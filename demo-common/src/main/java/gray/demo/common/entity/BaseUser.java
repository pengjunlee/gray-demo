package gray.demo.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2024-03-08 22:10:11
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
    private Boolean type;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人ID，名称
     */
    private String creBy;

    /**
     * 创建时间
     */
    private Date creTime;

    /**
     * 修改人ID，名称
     */
    private String updBy;

    /**
     * 修改时间
     */
    private Date updTime;

    /**
     * 删除人ID，名称
     */
    private String delBy;

    /**
     * 删除时间
     */
    private Long delTime;

    /**
     * 和风天气的位置, 官方文档:https://github.com/qwd/LocationList/blob/master/China-City-List-latest.csv
     */
    private String location;


}
