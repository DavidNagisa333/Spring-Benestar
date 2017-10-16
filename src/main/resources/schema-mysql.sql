CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adreca` varchar(40) NOT NULL,
  `cognoms` varchar(30) NOT NULL,
  `comarca` varchar(20) NOT NULL,
  `correu` varchar(50) NOT NULL,
  `localitat` varchar(20) NOT NULL,
  `mobil` varchar(20) NOT NULL,
  `naixement` tinyblob,
  `nom` varchar(20) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `edat` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastpasswordresetdate` datetime NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKpqlsjpkybgos9w2svcri7j8xy` (`user_id`),
  CONSTRAINT `FKgvxjs381k6f48d5d2yi11uh89` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
