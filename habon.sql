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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (5,'ssafy',1,'qweqwe','된장찌개','wqewqe','2024-05-22 09:19:21',53,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (7,5,'ssafy','된장찌개','wqewqewq','2024-05-22 09:48:57',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (98,'야구','선수',0,'류현진','https://newsimg-hams.hankookilbo.com/2024/02/23/1d5ec7f4-4473-4c09-bd0e-813aa4c7ecf8.jpg','토론토 블루제이스의 투수'),(99,'야구','선수',0,'김광현','https://i.namu.wiki/i/SmYe3Q3hrtlqVQce2xvnCF9cxs13uhjSFIzPwCl0jrPHgxCGL5pYaDa6MsAUSrdYGtXDYNJe_YKC8gwljZ28mZiXZ7rEsK_fpOT3FMWVSytpyGaTzcQ-Y9QE1GnGmrc0nC6guFyPhqd74O4EHYbsAA.webp','세인트루이스 카디널스의 투수'),(100,'야구','선수',0,'이대호','https://i.namu.wiki/i/465b-8jSDfm6fxZ4yNTq2sOYwrsz53Rk_HQEjw9Sc5WmzbRA9alC1Hl_gNFsUsFVsctyCEKN9SyjdvRP73meyUesbhXeWA63H613_pjoBbX53RUlF_YEJ6GBf72s-llZ3nRr8-GwFoKI2vuNVNsUxw.webp','롯데 자이언츠의 타자'),(101,'야구','선수',0,'최지만','https://i.namu.wiki/i/JD0pvbaVL8dP0FRnY-zOeekgJvB-LJ8BMjuQ6YvKaUulD7141sbtk1SX6oYn4-owl1ArPn-T6ZEyVVii85Pf6OtPj3j2BhLfmlJj5r8qWhLnDHRTMcucn0WkxkNEDOUGiYEyeg1N6b_hA9-Riw15EA.webp','탬파베이 레이스의 1루수'),(102,'야구','선수',0,'이정후','https://i.namu.wiki/i/CR9kYjDUPMa69-w2K3oAc1ON03uklSY-TaY4tngE56hRpwkuWtrFK2-dSEBen6w9Ha774PxdHyyHyWX3J2menWFfIyZngEpWV6Z42byTAfAJf9hS7_Pt4UWv6_ISL2AXpgONW3UGN3_sn80RzvJOzw.webp','키움 히어로즈의 외야수'),(103,'야구','선수',0,'강백호','https://i.namu.wiki/i/BAzGQVgwLhJfaaknIWqQAq8XFjrCa76EmdvcujXctst5yDu-7DiDLfYivkZGUx2L7vxedP_2P9K_B0OGcwb3SoHFIWrWOnHes5aX4IrD2HtPJhfyf0STOSbAHUlr8Wo9Eoxz2WTrkrZJiUy8gGgoBA.webp','KT 위즈의 타자'),(104,'야구','선수',0,'박병호','https://dimg.donga.com/wps/NEWS/IMAGE/2022/10/21/116058096.2.jpg','KT 위즈의 타자'),(105,'야구','선수',0,'김하성','https://isplus.com/data/isp/image/2023/08/22/isp20230822000251.800x.0.jpg','샌디에이고 파드리스의 내야수'),(106,'야구','선수',0,'양현종','https://cdn.apnews.kr/news/photo/202005/20200504_1_bodyimg_834735.PNG','KIA 타이거즈의 투수'),(107,'야구','선수',0,'김현수','https://i.namu.wiki/i/lAVB3X37ZDagq1nTJsu6bxMvbJUd0rVFjFkbXXmdcQrEfGVBUUndDj1yynfLBPYjwNRjii74uYreHq71_8iHgvxVA9cRx0n7T19YmnGnvTwh-WzE9J4fkRniLU0diRwpo6LxH6tjFOpMTx9_8jJL6A.webp','LG 트윈스의 외야수'),(108,'야구','선수',0,'오승환','https://i.namu.wiki/i/d8xmA3mPxPbSEaO8B50oEPkSx6xvLAsC8vGyXxWSp_MPnbZbCInlvYbewnWCkRNVbGTKJ5BbBvWyeufGAPfhbAhzc-MFyTh9AJI7DeUBVlMG-tguaOlOFhOlchfW8uKZ9PjKhFN55DU0bLi4H26dVg.webp','삼성 라이온즈의 투수'),(109,'야구','선수',0,'유희관','https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2022/05/30/d35a5116-cc74-48c1-922f-4b79b59b33ca.jpg','두산 베어스의 투수'),(111,'야구','선수',0,'정우람','https://i.namu.wiki/i/-f-eec7zpls0j70BjfcF5yXGcSaJrGhXL2PWA1ENY1TL8zEd8TVpHyRm8JDx-gcJNmRksCSumgkuXZOz_Tb9pyJGgBsKyFLW27ptwFLxTjB_yHffp0NiAh9QSpJBRZMGVNXfOXdSGW_Y7I_QUCYp3Q.webp','한화 이글스의 투수'),(112,'야구','선수',0,'박석민','https://i.namu.wiki/i/La9IHRcrSBOcp3gHpCV-nzy1SWOs-zRmnW3sQJEhTGxxt-MY_991_6mcWmbYEFSwfDj_metFa268uzEKVBzRH4QkV8wK3GsAo9ZsvndN7drHdz0vecb9zDR1rigsM42LHGhJXNq05Jr4TIlGK2Uoyw.webp','NC 다이노스의 내야수'),(113,'야구','선수',0,'이용규','https://i.namu.wiki/i/kTnmJ4t-0VoQLl-dhZkLe9erdZ8lQDsLDL3yLYLSfKmhr3aXzoDn9RLu_jLd-BWcbxjGacuXKvczEQ9RkSv-w6ULiPsnFI2aVhCMUpKt3mwedjTRqfCwjHqPedVJ6195tP0IxHgAWfzAZ_KEOXFYJg.webp','키움 히어로즈의 외야수'),(114,'야구','선수',0,'박해민','https://i.namu.wiki/i/OOW6rSSTVV1zqqc74xWNHOWUi2HkjblYR1jKj8mb9RqwBBxa2xOZYFUSqaho0Aq-rAfP-d_0RaD2V2opEkl8i7OdqNnL18yqpLxkHbaWYYT7F6kB0Nvj3SVBeGZ_r4Wo_CMIKjIv6600K0bH20lvTA.webp','삼성 라이온즈의 외야수'),(115,'야구','선수',0,'최정','https://i.namu.wiki/i/gIAN8IRFyULKNToRWrEBiy96irdnn4M2qv1xPU6ocjB84dUiV0gSchlEl5I3nIy6C1z6tExPNFfquAZ6zbFWWMB6UEk3nlEaQl-j42lT-r9i-WtR9EX9-ai1b8ccwKjn9VLbysjq7aY6vUed3VrHjg.webp','SSG 랜더스의 내야수'),(116,'야구','선수',0,'김강민','https://i.namu.wiki/i/TyK52bb_hmDZHM2Ky_lAezNEZhpzLCyaBoBY1Exa17Pp9bS89-VB6Lmp6y1rC7Y5Cer9pp0dv2dxLWe2ZRLxw-YTeVW5uLRLdhP-Np9NNAX4U_IXT0v7z6NoruYSilj0ZS2Wuh5eGByq6gL65xqpaw.webp','SSG 랜더스의 외야수'),(157,'야구','팀',0,'한화 이글스','https://i.namu.wiki/i/V8UpPDAns1vEXiKKrmlj9q8YB1Qwi5gFajiQu02S93LZMvZpdaonT8HVVPonFwwDXJp-_6QUvd8cCXviiSVo3LfnmGCMLMgKr7Qd04SHAv_Zwj9PGPDyeEJt9hFRMPs-EDe5EHOA9nM-nc6Aop-g8A.svg',NULL),(158,'야구','팀',0,'LG 트윈스','https://i.namu.wiki/i/NxckEmonV57vPYIOqGX4Pjn1AdkSL2XvPClylL4aOi9hAIEAITBCHWZKDVSKEtrkqlu4PWJixzSn7rDHDOvQxsDUOxkeQu24WmTNpMpn1Hya_S3HdgoeFrkXp-gwEDKF4ssSA3C3uhvgWLQzMy8uIA.svg',NULL),(159,'야구','팀',0,'롯데 자이언츠','https://i.namu.wiki/i/grld4vcle9RtLKvAEyjrstGpup54aIi9lvsOHTLz2V70GnMlS08shRJFFNaWHgmUqLafxC7qDBmZndn6SmLl5xz9uKu06W88CAdx6a0rA-xhAHv4605sN7bEURKD68W7EMEsju3Wtu2ocl221hjIAQ.svg',NULL),(160,'야구','팀',0,'기아 타이거즈','https://i.namu.wiki/i/5HO-lPxtRCbfGe7oPKBBTEhJmQtLeE_J4J8anPRIenlgUokdr6jrOPRLQLpCQyFNm4Ng25b471dLAKDtVBsnpr7vj5TyL5WY0s1kOydlAE3k8Ob536Ea4n4jBJc8yNhNzRp_OHIx6XwS-aar_cH76A.svg',NULL),(161,'야구','팀',0,'삼성 라이온즈','https://i.namu.wiki/i/h-UuGgi-5r8bqyGT6UMXdOg4Pzy1n1rXCL1rFP-mAmASGOy7N9bGrdoWWZ11TOL4i8EvhsB9zzarJRaAhiQs12mmhO-inRNuctBb4sNzlpYlQpgQWhy8zPRSXfLi2VNpzoZ1ztsJomJSNdwiFb2DuQ.svg',NULL),(162,'야구','팀',0,'두산 베어스','https://i.namu.wiki/i/NHZBncAjk9taJs5EmIu1s56tsEgcX4mA-syL9a4x1U3SRQiqIWB7MKRZcHSDi-TvBGNKT2F3lIMCyM1szvAyzRVhD1bVruRzOD0mEHz8qaQzoNsrypUsZuahA8bjKrN_UX_CU9Xo_lanFtawhTKCfQ.svg',NULL),(163,'야구','팀',0,'키움 히어로즈','https://i.namu.wiki/i/tpa14A9dFLlSmuxkM7Y7wBIYkB13RAFbLmhVAHh-qEgczUE6MhppuNQK24dfp_3x2L-3EglZQEgzrV51Frgr_T4mjvpyzz5V26P-v_3E22qfk2dD_KQok8GSXSk5S-vZVK7u_QVL9BgQD6ZFxPpicg.svg',NULL),(164,'야구','팀',0,'KT 위즈','https://i.namu.wiki/i/b7JkREMFWowzXt3bBYRCid1OGilJRLUlBYCAQPwfyU8IWyIYKfqpdKMCeiNyKzEZn-xfACo16_4L5pRzpg5LNw.svg',NULL),(165,'야구','팀',0,'NC 다이노스','https://i.namu.wiki/i/gStz-3AuB2poRN62xAq84Jxu-YPLFCciYoaX4M94bty9bbqyKCBaE7L7se6fc5Brt8F2z2sEVhLIGXXUHeuaK2xN_fzIxwVXGzHyMlkr2_T_MfIMQ0GvneYTHTuDWmxS_FbGh0W-zVJu29cwGosPiQ.svg',NULL),(166,'야구','팀',0,'SSG 랜더스','https://i.namu.wiki/i/cu7cehx0VzBISoDSCAq9A_kqPqg9IeilmC7VK9KfhoWh5hrxkuBDg8IgemCxcVWxnl1QiVQtTPoJVwMJ3t67HmdDLkKzJK6Q0dOTvW6DCKL1yTAk8cBST8o-I85Z1pGaNLkpDEwu5CKj5NFxBi5ThQ.svg',NULL),(167,'야구','팀',0,'SK 와이번스','https://i.namu.wiki/i/0Q0rIWad4AoUce1hBiWwi13Fi18jls8Y2qk_s16LQqX7NlcVYeaHEI5sP_ssWenIkDIDtnSGPPY_16jeQndID4TGQ0Jijg_MRcAhaKnE4r_j5Y4GQ4guidxWt41KY0in5Gpg7OZ2vS3p_GMAIZfT0Q.svg',NULL),(168,'야구','팀',0,'넥센 히어로즈','https://i.namu.wiki/i/261GXE1zbfzztoEIVHzyBupusVr_cKLkeIHwRKR7amRHk4_G5XFuUKD6YvEEiHHuzEhgXgXLQKVO4xP1IgfKhW1aQ1eEH8Mu_EhwQlI7lBFB3Fo43B7abPvfUujkOEkzfoY7KU-F9DawOhd-fPjXhw.svg',NULL),(169,'야구','팀',0,'현대 유니콘스','https://i.namu.wiki/i/_ZHpmfuQoQz_236dFfrxr6yUFjvbWEoo3MqAzysiYMeA73gKXG0KfRXjac66G8kC_C1sxU8zVWHHb-Tu9IbU1zf3VY-WFHrQy_22bvWqvd5Rjd4cGPfsacfvAt6J-pv-VHT9pYCtyTrMNlq9Q_SAzg.svg',NULL),(170,'야구','팀',0,'OB 베어스','https://i.namu.wiki/i/SN1EFK7DWbBrTNEJ_UDoYPZNLczlDQJngndwPKcQXzCUNPmeWC_dt1eQzTCkLXcl2rrgNqZYdH7mLj5JR9vd4cFslcT3NMrlqXgr1rQmSQukhIbs2fQ-IeOFTcT6fqfJRoJ--mM4pcFav_aahlw6AA.svg',NULL),(171,'야구','팀',0,'쌍방울 레이더스','https://i.namu.wiki/i/mlDw2VfbSxFm0bqm8uzPliD0GcH3Grxh0jasQehtWuAdlG7MdSxDKuAmbX2v4fbbYKYHzityoJJOvTtgtoliH-RYzzvxsrV3HICn06pyk5Bb1nMRdbbyOe8R0Y0CkG94tZ6WzmnLxmKNZwzXkPtcaA.png',NULL),(172,'야구','팀',0,'빙그레 이글스','https://i.namu.wiki/i/53VHR47hmrOwzcjoI8UkimVkSV7c8xLRDNNdmuRt1VLFGTyU4oMPapVutcOAPfoY5WQbOEU0CUlmiiR1TpRJBGoa3ju1LXOl5UVEkXwX_pzIVrEQcN1dFVezNIXw2hWHQzX7q6kKX5PG5EMZSJWC4g.svg',NULL),(173,'야구','팀',0,'삼미 슈퍼스타즈','https://i.namu.wiki/i/2pn6TEIU8ThFmbPwy9qVQ--Ob9b7eQdwiaf-_dttb1u9OBg6DQkfSC7pl-qbb6_ULGFRIFR8-ip6ZVaVQ7Lcmj0zt7dIh_WhhSrHLdBKCunW_XgfSSE9ltYgo6HtVPVTCd2JuCmgGlagG7OfoRI-Yw.webp',NULL),(174,'야구','팀',0,'해태 타이거즈','https://i.namu.wiki/i/vOXEFIETZvxJR5QxLFK1AE_KWMJB0ezNhTu6qvAcomzAHpYzzZz9EkvW5g4RCb0Eh95isrqnx4u6vf7d4ooLj_Os4LdMPrLp8dZKCMRgXDXpbv2qf1SuX2e_HOz9eqQzVK36AoP6gAFQjDol7oamNg.svg',NULL),(176,'야구','팀',0,'MBC 청룡','https://i.namu.wiki/i/15w4Y54rab0RSGJDyFqGI5tR2exZuHrIlfDNLXYJIE3jMkm8y0CIL1Gr7gKDQthJ3xCOaT5vKtTCpepJOueR-g.svg',NULL),(177,'','스포츠',0,'축구','https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Football_pictogram.svg/1200px-Football_pictogram.svg.png',NULL),(178,'','스포츠',0,'야구','https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Baseball_pictogram.svg/1024px-Baseball_pictogram.svg.png',NULL),(179,'','스포츠',0,'농구','https://upload.wikimedia.org/wikipedia/commons/4/4f/Basketball_pictogram.svg',NULL),(180,'','스포츠',0,'배구','https://upload.wikimedia.org/wikipedia/commons/c/ca/Volleyball_%28indoor%29_pictogram.svg',NULL),(181,'','스포츠',0,'테니스','https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Tennis_pictogram.svg/480px-Tennis_pictogram.svg.png',NULL),(182,'','스포츠',0,'골프','https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Golf_pictogram.svg/2048px-Golf_pictogram.svg.png',NULL),(183,'','스포츠',0,'배드민턴','https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Badminton_pictogram.svg/2048px-Badminton_pictogram.svg.png',NULL),(184,'','스포츠',0,'탁구','https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Table_tennis_pictogram.svg/2048px-Table_tennis_pictogram.svg.png',NULL),(185,'','스포츠',0,'수영','https://upload.wikimedia.org/wikipedia/commons/e/eb/Swimming_pictogram.svg',NULL),(186,'','스포츠',0,'육상','https://i.ibb.co/k3KF2DJ/png-transparent-track-field-sport-athlete-summer-olympic-games-pictogram-papel-digital-removebg-prev.png',NULL),(187,'','스포츠',0,'유도','https://svgsilh.com/svg_v2/639598.svg',NULL),(188,'','스포츠',0,'레슬링','https://i.ibb.co/YfTqZJt/94107-removebg-preview.png',NULL),(189,'','스포츠',0,'복싱','https://upload.wikimedia.org/wikipedia/commons/c/c2/Boxing_pictogram.svg',NULL),(190,'','스포츠',0,'펜싱','https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Fencing_pictogram.svg/768px-Fencing_pictogram.svg.png',NULL),(191,'','스포츠',0,'사격','https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Shooting_pictogram.svg/480px-Shooting_pictogram.svg.png',NULL),(192,'','스포츠',0,'양궁','https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Archery_pictogram.svg/2048px-Archery_pictogram.svg.png',NULL),(193,'','스포츠',0,'핸드볼','https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Handball_pictogram.svg/150px-Handball_pictogram.svg.png',NULL),(194,'','스포츠',0,'럭비','https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Rugby_union_pictogram.svg/600px-Rugby_union_pictogram.svg.png',NULL),(195,'','스포츠',0,'크리켓','https://i.ibb.co/BCvPkbv/png-clipart-1900-summer-olympics-olympic-games-cricket-pictogram-cricket-angle-text-removebg-preview.png',NULL),(196,'','스포츠',0,'스쿼시','https://cdn-icons-png.flaticon.com/512/37/37765.png',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participation`
--

LOCK TABLES `participation` WRITE;
/*!40000 ALTER TABLE `participation` DISABLE KEYS */;
INSERT INTO `participation` VALUES (27,'ssafy',1,-943),(28,'ssafy',4,2),(29,'ssafy',6,2),(30,'ssafy',2,5);
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
  `acc_point` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_worldcup_ele` (`worldcup_id`,`ele_id`),
  KEY `worldcup_id_idx` (`worldcup_id`),
  KEY `ele_id_idx` (`ele_id`),
  CONSTRAINT `rank_ele_id` FOREIGN KEY (`ele_id`) REFERENCES `elements` (`id`),
  CONSTRAINT `rank_worldcup_id` FOREIGN KEY (`worldcup_id`) REFERENCES `worldcup` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3530 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */
--
-- Dumping data for table `rank`
--

LOCK TABLES `rank` WRITE;
/*!40000 ALTER TABLE `rank` DISABLE KEYS */;
INSERT INTO `rank` VALUES (333,1,114,2,0,19),(334,1,106,4,0,4),(335,1,109,1,0,4),(336,1,99,55,0,2),(337,1,101,0,0,1),(338,1,103,0,0,0),(340,1,98,0,0,0),(343,1,100,0,0,0),(345,1,102,3,0,4),(347,1,104,0,0,0),(348,1,105,2,0,6),(350,1,107,0,0,0),(351,1,108,0,0,0),(354,1,111,0,0,1),(355,1,112,0,0,2),(356,1,113,1,0,1),(358,1,115,0,0,0),(359,1,116,1,0,1),(432,2,98,0,0,0),(433,2,99,0,0,0),(434,2,100,0,0,0),(435,2,101,0,0,0),(436,2,102,0,0,0),(437,2,103,0,0,0),(438,2,104,0,0,0),(439,2,105,0,0,0),(440,2,106,0,0,0),(441,2,107,0,0,0),(442,2,108,0,0,0),(443,2,109,0,0,0),(444,2,111,0,0,0),(445,2,112,0,0,0),(446,2,113,0,0,0),(447,2,114,0,0,0),(448,2,115,0,0,0),(449,2,116,0,0,0),(450,6,177,0,0,2),(451,6,178,0,0,0),(452,6,179,0,0,1),(453,6,180,0,0,2),(454,6,181,0,0,1),(455,6,182,0,0,0),(456,6,183,0,0,0),(457,6,184,0,0,0),(458,6,185,0,0,0),(459,6,186,0,0,0),(460,6,187,0,0,0),(461,6,188,0,0,0),(462,6,189,0,0,4),(463,6,190,0,0,1),(464,6,191,0,0,3),(465,6,192,0,0,0),(466,6,193,0,0,1),(467,6,194,0,0,0),(468,6,195,0,0,0),(469,6,196,0,0,0),(470,4,157,4,0,4),(471,4,158,0,0,0),(472,4,159,2,0,3),(473,4,160,4,0,4),(474,4,161,0,0,1),(475,4,162,1,0,1),(476,4,163,3,0,5),(477,4,164,1,0,2),(478,4,165,1,0,1),(479,4,166,0,0,1),(480,4,167,0,0,0),(481,4,168,0,0,0),(482,4,169,0,0,0),(483,4,170,0,0,2),(484,4,171,0,0,0),(485,4,172,1,0,1),(486,4,173,1,0,1),(487,4,174,3,0,7),(489,4,176,0,0,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendation`
--

LOCK TABLES `recommendation` WRITE;
/*!40000 ALTER TABLE `recommendation` DISABLE KEYS */;
INSERT INTO `recommendation` VALUES (45,'ssafy','board',5);
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
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `content_type` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `content_id` int NOT NULL,
  `content_content` text COLLATE utf8mb3_bin NOT NULL,
  `report_content` text COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (0000000001,'board',5,'','너무 시끄러움'),(0000000002,'comment',7,'','이것도 시끄러움'),(0000000003,'board',5,'wqewqe','string'),(0000000004,'board',5,'wqewqe','string'),(0000000005,'board',5,'wqewqe','qweqw'),(0000000006,'board',5,'wqewqe','reyreyery'),(0000000007,'comment',7,'wqewqewq','ㄴㅁㄴㅁㅇ'),(0000000008,'board',5,'wqewqe','ㅂㅈㄷㅈㅂㄷ');
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
INSERT INTO `user` VALUES ('qwer','qwer','qwer','qwer@qwe','weqwe',22,'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Rugby_union_pictogram.svg/600px-Rugby_union_pictogram.svg.png','wqe','wqe','wqe',0),('saffy','1234','박예본','goodyeib@nave.rcom','슈퍼~~~레코드',24,'','축구','맨유','페로난도 토레스',0),('ssafy','1234','유리카츠','fojeiui@fiae.com','된장찌개',23,'https://upload.wikimedia.org/wikipedia/commons/4/4f/Basketball_pictogram.svg','q','ww','er',1934),('string','string','이름이다잉','string.com','테이트중이다잉',26,'','야구','맹구','스털링',0);
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


DROP TABLE IF EXISTS `weeklyrank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weeklyrank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worldcup_id` int NOT NULL,
  `year` int NOT NULL,
  `month` int NOT NULL,
  `week` int NOT NULL,
  `first_ele_id` int NOT NULL,
  `second_ele_id` int NOT NULL,
  `third_ele_id` int NOT NULL,
  `fourth_ele_id` int NOT NULL,
  `fifth_ele_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weeklyrank`
--

LOCK TABLES `weeklyrank` WRITE;
/*!40000 ALTER TABLE `weeklyrank` DISABLE KEYS */;
INSERT INTO `weeklyrank` VALUES (1,1,2024,5,4,101,102,103,104,105),(2,1,2024,5,2,114,109,105,101,115),(3,2,2024,5,2,114,116,98,99,100),(4,4,2024,5,2,159,163,174,176,164),(5,6,2024,5,4,189,191,177,180,179),(6,1,2024,5,2,114,109,105,101,115),(7,2,2024,5,4,114,116,98,99,100),(8,4,2024,5,4,159,163,174,176,164),(9,6,2024,5,2,189,191,177,180,179),(10,1,2024,5,2,98,99,100,101,102),(11,2,2024,5,4,114,116,98,99,100),(12,4,2024,5,4,159,163,174,176,164),(13,6,2024,5,4,189,191,177,180,179),(14,1,2024,5,4,98,99,100,101,102),(15,2,2024,5,4,98,99,100,101,102),(16,4,2024,5,4,157,158,159,160,161),(17,6,2024,5,4,177,178,179,180,181),(18,1,2024,5,4,98,99,100,101,102),(19,2,2024,5,4,98,99,100,101,102),(20,4,2024,5,4,157,158,159,160,161),(21,6,2024,5,4,177,178,179,180,181);
/*!40000 ALTER TABLE `weeklyrank` ENABLE KEYS */;
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

-- Dump completed on 2024-05-22 17:41:19
