-- 주문 테이블 생성
CREATE TABLE `spring_batch`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_item` VARCHAR(45) NULL,
  `price` INT NULL,
  `order_date` DATE NULL,
  PRIMARY KEY (`id`))
  ;

-- 정산 테이블 생성
CREATE TABLE `spring_batch`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_item` VARCHAR(45) NULL,
  `price` INT NULL,
  `order_date` DATE NULL,
  `account_date` DATE NULL,
  PRIMARY KEY (`id`))
;

INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('카카오 선물', 15000, '2022-03-01');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('배달주문', 18000, '2022-03-01');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('교보문고', 14000, '2022-03-02');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('아이스크림', 3800, '2022-03-03');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('치킨', 21000, '2022-03-04');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('커피', 4000, '2022-03-04');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('교보문고', 13800, '2022-03-05');
INSERT INTO spring_batch.orders(`order_item`, `price`, `order_date`) values ('카카오 선물', 5500, '2022-03-06');

select *
from spring_batch.orders
;

select *
from spring_batch.accounts
;