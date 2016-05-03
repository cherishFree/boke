/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.55-community : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `blog`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `username` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `hasread` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`username`,`date`,`hasread`) values (1,'1234567','<p>&nbsp;123456789</p>','lifengxing','2016-04-14 10:09:51',1),(2,'432432424324','<p>&nbsp;24234432444444444444444444</p>','lifengxing','2016-04-14 10:10:30',0),(3,'42432432424','<p>&nbsp;43242432432324</p>','lifengxing','2016-04-14 10:14:07',1),(4,'4324324','<p>&nbsp;43244443333333333</p>','lifengxing','2016-04-14 10:15:44',0),(5,'大家好','<p>大家好，我是按很</p>','anheng','2016-04-14 10:29:27',5),(6,'这是我的博客啊','<p>&nbsp;这个博客是我的，我叫安恒</p>','anheng','2016-04-23 10:20:30',1),(7,'测试博客内容1','','anheng','2016-04-23 16:19:19',1),(8,'测试博客2','','anheng','2016-04-23 16:19:44',0),(9,'测试博客3','','anheng','2016-04-23 16:19:58',0),(10,'测试博客4','','anheng','2016-04-23 16:20:12',0),(11,'添加一个新的博客','<p>&nbsp;我要测试图片的添加是否可以用<img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/004.gif\" alt=\"\" /><a href=\"/blog/userfiles/anheng/image/d7befe75-2acb-48c0-bf45-eb307b34b6af.jpg\"><img src=\"/blog/userfiles/anheng/image/d7befe75-2acb-48c0-bf45-eb307b34b6af.jpg\" width=\"700\" height=\"700\" alt=\"\" /></a></p>','anheng','2016-04-25 17:32:22',0),(12,'添加新博客','<p>&nbsp;添加图片进行测试<img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/004.gif\" alt=\"\" /></p>','anheng','2016-04-25 17:36:21',1),(13,'添加图片','<p>&nbsp;添加图片<img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/004.gif\" alt=\"\" /></p>','anheng','2016-04-25 17:38:21',3),(14,'测试图片内容','<p>&nbsp;<img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/004.gif\" alt=\"\" /><img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/005.gif\" alt=\"\" /></p>','anheng','2016-04-25 17:51:06',3),(15,'ie下添加新博客','','zhangyu','2016-05-03 06:52:33',1),(16,'火狐下面添加新的博客','<p>测试一下添加新的博客，和上传一张图片试试<img src=\"http://localhost:8080/blog/user/fckeditor/editor/images/smiley/qq/004.gif\" alt=\"\" /><img width=\"700\" height=\"700\" src=\"/blog/userfiles/zhangyu/image/34294fa4-3a92-4e6a-9635-141a4beb67c4.jpeg\" alt=\"\" /></p>','zhangyu','2016-05-03 07:06:58',1);

/*Table structure for table `bloginfo` */

DROP TABLE IF EXISTS `bloginfo`;

CREATE TABLE `bloginfo` (
  `username` varchar(20) CHARACTER SET euckr NOT NULL,
  `blogtitle` varchar(50) CHARACTER SET euckr DEFAULT NULL,
  `idiograph` varchar(50) CHARACTER SET euckr DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `bloginfo` */

insert  into `bloginfo`(`username`,`blogtitle`,`idiograph`) values ('anheng','安恒的博客','安恒的博客了'),('beifengwang','beifengwang','beifengwang'),('lifengxin11g','我的博客','客'),('lifengxin1g','客','客'),('lifengxing','中文中文','中文中文中文中文'),('zhangyu','zhangyudeboke','zhangyudeboke');

/*Table structure for table `critique` */

DROP TABLE IF EXISTS `critique`;

CREATE TABLE `critique` (
  `Id` int(11) NOT NULL,
  `AId` int(11) DEFAULT NULL,
  `content` text,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `critique` */

insert  into `critique`(`Id`,`AId`,`content`,`username`) values (3,16,'<p>测试作者名字</p>','匿名'),(4,6,'<p>这是我的博客</p>','anheng'),(5,6,'<p>&nbsp;这个博客是我的</p>','anheng'),(6,6,'<p>&nbsp;我的博客是这个</p>','anheng'),(7,6,'<p>&nbsp;我有自己的博客</p>','anheng'),(8,6,'<p>&nbsp;你有博客吗？</p>','anheng'),(9,6,'<p>&nbsp;大家互粉</p>','anheng'),(10,6,'<p>&nbsp;在添加一条</p>','anheng'),(11,7,'<p>&nbsp;TIAN</p>','anheng'),(12,2,'<p>&nbsp;提交评论</p>','lifengxing'),(13,2,'<p>&nbsp;再次提交评论</p>','lifengxing'),(14,3,'<p>这个添加评论啊</p>','lifengxing'),(15,5,'<p>&nbsp;添加一个新的评论来测试一下</p>','anheng');

/*Table structure for table `dianjiliang` */

DROP TABLE IF EXISTS `dianjiliang`;

CREATE TABLE `dianjiliang` (
  `id` int(11) NOT NULL,
  `AId` int(11) DEFAULT NULL,
  `IP` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `dianjiliang` */

insert  into `dianjiliang`(`id`,`AId`,`IP`,`time`) values (1,16,'0:0:0:0:0:0:0:1','2016-04-28'),(2,14,'0:0:0:0:0:0:0:1','2016-04-28'),(3,13,'0:0:0:0:0:0:0:1','2016-04-28'),(4,16,'0:0:0:0:0:0:0:1','2016-04-29'),(5,14,'0:0:0:0:0:0:0:1','2016-04-29'),(6,6,'0:0:0:0:0:0:0:1','2016-04-29'),(7,7,'0:0:0:0:0:0:0:1','2016-04-29'),(8,8,'0:0:0:0:0:0:0:1','2016-04-29'),(9,2,'0:0:0:0:0:0:0:1','2016-04-29'),(10,3,'0:0:0:0:0:0:0:1','2016-04-29'),(11,5,'0:0:0:0:0:0:0:1','2016-04-29'),(12,5,'0:0:0:0:0:0:0:1','2016-04-30'),(13,14,'0:0:0:0:0:0:0:1','2016-05-03'),(14,13,'0:0:0:0:0:0:0:1','2016-05-03'),(15,15,'0:0:0:0:0:0:0:1','2016-05-03'),(16,16,'0:0:0:0:0:0:0:1','2016-05-03'),(17,5,'0:0:0:0:0:0:0:1','2016-05-03');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`nickname`,`question`,`answer`) values ('aibeifeng','1234567','爱北风','你的家乡','北京海淀区'),('anheng','1234567','安恒','你的家乡','贵州贵阳市'),('beifengwang','1234567','北风网','你的家乡','北京海淀区'),('jianfeisun','1234567','建飞孙','你的家乡','山东临沂市'),('lifengxing','1234567','李风行','你的家乡','北京海淀区'),('pinyin','1234567','显示中文不','你的家乡','山东枣庄市'),('qikunsun','1234567','启坤孙','你的家乡','山东潍坊市'),('sunjianfei','1234567','孙建飞','你的家乡','山东临沂市'),('sunqikun','1234567','孙启坤','你的家乡','山东潍坊市'),('xinderen','1234567','新的人','你的家乡','山东临沂市'),('yuanweiyu','1234567','袁维宇','你的家乡','山东枣庄市'),('zhangyu','1234567','张宇','你的家乡','山东枣庄市'),('zzxywang','1234567','枣庄学院网','你的家乡','山东枣庄市');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
