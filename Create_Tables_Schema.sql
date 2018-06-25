CREATE DATABASE `hw2_ladani_suhani_summer_2018` ;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personId` int(11) NOT NULL,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_has_address_idx` (`personId`),
  CONSTRAINT `address_to_user` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `developer` (
  `developerId` int(11) NOT NULL,
  `developerKey` varchar(100) NOT NULL,
  PRIMARY KEY (`developerId`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`developerId`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `heading` (
  `widgetId` int(11) NOT NULL,
  `size` int(11) DEFAULT '2',
  PRIMARY KEY (`widgetId`),
  CONSTRAINT `heading_to_widget` FOREIGN KEY (`widgetId`) REFERENCES `widget` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `html` (
  `widgetId` int(11) NOT NULL,
  `html` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`widgetId`),
  CONSTRAINT `html_to_widget` FOREIGN KEY (`widgetId`) REFERENCES `widget` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `image` (
  `widgetId` int(11) NOT NULL,
  `src` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`widgetId`),
  CONSTRAINT `image_to_widget` FOREIGN KEY (`widgetId`) REFERENCES `widget` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `views` int(11) NOT NULL,
  `websiteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_to_website_idx` (`websiteId`),
  CONSTRAINT `page_to_website` FOREIGN KEY (`websiteId`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `pagePriviledge` (
  `id` int(11) NOT NULL,
  `priviledgeId` int(11) NOT NULL,
  `pageId` int(11) DEFAULT NULL,
  `developerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `developer_has_pageRole_idx` (`developerId`),
  KEY `page_has_pageRole_idx` (`pageId`),
  KEY `pagePriviledge_to_priviledge_idx` (`priviledgeId`),
  CONSTRAINT `pagePriviledge_to_developer` FOREIGN KEY (`developerId`) REFERENCES `developer` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pagePriviledge_to_page` FOREIGN KEY (`pageId`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pagePriviledge_to_priviledge` FOREIGN KEY (`priviledgeId`) REFERENCES `priviledge` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

CREATE TABLE `pageRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pageId` int(11) NOT NULL,
  `developerId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `page_has_pageRole_idx` (`pageId`),
  KEY `developer_has_pageRole_idx` (`developerId`),
  KEY `pageRole_to_role_idx` (`roleId`),
  CONSTRAINT `pageRole_to_developer` FOREIGN KEY (`developerId`) REFERENCES `developer` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pageRole_to_page` FOREIGN KEY (`pageId`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pageRole_to_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ;


CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personId` int(11) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person_has_phone_idx` (`personId`),
  CONSTRAINT `phone_to_person` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;


CREATE TABLE `priviledge` (
  `value` varchar(45) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ;


CREATE TABLE `role` (
  `value` varchar(45) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `userAgreement` tinyint(4) DEFAULT NULL,
  `userKey` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`userId`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `website` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  `developerId` int(11) DEFAULT NULL,
  `websitecol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_to_developer_idx` (`developerId`),
  CONSTRAINT `website_to_developer` FOREIGN KEY (`developerId`) REFERENCES `developer` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `websitePriviledge` (
  `id` int(11) NOT NULL,
  `websiteId` int(11) NOT NULL,
  `priviledgeId` int(11) NOT NULL,
  `developerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `website_has_websitePriviledge_idx` (`websiteId`),
  KEY `developer_has_websitePriviledge_idx` (`developerId`),
  KEY `websitePriviledge_to_priviledge_idx` (`priviledgeId`),
  CONSTRAINT `websitePriviledge_to_developer` FOREIGN KEY (`developerId`) REFERENCES `developer` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `websitePriviledge_to_priviledge` FOREIGN KEY (`priviledgeId`) REFERENCES `priviledge` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `websitePriviledge_to_website` FOREIGN KEY (`websiteId`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `websiteRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developerId` int(11) NOT NULL,
  `websiteId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `website_has_role_idx` (`websiteId`),
  KEY `developer_has_websiteRole_idx` (`developerId`),
  KEY `websiteRole_to_role_idx` (`roleId`),
  CONSTRAINT `websiteRole_to_developer` FOREIGN KEY (`developerId`) REFERENCES `developer` (`developerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `websiteRole_to_role` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `websiteRole_to_website` FOREIGN KEY (`websiteId`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `widget` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cssClass` varchar(45) DEFAULT NULL,
  `cssStyle` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `pageId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `widget_to_page_idx` (`pageId`),
  CONSTRAINT `widget_to_page` FOREIGN KEY (`pageId`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE `youtube` (
  `widgetId` int(11) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareable` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  KEY `youtube_widget_idx` (`widgetId`),
  CONSTRAINT `youtube_widget` FOREIGN KEY (`widgetId`) REFERENCES `widget` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ;

