/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : students

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 31/10/2020 21:00:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_sex` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_birthday` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `student_phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, 'Mary', 'female', '2020-10-31 12:58:39.495000', '407-268-3258', 'BeautyMary@google.com');
INSERT INTO `student` VALUES (9, 'Nathy', 'female', '2010-04-04 16:00:00.000000', '406-965-8462', '0405@qq.com');
INSERT INTO `student` VALUES (10, 'Mark', 'male', '2001-01-09 16:00:00.000000', '452-985-0024', 'Mark@163.com');
INSERT INTO `student` VALUES (11, 'John', 'male', '2020-10-31 12:58:39.232000', '450-531-3173', 'John@google.com');

SET FOREIGN_KEY_CHECKS = 1;
