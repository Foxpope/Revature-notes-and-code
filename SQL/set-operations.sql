CREATE TABLE public.one (
	c_one integer PRIMARY KEY,
	c_two integer

);

CREATE TABLE public.two (
	c_one integer PRIMARY KEY,
	c_two integer

);

INSERT INTO public.one VALUES (1, 2), (2, 3);
INSERT INTO public.two VALUES (1, 1), (2, 4);

--set operation only operates on results that have the same number and type of COLUMNS 
--the union operator will combine all results togeter, but will not include duolicates

SELECT * FROM public.one UNION SELECT * FROM public.two;

--union all will include dulicates

SELECT * FROM  public.one UNION ALL SELECT * FROM public.two;

--intersect will include only the matching results from the tables
select * FROM public.one INTERSECT SELECT * FROM public.two; 

--except will keep results from the left view and remove matching results from the right
SELECT * FROM public.one EXCEPT select *FROM public.two;

/*
 * SQL has scalar and aggregate functions
 * 
 * Scalar: perform one thing to every value and return it
 * 
 *Aggregate: operate on one column and produce aone output
 */

--scalar
SELECT upper(first_name), last_name FROM public.users; --uppercases ALL the FIRST names

--aggregate
SELECT SUM(c_one) FROM public.one;
SELECT avg(c_one) FROM public.one;
SELECT max(c_one) FROM public.one;

SELECT avg(length(first_name)) FROM public.users;










