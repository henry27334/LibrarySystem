DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_LAST_LOGIN_TIME`(
	in user_id INT,
    in last_login_time VARCHAR(45)
)
BEGIN
	UPDATE `librarysystem`.`user`
	SET `user`.`last_login_time` = last_login_time
	WHERE `user`.`user_id` = user_id;
END$$
DELIMITER ;
