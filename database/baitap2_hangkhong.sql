use flight;
/*
Navicat MySQL Data Transfer

Source Server         : CSLD
Source Server Version : 60003
Source Host           : localhost:3306
Source Database       : baitap2_hangkhong

Target Server Type    : MYSQL
Target Server Version : 60003
File Encoding         : 65001

Date: 2012-05-11 10:04:58
*/

SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for `certificate`
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `MaNV` varchar(9) NOT NULL DEFAULT '',
  `MaMB` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaNV`,`MaMB`),
  KEY `FK_CN2` (`MaMB`),
  CONSTRAINT `FK_CN1` FOREIGN KEY (`MaNV`) REFERENCES `staff` (`MaNV`),
  CONSTRAINT `FK_CN2` FOREIGN KEY (`MaMB`) REFERENCES `airplane` (`MaMB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of certificate
-- ----------------------------
INSERT INTO `certificate` VALUES (1,'269734834', '154');
INSERT INTO `certificate` VALUES (2,'310454876', '154');
INSERT INTO `certificate` VALUES (3,'355548984', '154');
INSERT INTO `certificate` VALUES (4,'574489457', '154');
INSERT INTO `certificate` VALUES (5,'269734834', '319');
INSERT INTO `certificate` VALUES (6,'390487451', '319');
INSERT INTO `certificate` VALUES (7,'552455318', '319');
INSERT INTO `certificate` VALUES (8,'142519864', '320');
INSERT INTO `certificate` VALUES (9,'269734834', '320');
INSERT INTO `certificate` VALUES (10,'390487451', '320');
INSERT INTO `certificate` VALUES (11,'552455318', '320');
INSERT INTO `certificate` VALUES (12,'142519864', '340');
INSERT INTO `certificate` VALUES (13,'269734834', '340');
INSERT INTO `certificate` VALUES (14,'390487451', '340');
INSERT INTO `certificate` VALUES (15,'567354612', '340');
INSERT INTO `certificate` VALUES (16,'269734834', '727');
INSERT INTO `certificate` VALUES (17,'567354612', '727');
INSERT INTO `certificate` VALUES (18,'011564812', '737');
INSERT INTO `certificate` VALUES (19,'141582651', '737');
INSERT INTO `certificate` VALUES (20,'142519864', '737');
INSERT INTO `certificate` VALUES (21,'242518965', '737');
INSERT INTO `certificate` VALUES (22,'269734834', '737');
INSERT INTO `certificate` VALUES (23,'552455318', '737');
INSERT INTO `certificate` VALUES (24,'567354612', '737');
INSERT INTO `certificate` VALUES (25,'142519864', '747');
INSERT INTO `certificate` VALUES (26,'269734834', '747');
INSERT INTO `certificate` VALUES (27,'567354612', '747');
INSERT INTO `certificate` VALUES (28,'011564812', '757');
INSERT INTO `certificate` VALUES (29,'141582651', '757');
INSERT INTO `certificate` VALUES (30,'142519864', '757');
INSERT INTO `certificate` VALUES (31,'242518965', '757');
INSERT INTO `certificate` VALUES (32,'269734834', '757');
INSERT INTO `certificate` VALUES (33,'274878974', '757');
INSERT INTO `certificate` VALUES (34,'567354612', '757');
INSERT INTO `certificate` VALUES (35,'141582651', '767');
INSERT INTO `certificate` VALUES (36,'142519864', '767');
INSERT INTO `certificate` VALUES (37,'269734834', '767');
INSERT INTO `certificate` VALUES (38,'274878974', '767');
INSERT INTO `certificate` VALUES (39,'552455318', '767');
INSERT INTO `certificate` VALUES (40,'567354612', '767');
INSERT INTO `certificate` VALUES (41,'142519864', '777');
INSERT INTO `certificate` VALUES (42,'269734834', '777');
INSERT INTO `certificate` VALUES (43,'567354612', '777');

-- ----------------------------
-- Table structure for `flight`
-- ----------------------------
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `MaCB` varchar(5) NOT NULL,
  `GaDi` varchar(50) DEFAULT NULL,
  `GaDen` varchar(50) DEFAULT NULL,
  `DoDai` int(11) DEFAULT NULL,
  `GioDi` time DEFAULT NULL,
  `GioDen` time DEFAULT NULL,
  `ChiPhi` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaCB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flight
-- ----------------------------
INSERT INTO `flight` VALUES (1,'VN216', 'SGN', 'DIN', '4170', '10:30:00', '14:20:00', '262');
INSERT INTO `flight` VALUES (2,'VN254', 'SGN', 'HUI', '8765', '18:40:00', '20:00:00', '781');
INSERT INTO `flight` VALUES (3,'VN269', 'HAN', 'CXR', '1262', '14:10:00', '15:50:00', '202');
INSERT INTO `flight` VALUES (4,'VN276', 'DAD', 'CXR', '1283', '09:00:00', '12:00:00', '203');
INSERT INTO `flight` VALUES (5,'VN280', 'SGN', 'HPH', '11979', '06:00:00', '08:00:00', '1279');
INSERT INTO `flight` VALUES (6,'VN315', 'HAN', 'DAD', '134', '11:45:00', '13:00:00', '112');
INSERT INTO `flight` VALUES (7,'VN317', 'HAN', 'UIH', '827', '15:00:00', '16:15:00', '190');
INSERT INTO `flight` VALUES (8,'VN320', 'SGN', 'DAD', '2798', '06:00:00', '07:10:00', '221');
INSERT INTO `flight` VALUES (10,'VN338', 'SGN', 'BMV', '4081', '15:25:00', '16:25:00', '375');
INSERT INTO `flight` VALUES (11,'VN374', 'HAN', 'VII', '510', '11:40:00', '13:25:00', '120');
INSERT INTO `flight` VALUES (12,'VN375', 'VII', 'CXR', '752', '14:15:00', '16:00:00', '181');
INSERT INTO `flight` VALUES (13,'VN431', 'SGN', 'CAH', '3693', '05:55:00', '06:55:00', '236');
INSERT INTO `flight` VALUES (14,'VN440', 'SGN', 'BMV', '4081', '18:30:00', '19:30:00', '426');
INSERT INTO `flight` VALUES (15,'VN464', 'SGN', 'DLI', '2002', '07:20:00', '08:05:00', '225');
INSERT INTO `flight` VALUES (16,'VN474', 'PXU', 'PQC', '1586', '08:40:00', '11:20:00', '102');
INSERT INTO `flight` VALUES (17,'VN476', 'UIH', 'PQC', '485', '09:15:00', '11:50:00', '117');
INSERT INTO `flight` VALUES (18,'VN651', 'DAD', 'SGN', '2798', '19:30:00', '08:00:00', '221');
INSERT INTO `flight` VALUES (19,'VN741', 'HAN', 'PXU', '395', '06:30:00', '08:30:00', '120');

-- ----------------------------
-- Table structure for `airplane`
-- ----------------------------
DROP TABLE IF EXISTS `airplane`;
CREATE TABLE `airplane` (
  `MaMB` int(11) NOT NULL DEFAULT '0',
  `Loai` varchar(50) DEFAULT NULL,
  `TamBay` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaMB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of airplane
-- ----------------------------
INSERT INTO `airplane` VALUES (1,'154', 'Tupolev 154', 6565);
INSERT INTO `airplane` VALUES (2,'319', 'Airbus A319', 2888);
INSERT INTO `airplane` VALUES (3,'320', 'Airbus A320', 4168);
INSERT INTO `airplane` VALUES (4,'340', 'Airbus A340 - 300', 11392);
INSERT INTO `airplane` VALUES (5,'727', 'Boeing 727', 2406);
INSERT INTO `airplane` VALUES (6,'737', 'Boeing 737 - 800', 5413);
INSERT INTO `airplane` VALUES (7,'747', 'Boeing 747 - 400', 13488);
INSERT INTO `airplane` VALUES (8,'757', 'Boeing 757 - 300', 6416);
INSERT INTO `airplane` VALUES (9,'767', 'Boeing 767 - 400ER', 10360);
INSERT INTO `airplane` VALUES (10,'777', 'Boeing 777 - 300', 10306);

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `MaNV` varchar(9) NOT NULL DEFAULT '',
  `Ten` varchar(50) DEFAULT NULL,
  `Luong` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
select staff from flight;
INSERT INTO `staff` VALUES (1,'011564812','Ton Van Quy', '153972');
INSERT INTO `staff` VALUES (2,'141582651', 'Doan Thi Mai', '178345');
INSERT INTO `staff` VALUES (3,'142519864', 'Nguyen Thi Xuan Dao', '227489');
INSERT INTO `staff` VALUES (4,'159542516', 'Le Van Ky', '48250');
INSERT INTO `staff` VALUES (5,'242518965', 'Tran Van Son', '120443');
INSERT INTO `staff` VALUES (6,'248965255', 'Tran Thi Ba', '43723');
INSERT INTO `staff` VALUES (7,'254099823', 'Nguyen Thi Quynh', '24450');
INSERT INTO `staff` VALUES (8, '269734834', 'Truong Tuan Anh', '289950');
INSERT INTO `staff` VALUES (9, '274878974', 'Mai Quoc Minh', '99890');
INSERT INTO `staff` VALUES (10, '287321212', 'Duong Van Minh', '48090');
INSERT INTO `staff` VALUES (11, '310454876', 'Ta Van Do', '212156');
INSERT INTO `staff` VALUES (12, '310454877', 'Tran Van Hao', '33546');
INSERT INTO `staff` VALUES (13, '348121549', 'Nguyen Van Thanh', '32899');
INSERT INTO `staff` VALUES (14, '355548984', 'Tran Thi Hoai An', '212156');
INSERT INTO `staff` VALUES (15, '356187925', 'Nguyen Vinh Bao', '44740');
INSERT INTO `staff` VALUES (16, '390487451', 'Le Van Luat', '212156');
INSERT INTO `staff` VALUES (17, '489221823', 'Bui Quoc Chinh', '23980');
INSERT INTO `staff` VALUES (18, '489456522', 'Nguyen Thi Quy Linh', '127984');
INSERT INTO `staff` VALUES (19, '548977562', 'Le Van Quy', '84476');
INSERT INTO `staff` VALUES (20, '550156548', 'Nguyen Thi Cam', '205187');
INSERT INTO `staff` VALUES (21, '552455318', 'La Que', '101745');
INSERT INTO `staff` VALUES (22, '552455348', 'Bui Thi Dung', '92013');
INSERT INTO `staff` VALUES (23, '567354612', 'Quan Cam Ly', '256481');
INSERT INTO `staff` VALUES (24, '574489457', 'Dui Van Lap', '20');
