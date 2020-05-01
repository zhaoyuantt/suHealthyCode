/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : gshealthycode

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-05-01 15:46:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` char(32) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `code` char(32) COLLATE utf8_bin NOT NULL COMMENT '代码',
  `is_parent` tinyint(1) NOT NULL COMMENT '0 不是父节点 1 是父节点',
  `parent_id` char(32) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '该父节点id，如果为父节点，则为0',
  `sort_num` smallint(6) DEFAULT NULL COMMENT '排序规则',
  `remark` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics`;
CREATE TABLE `t_statistics` (
  `id` char(32) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '',
  `id_card` char(18) COLLATE utf8_bin NOT NULL,
  `phone_number` char(11) COLLATE utf8_bin NOT NULL COMMENT '',
  `number_verification_code` char(6) COLLATE utf8_bin NOT NULL COMMENT '手机验证码',
  `household_register` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '',
  `household_register_code` char(32) COLLATE utf8_bin NOT NULL,
  `is_leave_gansu` tinyint(1) NOT NULL COMMENT '',
  `is_fever` tinyint(1) NOT NULL COMMENT '',
  `code_path` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '',
  `code_color` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_verification_code
-- ----------------------------
DROP TABLE IF EXISTS `t_verification_code`;
CREATE TABLE `t_verification_code` (
  `id` char(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '',
  `phone_number` char(11) NOT NULL,
  `verification_code` char(6) NOT NULL COMMENT '验证码',
  `is_verification` tinyint(1) DEFAULT NULL COMMENT '是否验证成功 0：无 1：是',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
