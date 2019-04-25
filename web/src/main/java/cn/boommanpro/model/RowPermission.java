package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "row_permission")
public class RowPermission implements Serializable {
    private static final long serialVersionUID = 7363056553498068300L;
    /**
     * 主键 行级 permission_id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应 row_resource_id
     */
    @TableField(value = "resource_id")
    private Integer resourceId;

    /**
     * 子系统 id
     */
    @TableField(value = "sys_code")
    private Integer sysCode;

    /**
     * 角色
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * RUD，C功能级控制
     */
    @TableField(value = "type")
    private String type;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 创建者
     */
    @TableField(value = "creator")
    private Boolean creator;

    /**
     * 同部门
     */
    @TableField(value = "department")
    private Boolean department;

    /**
     * 子部门
     */
    @TableField(value = "sub_department")
    private Boolean subDepartment;

    /**
     * 负责人
     */
    @TableField(value = "supervisor")
    private Boolean supervisor;

    /**
     * 全部
     */
    @TableField(value = "all_owner")
    private Boolean allOwner;

    public static final String COL_RESOURCE_ID = "resource_id";

    public static final String COL_SYS_CODE = "sys_code";

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_TYPE = "type";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR = "creator";

    public static final String COL_DEPARTMENT = "department";

    public static final String COL_SUB_DEPARTMENT = "sub_department";

    public static final String COL_SUPERVISOR = "supervisor";

    public static final String COL_ALL_OWNER = "all_owner";
}