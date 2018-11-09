/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.38-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `course` (
	`Cno` varchar (60),
	`Cname` varchar (60),
	`Cpno` varchar (60),
	`Ccredit` int (11)
); 
insert into `course` (`Cno`, `Cname`, `Cpno`, `Ccredit`) values('50502','数学','80','2');
insert into `course` (`Cno`, `Cname`, `Cpno`, `Ccredit`) values('50503','历史','80','1');
insert into `course` (`Cno`, `Cname`, `Cpno`, `Ccredit`) values('50504','物理','80','2');
insert into `course` (`Cno`, `Cname`, `Cpno`, `Ccredit`) values('50505','体育','80','1');
