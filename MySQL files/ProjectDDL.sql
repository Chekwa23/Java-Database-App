-- create schema to be used with example-load-in-file.
-- 
DROP DATABASE IF EXISTS `Group78`;
CREATE DATABASE IF NOT EXISTS `Group78`;

USE `Group78`;
DROP TABLE IF EXISTS `tweet`;
CREATE TABLE `tweet` (
  `tid` bigint NOT NULL,
  `textbody` text,
  `retweet_count` int(11) DEFAULT NULL,
  `retweeted` tinyint(1) DEFAULT NULL,
  `posted` datetime NOT NULL,
  `posting_user` varchar(80) NOT NULL,
  `created_at` bigint NOT NULL,
  
  PRIMARY KEY (`tid`)
  );
 
 USE `Group78`;
 DROP TABLE IF EXISTS `newtweet`;
  CREATE TABLE `newtweet` (
  `tid` bigint NOT NULL,
  `textbody` text,
  `retweet_count` int(11) DEFAULT NULL,
  `retweeted` tinyint(1) DEFAULT NULL,
  `day_posted` int NOT NULL,
  `month_posted` int NOT NULL,
  `year_posted` int NOT NULL,
  `posting_user` varchar(80) NOT NULL ,
  
  PRIMARY KEY (`tid`)
  );
  
  USE `Group78`;
  DROP TABLE IF EXISTS `hashtags`;
  CREATE TABLE `hashtags` (
  `tid` bigint NOT NULL,
  `tag_name` varchar(255) NOT NULL,
  
  PRIMARY KEY (`tid`,`tag_name`),
  FOREIGN KEY (`tid`) REFERENCES tweet(`tid`) ON DELETE CASCADE 
  );
  
  USE `Group78`;
  DROP TABLE IF EXISTS `urls`;
  CREATE TABLE `urls` (
  `tid` bigint NOT NULL,
  `address` varchar(480) NOT NULL,
  
  PRIMARY KEY (`address`,`tid`),
  FOREIGN KEY (`tid`) REFERENCES tweet(`tid`) ON DELETE CASCADE
  );
  
  USE `Group78`;
  DROP TABLE IF EXISTS `users`;
  CREATE TABLE `users` (
  `screen_name` varchar(80) NOT NULL, 
  `user_name` varchar(80),
  `subCategory` varchar(80),
  `category` varchar(80),
  `state` varchar(255),
  `numFollowers` bigint,
  `numFollowing` bigint,
  PRIMARY KEY (`screen_name`)
  );
  
  USE `Group78`;
  DROP TABLE IF EXISTS `mentions`;
  CREATE TABLE `mentions` (
  `tid` bigint NOT NULL,
  `screen_name` varchar(80),
  
  PRIMARY KEY (`tid`,`screen_name`),
  FOREIGN KEY (`screen_name`) REFERENCES users(`screen_name`) ON DELETE CASCADE,
  FOREIGN KEY (`tid`) REFERENCES tweet(`tid`) ON DELETE CASCADE
  );
  

  

