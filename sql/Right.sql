/*
 Navicat Premium Data Transfer

 Source Server         : Ben
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : actualcombat02

 Target Server Type    : MySQL
 Target Server Version : 50799
 File Encoding         : 65001

 Date: 05/01/2021 19:41:55
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phoneNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of member
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES ('1', '张三', '小三', '18888888', 'zs@qq.com'), ('2', '李四', '小四', '28888888', 'ls@163.com');
COMMIT;

-- ----------------------------
-- Table structure for order_traveller
-- ----------------------------
DROP TABLE IF EXISTS `order_traveller`;
CREATE TABLE `order_traveller`  (
  `orderId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `travellerId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`orderId`, `travellerId`) USING BTREE,
  INDEX `travellerId`(`travellerId`) USING BTREE,
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of order_traveller
-- ----------------------------
BEGIN;
INSERT INTO `order_traveller` VALUES ('1', '1');
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号、不为空、唯一',
  `orderTime` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `peopleCount` int(11) NULL DEFAULT NULL COMMENT '出行人数',
  `orderDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单描述(其它信息)',
  `payType` int(11) NULL DEFAULT NULL COMMENT '支付方式(0：支付宝；1：微信；2：其它)',
  `orderStatus` int(11) NULL DEFAULT NULL COMMENT '订单状态(0：未支付：1：已支付)',
  `productId` int(11) NULL DEFAULT NULL COMMENT '产品id 外键',
  `memberId` int(11) NULL DEFAULT NULL COMMENT '会员(联系人）id 外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES ('1', '12345', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 4, 1), ('2', '54321', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 4, 1), ('3', '67890', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 5, 1), ('4', '98765', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 5, 1), ('5', '11111', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 5, 1), ('6', '22222', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 5, 1), ('7', '33333', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 6, 1), ('8', '44444', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 6, 1), ('9', '55555', '2018-03-02 12:00:00', 2, '没什么', 0, 1, 6, 1);
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (1, '查询全部用户数据', '/user/queryAll'), (2, '根据ID查询数据', '/user/queryDetailById'), (3, '仅浏览', '/***'), (4, '新增', '/add'), (5, '删除', '/delete'), (6, '修改', '/update'), (7, '查询', '/query');
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品编号，唯一，不为空',
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称（路线名称）',
  `cityName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出发城市',
  `DepartureTime` datetime(0) NULL DEFAULT NULL COMMENT '出发时间',
  `productPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '产品价格',
  `productDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品描述',
  `productStatus` int(255) NULL DEFAULT NULL COMMENT '状态(0 关闭 1 开启)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (4, 'BenBen-10', '代号10', '地点10', '2020-06-16 13:45:00', 1212.00, '1212', 1), (5, 'BenBen-11', '代号11', '地点11', '2020-05-04 08:40:00', 3232.00, '3232', 1), (6, 'BenBen-12', '代号12', '地点12', '2020-03-08 12:22:09', 2323.00, '3232', 1);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `roleDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'ADMIN', 'SystemManager'), (2, 'USER', 'OrdinaryUser'), (3, '新游客', '不再有查看功能，再添加一个浏览功能');
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限ID',
  `roleId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES (1, '1', '01'), (2, '1', '02'), (3, '2', '01'), (4, '4', '3'), (5, '5', '3');
COMMIT;

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitTime` datetime(0) NULL DEFAULT NULL COMMENT '在什么时候访问',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '谁访问',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问IP',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问了那个路径',
  `executionTime` int(11) NULL DEFAULT NULL COMMENT '资源被访问了多久',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体访问了那个方法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of syslog
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for traveller
-- ----------------------------
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phoneNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `credentialsType` int(11) NULL DEFAULT NULL COMMENT '证件类型（0：身份证；1：护照；2：军官证）',
  `travellerType` int(11) NULL DEFAULT NULL COMMENT '旅客类型（人群）【0：成人；1：儿童】',
  `credentialsNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of traveller
-- ----------------------------
BEGIN;
INSERT INTO `traveller` VALUES ('1', '张龙', '男', '13333333', 0, 0, '111222333'), ('2', '成龙', '男', '23333333', 0, 0, '444555666');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `roleId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, '1', '01'), (2, '1', '02'), (3, '63', '2'), (4, '63', '3'), (5, '1', '3');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phoneNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态0 未开启 1 开启',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'ben@qq.com', 'Ben', '$2a$10$noYcg4OwCzIZjKy0.ELlXORJJ8XbwXYgPbSjUStyKO0dAVag3h02C', '133333', 1), (63, 'alex@163.com', 'Alex', '$2a$10$WIq.6wiuqKC0D3yj9evBW.ql3TZmxm4VebHG/r0JoEd.0hXZl/9Ea', '233333', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
