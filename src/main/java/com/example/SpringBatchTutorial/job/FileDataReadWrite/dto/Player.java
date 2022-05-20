package com.example.SpringBatchTutorial.job.FileDataReadWrite.dto;

import lombok.Data;

@Data
public class Player{

    private String ID;
    private String lastName;
    private String firstName;
    private String position;
    private int birthYear;
    private int debutYear;
}
