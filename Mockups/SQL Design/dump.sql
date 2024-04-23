-- MySQL dump 10.13  Distrib 8.3.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fit_app
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `height_records`
--

DROP TABLE IF EXISTS `height_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `height_records` (
  `entryId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `height` int NOT NULL COMMENT 'As cm',
  `entry_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`entryId`),
  KEY `Userheight_fk` (`userId`),
  KEY `height_ix` (`height`),
  CONSTRAINT `Userheight_fk` FOREIGN KEY (`userId`) REFERENCES `user_profiles` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `height_records`
--

LOCK TABLES `height_records` WRITE;
/*!40000 ALTER TABLE `height_records` DISABLE KEYS */;
INSERT INTO `height_records` VALUES (1,1,111,'2024-02-23 18:09:40'),(2,1,123,'2024-02-23 18:09:40'),(3,2,99,'2024-02-23 18:09:40');
/*!40000 ALTER TABLE `height_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hip_records`
--

DROP TABLE IF EXISTS `hip_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hip_records` (
  `entryId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `hip` int NOT NULL COMMENT 'As cm',
  `entry_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`entryId`),
  KEY `Userhip_fk` (`userId`),
  KEY `hip_ix` (`hip`),
  CONSTRAINT `Userhip_fk` FOREIGN KEY (`userId`) REFERENCES `user_profiles` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hip_records`
--

LOCK TABLES `hip_records` WRITE;
/*!40000 ALTER TABLE `hip_records` DISABLE KEYS */;
INSERT INTO `hip_records` VALUES (1,1,111,'2024-02-23 18:09:40'),(2,1,123,'2024-02-23 18:09:40'),(3,2,99,'2024-02-23 18:09:40');
/*!40000 ALTER TABLE `hip_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profiles`
--

DROP TABLE IF EXISTS `user_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profiles` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(75) NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `activity_level` varchar(10) DEFAULT NULL,
  `entry_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  KEY `useEmail_ix` (`userEmail`),
  KEY `userFirstName_ix` (`firstName`),
  KEY `userLastName_ix` (`lastName`),
  KEY `userGender_ix` (`gender`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profiles`
--

LOCK TABLES `user_profiles` WRITE;
/*!40000 ALTER TABLE `user_profiles` DISABLE KEYS */;
INSERT INTO `user_profiles` VALUES (1,'oscarJ@email.com','Oscar','Johnson','male','2004-01-27',NULL,'2024-02-23 18:09:40'),(2,'joecoy@email.com','Joe','Coyne','male','1994-03-07','low','2024-02-23 18:09:40'),(3,'frensen@email.com','Fred','Hensen','male','2001-09-25',NULL,'2024-02-23 18:09:40'),(4,'barry@email.com','Barney','Curry','male','1986-10-16',NULL,'2024-02-23 18:09:40'),(5,'maren@email.com','Karen','Mack','female','1999-08-14',NULL,'2024-02-23 18:09:40'),(6,'cleandine@email.com','Dianne','Klein','female','2000-01-02',NULL,'2024-02-23 18:09:40'),(7,'tilldawn@email.com','Dawn','Tillman','male','1990-06-05',NULL,'2024-02-23 18:09:40'),(8,'filler@email.com',NULL,NULL,NULL,NULL,NULL,'2024-02-23 18:09:40'),(9,'test@email.com',NULL,NULL,NULL,NULL,NULL,'2024-02-23 18:09:40');
/*!40000 ALTER TABLE `user_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waist_records`
--

DROP TABLE IF EXISTS `waist_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waist_records` (
  `entryId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `waist` int NOT NULL COMMENT 'As cm',
  `entry_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`entryId`),
  KEY `Userwaist_fk` (`userId`),
  KEY `waist_ix` (`waist`),
  CONSTRAINT `Userwaist_fk` FOREIGN KEY (`userId`) REFERENCES `user_profiles` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waist_records`
--

LOCK TABLES `waist_records` WRITE;
/*!40000 ALTER TABLE `waist_records` DISABLE KEYS */;
INSERT INTO `waist_records` VALUES (1,1,111,'2024-02-23 18:09:40'),(2,1,123,'2024-02-23 18:09:40'),(3,2,99,'2024-02-23 18:09:40');
/*!40000 ALTER TABLE `waist_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weight_records`
--

DROP TABLE IF EXISTS `weight_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weight_records` (
  `entryId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `weight` int NOT NULL COMMENT 'As kg',
  `entry_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`entryId`),
  KEY `Userweight_fk` (`userId`),
  KEY `weight_ix` (`weight`),
  CONSTRAINT `Userweight_fk` FOREIGN KEY (`userId`) REFERENCES `user_profiles` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight_records`
--

LOCK TABLES `weight_records` WRITE;
/*!40000 ALTER TABLE `weight_records` DISABLE KEYS */;
INSERT INTO `weight_records` VALUES (1,1,111,'2024-02-23 18:09:40'),(2,1,123,'2024-02-23 18:09:40'),(3,2,99,'2024-02-23 18:09:40');
/*!40000 ALTER TABLE `weight_records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-23 12:10:00
