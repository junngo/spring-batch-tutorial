package com.example.SpringBatchTutorial.job.MultipleStep;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * desc: 다중 step을 사용하기 및 step to step 데이터 전달
 * run param: --job.name=multipleStepJob
 */
@Configuration
@RequiredArgsConstructor
public class MultipleStepJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job multipleStepJob(Step multipleStep1, Step multipleStep2, Step multipleStep3) {
        return jobBuilderFactory.get("multipleStepJob")
                .incrementer(new RunIdIncrementer())
                .start(multipleStep1)
                .next(multipleStep2)
                .next(multipleStep3)
                .build();
    }

    @JobScope
    @Bean
    public Step multipleStep1() {
        return stepBuilderFactory.get("multipleStep1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step1");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @JobScope
    @Bean
    public Step multipleStep2() {
        return stepBuilderFactory.get("multipleStep2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step2");

                    ExecutionContext executionContext = chunkContext
                            .getStepContext()
                            .getStepExecution()
                            .getJobExecution()
                            .getExecutionContext();

                    executionContext.put("someKey", "hello!!");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @JobScope
    @Bean
    public Step multipleStep3() {
        return stepBuilderFactory.get("multipleStep3")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step3");

                    ExecutionContext executionContext = chunkContext
                            .getStepContext()
                            .getStepExecution()
                            .getJobExecution()
                            .getExecutionContext();

                    System.out.println(executionContext.get("someKey"));

                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
