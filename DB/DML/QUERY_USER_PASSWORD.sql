DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_USER_PASSWORD`(
	in user_id INT
)
BEGIN
	SELECT * FROM `librarysystem`.`user` WHERE `user`.`user_id` = user_id;
END$$
DELIMITER ;
