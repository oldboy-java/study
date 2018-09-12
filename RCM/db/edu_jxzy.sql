/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.230
Source Server Version : 50624
Source Host           : 192.168.6.230:3306
Source Database       : edu_jxzy

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-09-11 13:48:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brg_data
-- ----------------------------
DROP TABLE IF EXISTS `brg_data`;
CREATE TABLE `brg_data` (
  `collect` varchar(100) DEFAULT NULL COMMENT '汇总列',
  `classify` varchar(100) DEFAULT NULL COMMENT '分类列',
  `amount` double DEFAULT NULL COMMENT '数量',
  `statid` varchar(100) DEFAULT NULL COMMENT '统计标识',
  `grp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='统计数据存储';

-- ----------------------------
-- Records of brg_data
-- ----------------------------
INSERT INTO `brg_data` VALUES ('', '', '5', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('7', '10', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('7', '9', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('8', '10', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('8', '11', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('8', '8', '4', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('8', '9', '2', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('9', '10', '2', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('9', '7', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('9', '9', '1', 'faf9e3ed6401411e8cc23323819e836e', null);
INSERT INTO `brg_data` VALUES ('H5前端开发工程师', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('JAVA服务器开发工', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('Java高级开发工程', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('U3D开发工程师', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('web前端工程师', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('WEB前端开发', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('人事行政主管', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('公交车司机', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('土建造价工程师', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('安全部-资深前端开发', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('机电造价师', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('系统运维工程师', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('营销策划专员', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('资深基础设施工程师', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('资深美术指导SAD/', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('销售经理', '8', '1', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('高级JAVA', '8', '2', 'd964173dc44da83eeafa3aebbee9a1a0', null);
INSERT INTO `brg_data` VALUES ('', '', '4', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('', '1', '1', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('7', '1', '2', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('8', '1', '6', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('8', '2', '2', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('9', '1', '2', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('9', '2', '1', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('9', '3', '1', '71b3b26aaa319e0cdf6fdb8429c112b0', null);
INSERT INTO `brg_data` VALUES ('3', '1', '6', 'e10adc3949ba59abbe56e057f20f883e', null);
INSERT INTO `brg_data` VALUES ('20', '1', '1', 'e10adc3949ba59abbe56e057f20f883e', null);
INSERT INTO `brg_data` VALUES ('3', '2', '150', 'e10adc3949ba59abbe56e057f20f883e', null);
INSERT INTO `brg_data` VALUES ('20', '2', '20', 'e10adc3949ba59abbe56e057f20f883e', null);
INSERT INTO `brg_data` VALUES ('29', '1', '2', 'comment', null);
INSERT INTO `brg_data` VALUES ('94', '1', '1', 'comment', null);
INSERT INTO `brg_data` VALUES ('94', '2', '1', 'comment', null);
INSERT INTO `brg_data` VALUES ('4', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('27', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('29', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('59', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('63', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('83', '1', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('94', '2', '1', 'audit', null);
INSERT INTO `brg_data` VALUES ('3', '1', '6', 'staff', null);
INSERT INTO `brg_data` VALUES ('20', '1', '1', 'staff', null);
INSERT INTO `brg_data` VALUES ('3', '2', '150', 'staff', null);
INSERT INTO `brg_data` VALUES ('20', '2', '20', 'staff', null);

-- ----------------------------
-- Table structure for brg_dict
-- ----------------------------
DROP TABLE IF EXISTS `brg_dict`;
CREATE TABLE `brg_dict` (
  `id` varchar(30) DEFAULT NULL COMMENT '字典值',
  `pid` varchar(30) DEFAULT NULL COMMENT '字典父级',
  `label` varchar(255) DEFAULT NULL COMMENT '字典文字',
  `dict` varchar(40) DEFAULT NULL,
  `source` varchar(40) DEFAULT NULL COMMENT '数据源',
  `exp1` varchar(1000) DEFAULT NULL COMMENT 'SQL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='本地字典缓存';

-- ----------------------------
-- Records of brg_dict
-- ----------------------------
INSERT INTO `brg_dict` VALUES ('1', null, '资源数量', 'JZGZYTJ', 'JIAOZHIGONGZIYUANTONGJI', 'SELECT z.scrid as collect,1 as classify,COUNT(*) as amount FROM jxzy_zy z GROUP BY z.SCRID');
INSERT INTO `brg_dict` VALUES ('2', null, '资源大小', 'JZGZYTJ', 'JIAOZHIGONGZIYUANTONGJI', 'SELECT z.scrid as collect,2 as classify,SUM(z.ZYDX) as amount FROM jxzy_zy z GROUP BY z.SCRID');
INSERT INTO `brg_dict` VALUES ('1', null, null, null, null, null);

-- ----------------------------
-- Table structure for jxzy_djxx
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_djxx`;
CREATE TABLE `jxzy_djxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DJMC` varchar(255) DEFAULT NULL COMMENT '等级名称',
  `ZXJF` int(11) DEFAULT '0' COMMENT '最小积分数',
  `ZDJF` int(11) DEFAULT '0' COMMENT '最大积分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='等级信息';

-- ----------------------------
-- Records of jxzy_djxx
-- ----------------------------
INSERT INTO `jxzy_djxx` VALUES ('1', '1', '0', '100');
INSERT INTO `jxzy_djxx` VALUES ('4', '2', '101', '500');
INSERT INTO `jxzy_djxx` VALUES ('5', '3', '501', '1000');
INSERT INTO `jxzy_djxx` VALUES ('7', '4', '11', '20');

-- ----------------------------
-- Table structure for jxzy_phsd
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_phsd`;
CREATE TABLE `jxzy_phsd` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZYLX_IDS` varchar(255) DEFAULT NULL COMMENT '资源类型ID串，用逗号隔开',
  `YHID` int(11) DEFAULT NULL COMMENT '用户ID',
  `XXID` int(11) DEFAULT NULL COMMENT '学校ＩＤ',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='偏好设定';

-- ----------------------------
-- Records of jxzy_phsd
-- ----------------------------
INSERT INTO `jxzy_phsd` VALUES ('1', '1,4', '1', '1');
INSERT INTO `jxzy_phsd` VALUES ('7', '1,2', null, '1');
INSERT INTO `jxzy_phsd` VALUES ('9', '17,20,7,18,23', '3', '1');
INSERT INTO `jxzy_phsd` VALUES ('10', '9,11', '19', '1');
INSERT INTO `jxzy_phsd` VALUES ('11', '10,11', '20', '1');
INSERT INTO `jxzy_phsd` VALUES ('17', '19,9', '21', '1');
INSERT INTO `jxzy_phsd` VALUES ('20', '1,2,4,5', '27', '1');
INSERT INTO `jxzy_phsd` VALUES ('21', '1,2,4', '26', '1');
INSERT INTO `jxzy_phsd` VALUES ('22', '20,11', '22', '1');
INSERT INTO `jxzy_phsd` VALUES ('23', '9,11', '23', '1');
INSERT INTO `jxzy_phsd` VALUES ('24', '10,7', '24', '1');
INSERT INTO `jxzy_phsd` VALUES ('25', '10', '29', '1');
INSERT INTO `jxzy_phsd` VALUES ('26', '9,10,11,17,18,19,20,21,23', '28', '1');
INSERT INTO `jxzy_phsd` VALUES ('27', '7,9,18', '16', '1');

-- ----------------------------
-- Table structure for jxzy_tzgg
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_tzgg`;
CREATE TABLE `jxzy_tzgg` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TZBT` varchar(255) DEFAULT NULL COMMENT '通知标题',
  `TZNR` varchar(255) DEFAULT NULL COMMENT '通知内容',
  `CJSJ` datetime DEFAULT NULL COMMENT '创建时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1118 DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of jxzy_tzgg
-- ----------------------------
INSERT INTO `jxzy_tzgg` VALUES ('1117', '关于资源共享', '11111', '2018-09-05 14:54:21', null);

-- ----------------------------
-- Table structure for jxzy_wjzh
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_wjzh`;
CREATE TABLE `jxzy_wjzh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wjid` varchar(255) DEFAULT NULL COMMENT '文件Id',
  `wjmc` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `zhjg` int(255) DEFAULT '0' COMMENT '转换结果',
  `zhsj` datetime DEFAULT NULL COMMENT '转换时间',
  `sftb` int(255) DEFAULT '0' COMMENT '是否已同步  0 未同步  1已同步',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=237 DEFAULT CHARSET=utf8 COMMENT='文件转换表';

-- ----------------------------
-- Records of jxzy_wjzh
-- ----------------------------
INSERT INTO `jxzy_wjzh` VALUES ('228', '/home/data/tky_upload/file/rcm/9d6d57be0e1b4379a0642e56b0e019f4.doc', '统一文件服务.doc', '1', '2018-09-06 17:22:56', '1');
INSERT INTO `jxzy_wjzh` VALUES ('229', '/home/data/tky_upload/file/rcm/2c4653fab9cd490785e7e204fa36e0cf.avi', '2f5352a1b1fc490cb5ecc6493792a7d2.avi', '1', '2018-09-06 15:15:09', '1');
INSERT INTO `jxzy_wjzh` VALUES ('230', '/home/data/tky_upload/file/rcm/ddc90e095c98459b9e644d01019a82e2.docx', '台科院办公系统需求-2018-6-12(1).docx', '1', '2018-09-06 17:43:56', '1');
INSERT INTO `jxzy_wjzh` VALUES ('231', '/home/data/tky_upload/file/rcm/8c2be5a72fc148269a8301fd32087958.docx', '校园信息化教学资源平台部署说明手册.docx', '1', '2018-09-06 17:54:35', '1');
INSERT INTO `jxzy_wjzh` VALUES ('232', '/home/data/tky_upload/file/rcm/422b9c41f52f48efab030e1e846eaf8c.avi', '2f5352a1b1fc490cb5ecc6493792a7d2.avi', '1', '2018-09-06 18:02:04', '1');
INSERT INTO `jxzy_wjzh` VALUES ('233', '/home/data/tky_upload/file/rcm/d4ea9d26ac16424ba7ef416cbc1beed1.docx', '台科院办公系统需求-2018-6-12(1).docx', '1', '2018-09-11 11:18:14', '1');
INSERT INTO `jxzy_wjzh` VALUES ('234', '/home/data/tky_upload/file/rcm/4e8a5b7c8f8247c9898789910d41bd7c.docx', '校园信息化教学资源平台部署说明手册.docx', '1', '2018-09-11 13:16:29', '1');
INSERT INTO `jxzy_wjzh` VALUES ('235', '/home/data/tky_upload/file/rcm/f2832439a333411fbcb85a02cd9070a7.doc', '统一文件服务.doc', '1', '2018-09-11 13:16:29', '1');
INSERT INTO `jxzy_wjzh` VALUES ('236', '/home/data/tky_upload/file/rcm/cdb60a6801d744d79b62e161df8a81db.pdf', '阿里巴巴Java开发手册终极版v1.3.0.pdf', '1', '2018-09-11 13:17:13', '1');

-- ----------------------------
-- Table structure for jxzy_wzsz
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_wzsz`;
CREATE TABLE `jxzy_wzsz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mb` int(11) DEFAULT '0' COMMENT '模板',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='网站设置';

-- ----------------------------
-- Records of jxzy_wzsz
-- ----------------------------
INSERT INTO `jxzy_wzsz` VALUES ('3', '1');

-- ----------------------------
-- Table structure for jxzy_xklb
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_xklb`;
CREATE TABLE `jxzy_xklb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `XKMC` varchar(255) DEFAULT NULL COMMENT ' 学科名称',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='学科类别表';

-- ----------------------------
-- Records of jxzy_xklb
-- ----------------------------
INSERT INTO `jxzy_xklb` VALUES ('7', '软件工程', null);
INSERT INTO `jxzy_xklb` VALUES ('9', '金融保险', null);
INSERT INTO `jxzy_xklb` VALUES ('10', '大数据', null);
INSERT INTO `jxzy_xklb` VALUES ('11', '电子商务', null);
INSERT INTO `jxzy_xklb` VALUES ('17', '人工智能', null);
INSERT INTO `jxzy_xklb` VALUES ('18', '生命科学', null);
INSERT INTO `jxzy_xklb` VALUES ('19', '经济管理', null);
INSERT INTO `jxzy_xklb` VALUES ('20', '文学历史', null);
INSERT INTO `jxzy_xklb` VALUES ('21', '艺术设计', null);
INSERT INTO `jxzy_xklb` VALUES ('23', '测试', null);

-- ----------------------------
-- Table structure for jxzy_yhkzxx
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_yhkzxx`;
CREATE TABLE `jxzy_yhkzxx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0' COMMENT '用户ID',
  `jf` int(11) DEFAULT '0' COMMENT '积分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户扩展信息';

-- ----------------------------
-- Records of jxzy_yhkzxx
-- ----------------------------
INSERT INTO `jxzy_yhkzxx` VALUES ('1', '3', '219');
INSERT INTO `jxzy_yhkzxx` VALUES ('3', '26', '63');
INSERT INTO `jxzy_yhkzxx` VALUES ('4', '27', '15');
INSERT INTO `jxzy_yhkzxx` VALUES ('5', '19', '20');
INSERT INTO `jxzy_yhkzxx` VALUES ('6', '19', '5');
INSERT INTO `jxzy_yhkzxx` VALUES ('7', '20', '45');
INSERT INTO `jxzy_yhkzxx` VALUES ('8', '21', '22');
INSERT INTO `jxzy_yhkzxx` VALUES ('9', '22', '5');
INSERT INTO `jxzy_yhkzxx` VALUES ('10', '23', '15');
INSERT INTO `jxzy_yhkzxx` VALUES ('11', '24', '42');

-- ----------------------------
-- Table structure for jxzy_zy
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zy`;
CREATE TABLE `jxzy_zy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYMC` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `SSXKID` int(11) DEFAULT NULL COMMENT '所属学科ID',
  `WJGS` varchar(255) DEFAULT NULL COMMENT '文件格式',
  `SCRID` int(1) DEFAULT NULL COMMENT '上传人ID',
  `ZYZT` int(11) DEFAULT NULL COMMENT '资源状态',
  `ZYDZ` varchar(255) DEFAULT NULL COMMENT '资源地址',
  `ZYLY` varchar(255) DEFAULT NULL COMMENT '资源来源',
  `ZZ` varchar(255) DEFAULT NULL COMMENT '作者',
  `SCRQ` date DEFAULT NULL COMMENT '上传日期',
  `LLCS` int(11) DEFAULT '0' COMMENT '浏览次数',
  `XZCS` int(11) DEFAULT '0' COMMENT '下载次数',
  `SCCS` int(11) DEFAULT '0' COMMENT '收藏次数',
  `PLCS` int(11) DEFAULT '0' COMMENT '评论次数',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  `WJDX` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `SHZT` int(11) DEFAULT NULL COMMENT '审核状态（1待审核，2审核通过，3未通过）',
  `FMLJ` varchar(255) DEFAULT NULL COMMENT '封面路径',
  `HZM` varchar(255) DEFAULT NULL COMMENT '后缀名',
  `WJMC` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `ZHCG` int(11) DEFAULT '0' COMMENT '转换成功',
  `scr` varchar(255) DEFAULT NULL COMMENT '上传人',
  `dzcs` int(11) DEFAULT '0' COMMENT '点赞次数',
  `ZYDX` varchar(255) DEFAULT NULL COMMENT '资源大小（统计用默认单位KB）',
  `XZQX` int(11) DEFAULT '0' COMMENT ' 0 自由下载  1有权限下载',
  `XZJF` int(11) DEFAULT '0' COMMENT '下载积分',
  `TAG` varchar(255) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of jxzy_zy
-- ----------------------------
INSERT INTO `jxzy_zy` VALUES ('94', 'Java并发编程', '7', 'PDF', '20', '3', 'rcm/25342d958f7a493ca61490af05dc404c.pdf', '', '', '2018-01-29', '73', '11', '1', '9', null, '8.8MB', '2', 'rcm/85d145d7fb344acea3576678d0834f51.jpg', '.pdf', 'JAVA并发编程实战.pdf', '1', '李海飞', '2', '9011.2', '1', '10', null);
INSERT INTO `jxzy_zy` VALUES ('192', 'JavaWeb课件', '7', 'PPTX', '20', '3', 'rcm/2302be4688414ea6afd5624000d0bd1d.pptx', '', '李兴华', '2018-03-01', '129', '4', '1', '1', null, '6.1MB', '2', 'rcm/bf63d24372ec4da6910102cab5dc34d0.jpg', '.pptx', 'JavaWeb课件.pptx', '1', '李海飞', '0', '6246.4', null, '0', 'JavaWeb');
INSERT INTO `jxzy_zy` VALUES ('194', 'Python编程之读取文本文件', '7', 'MOV', '19', '3', 'rcm/6fa53a3336e0417898233491b1fe7fb1.mov', '', '李铭', '2018-03-01', '19', '2', '0', '0', null, '86.36MB', '2', 'rcm/5951e5f215c24bd8982f03447d735efe.jpg', '.mov', '5-1 如何读取文本文件.mov', '1', '李明', '0', '88432.64', '0', '0', 'Python  编程 ');
INSERT INTO `jxzy_zy` VALUES ('195', 'Python编程之处理二进制文件', '7', 'MOV', '19', '3', 'rcm/bf928ce8af9240b9953b296446455c56.mov', '', '李铭', '2018-03-01', '9', '1', '0', '0', null, '112.49MB', '2', 'rcm/5951e5f215c24bd8982f03447d735efe.jpg', '.mov', '5-2 如何处理二进制文件.mov', '1', '李明', '0', '115189.76', null, '0', 'Python  编程  处理二进制文件');
INSERT INTO `jxzy_zy` VALUES ('196', 'Python编程之如何使用临时文件', '7', 'MOV', '20', '3', 'rcm/6888aed5cc20412fb2c59ad413d48a5d.mov', '', '李丽', '2018-03-01', '6', '0', '0', '0', null, '124.72MB', '2', 'rcm/5951e5f215c24bd8982f03447d735efe.jpg', '.mov', '5-6 如何使用临时文件.mov', '1', '李海飞', '0', '127713.28', null, '0', 'Python 编程');
INSERT INTO `jxzy_zy` VALUES ('197', 'Python编程之如何访问文件的状态', '7', 'MOV', '20', '3', 'rcm/4d57b1a73ee34ca1a4fe86d23207889a.mov', '', '李丽', '2018-03-01', '218', '150', '0', '0', null, '181.56MB', '2', 'rcm/d2e24c955f3f4c8da1094d20a3bfca6b.jpg', '.mov', '5-5 如何访问文件的状态.mov', '1', '李海飞', '0', '185917.44', null, '0', 'Python  编程');
INSERT INTO `jxzy_zy` VALUES ('199', '响应式Web设计', '7', 'PDF', '20', '3', 'rcm/6f75866bd8f4499fb2ee6f8e9eba09b4.pdf', '', '王强', '2018-03-01', '506', '0', '0', '0', null, '53.47MB', '2', 'rcm/c2b4d17491a647a9898330fbf4dbf850.jpg', '.pdf', '响应式Web设计.pdf', '1', '李海飞', '0', '54753.28', null, '0', '响应式  Web设计');
INSERT INTO `jxzy_zy` VALUES ('200', '淘宝响应式WebUI设计实践', '7', 'PDF', '20', '3', 'rcm/1baff0f2316c46d2998010d2026bb1cf.pdf', '', '淘宝设计组', '2018-03-01', '3', '0', '0', '0', null, '2.85MB', '2', 'rcm/a70380a1aa434274a578b23a1bec8f8e.jpg', '.pdf', '淘宝响应式WebUI设计实践.pdf', '1', '李海飞', '0', '2918.4', null, '0', '响应式 ');
INSERT INTO `jxzy_zy` VALUES ('201', 'Bootstrap模态框和下拉菜单', '7', 'MP4', '20', '3', 'rcm/b6526f8579844d1ea22c2d357d620ed7.mp4', '', '', '2018-03-01', '149', '51', '0', '0', null, '203.84MB', '2', 'rcm/1785a6e8e4ef4053aeca10c26a8aaba2.jpg', '.mp4', 'Bootstrap模态框和下拉菜单.mp4', '0', '李海飞', '1', '208732.16', '1', '10', 'Bootstrap  模态框  下拉菜单');
INSERT INTO `jxzy_zy` VALUES ('202', '保险行业新会计准则实施指南', '9', 'PDF', '21', '3', 'rcm/369b8c9650db4f9ca6d580e32e3576d8.pdf', '', '', '2018-03-01', '14', '0', '0', '0', null, '2.5MB', '2', 'rcm/9059d4bda5794c5a866aaefdd7957d98.jpg', '.pdf', '20130827121323.pdf', '1', '王柱', '0', '2560.0', null, '0', '保险');
INSERT INTO `jxzy_zy` VALUES ('203', '保险基础知识', '9', 'PDF', '21', '3', 'rcm/c078071d679a418e8db4624a3f1fc0a2.pdf', '', '', '2018-03-01', '563', '0', '1', '0', null, '1.05MB', '2', '', '.pdf', '保险基础知识.pdf', '1', '王柱', '0', '1075.2', '1', '10', '保险');
INSERT INTO `jxzy_zy` VALUES ('204', '保险学', '9', 'PDF', '21', '3', 'rcm/ed902476a64c4058b74eaeb4c4403ff0.pdf', '', '杨正勇', '2018-03-01', '20', '0', '0', '0', null, '1.02MB', '2', '', '.pdf', '20130827141730.pdf', '1', '王柱', '0', '1044.48', null, '0', '保险 保险学');
INSERT INTO `jxzy_zy` VALUES ('205', '保险行业介绍', '9', 'PDF', '21', '3', 'rcm/a5e77a5fd5f24e17bd434e6a12d06b5e.pdf', '', '', '2018-03-01', '2', '0', '0', '0', null, '405.31KB', '2', '', '.pdf', '20130827141750.pdf', '1', '王柱', '0', '405.31', null, '0', '保险行业');
INSERT INTO `jxzy_zy` VALUES ('206', '中国电信市场营销的思考', '11', 'PDF', '21', '3', 'rcm/ce510c3e399f492691cd2b27855382a0.pdf', '', '', '2018-03-01', '32', '0', '0', '0', null, '516.82KB', '2', '', '.pdf', '20130827145254.pdf', '1', '王柱', '0', '516.82', null, '0', '中国电信  市场营销');
INSERT INTO `jxzy_zy` VALUES ('207', '保险知识二', '9', 'PDF', '22', '3', 'rcm/126675fe06094a6aafaecf5f669b98bb.pdf', '', '', '2018-03-01', '0', '0', '0', '0', null, '109.14KB', '2', '', '.pdf', '20130827122904.pdf', '1', '李光华', '0', '109.14', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('208', '电子商务经济学', '11', 'PDF', '19', '3', 'rcm/ed819dc6e3d642aa90f69f22ad11e6c5.pdf', '', '', '2018-03-01', '611', '0', '0', '0', null, '3.32MB', '2', 'rcm/bc4e5be0d0844a5db72166ed97d79122.jpg', '.pdf', '[电子商务经济学].pdf', '1', '李明', '0', '3399.68', '1', '3', '电子商务  经济学');
INSERT INTO `jxzy_zy` VALUES ('209', 'ZooKeeper命令操作', '10', 'AVI', '23', '3', 'rcm/165d988a3a8446e38ad825aa6e3e5f91.avi', '', '', '2018-03-01', '21', '0', '0', '0', null, '59.5MB', '2', 'rcm/52110f6350b842549d889a589a064b88.jpg', '.avi', 'ZooKeeper第01天-03.zk命令操作.avi', '1', '赵美丽', '0', '60928.0', null, '0', 'ZooKeeper');
INSERT INTO `jxzy_zy` VALUES ('210', 'ZooKeeperAPI访问zk数据', '10', 'AVI', '23', '3', 'rcm/462e0b70f59642ffaa02d6cd6e2c05e0.avi', '', '', '2018-03-01', '2', '0', '0', '0', null, '15.67MB', '2', 'rcm/dc47fdc8e8d244debc451147ff5cbe91.jpg', '.avi', 'ZooKeeper第01天-04.zk API访问zk数据.avi', '1', '赵美丽', '0', '16046.08', '1', '3', 'ZooKeeper');
INSERT INTO `jxzy_zy` VALUES ('211', 'ZooKeeper递归方式输出zk系统目录', '10', 'AVI', '23', '3', 'rcm/30535bd9cb444de9a92a69fe5d607a76.avi', '', '', '2018-03-01', '2', '0', '0', '0', null, '17.15MB', '2', 'rcm/6949ca3ff31e4f1f82f49c59187668a1.jpg', '.avi', 'ZooKeeper第01天-05.zk递归方式输出zk系统目录.avi', '1', '赵美丽', '0', '17561.6', '1', '3', 'ZooKeeper');
INSERT INTO `jxzy_zy` VALUES ('212', 'ZooKeeper观察者模式', '10', 'AVI', '24', '3', 'rcm/eae9d7b4f72b4698a225e968655c94a1.avi', '', '', '2018-03-01', '3', '0', '0', '0', null, '180.71MB', '2', 'rcm/f443d32489d2406f909f3a51528cbc14.jpg', '.avi', 'ZooKeeper第01天-06.zk观察者模式-编程API使用-监控演示.avi', '1', '刘宇飞', '0', '185047.04', '1', '3', 'ZooKeeper');
INSERT INTO `jxzy_zy` VALUES ('213', '电子商务基础', '11', 'PDF', '24', '3', 'rcm/138a243f3a154ee6a4841927caeb39cb.pdf', '', '杨丙根', '2018-03-01', '11', '0', '0', '0', null, '4.27MB', '2', 'rcm/fbf2d38b0acf423a8342d4f668d54559.jpg', '.pdf', '[电子商务基础].杨丙根.文字版.pdf', '1', '刘宇飞', '0', '4372.48', null, '0', '电子商务');
INSERT INTO `jxzy_zy` VALUES ('214', '大数据时代', '10', 'PDF', '24', '3', 'rcm/f2ecf4f60bd44708a5a77b31be04d92c.pdf', '', '', '2018-03-01', '530', '1', '0', '5', null, '2.28MB', '2', 'rcm/35f8bce5dd5b43b3ae83ab63a881a6a8.jpg', '.pdf', '大数据时代.pdf', '1', '刘宇飞', '0', '2334.72', '1', '3', '大数据');
INSERT INTO `jxzy_zy` VALUES ('215', '电子商务教学课程ppt', '11', 'PPT', '24', '3', 'rcm/4c7c2b2c17dd434daecdf8621fc85ff3.ppt', '', '', '2018-03-01', '732', '301', '0', '0', null, '11.45MB', '2', 'rcm/86ef5a9f5cfa408294d248ce20ab4756.jpg', '.ppt', '电子商务教学课程ppt.ppt', '1', '刘宇飞', '0', '11724.8', '1', '3', '电子商务');
INSERT INTO `jxzy_zy` VALUES ('216', 'Hadoop之大数据介绍', '10', 'AVI', '24', '3', 'rcm/4560da58df08494fbde12aacc2d1c988.avi', '', '', '2018-03-01', '4', '0', '0', '0', null, '169.97MB', '2', 'rcm/2b97db9c14964155bd5eba71293fe3a3.jpg', '.avi', 'Hadoop第01天-01.大数据介绍.avi', '1', '刘宇飞', '0', '174049.28', null, '0', 'Hadoop  大数据');
INSERT INTO `jxzy_zy` VALUES ('218', 'Hadoop之hadoop安装配置', '10', 'AVI', '24', '3', 'rcm/5cea6f2c320147c59f0a5696deb141c9.avi', '', '', '2018-03-01', '440', '201', '0', '0', null, '153.49MB', '2', 'rcm/42f3d9f333c7469ebeb7545a35559bbe.jpg', '.avi', 'Hadoop第01天-03.hadoop安装-配置(独立模式-伪分布).avi', '1', '刘宇飞', '0', '157173.76', null, '0', 'Hadoop 大数据');
INSERT INTO `jxzy_zy` VALUES ('239', 'doc测试', '7', 'DOC', '3', '3', 'rcm/9d6d57be0e1b4379a0642e56b0e019f4.doc', '', '', '2018-09-06', '15', '0', '0', '0', null, '65.5KB', '2', '', '.doc', '统一文件服务.doc', '1', '李明敏', '0', '65.5', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('240', '视频测试', '7', 'AVI', '3', '3', 'rcm/2c4653fab9cd490785e7e204fa36e0cf.avi', '', '', '2018-09-06', '15', '0', '0', '0', null, '125.22MB', '2', '', '.avi', '2f5352a1b1fc490cb5ecc6493792a7d2.avi', '1', '李明敏', '0', '128225.28', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('241', '1111docx', '7', 'DOCX', '3', '3', 'rcm/ddc90e095c98459b9e644d01019a82e2.docx', '', '', '2018-09-06', '3', '0', '0', '0', null, '1.17MB', '2', '', '.docx', '台科院办公系统需求-2018-6-12(1).docx', '1', '李明敏', '0', '1198.08', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('242', '222视频测试', '7', 'AVI', '3', '3', 'rcm/422b9c41f52f48efab030e1e846eaf8c.avi', '', '', '2018-09-06', '2', '0', '0', '0', null, '125.22MB', '2', '', '.avi', '2f5352a1b1fc490cb5ecc6493792a7d2.avi', '1', '李明敏', '0', '128225.28', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('243', '33', '7', 'DOCX', '3', '3', 'rcm/8c2be5a72fc148269a8301fd32087958.docx', '', '', '2018-09-06', '10', '1', '0', '0', null, '836.49KB', '2', '', '.docx', '校园信息化教学资源平台部署说明手册.docx', '1', '李明敏', '0', '836.49', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('244', '测试视频', '7', 'MP4', '3', '1', 'rcm/b8c1974b83ab44b0a34c307a1ab667bf.mp4', '', '21', '2018-09-11', '7', '0', '0', '0', null, '291.24MB', '2', '', '.mp4', 'f276bc4ee54548b1ba6ef59914d95b9d.mp4', '0', '李明敏', '0', '298229.76', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('245', '测试docx', '7', 'DOCX', '3', '1', 'rcm/d4ea9d26ac16424ba7ef416cbc1beed1.docx', '', '11', '2018-09-11', '4', '0', '0', '0', null, '1.17MB', '2', '', '.docx', '台科院办公系统需求-2018-6-12(1).docx', '1', '李明敏', '0', '1198.08', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('246', '111docx测试', '9', 'DOCX', '3', '1', 'rcm/4e8a5b7c8f8247c9898789910d41bd7c.docx', '', '', '2018-09-11', '1', '0', '0', '0', null, '836.49KB', '2', '', '.docx', '校园信息化教学资源平台部署说明手册.docx', '1', '李明敏', '0', '836.49', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('247', '测试doc', '7', 'DOC', '3', '1', 'rcm/f2832439a333411fbcb85a02cd9070a7.doc', '', '', '2018-09-11', '1', '0', '0', '0', null, '65.5KB', '2', '', '.doc', '统一文件服务.doc', '1', '李明敏', '0', '65.5', null, '0', '');
INSERT INTO `jxzy_zy` VALUES ('248', '测试pdf', '7', 'PDF', '3', '1', 'rcm/cdb60a6801d744d79b62e161df8a81db.pdf', '', '', '2018-09-11', '1', '0', '0', '0', null, '1.0MB', '2', '', '.pdf', '阿里巴巴Java开发手册终极版v1.3.0.pdf', '1', '李明敏', '0', '1024.0', null, '0', '');

-- ----------------------------
-- Table structure for jxzy_zydz
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zydz`;
CREATE TABLE `jxzy_zydz` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYID` int(11) DEFAULT NULL COMMENT '资源ID',
  `DZRID` int(11) DEFAULT NULL COMMENT '点赞人ID',
  `DZSJ` datetime DEFAULT NULL COMMENT '点赞时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='资源点赞表';

-- ----------------------------
-- Records of jxzy_zydz
-- ----------------------------
INSERT INTO `jxzy_zydz` VALUES ('13', '63', '3', '2018-01-19 16:06:02', null);
INSERT INTO `jxzy_zydz` VALUES ('17', '78', '3', '2018-01-22 14:21:53', null);
INSERT INTO `jxzy_zydz` VALUES ('19', '4', '3', '2018-01-23 14:39:59', null);
INSERT INTO `jxzy_zydz` VALUES ('20', '4', '19', '2018-01-29 17:54:11', null);
INSERT INTO `jxzy_zydz` VALUES ('22', '98', '19', '2018-01-29 19:37:45', null);
INSERT INTO `jxzy_zydz` VALUES ('25', '27', '3', '2018-02-02 13:39:43', null);
INSERT INTO `jxzy_zydz` VALUES ('26', '109', '3', '2018-02-05 17:03:46', null);
INSERT INTO `jxzy_zydz` VALUES ('27', '113', '26', '2018-02-06 09:31:26', null);
INSERT INTO `jxzy_zydz` VALUES ('28', '59', '3', '2018-02-27 17:06:44', null);
INSERT INTO `jxzy_zydz` VALUES ('29', '94', '3', '2018-03-07 15:07:15', null);
INSERT INTO `jxzy_zydz` VALUES ('30', '201', '21', '2018-03-08 11:24:51', null);
INSERT INTO `jxzy_zydz` VALUES ('33', '94', '19', '2018-04-11 16:33:32', null);
INSERT INTO `jxzy_zydz` VALUES ('34', '231', '3', '2018-06-29 09:26:32', null);

-- ----------------------------
-- Table structure for jxzy_zyll
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zyll`;
CREATE TABLE `jxzy_zyll` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYID` varchar(255) DEFAULT NULL COMMENT '资源ID',
  `LLRID` varchar(255) DEFAULT NULL COMMENT '浏览人ID',
  `LLSJ` datetime DEFAULT NULL COMMENT '浏览时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=224 DEFAULT CHARSET=utf8 COMMENT='资源浏览表';

-- ----------------------------
-- Records of jxzy_zyll
-- ----------------------------
INSERT INTO `jxzy_zyll` VALUES ('13', '29', '3', '2018-02-28 13:15:28', null);
INSERT INTO `jxzy_zyll` VALUES ('15', '63', '3', '2018-02-28 15:01:26', null);
INSERT INTO `jxzy_zyll` VALUES ('16', '27', '3', '2018-02-27 17:48:19', null);
INSERT INTO `jxzy_zyll` VALUES ('22', '4', '3', '2018-02-27 17:02:32', null);
INSERT INTO `jxzy_zyll` VALUES ('23', '4', '19', '2018-02-05 09:56:25', null);
INSERT INTO `jxzy_zyll` VALUES ('24', '95', '20', '2018-01-29 15:06:51', null);
INSERT INTO `jxzy_zyll` VALUES ('25', '94', '20', '2018-01-29 16:56:10', null);
INSERT INTO `jxzy_zyll` VALUES ('26', '94', '3', '2018-09-06 18:08:32', null);
INSERT INTO `jxzy_zyll` VALUES ('27', '83', '20', '2018-01-29 15:19:26', null);
INSERT INTO `jxzy_zyll` VALUES ('28', '96', '19', '2018-01-31 09:55:16', null);
INSERT INTO `jxzy_zyll` VALUES ('29', '97', '19', '2018-01-29 17:40:29', null);
INSERT INTO `jxzy_zyll` VALUES ('30', '29', '19', '2018-01-31 09:54:35', null);
INSERT INTO `jxzy_zyll` VALUES ('31', '63', '19', '2018-01-29 16:33:41', null);
INSERT INTO `jxzy_zyll` VALUES ('32', '59', '19', '2018-01-29 16:32:54', null);
INSERT INTO `jxzy_zyll` VALUES ('33', '4', '20', '2018-01-29 16:53:22', null);
INSERT INTO `jxzy_zyll` VALUES ('34', '99', '19', '2018-01-29 19:34:28', null);
INSERT INTO `jxzy_zyll` VALUES ('35', '98', '19', '2018-01-31 09:54:06', null);
INSERT INTO `jxzy_zyll` VALUES ('36', '100', '19', '2018-01-30 09:49:18', null);
INSERT INTO `jxzy_zyll` VALUES ('37', '101', '19', '2018-01-30 10:00:13', null);
INSERT INTO `jxzy_zyll` VALUES ('38', '102', '19', '2018-01-30 09:56:17', null);
INSERT INTO `jxzy_zyll` VALUES ('39', '59', '3', '2018-02-27 17:06:48', null);
INSERT INTO `jxzy_zyll` VALUES ('40', '96', '3', '2018-01-30 11:44:32', null);
INSERT INTO `jxzy_zyll` VALUES ('41', '104', '3', '2018-01-31 09:40:43', null);
INSERT INTO `jxzy_zyll` VALUES ('42', '104', '19', '2018-01-31 09:50:06', null);
INSERT INTO `jxzy_zyll` VALUES ('43', '83', '19', '2018-01-31 11:07:02', null);
INSERT INTO `jxzy_zyll` VALUES ('44', '27', '19', '2018-02-01 15:52:51', null);
INSERT INTO `jxzy_zyll` VALUES ('45', '83', '3', '2018-02-28 13:17:56', null);
INSERT INTO `jxzy_zyll` VALUES ('46', '109', '19', '2018-02-05 17:05:27', null);
INSERT INTO `jxzy_zyll` VALUES ('47', '110', '19', '2018-02-05 14:49:25', null);
INSERT INTO `jxzy_zyll` VALUES ('48', '109', '3', '2018-02-06 11:14:54', null);
INSERT INTO `jxzy_zyll` VALUES ('49', '4', '26', '2018-02-06 09:29:00', null);
INSERT INTO `jxzy_zyll` VALUES ('50', '113', '26', '2018-02-06 09:31:40', null);
INSERT INTO `jxzy_zyll` VALUES ('51', '114', '26', '2018-02-06 09:39:16', null);
INSERT INTO `jxzy_zyll` VALUES ('52', '122', '3', '2018-02-06 15:31:02', null);
INSERT INTO `jxzy_zyll` VALUES ('53', '115', '3', '2018-02-06 16:55:28', null);
INSERT INTO `jxzy_zyll` VALUES ('54', '116', '3', '2018-02-06 15:30:25', null);
INSERT INTO `jxzy_zyll` VALUES ('55', '117', '3', '2018-02-06 16:55:19', null);
INSERT INTO `jxzy_zyll` VALUES ('56', '118', '3', '2018-02-06 16:55:34', null);
INSERT INTO `jxzy_zyll` VALUES ('57', '119', '3', '2018-02-06 15:30:45', null);
INSERT INTO `jxzy_zyll` VALUES ('58', '120', '3', '2018-02-06 16:55:23', null);
INSERT INTO `jxzy_zyll` VALUES ('59', '121', '3', '2018-02-06 15:30:57', null);
INSERT INTO `jxzy_zyll` VALUES ('60', '123', '3', '2018-02-06 16:34:09', null);
INSERT INTO `jxzy_zyll` VALUES ('61', '124', '3', '2018-02-06 16:39:17', null);
INSERT INTO `jxzy_zyll` VALUES ('62', '125', '27', '2018-02-07 10:38:21', null);
INSERT INTO `jxzy_zyll` VALUES ('63', '138', '3', '2018-02-08 14:39:26', null);
INSERT INTO `jxzy_zyll` VALUES ('64', '136', '3', '2018-02-08 14:49:44', null);
INSERT INTO `jxzy_zyll` VALUES ('65', '140', '3', '2018-02-08 16:18:03', null);
INSERT INTO `jxzy_zyll` VALUES ('66', '141', '3', '2018-02-08 17:18:05', null);
INSERT INTO `jxzy_zyll` VALUES ('67', '143', '3', '2018-02-08 17:08:09', null);
INSERT INTO `jxzy_zyll` VALUES ('68', '139', '3', '2018-02-08 16:45:31', null);
INSERT INTO `jxzy_zyll` VALUES ('69', '142', '3', '2018-02-08 17:20:09', null);
INSERT INTO `jxzy_zyll` VALUES ('70', '145', '3', '2018-02-08 16:58:24', null);
INSERT INTO `jxzy_zyll` VALUES ('71', '144', '3', '2018-02-08 17:01:01', null);
INSERT INTO `jxzy_zyll` VALUES ('72', '146', '3', '2018-02-08 17:02:36', null);
INSERT INTO `jxzy_zyll` VALUES ('73', '134', '3', '2018-02-08 17:09:52', null);
INSERT INTO `jxzy_zyll` VALUES ('74', '147', '3', '2018-02-08 17:13:02', null);
INSERT INTO `jxzy_zyll` VALUES ('75', '148', '3', '2018-02-08 17:14:26', null);
INSERT INTO `jxzy_zyll` VALUES ('76', '149', '3', '2018-02-08 17:15:21', null);
INSERT INTO `jxzy_zyll` VALUES ('77', '150', '3', '2018-02-08 17:16:07', null);
INSERT INTO `jxzy_zyll` VALUES ('78', '151', '3', '2018-02-08 17:25:54', null);
INSERT INTO `jxzy_zyll` VALUES ('79', '152', '26', '2018-02-08 17:39:49', null);
INSERT INTO `jxzy_zyll` VALUES ('80', '152', '3', '2018-02-08 17:47:54', null);
INSERT INTO `jxzy_zyll` VALUES ('81', '153', '3', '2018-02-27 17:09:38', null);
INSERT INTO `jxzy_zyll` VALUES ('82', '154', '3', '2018-02-27 17:07:46', null);
INSERT INTO `jxzy_zyll` VALUES ('83', '155', '3', '2018-02-08 17:48:31', null);
INSERT INTO `jxzy_zyll` VALUES ('84', '156', '3', '2018-02-08 17:48:37', null);
INSERT INTO `jxzy_zyll` VALUES ('85', '157', '3', '2018-02-08 17:48:41', null);
INSERT INTO `jxzy_zyll` VALUES ('86', '159', '3', '2018-02-08 18:05:38', null);
INSERT INTO `jxzy_zyll` VALUES ('87', '160', '3', '2018-02-08 18:06:24', null);
INSERT INTO `jxzy_zyll` VALUES ('88', '161', '3', '2018-02-08 18:08:07', null);
INSERT INTO `jxzy_zyll` VALUES ('89', '163', '3', '2018-02-08 18:01:57', null);
INSERT INTO `jxzy_zyll` VALUES ('90', '164', '3', '2018-02-27 11:28:27', null);
INSERT INTO `jxzy_zyll` VALUES ('91', '165', '3', '2018-02-27 11:28:35', null);
INSERT INTO `jxzy_zyll` VALUES ('92', '166', '3', '2018-02-27 11:28:42', null);
INSERT INTO `jxzy_zyll` VALUES ('93', '167', '3', '2018-02-27 11:28:46', null);
INSERT INTO `jxzy_zyll` VALUES ('94', '168', '3', '2018-02-27 17:34:52', null);
INSERT INTO `jxzy_zyll` VALUES ('95', '169', '3', '2018-02-27 11:31:33', null);
INSERT INTO `jxzy_zyll` VALUES ('96', '170', '3', '2018-02-27 17:35:52', null);
INSERT INTO `jxzy_zyll` VALUES ('97', '171', '3', '2018-02-27 17:36:18', null);
INSERT INTO `jxzy_zyll` VALUES ('98', '172', '3', '2018-02-28 10:26:55', null);
INSERT INTO `jxzy_zyll` VALUES ('99', '174', '3', '2018-02-27 11:14:02', null);
INSERT INTO `jxzy_zyll` VALUES ('100', '175', '3', '2018-02-28 10:12:54', null);
INSERT INTO `jxzy_zyll` VALUES ('101', '176', '3', '2018-02-27 17:11:12', null);
INSERT INTO `jxzy_zyll` VALUES ('102', '177', '3', '2018-02-27 17:11:39', null);
INSERT INTO `jxzy_zyll` VALUES ('103', '178', '3', '2018-02-28 09:34:07', null);
INSERT INTO `jxzy_zyll` VALUES ('104', '179', '3', '2018-02-27 16:39:54', null);
INSERT INTO `jxzy_zyll` VALUES ('105', '180', '3', '2018-02-27 16:46:01', null);
INSERT INTO `jxzy_zyll` VALUES ('106', '181', '3', '2018-02-28 10:12:13', null);
INSERT INTO `jxzy_zyll` VALUES ('107', '182', '19', '2018-02-27 17:59:57', null);
INSERT INTO `jxzy_zyll` VALUES ('108', '183', '19', '2018-02-27 18:01:31', null);
INSERT INTO `jxzy_zyll` VALUES ('109', '184', '19', '2018-02-27 18:02:58', null);
INSERT INTO `jxzy_zyll` VALUES ('110', '186', '3', '2018-02-28 10:05:08', null);
INSERT INTO `jxzy_zyll` VALUES ('111', '187', '19', '2018-02-27 18:17:17', null);
INSERT INTO `jxzy_zyll` VALUES ('112', '188', '19', '2018-02-27 18:10:27', null);
INSERT INTO `jxzy_zyll` VALUES ('113', '185', '3', '2018-02-28 10:11:49', null);
INSERT INTO `jxzy_zyll` VALUES ('114', '189', '3', '2018-02-28 10:02:06', null);
INSERT INTO `jxzy_zyll` VALUES ('115', '190', '3', '2018-02-28 10:12:25', null);
INSERT INTO `jxzy_zyll` VALUES ('116', '191', '3', '2018-02-28 10:09:43', null);
INSERT INTO `jxzy_zyll` VALUES ('117', '192', '3', '2018-09-06 15:23:56', null);
INSERT INTO `jxzy_zyll` VALUES ('118', '193', '3', '2018-02-28 10:22:22', null);
INSERT INTO `jxzy_zyll` VALUES ('119', '194', '19', '2018-03-07 10:08:04', null);
INSERT INTO `jxzy_zyll` VALUES ('120', '195', '19', '2018-03-07 10:05:45', null);
INSERT INTO `jxzy_zyll` VALUES ('121', '195', '20', '2018-03-01 10:35:22', null);
INSERT INTO `jxzy_zyll` VALUES ('122', '194', '20', '2018-03-01 10:35:45', null);
INSERT INTO `jxzy_zyll` VALUES ('123', '196', '20', '2018-03-01 13:31:22', null);
INSERT INTO `jxzy_zyll` VALUES ('124', '198', '20', '2018-03-01 11:12:49', null);
INSERT INTO `jxzy_zyll` VALUES ('125', '199', '20', '2018-03-01 11:13:08', null);
INSERT INTO `jxzy_zyll` VALUES ('126', '197', '20', '2018-03-01 11:04:39', null);
INSERT INTO `jxzy_zyll` VALUES ('127', '201', '20', '2018-03-01 11:24:00', null);
INSERT INTO `jxzy_zyll` VALUES ('128', '202', '21', '2018-05-15 16:04:36', null);
INSERT INTO `jxzy_zyll` VALUES ('129', '203', '21', '2018-03-01 11:43:41', null);
INSERT INTO `jxzy_zyll` VALUES ('130', '204', '21', '2018-03-01 11:55:04', null);
INSERT INTO `jxzy_zyll` VALUES ('131', '200', '21', '2018-03-01 11:54:39', null);
INSERT INTO `jxzy_zyll` VALUES ('132', '192', '20', '2018-03-01 14:26:22', null);
INSERT INTO `jxzy_zyll` VALUES ('133', '208', '23', '2018-03-01 15:03:57', null);
INSERT INTO `jxzy_zyll` VALUES ('134', '206', '23', '2018-03-01 15:02:42', null);
INSERT INTO `jxzy_zyll` VALUES ('135', '209', '24', '2018-03-01 15:16:22', null);
INSERT INTO `jxzy_zyll` VALUES ('136', '208', '24', '2018-03-01 15:20:30', null);
INSERT INTO `jxzy_zyll` VALUES ('137', '213', '24', '2018-03-01 16:05:31', null);
INSERT INTO `jxzy_zyll` VALUES ('138', '218', '24', '2018-04-03 10:49:43', null);
INSERT INTO `jxzy_zyll` VALUES ('139', '217', '24', '2018-03-01 16:03:42', null);
INSERT INTO `jxzy_zyll` VALUES ('140', '216', '24', '2018-03-01 16:04:13', null);
INSERT INTO `jxzy_zyll` VALUES ('141', '206', '24', '2018-03-01 16:05:28', null);
INSERT INTO `jxzy_zyll` VALUES ('142', '192', '24', '2018-04-03 10:50:34', null);
INSERT INTO `jxzy_zyll` VALUES ('143', '219', '24', '2018-03-01 17:36:26', null);
INSERT INTO `jxzy_zyll` VALUES ('144', '220', '24', '2018-03-01 17:36:30', null);
INSERT INTO `jxzy_zyll` VALUES ('145', '215', '22', '2018-03-19 11:55:42', null);
INSERT INTO `jxzy_zyll` VALUES ('146', '192', '29', '2018-03-01 17:49:36', null);
INSERT INTO `jxzy_zyll` VALUES ('147', '205', '19', '2018-03-01 18:11:58', null);
INSERT INTO `jxzy_zyll` VALUES ('148', '204', '19', '2018-04-08 13:56:09', null);
INSERT INTO `jxzy_zyll` VALUES ('149', '203', '19', '2018-03-07 10:34:14', null);
INSERT INTO `jxzy_zyll` VALUES ('150', '215', '19', '2018-03-07 10:07:24', null);
INSERT INTO `jxzy_zyll` VALUES ('151', '214', '24', '2018-03-02 09:05:13', null);
INSERT INTO `jxzy_zyll` VALUES ('152', '94', '19', '2018-04-11 16:33:36', null);
INSERT INTO `jxzy_zyll` VALUES ('153', '192', '19', '2018-09-10 09:23:13', null);
INSERT INTO `jxzy_zyll` VALUES ('154', '197', '19', '2018-03-07 10:05:51', null);
INSERT INTO `jxzy_zyll` VALUES ('155', '199', '19', '2018-03-07 17:00:03', null);
INSERT INTO `jxzy_zyll` VALUES ('156', '202', '19', '2018-09-10 09:23:30', null);
INSERT INTO `jxzy_zyll` VALUES ('157', '214', '19', '2018-03-07 10:06:49', null);
INSERT INTO `jxzy_zyll` VALUES ('158', '206', '19', '2018-06-25 15:31:57', null);
INSERT INTO `jxzy_zyll` VALUES ('159', '208', '19', '2018-03-07 17:00:16', null);
INSERT INTO `jxzy_zyll` VALUES ('160', '213', '19', '2018-03-07 10:07:19', null);
INSERT INTO `jxzy_zyll` VALUES ('161', '206', '20', '2018-03-07 16:56:01', null);
INSERT INTO `jxzy_zyll` VALUES ('162', '218', '20', '2018-03-07 13:30:54', null);
INSERT INTO `jxzy_zyll` VALUES ('163', '200', '20', '2018-03-07 13:33:18', null);
INSERT INTO `jxzy_zyll` VALUES ('164', '203', '20', '2018-03-07 13:33:29', null);
INSERT INTO `jxzy_zyll` VALUES ('165', '215', '3', '2018-09-11 10:42:57', null);
INSERT INTO `jxzy_zyll` VALUES ('166', '215', '20', '2018-03-07 16:54:45', null);
INSERT INTO `jxzy_zyll` VALUES ('167', '208', '20', '2018-03-07 13:55:11', null);
INSERT INTO `jxzy_zyll` VALUES ('168', '203', '3', '2018-03-07 14:31:57', null);
INSERT INTO `jxzy_zyll` VALUES ('169', '201', '3', '2018-04-10 16:33:29', null);
INSERT INTO `jxzy_zyll` VALUES ('170', '218', '3', '2018-09-05 16:20:12', null);
INSERT INTO `jxzy_zyll` VALUES ('171', '214', '3', '2018-03-07 14:43:12', null);
INSERT INTO `jxzy_zyll` VALUES ('172', '199', '3', '2018-03-07 15:08:42', null);
INSERT INTO `jxzy_zyll` VALUES ('173', '210', '20', '2018-03-07 16:54:13', null);
INSERT INTO `jxzy_zyll` VALUES ('174', '213', '20', '2018-03-07 16:55:31', null);
INSERT INTO `jxzy_zyll` VALUES ('175', '215', '21', '2018-03-08 11:24:00', null);
INSERT INTO `jxzy_zyll` VALUES ('176', '197', '21', '2018-03-08 11:24:19', null);
INSERT INTO `jxzy_zyll` VALUES ('177', '201', '21', '2018-03-08 11:24:30', null);
INSERT INTO `jxzy_zyll` VALUES ('178', '214', '21', '2018-03-08 09:24:32', null);
INSERT INTO `jxzy_zyll` VALUES ('179', '211', '21', '2018-03-08 09:24:40', null);
INSERT INTO `jxzy_zyll` VALUES ('180', '212', '21', '2018-03-08 09:24:50', null);
INSERT INTO `jxzy_zyll` VALUES ('181', '209', '21', '2018-03-08 09:25:09', null);
INSERT INTO `jxzy_zyll` VALUES ('182', '206', '21', '2018-03-08 09:25:44', null);
INSERT INTO `jxzy_zyll` VALUES ('183', '221', '3', '2018-09-06 14:16:35', null);
INSERT INTO `jxzy_zyll` VALUES ('184', '222', '3', '2018-03-13 11:58:27', null);
INSERT INTO `jxzy_zyll` VALUES ('185', '223', '3', '2018-03-13 13:28:17', null);
INSERT INTO `jxzy_zyll` VALUES ('186', '224', '3', '2018-04-10 16:00:03', null);
INSERT INTO `jxzy_zyll` VALUES ('187', '225', '3', '2018-03-13 15:02:49', null);
INSERT INTO `jxzy_zyll` VALUES ('188', '226', '3', '2018-04-10 16:31:52', null);
INSERT INTO `jxzy_zyll` VALUES ('189', '223', '24', '2018-04-03 10:49:52', null);
INSERT INTO `jxzy_zyll` VALUES ('190', '94', '24', '2018-04-03 10:50:00', null);
INSERT INTO `jxzy_zyll` VALUES ('191', '194', '24', '2018-04-03 10:50:53', null);
INSERT INTO `jxzy_zyll` VALUES ('192', '215', '24', '2018-04-03 10:51:57', null);
INSERT INTO `jxzy_zyll` VALUES ('193', '218', '19', '2018-04-08 13:56:15', null);
INSERT INTO `jxzy_zyll` VALUES ('194', '194', '3', '2018-09-06 15:24:02', null);
INSERT INTO `jxzy_zyll` VALUES ('195', '231', '3', '2018-06-29 09:26:28', null);
INSERT INTO `jxzy_zyll` VALUES ('196', '195', '3', '2018-09-06 13:44:57', null);
INSERT INTO `jxzy_zyll` VALUES ('197', '223', '19', '2018-04-11 16:19:57', null);
INSERT INTO `jxzy_zyll` VALUES ('198', '222', '19', '2018-04-11 16:20:05', null);
INSERT INTO `jxzy_zyll` VALUES ('199', '94', '28', '2018-04-12 09:14:58', null);
INSERT INTO `jxzy_zyll` VALUES ('200', '199', '28', '2018-04-12 09:14:02', null);
INSERT INTO `jxzy_zyll` VALUES ('201', '223', '28', '2018-04-12 09:14:07', null);
INSERT INTO `jxzy_zyll` VALUES ('202', '201', '28', '2018-04-12 09:14:14', null);
INSERT INTO `jxzy_zyll` VALUES ('203', '192', '28', '2018-04-12 09:14:27', null);
INSERT INTO `jxzy_zyll` VALUES ('204', '222', '28', '2018-04-12 09:14:53', null);
INSERT INTO `jxzy_zyll` VALUES ('205', '94', '21', '2018-04-15 08:15:55', null);
INSERT INTO `jxzy_zyll` VALUES ('206', '221', '19', '2018-06-25 15:31:42', null);
INSERT INTO `jxzy_zyll` VALUES ('207', '238', '3', '2018-09-05 15:55:02', null);
INSERT INTO `jxzy_zyll` VALUES ('208', '222', '16', '2018-09-05 17:49:26', null);
INSERT INTO `jxzy_zyll` VALUES ('209', '231', '16', '2018-09-05 17:49:34', null);
INSERT INTO `jxzy_zyll` VALUES ('210', '214', '16', '2018-09-05 17:49:53', null);
INSERT INTO `jxzy_zyll` VALUES ('211', '239', '3', '2018-09-06 17:33:56', null);
INSERT INTO `jxzy_zyll` VALUES ('212', '240', '3', '2018-09-06 15:32:16', null);
INSERT INTO `jxzy_zyll` VALUES ('213', '241', '3', '2018-09-11 11:06:10', null);
INSERT INTO `jxzy_zyll` VALUES ('214', '242', '3', '2018-09-06 17:47:47', null);
INSERT INTO `jxzy_zyll` VALUES ('215', '243', '3', '2018-09-06 18:03:48', null);
INSERT INTO `jxzy_zyll` VALUES ('216', '197', '3', '2018-09-11 09:59:02', null);
INSERT INTO `jxzy_zyll` VALUES ('217', '244', '3', '2018-09-11 13:20:26', null);
INSERT INTO `jxzy_zyll` VALUES ('218', '245', '3', '2018-09-11 11:18:17', null);
INSERT INTO `jxzy_zyll` VALUES ('219', '243', '16', '2018-09-11 13:15:01', null);
INSERT INTO `jxzy_zyll` VALUES ('220', '240', '16', '2018-09-11 13:15:10', null);
INSERT INTO `jxzy_zyll` VALUES ('221', '248', '3', '2018-09-11 13:18:10', null);
INSERT INTO `jxzy_zyll` VALUES ('222', '246', '3', '2018-09-11 13:20:00', null);
INSERT INTO `jxzy_zyll` VALUES ('223', '247', '3', '2018-09-11 13:20:09', null);

-- ----------------------------
-- Table structure for jxzy_zypl
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zypl`;
CREATE TABLE `jxzy_zypl` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYID` int(11) DEFAULT NULL COMMENT '资源ID',
  `PLNR` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `PLRID` int(11) DEFAULT NULL COMMENT '评论人ID',
  `PLRLX` varchar(255) DEFAULT NULL COMMENT '评论人类型',
  `PLRXM` varchar(255) DEFAULT NULL COMMENT '评论人姓名',
  `PLSJ` datetime DEFAULT NULL COMMENT '评论时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  `LX` int(11) DEFAULT '1' COMMENT '默认1为评论，2为回复',
  `PLS` varchar(255) DEFAULT NULL COMMENT '评论的是谁',
  `ZYMC` varchar(255) DEFAULT NULL COMMENT '资源名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='资源评论表';

-- ----------------------------
-- Records of jxzy_zypl
-- ----------------------------
INSERT INTO `jxzy_zypl` VALUES ('46', '29', '确实不错！！', '3', null, '杨帆', '2018-01-29 10:10:26', null, '1', null, '微观经济学CAP');
INSERT INTO `jxzy_zypl` VALUES ('47', '29', '挺好的', '3', null, '杨帆', '2018-01-29 10:50:03', null, '1', null, '微观经济学CAP');
INSERT INTO `jxzy_zypl` VALUES ('48', '94', '这本书不错，找了好久终于等到了<img src=\"http://192.168.6.225:8083/RCM/portal/js/lib/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://192.168.6.225:8083/RCM/portal/js/lib/layui/images/face/16.gif\" alt=\"[太开心]\">', '3', null, '杨帆', '2018-01-29 14:44:48', null, '1', null, 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('59', '109', '挺好的！', '3', null, '杨帆', '2018-02-05 17:04:35', null, '1', null, '哲学');
INSERT INTO `jxzy_zypl` VALUES ('60', '109', '同意~', '19', null, '张三', '2018-02-05 17:05:27', null, '2', '杨帆', '哲学');
INSERT INTO `jxzy_zypl` VALUES ('61', '113', '挺好的！', '26', null, '周元', '2018-02-06 09:31:39', null, '1', null, '基本法');
INSERT INTO `jxzy_zypl` VALUES ('63', '192', '不错，挺详细的', '20', null, '李海飞', '2018-03-01 14:26:22', null, '1', null, 'JavaWeb课件');
INSERT INTO `jxzy_zypl` VALUES ('64', '94', '<img src=\"http://192.168.6.225:8038/RCM/portal/js/lib/layui/images/face/49.gif\" alt=\"[猪头]\">', '3', null, '李明敏', '2018-04-10 16:58:36', null, '1', null, 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('65', '94', '<img src=\"http://192.168.6.225:8038/RCM/portal/js/lib/layui/images/face/2.gif\" alt=\"[哈哈]\"><img src=\"http://192.168.6.225:8038/RCM/portal/js/lib/layui/images/face/53.gif\" alt=\"[耶]\">', '3', null, '李明敏', '2018-04-10 16:59:23', null, '1', null, 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('66', '94', '<p style=\"text-align: center;\">第三方</p>', '3', null, '李明敏', '2018-04-10 16:59:30', null, '1', null, 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('67', '94', '<p style=\"text-align: right;\">地方</p>', '3', null, '李明敏', '2018-04-10 16:59:36', null, '1', null, 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('69', '94', '爱的色放', '3', null, '李明敏', '2018-04-10 16:59:55', null, '2', '李明敏', 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('70', '94', '呵呵', '3', null, '李明敏', '2018-04-10 17:00:09', null, '2', '李明敏', 'Java并发编程');
INSERT INTO `jxzy_zypl` VALUES ('71', '214', 'er', '16', null, '吴天', '2018-09-05 17:49:45', null, '1', null, '大数据时代');
INSERT INTO `jxzy_zypl` VALUES ('72', '214', 'fadsf', '16', null, '吴天', '2018-09-05 17:49:47', null, '1', null, '大数据时代');
INSERT INTO `jxzy_zypl` VALUES ('73', '214', 'fsa', '16', null, '吴天', '2018-09-05 17:49:50', null, '1', null, '大数据时代');
INSERT INTO `jxzy_zypl` VALUES ('74', '214', 'fads', '16', null, '吴天', '2018-09-05 17:49:51', null, '1', null, '大数据时代');
INSERT INTO `jxzy_zypl` VALUES ('75', '214', 'fads', '16', null, '吴天', '2018-09-05 17:49:53', null, '1', null, '大数据时代');

-- ----------------------------
-- Table structure for jxzy_zyplhf
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zyplhf`;
CREATE TABLE `jxzy_zyplhf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PLID` varchar(255) DEFAULT NULL COMMENT '评论ID',
  `HFNR` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `HFRID` int(11) DEFAULT NULL COMMENT '回复人ID',
  `HFRLX` varchar(255) DEFAULT NULL COMMENT '回复人类型',
  `HFRXM` varchar(255) DEFAULT NULL COMMENT '回复人姓名',
  `HFSJ` datetime DEFAULT NULL COMMENT '回复时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='资源评论回复表';

-- ----------------------------
-- Records of jxzy_zyplhf
-- ----------------------------
INSERT INTO `jxzy_zyplhf` VALUES ('2', '1', '你好啊', '666', '学生', '张三', '2018-01-05 14:16:27', '1');
INSERT INTO `jxzy_zyplhf` VALUES ('3', '2', 'OK', '888', '学生', '李四', '2018-01-16 14:17:04', '2');
INSERT INTO `jxzy_zyplhf` VALUES ('4', '2', 'gdsag', '3', null, '杨帆', '2018-01-19 15:13:36', null);
INSERT INTO `jxzy_zyplhf` VALUES ('5', '2', 'fdsafgasdgasd', '3', null, '杨帆', '2018-01-19 15:15:55', null);
INSERT INTO `jxzy_zyplhf` VALUES ('6', '2', 'fasdgasgasdg', '3', null, '杨帆', '2018-01-19 15:17:18', null);
INSERT INTO `jxzy_zyplhf` VALUES ('7', '2', '666', '3', null, '杨帆', '2018-01-19 15:22:30', null);
INSERT INTO `jxzy_zyplhf` VALUES ('8', '2', 'fasgasdg', '3', null, '杨帆', '2018-01-19 15:25:07', null);
INSERT INTO `jxzy_zyplhf` VALUES ('9', '2', '777', '3', null, '杨帆', '2018-01-19 15:26:14', null);
INSERT INTO `jxzy_zyplhf` VALUES ('10', '13', 'gdfgdfsgsdfg', '3', null, '杨帆', '2018-01-19 15:28:50', null);
INSERT INTO `jxzy_zyplhf` VALUES ('11', '3', 'gasdg', '3', null, '杨帆', '2018-01-19 15:29:59', null);
INSERT INTO `jxzy_zyplhf` VALUES ('12', '13', 'gdfgdfsgsdfg', '3', null, '杨帆', '2018-01-19 15:30:55', null);
INSERT INTO `jxzy_zyplhf` VALUES ('13', '14', '发生大法师', '3', null, '杨帆', '2018-01-19 15:31:49', null);
INSERT INTO `jxzy_zyplhf` VALUES ('14', '3', '发生过傻大个', '3', null, '杨帆', '2018-01-19 15:40:36', null);
INSERT INTO `jxzy_zyplhf` VALUES ('15', '13', '固定撒', '3', null, '杨帆', '2018-01-19 15:42:20', null);
INSERT INTO `jxzy_zyplhf` VALUES ('16', '3', 'gdsadgas', '3', null, '杨帆', '2018-01-19 15:45:14', null);
INSERT INTO `jxzy_zyplhf` VALUES ('17', '3', 'gasdgas', '3', null, '杨帆', '2018-01-19 15:46:54', null);
INSERT INTO `jxzy_zyplhf` VALUES ('18', '3', 'gasdgas', '3', null, '杨帆', '2018-01-19 15:47:03', null);
INSERT INTO `jxzy_zyplhf` VALUES ('19', '3', 'gdsadfgasdfsad', '3', null, '杨帆', '2018-01-19 15:47:59', null);
INSERT INTO `jxzy_zyplhf` VALUES ('20', '3', 'gdsadfgasdfsadfdsfas', '3', null, '杨帆', '2018-01-19 15:51:00', null);
INSERT INTO `jxzy_zyplhf` VALUES ('21', '3', 'fdsafdsf', '3', null, '杨帆', '2018-01-19 15:52:14', null);
INSERT INTO `jxzy_zyplhf` VALUES ('22', '3', 'gfdgsdfg', '3', null, '杨帆', '2018-01-19 15:53:19', null);
INSERT INTO `jxzy_zyplhf` VALUES ('23', '3', 'gfdsgsdf', '3', null, '杨帆', '2018-01-19 15:57:41', null);
INSERT INTO `jxzy_zyplhf` VALUES ('24', '13', 'gdsagasd', '3', null, '杨帆', '2018-01-19 15:58:19', null);
INSERT INTO `jxzy_zyplhf` VALUES ('25', '16', '好的', '3', null, '杨帆', '2018-01-19 15:59:07', null);
INSERT INTO `jxzy_zyplhf` VALUES ('26', '15', '华东师范', '3', null, '杨帆', '2018-01-19 15:59:29', null);
INSERT INTO `jxzy_zyplhf` VALUES ('27', '17', '还好吧', '3', null, '杨帆', '2018-01-19 16:00:34', null);
INSERT INTO `jxzy_zyplhf` VALUES ('28', '3', '高达杀手', '3', null, '杨帆', '2018-01-19 16:01:17', null);
INSERT INTO `jxzy_zyplhf` VALUES ('29', '15', '法撒旦法啊', '3', null, '杨帆', '2018-01-19 16:01:23', null);
INSERT INTO `jxzy_zyplhf` VALUES ('30', '3', '法撒旦法', '3', null, '杨帆', '2018-01-19 16:01:44', null);
INSERT INTO `jxzy_zyplhf` VALUES ('31', '13', '固定撒蛋糕', '3', null, '杨帆', '2018-01-19 16:01:50', null);
INSERT INTO `jxzy_zyplhf` VALUES ('32', '13', '干啥的噶多少', '3', null, '杨帆', '2018-01-19 16:03:09', null);
INSERT INTO `jxzy_zyplhf` VALUES ('33', '3', 'gdsadaf&nbsp;', '3', null, '杨帆', '2018-01-19 16:09:55', null);
INSERT INTO `jxzy_zyplhf` VALUES ('34', '13', 'gdsadgas', '3', null, '杨帆', '2018-01-19 16:10:03', null);
INSERT INTO `jxzy_zyplhf` VALUES ('35', '13', 'gdsadgas', '3', null, '杨帆', '2018-01-19 16:15:16', null);
INSERT INTO `jxzy_zyplhf` VALUES ('36', '3', 'fdsafa', '3', null, '杨帆', '2018-01-19 16:28:54', null);
INSERT INTO `jxzy_zyplhf` VALUES ('37', '17', '噶多少', '3', null, '杨帆', '2018-01-19 17:04:55', null);

-- ----------------------------
-- Table structure for jxzy_zysc
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zysc`;
CREATE TABLE `jxzy_zysc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYID` int(11) DEFAULT NULL COMMENT '资源ID',
  `SCRID` int(11) DEFAULT NULL COMMENT '收藏人ID',
  `SCSJ` datetime DEFAULT NULL COMMENT '收藏时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='资源收藏表';

-- ----------------------------
-- Records of jxzy_zysc
-- ----------------------------
INSERT INTO `jxzy_zysc` VALUES ('47', '4', '19', '2018-01-22 16:52:40', null);
INSERT INTO `jxzy_zysc` VALUES ('48', '93', '3', '2018-01-26 09:50:10', null);
INSERT INTO `jxzy_zysc` VALUES ('51', '101', '19', '2018-01-30 09:59:47', null);
INSERT INTO `jxzy_zysc` VALUES ('54', '109', '3', '2018-02-05 17:03:45', null);
INSERT INTO `jxzy_zysc` VALUES ('55', '29', '3', '2018-02-07 11:02:12', null);
INSERT INTO `jxzy_zysc` VALUES ('56', '139', '3', '2018-02-08 16:45:28', null);
INSERT INTO `jxzy_zysc` VALUES ('58', '203', '21', '2018-03-01 11:43:47', null);
INSERT INTO `jxzy_zysc` VALUES ('59', '192', '20', '2018-03-01 13:49:10', null);
INSERT INTO `jxzy_zysc` VALUES ('60', '94', '3', '2018-03-07 15:07:13', null);
INSERT INTO `jxzy_zysc` VALUES ('62', '231', '3', '2018-06-29 09:26:36', null);

-- ----------------------------
-- Table structure for jxzy_zyxz
-- ----------------------------
DROP TABLE IF EXISTS `jxzy_zyxz`;
CREATE TABLE `jxzy_zyxz` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ZYID` varchar(255) DEFAULT NULL COMMENT '资源ID',
  `XZRID` varchar(255) DEFAULT NULL COMMENT '下载人ID',
  `XZSJ` datetime DEFAULT NULL COMMENT '下载时间',
  `XXID` varchar(255) DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='资源下载表';

-- ----------------------------
-- Records of jxzy_zyxz
-- ----------------------------
INSERT INTO `jxzy_zyxz` VALUES ('19', '63', '3', '2018-01-25 14:42:59', null);
INSERT INTO `jxzy_zyxz` VALUES ('25', '29', '19', '2018-01-31 09:54:39', null);
INSERT INTO `jxzy_zyxz` VALUES ('26', '59', '3', '2018-01-31 13:59:18', null);
INSERT INTO `jxzy_zyxz` VALUES ('27', '27', '3', '2018-01-31 13:59:37', null);
INSERT INTO `jxzy_zyxz` VALUES ('28', '27', '19', '2018-02-01 15:52:52', null);
INSERT INTO `jxzy_zyxz` VALUES ('29', '29', '3', '2018-02-02 14:04:23', null);
INSERT INTO `jxzy_zyxz` VALUES ('30', '4', '3', '2018-02-02 14:11:23', null);
INSERT INTO `jxzy_zyxz` VALUES ('31', '4', '19', '2018-02-02 17:48:25', null);
INSERT INTO `jxzy_zyxz` VALUES ('32', '109', '3', '2018-02-05 17:03:46', null);
INSERT INTO `jxzy_zyxz` VALUES ('33', '113', '26', '2018-02-06 09:29:57', null);
INSERT INTO `jxzy_zyxz` VALUES ('34', '141', '3', '2018-02-08 16:27:47', null);
INSERT INTO `jxzy_zyxz` VALUES ('35', '143', '3', '2018-02-08 16:45:56', null);
INSERT INTO `jxzy_zyxz` VALUES ('36', '142', '3', '2018-02-08 16:53:52', null);
INSERT INTO `jxzy_zyxz` VALUES ('37', '163', '3', '2018-02-08 17:51:20', null);
INSERT INTO `jxzy_zyxz` VALUES ('38', '172', '3', '2018-02-27 11:14:15', null);
INSERT INTO `jxzy_zyxz` VALUES ('39', '180', '3', '2018-02-27 16:46:37', null);
INSERT INTO `jxzy_zyxz` VALUES ('40', '168', '3', '2018-02-27 17:35:34', null);
INSERT INTO `jxzy_zyxz` VALUES ('41', '192', '20', '2018-03-01 14:24:49', null);
INSERT INTO `jxzy_zyxz` VALUES ('42', '214', '24', '2018-03-02 09:05:20', null);
INSERT INTO `jxzy_zyxz` VALUES ('43', '218', '20', '2018-03-07 13:31:06', null);
INSERT INTO `jxzy_zyxz` VALUES ('44', '94', '3', '2018-03-07 15:07:16', null);
INSERT INTO `jxzy_zyxz` VALUES ('45', '215', '21', '2018-03-08 09:09:34', null);
INSERT INTO `jxzy_zyxz` VALUES ('46', '222', '3', '2018-03-13 11:52:06', null);
INSERT INTO `jxzy_zyxz` VALUES ('47', '224', '3', '2018-03-13 13:54:18', null);
INSERT INTO `jxzy_zyxz` VALUES ('48', '192', '3', '2018-04-10 15:58:41', null);
INSERT INTO `jxzy_zyxz` VALUES ('49', '221', '3', '2018-04-10 15:59:35', null);
INSERT INTO `jxzy_zyxz` VALUES ('50', '201', '3', '2018-04-10 16:00:08', null);
INSERT INTO `jxzy_zyxz` VALUES ('51', '194', '3', '2018-04-10 16:00:31', null);
INSERT INTO `jxzy_zyxz` VALUES ('52', '231', '3', '2018-04-10 16:31:47', null);
INSERT INTO `jxzy_zyxz` VALUES ('53', '195', '3', '2018-04-10 17:06:12', null);
INSERT INTO `jxzy_zyxz` VALUES ('54', '192', '19', '2018-04-11 15:30:48', null);
INSERT INTO `jxzy_zyxz` VALUES ('55', '243', '3', '2018-09-06 18:08:07', null);

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `PID` int(11) DEFAULT NULL COMMENT '父',
  `LINK` varchar(255) DEFAULT NULL COMMENT '链接',
  `ISSHOW` varchar(255) DEFAULT NULL COMMENT '显示',
  `INFO` varchar(255) DEFAULT NULL COMMENT '说明',
  `PICICO` varchar(255) DEFAULT NULL COMMENT '图标',
  `PICIMG` varchar(255) DEFAULT NULL COMMENT '图片',
  `ORD` int(11) DEFAULT NULL COMMENT '排序',
  `TREETRACK` varchar(255) DEFAULT NULL COMMENT '树序',
  `MODULENAME` varchar(255) DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='功能';

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('1', '机构同步', '5', '/sysManage/transact.do?method=synchOrgan', '0', '通讯平台机构同步。', '', '', '14', '5-h-1', 'sys');
INSERT INTO `sys_function` VALUES ('5', '系统根目录', '0', '/root', '1', '系统所用功能的根节点。', '', '', '1', '5', 'sys');
INSERT INTO `sys_function` VALUES ('6', '系统管理', '5', '/sysmanage', '1', '系统管理模块根节点。', '', 'xtglm.png', '13', '5-6', 'sys');
INSERT INTO `sys_function` VALUES ('9', '用户管理', '6', '/sysmanage/user/page.action?page=user_sch', '1', '管理系统内用户，对用户的增删改查操作。', '/imgs/sysmanage/icon_user.png', 'yhgl.gif', '4', '5-6-9', 'sys');
INSERT INTO `sys_function` VALUES ('10', '角色管理', '6', '/sysmanage/role/page.action?page=role_sch', '1', '管理系统内角色，对角色的增删改查操作。', '/imgs/sysmanage/icon_role.png', 'jsgl.gif', '5', '5-6-a', 'sys');
INSERT INTO `sys_function` VALUES ('11', '功能管理', '6', '/sysmanage/function/page.action?page=function_upd', '1', '管理系统内功能树，对功能的增删改查操作。', '/imgs/sysmanage/icon_function.png', 'gngl.gif', '7', '5-6-b', 'sys');
INSERT INTO `sys_function` VALUES ('12', '功能全能', '11', '/sysManage/function/\\D*', '0', '功能管理的所有权限。', '', '', '8', '5-6-b-c', 'sys');
INSERT INTO `sys_function` VALUES ('13', '功能单元全能', '8', '/sysManage/functionUnit/\\D*', '0', '功能单元管理的所有权限。', '', '', '9', '5-6-8-d', 'sys');
INSERT INTO `sys_function` VALUES ('14', '角色全能', '10', '/sysManage/role/\\D*', '0', '角色管理的所有权限。', '', '', '10', '5-6-a-e', 'sys');
INSERT INTO `sys_function` VALUES ('15', '用户全能', '9', '/sysManage/user/\\D*', '0', '用户管理的所有权限。', '', '', '11', '5-6-9-f', 'sys');
INSERT INTO `sys_function` VALUES ('16', '机构全能', '7', '/sysmanage/organ/\\D*', '0', '机构管理的所有权限。', '', '', '12', '5-6-7-g', 'sys');
INSERT INTO `sys_function` VALUES ('20', '资源管理模块', '5', '/', '1', '', '/imgs/company/xsgl.png', '', null, '', '');
INSERT INTO `sys_function` VALUES ('21', '资源信息管理', '20', '/zygl/zy/page.action?page=zy_sch', '1', '', '/imgs/company/zy.png', '', null, '', '');
INSERT INTO `sys_function` VALUES ('22', '资源评论管理', '20', '/zygl/zypl/page.action?page=zypl_sch', '1', null, '/imgs/company/ms.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('24', '资源收藏', '20', '/zygl/zysc/page.action?page=zysc_sch', '1', null, '/imgs/company/zysy.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('25', '资源下载', '20', '/zygl/zyxz/page.action?page=zyxz_sch', '1', null, '/imgs/company/xsgl.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('26', '资源浏览', '20', '/zygl/zyll/page.action?page=zyll_sch', '1', null, '/imgs/company/jyhgl.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('27', '通知公告', '30', '/zygl/tzgg/page.action?page=tzgg_sch', '1', null, '/imgs/company/gzlb.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('28', '资源类型管理', '29', '/zygl/xklb/page.action?page=xklb_sch', '1', null, '/imgs/sms/jk_tz_o.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('29', '基础信息管理', '20', '/', '1', null, '/imgs/company/xsgl.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('30', '通知公告管理', '20', '/', '1', null, '/imgs/company/xsgl.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('31', '统计', '5', '/', '1', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('32', '资源相关统计', '31', '/zygl/bbList/page.action?page=stat_sch', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('33', '等级信息管理', '29', '/zygl/djxx/page.action?page=djxx_sch', '1', null, '/imgs/sms/jygl_jyjg_o.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('34', '资源下载统计', '31', '/zygl/zyxz/page.action?page=zyxz_tj', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('35', '资源评论统计', '31', '/zygl/zypl/page.action?page=zypl_tj', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('36', '资源综合查询', '31', '/zygl/zy/page.action?page=zy_tj_sch', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('37', '资源审核记录', '31', '/zygl/zy/page.action?page=zy_shtj_sch', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('38', '共享资源统计', '31', '/zygl/zy/page.action?page=zy_dxsltj_sch', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('39', '教职工资源统计', '31', '/zygl/zy/page.action?page=zy_scrdxsltj_sch', '1', null, '/imgs/company/mssytj.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('40', '网站设置', '29', '/zygl/wzsz/page.action?page=wzsz_upd', '1', null, '/imgs/sms/bysgl_xljl_o.png', null, null, null, null);
INSERT INTO `sys_function` VALUES ('41', '文件转换管理', '5', '/', '1', null, null, null, null, null, null);
INSERT INTO `sys_function` VALUES ('42', '未转换成功文件', '41', '/zygl/zy/page.action?page=zywj_sch', '1', null, '/imgs/company/zy.png', null, null, null, null);

-- ----------------------------
-- Table structure for sys_functionunit
-- ----------------------------
DROP TABLE IF EXISTS `sys_functionunit`;
CREATE TABLE `sys_functionunit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) DEFAULT NULL COMMENT '功能单元名称',
  `INFO` varchar(255) DEFAULT NULL COMMENT '功能单元说明',
  `ORD` int(11) DEFAULT NULL COMMENT '排序',
  `PICICO` varchar(255) DEFAULT NULL COMMENT '功能单元图标',
  `MODULENAME` varchar(255) DEFAULT NULL COMMENT '模块类别',
  `FUNCS` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='功能单元';

-- ----------------------------
-- Records of sys_functionunit
-- ----------------------------
INSERT INTO `sys_functionunit` VALUES ('1', '系统管理', '系统管理功能单元。', '1', '', 'sys', '');
INSERT INTO `sys_functionunit` VALUES ('2', '教工信息管理', '教工信息管理', null, '', '', '');

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '标题',
  `keyword` varchar(255) DEFAULT NULL COMMENT '关键词',
  `funcs` varchar(255) DEFAULT NULL COMMENT '功能根集合',
  `link` varchar(255) DEFAULT NULL COMMENT '外链',
  `info` varchar(255) DEFAULT NULL COMMENT '说明',
  `ord` int(255) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='功能模块';

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('1', '系统管理', 'sys', '9,10,11', null, '系统管理模块', '1', '/common/mico/sys.png');
INSERT INTO `sys_module` VALUES ('2', '基础信息管理', 'jcxxgl', '28,33,40', null, '基础信息管理', null, '/common/mico/jyxxgl.png');
INSERT INTO `sys_module` VALUES ('3', '资源管理', 'zygl', '21,22,24,25,26', null, '资源管理模块', null, '/common/mico/ygxx.png');
INSERT INTO `sys_module` VALUES ('5', '通知公告管理', 'ttgggl', '27', null, '通知公告管理', null, '/common/mico/xsmsqk.png');
INSERT INTO `sys_module` VALUES ('6', '统计', 'tj', '34,35,36,37,38,39', null, '统计模块', null, '/common/mico/tj.png');
INSERT INTO `sys_module` VALUES ('7', '文件转换管理', 'wj', '42', null, '文件转换管理模块', null, '/common/mico/ygxx.png');

-- ----------------------------
-- Table structure for sys_organ
-- ----------------------------
DROP TABLE IF EXISTS `sys_organ`;
CREATE TABLE `sys_organ` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PID` int(11) DEFAULT NULL COMMENT '父',
  `NAME` varchar(255) DEFAULT NULL COMMENT '机构名称',
  `ISMASTER` varchar(255) DEFAULT NULL COMMENT '是否机构',
  `INFO` varchar(255) DEFAULT NULL COMMENT '说明',
  `ORD` int(11) DEFAULT NULL COMMENT '排序',
  `TREETRACK` varchar(255) DEFAULT NULL COMMENT '树结构路径',
  `CODE` varchar(255) DEFAULT NULL COMMENT '机构编码',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '机构类型',
  `APPID` varchar(255) DEFAULT NULL COMMENT '子应用',
  `FUNCUNITS` varchar(255) DEFAULT NULL,
  `ROLES` varchar(255) DEFAULT NULL,
  `SID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='机构';

-- ----------------------------
-- Records of sys_organ
-- ----------------------------
INSERT INTO `sys_organ` VALUES ('1', null, '星火职教中心', '1', '所有机构的根，不能删除。', '1', '1', 'biggest_1', '', 'sys', '', '', null);
INSERT INTO `sys_organ` VALUES ('2', '1', '行政机构', '1', '数学系机构', '2', '1-2', '', '', 'sys', '', '', null);
INSERT INTO `sys_organ` VALUES ('3', '1', '数学学院', '1', '', null, '1-3', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('4', '2', '教务处', '2', '数学学院教务处', null, '1-2-4', '', '', '', '', null, null);
INSERT INTO `sys_organ` VALUES ('5', '2', '财务处', '2', '数学学院财务处', null, '1-2-5', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('6', '2', '学生处', '2', '', null, '1-2-6', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('7', '2', '招生办', '2', '是多少v从', null, '1-2-7', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('9', '1', '英语学院', '1', '', null, '1-9', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('10', null, '星火幼儿园', '1', '', null, '', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('11', null, '星火小学', '1', '', null, '', '', '', '', '', '', '36');
INSERT INTO `sys_organ` VALUES ('12', null, '星火中学', '1', '', null, '', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('13', '10', '教务处', '1', '', null, '-13', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('14', '10', '财务处', '1', '', null, '-14', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('15', '10', '学生处', '1', '', null, '-15', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('16', '10', '招生办', '1', '', null, '-16', '', '', '', '', '', null);
INSERT INTO `sys_organ` VALUES ('17', null, '授权中心', '1', '', '0', '', '', '', '', '', '', '36');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `ISLOCAL` varchar(255) DEFAULT NULL COMMENT '是否全局角色',
  `INFO` varchar(255) DEFAULT NULL COMMENT '说明',
  `ORD` int(11) DEFAULT NULL COMMENT '排序',
  `CLASSIFY` varchar(255) DEFAULT NULL COMMENT '类别',
  `ORGANID` varchar(255) DEFAULT NULL COMMENT '组织机构ID',
  `MODULENAME` varchar(255) DEFAULT NULL COMMENT '模块类别',
  `FUNCS` varchar(1000) DEFAULT NULL COMMENT '功能集',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超系统管理员', '0', '超系统管理员', '1', '1', '1', 'sys', '6,9,10,11');
INSERT INTO `sys_role` VALUES ('13', '资源管理员', '', '资源管理', null, '', '', '', '21,22,29,28,33,40,30,27,31,32,34,35,36,37,38,39,41,42');
INSERT INTO `sys_role` VALUES ('14', '普通人员', '', '', null, '', '', '', '');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOGINNAME` varchar(255) DEFAULT NULL COMMENT '登录名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码',
  `STATE` varchar(255) DEFAULT NULL COMMENT '状态',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '姓名',
  `REGTIME` datetime DEFAULT NULL COMMENT '注册时间',
  `ORGANID` int(11) DEFAULT NULL COMMENT '组织机构ID',
  `QYID` int(11) DEFAULT NULL,
  `XSID` int(11) DEFAULT NULL,
  `CLASSIFY` varchar(255) DEFAULT NULL COMMENT '类型',
  `MODULENAME` varchar(255) DEFAULT NULL COMMENT '模块类别',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `ROLES` varchar(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3', 'javamao', '123456', '', '李明敏', null, null, null, null, '', '', null, '13');
INSERT INTO `sys_user` VALUES ('19', '20180301', '123456', '', '李明', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('20', '20180302', '123456', '', '李海飞', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('21', '20180303', '123456', '', '王柱', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('22', '20180304', '123456', '', '李光华', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('23', '20180305', '123456', '', '赵美丽', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('24', '20180306', '123456', '', '刘宇飞', null, null, null, null, '', '', null, '14');
INSERT INTO `sys_user` VALUES ('28', 'admin', '123456', null, '超级管理员', null, null, null, null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('29', '20180307', '123456', '', '雯雯', null, null, null, null, '', '', null, '14');

-- ----------------------------
-- Table structure for zd_pllx
-- ----------------------------
DROP TABLE IF EXISTS `zd_pllx`;
CREATE TABLE `zd_pllx` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL,
  `LABEL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='是否共享字典';

-- ----------------------------
-- Records of zd_pllx
-- ----------------------------
INSERT INTO `zd_pllx` VALUES ('1', null, '评论');
INSERT INTO `zd_pllx` VALUES ('2', null, '回复');

-- ----------------------------
-- Table structure for zd_sfgx
-- ----------------------------
DROP TABLE IF EXISTS `zd_sfgx`;
CREATE TABLE `zd_sfgx` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL,
  `LABEL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='是否共享字典';

-- ----------------------------
-- Records of zd_sfgx
-- ----------------------------
INSERT INTO `zd_sfgx` VALUES ('1', null, '是');
INSERT INTO `zd_sfgx` VALUES ('2', null, '否');

-- ----------------------------
-- Table structure for zd_shzt
-- ----------------------------
DROP TABLE IF EXISTS `zd_shzt`;
CREATE TABLE `zd_shzt` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL,
  `LABEL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='审核状态字典';

-- ----------------------------
-- Records of zd_shzt
-- ----------------------------
INSERT INTO `zd_shzt` VALUES ('1', null, '待审核');
INSERT INTO `zd_shzt` VALUES ('2', null, '审核通过');
INSERT INTO `zd_shzt` VALUES ('3', null, '未通过');

-- ----------------------------
-- Table structure for zd_zygs
-- ----------------------------
DROP TABLE IF EXISTS `zd_zygs`;
CREATE TABLE `zd_zygs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL,
  `LABEL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='资源状态字典';

-- ----------------------------
-- Records of zd_zygs
-- ----------------------------
INSERT INTO `zd_zygs` VALUES ('1', null, 'DOC');
INSERT INTO `zd_zygs` VALUES ('2', null, 'DOCX');
INSERT INTO `zd_zygs` VALUES ('3', null, 'PPT');
INSERT INTO `zd_zygs` VALUES ('4', null, 'PPTX');
INSERT INTO `zd_zygs` VALUES ('5', null, 'PDF');
INSERT INTO `zd_zygs` VALUES ('6', null, 'XLS');
INSERT INTO `zd_zygs` VALUES ('7', null, 'XLSX');
INSERT INTO `zd_zygs` VALUES ('8', null, 'MP4');
INSERT INTO `zd_zygs` VALUES ('9', null, 'FLV');
INSERT INTO `zd_zygs` VALUES ('10', null, 'AVI');
INSERT INTO `zd_zygs` VALUES ('11', null, 'MOV');
INSERT INTO `zd_zygs` VALUES ('12', null, 'WMV');

-- ----------------------------
-- Table structure for zd_zyzt
-- ----------------------------
DROP TABLE IF EXISTS `zd_zyzt`;
CREATE TABLE `zd_zyzt` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) DEFAULT NULL,
  `LABEL` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资源状态字典';

-- ----------------------------
-- Records of zd_zyzt
-- ----------------------------
INSERT INTO `zd_zyzt` VALUES ('1', null, '私有');
INSERT INTO `zd_zyzt` VALUES ('3', null, '共享');

-- ----------------------------
-- View structure for scrxm_view
-- ----------------------------
DROP VIEW IF EXISTS `scrxm_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`mysql`@`%` SQL SECURITY DEFINER VIEW `scrxm_view` AS select `u`.`ID` AS `ID`,`u`.`LOGINNAME` AS `LOGINNAME`,`u`.`PASSWORD` AS `PASSWORD`,`u`.`STATE` AS `STATE`,`u`.`USERNAME` AS `USERNAME`,`u`.`REGTIME` AS `REGTIME`,`u`.`ORGANID` AS `ORGANID`,`u`.`QYID` AS `QYID`,`u`.`XSID` AS `XSID`,`u`.`CLASSIFY` AS `CLASSIFY`,`u`.`MODULENAME` AS `MODULENAME`,`u`.`BIRTHDAY` AS `BIRTHDAY`,`u`.`ROLES` AS `ROLES` from `sys_user` `u` where (`u`.`ID` in (select `z`.`SCRID` from `jxzy_zy` `z` group by `z`.`SCRID`) and (`u`.`ID` <> 1)) ;

-- ----------------------------
-- View structure for wjgs_view
-- ----------------------------
DROP VIEW IF EXISTS `wjgs_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`mysql`@`%` SQL SECURITY DEFINER VIEW `wjgs_view` AS select ucase(`t`.`WJGS`) AS `id`,'' AS `pid`,ucase(`t`.`WJGS`) AS `label` from `jxzy_zy` `t` group by `t`.`WJGS` ;
