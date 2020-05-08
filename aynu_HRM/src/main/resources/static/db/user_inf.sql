/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : hrm

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 28/02/2020 21:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456',
  `STATUS` int(11) NOT NULL DEFAULT 1,
  `createdate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES (1, 'admin', '123456', 2, '2016-03-12 09:34:28', '超级管理员');
INSERT INTO `user_inf` VALUES (2, 'qiu1', '1234561', 1, '2020-02-23 11:44:24', '邱一111');
INSERT INTO `user_inf` VALUES (3, 'zhang', '123456', 1, '2020-02-24 13:49:08', '张二');
INSERT INTO `user_inf` VALUES (4, 'liu', '123456', 1, '2020-02-24 13:49:21', '刘三');
INSERT INTO `user_inf` VALUES (5, 'yu', '123456', 1, '2020-02-24 13:49:26', '于四');
INSERT INTO `user_inf` VALUES (6, 'shi', '123456', 1, '2020-02-24 14:55:26', '张二');
INSERT INTO `user_inf` VALUES (7, 'root', '123456', 1, '2020-02-24 14:55:40', '张三三');
INSERT INTO `user_inf` VALUES (8, 'zhao', '123456', 1, '2020-02-24 14:56:05', '张二三');
INSERT INTO `user_inf` VALUES (10, 'sun', '123456', 1, '2020-02-24 14:56:13', '张二五');
INSERT INTO `user_inf` VALUES (11, 'zhou', '123456111', 1, '2020-02-24 14:56:17', '张二六');
INSERT INTO `user_inf` VALUES (12, 'qiu333', '123456', 1, '2020-02-26 15:42:22', '邱三三三');
INSERT INTO `user_inf` VALUES (13, '11111111', '111111', 1, '2020-02-27 14:37:07', 'root11');

SET FOREIGN_KEY_CHECKS = 1;
