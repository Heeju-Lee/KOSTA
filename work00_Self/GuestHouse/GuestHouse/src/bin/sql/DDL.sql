-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema guesthouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema guesthouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `guesthouse` DEFAULT CHARACTER SET utf8 ;
USE `guesthouse` ;

-- -----------------------------------------------------
-- Table `guesthouse`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guesthouse`.`Customer` (
  `id` VARCHAR(10) NOT NULL,
  `pass` VARCHAR(15) NULL,
  `name` VARCHAR(10) NULL,
  `phone` VARCHAR(15) NULL,
  PRIMARY KEY (`id`)
  );


-- -----------------------------------------------------
-- Table `guesthouse`.`GuestHouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guesthouse`.`GuestHouse` (
  `id` VARCHAR(10) NOT NULL,
  `name` VARCHAR(15) NULL,
  `address` VARCHAR(45) NULL,
  `room_num` INT NOT NULL,
  `room_price` INT NULL,
  `capacity` INT NULL,
  PRIMARY KEY (`id`, `room_num`));

-- -----------------------------------------------------
-- Table `guesthouse`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guesthouse`.`Review` (
  `content` VARCHAR(255) NULL,
  `rating` INT NULL,
  `Customer_id` VARCHAR(10) NOT NULL,
  `GuestHouse_id` VARCHAR(10) NOT NULL,
  INDEX `fk_Review_Customer1_idx` (`Customer_id` ASC) VISIBLE,
  INDEX `fk_Review_GuestHouse1_idx` (`GuestHouse_id` ASC) VISIBLE,
  CONSTRAINT `fk_Review_Customer1`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `guesthouse`.`Customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Review_GuestHouse1`
    FOREIGN KEY (`GuestHouse_id`)
    REFERENCES `guesthouse`.`GuestHouse` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `guesthouse`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guesthouse`.`Reservation` (
  `id` INT AUTO_INCREMENT,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `total_price` INT NULL,
  `Customer_id` VARCHAR(10) NOT NULL,
  `GuestHouse_id` VARCHAR(10) NOT NULL,
  `GuestHouse_room_num` int NOT NULL,

  PRIMARY KEY (`id`),
  INDEX `fk_Reservation_Customer_idx` (`Customer_id` ASC) VISIBLE,
  INDEX `fk_Reservation_GuestHouse1_idx` (`GuestHouse_id` ASC) VISIBLE,
  INDEX `fk_Reservation_GuestHouse2_idx` (`GuestHouse_room_num` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Customer`
    FOREIGN KEY (`Customer_id`)
    REFERENCES `guesthouse`.`Customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reservation_GuestHouse1`
    FOREIGN KEY (`GuestHouse_id`,`GuestHouse_room_num`)
    REFERENCES `guesthouse`.`GuestHouse` (`id`,`room_num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


