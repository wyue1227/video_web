-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (arm64)
--
-- Host: 127.0.0.1    Database: video_web
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collection` (
  `collection_id` int NOT NULL AUTO_INCREMENT,
  `collection_cover` varchar(200) DEFAULT NULL,
  `collection_title` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `deleted_flg` tinyint DEFAULT '0',
  `video_count` int DEFAULT '0',
  `collection_time` mediumtext,
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,'https://manongbiji.oss-cn-beijing.aliyuncs.com/ittailkshow/ssm-job/description/cover.jpg?x-oss-process=image/resize,h_264/quality,Q_80','你必学的SSM工作案例','2022-05-19 22:45:21','2022-05-19 22:45:21','db','db',0,1,'487');
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_backgroundColor` varchar(6) DEFAULT 'FFFFFF',
  `tag_font_color` varchar(6) DEFAULT '000000',
  `tag_border_color` varchar(6) DEFAULT '000000',
  `tag_title` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `collection_id` int DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'FFFFFF','000000','000000','课时','2022-05-24 23:01:05','2022-05-24 23:01:05','db','db',1),(2,'FFFFFF','000000','000000','小时','2022-05-24 23:01:05','2022-05-24 23:01:05','db','db',1),(3,'FFFFFF','000000','000000','热度','2022-05-24 23:01:05','2022-05-24 23:01:05','db','db',1),(4,'FFFFFF','000000','000000','热度','2022-05-24 23:01:05','2022-05-24 23:01:05','db','db',2);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `token_id` varchar(36) NOT NULL COMMENT '主键UUID',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expire_time` datetime NOT NULL,
  `user_id` int NOT NULL COMMENT '创建Token的User',
  `deleted_flg` tinyint NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES ('18a489c2089a3b8c7092ba5a7a479db9','2022-05-20 01:17:45','2022-05-27 01:17:45',1,0,'2022-05-20 01:17:45','system','system'),('1c3c7df1d89c4a36e8b02f93512db542','2022-05-20 01:00:03','2022-05-27 01:00:03',1,0,'2022-05-20 01:00:03','system','system'),('26debfb8faa718257473cb59dc493748','2022-05-20 01:12:59','2022-05-27 01:12:59',1,0,'2022-05-20 01:12:59','system','system'),('3b8b6e57255240068602721bc5fcc0c3','2022-05-20 01:18:01','2022-05-27 01:18:01',1,0,'2022-05-20 01:18:01','system','system'),('959900f2f41c9d7be5e5f472bb1a5319','2022-05-19 17:36:18','2022-05-26 17:36:18',1,0,'2022-05-19 17:36:18','system','system'),('c97be2d19045c15a55633ec975c68d05','2022-05-20 01:07:20','2022-05-27 01:07:20',1,0,'2022-05-20 01:07:20','system','system');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` char(32) NOT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `deleted_flg` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_user_id_uindex` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'15524794947','Test1','827ccb0eea8a706c4c34a16891f84e7b','2022-05-19 01:17:48','system',NULL,NULL,0),(2,'15524794946','Test2','827ccb0eea8a706c4c34a16891f84e7b','2022-05-19 01:18:24','system',NULL,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `video_title` varchar(50) NOT NULL,
  `video_url` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `deleted_flg` tinyint DEFAULT '0',
  `video_time` mediumtext COMMENT '视频时长，单位秒',
  `collection_id` int DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'你必学的SSM工作案例','https://video.itlaoqi.com/sv/b6a4817-16a5e5d1823/b6a4817-16a5e5d1823.mp4','2022-05-19 20:48:32','2022-05-19 20:48:32','system','system',0,'487',1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-25 23:53:41
