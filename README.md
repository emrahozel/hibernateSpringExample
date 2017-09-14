# hibernateSpringExample
Spring ve hibernate kullanilarak gelistirilmis ornek bir projedir. Projede primefaces ve mysql kullanilmistir.

#Gereksinimler

    1. Tomcat 7
    
    2. Mysql Server
    
>Login olabilmek ve Veri kaydedebilmek icin veritabani ve tablolari olusturulmalidir. Create Scriptleri;

```
CREATE DATABASE envanter;

delimiter $$

CREATE TABLE `envanter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kullanici` varchar(45) NOT NULL,
  `birim` varchar(45) NOT NULL,
  `malzemeAdi` varchar(45) NOT NULL,
  `marka` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `seriNo` varchar(45) NOT NULL,
  `adet` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
```

    
