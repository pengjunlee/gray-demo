package gray.demo.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-11 17:05:37
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("base_user")
public class BaseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户类型: 1:管理员; 2:普通用户; 3:只读用户;
     */
    @TableField("type")
    private Boolean type;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 密码加盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 用户头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建人ID，名称
     */
    @TableField("cre_by")
    private String creBy;

    /**
     * 创建时间
     */
    @TableField("cre_time")
    private Date creTime;

    /**
     * 修改人ID，名称
     */
    @TableField("upd_by")
    private String updBy;

    /**
     * 修改时间
     */
    @TableField("upd_time")
    private Date updTime;

    /**
     * 删除人ID，名称
     */
    @TableField("del_by")
    private String delBy;

    /**
     * 删除时间
     */
    @TableField("del_time")
    private Long delTime;

    /**
     * 和风天气的位置, 官方文档:https://github.com/qwd/LocationList/blob/master/China-City-List-latest.csv
     */
    @TableField("location")
    private String location;
}
