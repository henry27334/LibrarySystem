DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_USER`(
	in phone_number varchar(10), 
    OUT userid INT)
BEGIN
	SET @userid = (SELECT `user_id` FROM `user` WHERE `user`.`phone_number` = phone_number);
    
	IF NOT EXISTS (SELECT `user_id` FROM `user` WHERE `user`.`phone_number` = phone_number) THEN
		SET @userid = -1;
	END IF;
    
    SELECT @userid;
END$$
DELIMITER ;
