-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema habon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema habon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `habon` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `habon` ;

-- -----------------------------------------------------
-- Table `habon`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`User` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  `age` INT NOT NULL,
  `img` VARCHAR(255) NULL,
  `sport` VARCHAR(45) NULL,
  `team` VARCHAR(45) NULL,
  `player` VARCHAR(45) NULL,
  `point` BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`WorldCup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`WorldCup` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ele_category` VARCHAR(45) NOT NULL,
  `sub_category` VARCHAR(45) NULL,
  `league` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`Board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `worldcup_id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `writer` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `registDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_count` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `category_idx` (`worldcup_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `b_worldcup_id`
    FOREIGN KEY (`worldcup_id`)
    REFERENCES `habon`.`WorldCup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `b_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `habon`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`RequestBoard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`RequestBoard` (
  `id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`Comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `writer` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `registDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `board_id_idx` (`board_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `c_board_id`
    FOREIGN KEY (`board_id`)
    REFERENCES `habon`.`Board` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `c_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `habon`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`Report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Report` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`UserPick`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`UserPick` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`Reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Reply` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `comment_id` INT NOT NULL,
  `writer` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `registDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `comment_id_idx` (`comment_id` ASC) VISIBLE,
  INDEX `board_id_idx` (`board_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `r_board_id`
    FOREIGN KEY (`board_id`)
    REFERENCES `habon`.`Comment` (`board_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `r_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `habon`.`User` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `r_comment_id`
    FOREIGN KEY (`comment_id`)
    REFERENCES `habon`.`Comment` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habon`.`Elements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Elements` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `sub_category` VARCHAR(45) NULL,
  `league` TINYINT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL,
  `img` VARCHAR(255) NOT NULL,
  `information` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `habon`.`Rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`Rank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `worldcup_id` INT NOT NULL,
  `ele_id` INT NOT NULL,
  `point` INT DEFAULT 0,
  `league` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `worldcup_id_idx` (`worldcup_id` ASC) VISIBLE,
  INDEX `ele_id_idx` (`ele_id` ASC) VISIBLE,
  UNIQUE INDEX `unique_worldcup_ele` (`worldcup_id`, `ele_id`),
  CONSTRAINT `rank_worldcup_id`
    FOREIGN KEY (`worldcup_id`)
    REFERENCES `habon`.`WorldCup` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rank_ele_id`
    FOREIGN KEY (`ele_id`)
    REFERENCES `habon`.`Elements` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

# 참여 횟수 제한
CREATE TABLE IF NOT EXISTS `Participation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `worldcup_id` INT NOT NULL,
  `participation_count` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_worldcup_unique` (`user_id`, `worldcup_id`),
  FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  FOREIGN KEY (`worldcup_id`) REFERENCES `WorldCup` (`id`)
) ENGINE = InnoDB;


#추천수 한번만
CREATE TABLE IF NOT EXISTS `Recommendation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `content_type` ENUM('board', 'comment', 'reply') NOT NULL,
  `content_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_content_unique` (`user_id`, `content_type`, `content_id`),
  FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE = InnoDB;




USE `habon` ;

-- -----------------------------------------------------
-- Placeholder table for view `habon`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `habon`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `habon`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habon`.`view1`;
USE `habon`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;