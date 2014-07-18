CREATE DATABASE  IF NOT EXISTS `cm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cm`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: cm
-- ------------------------------------------------------
-- Server version	5.6.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `address` varchar(300) NOT NULL,
  `email` varchar(90) NOT NULL,
  `ccNo` varchar(20) NOT NULL,
  `ccType` varchar(60) NOT NULL,
  `maturity` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Dan Nelis','Vosselaar st. 19, Trnaut, Belgium','Dan@adw.com','11345694671214','MasterCard','2014-07-31'),(2,'Mark Wolf','Olaf st. 11, Stockholm, Sweden','mwolf@yahoo.com','44402356988712','Visa','2012-09-30'),(3,'Stein Brown','Oxford st. 223, Stockholm, Sweden','steinB@yahoo.com','41233576012434','Visa','2015-11-30');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `charge` decimal(5,2) NOT NULL,
  `period` smallint(6) NOT NULL,
  `minSum` decimal(19,2) NOT NULL,
  `bankName` varchar(100) NOT NULL,
  `swift` varchar(40) NOT NULL,
  `account` varchar(20) NOT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant`
--

LOCK TABLES `merchant` WRITE;
/*!40000 ALTER TABLE `merchant` DISABLE KEYS */;
INSERT INTO `merchant` VALUES (1,'Jim Smith Ltd.',5.10,1,100.00,'Chase Manhatten','AA245BXW','247991002',NULL),(2,'Domby and sun Co.',2.80,2,20.00,'Paribas','XTW2NNM','1188532009',NULL),(3,'Victoria Shop',3.40,3,500.00,'Swedbank','SWEE34YY','557880234',NULL),(4,'Software & Digital goods',4.90,1,160.00,'Credi Leone','FRTOPM','367920489',NULL);
/*!40000 ALTER TABLE `merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `merchantId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `goods` varchar(500) DEFAULT NULL,
  `total` decimal(15,2) DEFAULT NULL,
  `charge` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `merchantId` (`merchantId`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`merchantId`) REFERENCES `merchant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'2014-07-18 15:54:02',3,1,'CD Europe Maps',12.08,0.41),(2,'2014-07-18 15:54:02',4,3,'NOD32 Antivirus',33.80,1.66),(3,'2014-07-18 15:54:02',1,1,'Railway return ticket Brussel-Paris',255.58,13.03),(4,'2014-07-18 15:54:02',1,2,'Railway ticket Stockholm - Oslo',1325.00,67.58),(5,'2014-07-18 15:54:02',3,2,'CD African music',7.65,0.26),(6,'2014-07-18 15:54:02',2,1,'Acer computer',654.00,18.31),(7,'2014-07-18 15:54:02',4,2,'NOD32 Antivirus',33.80,1.66),(8,'2014-07-18 15:54:02',4,3,'MS Office',400.23,19.61),(9,'2014-07-18 15:54:02',2,2,'Dell computer',768.00,21.50);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-18 18:57:12

-- update cm.payment as p set charge = (select p.total * m.charge / 100  from cm.merchant as m where m.id = p.merchantId)
