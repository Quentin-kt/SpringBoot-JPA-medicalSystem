-- CREATE DATABASE medicaldbdb;
DROP DATABASE IF EXISTS `medicaldb`;
CREATE DATABASE `medicaldb`;
use
medicaldb;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 用户表
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`
(
-- Id、用户名、密码、电话、邮箱、用户身份
    `person_id`  integer     NOT NULL auto_increment,
    `name`       varchar(30) NOT NULL,
    `password`   varchar(30) NOT NULL,
    `tel`        varchar(30) NOT NULL,
    `email`      varchar(30) NOT NULL,
    `user_types` integer     NOT NULL,
    PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 患者表
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`
(
-- 证件号、证件类型、患者名、社保号、电话、状态
    `id_card`    varchar(30)  NOT NULL,
    `id_type`    varchar(30)  NOT NULL,
    `name`       varchar(30)  NOT NULL,
    `social_security_no`      varchar(30),
    `state`      varchar(30),
    PRIMARY KEY (`id_card`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;