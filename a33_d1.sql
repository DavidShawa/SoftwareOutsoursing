CREATE TABLE `store` (
`sid` varchar(255) NOT NULL COMMENT '门店编号，业务预测数据用id关联门店',
`sname` varchar(255) NOT NULL COMMENT '在页面上显示门店名称',
`address` varchar(255) NULL COMMENT '门店地址',
`size` float(11,3) NOT NULL COMMENT '单位：平方米',
PRIMARY KEY (`sid`) 
);
CREATE TABLE `employee` (
`eid` varchar(255) NOT NULL COMMENT '员工id，用于唯一标识员工，使用员工id关联门店',
`ename` varchar(255) NOT NULL,
`email` varchar(255) NOT NULL COMMENT '员工邮件地址，可以作为用户登录名，唯一',
`position` varchar(255) NOT NULL COMMENT '可选值：门店经理，副经理，小组长，店员',
`sname` varchar(255) NOT NULL COMMENT '员工所属门店',
PRIMARY KEY (`eid`) 
);
CREATE TABLE `preferences` (
`pretype` varchar(255) NOT NULL COMMENT '偏好类型：可选值：工作日偏好、工作时间偏好、班次时长偏好。可扩展',
`ename` varchar(255) NOT NULL COMMENT '当员工没有选择对应的偏好类型时，表示员工对该类型无特殊偏好。',
`prevalue` varchar(255) NOT NULL COMMENT '偏好值：\r\n需要开发者自行设计。\r\n示例：\r\n\r\n- 工作日偏好的值：1,3,4     表示偏好周一、周三、周四工作。\r\n\r\n- 工作时间偏好的值：08:00-12:00,18:00:22:00 表示偏好上午8点到12点和晚上6点到10点工作',
PRIMARY KEY (`pretype`) 
);
CREATE TABLE `schedulingrules` (
`stype` varchar(255) NOT NULL COMMENT '可选值：开店规则、关店规则、客流规则。可扩展',
`sname` varchar(255) NULL COMMENT '\r\n为空时，为系统通用规则。\r\n\r\n不为空时，为门店规则。\r\n\r\n当门店有门店规则时，使用门店规则进行排班，没有门店规则时，使用系统通用规则进行排班	',
`svalue` varchar(255) NOT NULL COMMENT '需要开发者自行设计。\r\n\r\n示例：\r\n\r\n- 客流规则：\"3.8\"  表示按照业务预测数据，每3.8个客流必须安排至少一个员工当值\r\n\r\n- 开店规则：\"1.5,23.5\" 表示开店1个半小时前需要有员工当值，当值员工数为门店面积除以23.5\r\n\r\n- 关店规则：\"2.5,3,13\" 表示关店2个半小时内需要有员工当值，当值员工数不小于3并且不小于门店面积除以13\r\n\r\n为了提高规则的灵活性，建议使用json格式保存规则值，如关店规则：{\"after\":\"2.5\",\"count\":\"3\",\"fomula\":\"size/13\"}',
PRIMARY KEY (`stype`) 
);

ALTER TABLE `employee` ADD CONSTRAINT `fk_employee_store_1` FOREIGN KEY (`sname`) REFERENCES `store` (`sname`);
ALTER TABLE `preferences` ADD CONSTRAINT `fk_preferences_employee_1` FOREIGN KEY (`ename`) REFERENCES `employee` (`ename`);
ALTER TABLE `schedulingrules` ADD CONSTRAINT `fk_schedulingrules_store_1` FOREIGN KEY (`sname`) REFERENCES `store` (`sname`);

