package org.asset.onlylinkend.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("user")
public class userInfo {
    @TableId(type = IdType.AUTO)
//### Error updating database. Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Out of range value for column 'id' at row 1
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String avatar;
    private String bio;
    private String QQ; // 或者使用 QQ
    private String wechat;
    private String github;
    private String gitee;
    private String personal_Website_1;
    private String personal_Website_2;
    private String personal_Website_3;
    private String personal_Website_4;

}

