package cn.boommanpro.basic.h2.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author BoomMan
 * @mail boommanpro@gmail.com
 * @description
 */
@Data
@Entity
public class RowPermission {
    /**
     * 主键Id
     */
    @Id
    @GeneratedValue
    private Integer id;

    private Integer resourceId;
    /**
     * 当前操作类型 RUD ? ,C功能级控制
     */
    private String type;
    /**
     * 子系统
     */
    private Integer sysId;
    /**
     * 角色
     */
    private String roleName;
    /**
     * 业务表状态字段 一致
     */
    private String status;
    /**
     * 是否根据创建者查询
     */
    private Boolean creator;
    /**
     * 部门查询
     */
    private Boolean department;
    /**
     * 子部门查询
     */
    private Boolean subDepartment;
    /**
     * 监督者查询
     */
    private Boolean supervisor;
    /**
     * 所有用户都可查询
     */
    private Boolean all;
}
