/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : fm-shop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 12/01/2022 00:39:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键 分类id主键',
  `category_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称 分类名称',
  `category_level` int(0) NOT NULL COMMENT '分类层级 分类得类型，\n1:一级大分类\n2:二级分类\n3:三级小分类',
  `parent_id` int(0) NOT NULL COMMENT '父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级',
  `category_icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标 logo',
  `category_slogan` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '口号',
  `category_pic` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类图',
  `category_bg_color` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背景颜色',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '点心/蛋糕', 1, 0, 'cake.png', '每一道甜品都有一个故事', 'act1.png', 'black');
INSERT INTO `category` VALUES (2, '饼干/膨化', 1, 0, 'cookies.png', '健康饮食远离我', 'act2.png', 'black');
INSERT INTO `category` VALUES (3, '熟食/肉类', 1, 0, 'meat.png', 'nice！nice！nice！', 'act3.png', 'black');
INSERT INTO `category` VALUES (4, '素食/卤味', 1, 0, 'bamboo.png', '卤味天下！！！', 'act1.png', 'black');
INSERT INTO `category` VALUES (5, '坚果/炒货', 1, 0, 'nut.png', '酥酥脆脆，回味无穷', 'act2.png', 'black');
INSERT INTO `category` VALUES (6, '糖果/蜜饯', 1, 0, 'candy.png', '甜到你心理！！！', 'act3.png', 'black');
INSERT INTO `category` VALUES (7, '巧克力', 1, 0, 'chocolate.png', '黑色美食！！！', 'act1.png', 'black');
INSERT INTO `category` VALUES (8, '海味/河鲜', 1, 0, 'fish.png', '鲜香每一天！！！', 'act2.png', 'black');
INSERT INTO `category` VALUES (9, '花茶/果茶', 1, 0, 'tea.png', '健康快乐每一天', 'act3.png', 'black');
INSERT INTO `category` VALUES (10, '品牌/礼包', 1, 0, 'package.png', '每日一个小惊喜', 'act1.png', 'black');
INSERT INTO `category` VALUES (11, '蛋糕', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (12, '点心', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (13, '饼干', 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (14, '薯片', 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (15, '虾条', 2, 2, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (16, '猪肉脯', 2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (17, '牛肉丝', 2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (18, '小香肠', 2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (19, '豆干', 2, 4, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (20, '干笋', 2, 4, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (21, '鸭脖', 2, 4, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (22, '坚果', 2, 5, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (23, '锅巴', 2, 5, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (24, '糖果', 2, 6, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (25, '蜜饯', 2, 6, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (26, '巧克力', 2, 7, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (27, '果冻', 2, 7, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (28, '海带丝', 2, 8, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (29, '小鱼干', 2, 8, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (30, '鱿鱼丝', 2, 8, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (31, '花茶', 2, 9, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (32, '果茶', 2, 9, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (33, '品牌套餐', 2, 10, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (34, '活动礼包', 2, 10, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (35, '蒸蛋糕', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (36, '脱水蛋糕', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (37, '瑞士卷', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (38, '软面包', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (39, '马卡龙', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (40, '千层饼', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (41, '甜甜圈', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (42, '蒸三明治', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (43, '铜锣烧', 3, 11, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (44, '华夫饼', 3, 12, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (45, '老婆饼', 3, 12, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (46, '奥利奥', 3, 13, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (47, '粤利粤', 3, 13, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (48, '膨化虾条', 3, 15, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (49, '油炸虾条', 3, 15, NULL, NULL, NULL, NULL);
INSERT INTO `category` VALUES (50, '海鲜虾条', 3, 15, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for index_img
-- ----------------------------
DROP TABLE IF EXISTS `index_img`;
CREATE TABLE `index_img`  (
  `img_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `img_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片 图片地址',
  `img_bg_color` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背景色 背景颜色',
  `prod_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id 商品id',
  `category_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类id 商品分类id',
  `index_type` int(0) NOT NULL COMMENT '轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类',
  `seq` int(0) NOT NULL COMMENT '轮播图展示顺序 轮播图展示顺序，从小到大',
  `status` int(0) NOT NULL COMMENT '是否展示:1表示正常显示，0表示下线 是否展示，1：展示    0：不展示',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间 创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间 更新',
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '轮播图 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of index_img
-- ----------------------------
INSERT INTO `index_img` VALUES ('1', 'ad1.jpg', 'green', '101', NULL, 1, 1, 1, '2021-04-14 17:21:13', '2021-04-14 17:21:18');
INSERT INTO `index_img` VALUES ('2', 'ad2.jpg', 'pink', NULL, '1', 2, 2, 1, '2021-04-14 17:21:49', '2021-04-14 17:21:52');
INSERT INTO `index_img` VALUES ('3', 'ad3.jpg', 'black', '103', NULL, 1, 3, 1, '2021-04-14 17:22:23', '2021-04-14 17:22:27');
INSERT INTO `index_img` VALUES ('4', 'ad4.jpg', 'orange', NULL, '2', 2, 4, 1, '2021-04-14 17:23:06', '2021-04-14 17:23:08');
INSERT INTO `index_img` VALUES ('5', 'ad5.jpg', 'yellow', '101', NULL, 1, 2, 0, '2021-04-24 09:34:01', '2021-04-25 09:34:05');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单项ID',
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_img` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `sku_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'skuID',
  `sku_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku名称',
  `product_price` decimal(32, 8) NOT NULL COMMENT '商品价格',
  `buy_counts` int(0) NOT NULL COMMENT '购买数量',
  `total_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '商品总金额',
  `basket_date` datetime(0) NULL DEFAULT NULL COMMENT '加入购物车时间',
  `buy_time` datetime(0) NULL DEFAULT NULL COMMENT '购买时间',
  `is_comment` int(0) NULL DEFAULT NULL COMMENT '评论状态： 0 未评价  1 已评价',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单项/快照 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('164043835461575137', '4d6ef1a3458440c9bab2102383db0113', '1', '奥利奥小饼干', 'ala_1.png', '6', '奥利奥全家桶', 47.00000000, 1, 47.00000000, '2021-12-25 21:19:15', '2021-12-25 21:19:15', 0);
INSERT INTO `order_item` VALUES ('164043835465384423', '4d6ef1a3458440c9bab2102383db0113', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 3, 33.00000000, '2021-12-25 21:19:15', '2021-12-25 21:19:15', 0);
INSERT INTO `order_item` VALUES ('164043860533292561', 'a6752ebdef2c486f9399d206163f5442', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 1, 11.00000000, '2021-12-25 21:23:25', '2021-12-25 21:23:25', 0);
INSERT INTO `order_item` VALUES ('164043860534356504', 'a6752ebdef2c486f9399d206163f5442', '3', '咪咪虾条', 'mmxt_1.png', '2', '咪咪虾条 6连包', 5.00000000, 4, 20.00000000, '2021-12-25 21:23:25', '2021-12-25 21:23:25', 0);
INSERT INTO `order_item` VALUES ('164043937525211328', 'c90d5fa074e64c6aad102baa9e764d85', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 11, 121.00000000, '2021-12-25 21:36:15', '2021-12-25 21:36:15', 0);
INSERT INTO `order_item` VALUES ('164043937525598417', 'c90d5fa074e64c6aad102baa9e764d85', '3', '咪咪虾条', 'mmxt_1.png', '2', '咪咪虾条 6连包', 5.00000000, 3, 15.00000000, '2021-12-25 21:36:15', '2021-12-25 21:36:15', 0);
INSERT INTO `order_item` VALUES ('164043972490193571', 'f710eccdc0bb443e901062c337b9c210', '1', '奥利奥小饼干', 'ala_1.png', '4', '奥利奥分享装', 8.00000000, 1, 8.00000000, '2021-12-25 21:42:05', '2021-12-25 21:42:05', 0);
INSERT INTO `order_item` VALUES ('164043992083220147', '1342ad08a9344470bac3a3689a62b9c2', '1', '奥利奥小饼干', 'ala_1.png', '4', '奥利奥分享装', 8.00000000, 3, 24.00000000, '2021-12-25 21:45:21', '2021-12-25 21:45:21', 0);
INSERT INTO `order_item` VALUES ('164043996770876639', 'b75672e0b44247f7b563fe145b3d46f1', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 6, 66.00000000, '2021-12-25 21:46:08', '2021-12-25 21:46:08', 0);
INSERT INTO `order_item` VALUES ('164060614388291172', 'e14759c2825e48b49236fc18bd70e431', '1', '奥利奥小饼干', 'ala_1.png', '4', '奥利奥分享装', 8.00000000, 1, 8.00000000, '2021-12-27 19:55:44', '2021-12-27 19:55:44', 0);
INSERT INTO `order_item` VALUES ('164060623165689324', 'c772ebcd31874dcc815a19d94ab9fc69', '3', '咪咪虾条', 'mmxt_1.png', '3', '咪咪虾条 整箱50包', 40.00000000, 8, 320.00000000, '2021-12-27 19:57:12', '2021-12-27 19:57:12', 0);
INSERT INTO `order_item` VALUES ('164060775312948705', '704d9249b0d1423bb7c09f60ba5c6b38', '1', '奥利奥小饼干', 'ala_1.png', '6', '奥利奥全家桶', 47.00000000, 12, 564.00000000, '2021-12-27 20:22:33', '2021-12-27 20:22:33', 0);
INSERT INTO `order_item` VALUES ('164060775313775833', '704d9249b0d1423bb7c09f60ba5c6b38', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 4, 44.00000000, '2021-12-27 20:22:33', '2021-12-27 20:22:33', 0);
INSERT INTO `order_item` VALUES ('164060799245880154', 'b97af02f284d41c1a2813351acddde62', '3', '咪咪虾条', 'mmxt_1.png', '2', '咪咪虾条 6连包', 5.00000000, 6, 30.00000000, '2021-12-27 20:26:32', '2021-12-27 20:26:32', 0);
INSERT INTO `order_item` VALUES ('164070942963012119', '5648a7389f4f4fb8a35f44fdb0392614', '29', '旺旺华夫饼', 'wwxb_1.png', '5', '旺旺雪夫达', 11.00000000, 3, 33.00000000, '2021-12-29 00:37:10', '2021-12-29 00:37:10', 0);
INSERT INTO `order_item` VALUES ('164070959816231224', '836890997bbc46859d16753bf2341d49', '3', '咪咪虾条', 'mmxt_1.png', '1', '咪咪虾条 单包 50g', 1.00000000, 1, 1.00000000, '2021-12-29 00:39:58', '2021-12-29 00:39:58', 0);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID 同时也是订单编号',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `untitled` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称（多个产品用,隔开）',
  `receiver_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人快照',
  `receiver_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人手机号快照',
  `receiver_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址快照',
  `total_amount` decimal(32, 8) NULL DEFAULT NULL COMMENT '订单总价格',
  `actual_amount` int(0) NULL DEFAULT NULL COMMENT '实际支付总价格',
  `pay_type` int(0) NULL DEFAULT NULL COMMENT '支付方式 1:微信 2:支付宝',
  `order_remark` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:已完成 6:已关闭',
  `delivery_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配送方式',
  `delivery_flow_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `order_freight` decimal(32, 8) NULL DEFAULT 0.00000000 COMMENT '订单运费 默认可以为零，代表包邮',
  `delete_status` int(0) NULL DEFAULT 0 COMMENT '逻辑删除状态 1: 删除 0:未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间（成交时间）',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `flish_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '取消时间',
  `close_type` int(0) NULL DEFAULT NULL COMMENT '订单关闭类型1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1342ad08a9344470bac3a3689a62b9c2', '11', '奥利奥小饼干,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 24.00000000, 24, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-25 21:45:21', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('48cc30a22e3e4d4782d90914f8125fa2', '11', '', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 0.00000000, 0, 1, '', '3', NULL, NULL, NULL, NULL, '2021-12-25 21:21:20', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('4d6ef1a3458440c9bab2102383db0113', '11', '奥利奥小饼干,旺旺华夫饼,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 80.00000000, 80, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-25 21:19:14', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('55c0b5e30b254dcd846bc02a44dcc8e0', '11', '', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 0.00000000, 0, 1, '', '2', NULL, NULL, NULL, NULL, '2021-12-25 21:24:00', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('5648a7389f4f4fb8a35f44fdb0392614', '11', '旺旺华夫饼,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 33.00000000, 33, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-29 00:37:10', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('704d9249b0d1423bb7c09f60ba5c6b38', '11', '奥利奥小饼干,旺旺华夫饼,', '张三', '13030303300', '湖北 武汉 江夏区 光谷大道77号', 608.00000000, 608, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-27 20:22:33', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('836890997bbc46859d16753bf2341d49', '11', '咪咪虾条,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 1.00000000, 1, 1, '', '2', NULL, NULL, NULL, NULL, '2021-12-29 00:39:58', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('a6752ebdef2c486f9399d206163f5442', '11', '旺旺华夫饼,咪咪虾条,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 31.00000000, 31, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-25 21:23:25', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('b75672e0b44247f7b563fe145b3d46f1', '11', '旺旺华夫饼,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 66.00000000, 66, 1, '', '2', NULL, NULL, NULL, NULL, '2021-12-25 21:46:08', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('b97af02f284d41c1a2813351acddde62', '11', '咪咪虾条,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 30.00000000, 30, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-27 20:26:32', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('c772ebcd31874dcc815a19d94ab9fc69', '11', '咪咪虾条,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 320.00000000, 320, 1, '', '4', NULL, NULL, NULL, NULL, '2021-12-27 19:57:12', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('c90d5fa074e64c6aad102baa9e764d85', '11', '旺旺华夫饼,咪咪虾条,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 136.00000000, 136, 1, '', '2', NULL, NULL, NULL, NULL, '2021-12-25 21:36:15', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('e14759c2825e48b49236fc18bd70e431', '11', '奥利奥小饼干,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 8.00000000, 8, 1, '', '1', NULL, NULL, NULL, NULL, '2021-12-27 19:55:44', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `orders` VALUES ('f710eccdc0bb443e901062c337b9c210', '11', '奥利奥小饼干,', '清风', '13197150384', '四川 眉山 仁寿县 光华大道9号', 8.00000000, 8, 1, '', '2', NULL, NULL, NULL, NULL, '2021-12-25 21:42:05', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品主键id',
  `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称 商品名称',
  `category_id` int(0) NOT NULL COMMENT '分类外键id 分类id',
  `root_category_id` int(0) NOT NULL COMMENT '一级分类外键id 一级分类id，用于优化查询',
  `sold_num` int(0) NOT NULL COMMENT '销量 累计销售',
  `product_status` int(0) NOT NULL COMMENT '默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品内容 商品内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '奥利奥小饼干', 46, 2, 196, 1, '<label style=\"color:red;font-size:18px\">1.全新升级</label><br/><img src=\"static/pimgs/ala_desc1.png\"/><br/><label style=\"color:green;font-size:18px\">2.全新口味</label><br/><img src=\"static/pimgs/ala_desc2.png\"/><br/><label style=\"color:blue;font-size:18px\">3.全新体验</label><br/><img src=\"static/pimgs/ala_desc3.png\"/><br/>', '2021-12-01 15:20:51', '2021-04-23 15:20:58');
INSERT INTO `product` VALUES ('10', '商品10', 10, 1, 127, 1, '商品说明', '2021-04-01 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('100', '加力加虾条11', 49, 2, 169, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('101', '加力加虾条12', 48, 2, 149, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('102', '加力加虾条13', 48, 2, 129, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('103', '加力加虾条14', 48, 2, 139, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('104', '加力加虾条15', 48, 2, 159, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('105', '加力加虾条16', 48, 2, 179, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('106', '加力加虾条17', 48, 2, 169, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('107', '加力加虾条18', 50, 2, 149, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('108', '加力加虾条19', 50, 2, 129, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('109', '加力加虾条20', 50, 2, 139, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('11', '商品11', 10, 1, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('110', '加力加虾条21', 50, 2, 159, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('111', '加力加虾条22', 50, 2, 179, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('112', '加力加虾条23', 50, 2, 169, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('113', '加力加虾条24', 49, 2, 149, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('114', '加力加虾条25', 49, 2, 129, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('115', '加力加虾条26', 49, 2, 139, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('116', '加力加虾条27', 49, 2, 159, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('117', '加力加虾条28', 49, 2, 179, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('118', '加力加虾条29', 49, 2, 169, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('12', '商品12', 46, 2, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('13', '商品13', 46, 2, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('14', '商品14', 46, 2, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('15', '商品15', 46, 2, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('16', '商品16', 46, 2, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('17', '商品17', 46, 2, 127, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('18', '商品18', 46, 2, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('19', '加力加虾条', 49, 2, 1562, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('2', '旺旺华夫饼', 22, 1, 202, 1, '旺旺华夫饼商品内容', '2021-05-01 15:27:22', '2021-04-25 15:27:25');
INSERT INTO `product` VALUES ('20', '商品10', 10, 3, 127, 1, '商品说明', '2021-06-01 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('21', '商品11', 10, 3, 128, 1, '商品说明', '2021-05-28 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('22', '商品12', 46, 3, 122, 1, '商品说明', '2021-05-23 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('23', '商品13', 46, 3, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('24', '商品14', 46, 4, 124, 1, '商品说明', '2021-05-25 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('25', '商品15', 46, 4, 125, 1, '商品说明', '2021-05-30 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('26', '商品16', 46, 4, 126, 1, '商品说明', '2021-04-28 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('27', '商品17', 46, 4, 127, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('28', '商品18', 46, 4, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('29', '旺旺华夫饼', 22, 4, 202, 1, '旺旺华夫饼商品内容', '2021-12-01 15:27:22', '2021-04-25 15:27:25');
INSERT INTO `product` VALUES ('3', '咪咪虾条', 50, 2, 199, 1, '<img src=\"static/pimgs/mmxt_desc.jpg\"/>', '2021-12-01 15:58:09', '2021-04-25 15:58:11');
INSERT INTO `product` VALUES ('30', '咪咪虾条', 15, 4, 199, 1, '美味小吃哦', '2021-04-26 15:58:09', '2021-04-25 15:58:11');
INSERT INTO `product` VALUES ('31', '旺旺雪饼', 46, 4, 201, 1, '旺旺雪饼商品内容', '2021-10-01 15:58:59', '2021-04-25 15:59:03');
INSERT INTO `product` VALUES ('32', '商品5', 10, 3, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('33', '商品6', 10, 3, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('34', '商品7', 10, 3, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('35', '商品8', 10, 3, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('36', '商品9', 10, 3, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('37', '奥利奥小饼干', 46, 5, 196, 1, '奥利奥诶', '2021-05-19 15:20:51', '2021-04-23 15:20:58');
INSERT INTO `product` VALUES ('38', '商品10', 10, 5, 127, 1, '商品说明', '2021-04-28 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('39', '商品11', 10, 5, 128, 1, '商品说明', '2021-05-18 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('4', '旺旺雪饼', 46, 5, 201, 1, '旺旺雪饼商品内容', '2021-10-01 15:58:59', '2021-04-25 15:59:03');
INSERT INTO `product` VALUES ('40', '商品12', 46, 5, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('41', '商品13', 46, 5, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('42', '商品14', 46, 6, 124, 1, '商品说明', '2021-05-24 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('43', '商品15', 46, 6, 125, 1, '商品说明', '2021-05-29 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('44', '商品16', 46, 6, 126, 1, '商品说明', '2021-05-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('45', '商品17', 46, 6, 127, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('46', '商品18', 46, 6, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('47', '旺旺华夫饼', 22, 6, 202, 1, '旺旺华夫饼商品内容', '2021-05-01 15:27:22', '2021-04-25 15:27:25');
INSERT INTO `product` VALUES ('48', '咪咪虾条', 15, 6, 199, 1, '美味小吃哦', '2021-04-26 15:58:09', '2021-04-25 15:58:11');
INSERT INTO `product` VALUES ('49', '旺旺雪饼', 46, 6, 201, 1, '旺旺雪饼商品内容', '2021-10-01 15:58:59', '2021-04-25 15:59:03');
INSERT INTO `product` VALUES ('5', '商品5', 10, 6, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('50', '商品5', 10, 5, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('51', '商品6', 10, 5, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('52', '商品7', 10, 5, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('53', '商品8', 10, 5, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('54', '商品9', 10, 5, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('55', '奥利奥小饼干', 46, 7, 196, 5, '奥利奥诶', '2021-04-01 15:20:51', '2021-04-23 15:20:58');
INSERT INTO `product` VALUES ('56', '商品10', 10, 7, 127, 1, '商品说明', '2021-05-19 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('57', '商品11', 10, 7, 128, 1, '商品说明', '2021-06-02 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('58', '商品12', 46, 7, 122, 1, '商品说明', '2021-05-24 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('59', '商品13', 46, 7, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('6', '商品6', 10, 7, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('60', '商品14', 46, 8, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('61', '商品15', 46, 8, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('62', '商品16', 46, 8, 126, 1, '商品说明', '2021-05-23 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('63', '商品17', 46, 8, 127, 1, '商品说明', '2021-04-28 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('64', '商品18', 46, 8, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('65', '旺旺华夫饼', 22, 8, 202, 1, '旺旺华夫饼商品内容', '2021-05-01 15:27:22', '2021-04-25 15:27:25');
INSERT INTO `product` VALUES ('66', '咪咪虾条', 15, 8, 199, 1, '美味小吃哦', '2021-05-19 15:58:09', '2021-04-25 15:58:11');
INSERT INTO `product` VALUES ('67', '旺旺雪饼', 46, 8, 201, 1, '旺旺雪饼商品内容', '2021-10-01 15:58:59', '2021-04-25 15:59:03');
INSERT INTO `product` VALUES ('68', '商品5', 10, 7, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('69', '商品6', 10, 7, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('7', '商品7', 10, 1, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('70', '商品7', 10, 7, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('71', '商品8', 10, 7, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('72', '商品9', 10, 7, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('73', '奥利奥小饼干', 46, 9, 196, 5, '奥利奥诶', '2021-04-01 15:20:51', '2021-04-23 15:20:58');
INSERT INTO `product` VALUES ('74', '商品10', 10, 9, 127, 1, '商品说明', '2021-04-01 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('75', '商品11', 10, 9, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('76', '商品12', 46, 9, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('77', '商品13', 46, 9, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('78', '商品14', 46, 10, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('79', '商品15', 46, 10, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('8', '商品8', 10, 1, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('80', '商品16', 46, 10, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('81', '商品17', 46, 10, 127, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('82', '商品18', 46, 10, 128, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('83', '旺旺华夫饼', 22, 10, 202, 1, '旺旺华夫饼商品内容', '2021-05-01 15:27:22', '2021-04-25 15:27:25');
INSERT INTO `product` VALUES ('84', '咪咪虾条', 15, 10, 199, 1, '美味小吃哦', '2021-04-26 15:58:09', '2021-04-25 15:58:11');
INSERT INTO `product` VALUES ('85', '旺旺雪饼', 46, 10, 201, 1, '旺旺雪饼商品内容', '2021-10-01 15:58:59', '2021-04-25 15:59:03');
INSERT INTO `product` VALUES ('86', '商品5', 10, 9, 122, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('87', '商品6', 10, 9, 123, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('88', '商品7', 10, 9, 124, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('89', '商品8', 10, 9, 125, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('9', '商品9', 10, 1, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('90', '商品9', 10, 9, 126, 1, '商品说明', '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product` VALUES ('91', '加力加虾条2', 49, 2, 199, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('92', '加力加虾条3', 48, 2, 1199, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('93', '加力加虾条4', 49, 2, 179, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('94', '加力加虾条5', 48, 2, 119, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('95', '加力加虾条6', 49, 2, 149, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('96', '加力加虾条7', 49, 2, 129, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('97', '加力加虾条8', 48, 2, 139, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('98', '加力加虾条9', 49, 2, 159, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');
INSERT INTO `product` VALUES ('99', '加力加虾条10', 50, 2, 179, 1, '加力加虾条说明', '2021-11-30 15:20:51', '2021-12-01 15:20:58');

-- ----------------------------
-- Table structure for product_comments
-- ----------------------------
DROP TABLE IF EXISTS `product_comments`;
CREATE TABLE `product_comments`  (
  `comm_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `order_item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单项(商品快照)ID 可为空',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户id 用户名须脱敏',
  `is_anonymous` int(0) NULL DEFAULT NULL COMMENT '是否匿名（1:是，0:否）',
  `comm_type` int(0) NULL DEFAULT NULL COMMENT '评价类型（1好评，0中评，-1差评）',
  `comm_level` int(0) NOT NULL COMMENT '评价等级 1：好评 2：中评 3：差评',
  `comm_content` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价内容',
  `comm_imgs` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价晒图(JSON {img1:url1,img2:url2}  )',
  `sepc_name` datetime(0) NULL DEFAULT NULL COMMENT '评价时间 可为空',
  `reply_status` int(0) NULL DEFAULT NULL COMMENT '是否回复（0:未回复，1:已回复）',
  `reply_content` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `is_show` int(0) NULL DEFAULT NULL COMMENT '是否显示（1:是，0:否）',
  PRIMARY KEY (`comm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品评价 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product_comments
-- ----------------------------
INSERT INTO `product_comments` VALUES ('1', '3', '咪咪虾条', '10000001', '4', 1, 1, 1, '我买这不是来吃的，就是玩儿', '{}', '2021-04-27 14:51:10', 0, NULL, '2021-04-27 14:51:32', 1);
INSERT INTO `product_comments` VALUES ('2', '3', '咪咪虾条', '10000002', '5', 0, 1, 1, 'nice', '{img1:“mmxt2.png”}', '2021-04-27 14:53:20', 1, '你好我也好', '2021-04-27 14:53:37', 1);
INSERT INTO `product_comments` VALUES ('3', '3', '咪咪虾条', '10000003', '1', 1, 1, 1, '评价内容3', '{}', '2021-04-27 09:36:36', 0, NULL, NULL, 1);
INSERT INTO `product_comments` VALUES ('4', '3', '咪咪虾条', '10000004', '3', 1, 1, 1, '评价内容4', '{}', '2021-04-28 09:37:28', 0, NULL, NULL, 1);
INSERT INTO `product_comments` VALUES ('5', '3', '咪咪虾条', '10000005', '3', 1, 0, 1, '评价内容5', '{}', '2021-04-28 09:38:13', 0, NULL, NULL, 1);
INSERT INTO `product_comments` VALUES ('6', '3', '咪咪虾条', '10000006', '3', 1, 0, 1, '评价内容6', '{}', '2021-04-21 09:39:16', 0, NULL, NULL, 1);
INSERT INTO `product_comments` VALUES ('7', '3', '咪咪虾条', '10000007', '4', 0, -1, 1, '评价内容7', '{}', '2021-04-06 09:40:01', 0, NULL, NULL, 1);

-- ----------------------------
-- Table structure for product_img
-- ----------------------------
DROP TABLE IF EXISTS `product_img`;
CREATE TABLE `product_img`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片主键',
  `item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品外键id 商品外键id',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址 图片地址',
  `sort` int(0) NOT NULL COMMENT '顺序 图片顺序，从小到大',
  `is_main` int(0) NOT NULL COMMENT '是否主图 是否主图，1：是，0：否',
  `created_time` datetime(0) NOT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品图片 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product_img
-- ----------------------------
INSERT INTO `product_img` VALUES ('1', '1', 'ala_1.png', 1, 1, '2021-04-22 15:25:08', '2021-04-22 15:25:15');
INSERT INTO `product_img` VALUES ('10', '6', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('100', '95', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('101', '96', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('102', '97', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('103', '98', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('104', '99', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('105', '100', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('106', '101', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('107', '102', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('108', '103', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('109', '104', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('11', '7', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('110', '105', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('111', '106', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('112', '107', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('113', '108', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('114', '109', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('115', '110', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('116', '111', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('117', '112', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('118', '113', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('119', '114', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('12', '8', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('120', '115', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('121', '116', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('122', '117', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('123', '118', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('13', '9', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('14', '10', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('15', '11', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('16', '12', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('17', '13', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('18', '14', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('19', '15', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('2', '1', 'ala_2.png', 2, 0, '2021-04-22 15:25:39', '2021-04-22 15:25:44');
INSERT INTO `product_img` VALUES ('20', '16', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('21', '17', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('22', '18', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('23', '19', 'jij_1.png', 1, 1, '2021-04-22 15:25:08', '2021-04-22 15:25:15');
INSERT INTO `product_img` VALUES ('24', '20', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('25', '21', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('26', '22', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('27', '23', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('28', '24', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('29', '25', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('3', '2', 'hfb_1.png', 1, 1, '2021-04-24 15:30:09', '2021-04-25 15:30:19');
INSERT INTO `product_img` VALUES ('30', '26', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('31', '27', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('32', '28', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('33', '29', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('34', '30', 'ala_2.png', 2, 0, '2021-04-22 15:25:39', '2021-04-22 15:25:44');
INSERT INTO `product_img` VALUES ('35', '31', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('36', '32', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('37', '33', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('38', '34', 'hfb_1.png', 1, 1, '2021-04-24 15:30:09', '2021-04-25 15:30:19');
INSERT INTO `product_img` VALUES ('39', '35', 'hfb_2.png', 2, 0, '2021-04-25 15:30:45', '2021-04-25 15:30:48');
INSERT INTO `product_img` VALUES ('4', '2', 'hfb_2.png', 2, 0, '2021-04-25 15:30:45', '2021-04-25 15:30:48');
INSERT INTO `product_img` VALUES ('40', '36', 'mmxt_1.png', 1, 1, '2021-04-25 15:59:28', '2021-04-25 15:59:31');
INSERT INTO `product_img` VALUES ('41', '54', 'ala_1.png', 1, 1, '2021-04-22 15:25:08', '2021-04-22 15:25:15');
INSERT INTO `product_img` VALUES ('42', '53', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('43', '52', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('44', '51', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('45', '50', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('46', '49', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('47', '48', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('48', '47', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('49', '46', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('5', '3', 'mmxt_1.png', 1, 1, '2021-04-25 15:59:28', '2021-04-25 15:59:31');
INSERT INTO `product_img` VALUES ('50', '45', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('51', '44', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('52', '43', 'ala_2.png', 2, 0, '2021-04-22 15:25:39', '2021-04-22 15:25:44');
INSERT INTO `product_img` VALUES ('53', '42', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('54', '41', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('55', '40', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('56', '39', 'hfb_1.png', 1, 1, '2021-04-24 15:30:09', '2021-04-25 15:30:19');
INSERT INTO `product_img` VALUES ('57', '38', 'hfb_2.png', 2, 0, '2021-04-25 15:30:45', '2021-04-25 15:30:48');
INSERT INTO `product_img` VALUES ('58', '37', 'mmxt_1.png', 1, 1, '2021-04-25 15:59:28', '2021-04-25 15:59:31');
INSERT INTO `product_img` VALUES ('59', '72', 'mmxt_1.png', 1, 1, '2021-04-25 15:59:28', '2021-04-25 15:59:31');
INSERT INTO `product_img` VALUES ('6', '3', 'mmxt_2.png', 2, 0, '2021-04-25 15:59:51', '2021-04-25 15:59:54');
INSERT INTO `product_img` VALUES ('60', '71', 'hfb_2.png', 2, 0, '2021-04-25 15:30:45', '2021-04-25 15:30:48');
INSERT INTO `product_img` VALUES ('61', '70', 'hfb_1.png', 1, 1, '2021-04-24 15:30:09', '2021-04-25 15:30:19');
INSERT INTO `product_img` VALUES ('62', '69', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('63', '68', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('64', '67', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('65', '66', 'ala_2.png', 2, 0, '2021-04-22 15:25:39', '2021-04-22 15:25:44');
INSERT INTO `product_img` VALUES ('66', '65', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('67', '64', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('68', '63', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('69', '62', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('7', '4', 'wwxb_1.png', 1, 1, '2021-04-25 16:00:12', '2021-04-25 16:00:17');
INSERT INTO `product_img` VALUES ('70', '61', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('71', '60', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('72', '59', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('73', '58', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('74', '57', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('75', '56', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('76', '55', 'ala_1.png', 1, 1, '2021-04-22 15:25:08', '2021-04-22 15:25:15');
INSERT INTO `product_img` VALUES ('77', '90', 'ala_1.png', 1, 1, '2021-04-22 15:25:08', '2021-04-22 15:25:15');
INSERT INTO `product_img` VALUES ('78', '89', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('79', '88', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('8', '4', 'wwxb_2.png', 2, 0, '2021-04-25 16:00:36', '2021-04-25 16:00:39');
INSERT INTO `product_img` VALUES ('80', '87', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('81', '86', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('82', '85', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('83', '84', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('84', '83', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('85', '82', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('86', '81', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('87', '80', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('88', '79', 'ala_2.png', 2, 0, '2021-04-22 15:25:39', '2021-04-22 15:25:44');
INSERT INTO `product_img` VALUES ('89', '78', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('9', '5', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('90', '77', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('91', '76', 'wwxb_1.png', 1, 1, '2021-04-26 11:11:11', '2021-04-26 11:11:11');
INSERT INTO `product_img` VALUES ('92', '75', 'hfb_1.png', 1, 1, '2021-04-24 15:30:09', '2021-04-25 15:30:19');
INSERT INTO `product_img` VALUES ('93', '74', 'hfb_2.png', 2, 0, '2021-04-25 15:30:45', '2021-04-25 15:30:48');
INSERT INTO `product_img` VALUES ('94', '73', 'mmxt_1.png', 1, 1, '2021-04-25 15:59:28', '2021-04-25 15:59:31');
INSERT INTO `product_img` VALUES ('95', '19', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('96', '91', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('97', '92', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('98', '93', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');
INSERT INTO `product_img` VALUES ('99', '94', 'jij_1.png', 1, 1, '2022-01-01 17:59:05', '2022-01-01 17:59:07');

-- ----------------------------
-- Table structure for product_params
-- ----------------------------
DROP TABLE IF EXISTS `product_params`;
CREATE TABLE `product_params`  (
  `param_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品参数id',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `product_place` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产地 产地，例：中国江苏',
  `foot_period` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保质期 保质期，例：180天',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌名 品牌名，例：三只大灰狼',
  `factory_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产厂名 生产厂名，例：大灰狼工厂',
  `factory_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产厂址 生产厂址，例：大灰狼生产基地',
  `packaging_method` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '包装方式 包装方式，例：袋装',
  `weight` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格重量 规格重量，例：35g',
  `storage_method` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储方法 存储方法，例：常温5~25°',
  `eat_method` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '食用方式 食用方式，例：开袋即食',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`param_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品参数 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product_params
-- ----------------------------
INSERT INTO `product_params` VALUES ('1', '3', '中国湖北武汉', '12个月', '咪咪', '贤磊咪咪虾条有限责任公司', '湖北武汉江夏区光谷大道77号', '袋装', '50g', '常温保存', '开袋即食', '2021-04-27 11:53:20', '2021-04-27 11:53:35');
INSERT INTO `product_params` VALUES ('10', '94', '四川成都', '8个月', '康师傅', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('11', '95', '上海', '8个月', '大长今', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('12', '96', '上海', '8个月', '大长今', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('13', '97', '上海', '8个月', '仁和', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('14', '98', '上海', '8个月', '优优', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('15', '99', '上海', '8个月', '食油', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('16', '100', '上海', '8个月', '大圣牌', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('17', '1', '中国浙江', '8个月', '良品铺子', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('2', '29', '四川成都', '24个月', '雪饼', '成都旺旺雪饼有限公司', '成都旺旺雪饼制造厂', '袋装', '500g', '常温保存', '开袋即食', '2021-12-25 20:49:09', '2021-12-26 20:49:11');
INSERT INTO `product_params` VALUES ('3', '1', '中国浙江', '8个月', '奥利奥', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('4', '19', '四川成都', '8个月', '卫龙', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('5', '91', '北京', '8个月', '威龙', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('6', '22', '四川成都', '8个月', '卫龙', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('7', '21', '四川成都', '8个月', '威龙', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('8', '92', '四川成都', '8个月', '卫龙', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');
INSERT INTO `product_params` VALUES ('9', '93', '四川成都', '8个月', '好人家', '浙江奥利奥小饼干', '浙江奥利奥饼干制造厂', '袋装、盒装', '200g', '常温保存', '开袋即食', '2021-12-25 20:51:29', '2021-12-26 20:51:32');

-- ----------------------------
-- Table structure for product_sku
-- ----------------------------
DROP TABLE IF EXISTS `product_sku`;
CREATE TABLE `product_sku`  (
  `sku_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku编号',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `sku_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku名称',
  `sku_img` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku图片',
  `untitled` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性组合（格式是p1:v1;p2:v2）',
  `original_price` int(0) NOT NULL COMMENT '原价',
  `sell_price` int(0) NOT NULL COMMENT '销售价格',
  `discounts` decimal(4, 2) NOT NULL COMMENT '折扣力度',
  `stock` int(0) NOT NULL COMMENT '库存',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `status` int(0) NULL DEFAULT NULL COMMENT 'sku状态(1启用，0禁用，-1删除)',
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product_sku
-- ----------------------------
INSERT INTO `product_sku` VALUES ('1', '3', '咪咪虾条 单包 50g', 'mmxt_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 2, 1, 0.70, 332, '2021-04-26 15:58:00', '2021-04-25 15:58:00', 1);
INSERT INTO `product_sku` VALUES ('10', '93', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('100', '67', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('101', '68', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('102', '69', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('103', '70', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('104', '71', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('105', '72', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('106', '73', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('107', '74', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('108', '75', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('109', '76', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('11', '94', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('110', '77', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('111', '78', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('112', '79', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('113', '80', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('114', '81', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('115', '82', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('116', '83', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('117', '84', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('118', '85', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('119', '86', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('12', '95', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('120', '87', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('121', '88', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('122', '89', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('123', '90', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('124', '91', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('125', '92', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('126', '93', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('127', '94', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('128', '95', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('129', '96', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('13', '96', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('130', '97', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('131', '98', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('132', '99', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('133', '100', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('14', '97', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('15', '98', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('16', '99', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('17', '100', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('18', '101', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('19', '102', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('2', '3', '咪咪虾条 6连包', 'mmxt_1.png', '{口味:[\"原味\",\"烧烤\"],包装:[\"新包装\",\"老包装\"]}', 6, 5, 0.60, 186, '2021-04-26 14:48:21', '2021-04-26 14:48:25', 1);
INSERT INTO `product_sku` VALUES ('20', '107', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('21', '108', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('22', '109', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('23', '110', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('24', '111', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('25', '112', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('26', '113', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('27', '114', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('28', '115', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('29', '116', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('3', '3', '咪咪虾条 整箱50包', 'mmxt_1.png', '{口味:[\"原味\",\"烧烤\",\"孜然\"]}', 50, 40, 0.50, 40, '2021-04-26 14:49:20', '2021-04-26 14:49:23', 1);
INSERT INTO `product_sku` VALUES ('30', '117', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('31', '118', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('32', '103', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('33', '104', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('34', '105', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('35', '106', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('36', '2', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('37', '4', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('38', '5', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('39', '6', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('4', '1', '奥利奥分享装', 'ala_1.png', '{口味:[\"草莓\",\"巧克力\",\"牛奶\",\"原味\"]}', 10, 8, 0.80, 158, '2021-04-27 11:38:55', '2021-04-27 11:39:00', 1);
INSERT INTO `product_sku` VALUES ('40', '7', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('41', '8', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('42', '9', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('43', '10', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('44', '11', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('45', '12', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('46', '13', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('47', '14', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('48', '15', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('49', '16', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('5', '29', '旺旺雪夫达', 'wwxb_1.png', '{口味:[\"原味\",\"烧烤\"],包装:[\"新包装\",\"老包装\"]}', 12, 11, 0.90, 345, '2021-12-14 15:12:23', '2021-12-14 15:12:27', 1);
INSERT INTO `product_sku` VALUES ('50', '17', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('51', '18', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('52', '19', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('53', '20', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('54', '21', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('55', '22', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('56', '23', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('57', '24', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('58', '25', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('59', '26', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('6', '1', '奥利奥全家桶', 'ala_1.png', '{口味:[\"草莓\",\"巧克力\",\"牛奶\",\"原味\"]}', 50, 47, 0.70, 320, '2021-04-26 15:58:00', '2021-04-25 15:58:00', 1);
INSERT INTO `product_sku` VALUES ('60', '27', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('61', '28', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('62', '29', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('63', '30', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('64', '31', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('65', '32', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('66', '33', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('67', '34', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('68', '35', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('69', '36', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('7', '19', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('70', '37', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('71', '38', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('72', '39', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('73', '40', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('74', '41', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('75', '42', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('76', '43', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('77', '44', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('78', '45', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('79', '46', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('8', '91', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"烧烤\",\"芥末\"],包装:[\"盒装\",\"袋装\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('80', '47', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('81', '48', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('82', '49', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('83', '50', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('84', '51', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('85', '52', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('86', '53', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('87', '54', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('88', '55', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('89', '56', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('9', '92', '加力加100g', 'jij_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('90', '57', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('91', '58', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('92', '59', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('93', '60', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('94', '61', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('95', '62', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('96', '63', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('97', '64', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('98', '65', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);
INSERT INTO `product_sku` VALUES ('99', '66', '咪咪虾条大礼盒', 'mmxt_1.png', '{口味:[\"原味\",\"微辣\",\"爆辣\"]}', 24, 20, 0.90, 999, '2022-01-01 18:02:12', '2022-01-01 18:02:15', 1);

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `cart_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `sku_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'skuID',
  `sku_props` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选择的套餐的属性',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `cart_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物车商品数量',
  `cart_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '添加购物车时间',
  `product_price` decimal(32, 8) NULL DEFAULT NULL COMMENT '添加购物车时商品价格',
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES (48, '1', '6', '口味:牛奶;', '11', '1', '2021-12-25 21:36:01', 47.00000000);
INSERT INTO `shopping_cart` VALUES (53, '3', '1', '口味:芥末;包装:盒装;', '11', '3', '2021-12-29 00:34:42', 1.00000000);
INSERT INTO `shopping_cart` VALUES (55, '1', '4', '口味:牛奶;', '11', '3', '2021-12-29 00:35:02', 8.00000000);
INSERT INTO `shopping_cart` VALUES (56, '3', '1', '口味:原味;包装:袋装;', '11', '1', '2021-12-29 00:39:49', 1.00000000);

-- ----------------------------
-- Table structure for user_addr
-- ----------------------------
DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr`  (
  `addr_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址主键id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `receiver_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人姓名',
  `receiver_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收件人手机号',
  `province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份',
  `city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  `area` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区县',
  `addr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  `post_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态,1正常，0无效',
  `common_addr` int(0) NULL DEFAULT NULL COMMENT '是否默认地址 1是 1:是  0:否',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`addr_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户地址 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_addr
-- ----------------------------
INSERT INTO `user_addr` VALUES ('1', '11', '张三', '13030303300', '湖北', '武汉', '江夏区', '光谷大道77号', '421000', 1, 0, '2021-04-30 09:33:30', '2021-04-28 09:33:37');
INSERT INTO `user_addr` VALUES ('2', '1', '小丽', '13131313311', '湖北', '宜昌', '夷陵区', '巴拉巴拉', '410000', 1, 0, '2021-04-30 09:34:41', '2021-04-30 09:34:44');
INSERT INTO `user_addr` VALUES ('3', '6', '韩梅梅', '13232323322', '湖南', '长沙', '岳麓区', '淅沥淅沥', '430000', 1, 1, '2021-04-30 09:35:49', '2021-04-30 09:35:53');
INSERT INTO `user_addr` VALUES ('4', '11', '清风', '13197150384', '四川', '眉山', '仁寿县', '光华大道9号', '615055', 1, 1, '2021-12-21 18:20:23', '2021-12-22 18:20:27');

-- ----------------------------
-- Table structure for user_login_history
-- ----------------------------
DROP TABLE IF EXISTS `user_login_history`;
CREATE TABLE `user_login_history`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `AREA` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `COUNTRY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家',
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `IP` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IP',
  `LOGIN_TIME` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录历史表 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id 用户id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名 用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码 密码',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称 昵称',
  `realname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名 真实姓名',
  `user_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像 头像',
  `user_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号 手机号',
  `user_email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址 邮箱地址',
  `user_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 M(男) or F(女)',
  `user_birth` date NULL DEFAULT NULL COMMENT '生日 生日',
  `user_regtime` datetime(0) NOT NULL COMMENT '注册时间 创建时间',
  `user_modtime` datetime(0) NOT NULL COMMENT '更新时间 更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户 ' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'zhangsan', 'f379eaf3c831b04de153469d1bec345e', NULL, NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-15 16:10:53', '2021-04-15 16:10:53');
INSERT INTO `users` VALUES (3, 'wahaha', '4297f44b13955235245b2497399d7a93', NULL, NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-16 15:36:52', '2021-04-16 15:36:52');
INSERT INTO `users` VALUES (4, 'heihei', '4297f44b13955235245b2497399d7a93', '二狗', NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-16 15:38:49', '2021-04-16 15:38:49');
INSERT INTO `users` VALUES (5, 'Tony', '4297f44b13955235245b2497399d7a93', '托尼', NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-23 10:25:04', '2021-04-23 10:25:04');
INSERT INTO `users` VALUES (6, 'hanmeimei', 'f379eaf3c831b04de153469d1bec345e', NULL, NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-23 10:30:52', '2021-04-23 10:30:52');
INSERT INTO `users` VALUES (7, 'lilei123', '4297f44b13955235245b2497399d7a93', NULL, NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-23 10:33:03', '2021-04-23 10:33:03');
INSERT INTO `users` VALUES (8, 'tom123123', '4297f44b13955235245b2497399d7a93', NULL, NULL, 'img/default.png', NULL, NULL, NULL, NULL, '2021-04-23 10:34:49', '2021-04-23 10:34:49');
INSERT INTO `users` VALUES (11, 'qingfeng', 'e10adc3949ba59abbe56e057f20f883e', '清风', '清风学Java', 'img/default.png', NULL, NULL, NULL, NULL, '2021-11-20 21:15:02', '2021-11-20 21:15:02');

SET FOREIGN_KEY_CHECKS = 1;
