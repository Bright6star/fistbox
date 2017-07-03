/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : text

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-03 14:19:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publishDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publishStatus` varchar(255) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '招聘信息', '招聘招聘招聘fgnvesjvggvjksuigch erjkgveskgvherjktvhncfgierjyhegcfrselatvhueriarynectreuisltgveabjcfgrseuaivtfhnubfrahgsv', '2017-04-20 15:58:13', '2017-04-20 15:58:13', '1', '1', '1');
INSERT INTO `notice` VALUES ('2', '培训信息', '招聘招聘fewgyrtfesanrtfgeukseiltngueithvuerioatvgniseultestvugsiewal.gcfentfvebrejslgvnreustvbs', '2017-04-20 15:58:23', '2017-04-20 15:58:23', '1', '2', '1');
INSERT INTO `notice` VALUES ('3', 'hsfiid东风浩荡 ', '<p>你撒的窘摆上哟个v啊手机频道撒旦法 你家飞车无i啊超过发怒一分超过北外如此耶稣vhwegyahrcbgfnwaerutvhjuewriariv  然后侧suit个女友长头发能够维持太久啊饿如同hue日啊女热碎骨推测uiltgvuir规范&nbsp;</p>', '2017-04-20 15:58:39', '2017-04-20 15:58:39', '1', '3', '1');
INSERT INTO `notice` VALUES ('6', 'asdfsdggv', '<p>j;klyhmnedtbheasnrgna</p>', '2017-04-19 17:18:31', '2017-04-19 17:18:31', '1', '1', '1');
INSERT INTO `notice` VALUES ('7', '大方地说v', '<p>局域网vttyh怒他任务就要你编辑特</p>', '2017-04-19 17:18:12', '2017-04-19 17:18:13', '1', '2', '1');
INSERT INTO `notice` VALUES ('8', 'dggfjhbt', '<p>yvtwy6jn6iwebu</p>', '2017-04-19 17:17:14', '2017-04-19 17:17:15', '1', '3', '1');
INSERT INTO `notice` VALUES ('10', 'tyabvrteny', '<p>tnwysvretybrtuybw</p>', '2017-04-18 16:00:07', '2017-04-18 16:00:07', '1', '1', '2');
INSERT INTO `notice` VALUES ('11', 'gtadfscger', '<p>gernjuyrfhbsarcrger</p>', '2017-04-18 16:00:08', '2017-04-18 16:00:08', '1', '1', '2');
INSERT INTO `notice` VALUES ('12', 'gfeyhb', '<p>rfghvtyerb</p>', '2017-04-18 16:00:09', '2017-04-18 16:00:09', '1', '1', '3');
INSERT INTO `notice` VALUES ('13', 'sdfgb', '<p>wrrtnjurkmt,l</p>', '2017-04-18 16:00:10', '2017-04-18 16:00:10', '1', '1', '3');
INSERT INTO `notice` VALUES ('14', 'fgbdge', '<p>srvyhtefwrdewrfvnvd</p>', '2017-04-18 16:00:14', '2017-04-18 16:00:14', '1', '1', '3');
INSERT INTO `notice` VALUES ('15', 'triu,t', '<p>sehnplotrbsvg</p>', '2017-04-18 16:00:14', '2017-04-18 16:00:14', '1', '1', '3');
INSERT INTO `notice` VALUES ('16', 'trrhyrgbv', '<p>ghbyetjnuedgtew5yh56u7</p>', '2017-04-18 16:00:14', '2017-04-18 16:00:14', '1', '2', '1');
INSERT INTO `notice` VALUES ('21', '好气哦', '<p>的vfgrenercfewq vqreves</p>', '2017-04-18 16:00:14', '2017-04-18 16:00:14', '1', '2', '1');
INSERT INTO `notice` VALUES ('22', '你好过分你觉得', '<p>彩色vgtrwbrvw让vgsevsae</p>', '2017-04-18 15:58:06', '2017-04-18 15:58:07', '1', '3', '1');
INSERT INTO `notice` VALUES ('23', 'nbujhftgm', '<p>nyrfuyf,ikuyg,</p>', '2017-04-18 16:00:17', '2017-04-18 16:00:17', '1', '3', '1');
INSERT INTO `notice` VALUES ('24', '222', '222', '2017-04-18 16:11:18', '2017-04-18 16:11:18', '1', '3', '1');
INSERT INTO `notice` VALUES ('25', 'tyuhjym', 'bjyufimkyt', '2017-04-18 15:13:11', null, '0', '2', '1');
INSERT INTO `notice` VALUES ('26', 'b mnhg gmdj', 'nbdgnjydfvfdsvcfgbdesacvfdsvf', '2017-04-18 15:14:14', null, '0', '2', '1');
INSERT INTO `notice` VALUES ('27', '但法国议会大厅内聚一堂', '突然变化土壤条件不太认识', '2017-04-18 17:51:57', null, '0', '1', '1');
INSERT INTO `notice` VALUES ('28', 'ybjynyjuy', 'yjbdyjhnytfty', '2017-04-19 14:32:11', null, '0', '1', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `product_voltage` varchar(255) DEFAULT NULL,
  `product_power` varchar(255) DEFAULT NULL,
  `product_water` varchar(255) DEFAULT NULL,
  `product_pressure` varchar(255) DEFAULT NULL,
  `product_shell` varchar(255) DEFAULT NULL,
  `product_capacity` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `product_typeId` varchar(255) DEFAULT NULL,
  `product_url` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `publishDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(10) DEFAULT NULL,
  `publishStatus` int(10) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'FAB-S01P', '220V-', '2000w', 'IPX4', '0.75mpa', 'ABS环保材料', '30/40/60/80/100/120', '放电墙保护技术，保护家人洗浴安全 金属喷涂外壳，美丽大方 双内胆，时尚超薄设计，节约空间', '1', '/img/pro_list.jpg', '2017-04-19 17:49:26', '2017-04-19 17:49:27', '1', '1');
INSERT INTO `product` VALUES ('4', 'FAB-PDIKV', '220V-', '2000w', 'IPX4', '0.75mpa', '环保材料', '60/80/100/120', '<p>金属喷涂外壳，美丽大方</p>', '2', '/img/pro_list2.jpg', '2017-04-21 14:13:37', '2017-04-21 14:13:37', '1', '1');
INSERT INTO `product` VALUES ('6', 'FAB-SBBC', '220V-', '2000w', 'IPX4', '0.75mpa', '环保材料', '60/80/100/120', '<p>金属喷涂外壳，美丽大方</p>', '2', '/img/pro_list3.jpg', '2017-04-21 14:14:05', '2017-04-21 14:14:05', '1', '1');
INSERT INTO `product` VALUES ('8', 'FAB-SPPD_JD', '220V-', '2000w', 'IPX4', '0.75mpa', '环保材料', '60/80/100/120', '<p>金属喷涂外壳，美丽大方</p>', '3', '/img/pro_list.jpg', '2017-04-20 14:41:33', '2017-04-20 14:41:33', '1', '1');
INSERT INTO `product` VALUES ('12', '规划布局国内', '华国锋的', '翠宫饭店', '地方法规的', '个vfd', ' 第三次的方式v', '测定vsdfcsdvf', 's对房产税的vfsdsdcfsd&nbsp;', '1', '/img/pro_list.jpg', '2017-04-21 11:12:56', '2017-04-21 11:12:57', '1', '1');
INSERT INTO `product` VALUES ('13', '对方vg', '个vfdvdf', ' 使得吃饭速度', '吃饭速度vdsfcsd ', '是大学生吃饭速度', '但是vcfgedvs', 'vgeayygbe', '为vtersbeqcw', '1', '/img/pro_list.jpg', '2017-04-21 11:13:03', '2017-04-21 11:13:03', '1', '1');
INSERT INTO `product` VALUES ('14', '你不同意', '后天怒江月', '个月手提包', '额vbhrtb', '让vgrsvg', '如果vrgtdbr', '而vbhsrtbs', '侧特vy', '1', '/img/pro_list.jpg', '2017-04-21 11:13:03', '2017-04-21 11:13:03', '1', '1');
INSERT INTO `product` VALUES ('15', '标点符号年后', '管他人不会太多废话', '人不会太多', '对方不会放过报道', ' vweacfre', '个vrestvgdwergtvre', '和vrbhs', '额vhrebhtr', '1', '/img/pro_list.jpg', '2017-04-21 11:13:03', '2017-04-21 11:13:03', '1', '1');
INSERT INTO `product` VALUES ('16', '一般均衡投放', 'tv华人特别好人', '耳朵vsgdgf', ' 发呆vsgvfd', '梵蒂冈vdfbggvdfbg', ' 而远不如天算v', 'vtgsrbd非', '东风公司不v', '1', '/img/pro_list.jpg', '2017-04-21 11:13:03', '2017-04-21 11:13:03', '1', '1');
INSERT INTO `product` VALUES ('17', '国防部年更好', '突然改变和通风不好', ' 突然改变和v', 'vgtrdbdf', '发呆vhytbht', 'vgsdrbgf', '激怒他一点烦恼', '途锐调音台测光v', '3', '/img/pro_list.jpg', '2017-04-21 11:13:03', '2017-04-21 11:13:03', '1', '1');

-- ----------------------------
-- Table structure for pro_type
-- ----------------------------
DROP TABLE IF EXISTS `pro_type`;
CREATE TABLE `pro_type` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_type
-- ----------------------------
INSERT INTO `pro_type` VALUES ('1', '时尚数显系列');
INSERT INTO `pro_type` VALUES ('2', '涂漆外壳系列');
INSERT INTO `pro_type` VALUES ('3', '即热式系列');
INSERT INTO `pro_type` VALUES ('4', '速热式系列');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '公司动态');
INSERT INTO `type` VALUES ('2', '公司新闻');
INSERT INTO `type` VALUES ('3', '行业新闻');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPass` varchar(255) DEFAULT NULL,
  `root` int(2) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '0', '2017-04-05 14:43:03');
INSERT INTO `user` VALUES ('2', 'jh', 'admin', '1', '2017-04-07 09:41:56');
INSERT INTO `user` VALUES ('3', 'cjh', 'admin', '0', '2017-04-06 16:49:03');
