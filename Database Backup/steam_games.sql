-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: steam
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
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` text,
  `title` text,
  `developer` text,
  `genre` text,
  `price` double DEFAULT NULL,
  `release_year` int DEFAULT NULL,
  `controller_support` tinyint(1) DEFAULT NULL,
  `reviews` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  `file_path` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES ('292030','The Witcher 3: Wild Hunt','CD Projekt Red','Role-playing',29.99,2015,1,96,798,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('323190','Frostpunk','11 bit studios','Strategy',29.99,2018,0,91,944,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('359550','Tom Clancy\'s Rainbow Six Siege','Ubisoft','First-person Shooter',19.99,2015,1,82,561,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('489830','The Elder Scrolls V: Skyrim Special Edition','Bethesda Game Studios','Role-playing',39.99,2016,1,96,677,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('2050650','Destiny 2','Bungie','First-person Shooter',0,2019,1,74,657,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('1151640','Horizon Zero Dawn Complete Edition','Guerrilla','Action-adventure',49.99,2020,1,87,915,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('1174180','Red Dead Redemption 2','Rockstar Games','Action-adventure',59.99,2018,1,90,771,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('1196590','Resident Evil Village','Capcom','Survival Horror',39.99,2021,1,95,811,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('1245620','Elden Ring','FromSoftware','Role-playing',59.99,2022,1,94,703,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources'),('2050650','Resident Evil 4','Capcom','Survival Horror',59.99,2023,1,97,618,'D:Uni TA ProjectsTerm 2JavaMainEighth-Assignment-SteamsrcmainjavaServerResources');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-13 20:26:42
