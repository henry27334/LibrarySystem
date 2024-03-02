DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_USER`(
	in phone_number varchar(10), 
    in user_password varchar(45), 
    in last_login_time varchar(45),
    OUT userid INT)
BEGIN
	SET @userid = (SELECT `user_id` FROM `user` WHERE `phone_number` = phone_number AND `password` = user_password);

	IF (@userid) THEN
        UPDATE `user` SET `last_login_time` = last_login_time WHERE `user_id` = @ingregid;
	ELSE
		SET @userid = -1;
	END IF;
    
    SELECT @userid;
END$$
DELIMITER ;
