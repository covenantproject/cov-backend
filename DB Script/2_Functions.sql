--public.getallhistory
CREATE OR REPLACE FUNCTION public.getallhistory(
	userid integer)
    RETURNS TABLE(ishealthupdated boolean, ishelpupdated boolean, hascough boolean, hasfever boolean, haschills boolean, hasbreathingissue boolean, currenthealthstatus character varying, temperature double precision, heartrate double precision, respiratoryrate double precision, spo2 double precision, requesttype character varying, comments character varying, timestampval timestamp without time zone) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

BEGIN
		RETURN QUERY(
		select true as ishealthupdated, false as ishelpupdated, "CoughPresent" as hascough,
		"FeverPresent" as hasfever, false as haschills, "BreathingDifficultyPresent" as hasbreathingissue,
		"ProgressStatus" as currenthealthstatus, "TemperatureCelsius" as temperature,
		"HeartRatePerMin" as heartrate, "RespRatePerMin" as respiratoryrate, "SpO2Percent" as spo2, 
		null::varchar as requesttype, null::varchar as comments, "HealthDateTime" as timestampVal
		from public."HealthCheckHistory" where "UserId"=$1
		UNION
		select false as ishealthupdated, true as ishelpupdated, false as hascough,
		false as hasfever,false as haschills, false as hasbreathingissue, null::varchar as currenthealthstatus,
		null::double precision as temperature, null::double precision as heartrate, null::double precision as respiratoryrate,
		null::double precision as spo2, "RequestType" as requesttype, "RequestComments" as comments,
		"RequestDateTime" as timestampVal
		from public."UserRequestHistory" where "UserId"=$1
		ORDER BY timestampVal desc			
		);
END; $BODY$;

--public.getgeofencelocation
CREATE OR REPLACE FUNCTION public.getgeofencelocation(
	userid integer)
    RETURNS TABLE(geofencelocationid integer, patientid integer, geofencelatitude double precision, geofencelongitude double precision, geofenceradiusmetres double precision, geofencestartdate timestamp without time zone, geofenceenddate timestamp without time zone, geofenceset boolean) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
DECLARE 
 patientId integer;
BEGIN
		IF EXISTS(select 1 FROM public."GeofenceLocation" gf
		LEFT JOIN public."Patient" p ON p."PatientId" = gf."PatientId"
		LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId" WHERE p."UserId"=$1) THEN		
			RETURN QUERY(
				SELECT gf."GeofenceLocationId", gf."PatientId", gf."GeoFenceLatitude", gf."GeoFenceLongitude",
				gf."GeoFenceRadiusMetres", gf."GeoFenceStartDate", gf."GeoFenceEndDate", 
				CASE WHEN ps."GeofenceSet" is null THEN false ELSE ps."GeofenceSet" END as "GeofenceSet" 
				FROM public."GeofenceLocation" gf
				LEFT JOIN public."Patient" p ON p."PatientId" = gf."PatientId"
				LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
				where p."UserId"=$1 order by gf."GeofenceLocationId" desc limit 1
			);
		ELSE
			RETURN QUERY(
				SELECT null::integer as "GeofenceLocationId", p."PatientId", null::double precision as "GeoFenceLatitude", null::double precision as "GeoFenceLongitude",
				null::double precision as "GeoFenceRadiusMetres", null::timestamp as "GeoFenceStartDate", null::timestamp as "GeoFenceEndDate", 
				CASE WHEN ps."GeofenceSet" is null THEN false ELSE ps."GeofenceSet" END as "GeofenceSet" 
				FROM public."Patient" p 
				LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
				where p."UserId"=$1 limit 1
			);
		END IF;
				
END; $BODY$;


--public.getlocationhierarchy
CREATE OR REPLACE FUNCTION public.getlocationhierarchy(
	locationid integer)
    RETURNS TABLE(location_id integer, locationname character varying, locationabbreviation character varying, assignpatients boolean, parentlocationid integer, countrycode character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$BEGIN
	 RETURN QUERY(SELECT * FROM public."LocationHierarchy"  WHERE "ParentLocationId" = $1);
END; $BODY$;



--public.getlocationsandrolesforuser
CREATE OR REPLACE FUNCTION public.getlocationsandrolesforuser(
	userid integer)
    RETURNS TABLE(locationid integer, locationname character varying, assignpatients boolean, relationshiptype character varying, parentlocationid integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
BEGIN
	RETURN QUERY(select lc."LocationId",lc."LocationName",lc."AssignPatients", pp."RelationshipType",lc."ParentLocationId" from 
	public."PatientProviderRelationship" pp 
	JOIN public."LocationHierarchy" lc ON pp."RelationshipFacilityLocation" = lc."LocationId"
	where pp."PatientId" in (select "PatientId" from public."Patient" p where p."UserId"=$1));
END; $BODY$;


--public.getpatientinfo
CREATE OR REPLACE FUNCTION public.getpatientinfo(
	userid bigint)
    RETURNS TABLE(patientid integer, firstname character varying, lastname character varying, householdid integer, covid19status character varying, quarantinestatus character varying, isolationstatus character varying, healthrequeststatus character varying, healthrequestmessage character varying, quarantinerequeststatus character varying, suppliesrequeststatus character varying, suppliesrequestmessage character varying, healthstatusalert character varying, geofencestatus character varying, heartbeatstatus character varying, heartbeattime timestamp without time zone, latitude double precision, longitude double precision, quarantinestartdate timestamp without time zone, quarantineenddate timestamp without time zone, sex character varying, dateofbirth timestamp without time zone, phonenumber1 character varying, phonenumber1type character varying, phonenumber1hassms boolean, phonenumber1hasinternet boolean, phonenumber1haswhatsapp boolean, phonenumber1isprimaryuser boolean, quarantineaddress text) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$begin
	
	RETURN QUERY(
		SELECT p."PatientId", u."FirstName", u."LastName", null::integer as householdId,
		ps."COVID19Status", ps."QuarantineStatus", ps."IsolationStatus", ps."MedicalRequestStatus",
		null::varchar as healthRequestMessage, ps."QuarantineRequestStatus", ps."SuppliesRequestStatus",
		null::varchar as suppliesRequestMessage, ps."HealthAlert", ps."GeofenceStatus", ps."HeartbeatStatus",
		hrt."HeartbeatDateTime" as heartbeatTime, ps."Latitude", ps."Longitude", ps."QuarantineStartDateTime" as quarantineStartDate,
		ps."QuarantineEndDateTime" as quarantineEndDate, u."Gender" as sex, u."DateOfBirth",
		phn."PhoneNumber" as phoneNumber1, phn."PhoneType" as phoneNumber1Type, phn."HasSMSAccess" as phoneNumber1HasSMS,
		phn."HasInternetAccess" as phoneNumber1HasInternet, phn."HasWhatsAppAccess" as phoneNumber1HasWhatsapp,
		phn."IsPrimaryUser" as phoneNumber1IsPrimaryUser, CONCAT(a."AddressLine1",', ', a."City",', ', a."State",', ', a."Country")
		from public."User" u
		LEFT JOIN public."Patient" p ON u."UserId" = p."UserId" 
		LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
		LEFT JOIN public."PhoneNumber" phn ON phn."UserId" = u."UserId"
		LEFT JOIN public."AppHeartbeatHistory" hrt
			 ON hrt."AppHeartbeatHistoryId" = (SELECT MAX("AppHeartbeatHistoryId") FROM public."AppHeartbeatHistory" WHERE "PrimaryUserId" = u."UserId")
		LEFT JOIN public."Address" a
			 ON a."AddressId" = (SELECT MAX("AddressId") FROM public."Address" WHERE "UserId" = u."UserId")
		WHERE p."PatientId" = $1
		order by p."PatientId" desc
	);

END;
$BODY$;


--public.getuserhierarchy
CREATE OR REPLACE FUNCTION public.getuserhierarchy(
	superid integer)
    RETURNS TABLE(healthproid integer, title character varying, firstname character varying, lastname character varying, suffix character varying, healthprotype character varying, healthprojobtitle character varying, healthproofficeaddress character varying, healthprolocationid integer, supervisorid integer) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$BEGIN
		IF($1 is null OR $1 = 0) THEN	
			RETURN QUERY(SELECT h."HealthProfessionalId" as healthProId, u."Title", u."FirstName", u."LastName", u."Suffix", null::varchar as healthProType,
			h."HealthProfessionalJobTitle" as healthProJobTitle, null::varchar as healthProOfficeAddress, h."WorkLocationId" as healthProLocationId,
			h."SupervisorId" as supervisorId FROM public."HealthProfessional" h 
			LEFT JOIN public."User" u ON h."HealthProfessionalId" = u."UserId" );
		ELSE
			RETURN QUERY(SELECT h."HealthProfessionalId" as healthProId, u."Title", u."FirstName", u."LastName", u."Suffix", null::varchar as healthProType,
			h."HealthProfessionalJobTitle" as healthProJobTitle, null::varchar as healthProOfficeAddress, h."WorkLocationId" as healthProLocationId,
			h."SupervisorId" as supervisorId FROM public."HealthProfessional" h 
			LEFT JOIN public."User" u ON h."HealthProfessionalId" = u."UserId"  
			WHERE h."SupervisorId" = $1 );
		END IF;
END; $BODY$;



--public.getuserid
CREATE OR REPLACE FUNCTION public.getuserid(
	uname character varying)
    RETURNS TABLE(userid integer, username character varying) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
BEGIN
	RETURN QUERY(SELECT "UserId", "UserName" FROM public."User" where LOWER("UserName")=TRIM(LOWER($1)));
END; $BODY$;


--public.homedetails
CREATE OR REPLACE FUNCTION public.homedetails(
	userid integer)
    RETURNS TABLE(patientid integer, firstname character varying, lastname character varying, latitude double precision, longitude double precision, emergencycontact1 character varying, requestdatetime timestamp without time zone) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$begin
	
	
	IF EXISTS (SELECT 1 FROM public."PatientProviderRelationship" pp LEFT JOIN public."Patient" p ON pp."PatientId" = p."PatientId" WHERE p."UserId" = $1) THEN
		RETURN Query
		SELECT p."PatientId",u."FirstName", u."LastName", 
		ps."Latitude", ps."Longitude", p."EmergencyContact1", hh."HealthDateTime"
		from public."PatientProviderRelationship" pp
		LEFT JOIN public."Patient" p ON pp."PatientId" = p."PatientId"
		LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
		LEFT JOIN public."HealthProfessional" h ON h."HealthProfessionalId" = pp."ProviderId"
		LEFT JOIN public."User" u ON u."UserId" = h."HealthProfessionalId"
		LEFT JOIN public."HealthCheckHistory" hh ON hh."UserId" = u."UserId"
		WHERE p."UserId" = $1
		order by uh."HealthDateTime" desc limit 1;
	ELSE 
		RETURN Query
		SELECT p."PatientId", null::varchar, null::varchar, 
		ps."Latitude", ps."Longitude", p."EmergencyContact1", hh."HealthDateTime"
		FROM public."Patient" p
		LEFT JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
		LEFT JOIN public."HealthCheckHistory" hh ON hh."UserId" = p."UserId"
		WHERE p."UserId" = $1
		order by hh."HealthDateTime" desc limit 1;
	END IF;

END;
$BODY$;



--public.raiseyourhand
CREATE OR REPLACE FUNCTION public.raiseyourhand(
	userid integer,
	reqtype character varying,
	reqstatus character varying,
	comments character varying)
    RETURNS character varying
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
BEGIN
    INSERT INTO public."UserRequestHistory" ("UserId" ,"RequestType" ,"RequestStatus" ,"RequestComments"  ) VALUES ($1,$2,$3,$4);
   return 'SUCCESS';
END
$BODY$;


--public.registernewhealthpro
CREATE OR REPLACE FUNCTION public.registernewhealthpro(
	title character varying,
	firstname character varying,
	lastname character varying,
	suffix character varying,
	gender character varying,
	dateofbirth date,
	emailaddress character varying,
	phonenumber character varying,
	healthprotype character varying,
	healthprojobtitle character varying,
	healthproofficeaddress character varying,
	healthprolocationid integer,
	supervisorid integer DEFAULT NULL::integer,
	username character varying DEFAULT NULL::character varying)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$DECLARE 
 userID integer;
BEGIN
	INSERT INTO public."User"(
	 "Title", "FirstName","LastName","Suffix","Gender", "DateOfBirth", "UserName")
	VALUES ($1, $2,$3,$4,$5,$6,$14)
	RETURNING public."User"."UserId" INTO userID;
	INSERT INTO public."EmailAddress"(
	"UserId", "EmailAddress")
	VALUES (userID, $7);	
	INSERT INTO public."PhoneNumber"(
	"UserId","PhoneNumber")
	VALUES (userID, $8);
	
	IF ($13 = 0) THEN
		INSERT INTO public."HealthProfessional"(
		 "HealthProfessionalId", "HealthProfessionalJobTitle", "WorkLocationId")
		VALUES (userID,$10,$12);
	ELSE
		INSERT INTO public."HealthProfessional"(
		 "HealthProfessionalId","SupervisorId", "HealthProfessionalJobTitle", "WorkLocationId")
		VALUES (userID,$13,$10,$12);
	END IF;
	
	RETURN userID;
END; $BODY$;


--public.savelocationhistory
CREATE OR REPLACE FUNCTION public.savelocationhistory(
	userid integer,
	latitude double precision,
	longitude double precision,
	code character varying)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
DECLARE 
 userID integer;
 geofenceStatus character varying;
 deviceId integer;
BEGIN
	INSERT INTO public."LocationHistory"(
	 "UserId", "Latitude", "Longitude", "Code")
	VALUES ($1, $2,$3,$4);
	
	IF $4 = 'GEOFENCE_EXIT' THEN
		SELECT 'Outside - near' into geofenceStatus;
	ELSIF $4 = 'GEOFENCE_ENTER' THEN
		SELECT 'Inside' into geofenceStatus;
	ELSIF $4 = 'GEOFENCE_FAR' THEN
		SELECT 'Outside - far' into geofenceStatus;
	END IF;
	
	SELECT "PatientId" into userID from public."Patient" where "UserId"=$1;
	IF EXISTS (select 1 FROM public."PatientStatus" where "PatientId"=userID) THEN
		Update public."PatientStatus" SET "GeofenceStatus" = geofenceStatus, "HeartbeatStatus" = 'Online' where "PatientId"=userID;
	ELSE 
		INSERT INTO public."PatientStatus"("PatientId", "GeofenceStatus", "HeartbeatStatus")VALUES(userID, geofenceStatus, 'Online');
	END IF;
	
	IF EXISTS (SELECT "DeviceSID" from public."PatientDeviceApp" where "PrimaryUserId"=$1) THEN
		SELECT "DeviceSID" into deviceId from public."PatientDeviceApp" where "PrimaryUserId"=$1;
	ELSE
		INSERT INTO public."PatientDeviceApp"("PrimaryUserId")VALUES($1)
		RETURNING public."PatientDeviceApp"."DeviceSID" INTO deviceId;
	END IF;
	
	INSERT INTO public."AppHeartbeatHistory"("PrimaryUserId", "DeviceId", "HeartBeatStatus")
	VALUES($1, deviceId, 'Online');
	
	RETURN 'SUCCESS';
END; $BODY$;


--public.savepatientproviderrela
CREATE OR REPLACE FUNCTION public.savepatientproviderrela(
	patientid integer,
	providerid integer,
	relationshiptype character varying,
	locationid integer,
	relationshipstartdate date DEFAULT NULL::date,
	relationshipenddate date DEFAULT NULL::date)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$BEGIN
	INSERT INTO public."PatientProviderRelationship"(
	 "PatientId", "ProviderId", "RelationshipType", "RelationshipStartDate", "RelationshipEndDate", "RelationshipFacilityLocation")
	VALUES ($1, $2,$3,$5,$6,$4);
	RETURN 'SUCCESS';
END; $BODY$;



--public.updategeofencelocation
CREATE OR REPLACE FUNCTION public.updategeofencelocation(
	patientid integer,
	geofencelattitude double precision,
	geofencelongitude double precision,
	geofenceradiusmetres double precision,
	geofencestartdate date,
	geofenceenddate date,
	geofenceset boolean)
    RETURNS text
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$DECLARE 
 userID integer;
BEGIN
	SELECT "PatientId" into  userID from public."Patient" where "UserId"=$1;
	INSERT INTO public."GeofenceLocation"(
	 "PatientId", "GeoFenceLatitude", "GeoFenceLongitude", "GeoFenceRadiusMetres", "GeoFenceStartDate", "GeoFenceEndDate")
	VALUES (userID, $2,$3,$4,$5,$6);
	
	IF EXISTS (select 1 FROM public."PatientStatus" where "PatientId"=userID) THEN
		Update public."PatientStatus" SET "GeofenceSet" = $7 where "PatientId"=userID;
	ELSE 
		INSERT INTO public."PatientStatus"("PatientId", "GeofenceSet")VALUES(userID, $7);
	END IF;
	RETURN 'SUCCESS';
END; $BODY$;



--public.updatehealth
CREATE OR REPLACE FUNCTION public.updatehealth(
	userid integer,
	coughpresent boolean,
	feverpresent boolean,
	breathingdifficultypresent boolean,
	progressstatus character varying,
	temperature double precision,
	heartrate integer,
	respiratoryrate integer,
	spo2 integer)
    RETURNS character varying
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$
BEGIN
    INSERT INTO public."HealthCheckHistory" ("UserId","CoughPresent" ,"FeverPresent" ,
   "BreathingDifficultyPresent" ,"ProgressStatus" ,"TemperatureCelsius" ,
  "HeartRatePerMin" ,"RespRatePerMin" ,"SpO2Percent" ) VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9);
 return 'SUCCESS';
END
$BODY$;