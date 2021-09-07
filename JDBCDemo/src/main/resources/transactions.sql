CREATE table bank_accounts (
	cust_name VARCHAR(50),
	balance numeric(50, 2)
);

insert into bank_accounts (cust_name, balance)
	values ('Alice', 100), 
			('bob', 50), 
			('Sam', 0);
			
select * from BANK_ACCOUNTS;
		
--what happens if alice sends bob $50?
UPDATE BANK_ACCOUNTS set BALANCE = BALANCE - 50 WHERE CUST_NAME = 'Alice';
UPDATE BANK_ACCOUNTS set BALANCE = BALANCE + 50 where CUST_NAME = 'bob';
--but this is not safe, you could lose $50 in a power outage or the like

--a transaction is a unit of work to be performed against DB that follows certain principals (A.C.I.D.)
--A: ATOMIC - either it happens or it doesn't (you can't split it)
--C: consistent - referential integrity is maintained and constraints are changed on success
--I: isolated  -transactions happen independently
--D: durability - ensures that the rest of the event occurs even in the event of an inturruption (such asa power failure)

--TCL (transaction control language):
begin;
	UPDATE BANK_ACCOUNTS set BALANCE = BALANCE - 50 WHERE CUST_NAME = 'Alice';
	
	--savepoints allow you to discard the remaining part of something while committing the rest
	savepoint my_save;

	--savepoint example: didn't mean to make this money
	UPDATE BANK_ACCOUNTS set BALANCE = BALANCE + 50 where CUST_NAME = 'Sam';

	rollback to my_save;
--think about how you would use this in java to check for issues
	
	UPDATE BANK_ACCOUNTS set BALANCE = BALANCE + 50 where CUST_NAME = 'bob';
end;

select * from BANK_ACCOUNTS;

--transactions are acidic

-----------------------------------------------------------------------------------------------------------------------------
/*
 *transaction issues 
