package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "service_sample")
public class ServiceSample {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "description")
    private String description;

    @TableField(value = "status")
    private String status;

    @TableField(value = "creator")
    private String creator;

    @TableField(value = "department")
    private String department;

    @TableField(value = "supervisor")
    private String supervisor;

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATOR = "creator";

    public static final String COL_DEPARTMENT = "department";

    public static final String COL_SUPERVISOR = "supervisor";
}