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

 Date: 23/04/2019 21:55:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for row_permission
-- ----------------------------
DROP TABLE IF EXISTS `row_permission`;
CREATE TABLE `row_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 行级 permission_id',
  `resource_id` int(11) NOT NULL COMMENT '对应 row_resource_id',
  `sys_code` int(11) NULL DEFAULT NULL COMMENT '子系统 id',
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '角色',
  `type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT 'RUD，C功能级控制',
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '状态',
  `creator` tinyint(1) NULL DEFAULT NULL COMMENT '创建者',
  `department` tinyint(1) NULL DEFAULT NULL COMMENT '同部门',
  `sub_department` tinyint(1) NULL DEFAULT NULL COMMENT '子部门',
  `supervisor` tinyint(1) NULL DEFAULT NULL COMMENT '负责人',
  `all_owner` tinyint(1) NULL DEFAULT NULL COMMENT '全部',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of row_permission
-- ----------------------------
INSERT INTO `row_permission` VALUES (1, 1, 1000, 'master', 'R', '已发货', 0, 0, 0, 0, 0);
INSERT INTO `row_permission` VALUES (2, 1, 1000, 'slave', 'R', '未发货', 0, 0, 0, 0, 0);
INSERT INTO `row_permission` VALUES (3, 1, 1000, 'other', 'R', '取消', 0, 0, 0, 0, 0);
INSERT INTO `row_permission` VALUES (4, 1, 1000, 'master', 'U', '已发货', 0, 0, 0, 0, 1);
INSERT INTO `row_permission` VALUES (5, 1, 1000, 'slave', 'U', '未发货', 0, 0, 0, 0, 1);
INSERT INTO `row_permission` VALUES (6, 1, 1000, 'other', 'U', '取消', 0, 0, 0, 0, 1);
INSERT INTO `row_permission` VALUES (10, 1, 1000, 'master', 'D', '已发货', 0, 0, 0, 0, 1);
INSERT INTO `row_permission` VALUES (11, 1, 1000, 'slave', 'D', '未发货', 0, 0, 0, 0, 1);
INSERT INTO `row_permission` VALUES (12, 1, 1000, 'other', 'D', '取消', 0, 0, 0, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
