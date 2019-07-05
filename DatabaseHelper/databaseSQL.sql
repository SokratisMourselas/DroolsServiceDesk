-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for springdrools
DROP DATABASE IF EXISTS `springdrools`;
CREATE DATABASE IF NOT EXISTS `springdrools` /*!40100 DEFAULT CHARACTER SET ascii */;
USE `springdrools`;

-- Dumping structure for table springdrools.comment
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(400) NOT NULL DEFAULT '0',
  `requestId` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_comment_request` (`requestId`),
  CONSTRAINT `FK_comment_request` FOREIGN KEY (`requestId`) REFERENCES `request` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=ascii;

-- Dumping data for table springdrools.comment: ~1 rows (approximately)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `comment`, `requestId`) VALUES
	(1, 'This is a dummy comment message!', 1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- Dumping structure for table springdrools.request
DROP TABLE IF EXISTS `request`;
CREATE TABLE IF NOT EXISTS `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teamDirectedTo` varchar(50) DEFAULT 'Not Selected',
  `rule` varchar(5) DEFAULT NULL,
  `message` varchar(5000) DEFAULT 'Empty body...',
  `project` varchar(10) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_request_user` (`userId`),
  CONSTRAINT `FK_request_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=ascii;

-- Dumping data for table springdrools.request: ~3 rows (approximately)
DELETE FROM `request`;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` (`id`, `teamDirectedTo`, `rule`, `message`, `project`, `userId`) VALUES
	(1, 'DEV', 'E1837', 'Dummy message from a dummy user', 'AES 1.1', 3),
	(2, 'DEV', 'C0557', 'Another dummy message from a dummy user', 'NCTS 5.1', 3),
	(3, 'DEV', 'C0557', 'Another dummy message from a dummy user', 'NCTS 5.1', 3);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;

-- Dumping structure for table springdrools.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '0',
  `password` varchar(50) DEFAULT '0',
  `email` varchar(50) DEFAULT 'not provided',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=ascii;

-- Dumping data for table springdrools.user: ~0 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES
	(3, 'Sokratis MOURSELAS', 'ExamplePassword', 'example@springMVC.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

DROP TABLE IF EXISTS `comment_user`;
CREATE TABLE IF NOT EXISTS `comment_user`(
	`commentId` int(11) NOT NULL,
	`userId` int(11) NOT NULL,
	PRIMARY KEY(`commentId`, `userId`),
	
	CONSTRAINT `FK_comment_05`
	FOREIGN KEY (`commentId`)
	REFERENCES `comment` (`id`),
	
	CONSTRAINT `FK_user_05`
	FOREIGN KEY (`userId`)
	REFERENCES `user` (`id`)
);
