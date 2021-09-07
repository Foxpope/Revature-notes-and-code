CREATE or REPLACE FUNCTION multiply(x numeric, y numeric) 
returns NUMERIC 
as'
	BEGIN 
		return x*y;
end
'
language plpgsql;

SELECT multiply(4, '5');

CREATE or REPLACE FUNCTION rashidt.multiply(x numeric, y numeric, z NUMERIC) 
returns NUMERIC 
as'
	BEGIN 
		return $1*$2*$3;
end
'
language plpgsql;

--we're going to create a function with variables that fetches the last track from the chinook db
--grt remaining from notes
select * FROM chinook."Track"

CREATE OR REPLACE FUNCTION chinook.get_last_track_info()
RETURNS TEXT 
AS $$
	
	DECLARE -- DECLARE variables TO use IN the FUNCTION body 
	largest INT;
	track_name TEXT;
	end_result TEXT;

BEGIN
	
	-- AGGREGATE FUNCTION
	SELECT max("TrackId")
		INTO largest
		FROM chinook."Track";
		
	-- Save the name as the Track name
	-- Select the "Name" columm from the track table where the TrackID is the largest
	SELECT "Name" 
		INTO track_name
		FROM chinook."Track" WHERE "TrackId" = largest;
	
	end_result := largest || ' ' || track_name;

	RETURN end_result;
END

$$
language plpgsql;
