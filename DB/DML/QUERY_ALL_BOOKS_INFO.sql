DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `QUERY_ALL_BOOKS_INFO`()
BEGIN
	SELECT *
	FROM `librarysystem`.`book` as `bk`
    INNER JOIN `librarysystem`.`inventory` as `inv`
    WHERE `bk`.`isbn` = `inv`.`isbn`;
END$$
DELIMITER ;
