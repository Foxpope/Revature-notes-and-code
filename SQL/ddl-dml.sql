--this is a single line comment

/*
multi line

you can put your cursor on the expression and press ctrl_enter to run the script
*/

CREATE SCHEMA rashidt;

DROP TABLE IF EXISTS public.users CASCADE;

--this is DDL (data definition language): defining table structure
CREATE TABLE public.users (
	id SERIAL PRIMARY KEY, -- SERIAL IS an autoincrememted number
	first_name VARCHAR(30) CHECK(LENGTH(first_name) >= 2), -- CONSTRAINTS SERVe TO FILTER 
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) UNIQUE,
	user_age INTEGER NOT NULL DEFAULT 0 CHECK(user_age >= 0),
	supervisor INTEGER
); 

-- Altering a table is also ddl
ALTER TABLE public.users
	ADD CONSTRAINT user_supervisor_fk
	FOREIGN KEY (supervisor) REFERENCES public.users(id);
	


-- DQL: Data Query Language
SELECT * FROM public.users;


-- DML: Data Manipulation Language to add data to our tables
-- INSERT INTO TABLE_NAME (COLUMN1, COLUM2, ...) VALUES (?, ?);

INSERT INTO public.users (first_name, last_name, email, user_age)
	VALUES ('Tony', 'Stark', 'ironman@mail.com', 40);


INSERT INTO public.users (first_name, last_name, email, user_age, supervisor)
	VALUES ('Peter', 'Parker', 'spiderman@mail.com', 16, 1),
 		    ('Pepper', 'Potts', 'pepper@mail.com', 30, 1);
 		   
--DQL
SELECT * FROM public.users;

--selectively query names and save a "virtual table"
CREATE VIEW names AS SELECT first_name, last_name FROM public.users users;

SELECT * FROM names;

--cancatenate and reformat the data with an alias with the as keyword
SELECT first_name || ' ' || LAST_name AS "Full Name" FROM public.users users;

DROP TABLE IF EXISTS public.phonenumbers CASCADE;

CREATE TABLE public.phonenumbers (
	id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL REFERENCES users(id), --our FOREIGN KEY
	home VARCHAR(20),
	work_num varchar(20),
	mobile varchar(20)
);

INSERT INTO public.phonenumbers (user_id, home, mobile)
	VALUES (1, '111-222-3333', '888-777-6666'),
			(3, '555-555-5555', '123-867-5309');

SELECT * FROM phonenumbers;

--DML: how would we delete pepper's phone number from the table
DELETE FROM public.users phonenumbers WHERE user_id = 3;

--this is DDL. truncate vs elete vs drop
TRUNCATE public.users phonenumbers;




