-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`members` (
  `id` VARCHAR(50) NOT NULL COMMENT '회원가입 시 작성하는 ID',
  `pw` VARCHAR(50) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(25) NOT NULL,
  `kind` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `category_idx` INT NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_category_category1_idx` (`category_idx` ASC) VISIBLE,
  CONSTRAINT `fk_category_category1`
    FOREIGN KEY (`category_idx`)
    REFERENCES `mydb`.`category` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`admins` (
  `id` VARCHAR(50) NOT NULL,
  `pw` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`questions` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `contents` VARCHAR(1000) NULL,
  `from_id` VARCHAR(50) NOT NULL,
  `to_id` VARCHAR(50) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `question_idx` INT NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_questions_questions1_idx` (`question_idx` ASC) VISIBLE,
  CONSTRAINT `fk_questions_questions1`
    FOREIGN KEY (`question_idx`)
    REFERENCES `mydb`.`questions` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`commissions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`commissions` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `contents` VARCHAR(1000) NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `member_id` VARCHAR(50) NOT NULL,
  `category_idx` INT NOT NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_commissions_members1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_commissions_category1_idx` (`category_idx` ASC) VISIBLE,
  CONSTRAINT `fk_commissions_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `mydb`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commissions_category1`
    FOREIGN KEY (`category_idx`)
    REFERENCES `mydb`.`category` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`talents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`talents` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `contents` VARCHAR(1000) NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `member_id` VARCHAR(50) NOT NULL,
  `category_idx` INT NOT NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_talents_members1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_talents_category1_idx` (`category_idx` ASC) VISIBLE,
  CONSTRAINT `fk_talents_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `mydb`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_talents_category1`
    FOREIGN KEY (`category_idx`)
    REFERENCES `mydb`.`category` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `register_date` DATETIME NOT NULL,
  `state` VARCHAR(10) NULL COMMENT '결제 + 추가결제 -> 대금 지불',
  `member_id` VARCHAR(50) NOT NULL,
  `commission_idx` INT NULL,
  `talent_idx` INT NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_orders_members1_idx` (`member_id` ASC) VISIBLE,
  INDEX `fk_orders_commissions1_idx` (`commission_idx` ASC) VISIBLE,
  INDEX `fk_orders_talents1_idx` (`talent_idx` ASC) VISIBLE,
  CONSTRAINT `fk_orders_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `mydb`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_commissions1`
    FOREIGN KEY (`commission_idx`)
    REFERENCES `mydb`.`commissions` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_talents1`
    FOREIGN KEY (`talent_idx`)
    REFERENCES `mydb`.`talents` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payments` (
  `order_idx` INT NOT NULL,
  `idx` INT NOT NULL,
  `pay_date` DATETIME NOT NULL,
  `purchaser_id` VARCHAR(50) NOT NULL COMMENT '소비자 id',
  `bank` VARCHAR(50) NOT NULL,
  `total_pay` INT NOT NULL,
  PRIMARY KEY (`order_idx`, `idx`),
  INDEX `fk_payments_orders1_idx` (`order_idx` ASC) VISIBLE,
  CONSTRAINT `fk_payments_orders1`
    FOREIGN KEY (`order_idx`)
    REFERENCES `mydb`.`orders` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ㅔ개`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ㅔ개` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`producers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`producers` (
  `member_id` VARCHAR(50) NOT NULL,
  `account` VARCHAR(50) NOT NULL,
  `bank` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`member_id`),
  CONSTRAINT `fk_producers_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `mydb`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`consumers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`consumers` (
  `member_id` VARCHAR(50) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`member_id`),
  CONSTRAINT `fk_consumers_members1`
    FOREIGN KEY (`member_id`)
    REFERENCES `mydb`.`members` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;

-- -----------------------------------------------------
-- Placeholder table for view `mydb`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `mydb`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`view1`;
USE `mydb`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
