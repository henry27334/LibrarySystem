DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_BOOK_STATUS`(
	in inventory_id INT, 
    in book_status INT, 
    out success INT)
BEGIN
	UPDATE librarysystem.inventory as inv
	SET inv.status = book_status
    WHERE inv.inventory_id = inventory_id;
    
    SET success = inventory_id;
END$$
DELIMITER ;
