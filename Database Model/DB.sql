-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Tecmis_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Tecmis_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Tecmis_DB` DEFAULT CHARACTER SET utf8 ;
USE `Tecmis_DB` ;

-- -----------------------------------------------------
-- Table `Tecmis_DB`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`department` (
  `department_id` VARCHAR(20) NOT NULL,
  `d_name` VARCHAR(45) NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`student` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL,
  `fname` VARCHAR(45) NULL,
  `mname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `sex` VARCHAR(10) NULL,
  `phone_no` INT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `image_path` VARCHAR(1000) NULL,
  `level` VARCHAR(45) NULL,
  `department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_id`),
  INDEX `fk_student_department_idx` (`department_id` ASC) ,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `Tecmis_DB`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`lecturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`lecturer` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL,
  `fname` VARCHAR(45) NULL,
  `mname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `sex` VARCHAR(10) NULL,
  `phone_no` INT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `image_path` VARCHAR(1000) NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_department_id`),
  INDEX `fk_lecturer_department1_idx` (`department_department_id` ASC) ,
  CONSTRAINT `fk_lecturer_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `Tecmis_DB`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`technical_officer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`technical_officer` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL,
  `fname` VARCHAR(45) NULL,
  `mname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `sex` VARCHAR(10) NULL,
  `phone_no` INT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `image_path` VARCHAR(1000) NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `department_department_id`),
  INDEX `fk_technical_officer_department1_idx` (`department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_technical_officer_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `Tecmis_DB`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`admin` (
  `id` VARCHAR(20) NOT NULL,
  `nic` VARCHAR(45) NULL,
  `fname` VARCHAR(45) NULL,
  `mname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  `address` VARCHAR(45) NULL,
  `sex` VARCHAR(10) NULL,
  `phone_no` INT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `image_path` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`attendence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`attendence` (
  `attendence_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `time` DATETIME NULL,
  `course_id` VARCHAR(20) NULL,
  `lecturer_id` VARCHAR(20) NULL,
  `hour` INT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `student_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`attendence_id`, `student_id`, `student_department_department_id`),
  INDEX `fk_attendence_student1_idx` (`student_id` ASC, `student_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_attendence_student1`
    FOREIGN KEY (`student_id` , `student_department_department_id`)
    REFERENCES `Tecmis_DB`.`student` (`id` , `department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`medical`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`medical` (
  `medical_id` INT NOT NULL,
  `date` DATETIME NULL,
  `state` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `department_id` VARCHAR(20) NULL,
  `subject_code` VARCHAR(20) NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `student_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`medical_id`, `student_id`, `student_department_department_id`),
  INDEX `fk_medical_student1_idx` (`student_id` ASC, `student_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_medical_student1`
    FOREIGN KEY (`student_id` , `student_department_department_id`)
    REFERENCES `Tecmis_DB`.`student` (`id` , `department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`mark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`mark` (
  `mark_id` INT NOT NULL,
  `grade` VARCHAR(45) NULL,
  `level` VARCHAR(45) NULL,
  `assesment` INT NULL,
  `quiz` INT NULL,
  `course_id` INT NULL,
  `sgpa` DECIMAL(3,2) NULL,
  `cgpa` DECIMAL(3,2) NULL,
  `mid_term` INT NULL,
  `final_theory` INT NULL,
  `final_practicle` INT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `student_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`mark_id`, `student_id`, `student_department_department_id`),
  INDEX `fk_mark_student1_idx` (`student_id` ASC, `student_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_mark_student1`
    FOREIGN KEY (`student_id` , `student_department_department_id`)
    REFERENCES `Tecmis_DB`.`student` (`id` , `department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`course` (
  `course_id` VARCHAR(20) NOT NULL,
  `level` VARCHAR(45) NULL,
  `credit` INT NULL,
  `course_name` VARCHAR(45) NULL,
  `course_type` VARCHAR(45) NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`course_id`, `department_department_id`),
  INDEX `fk_course_department1_idx` (`department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `Tecmis_DB`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`lecture_matireal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`lecture_matireal` (
  `lecture_matireal_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `file_path` VARCHAR(1000) NULL,
  `course_id` VARCHAR(20) NOT NULL,
  `course_department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`lecture_matireal_id`, `course_id`, `course_department_department_id`),
  INDEX `fk_lecture_matireal_course1_idx` (`course_id` ASC, `course_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_matireal_course1`
    FOREIGN KEY (`course_id` , `course_department_department_id`)
    REFERENCES `Tecmis_DB`.`course` (`course_id` , `department_department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`notice` (
  `notice_id` INT NOT NULL,
  `file_path` VARCHAR(1000) NULL,
  `title` VARCHAR(45) NULL,
  `date_and_time` DATETIME NULL,
  `discripsion` VARCHAR(1000) NULL,
  PRIMARY KEY (`notice_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tecmis_DB`.`course_has_department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tecmis_DB`.`course_has_department` (
  `course_course_id` VARCHAR(20) NOT NULL,
  `course_department_department_id` VARCHAR(20) NOT NULL,
  `department_department_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`course_course_id`, `course_department_department_id`, `department_department_id`),
  INDEX `fk_course_has_department_department1_idx` (`department_department_id` ASC) VISIBLE,
  INDEX `fk_course_has_department_course1_idx` (`course_course_id` ASC, `course_department_department_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_has_department_course1`
    FOREIGN KEY (`course_course_id` , `course_department_department_id`)
    REFERENCES `Tecmis_DB`.`course` (`course_id` , `department_department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_department_department1`
    FOREIGN KEY (`department_department_id`)
    REFERENCES `Tecmis_DB`.`department` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
