CREATE TABLE `ml_row_resource` (
  `id` int(11) NOT NULL,
  `sys_id` int(11) DEFAULT NULL,
  `full_name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `update_check` tinyint(1) DEFAULT '1',
  `delete_check` tinyint(1) DEFAULT '1',
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

CREATE TABLE `ml_row_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL COMMENT '主键',
  `sys_id` int(11) DEFAULT NULL COMMENT '子系统',
  `role_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色',
  `type` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT 'RUD，C功能级控制',
  `status` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `creator` tinyint(1) DEFAULT NULL COMMENT '创建者',
  `department` tinyint(1) DEFAULT NULL COMMENT '同部门',
  `sub_department` tinyint(1) DEFAULT NULL COMMENT '子部门',
  `supervisor` tinyint(1) DEFAULT NULL COMMENT '负责人',
  `all` tinyint(1) DEFAULT NULL COMMENT '全部',
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;