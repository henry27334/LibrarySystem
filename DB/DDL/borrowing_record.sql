CREATE TABLE `borrowing_record` (
  `user_id` int NOT NULL,
  `inventory_id` varchar(45) NOT NULL,
  `borrowing_time` varchar(45) NOT NULL,
  `return_time` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci