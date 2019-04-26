CREATE TABLE `row_resource`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '行级权限 resource_id',
                                 `sys_code` int(11) NOT NULL COMMENT '系统sys_code',
                                 `full_name` varchar(100)      NOT NULL COMMENT '目标类全限定名',
                                 `name` varchar(32)   NOT NULL COMMENT '资源描述',
                                 `update_check` tinyint(1) NOT NULL DEFAULT 1 COMMENT '更新操作开关',
                                 `delete_check` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除操作开关',
                                 PRIMARY KEY (`id`)
) ;


CREATE TABLE `row_permission`  (
                                   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 行级 permission_id',
                                   `resource_id` int(11) NOT NULL COMMENT '对应 row_resource_id',
                                   `sys_code` int(11) NULL DEFAULT NULL COMMENT '子系统 id',
                                   `role_name` varchar(32)  NULL DEFAULT NULL COMMENT '角色',
                                   `type` varchar(16) NOT NULL COMMENT 'RUD，C功能级控制',
                                   `status` varchar(32)  NULL DEFAULT NULL COMMENT '状态',
                                   `creator` tinyint(1) NULL DEFAULT NULL COMMENT '创建者',
                                   `department` tinyint(1) NULL DEFAULT NULL COMMENT '同部门',
                                   `sub_department` tinyint(1) NULL DEFAULT NULL COMMENT '子部门',
                                   `supervisor` tinyint(1) NULL DEFAULT NULL COMMENT '负责人',
                                   `all_owner` tinyint(1) NULL DEFAULT NULL COMMENT '全部',
                                   PRIMARY KEY (`id`)
) ;