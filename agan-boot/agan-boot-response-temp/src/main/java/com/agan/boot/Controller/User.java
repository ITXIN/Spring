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

@Data
@NoArgsConstructor
public class User {

    private Integer id;
    @NotEmpty(message = "phone")
    @Length(min = 6,max = 12,message = "{user.name.size}")
    private String name;

    @NotEmpty(message = "${user.password.notnull}")
    @Length(min = 6,message = "{user.password.size}")
    private String password;

    @Email(message = "请输入正确的邮箱")
    private String email;

    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;

    private Byte sex;
    private Byte deleted;
    private Date updateTime;
    private Date createTime;

}
