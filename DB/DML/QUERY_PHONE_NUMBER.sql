DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_PHONE_NUMBER`(
	in phone_number VARCHAR(45),
    out is_exist int
)
BEGIN
	IF (SELECT `user`.`phone_number` FROM `librarysystem`.`user` WHERE `user`.`phone_number` = phone_number) then
		SET is_exist = 1;
	ELSE
		SET is_exist = 0;
	END IF;
	SELECT is_exist;
END$$
DELIMITER ;
