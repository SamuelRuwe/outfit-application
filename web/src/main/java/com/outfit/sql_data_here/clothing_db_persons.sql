CREATE DATABASE  IF NOT EXISTS `clothing_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clothing_db`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clothing_db
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `salt` varchar(100) NOT NULL,
  `securepassword` varchar(100) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `zipcode` int(11) NOT NULL,
  `countrycode` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'ruwesam','gqKUT72kUSqwyq2GGmLnw8Y6evuPfA','ogRqck/PZCLsFlFWmVphSC9Q/VVjFQNicq4wSOqfJRY=','Sam','Ruwe','ruwesam@gmail.com',27502,'US'),(2,'sloanbrandon','EgINy18o8FxfC54CcLQYoGS62GY5KP','IkfGz2yTe1clDD+il9AMWpEzE+d3DUtQrccxYxEAgmM=','Brandon','Sloan','bsloan@gmail.com',27502,'US'),(3,'hudginsclay','aTKLpTZgVb5zptVD3jTKoQab5qywU6','f7LgVfmXy14AclGQgP+IVZ4Yag3w5R9gxajLXXTevyM=','Clay','Hudgins','hudginsclay@att.com',27502,'US'),(4,'erinruwe','CcGF2wLhn8NwHmpx10CuTFwP3Kjlas','vQ2cf6Z/5J/GUL2/1L+jIjfMH3HYP1RIfKB6wZxxmhA=','Erin','Ruwe','eruwe@comcast.com',27502,'US'),(5,'AnthonyFrusc','bA4HaSowk9MWi3ZyGVuqJKLoCIw7Qp','QPyF61DTE/lqcoBkz3W7qrH3bIJsfu+crYGaOGWgFJ8=','AnthonyFrusc','Fruscione','AnthonyF@gmail.com',37122,'US'),(6,'samaccount2','WC81tFqnfNrrFQqK6W6aslIbbnh9LI','M0JEsb94rkQRbc7W6gByxj8qL45RV6753Fc3U1X2TMA=','samaccount2','Ruwe','ruwesamsam@gmail.com',37122,'US'),(7,'TestUser','9xMQK2Ri3eLcWspQdRCfU9LT94N8HK','vsL8WyRMuy6RUmMm+PlgtZK+qYeVy4iMFYqM2lJd9DU=','TestUser','Test','Test@gmail.com',97133,'US');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-15 19:31:33
