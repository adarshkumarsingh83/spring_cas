DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `active` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--
INSERT INTO `users` (`username`,`password`,`active`)
VALUES('adarsh','97d9de758e20f8e5a74c21ba389fb562',0x01)
     , ('radha','0280a430e35fee634f01cbc5a8178864',0x01);