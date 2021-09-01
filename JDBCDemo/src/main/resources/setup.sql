-- This is the script where I'm going to create the tables for my app

DROP TYPE IF EXISTS rashidt.user_role CASCADE;
CREATE TYPE rashidt.user_role AS ENUM ('Admin', 'Employee', 'Customer');

-- This is just a demo of JDBC connection, and YOUR projhect 0 script does not need to be exactly like this

DROP TABLE IF EXISTS rashidt.users CASCADE;
CREATE TABLE rashidt.users(
	
	-- it does NOT need to be the same name as your User.java instance variables
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role rashidt.user_role NOT NULL
);

DROP TABLE IF EXISTS rashidt.accounts CASCADE;
CREATE TABLE rashidt.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES rashidt.users(id),
	active BOOLEAN DEFAULT FALSE -- this IS determining whether the account has been activated
);

-- This is demonstrating a MANY to MANY relationship....
DROP TABLE IF EXISTS rashidt.users_account_jt CASCADE;
CREATE TABLE rashidt.users_account_jt (
	acc_owner INTEGER NOT NULL REFERENCES rashidt.users(id),
	account INTEGER NOT NULL REFERENCES rashidt.accounts(id)
);

-- this table represents pending applications of users who want to open an account
DROP TABLE IF EXISTS rashidt.applications CASCADE;
CREATE TABLE rashidt.applications (
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES rashidt.users(id)
);

INSERT INTO rashidt.users(username, pwd, user_role) 
	VALUES ('Larry', 'secret', 'Employee'),
			('Mary', '1234', 'Customer'),
			('Barry', 'dozer', 'Admin'),
			('Kerry', '1wink', 'Customer'),
			('Harry', 'plurg', 'Customer'),
			('Perry', 'docat', 'Employee'),
			('Jerry', 'orange', 'Admin');
		
SELECT * FROM rashidt.users;
		
INSERT INTO rashidt.accounts (balance, acc_owner)
	VALUES (200, 6), (500, 6), (1000, 7), (250, 1);

SELECT * FROM rashidt.accounts;

INSERT INTO rashidt.users_account_jt
	VALUES (1, 1),
	(2, 2),
	(6, 3),
	(7, 4);

SELECT * FROM rashidt.users_account_jt;

-- JOIN from the accounts table and the users_account_jt WHERE the accowner_id is the same as the userId
SELECT rashidt.accounts.id, rashidt.accounts.balance
	FROM rashidt.accounts
	INNER JOIN rashidt.users_account_jt
	ON rashidt.accounts.id = rashidt.users_account_jt.acc_owner;


