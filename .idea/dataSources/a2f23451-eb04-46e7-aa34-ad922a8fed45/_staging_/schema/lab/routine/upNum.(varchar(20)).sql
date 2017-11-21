CREATE PROCEDURE `upNum`(`id` VARCHAR(20))
  BEGIN
	#Routine body goes here...
UPDATE information SET lab_num=lab_num-1 WHERE course_id='id';
END