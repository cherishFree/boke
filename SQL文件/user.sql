/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.55-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`username` varchar (60),
	`password` varchar (60),
	`nickname` varchar (60),
	`question` varchar (150),
	`answer` varchar (150)
); 
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('aibeifeng','1234567','爱北风','你的家乡','北京海淀区');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('anheng','1234567','安恒','你的家乡','贵州贵阳市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('beifengwang','1234567','北风网','你的家乡','北京海淀区');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('jianfeisun','1234567','建飞孙','你的家乡','山东临沂市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('lifengxing','1234567','李风行','你的家乡','北京海淀区');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('pinyin','1234567','显示中文不','你的家乡','山东枣庄市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('qikunsun','1234567','启坤孙','你的家乡','山东潍坊市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('sunjianfei','1234567','孙建飞','你的家乡','山东临沂市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('sunqikun','1234567','孙启坤','你的家乡','山东潍坊市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('xinderen','1234567','新的人','你的家乡','山东临沂市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('yuanweiyu','1234567','袁维宇','你的家乡','山东枣庄市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('zhangyu','1234567','张宇','你的家乡','山东枣庄市');
insert into `user` (`username`, `password`, `nickname`, `question`, `answer`) values('zzxywang','1234567','枣庄学院网','你的家乡','山东枣庄市');
