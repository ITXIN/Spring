package com.agan.boot.Controller;

import com.agan.boot.utils.ConfigProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.bcel.Const;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class User {

    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 5,max = 12,message = "用户名长度介于6到10个字符之间")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,message = "密码长度介于6到10个字符之间")
    private String password;

    @Email(message = "请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;

    private Byte sex;
    private Byte deleted;
    private Date updateTime;
    private Date createTime;

    private String[] roles;
    private String token;
    private String introduction;
    private String avatar;
    private String name;//昵称

    public static User createrUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        String[] s = {"admin", "editor"};
        user.setRoles(s);
        user.setToken("1234566");
        user.setName("Super Admin!");
        return user;
    }

}
