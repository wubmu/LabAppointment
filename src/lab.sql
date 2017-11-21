CREATE TABLE information
(
  lab_id VARCHAR(10),
  lab_name VARCHAR(20),
  lab_num INT(11),
  teacher_id VARCHAR(10),
  lab_tab VARCHAR(2),
  lab_date VARCHAR(20),
  course_id VARCHAR(10) PRIMARY KEY NOT NULL,
  CONSTRAINT information_lab_lab_id_fk FOREIGN KEY (lab_id) REFERENCES lab (lab_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT information_teacher_teacher_id_fk FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX information_lab_lab_id_fk ON information (lab_id);
CREATE INDEX information_teacher_teacher_id_fk ON information (teacher_id);

CREATE TABLE lab
(
  lab_id VARCHAR(10) PRIMARY KEY NOT NULL,
  lab_address VARCHAR(20),
  lab_name1 VARCHAR(20)
);
CREATE TABLE sc
(
  student_id VARCHAR(10) NOT NULL,
  course_id VARCHAR(10) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (student_id, course_id),
  CONSTRAINT sc_student_student_id_fk FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT sc_information_course_id_fk FOREIGN KEY (course_id) REFERENCES information (course_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX sc_information_course_id_fk ON sc (course_id);

CREATE TABLE student
(
  student_id VARCHAR(10) PRIMARY KEY NOT NULL,
  student_name VARCHAR(10),
  student_sex VARCHAR(2),
  student_dept VARCHAR(20),
  student_password VARCHAR(20)
);

CREATE TABLE teacher
(
  teacher_name VARCHAR(10),
  teacher_id VARCHAR(10) PRIMARY KEY NOT NULL,
  teacher_sex VARCHAR(2),
  teacher_tel VARCHAR(11),
  teacher_class VARCHAR(20),
  teacher_dept VARCHAR(30)
);