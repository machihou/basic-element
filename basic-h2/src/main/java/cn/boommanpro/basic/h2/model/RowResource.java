package cn.boommanpro.basic.h2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author BoomMan
 * @mail boommanpro@gmail.com
 * @description
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RowResource {
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 系统Id
     */
    private Integer sysId;
    /**
     * 类的全限定名
     */
    private String fullName;
    /**
     * 业务名称 描述
     */
    private String name;
    /**
     * 更新是否校验
     */
    private Boolean updateCheck;
    /**
     * 删除是否校验
     */
    private Boolean deleteCheck;
}
