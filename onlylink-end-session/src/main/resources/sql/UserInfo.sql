
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `username` VARCHAR(255) NOT NULL UNIQUE COMMENT '用户名',
                        `email` VARCHAR(255) NOT NULL UNIQUE COMMENT '电子邮箱',
                        `password` VARCHAR(20) DEFAULT NULL COMMENT '密码',
                        `phone` VARCHAR(20) DEFAULT NULL COMMENT '电话号码',
                        `avatar` VARCHAR(255) DEFAULT NULL COMMENT '头像',
                        `bio` TEXT DEFAULT NULL COMMENT '个人简介',
                        `QQ` VARCHAR(20) DEFAULT NULL COMMENT 'QQ号',
                        `wechat` VARCHAR(50) DEFAULT NULL COMMENT '微信号',
                        `github` VARCHAR(255) DEFAULT NULL COMMENT 'GitHub地址',
                        `gitee` VARCHAR(255) DEFAULT NULL COMMENT 'Gitee地址',
                        `personal_website_1` VARCHAR(255) DEFAULT NULL COMMENT '个人网址1',
                        `personal_website_2` VARCHAR(255) DEFAULT NULL COMMENT '个人网址2',
                        `personal_website_3` VARCHAR(255) DEFAULT NULL COMMENT '个人网址3',
                        `personal_website_4` VARCHAR(255) DEFAULT NULL COMMENT '个人网址4',
                        `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;


INSERT INTO `user` (`username`, `email`, `phone`, `avatar`, `bio`, `QQ`, `wechat`, `github`, `gitee`, `personal_website_1`, `personal_website_2`, `personal_website_3`, `personal_website_4`)
VALUES ('lmliheng','liheng2137@126.com','13551458597','null','null','2137221994','b13551458597','https://github.com/lmliheng','https://gitee.com/liheng1111','https://liheng.work','http://hao.liheng.work',' null','null')