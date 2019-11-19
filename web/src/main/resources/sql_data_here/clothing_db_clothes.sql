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
-- Table structure for table `clothes`
--

DROP TABLE IF EXISTS `clothes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clothes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ownerid` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `formal` int(11) NOT NULL DEFAULT '0',
  `mintemp` int(11) NOT NULL DEFAULT '-100',
  `maxtemp` int(11) NOT NULL DEFAULT '100',
  `lastworn` int(11) NOT NULL DEFAULT '0',
  `clean` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id_idx` (`ownerid`),
  CONSTRAINT `id` FOREIGN KEY (`ownerid`) REFERENCES `persons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothes`
--

LOCK TABLES `clothes` WRITE;
/*!40000 ALTER TABLE `clothes` DISABLE KEYS */;
INSERT INTO `clothes` VALUES (1,1,'shirt','blue',0,0,200,1,0),(2,1,'jeans','blue',0,-500,500,0,1),(3,1,'khacki pants','brown',1,-500,20,0,0),(5,3,'khacki pants','brown',0,-500,500,0,1),(6,4,'khacki pants','brown',0,-500,500,0,1),(7,1,'khacki shorts','brown',0,-500,500,0,1),(9,1,'shorts','light brown',0,-500,500,1,1),(11,3,'shorts','light brown',0,-500,500,0,1),(12,4,'shorts','light brown',0,-500,500,0,1),(13,4,'dress','light blue',1,-500,500,0,1),(14,4,'dress','orange and white striped',1,-500,500,0,1),(15,1,'jacket','orange',0,-500,50,0,1),(16,1,'jacket','black, gold, and white',0,-500,50,0,1),(17,1,'jacket','black and gold',0,-500,50,0,1),(18,2,'jacket','black',0,-500,50,0,1),(20,3,'jacket','red',0,-500,50,0,1),(21,1,'Jeans','Purple',0,100,800,50,0),(22,4,'Jeans','Blue',1,0,100,0,0),(23,1,'Khackis','Blue',1,70,100,5,0),(24,5,'Pants','Blue',1,0,100,5,1),(27,2,'Shirt','Red',0,0,500,0,0),(29,1,'jeans','Blue',1,-100,500,5,1),(30,1,'khacki pants','Blue',1,100,-1,57,0);
/*!40000 ALTER TABLE `clothes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-15 19:31:34
