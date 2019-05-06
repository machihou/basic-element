/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : basic-element

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 23/04/2019 21:55:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for row_resource
-- ----------------------------
DROP TABLE IF EXISTS `row_resource`;
CREATE TABLE `row_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行级权限 resource_id',
  `sys_code` int(11) NOT NULL COMMENT '系统sys_code',
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '目标类全限定名',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源描述',
  `update_check` tinyint(1) NOT NULL DEFAULT 1 COMMENT '更新操作开关',
  `delete_check` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除操作开关',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of row_resource
-- ----------------------------
INSERT INTO `row_resource` VALUES (1, 1000, 'com.boommanpro.inno.permission.demo.model.ServiceSample', '测试业务', 1, 1);
INSERT INTO `row_resource` VALUES (2, 1000, 'com.boommanpro.inno.permission.demo.model.ServiceSampleTwo', '测试业务2', 1, 1);
INSERT INTO `row_resource` VALUES (3, 1000, 'com.boommanpro.inno.permission.demo.model.ServiceSampleThree', '测试业务3', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
