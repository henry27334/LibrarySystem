DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_ALL_BOOKS`()
BEGIN
	SELECT *  FROM `librarysystem`.`book`;
END$$
DELIMITER ;