-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hrm
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `dept_inf`
--

DROP TABLE IF EXISTS `dept_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept_inf`
--

LOCK TABLES `dept_inf` WRITE;
/*!40000 ALTER TABLE `dept_inf` DISABLE KEYS */;
INSERT INTO `dept_inf` VALUES (1,'技术部1','技术部1'),(2,'运营部','运营部1'),(5,'总公办','总公办2'),(6,'市场部','市场部1'),(11,'软件学院','安阳师范'),(12,'计算机学院','安阳师范2'),(13,'资环学院','安阳师范'),(14,'马克思学院','安阳师范12');
/*!40000 ALTER TABLE `dept_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_inf`
--

DROP TABLE IF EXISTS `document_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filename` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_DOCUMENT_USER` (`USER_ID`) USING BTREE,
  CONSTRAINT `document_inf_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_inf`
--

LOCK TABLES `document_inf` WRITE;
/*!40000 ALTER TABLE `document_inf` DISABLE KEYS */;
INSERT INTO `document_inf` VALUES (11,'ab213','e1a4c924-5b3c-4586-9a89-a4e3a386ad05数学图片2.jpg','c11111122222222','2020-04-12 10:27:59',1),(12,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:40:33',1),(13,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:43:43',1),(14,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:47:36',1),(15,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:49:15',1),(16,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:50:48',1),(17,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:51:18',1),(18,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:52:25',1),(19,'ab213','d8c833c2-cd18-462c-979d-884cf72ca6d2数学图片2.jpg','c11111122222222','2020-04-12 10:54:00',1),(20,'123','7a7c4a0a-1ed0-43bf-a356-24bdeb69780b数学图片1.jpg','EWREWREWREWR','2020-04-13 02:21:34',1);
/*!40000 ALTER TABLE `document_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_inf`
--

DROP TABLE IF EXISTS `employee_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CARD_ID` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `POST_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TEL` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PHONE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `QQ_NUM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SEX` int(11) NOT NULL DEFAULT '1',
  `PARTY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `RACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `EDUCATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SPECIALITY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `HOBBY` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `REMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_EMP_DEPT` (`DEPT_ID`) USING BTREE,
  KEY `FK_EMP_JOB` (`JOB_ID`) USING BTREE,
  CONSTRAINT `employee_inf_ibfk_1` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_inf_ibfk_2` FOREIGN KEY (`JOB_ID`) REFERENCES `job_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_inf`
--

LOCK TABLES `employee_inf` WRITE;
/*!40000 ALTER TABLE `employee_inf` DISABLE KEYS */;
INSERT INTO `employee_inf` VALUES (1,14,1,'爱丽丝','4328011988','广州天河','510000','020-77777777','13902001111','36750066','251425887@qq.com',1,'党员','2020-03-10 00:00:00','满','本科','美声','唱歌','四大天王','2016-03-14 03:35:18'),(2,2,1,'杰克','22623','43234','424274','020-77777777','13902001111','36750066','251425887@qq.com',1,'党员1','2020-03-10 00:00:00','1','研究生','1','1','总公办1','2016-03-14 03:35:18'),(3,1,1,'bb55','432801197711251038','广州','510000','020-99999999','13907351532','36750064','36750064@qq.com',1,'党员','2020-03-10 00:00:00','汉','本科','计算机','爬山','无','2016-07-14 01:54:52'),(21,1,2,'12','123','123','123','312','132','312','312',1,'123','2020-02-26 13:58:50','132','132',NULL,NULL,NULL,'2020-03-16 05:58:55');
/*!40000 ALTER TABLE `employee_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_inf`
--

DROP TABLE IF EXISTS `job_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REMARK` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_inf`
--

LOCK TABLES `job_inf` WRITE;
/*!40000 ALTER TABLE `job_inf` DISABLE KEYS */;
INSERT INTO `job_inf` VALUES (1,'职员','职员'),(2,'Java开发工程师','Java开发工程师'),(5,'系统管理员','系统管理员'),(6,'架构师','架构师'),(7,'主管1','主管'),(8,'经理','经理'),(10,'财','qwe');
/*!40000 ALTER TABLE `job_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_inf`
--

DROP TABLE IF EXISTS `notice_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_NOTICE_USER` (`USER_ID`) USING BTREE,
  CONSTRAINT `notice_inf_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_inf` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_inf`
--

LOCK TABLES `notice_inf` WRITE;
/*!40000 ALTER TABLE `notice_inf` DISABLE KEYS */;
INSERT INTO `notice_inf` VALUES (1,'公告3','[M22222','2020-03-28 17:15:22',1),(2,'公告3111','[Music, Live, Money, Nut, Tight] 1111','2020-03-28 17:15:22',1),(3,'公告3','[Music, Live, Money, Nut, Tight] 1111','2020-03-28 17:15:22',1),(4,'About','Lake[Effect, Pipe, Appear, Deed, Urgent]','2020-03-30 07:25:37',1),(5,'World','[Storm, Home, Serve, Except, True]','2020-03-30 07:25:37',1),(6,'Put','[Will, Raise, Loosen, Bottle, Throat]','2020-03-30 07:25:37',1),(7,'Yes','[Reach, Rotten, Sell, Dance, Stone]','2020-03-30 07:25:37',1),(8,'qui','[Sense, Weaken, Camp, Wisdom, Steer]','2020-03-30 07:25:37',1),(9,'123','123','2020-04-12 07:23:27',NULL),(10,'123','11111','2020-04-12 07:24:00',NULL),(11,'123','123123123','2020-04-12 10:09:01',NULL);
/*!40000 ALTER TABLE `notice_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_inf`
--

DROP TABLE IF EXISTS `user_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_inf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456',
  `STATUS` int(11) NOT NULL DEFAULT '1',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_inf`
--

LOCK TABLES `user_inf` WRITE;
/*!40000 ALTER TABLE `user_inf` DISABLE KEYS */;
INSERT INTO `user_inf` VALUES (1,'admin','123456',1,'2016-03-12 01:34:28','超级管理员'),(6,'shi','123456',1,'2020-02-24 06:55:26','张二'),(7,'root','123456',1,'2020-02-24 06:55:40','张三三'),(8,'zhao','123456',1,'2020-02-24 06:56:05','张二三'),(10,'sun','123456',1,'2020-02-24 06:56:13','张二五'),(11,'zhou','123456',1,'2020-02-24 06:56:17','张二六111');
/*!40000 ALTER TABLE `user_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hrm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 11:39:55
