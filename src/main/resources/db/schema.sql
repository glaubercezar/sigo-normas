CREATE TABLE IF NOT EXISTS `norms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(80) NULL,
  `title` VARCHAR(200) NULL,
  `committee` VARCHAR(80) NULL,
  `publication_date` DATE NULL,
  `status` VARCHAR(10) NULL,
  `link` VARCHAR(200) NULL,
  `description` TINYTEXT NULL,
  `area_name` VARCHAR(80) NULL,
  `area_department` INT NULL,
  PRIMARY KEY (`id`));
