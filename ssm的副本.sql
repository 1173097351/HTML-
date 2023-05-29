/*
 Navicat Premium Data Transfer

 Source Server         : zhou
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/05/2023 14:21:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agency
-- ----------------------------
DROP TABLE IF EXISTS `agency`;
CREATE TABLE `agency` (
  `distributor_id` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `distributorid_name` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `distributorid_address` varchar(100) DEFAULT NULL,
  `contact_person` varchar(15) DEFAULT NULL,
  `contact_method` varchar(12) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`distributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency
-- ----------------------------
BEGIN;
INSERT INTO `agency` VALUES ('012fb4b8-dd90-11ed-bed6-1f0fee7ca1b5', '周氏家族', '四川省达州市渠县', '周渠岸', '19382120092', NULL, 1);
INSERT INTO `agency` VALUES ('1', '万键集团', '北京', '周渠岸', '88888888', '2023-04-18 21:01:50', 1);
INSERT INTO `agency` VALUES ('17299e46-dd90-11ed-bed6-1f0fee7ca1b5', '周氏家族', '四川省达州市渠县', '周渠岸', '19382120092', NULL, 1);
INSERT INTO `agency` VALUES ('5b9aa9ea-dea7-11ed-bed6-1f0fee7ca1b5', '1', '1', '1', '1', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for agricultural_product_information
-- ----------------------------
DROP TABLE IF EXISTS `agricultural_product_information`;
CREATE TABLE `agricultural_product_information` (
  `agr_id` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `crop_id` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `storage_num` double DEFAULT NULL,
  `in_num` double DEFAULT NULL,
  `out_num` double DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`agr_id`) USING BTREE,
  KEY `crop_id` (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='农产品信息（农产品编号，农作物编号，库存量，进库量，销售量，更新日期，状态）';

-- ----------------------------
-- Records of agricultural_product_information
-- ----------------------------
BEGIN;
INSERT INTO `agricultural_product_information` VALUES ('1', '49865fac-c6ff-11ed-8dfb-d0a4c7f883aa', '草莓', 888, 100, NULL, '2023-04-03 09:43:20', 1);
INSERT INTO `agricultural_product_information` VALUES ('2', '1a0946216-c7c3-11ed-b30d-9930232036af', '苹果', 100, 30, 20, '2023-03-21 17:02:52', 1);
INSERT INTO `agricultural_product_information` VALUES ('3', 'a0946216-c7c3-11ed-b30d-9930232036af', '香蕉', NULL, NULL, NULL, '2023-03-20 17:03:53', 1);
COMMIT;

-- ----------------------------
-- Table structure for agrin
-- ----------------------------
DROP TABLE IF EXISTS `agrin`;
CREATE TABLE `agrin` (
  `agrin` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `agr_id` varchar(85) DEFAULT NULL,
  `in_num` double NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`agrin`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='农产品进库（农产品进库编号，进库量，更新日期，状态）';

-- ----------------------------
-- Records of agrin
-- ----------------------------
BEGIN;
INSERT INTO `agrin` VALUES ('1', '1', 99, '2023-04-03 00:00:00', 1);
INSERT INTO `agrin` VALUES ('476ebbb2-d297-11ed-b49a-1aaf24a5d023', '34a158fc-d1e1-11ed-b49a-1aaf24a5d023', 500, '2023-04-04 11:17:50', 1);
INSERT INTO `agrin` VALUES ('742f7a5e-d2b7-11ed-b49a-1aaf24a5d023', '1', 1, '2023-04-04 15:08:09', 1);
INSERT INTO `agrin` VALUES ('761bcf8a-d20c-11ed-b49a-1aaf24a5d023', '2', 1, '2023-04-03 18:44:08', 1);
INSERT INTO `agrin` VALUES ('793f3120-d20c-11ed-b49a-1aaf24a5d023', '2', 2, '2023-04-03 18:44:13', 1);
INSERT INTO `agrin` VALUES ('8812471e-d20c-11ed-b49a-1aaf24a5d023', '3', 1, '2023-04-03 18:44:38', 1);
INSERT INTO `agrin` VALUES ('89f80cf8-d20c-11ed-b49a-1aaf24a5d023', '3', 2, '2023-04-03 18:44:41', 1);
INSERT INTO `agrin` VALUES ('bb03930c-d44c-11ed-b49a-1aaf24a5d023', 'a4272338-d44c-11ed-b49a-1aaf24a5d023', 1, '2023-04-06 15:29:14', 1);
INSERT INTO `agrin` VALUES ('c4d03710-d202-11ed-b49a-1aaf24a5d023', '1', 3, '2023-04-03 17:34:45', 1);
INSERT INTO `agrin` VALUES ('d51b5d9c-d442-11ed-b49a-1aaf24a5d023', '1', 1, '2023-04-06 14:18:23', 1);
INSERT INTO `agrin` VALUES ('e5451600-d202-11ed-b49a-1aaf24a5d023', '1', 1, '2023-04-03 17:35:40', 1);
COMMIT;

-- ----------------------------
-- Table structure for agrout
-- ----------------------------
DROP TABLE IF EXISTS `agrout`;
CREATE TABLE `agrout` (
  `agrout_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `out_num` double NOT NULL,
  `distributor_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `agr_id` varchar(85) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`agrout_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='农产品销售（农产品销售编号，销售量，经销商编号，更新日期，状态）';

-- ----------------------------
-- Records of agrout
-- ----------------------------
BEGIN;
INSERT INTO `agrout` VALUES ('1', 888, '1', '1', '2023-04-04 00:00:00', 1);
INSERT INTO `agrout` VALUES ('2', 666, '1', '1', '2023-04-04 00:00:00', 1);
INSERT INTO `agrout` VALUES ('544be838-dd90-11ed-bed6-1f0fee7ca1b5', 1, '17299e46-dd90-11ed-bed6-1f0fee7ca1b5', '1', '2023-04-18 10:25:48', 1);
INSERT INTO `agrout` VALUES ('a4101cf8-d44f-11ed-b49a-1aaf24a5d023', 1, '2', '2', '2023-04-06 15:50:04', 1);
COMMIT;

-- ----------------------------
-- Table structure for apply_information
-- ----------------------------
DROP TABLE IF EXISTS `apply_information`;
CREATE TABLE `apply_information` (
  `apply_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pesticide_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `crop_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `apply_num` double NOT NULL,
  `apply_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`apply_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='施药信息（施药信息编号，农药编号，农作物编号，施药量，施药日期，更新日期，状态）';

-- ----------------------------
-- Records of apply_information
-- ----------------------------
BEGIN;
INSERT INTO `apply_information` VALUES ('36332b7a-cd16-11ed-aca1-d69e920459b6', '2', '5da2bf22-c866-11ed-b30d-9930232036af', 50, '2023-03-28 11:11:20', '2023-03-28 11:11:20', 1);
INSERT INTO `apply_information` VALUES ('3a708a20-cd16-11ed-aca1-d69e920459b6', '3', 'ab37ff6e-c856-11ed-b30d-9930232036af', 40, '2023-03-28 11:11:27', '2023-03-28 11:11:27', 1);
INSERT INTO `apply_information` VALUES ('913d291e-cc9c-11ed-9f7a-39591355733f', '1', '5da2bf22-c866-11ed-b30d-9930232036af', 1, '2023-03-27 20:40:34', '2023-03-27 20:40:34', 1);
INSERT INTO `apply_information` VALUES ('e326fe54-cd18-11ed-aca1-d69e920459b6', '1', '5da2bf22-c866-11ed-b30d-9930232036af', 100, '2023-03-28 11:30:29', '2023-03-28 11:30:29', 1);
INSERT INTO `apply_information` VALUES ('e6a1b844-cd18-11ed-aca1-d69e920459b6', '3', '5da2bf22-c866-11ed-b30d-9930232036af', 3, '2023-03-28 11:30:35', '2023-03-28 11:30:35', 1);
COMMIT;

-- ----------------------------
-- Table structure for crop
-- ----------------------------
DROP TABLE IF EXISTS `crop`;
CREATE TABLE `crop` (
  `crop_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '农作物编号',
  `land_id` varchar(86) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地块编号',
  `seed_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '种苗编号',
  `cropName` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`crop_id`) USING BTREE,
  KEY `land_id` (`land_id`),
  KEY `seed_id` (`seed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='农作物（农作物编号，地块编号，种苗编号，更新日期，状态）';

-- ----------------------------
-- Records of crop
-- ----------------------------
BEGIN;
INSERT INTO `crop` VALUES ('5da2bf22-c866-11ed-b30d-9930232036af', 'f57b26a0-c860-11ed-b30d-9930232036af', '1', '蔬菜作物', '2023-03-22 12:02:30', 1);
INSERT INTO `crop` VALUES ('70ebdec8-c858-11ed-b30d-9930232036af', '6a33fcfa-c858-11ed-b30d-9930232036af', '1', '蔬菜作物', '2023-03-22 10:22:50', 1);
INSERT INTO `crop` VALUES ('aa7e90bb4-c856-11ed-b30d-9930232036af', '3f3f67fc-c7ed-11ed-b30d-9930232036af', '1', '蔬菜作物', '2023-03-22 10:10:03', 1);
INSERT INTO `crop` VALUES ('ab37ff6e-c856-11ed-b30d-9930232036af', '96db6d3a-c84c-11ed-b30d-9930232036af', '2', '水果作物', '2023-03-22 10:18:41', 1);
COMMIT;

-- ----------------------------
-- Table structure for fertilization_information
-- ----------------------------
DROP TABLE IF EXISTS `fertilization_information`;
CREATE TABLE `fertilization_information` (
  `apply_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fertilizer_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `crop_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `apply_num` double NOT NULL,
  `apply_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`apply_id`) USING BTREE,
  KEY `crop_id` (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='施肥信息（施肥信息编号，化肥编号，农作物编号，施肥量，施肥日期，更新日期，状态）';

-- ----------------------------
-- Records of fertilization_information
-- ----------------------------
BEGIN;
INSERT INTO `fertilization_information` VALUES ('29adf7be-cbcb-11ed-acc5-efc2fcab61e3', '1', '5da2bf22-c866-11ed-b30d-9930232036af', 1, '2023-03-26 19:41:36', NULL, 1);
INSERT INTO `fertilization_information` VALUES ('572105a0-c988-11ed-8859-ba46332d48e0', '2', '5da2bf22-c866-11ed-b30d-9930232036af', 8, '2023-03-23 22:38:13', NULL, 1);
INSERT INTO `fertilization_information` VALUES ('5a85f06a-cbb9-11ed-acc5-efc2fcab61e3', '3', '5da2bf22-c866-11ed-b30d-9930232036af', 10, '2023-03-26 17:34:07', NULL, 1);
INSERT INTO `fertilization_information` VALUES ('7ef02ee4-c866-11ed-b30d-9930232036af', '1', '5da2bf22-c866-11ed-b30d-9930232036af', 80, '2023-03-22 12:03:26', NULL, 1);
INSERT INTO `fertilization_information` VALUES ('8ba87682-c866-11ed-b30d-9930232036af', '1', '70ebdec8-c858-11ed-b30d-9930232036af', 80, '2023-03-22 12:03:47', NULL, 1);
INSERT INTO `fertilization_information` VALUES ('ec70f840-cbc7-11ed-acc5-efc2fcab61e3', '1', 'ab37ff6e-c856-11ed-b30d-9930232036af', 1, '2023-03-26 19:18:24', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for fertilizer_in_storage
-- ----------------------------
DROP TABLE IF EXISTS `fertilizer_in_storage`;
CREATE TABLE `fertilizer_in_storage` (
  `fertilizer_out_id` varchar(35) NOT NULL,
  `out_num` double DEFAULT NULL,
  `supplier_id` varchar(35) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`fertilizer_out_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fertilizer_information
-- ----------------------------
DROP TABLE IF EXISTS `fertilizer_information`;
CREATE TABLE `fertilizer_information` (
  `fertilizer_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fertilizer_name` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `supplier_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `storage_num` double DEFAULT NULL,
  `in_num` double DEFAULT NULL,
  `out_num` double DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`fertilizer_id`),
  KEY `fertilizer_name` (`fertilizer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fertilizer_information
-- ----------------------------
BEGIN;
INSERT INTO `fertilizer_information` VALUES ('1', '大便', '1', 100, 20, 30, '2023-03-20 00:00:00', 1);
INSERT INTO `fertilizer_information` VALUES ('2', '尿尿', '1', 100, 20, 30, '2023-03-21 12:00:00', 1);
INSERT INTO `fertilizer_information` VALUES ('a7efb876-d8e4-11ed-b49a-1aaf24a5d023', '胡俊杰', '2', NULL, 100, NULL, '2023-04-12 11:55:35', 1);
COMMIT;

-- ----------------------------
-- Table structure for fertilizer_out_storage
-- ----------------------------
DROP TABLE IF EXISTS `fertilizer_out_storage`;
CREATE TABLE `fertilizer_out_storage` (
  `fertilizer_id` varchar(35) NOT NULL,
  `out_num` double NOT NULL,
  `crop_id` varchar(35) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`fertilizer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for irrigation_information
-- ----------------------------
DROP TABLE IF EXISTS `irrigation_information`;
CREATE TABLE `irrigation_information` (
  `irrigation_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `crop_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `irrigation_num` double NOT NULL,
  `irrigation_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`irrigation_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='灌溉信息（灌溉信息编号，农作物编号，灌溉量，灌溉日期，更新日期，状态）';

-- ----------------------------
-- Records of irrigation_information
-- ----------------------------
BEGIN;
INSERT INTO `irrigation_information` VALUES ('797c423c-cd1f-11ed-aca1-d69e920459b6', '5da2bf22-c866-11ed-b30d-9930232036af', 100, '2023-03-28 12:17:38', NULL, 1);
INSERT INTO `irrigation_information` VALUES ('7bbbaf66-cdfa-11ed-aca1-d69e920459b6', '5da2bf22-c866-11ed-b30d-9930232036af', 80, '2023-03-29 14:25:22', NULL, 1);
INSERT INTO `irrigation_information` VALUES ('9eb1def4-cd1f-11ed-aca1-d69e920459b6', '5da2bf22-c866-11ed-b30d-9930232036af', 50, '2023-03-28 12:18:41', NULL, 1);
INSERT INTO `irrigation_information` VALUES ('a6bfa3ec-cd1f-11ed-aca1-d69e920459b6', 'ab37ff6e-c856-11ed-b30d-9930232036af', 1, '2023-03-28 12:18:54', NULL, 1);
INSERT INTO `irrigation_information` VALUES ('bb837f84-cdfa-11ed-aca1-d69e920459b6', '5da2bf22-c866-11ed-b30d-9930232036af', 8, '2023-03-29 00:00:00', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for parcel_information
-- ----------------------------
DROP TABLE IF EXISTS `parcel_information`;
CREATE TABLE `parcel_information` (
  `land_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '地块信息编号',
  `park_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '园区编号',
  `land_num` varchar(10) DEFAULT NULL COMMENT '地块编号',
  `land_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地块名称',
  `lande` varchar(100) DEFAULT NULL COMMENT '地块位置东',
  `landw` varchar(100) DEFAULT NULL COMMENT '地块位置西',
  `lands` varchar(100) DEFAULT NULL COMMENT '地块位置南',
  `landn` varchar(100) DEFAULT NULL COMMENT '地块位置北',
  `land_size` double DEFAULT NULL COMMENT '地块大小',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(11) NOT NULL COMMENT '状态',
  `agr_id` varchar(85) DEFAULT NULL,
  PRIMARY KEY (`land_id`) USING BTREE,
  UNIQUE KEY `land_num` (`land_name`) USING BTREE,
  KEY `park_id` (`park_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地块信息';

-- ----------------------------
-- Records of parcel_information
-- ----------------------------
BEGIN;
INSERT INTO `parcel_information` VALUES ('6a33fcfa-c858-11ed-b30d-9930232036af', '2', NULL, '成华区', '东', '西', '南', '北', 100, NULL, 1, '3');
INSERT INTO `parcel_information` VALUES ('96db6d3a-c84c-11ed-b30d-9930232036af', '1', NULL, '九眼桥', '东', '西', '南', '北', 520, '2023-03-23 13:28:18', 1, '1');
INSERT INTO `parcel_information` VALUES ('f57b26a0-c860-11ed-b30d-9930232036af', '1', NULL, '都江堰', '1', '1', '1', '1', 1, '2023-03-22 12:04:38', 1, '3');
COMMIT;

-- ----------------------------
-- Table structure for park_information
-- ----------------------------
DROP TABLE IF EXISTS `park_information`;
CREATE TABLE `park_information` (
  `park_id` varchar(35) NOT NULL COMMENT '园区编号',
  `park_name` varchar(50) DEFAULT NULL COMMENT '园区名称',
  `park_address` varchar(100) DEFAULT NULL COMMENT '园区地址',
  `concat_person` varchar(15) DEFAULT NULL COMMENT '联系人',
  `concat_method` varchar(12) DEFAULT NULL COMMENT '联系方式',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`park_id`) USING BTREE,
  CONSTRAINT `i_i` FOREIGN KEY (`park_id`) REFERENCES `user_information` (`park_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='园区信息';

-- ----------------------------
-- Records of park_information
-- ----------------------------
BEGIN;
INSERT INTO `park_information` VALUES ('1', '小周园区', '成都', '周渠岸', '19382120092', '2023-03-22 10:20:52', 112);
INSERT INTO `park_information` VALUES ('2', '小马园区', '重庆', '马诗茹', '119', '2023-03-22 10:21:12', 2);
COMMIT;

-- ----------------------------
-- Table structure for pesticide_in_storage
-- ----------------------------
DROP TABLE IF EXISTS `pesticide_in_storage`;
CREATE TABLE `pesticide_in_storage` (
  `pesticide_out_id` varchar(35) NOT NULL,
  `in_num` double NOT NULL,
  `supplier_id` varchar(35) NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`pesticide_out_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pesticide_information
-- ----------------------------
DROP TABLE IF EXISTS `pesticide_information`;
CREATE TABLE `pesticide_information` (
  `pesticide_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pesticide_name` varchar(50) NOT NULL,
  `supplier_id` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `storage_num` double DEFAULT NULL,
  `in_num` double DEFAULT NULL,
  `out_num` double DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`pesticide_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pesticide_information
-- ----------------------------
BEGIN;
INSERT INTO `pesticide_information` VALUES ('1', '药水哥', '1', 100, 52, 20, '2023-04-12 11:01:17', 1);
INSERT INTO `pesticide_information` VALUES ('2', '除草剂', '2', 100, 50, 20, '2023-04-12 11:01:21', 1);
INSERT INTO `pesticide_information` VALUES ('68250bc4-dea7-11ed-bed6-1f0fee7ca1b5', '1', '2', NULL, 100, NULL, '2023-04-19 19:43:39', 1);
COMMIT;

-- ----------------------------
-- Table structure for pesticide_out_storage
-- ----------------------------
DROP TABLE IF EXISTS `pesticide_out_storage`;
CREATE TABLE `pesticide_out_storage` (
  `pesticide_out_id` varchar(35) NOT NULL,
  `out_num` double NOT NULL,
  `crop_id` varchar(35) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`pesticide_out_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for seed_information
-- ----------------------------
DROP TABLE IF EXISTS `seed_information`;
CREATE TABLE `seed_information` (
  `seed_id` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `seed_name` varchar(50) NOT NULL,
  `supplier_id` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `storage_num` double DEFAULT NULL,
  `in_num` double DEFAULT NULL,
  `out_num` double DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`seed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seed_information
-- ----------------------------
BEGIN;
INSERT INTO `seed_information` VALUES ('1', '黄瓜', '2', 100, 58, 30, '2023-04-12 08:49:56', 1);
INSERT INTO `seed_information` VALUES ('2', '香蕉树', '2', 90, 13, 13, '2023-04-12 08:49:51', 1);
COMMIT;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `supplier_name` varchar(50) NOT NULL,
  `supplier_address` varchar(100) DEFAULT NULL,
  `concat_person` varchar(15) DEFAULT NULL,
  `concat_method` varchar(12) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`supplier_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='农资商（农资商编号，农资商名称，农资商地址，联系人，联系方式，更新日期，状态）';

-- ----------------------------
-- Records of supplier
-- ----------------------------
BEGIN;
INSERT INTO `supplier` VALUES ('1', '成都东软学院', '四川省成都市都江堰市', '周渠岸', '19382120092', '2023-04-04 00:00:00', 1);
INSERT INTO `supplier` VALUES ('2', '四川大学', '四川省成都市锦江区', '胡俊杰', '110', '2023-04-10 11:25:17', 1);
COMMIT;

-- ----------------------------
-- Table structure for tools_in_storage
-- ----------------------------
DROP TABLE IF EXISTS `tools_in_storage`;
CREATE TABLE `tools_in_storage` (
  `tool_in_id` varchar(35) NOT NULL,
  `in_num` double NOT NULL,
  `supplier_id` varchar(35) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`tool_in_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tools_information
-- ----------------------------
DROP TABLE IF EXISTS `tools_information`;
CREATE TABLE `tools_information` (
  `tool_id` varchar(85) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tool_name` varchar(50) NOT NULL,
  `supplier_id` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `storage_num` double DEFAULT NULL,
  `in_num` double DEFAULT NULL,
  `out_num` double DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tool_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tools_information
-- ----------------------------
BEGIN;
INSERT INTO `tools_information` VALUES ('1', '斧头1', '2', 1, 1, 1, '2023-04-17 11:38:54', 1);
INSERT INTO `tools_information` VALUES ('7007a64e-dd8a-11ed-bed6-1f0fee7ca1b5', '锤子', '1', NULL, 100, NULL, '2023-04-18 09:47:53', 1);
COMMIT;

-- ----------------------------
-- Table structure for tools_out _storage
-- ----------------------------
DROP TABLE IF EXISTS `tools_out _storage`;
CREATE TABLE `tools_out _storage` (
  `tools_out_id` varchar(35) NOT NULL,
  `out_num` double NOT NULL,
  `crop_id` varchar(35) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`tools_out_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `uid` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `unick_name` varchar(20) NOT NULL COMMENT '用户昵称',
  `uaccount` varchar(20) NOT NULL COMMENT '用户账户',
  `upassword` varchar(30) NOT NULL COMMENT '用户密码',
  `role_flag` int(11) NOT NULL COMMENT '用户角色标志',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(11) NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户账户';

-- ----------------------------
-- Records of user_account
-- ----------------------------
BEGIN;
INSERT INTO `user_account` VALUES ('1', '周渠岸', '11', '111', 1, '2023-03-22 10:20:52', 1);
INSERT INTO `user_account` VALUES ('2', '马诗茹', '22', '222', 2, '2023-03-22 10:21:12', 1);
INSERT INTO `user_account` VALUES ('c0533334-c2fa-11ed-8dfb-d0a4c7f883aa', '周', '周', '周', 1, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for user_copy1
-- ----------------------------
DROP TABLE IF EXISTS `user_copy1`;
CREATE TABLE `user_copy1` (
  `id` int(10) NOT NULL,
  `username` varchar(85) DEFAULT NULL,
  `password` varchar(85) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `uinfo_id` varchar(35) NOT NULL COMMENT '用户信息编号',
  `uid` varchar(35) NOT NULL COMMENT '用户编号',
  `park_id` varchar(35) NOT NULL COMMENT '园区编号',
  PRIMARY KEY (`uinfo_id`) USING BTREE,
  KEY `park_id_park_id` (`park_id`),
  KEY `uid_uid` (`uid`),
  CONSTRAINT `park_id_park_id` FOREIGN KEY (`park_id`) REFERENCES `park_information` (`park_id`),
  CONSTRAINT `uid_uid` FOREIGN KEY (`uid`) REFERENCES `user_account` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息';

-- ----------------------------
-- Records of user_information
-- ----------------------------
BEGIN;
INSERT INTO `user_information` VALUES ('1', '1', '1');
INSERT INTO `user_information` VALUES ('2', '2', '2');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `role_flag` int(11) NOT NULL COMMENT '角色标志',
  `role_name` varchar(20) NOT NULL COMMENT '角色名',
  `status` int(11) NOT NULL COMMENT '状态',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色';

SET FOREIGN_KEY_CHECKS = 1;
