--1NF
CREATE TABLE employee (
	employee_id Serial PRImary KEY,
	emp_name VARCHAR(100) NOT NULL,
	ss_number integer,
	dept_name varchar(100)
);


--2NF
CREATE TABLE employee_2NF (
	employee_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(100) NOT NULL,
	ss_number integer
);

CREATE TABLE department_2NF (
	employee_id INTEGER REFERENCES employee_2NF(employee_id),
	dept_name VARCHAR(100) NOT NULL
);


--3NF
CREATE TABLE employee_3NF (
	employee_id SERIAL PRIMARY KEY,
	emp_name VARCHAR(100) NOT NULL,
	ss_number integer
);

--must be made before employee department so that that table can reference this one
CREATE TABLE department_3NF (
	dept_id integer PRIMARY KEY, --this must be persisted FROM the app
	dept_name VARCHAR(100)
);

DROP TABLE IF EXISTS public.employee_department_3NF CASCADE;

CREATE TABLE employee_department_3NF (
	employee_id integer REFERENCES employee_3NF(employee_id),
	dept_id INTEGER REFERENCES department_3NF(dept_id)
);

