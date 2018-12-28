/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-12-28 19:22:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth2_client
-- ----------------------------
DROP TABLE IF EXISTS `oauth2_client`;
CREATE TABLE `oauth2_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(100) DEFAULT NULL COMMENT '客戶端名稱',
  `client_id` varchar(100) DEFAULT NULL COMMENT '客戶端ID',
  `client_secret` varchar(100) DEFAULT NULL COMMENT '客户端安全key',
  PRIMARY KEY (`id`),
  KEY `idx_oauth2_client_client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth2_client
-- ----------------------------
INSERT INTO `oauth2_client` VALUES ('1', 'oauth-client', 'c1ebe466-1cdc-4bd3-ab69-77c3561b9dee', 'd8346ea2-6017-43ed-ad68-19c0f971738b');

-- ----------------------------
-- Table structure for oauth2_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth2_code`;
CREATE TABLE `oauth2_code` (
  `code` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth2_code
-- ----------------------------
INSERT INTO `oauth2_code` VALUES ('c8c68089eee6c529cdaa186be87a04ab', 'admin');
INSERT INTO `oauth2_code` VALUES ('34ca1603cb14472ecbd28a71c16c861e', 'admin');
INSERT INTO `oauth2_code` VALUES ('237e0b22f1c4f6d1eb0e4da501b77750', 'admin');
INSERT INTO `oauth2_code` VALUES ('a6efeaaaf96bdfb6216900dfa322767d', 'admin');
INSERT INTO `oauth2_code` VALUES ('1b74c4020ecc0e4b9b8ac2b7ed2afeba', 'admin');
INSERT INTO `oauth2_code` VALUES ('2eb4161639734e3aa00367ccdaeb0343', 'admin');
INSERT INTO `oauth2_code` VALUES ('d8a02a3dc6441f45acb2adddb79984a2', 'admin');
INSERT INTO `oauth2_code` VALUES ('47d3e89ce4081f7d2c873e1d40c55f21', 'admin');
INSERT INTO `oauth2_code` VALUES ('55ccd1bf691377ca36dc86c83b46eed8', 'admin');
INSERT INTO `oauth2_code` VALUES ('7508b914e7fc3fbc4ef80570e509b74c', 'admin');

-- ----------------------------
-- Table structure for oauth2_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth2_token`;
CREATE TABLE `oauth2_token` (
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth2_token
-- ----------------------------
INSERT INTO `oauth2_token` VALUES ('2cc5ab780f834d677bec7b45925f5afb', 'admin');
INSERT INTO `oauth2_token` VALUES ('74290a3ae47e048a745411b978a6a056', 'admin');
INSERT INTO `oauth2_token` VALUES ('276ea931b1f6e8f1aaa5fad7a5b2cc53', 'admin');
INSERT INTO `oauth2_token` VALUES ('fc4e71de2f2e96bacdc2c30ee361bdd3', 'admin');
INSERT INTO `oauth2_token` VALUES ('71d030718e907f1c75e8b3055d6059a3', 'admin');
INSERT INTO `oauth2_token` VALUES ('5f08d4d5d8d9430534cc0f85cdb0033b', 'admin');
INSERT INTO `oauth2_token` VALUES ('82ba42af236e0dc7597906f67ccb4fd4', 'admin');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(255) NOT NULL COMMENT '权限id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级权限id',
  `type` int(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('32', 'aae1d97fe7244d6f9e0651a0707e58f7', 'role_code', null, '/api/shiro/test1', null, '0', '0', '0', null, '1', null, null);
INSERT INTO `permission` VALUES ('33', '29f290701b6b425eb2bae92911123e24', 'role_as', null, '/api/shiro/test2', null, '0', '0', '0', null, '1', null, null);
INSERT INTO `permission` VALUES ('34', '23fb776961a84267a7e66050f3abb100', 'role_dfd', null, '/api/shiro/test3', null, '0', '0', '0', null, '1', null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('5', 'd020f57aca764d45b045f8ba2df72568', 'ylchen', null, '1', null, null);
INSERT INTO `role` VALUES ('6', 'ff81918c889d427c8eab38acecd8f6f0', 'admin', null, '1', null, null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL COMMENT '角色id',
  `permission_id` varchar(255) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=873 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('869', 'd020f57aca764d45b045f8ba2df72568', 'aae1d97fe7244d6f9e0651a0707e58f7');
INSERT INTO `role_permission` VALUES ('870', 'd020f57aca764d45b045f8ba2df72568', '29f290701b6b425eb2bae92911123e24');
INSERT INTO `role_permission` VALUES ('871', 'd020f57aca764d45b045f8ba2df72568', '23fb776961a84267a7e66050f3abb100');
INSERT INTO `role_permission` VALUES ('872', 'ff81918c889d427c8eab38acecd8f6f0', 'aae1d97fe7244d6f9e0651a0707e58f7');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `res_name` varchar(50) DEFAULT NULL,
  `res_type` varchar(10) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', null, '系统管理', 'menu', 'system', null);
INSERT INTO `sys_permission` VALUES ('2', '1', '用户管理', 'menu', 'systemUserList', '/user/userList');
INSERT INTO `sys_permission` VALUES ('3', '1', '角色管理', 'menu', 'systemRole', '/roles');
INSERT INTO `sys_permission` VALUES ('4', null, '一级菜单', 'menu', 'menu', null);
INSERT INTO `sys_permission` VALUES ('5', '4', '二级菜单1', 'menu', 'menuXxx', '/xxx');
INSERT INTO `sys_permission` VALUES ('6', '4', '二级菜单2', 'menu', 'menuYyy', '/yyy');
INSERT INTO `sys_permission` VALUES ('7', '2', '用户添加', 'button', 'systemUserAdd', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '用户管理员');
INSERT INTO `sys_role` VALUES ('2', '普通用户');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '5');
INSERT INTO `sys_role_permission` VALUES ('1', '6');
INSERT INTO `sys_role_permission` VALUES ('1', '7');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `full_name` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'zhangsan', '张三', '86fb1b048301461bdc71d021d2af3f97', '1');
INSERT INTO `sys_user` VALUES ('2', 'lisi', '李四', 'c9351e5cf153923f052ebe1462cca93a', '2');
INSERT INTO `sys_user` VALUES ('3', 'wangwu', '王五', '92262648696eae1b0a321cbd2b238bf2', '3');
INSERT INTO `sys_user` VALUES ('4', 'user1', '用户1', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('5', 'user2', '用户2', '86fb1b048301461bdc71d021d2af3f97', '5');
INSERT INTO `sys_user` VALUES ('6', 'user3', '用户3', '86fb1b048301461bdc71d021d2af3f97', '5');
INSERT INTO `sys_user` VALUES ('7', 'user4', '用户4', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('8', 'user5', '用户5', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('9', 'user6', '用户6', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('10', 'user7', '用户7', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('11', 'user8', '用户8', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('12', 'user9', '用户9', '86fb1b048301461bdc71d021d2af3f97', '4');
INSERT INTO `sys_user` VALUES ('13', 'user10', '用户10', '86fb1b048301461bdc71d021d2af3f97', '4');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL,
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `sex` int(255) DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `status` int(1) NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('25', '8cdc1d0b43394329b601dab75ade79a2', 'ylchen', '033f56c54fed03134c414b44b215bf51', null, null, null, '0', '0', '0', '2018-12-20 10:22:37', null, null);
INSERT INTO `user` VALUES ('26', '0c3f8bf664ca4460a533b8359ed98e12', 'admin', '8ac74c2b738c76527d877f7870b3eb6e', '6dd8f4eced55833d2cf5fc4830c97721', null, null, '0', '0', '0', '2018-12-20 10:25:24', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  `role_id` varchar(255) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2', '8cdc1d0b43394329b601dab75ade79a2', 'd020f57aca764d45b045f8ba2df72568');
INSERT INTO `user_role` VALUES ('3', '0c3f8bf664ca4460a533b8359ed98e12', 'ff81918c889d427c8eab38acecd8f6f0');
