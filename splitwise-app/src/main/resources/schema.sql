CREATE SCHEMA IF NOT EXISTS `splitwise` ;

CREATE TABLE IF NOT EXISTS `splitwise`.`USER` (
  `USER_ID` VARCHAR(25) NOT NULL,
  `NAME` VARCHAR(25) NOT NULL,
  `EMAIL_ID` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `EMAIL_ID_UNIQUE` (`EMAIL_ID` ASC) VISIBLE);


CREATE TABLE IF NOT EXISTS `splitwise`.`GROUP` (
  `GROUP_ID` VARCHAR(25) NOT NULL,
  `GROUP_NAME` VARCHAR(45) NULL,
  `USER_ID` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`GROUP_ID`),
  INDEX `USER_ID_FK_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `USER_ID_FK`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `splitwise`.`USER` (`USER_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `splitwise`.`EXPENSE` (
  `EXPENSE_ID` VARCHAR(25) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `EXPENSE_ON` DATETIME NOT NULL,
  PRIMARY KEY (`EXPENSE_ID`));

CREATE TABLE IF NOT EXISTS `splitwise`.`USER_EXPENSE` (
  `USER_EXPENSE_ID` VARCHAR(25) NOT NULL,
  `EXPENSE_ID` VARCHAR(25) NOT NULL,
  `USER_ID` VARCHAR(25) NOT NULL,
  `GROUP_ID` VARCHAR(25) NULL,
  `AMOUNT_PAID` DECIMAL(10,2) NOT NULL,
  `OWE_AMOUNT` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`USER_EXPENSE_ID`),
  INDEX `USER_EXPENSE_USER_ID_FK_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `USER_EXPENSE_GROUP_ID_FK_idx` (`GROUP_ID` ASC) VISIBLE,
  INDEX `USER_EXPENSE_EXPENSE_ID_FK_idx` (`EXPENSE_ID` ASC) VISIBLE,
  CONSTRAINT `USER_EXPENSE_USER_ID_FK`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `splitwise`.`USER` (`USER_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `USER_EXPENSE_GROUP_ID_FK`
    FOREIGN KEY (`GROUP_ID`)
    REFERENCES `splitwise`.`GROUP` (`GROUP_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `USER_EXPENSE_EXPENSE_ID_FK`
    FOREIGN KEY (`EXPENSE_ID`)
    REFERENCES `splitwise`.`EXPENSE` (`EXPENSE_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);