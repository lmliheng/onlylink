package org.asset.onlylinkend.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("user")
public class user {
    @TableId(type = IdType.AUTO)//### Error updating database. Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Out of range value for column 'id' at row 1
    private Long id;
    private String username;
    private String password;
    private String email;

}
