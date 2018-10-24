DELIMITER $$
CREATE PROCEDURE usp_get_author_books (IN f_name VARCHAR(255), IN l_name VARCHAR(255), OUT books_count INT)
BEGIN
     IF f_name NOT IN (SELECT a.first_name FROM `authors` AS a)
 		THEN
 			ROLLBACK;
             SIGNAL SQLSTATE '45000'
             SET MESSAGE_TEXT = 'There is no Author with this first name!';
 	ELSEIF l_name NOT IN (SELECT a.last_name FROM `authors` AS a)
 		THEN
 			ROLLBACK;
             SIGNAL SQLSTATE '45000'
             SET MESSAGE_TEXT = 'There is no Author with this last name!';
 	ELSE
		SET books_count = (
        SELECT
        count(b.id) AS 'books_count'
        FROM `authors` AS a JOIN `books` AS b
        ON b.author_id = a.id
        WHERE a.first_name = f_name AND a.last_name = l_name
        GROUP BY a.id);
     END IF;
END $$
DELIMITER ;