-- 删除表如果存在
DROP TABLE IF EXISTS `user`;

-- 创建用户表
CREATE TABLE `user`
(
    `id`         INT AUTO_INCREMENT PRIMARY KEY,
    `username`   VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名',
    `password`   VARCHAR(255) NOT NULL COMMENT '密码',
    `email`      VARCHAR(100) NOT NULL UNIQUE COMMENT '邮箱',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 插入初始数据
INSERT IGNORE INTO `user` (`username`, `password`, `email`)
VALUES
    ('user1', 'hashed_password_1', 'user1@126.com'),
    ('user2', 'hashed_password_2', 'user2@126.com'),
    ('user3', 'hashed_password_3', 'user3@126.com'),
    ('user4', 'hashed_password_4', 'user4@126.com');


-- 插入初始数据
INSERT IGNORE INTO `user` (`username`, `password`, `email`)
VALUES

    ('liheng', '123456', 'liheng2137@126.com');
