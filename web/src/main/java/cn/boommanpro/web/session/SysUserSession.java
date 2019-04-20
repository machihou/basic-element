package cn.boommanpro.web.session;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Admin
 */
@Data
public class SysUserSession implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

}
