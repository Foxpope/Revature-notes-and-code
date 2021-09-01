--save relevant sql scripts to your java project resources


DROP TYPE IF EXISTS rashidt.user_role CASCADE;
CREATE TYPE rashidt.user_role AS ENUM ('Admin', 'Employee', 'Customer');

--this can be done with commas
DROP TABLE IF exists rashidt.users, rashidt.accounts, rashidt.users_acc_joined, rashidt.applications CASCADE;
--this is just a demo (not *necessarily* a template for project 0)
CREATE TABLE  rashidt.users (
--it does not have to to be the same names as in your User.java instance variables
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role rashidt.user_role NOT NULL
);

CREATE TABLE rashidt.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC (50, 2) DEFAULT 0,
	acc_owner integer NOT NULL REFERENCES rashidt.users(id),
	active boolean DEFAULT FALSE --this IS determining whether the account has been activated
);

--this seperate join table assists in the creation of a many to many table (because many people could own one account and vice versa)
CREATE TABLE rashidt.users_acc_joined (
	acc_owner integer NOT NULL REFERENCES rashidt.users(id),
	account integer NOT NULL REFERENCES rashidt.accounts(id)
);

--for applications to use the system
CREATE TABLE rashidt.applications (
	id Serial PRIMARY KEY,
	app_owner integer NOT NULL REFERENCES rashidt.users(id)
);





