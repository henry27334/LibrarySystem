DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CREATE_USER`(
	IN phone_number VARCHAR(10), 
    IN user_password VARCHAR(45), 
    IN user_name VARCHAR(45), 
    IN registaration_time VARCHAR(45), 
    IN last_login_time VARCHAR(45),
    IN salt VARCHAR(45),
    OUT userId INT)
BEGIN
	INSERT INTO `librarysystem`.`user`
	(`phone_number`,
    `password`,
	`username`,
	`registaration_time`,
	`last_login_time`,
    `salt`)
	VALUES
	(phone_number,
	user_password,
	user_name,
	registaration_time,
	last_login_time,
    salt);

	SET userId = LAST_INSERT_ID();  
END$$
DELIMITER ;
