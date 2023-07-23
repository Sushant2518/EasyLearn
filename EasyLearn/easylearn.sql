-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: easylearn
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseID` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) DEFAULT NULL,
  `courseStatus` enum('ACTIVE','DELETED') DEFAULT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'SB101','ACTIVE'),(2,'DSA351','ACTIVE'),(3,'SB201','ACTIVE'),(4,'DSA401','ACTIVE'),(5,'MAC101','ACTIVE'),(6,'MAC201','DELETED');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_assignments`
--

DROP TABLE IF EXISTS `course_assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_assignments` (
  `Course_courseID` int NOT NULL,
  `assignmentID` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endAt` date DEFAULT NULL,
  `givenAt` date DEFAULT NULL,
  `isCompleted` enum('COMPLETED','PENDING') DEFAULT NULL,
  `is_deleted` enum('ACTIVE','DELETED') DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  UNIQUE KEY `UK_f82vfiincldi2ojllgw413sps` (`assignmentID`),
  KEY `FKa0a5ew083m6ajfvioq89jfx36` (`Course_courseID`),
  CONSTRAINT `FKa0a5ew083m6ajfvioq89jfx36` FOREIGN KEY (`Course_courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_assignments`
--

LOCK TABLES `course_assignments` WRITE;
/*!40000 ALTER TABLE `course_assignments` DISABLE KEYS */;
INSERT INTO `course_assignments` VALUES (1,597266015,'generic in java','2023-08-01','2023-07-23','COMPLETED','ACTIVE','SB101 DAY1'),(2,619763105,'all about stack','2023-08-02','2023-07-23','PENDING','ACTIVE','DSA day2 assignment'),(5,913263503,'interview rediness ','2023-08-02','2023-07-23','PENDING','ACTIVE','interview rediness');
/*!40000 ALTER TABLE `course_assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_lectures`
--

DROP TABLE IF EXISTS `course_lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_lectures` (
  `Course_courseID` int NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `isWatched` enum('COMPLETED','PENDING') DEFAULT NULL,
  `is_deleted` enum('ACTIVE','DELETED') DEFAULT NULL,
  `lectureId` bigint NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `uplodedAt` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  UNIQUE KEY `UK_3hi1o9lc1m0jdxccy7nop07kk` (`lectureId`),
  KEY `FK9125rk38m250nkapxo101nr5k` (`Course_courseID`),
  CONSTRAINT `FK9125rk38m250nkapxo101nr5k` FOREIGN KEY (`Course_courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_lectures`
--

LOCK TABLES `course_lectures` WRITE;
/*!40000 ALTER TABLE `course_lectures` DISABLE KEYS */;
INSERT INTO `course_lectures` VALUES (5,'interview rediness','PENDING','ACTIVE',754788448,'interview rideness','2023-07-23','https://course.masaischool.com/dashboard'),(1,'all about ddl,dml,drl quries','PENDING','ACTIVE',793464052,'SQL introduction','2023-07-23','https://course.masaischool.com/dashboard'),(2,'push and pop','PENDING','ACTIVE',942307345,'Stack','2023-07-23','https://course.masaischool.com/dashboard');
/*!40000 ALTER TABLE `course_lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_quizzes`
--

DROP TABLE IF EXISTS `course_quizzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_quizzes` (
  `Course_courseID` int NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `endAt` date DEFAULT NULL,
  `givenAt` date DEFAULT NULL,
  `isCompleted` enum('COMPLETED','PENDING') DEFAULT NULL,
  `is_deleted` enum('ACTIVE','DELETED') DEFAULT NULL,
  `quizId` bigint NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  UNIQUE KEY `UK_axqovbv7syqmbkvnp5di82r2f` (`quizId`),
  KEY `FKnmgjw0kr1n6h2jgdp6tl3wdor` (`Course_courseID`),
  CONSTRAINT `FKnmgjw0kr1n6h2jgdp6tl3wdor` FOREIGN KEY (`Course_courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_quizzes`
--

LOCK TABLES `course_quizzes` WRITE;
/*!40000 ALTER TABLE `course_quizzes` DISABLE KEYS */;
INSERT INTO `course_quizzes` VALUES (5,'personal development','2023-08-03','2023-07-23','PENDING','ACTIVE',181658862,'interview redinesss'),(2,'all about 2d matrix ','2023-07-28','2023-07-23','PENDING','ACTIVE',656376272,'DSA351 Daily quiz'),(1,'all about generic','2023-07-24','2023-07-23','PENDING','ACTIVE',942836666,'SB101 day1 quiz');
/*!40000 ALTER TABLE `course_quizzes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_status` enum('ACTIVE','DELETED') NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_20ykra0dktqrotgxyy0yapfjo` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'ACTIVE','karan','1234','karan'),(2,'ACTIVE','omkar','1234','omkar'),(3,'ACTIVE','abhay','1234','abhay');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_status` enum('ACTIVE','DELETED') NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bx5vwmhlct693d8ihgpsc1c5` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'ACTIVE','Sushant','1234','sushant'),(2,'ACTIVE','rahul','1234','rahul'),(3,'ACTIVE','amar','1234','amar');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `students_id` int NOT NULL,
  `courses_courseID` int NOT NULL,
  PRIMARY KEY (`students_id`,`courses_courseID`),
  KEY `FKtg49hbcw1hm8l5v6kjusyhgc` (`courses_courseID`),
  CONSTRAINT `FKemqred2obsjrlmip5cei2g6qk` FOREIGN KEY (`students_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKtg49hbcw1hm8l5v6kjusyhgc` FOREIGN KEY (`courses_courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-23 19:44:35
