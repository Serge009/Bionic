CREATE TABLE `deposits`.`deposits` (
  `deposits_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bank` VARCHAR(60) NULL,
  `id` VARCHAR(20) NULL,
  `type` INT(11) NULL,
  `start_date` DATE NULL,
  `duration` INT(11) NULL,
  `sum` DECIMAL(10,2) NULL,
  `rate` DECIMAL(10,2) NULL,
  PRIMARY KEY (`deposits_id`),
  UNIQUE INDEX `deposits_id_UNIQUE` (`deposits_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


DELETE from deposits.deposits;
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (1, "Credit Swiss", "HB-1046/2012", 1, DATE("12.06.01"), 92, 10000.00, 12.0);
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (2, "Credit Swiss", "HB-1091/2012", 2, DATE("12.07.01"), 92, 10000.00, 12.0);
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (3, "Credit Leone", "185608", 2, DATE("12.05.09"), 15, 2500000.00, 24.0);
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (4, "Paribas Bank", "D8805-12", 1, DATE("12.08.11"), 370, 1000.00, 6.0);
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (5, "Chase Manhattan Bank", "UL2989/14", 2, DATE("11.10.01"), 182, 1000000.00, 5.3);
INSERT INTO deposits.deposits(deposits_id, bank, id, type, start_date, duration, sum, rate) VALUES (6, "Raiffeisen Bank", "20120512618", 1, DATE("12.05.11"), 270, 10000.00, 6.0);