DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CREATE_BORROWING_RECORD`(
	in user_id INT, 
    in inventory_id INT, 
    in borrowing_time VARCHAR(45), 
    out success INT
)
BEGIN
	INSERT INTO `librarysystem`.`borrowing_record`
	(`user_id`,
	`inventory_id`,
	`borrowing_time`)
	VALUES
	(user_id,
	 inventory_id,
	 borrowing_time);
     
     SET success = 1;
END$$
DELIMITER ;
