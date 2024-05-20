CREATE DATABASE  IF NOT EXISTS `habon` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `habon`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: habon
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `worldcup_id` int NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `writer` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `registDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_count` int NOT NULL DEFAULT '0',
  `like_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `category_idx` (`worldcup_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `b_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `b_worldcup_id` FOREIGN KEY (`worldcup_id`) REFERENCES `worldcup` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (2,'ssafy',1,'ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ','된장찌개','ㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ','2024-05-20 09:14:45',284,1),(3,'ssafy',1,'rqrq','된장찌개','rqrqrqr','2024-05-20 11:29:48',4,1),(4,'ssafy',1,'qweqwe','된장찌개','qwewqewqe','2024-05-20 11:31:09',1,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `board_id` int NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `writer` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `registDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `like_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `board_id_idx` (`board_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `c_board_id_fk` FOREIGN KEY (`board_id`) REFERENCES `board` (`id`) ON DELETE CASCADE,
  CONSTRAINT `c_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (4,2,'ssafy','된장찌개','aqqaqaqeeee','2024-05-20 09:26:32',1),(5,2,'ssafy','된장찌개','weweweewewe','2024-05-20 09:26:40',0);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elements`
--

DROP TABLE IF EXISTS `elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `sub_category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `league` tinyint NOT NULL DEFAULT '0',
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `information` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'선수','축구',1,'Lionel Messi','messi.jpg','Argentine professional footballer.'),(2,'선수','축구',1,'Cristiano Ronaldo','ronaldo.jpg','Portuguese professional footballer.'),(3,'선수','농구',1,'LeBron James','lebron.jpg','American professional basketball player.'),(4,'선수','농구',1,'Stephen Curry','curry.jpg','American professional basketball player.'),(5,'선수','크리켓',1,'Virat Kohli','kohli.jpg','Indian professional cricketer.'),(6,'선수','크리켓',1,'Joe Root','root.jpg','English professional cricketer.'),(7,'팀','축구',1,'FC Barcelona','barcelona.jpg','Spanish professional football club.'),(8,'팀','축구',1,'Real Madrid','madrid.jpg','Spanish professional football club.'),(9,'팀','농구',1,'Los Angeles Lakers','lakers.jpg','American professional basketball team.'),(10,'팀','농구',1,'Golden State Warriors','warriors.jpg','American professional basketball team.'),(11,'스포츠','올림픽',1,'Swimming','swimming.jpg','Competitive swimming sport.'),(12,'스포츠','올림픽',1,'Athletics','athletics.jpg','Track and field athletics.'),(13,'스포츠','단체',1,'Football','football.jpg','Team sport played with a spherical ball.'),(14,'스포츠','단체',1,'Basketball','basketball.jpg','Team sport played with a round ball.'),(15,'축구','선수',1,'Lionel Messi','messi.jpg','Argentine professional footballer.'),(16,'축구','선수',1,'Cristiano Ronaldo','ronaldo.jpg','Portuguese professional footballer.'),(17,'농구','선수',1,'LeBron James','lebron.jpg','American professional basketball player.'),(18,'농구','선수',1,'Stephen Curry','curry.jpg','American professional basketball player.'),(19,'크리켓','선수',1,'Virat Kohli','kohli.jpg','Indian professional cricketer.'),(20,'크리켓','선수',1,'Joe Root','root.jpg','English professional cricketer.'),(21,'축구','팀',1,'FC Barcelona','barcelona.jpg','Spanish professional football club.'),(22,'축구','팀',1,'Real Madrid','madrid.jpg','Spanish professional football club.'),(23,'농구','팀',1,'Los Angeles Lakers','lakers.jpg','American professional basketball team.'),(24,'농구','팀',1,'Golden State Warriors','warriors.jpg','American professional basketball team.'),(25,'올림픽','스포츠',1,'Swimming','swimming.jpg','Competitive swimming sport.'),(26,'올림픽','스포츠',1,'Athletics','athletics.jpg','Track and field athletics.'),(27,'단체','스포츠',1,'Football','football.jpg','Team sport played with a spherical ball.'),(28,'단체','스포츠',1,'Basketball','basketball.jpg','Team sport played with a round ball.'),(29,'축구','선수',1,'Kylian Mbappe','mbappe.jpg','French professional footballer.'),(30,'축구','선수',1,'Neymar Jr','neymar.jpg','Brazilian professional footballer.'),(31,'축구','선수',1,'Zlatan Ibrahimovic','zlatan.jpg','Swedish professional footballer.'),(32,'축구','선수',1,'Luka Modric','modric.jpg','Croatian professional footballer.'),(33,'축구','선수',1,'Kevin De Bruyne','debruyne.jpg','Belgian professional footballer.'),(34,'농구','선수',1,'Kevin Durant','durant.jpg','American professional basketball player.'),(35,'농구','선수',1,'Kawhi Leonard','leonard.jpg','American professional basketball player.'),(36,'농구','선수',1,'James Harden','harden.jpg','American professional basketball player.'),(37,'농구','선수',1,'Anthony Davis','davis.jpg','American professional basketball player.'),(38,'크리켓','선수',1,'Steve Smith','smith.jpg','Australian professional cricketer.'),(39,'크리켓','선수',1,'Kane Williamson','williamson.jpg','New Zealand professional cricketer.'),(40,'크리켓','선수',1,'AB de Villiers','devilliers.jpg','South African professional cricketer.'),(41,'축구','팀',1,'Manchester United','manutd.jpg','English professional football club.'),(42,'축구','팀',1,'Liverpool FC','liverpool.jpg','English professional football club.'),(43,'농구','팀',1,'Boston Celtics','celtics.jpg','American professional basketball team.'),(44,'농구','팀',1,'Chicago Bulls','bulls.jpg','American professional basketball team.'),(45,'올림픽','스포츠',1,'Gymnastics','gymnastics.jpg','Competitive gymnastics sport.'),(46,'올림픽','스포츠',1,'Weightlifting','weightlifting.jpg','Competitive weightlifting sport.'),(47,'단체','스포츠',1,'Rugby','rugby.jpg','Team sport played with an oval ball.'),(48,'단체','스포츠',1,'Volleyball','volleyball.jpg','Team sport played with a round ball.'),(49,'개인','스포츠',1,'Tennis','tennis.jpg','Individual sport played with a racket and ball.'),(50,'개인','스포츠',1,'Badminton','badminton.jpg','Individual sport played with a shuttlecock and racket.'),(51,'개인','스포츠',1,'Boxing','boxing.jpg','Combat sport with two competitors.'),(52,'개인','스포츠',1,'MMA','mma.jpg','Mixed martial arts combat sport.'),(53,'겨울 스포츠','선수',1,'Shaun White','shaunwhite.jpg','American professional snowboarder.'),(54,'겨울 스포츠','선수',1,'Chloe Kim','chloekim.jpg','American professional snowboarder.'),(55,'겨울 스포츠','팀',1,'Team Canada Hockey','canadahockey.jpg','Canadian professional ice hockey team.'),(56,'겨울 스포츠','팀',1,'Team USA Hockey','usahockey.jpg','American professional ice hockey team.'),(57,'e스포츠','선수',1,'Faker','faker.jpg','South Korean professional esports player.'),(58,'e스포츠','선수',1,'s1mple','s1mple.jpg','Ukrainian professional esports player.');
/*!40000 ALTER TABLE `elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participation`
--

DROP TABLE IF EXISTS `participation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `worldcup_id` int NOT NULL,
  `participation_count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_worldcup_unique` (`user_id`,`worldcup_id`),
  KEY `worldcup_id` (`worldcup_id`),
  CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`worldcup_id`) REFERENCES `worldcup` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participation`
--

LOCK TABLES `participation` WRITE;
/*!40000 ALTER TABLE `participation` DISABLE KEYS */;
INSERT INTO `participation` VALUES (1,'string',1,-100),(11,'string',2,-100),(13,'string',4,4),(15,'saffy',1,-38),(16,'ssafy',1,-42),(17,'ssafy',4,-95),(18,'ssafy',6,-97),(21,'ssafy',2,-89),(23,'saffy',2,-989),(25,'saffy',6,1),(26,'saffy',4,2);
/*!40000 ALTER TABLE `participation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rank`
--

DROP TABLE IF EXISTS `rank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worldcup_id` int NOT NULL,
  `ele_id` int NOT NULL,
  `point` int DEFAULT '0',
  `league` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_worldcup_ele` (`worldcup_id`,`ele_id`),
  KEY `worldcup_id_idx` (`worldcup_id`),
  KEY `ele_id_idx` (`ele_id`),
  CONSTRAINT `rank_ele_id` FOREIGN KEY (`ele_id`) REFERENCES `elements` (`id`),
  CONSTRAINT `rank_worldcup_id` FOREIGN KEY (`worldcup_id`) REFERENCES `worldcup` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` VALUES (125,1,33,29,0),(126,1,54,27,0),(127,1,32,21,0),(128,1,38,20,0),(129,1,29,18,0),(130,1,15,31,0),(131,1,18,15,0),(132,1,53,12,0),(133,1,19,19,0),(134,1,36,19,0),(135,1,37,21,0),(136,1,34,13,0),(137,1,58,16,0),(138,1,20,24,0),(139,1,57,22,0),(140,1,40,16,0),(141,1,16,30,0),(142,1,30,15,0),(143,1,17,13,0),(144,1,39,19,0),(145,1,31,16,0),(146,1,35,22,0),(147,2,33,7,0),(148,2,39,1,0),(149,2,38,2,0),(150,2,31,3,0),(151,2,34,4,0),(152,2,30,1,0),(153,2,17,6,0),(154,2,54,1,0),(155,2,53,2,0),(156,2,19,1,0),(157,2,18,2,0),(158,2,37,1,0),(161,6,28,1,0),(162,6,46,2,0),(163,4,42,4,0),(168,4,43,2,0),(169,4,56,2,0),(173,4,22,2,0),(174,4,21,1,0),(175,2,32,1,0),(176,2,29,2,0),(177,2,36,1,0),(178,2,58,4,0);
/*!40000 ALTER TABLE `rank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendation`
--

DROP TABLE IF EXISTS `recommendation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content_type` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_content_unique` (`user_id`,`content_type`,`content_id`),
  CONSTRAINT `recommendation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation`
--

LOCK TABLES `recommendation` WRITE;
/*!40000 ALTER TABLE `recommendation` DISABLE KEYS */;
INSERT INTO `recommendation` VALUES (44,'ssafy','board',2),(39,'ssafy','board',3),(42,'ssafy','comment',4);
/*!40000 ALTER TABLE `recommendation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `board_id` int NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `comment_id` int NOT NULL,
  `writer` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `registDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `comment_id_idx` (`comment_id`),
  KEY `board_id_idx` (`board_id`),
  CONSTRAINT `r_comment_id_fk` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE,
  CONSTRAINT `r_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestboard`
--

DROP TABLE IF EXISTS `requestboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requestboard` (
  `id` int NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestboard`
--

LOCK TABLES `requestboard` WRITE;
/*!40000 ALTER TABLE `requestboard` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `age` int NOT NULL,
  `img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `sport` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `team` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `player` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `point` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('saffy','1234','박예본','goodyeib@nave.rcom','슈퍼~~~레코드',24,'','축구','맨유','페로난도 토레스',0),('ssafy','1234','유리카츠','fojeiui@fiae.com','된장찌개',23,NULL,'q','ww','er',0),('string','string','이름이다잉','string.com','테이트중이다잉',26,'','야구','맹구','스털링',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpick`
--

DROP TABLE IF EXISTS `userpick`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userpick` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userpick`
--

LOCK TABLES `userpick` WRITE;
/*!40000 ALTER TABLE `userpick` DISABLE KEYS */;
/*!40000 ALTER TABLE `userpick` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worldcup`
--

DROP TABLE IF EXISTS `worldcup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worldcup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ele_category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `sub_category` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `league` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worldcup`
--

LOCK TABLES `worldcup` WRITE;
/*!40000 ALTER TABLE `worldcup` DISABLE KEYS */;
INSERT INTO `worldcup` VALUES (1,'선수','가장 잘하는 선수는?',1),(2,'선수','외모가 가장 멋있는 선수는?',1),(4,'팀','가장 강력한 팀은?',1),(6,'스포츠','가장 힘든 스포츠는?',1);
/*!40000 ALTER TABLE `worldcup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21  8:53:11
