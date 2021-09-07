--dcl (data control language): allows and restricts access to abilities on server (usually only for admins to implement)

--1. create user
create user toejam with password 'earlismybud';

--grant/revoke priveleges
grant all privileges on all TABLES in SCHEMA rashidt to toejam;
revoke all privileges on all TABLES in SCHEMA rashidt FROM toejam;


create role special_admin with
	createdb
	createrole
	login
	inherit;
	
--we can grant the role to the user
grant special_admin to toejam;