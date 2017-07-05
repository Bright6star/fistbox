/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : project3

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-07 18:26:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `brandName` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `favorablePrice` double(10,2) DEFAULT NULL,
  `groundingDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `storage` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `typeCode` varchar(255) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `typeCode` (`typeCode`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`typeCode`) REFERENCES `goodstype` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '15款起亚k2/k3/k4/k5/Kx3/狮跑/KX5/ 智跑底盘3D发动机下护板钢', '5465465635', '125.00', '100.00', '2017-05-27 14:42:16', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:42:16');
INSERT INTO `goods` VALUES ('2', '15款起亚k2/k3/k4/k5/Kx3/狮跑/KX5/ 智跑底盘3D发动机下护板钢', '5465465635', '125.00', '100.00', '2017-05-27 14:42:16', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:42:16');
INSERT INTO `goods` VALUES ('3', '15款起亚k2/k3/k4/k5/Kx3/狮跑/KX5/ 智跑底盘3D发动机下护板钢', '5465465635', '125.00', '100.00', '2017-05-27 14:42:18', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:42:18');
INSERT INTO `goods` VALUES ('4', '33312', '5465465635', '0.01', '0.01', '2017-06-06 09:36:26', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-06-06 09:36:26');
INSERT INTO `goods` VALUES ('5', '3789798', '5455454', '1.00', '1.00', '2017-05-27 00:00:00', '2', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 00:00:00');
INSERT INTO `goods` VALUES ('6', '33312', '5465465635', '125.00', '100.00', '2017-05-27 14:41:41', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:41:41');
INSERT INTO `goods` VALUES ('8', '33312', '5465465635', '125.00', '100.00', '2017-05-27 14:41:41', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:41:41');
INSERT INTO `goods` VALUES ('9', '33312', '5465465635', '125.00', '100.00', '2017-05-27 14:41:42', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:41:42');
INSERT INTO `goods` VALUES ('10', '33312', '5465465635', '125.00', '100.00', '2017-05-27 14:41:43', '1', 'images/2_shop_15.jpg', 'fgghg', '001', '2017-05-27 14:41:43');
INSERT INTO `goods` VALUES ('12', '路虎底盘', '路虎', '12.00', '10.00', '2017-05-24 15:38:48', '1', 'timg.jpg', '<p>路虎底盘安全的保证，保证翻车</p>', '005', '2017-05-24 15:38:48');
INSERT INTO `goods` VALUES ('13', 'bbc', '魔音', '999.00', '998.00', '2017-05-24 15:38:52', '1', 'timg.jpg', '<p>豆腐干风格和</p>', '004', '2017-05-24 15:38:52');
INSERT INTO `goods` VALUES ('14', '大方地说v', '魔音', '999.00', '998.00', '2017-05-23 00:00:00', '1', 'timg.jpg', '<p>unscyers额urytrjptcugreihgynugftx客户佛店铺一个8额uief</p>', '007', '2017-05-23 14:39:26');
INSERT INTO `goods` VALUES ('15', '新品', '新品推荐', '1.00', '0.01', '2017-06-07 15:22:01', '100', 'images/xp.gif', '<p>好用上手，威力不小 轻松破窗，易于存放 越简单，越实用！ 危急时刻一个安全锤 =一个逃生的希望！</p>', '010', '2017-06-07 15:22:01');
INSERT INTO `goods` VALUES ('16', '新品', '新品推荐', '1.00', '0.01', '2017-06-07 15:22:28', '100', 'images/xp1.gif', '<p>出家旅行，威力不小 轻松破窗，易于存放 越简单，越实用！ 危急时刻一个安全锤 =一个逃生的希望！</p>', '010', '2017-06-07 15:22:28');
INSERT INTO `goods` VALUES ('17', '新品', '新品推荐', '1.00', '0.01', '2017-06-07 15:22:42', '100', 'images/1_index_18.gif', '<p>必备物品，威力不小 轻松破窗，易于存放 越简单，越实用！ 危急时刻一个安全锤 =一个逃生的希望！</p>', '010', '2017-06-07 15:22:42');
INSERT INTO `goods` VALUES ('18', '新品', '新品推荐', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_19.gif', '<p>产品虽小，威力不小 轻松破窗，易于存放 越简单，越实用！ 危急时刻一个安全锤 =一个逃生的希望！</p>', '010', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('19', '新品右大', '新品推荐', '1.00', '0.01', '2017-06-07 14:57:30', '100', 'images/hh.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '010', '2017-06-07 14:57:30');
INSERT INTO `goods` VALUES ('20', '热卖左大', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_24.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('21', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('22', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('23', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('24', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('25', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('26', '热卖', '热卖产品', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_30.gif', '新款促销！厂家特价5折 出售！ 品质见证，放心购买！买 此款还送：方向盘套 擦车毛巾香包 静电 贴 4样礼品！', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('27', '夏日', '夏日必备', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_34.jpg', '汽车坐垫 夏季 女汽车坐垫四季通用全包 车座垫手编冰丝凉垫坐垫夏季冰丝坐垫 <span>手勾工艺</span>', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('28', '夏日', '夏日必备', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_34.jpg', '汽车坐垫 夏季 女汽车坐垫四季通用全包 车座垫手编冰丝凉垫坐垫夏季冰丝坐垫 <span>手勾工艺</span>', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('29', '夏日', '夏日必备', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_34.jpg', '汽车坐垫 夏季 女汽车坐垫四季通用全包 车座垫手编冰丝凉垫坐垫夏季冰丝坐垫 <span>手勾工艺</span>', '011', '2017-06-07 00:00:00');
INSERT INTO `goods` VALUES ('30', '夏日', '夏日必备', '1.00', '0.01', '2017-06-07 00:00:00', '100', 'images/1_index_34.jpg', '汽车坐垫 夏季 女汽车坐垫四季通用全包 车座垫手编冰丝凉垫坐垫夏季冰丝坐垫 <span>手勾工艺</span>', '011', '2017-06-07 00:00:00');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `code` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('001', '汽车保养', '#');
INSERT INTO `goodstype` VALUES ('002', '应急用品', '#');
INSERT INTO `goodstype` VALUES ('003', '内部装饰', '#');
INSERT INTO `goodstype` VALUES ('004', '外观改装', '/searchs');
INSERT INTO `goodstype` VALUES ('005', '座垫/脚垫', '#');
INSERT INTO `goodstype` VALUES ('006', '清洁用品', '#');
INSERT INTO `goodstype` VALUES ('007', '音响改装', '#');
INSERT INTO `goodstype` VALUES ('008', '儿童用品', '#');
INSERT INTO `goodstype` VALUES ('009', '新车必备', '#');
INSERT INTO `goodstype` VALUES ('010', '新品推荐', '#');
INSERT INTO `goodstype` VALUES ('011', '热卖产品', '#');
INSERT INTO `goodstype` VALUES ('012', '夏日必备', '#');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sendDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `tradingStatus` int(11) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `alipay` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('13', 'luBiao_1_20170606092235', '2017-06-07 17:35:50', '2017-06-07 17:35:50', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('14', 'luBiao_1_20170606093638', '2017-06-07 17:35:49', '2017-06-07 17:35:49', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('15', 'luBiao_1_20170606095252', '2017-06-07 17:35:48', '2017-06-07 17:35:48', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('16', 'luBiao_1_20170606100311', '2017-06-07 17:35:47', '2017-06-07 17:35:47', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('17', 'luBiao_1_20170606100704', '2017-06-07 17:35:46', '2017-06-07 17:35:46', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('18', 'luBiao_1_20170606101124', '2017-06-07 17:35:45', '2017-06-07 17:35:45', '0', '0.01', '1', '1');
INSERT INTO `order` VALUES ('19', 'luBiao_1_20170606101615', '2017-06-06 10:17:08', '2017-06-06 10:17:08', '1', '0.01', '1', '1');
INSERT INTO `order` VALUES ('20', 'luBiao_1_20170607181544', '2017-06-07 18:15:45', null, '0', '400', '1', '0');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderId` int(11) NOT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('13', '4', '1');
INSERT INTO `orderitem` VALUES ('14', '4', '1');
INSERT INTO `orderitem` VALUES ('15', '4', '1');
INSERT INTO `orderitem` VALUES ('16', '4', '1');
INSERT INTO `orderitem` VALUES ('17', '4', '1');
INSERT INTO `orderitem` VALUES ('18', '4', '1');
INSERT INTO `orderitem` VALUES ('19', '4', '1');
INSERT INTO `orderitem` VALUES ('20', '2', '4');

-- ----------------------------
-- Table structure for picturecarousel
-- ----------------------------
DROP TABLE IF EXISTS `picturecarousel`;
CREATE TABLE `picturecarousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imageUrl` varchar(500) DEFAULT NULL,
  `requestUrl` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picturecarousel
-- ----------------------------
INSERT INTO `picturecarousel` VALUES ('1', '/images/pic/banner.jpg', '/detail?id=1');
INSERT INTO `picturecarousel` VALUES ('2', '/images/pic/banner1.jpg', '/detail?id=2');
INSERT INTO `picturecarousel` VALUES ('3', '/images/pic/banner2.jpg', '/detail?id=3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `activeStatus` int(1) DEFAULT '0',
  `activeCode` varchar(255) DEFAULT NULL,
  `root` int(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', 'cjh_dodi@163.com', '13929950000', '超鸡棒', '1', '2000-01-01 12:13:14', '广东省', '广州市', '天河区', '2017-05-16 14:34:50', '1', '1494561350287', '0');
INSERT INTO `user` VALUES ('2', 'cjh123', '123456', 'cjh_dodi@163.com', '13929950000', '乱码大军', null, '2000-01-01 00:00:00', '广东省', '广州市', '天河区石牌桥天竣阁162号', '2017-06-06 14:15:44', '0', '1494561350287', '1');
