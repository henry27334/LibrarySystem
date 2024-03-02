DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_BORROWING_RECORD`(
	in user_id INT, 
    in inventory_id INT, 
    in return_time VARCHAR(45), 
    out success INT
)
BEGIN
	UPDATE librarysystem.borrowing_record as ibr
	SET ibr.return_time = return_time
	WHERE ibr.user_id = user_id AND ibr.inventory_id = inventory_id;

	SET success = 1;
END$$
DELIMITER ;
