/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 02/12/2019 13:58:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classnum` int(10) NOT NULL DEFAULT 0 COMMENT '班级编号',
  `adminclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政班级',
  PRIMARY KEY (`classnum`) USING BTREE,
  INDEX `adminclass`(`adminclass`) USING BTREE,
  CONSTRAINT `adminclass` FOREIGN KEY (`adminclass`) REFERENCES `student` (`adminclass`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1701, '17java1');
INSERT INTO `class` VALUES (1702, '17java2');
INSERT INTO `class` VALUES (1703, '17java3');
INSERT INTO `class` VALUES (1704, '17java4');

-- ----------------------------
-- Table structure for classlearnmessagecount
-- ----------------------------
DROP TABLE IF EXISTS `classlearnmessagecount`;
CREATE TABLE `classlearnmessagecount`  (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `adminClass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `normalSum` double NULL DEFAULT NULL,
  `normalAvg` double NULL DEFAULT NULL,
  `finalSum` double NULL DEFAULT NULL,
  `finalAvg` double NULL DEFAULT NULL,
  `totalSum` double NULL DEFAULT NULL,
  `totalAvg` double NULL DEFAULT NULL,
  PRIMARY KEY (`classId`) USING BTREE,
  INDEX `fk_adminClass`(`adminClass`) USING BTREE,
  CONSTRAINT `fk_adminClass` FOREIGN KEY (`adminClass`) REFERENCES `class` (`adminclass`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_classId` FOREIGN KEY (`classId`) REFERENCES `class` (`classnum`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1705 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classlearnmessagecount
-- ----------------------------
INSERT INTO `classlearnmessagecount` VALUES (1701, '17java1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `classlearnmessagecount` VALUES (1702, '17java2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `classlearnmessagecount` VALUES (1703, '17java3', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `classlearnmessagecount` VALUES (1704, '17java4', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `time` int(10) NULL DEFAULT NULL COMMENT '课程学时',
  `credit` int(10) NULL DEFAULT NULL COMMENT '课程学分',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '毛中特', 16, 100);
INSERT INTO `course` VALUES (2, '计算机网络', 16, 100);
INSERT INTO `course` VALUES (3, 'Java EE视图层框架技术', 16, 100);
INSERT INTO `course` VALUES (4, 'Oracle数据库', 16, 100);
INSERT INTO `course` VALUES (5, '软件前沿技术', 16, 100);
INSERT INTO `course` VALUES (6, '软件工程导论', 16, 100);
INSERT INTO `course` VALUES (7, 'Java EE持久层框架技术', 16, 100);
INSERT INTO `course` VALUES (8, '媒体设计方法学', 16, 100);
INSERT INTO `course` VALUES (9, '企业项目实战', 16, 100);

-- ----------------------------
-- Table structure for coursescore
-- ----------------------------
DROP TABLE IF EXISTS `coursescore`;
CREATE TABLE `coursescore`  (
  `studentid` int(20) NOT NULL DEFAULT 0,
  `studentname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `courseid` int(10) NULL DEFAULT NULL,
  `peacescore` double(10, 0) NULL DEFAULT NULL COMMENT '平时成绩',
  `finalscore` double(10, 0) NULL DEFAULT NULL COMMENT '期末试卷成绩',
  `totalscore` double(10, 0) NULL DEFAULT NULL COMMENT '总成绩',
  PRIMARY KEY (`studentid`) USING BTREE,
  INDEX `studentname`(`studentname`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE,
  INDEX `peacescore`(`peacescore`) USING BTREE,
  INDEX `finalscore`(`finalscore`) USING BTREE,
  INDEX `totalscore`(`totalscore`) USING BTREE,
  CONSTRAINT `courseid` FOREIGN KEY (`courseid`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentid` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `studentname` FOREIGN KEY (`studentname`) REFERENCES `student` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coursescore
-- ----------------------------
INSERT INTO `coursescore` VALUES (1, 'zhangsan', 2, 98, 98, 98);
INSERT INTO `coursescore` VALUES (2, 'lisi', 1, 56, 100, 60);
INSERT INTO `coursescore` VALUES (3, 'wangwu', 2, 80, 80, 80);
INSERT INTO `coursescore` VALUES (4, 'mali', 2, 60, 60, 60);
INSERT INTO `coursescore` VALUES (5, 'tom', 1, 77, 77, 77);
INSERT INTO `coursescore` VALUES (6, 'cat', 1, 78, 78, 78);
INSERT INTO `coursescore` VALUES (7, 'lily', 4, 66, 66, 66);
INSERT INTO `coursescore` VALUES (8, 'monica', 4, 98, 98, 98);
INSERT INTO `coursescore` VALUES (9, 'luosi', 4, 84, 84, 84);
INSERT INTO `coursescore` VALUES (10, 'joe', 9, 69, 69, 69);
INSERT INTO `coursescore` VALUES (11, 'ruiqiu', 9, 82, 82, 82);
INSERT INTO `coursescore` VALUES (12, 'feibi', 9, 99, 99, 99);

-- ----------------------------
-- Table structure for mid
-- ----------------------------
DROP TABLE IF EXISTS `mid`;
CREATE TABLE `mid`  (
  `stuid` int(11) NOT NULL,
  `cid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mid
-- ----------------------------
INSERT INTO `mid` VALUES (2, 1);
INSERT INTO `mid` VALUES (2, 2);
INSERT INTO `mid` VALUES (2, 3);

-- ----------------------------
-- Table structure for personallearn
-- ----------------------------
DROP TABLE IF EXISTS `personallearn`;
CREATE TABLE `personallearn`  (
  `studentid` int(20) NOT NULL,
  `studentname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `peacescore` double(20, 0) NULL DEFAULT NULL,
  `finalscore` double(20, 0) NULL DEFAULT NULL,
  `totalscore` double(20, 0) NOT NULL,
  PRIMARY KEY (`studentid`, `studentname`) USING BTREE,
  INDEX `studentname_fk`(`studentname`) USING BTREE,
  INDEX `gender_fk`(`gender`) USING BTREE,
  INDEX `adminclass_fk`(`adminclass`) USING BTREE,
  INDEX `peacescore_fk`(`peacescore`) USING BTREE,
  INDEX `finalscore_fk`(`finalscore`) USING BTREE,
  INDEX `totalscore_fk`(`totalscore`) USING BTREE,
  CONSTRAINT `adminclass_fk` FOREIGN KEY (`adminclass`) REFERENCES `student` (`adminclass`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `finalscore_fk` FOREIGN KEY (`finalscore`) REFERENCES `coursescore` (`finalscore`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `gender_fk` FOREIGN KEY (`gender`) REFERENCES `student` (`gender`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `peacescore_fk` FOREIGN KEY (`peacescore`) REFERENCES `coursescore` (`peacescore`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `totalscore_fk` FOREIGN KEY (`totalscore`) REFERENCES `coursescore` (`totalscore`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personallearn
-- ----------------------------
INSERT INTO `personallearn` VALUES (2, 'lisi', 'male', '17java2', 56, 98, 60);
INSERT INTO `personallearn` VALUES (3, 'wangwu', 'male', '17java1', 80, 80, 80);
INSERT INTO `personallearn` VALUES (4, 'mali', 'female', '17java1', 60, 60, 60);
INSERT INTO `personallearn` VALUES (5, 'tom', 'male', '17java2', 77, 77, 77);
INSERT INTO `personallearn` VALUES (6, 'cat', 'male', '17java2', 78, 78, 78);
INSERT INTO `personallearn` VALUES (7, 'lily', 'female', '17java3', 66, 66, 66);
INSERT INTO `personallearn` VALUES (8, 'monica', 'female', '17java3', 98, 98, 98);
INSERT INTO `personallearn` VALUES (9, 'luosi', 'male', '17java3', 84, 84, 84);
INSERT INTO `personallearn` VALUES (10, 'joe', 'male', '17java4', 69, 69, 69);
INSERT INTO `personallearn` VALUES (11, 'ruiqiu', 'female', '17java4', 82, 82, 82);
INSERT INTO `personallearn` VALUES (12, 'feibi', 'female', '17java4', 99, 99, 99);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在院校',
  `adminclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '行政班级',
  `mobile` int(20) NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `adminclass`(`adminclass`) USING BTREE,
  INDEX `gender`(`gender`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'zhangsan', 'male', 'aynu', '17java1', 110);
INSERT INTO `student` VALUES (2, 'lisi', 'male', 'aynu', '17java2', 110);
INSERT INTO `student` VALUES (3, 'wangwu', 'male', 'aynu', '17java1', 110);
INSERT INTO `student` VALUES (4, 'mali', 'female', 'aynu', '17java1', 110);
INSERT INTO `student` VALUES (5, 'tom', 'male', 'aynu', '17java2', 110);
INSERT INTO `student` VALUES (6, 'cat', 'male', 'aynu', '17java2', 110);
INSERT INTO `student` VALUES (7, 'lily', 'female', 'aynu', '17java3', 110);
INSERT INTO `student` VALUES (8, 'monica', 'female', 'aynu', '17java3', 110);
INSERT INTO `student` VALUES (9, 'luosi', 'male', 'aynu', '17java3', 110);
INSERT INTO `student` VALUES (10, 'joe', 'male', 'aynu', '17java4', 110);
INSERT INTO `student` VALUES (11, 'ruiqiu', 'female', 'aynu', '17java4', 110);
INSERT INTO `student` VALUES (12, 'feibi', 'female', 'aynu', '17java4', 110);

SET FOREIGN_KEY_CHECKS = 1;
