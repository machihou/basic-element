package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "row_resource")
@NoArgsConstructor
@AllArgsConstructor
public class RowResource {
    /**
     * 行级权限 resource_id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 系统sys_code
     */
    @TableField(value = "sys_code")
    private Integer sysCode;

    /**
     * 目标类全限定名
     */
    @TableField(value = "full_name")
    private String fullName;

    /**
     * 资源描述
     */
    @TableField(value = "name")
    private String name;

    /**
     * 更新操作开关
     */
    @TableField(value = "update_check")
    private Boolean updateCheck;

    /**
     * 删除操作开关
     */
    @TableField(value = "delete_check")
    private Boolean deleteCheck;

    public static final String COL_SYS_CODE = "sys_code";

    public static final String COL_FULL_NAME = "full_name";

    public static final String COL_NAME = "name";

    public static final String COL_UPDATE_CHECK = "update_check";

    public static final String COL_DELETE_CHECK = "delete_check";
}