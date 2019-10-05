SET AUTOCOMMIT = 0;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `create_at`   datetime     NOT NULL,
    `update_at`   datetime     NOT NULL,
    `avatar`      varchar(255) DEFAULT NULL,
    `full_name`   varchar(64)  DEFAULT NULL,
    `password`    varchar(128) NOT NULL,
    `username`    varchar(128) NOT NULL,
    `user_social` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `role`
(
    `id`        int(11)      NOT NULL,
    `create_at` datetime     NOT NULL,
    `update_at` datetime     NOT NULL,
    `code`      varchar(128) NOT NULL,
    `name`      varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `permission`
(
    `id`        int(11)      NOT NULL,
    `create_at` datetime     NOT NULL,
    `update_at` datetime     NOT NULL,
    `code`      varchar(128) NOT NULL,
    `name`      varchar(128) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `roles_users`
(
    `role_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    PRIMARY KEY (`role_id`, `user_id`),
    KEY `FK8ahp0knpd98f8urotdnmqoorw` (`user_id`),
    CONSTRAINT `FK8ahp0knpd98f8urotdnmqoorw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FKiekkooywvstxn9cgt1iyvorq8` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `roles_permissions`
(
    `role_id`       int(11) NOT NULL,
    `permission_id` int(11) NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`),
    KEY `FK5yjwxw2gvfyu76j3rgqwo685u` (`permission_id`),
    CONSTRAINT `FK5yjwxw2gvfyu76j3rgqwo685u` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
    CONSTRAINT `FK9h2vewsqh8luhfq71xokh4who` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO registration_service.`user`
(avatar, create_at, full_name, password, update_at, username, user_social)
VALUES (NULL, CURRENT_TIMESTAMP, NULL, '$2a$10$hwm3jwNcsFhIfqeOKHAwJOpo1FaJFL8jjA9w0WflyTrG55km7jpU6',
        CURRENT_TIMESTAMP, '0988123123', NULL);

SET FOREIGN_KEY_CHECKS = 1;

COMMIT;