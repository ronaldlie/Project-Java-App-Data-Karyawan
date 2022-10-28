-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: karyawan
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `dept_id` int NOT NULL,
  `dept_name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (10,'Administration'),(20,'Marketing'),(50,'Shipping'),(60,'IT'),(80,'Sales');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `nik` int NOT NULL,
  `dob` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `religion` varchar(45) NOT NULL,
  `job_id` varchar(45) NOT NULL,
  `dept_id` int NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `job_id_idx` (`job_id`),
  KEY `dept_id_idx` (`dept_id`),
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `job_id` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Ronald Lie',825200011,'06 January 2003','Male','Buddha','SA_MAN',50),(2,'Lisa Magdalena',825200016,'15 September 2002','Female','Buddha','AC_ACCOUNT',20),(3,'Dedoy',11234321,'18 August 2002','Female','Buddha','AC_MGR',60),(4,'Aurelia',825200132,'26 May 1999','Male','Katolik','AC_MGR',10),(5,'Max Max',825200068,'21 October 1996','Male','Buddha','AD_ASTT',50),(6,'Carolina',825200123,'09 November 2000','Female','Kristen','AD_ASTT',50),(7,'Beni beni',825203214,'09 March 1997','Male','Hindu','AC_ACCOUNT',10),(8,'Desi Siti',825201389,'22 October 2001','Female','Konghucu','SA_REP',50),(9,'Ryond Theixar',825289713,'27 January 2001','Male','Islam','AC_MGR',50),(10,'Jovan Bildy',825200983,'07 March 2001','Male','Katolik','SA_MAN',10),(11,'William JB',825219823,'17 January 2003','Male','Buddha','AC_ACCOUNT',20),(12,'Maulid Ahmad',825209134,'16 September 1996','Male','Islam','SA_REP',60),(13,'Kelvin Kelvin',825200015,'07 August 2003','Male','Kristen','AC_MGR',20),(14,'Zulfikri Duni',825200134,'20 May 1999','Male','Hindu','SA_REP',60),(15,'Jonathan Adelwyn',825200145,'12 December 2021','Male','Hindu','SA_REP',10);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `job_id` varchar(45) NOT NULL,
  `job_title` varchar(45) NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES ('AC_ACCOUNT','Public Account'),('AC_MGR','Accounting Manager'),('AD_ASTT','Administration Assistant'),('SA_MAN','Sales Manager'),('SA_REP','Sales Representative');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `salaryNo` int NOT NULL AUTO_INCREMENT,
  `salary` varchar(45) NOT NULL,
  `job_id` varchar(45) NOT NULL,
  `dept_id` int NOT NULL,
  PRIMARY KEY (`salaryNo`),
  KEY `job_id_idx` (`job_id`),
  KEY `dept_id_salary_idx` (`dept_id`),
  CONSTRAINT `dept_id_salary` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `job_id_salary` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,'2300','AC_ACCOUNT',10),(2,'2500','AC_ACCOUNT',20),(3,'2700','AC_ACCOUNT',50),(4,'2400','AC_ACCOUNT',60),(5,'2100','AC_ACCOUNT',80),(6,'3200','AC_MGR',10),(7,'3500','AC_MGR',20),(8,'3900','AC_MGR',50),(9,'3100','AC_MGR',60),(10,'3000','AC_MGR',80),(11,'3300','AD_ASTT',10),(12,'3600','AD_ASTT',20),(13,'3400','AD_ASTT',50),(14,'3800','AD_ASTT',60),(15,'3700','AD_ASTT',80),(16,'4000','SA_MAN',10),(17,'4200','SA_MAN',20),(18,'4500','SA_MAN',50),(19,'4300','SA_MAN',60),(20,'4100','SA_MAN',80),(21,'5000','SA_REP',10),(22,'1500','SA_REP',20),(23,'1700','SA_REP',50),(24,'1300','SA_REP',60),(25,'1800','SA_REP',80);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 22:12:14
