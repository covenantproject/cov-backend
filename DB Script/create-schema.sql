-- CREATE SCRIPTS FOR PUBLIC SCHEMA

CREATE TYPE "public"."phototype" CREATE TYPE public.phototype AS ENUM ( profile, selfie, officialid, other );

CREATE  TABLE "public"."CovidContact" ( 
	"ContactId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"ContactUserID1"     varchar(10)   ,
	"ContactUserID2"     varchar(10)   ,
	"ContactTimeStart"   varchar(10)   ,
	"ContactTimeEnd"     varchar(10)   ,
	"ContactLocation"    varchar(10)   ,
	"ContactRelationship" varchar(10)   ,
	"ContactExposure"    varchar(10)   ,
	CONSTRAINT "CovidContact_pkey" PRIMARY KEY ( "ContactId" )
 );

CREATE  TABLE "public"."LocationHierarchy" ( 
	"LocationId"         integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"LocationName"       varchar   ,
	"LocationAbbreviation" varchar   ,
	"AssignPatients"     bool DEFAULT false  ,
	"ParentLocationId"   integer   ,
	"CountryCode"        varchar   ,
	CONSTRAINT "Location_pkey" PRIMARY KEY ( "LocationId" )
 );

CREATE  TABLE "public"."UserPhotos" ( 
	"PhotoId"            integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PhotoType"          varchar(15) DEFAULT 'AppProfile'::character varying  ,
	"PhotoPath"          varchar(150)   ,
	"FileSavedDateTime"  timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT "UserPhotos_pkey" PRIMARY KEY ( "PhotoId" )
 );

CREATE  TABLE "public"."User" ( 
	"UserId"             integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"Title"              varchar(10)   ,
	"FirstName"          varchar(32)   ,
	"MiddleName"         varchar(32)   ,
	"LastName"           varchar(32)   ,
	"PreferredName"      varchar(32)   ,
	"ShortName"          varchar(16)   ,
	"Suffix"             varchar(10)   ,
	"DateOfBirth"        timestamp   ,
	"Gender"             varchar(10)   ,
	"ProfilePhotoId"     integer   ,
	"OTPCode"            varchar   ,
	CONSTRAINT "User_pkey" PRIMARY KEY ( "UserId" )
 );

CREATE  TABLE "public"."UserRequestHistory" ( 
	"UserRequestHistoryId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"RequestType"        varchar DEFAULT 'Supplies'::character varying  ,
	"RequestDateTime"    timestamp DEFAULT timezone('utc'::text, now())  ,
	"RequestStatus"      varchar DEFAULT 'Open'::character varying  ,
	"RequestComments"    varchar   ,
	"ResponseType"       varchar DEFAULT 'Phone'::character varying  ,
	"ResponseUserId"     integer   ,
	"ResponseDateTime"   timestamp   ,
	"ResponseComments"   varchar   ,
	CONSTRAINT "UserRequestHistory_pkey" PRIMARY KEY ( "UserRequestHistoryId" )
 );

CREATE  TABLE "public"."Address" ( 
	"AddressId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"AddressType"        varchar(10)   ,
	"CompanyName"        varchar(10)   ,
	"InCareOf"           varchar(10)   ,
	"AddressLine1"       varchar(10)   ,
	"AddressLine2"       varchar(10)   ,
	"AddressLine3"       varchar(10)   ,
	"City"               varchar(10)   ,
	"DistrictCounty"     varchar(10)   ,
	"State"              varchar(10)   ,
	"PostCode"           varchar(10)   ,
	"Country"            varchar(10)   ,
	CONSTRAINT "Address_pkey" PRIMARY KEY ( "AddressId" )
 );

CREATE  TABLE "public"."Allergy" ( 
	"AllergyId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"AllergenType"       varchar(10)   ,
	"AllergenSCT"        varchar(10)   ,
	"AllergicReactionSCT" varchar(10)   ,
	"AllergySeverity"    varchar(10)   ,
	"Current"            varchar(10)   ,
	"Duration"           varchar(10)   ,
	CONSTRAINT "Allergy_pkey" PRIMARY KEY ( "AllergyId" )
 );

CREATE  TABLE "public"."EmailAddress" ( 
	"EmailAddressId"     integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"EmailAddress"       varchar(25)   ,
	"PersonalOrWork"     varchar(10)   ,
	"IsPreferred"        bool   ,
	"IsPrimaryUser"      bool   ,
	"PrimaryUserId"      integer   ,
	CONSTRAINT "EmailAddress_pkey" PRIMARY KEY ( "EmailAddressId" )
 );

CREATE  TABLE "public"."ExternalIdentifier" ( 
	"IdentificationId"   integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"IDType"             varchar(10)   ,
	"IDTypeURI"          varchar(10)   ,
	"IssuingAuthorityName" varchar(10)   ,
	"IssuingAuthorityID" varchar(10)   ,
	"IssuingAuthorityURI" varchar(10)   ,
	"IDNumber"           varchar(20)   ,
	"IssueDate"          varchar(10)   ,
	"ExpirationDate"     varchar(10)   ,
	CONSTRAINT "ExternalIdentifier_pkey" PRIMARY KEY ( "IdentificationId" )
 );

CREATE  TABLE "public"."HealthProfessional" ( 
	"HealthProfessionalId" integer  NOT NULL ,
	"SupervisorId"       integer   ,
	"HealthProfessionalJobTitle" varchar(15)   ,
	"IsActive"           bool DEFAULT true  ,
	"WorkLocationId"     integer   ,
	CONSTRAINT "HealthPro_pkey" PRIMARY KEY ( "HealthProfessionalId" )
 );

CREATE  TABLE "public"."LocationHistory" ( 
	"LocationHistoryId"  integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"Latitude"           float8   ,
	"Longitude"          float8   ,
	"Code"               varchar(50)   ,
	"LocationDateTime"   timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT "LocationHistory_pkey" PRIMARY KEY ( "LocationHistoryId" )
 );

CREATE  TABLE "public"."Medication" ( 
	"MedicationId"       integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"IngredientRxCUI"    varchar(10)   ,
	"BrandedName"        varchar(10)   ,
	"IngredientName"     varchar(10)   ,
	"IsCurrent"          varchar(10)   ,
	"Duration"           varchar(10)   ,
	"Strength"           varchar(10)   ,
	"Dose"               varchar(10)   ,
	"Frequency"          varchar(10)   ,
	"Route"              varchar(10)   ,
	"Indication"         varchar(10)   ,
	"Intent"             varchar(10)   ,
	"Comments"           varchar   ,
	CONSTRAINT "Medication_pkey" PRIMARY KEY ( "MedicationId" )
 );

CREATE  TABLE "public"."Patient" ( 
	"PatientId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"Nationality"        bool   ,
	"EmergencyContact1"  varchar(20)   ,
	"EContact1RelToPt"   varchar(10)   ,
	"EmergencyContact2"  varchar(20)   ,
	"EContact2RelToPt"   varchar(10)   ,
	"NextOfKin1"         bool   ,
	"NofKin1RelToPt"     varchar(10)   ,
	"NextofKin2"         bool   ,
	"NofKin2RelToPt"     varchar(10)   ,
	"HasPreExistingConditions" bool   ,
	"HasMedications"     bool   ,
	"HasAllergies"       bool   ,
	"HasAdvanceDirectives" bool   ,
	"NeedsCarer"         bool   ,
	"HasInternationalTravel" bool   ,
	"HasInterstateTravel" bool   ,
	"HasHighRiskFacilityVisit" bool   ,
	"IsHighRiskHealthWorker" bool   ,
	"ClinicalTrialStatus" varchar(10)   ,
	"Comments"           varchar(10)   ,
	CONSTRAINT "Patient_pkey" PRIMARY KEY ( "PatientId" )
 );

CREATE  TABLE "public"."PatientDeviceApp" ( 
	"DeviceSID"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PrimaryUserId"      integer   ,
	"DeviceIMEI"         varchar   ,
	"DeviceMacID"        varchar   ,
	"DeviceOS"           varchar   ,
	"DeviceOSVersion"    varchar   ,
	"DeviceManufacturer" varchar   ,
	"DeviceModel"        varchar   ,
	"DevicePhoneNumber"  varchar   ,
	"DevicePhoneServiceProvider" varchar   ,
	"AppVersion"         varchar   ,
	"AppInstalledDateTime" timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT "PatientDeviceApp_pkey" PRIMARY KEY ( "DeviceSID" )
 );

CREATE  TABLE "public"."PatientProviderRelationship" ( 
	"PatProRelationshipId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer   ,
	"ProviderId"         integer   ,
	"RelationshipType"   varchar(15)   ,
	"RelationshipStartDate" timestamp   ,
	"RelationshipEndDate" timestamp   ,
	"RelationshipFacilityLocation" integer   ,
	CONSTRAINT "PatientProviderRelationship_pkey" PRIMARY KEY ( "PatProRelationshipId" )
 );

CREATE  TABLE "public"."PatientStatus" ( 
	"PatientStatusId"    integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer   ,
	"COVID19Status"      varchar DEFAULT 'Susceptible'::character varying  ,
	"PatientType"        varchar DEFAULT 'Not applicable'::character varying  ,
	"QuarantineStatus"   varchar DEFAULT 'Not quarantined'::character varying  ,
	"IsolationStatus"    varchar DEFAULT 'Not isolated'::character varying  ,
	"QuarantineStartDateTime" timestamp   ,
	"QuarantineEndDateTime" timestamp   ,
	"IsolationStartDateTime" timestamp   ,
	"IsolationEndDateTime" timestamp   ,
	"QuarantineRequestStatus" varchar(10)   ,
	"MedicalRequestStatus" varchar(10)   ,
	"SuppliesRequestStatus" varchar(10)   ,
	"GeofenceStatus"     varchar   ,
	"Latitude"           float8   ,
	"Longitude"          float8   ,
	"HeartbeatStatus"    varchar   ,
	"HealthStatusAlert"  varchar   ,
	CONSTRAINT "PatientStatus_pkey" PRIMARY KEY ( "PatientStatusId" )
 );

CREATE  TABLE "public"."PhoneNumber" ( 
	"PhoneNumberId"      integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"PhoneType"          varchar(10)   ,
	"PhoneNumber"        varchar(20)   ,
	"PersonalOrWork"     varchar(10)   ,
	"IsPreferred"        bool   ,
	"IsPrimaryUser"      bool   ,
	"PrimaryUserId"      integer   ,
	"HasInternetAccess"  bool   ,
	"HasSMSAccess"       bool   ,
	"HasWhatsAppAccess"  bool   ,
	"HasTelegramAccess"  bool   ,
	CONSTRAINT "PhoneNumber_pkey" PRIMARY KEY ( "PhoneNumberId" )
 );

CREATE  TABLE "public"."PreExistingCondition" ( 
	"PreExistingConditionId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"PreExistingCondtionSCT" varchar(10)   ,
	"Active"             varchar(10)   ,
	"Controlled"         varchar(10)   ,
	"Duration"           varchar(10)   ,
	CONSTRAINT "PreExistingCondition_pkey" PRIMARY KEY ( "PreExistingConditionId" )
 );

CREATE  TABLE "public"."PreExistingConditionsCovidDenorm" ( 
	"CovidPreExistingConditionId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	COPD                 varchar(10)   ,
	"Bronchitis"         varchar(10)   ,
	"DiabetesMellitus"   varchar(10)   ,
	"Hypertension"       varchar(10)   ,
	"ChronicRenalDisease" varchar(10)   ,
	"Malignancy"         varchar(10)   ,
	"HeartDisease"       varchar(10)   ,
	"Asthma"             varchar(10)   ,
	"Other"              varchar(10)   ,
	CONSTRAINT "PreExistingConditionsCovidDenorm_pkey" PRIMARY KEY ( "CovidPreExistingConditionId" )
 );

CREATE  TABLE "public"."AppHeartbeatHistory" ( 
	"AppHeartbeatHistoryId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PrimaryUserId"      integer   ,
	"DeviceId"           integer   ,
	"HeartbeatDateTime"  timestamp DEFAULT timezone('utc'::text, now())  ,
	"HeartBeatStatus"    varchar(10)   ,
	CONSTRAINT "AppHeartbeatHistory_pkey" PRIMARY KEY ( "AppHeartbeatHistoryId" )
 );

CREATE  TABLE "public"."GeofenceLocation" ( 
	"GeofenceLocationId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer   ,
	"GeoFenceLatitude"   float8   ,
	"GeoFenceLongitude"  float8   ,
	"GeoFenceRadiusMetres" float8   ,
	"GeoFenceStartDate"  timestamp   ,
	"GeoFenceEndDate"    timestamp   ,
	CONSTRAINT "GeofenceLocation_pkey" PRIMARY KEY ( "GeofenceLocationId" )
 );

CREATE  TABLE "public"."HealthCheckHistory" ( 
	"HealthHistoryId"    integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer   ,
	"EnteredByUserID"    integer   ,
	"DeviceID"           integer   ,
	"LocationID"         integer   ,
	"HealthDateTime"     timestamp DEFAULT timezone('utc'::text, now())  ,
	"HealthCheckReason"  varchar   ,
	"HealthCheckMethod"  varchar   ,
	"CoughPresent"       bool DEFAULT false  ,
	"FeverPresent"       bool DEFAULT false  ,
	"BreathingDifficultyPresent" bool DEFAULT false  ,
	"ProgressStatus"     varchar DEFAULT 'Stay the same'::character varying  ,
	"TemperatureCelsius" float8   ,
	"HeartRatePerMin"    integer   ,
	"RespRatePerMin"     integer   ,
	"SpO2Percent"        integer   ,
	"SystolicBPMMHg"     integer   ,
	"DiastolicBPMMHg"    integer   ,
	"Comments"           varchar   ,
	CONSTRAINT "HealthHistory_pkey" PRIMARY KEY ( "HealthHistoryId" )
 );

CREATE OR REPLACE FUNCTION public.getgeofencelocation(userid integer)
 RETURNS TABLE(geofencelocationid integer, patientid integer, geofencelatitude double precision, geofencelongitude double precision, geofenceradiusmetres double precision, geofencestartdate timestamp without time zone, geofenceenddate timestamp without time zone)
 LANGUAGE plpgsql
AS $function$DECLARE 
 patientId integer;
BEGIN
		RETURN QUERY(SELECT * FROM public."GeofenceLocation" WHERE "PatientId" IN (SELECT "PatientId" FROM
					public."Patient" WHERE "UserId"=$1));
END; $function$
;

CREATE OR REPLACE FUNCTION public.getlocationhierarchy(locationid integer)
 RETURNS TABLE(location_id integer, locationname character varying, locationabbreviation character varying, assignpatients boolean, parentlocationid integer, countrycode character varying)
 LANGUAGE plpgsql
AS $function$BEGIN
	 RETURN QUERY(SELECT * FROM public."LocationHierarchy"  WHERE "LocationId" = $1);
END; $function$
;

CREATE OR REPLACE FUNCTION public.getlocationsandrolesforuser(userid integer)
 RETURNS TABLE(locationid integer, locationname character varying, assignpatients boolean, relationshiptype character varying, parentlocationid integer)
 LANGUAGE plpgsql
AS $function$
DECLARE 
 patientId integer;
BEGIN
	RETURN QUERY(select lc."LocationId",lc."LocationName",lc."AssignPatients", pp."RelationshipType",lc."ParentLocationId" from 
	public."PatientProviderRelationship" pp 
	JOIN public."LocationHierarchy" lc ON pp."RelationshipFacilityLocation" = lc."LocationId"
	where pp."PatientId" in (select "PatientId" from public."Patient" p,public."User" u where p."UserId"=$1));
END; $function$
;

CREATE OR REPLACE FUNCTION public.historylist(id integer)
 RETURNS TABLE(healthhistoryid integer, userid integer, coughpresent boolean, feverpresent boolean, breathingdifficultypresent boolean, progressstatus character varying, temperaturecelsius double precision, heartratepermin integer, respratepermin integer, spo2percent integer)
 LANGUAGE plpgsql
AS $function$
begin
	RETURN Query  
	select "HealthHistoryId","UserId" ,"CoughPresent" ,
"FeverPresent" ,"BreathingDifficultyPresent" ,
"ProgressStatus" ,"TemperatureCelsius","HeartRatePerMin" ,
"RespRatePerMin" ,"SpO2Percent" from public."HealthCheckHistory"
where "UserId"=$1;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.homedetails(userid integer)
 RETURNS TABLE(patientid integer, firstname character varying, lastname character varying, latitude double precision, longitude double precision, emergencycontact1 character varying, requestdatetime timestamp without time zone)
 LANGUAGE plpgsql
AS $function$
begin
	RETURN Query  
	SELECT p."PatientId",u."FirstName", u."LastName", 
	ps."Latitude", ps."Longitude", p."EmergencyContact1", uh."RequestDateTime"
	from public."PatientProviderRelationship" pp
	JOIN public."Patient" p ON pp."PatientId" = p."PatientId"
	JOIN public."PatientStatus" ps ON ps."PatientId" = p."PatientId"
	JOIN public."HealthProfessional" h ON h."HealthProfessionalId" = pp."ProviderId"
	JOIN public."User" u ON u."UserId" = h."UserId"
	LEFT JOIN public."UserRequestHistory" uh ON uh."UserId" = u."UserId"
	WHERE pp."PatientId" = $1;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.raiseyourhand(userid integer, reqtype character varying, reqstatus character varying, comments character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
BEGIN
    INSERT INTO public."UserRequestHistory" ("UserId" ,"RequestType" ,"RequestStatus" ,"RequestComments"  ) VALUES ($1,$2,$3,$4);
   return 'SUCCESS';
END
$function$
;

CREATE OR REPLACE FUNCTION public.registernewhealthpro(title character varying, firstname character varying, lastname character varying, suffix character varying, gender character varying, dateofbirth date, emailaddress character varying, phonenumber character varying, healthprotype character varying, healthprojobtitle character varying, healthproofficeaddress character varying, healthprolocationid integer, supervisorid integer)
 RETURNS text
 LANGUAGE plpgsql
AS $function$DECLARE 
 userID integer;
BEGIN
	INSERT INTO public."User"(
	 "Title", "FirstName","LastName","Suffix","Gender", "DateOfBirth" )
	VALUES ($1, $2,$3,$4,$5,$6)
	RETURNING public."User"."UserId" INTO userID;
	INSERT INTO public."EmailAddress"(
	"UserId", "EmailAddress")
	VALUES (userID, $7);	
	INSERT INTO public."PhoneNumber"(
	"UserId","PhoneNumber")
	VALUES (userID, $8);
	
	RETURN 'SUCCESS';
END; $function$
;

CREATE OR REPLACE FUNCTION public.savepatientproviderrela(patientid integer, providerid integer, relationshiptype character varying, locationid integer, relationshipstartdate date DEFAULT NULL::date, relationshipenddate date DEFAULT NULL::date)
 RETURNS text
 LANGUAGE plpgsql
AS $function$BEGIN
	INSERT INTO public."PatientProviderRelationship"(
	 "PatientId", "ProviderId", "RelationshipType", "RelationshipStartDate", "RelationshipEndDate", "RelationshipFacilityLocation")
	VALUES ($1, $2,$3,$5,$6,$4);
	RETURN 'SUCCESS';
END; $function$
;

CREATE OR REPLACE FUNCTION public.updategeofencelocation(patientid integer, geofencelattitude double precision, geofencelongitude double precision, geofenceradiusmetres double precision, geofencestartdate date, geofenceenddate date)
 RETURNS text
 LANGUAGE plpgsql
AS $function$
BEGIN
	INSERT INTO public."GeofenceLocation"(
	 "PatientId", "GeoFenceLatitude", "GeoFenceLongitude", "GeoFenceRadiusMetres", "GeoFenceStartDate", "GeoFenceEndDate")
	VALUES ($1, $2,$3,$4,$5,$6);
	RETURN 'SUCCESS';
END; $function$
;

CREATE OR REPLACE FUNCTION public.updategeofencelocation1(patientid integer, geofencelattitude double precision, geofencelongitude double precision, geofenceradiusmetres double precision, geofencestartdate date, date)
 RETURNS text
 LANGUAGE plpgsql
AS $function$
DECLARE 
 userID integer;
BEGIN
	SELECT "PatientId" as userID from public."Patient" where "UserId"=$1;
	INSERT INTO public."GeofenceLocation"(
	 "PatientId", "GeoFenceLatitude", "GeoFenceLongitude", "GeoFenceRadiusMetres", "GeoFenceStartDate", "GeoFenceEndDate")
	VALUES (userID, $2,$3,$4,$5,$6);
	RETURN 'SUCCESS';
END; $function$
;

CREATE OR REPLACE FUNCTION public.updatehealth(userid integer, coughpresent boolean, feverpresent boolean, breathingdifficultypresent boolean, progressstatus character varying, temperature double precision, heartrate integer, respiratoryrate integer, spo2 integer)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
BEGIN
    INSERT INTO public."HealthCheckHistory" ("UserId","CoughPresent" ,"FeverPresent" ,
   "BreathingDifficultyPresent" ,"ProgressStatus" ,"TemperatureCelsius" ,
  "HeartRatePerMin" ,"RespRatePerMin" ,"SpO2Percent" ) VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9);
 return 'SUCCESS';
END
$function$
;

ALTER TABLE "public"."Address" ADD CONSTRAINT "Address_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."Allergy" ADD CONSTRAINT "Allergy_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."AppHeartbeatHistory" ADD CONSTRAINT "AppHeartbeatHistory_DeviceId_fkey" FOREIGN KEY ( "DeviceId" ) REFERENCES "public"."PatientDeviceApp"( "DeviceSID" );

ALTER TABLE "public"."AppHeartbeatHistory" ADD CONSTRAINT "AppHeartbeatHistory_UserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."EmailAddress" ADD CONSTRAINT "EmailAddress_PrimaryUserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."EmailAddress" ADD CONSTRAINT "EmailAddress_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."ExternalIdentifier" ADD CONSTRAINT "ExternalIdentifier_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."GeofenceLocation" ADD CONSTRAINT "GeofenceLocation_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "public"."Patient"( "PatientId" );

ALTER TABLE "public"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_LocationID_fkey" FOREIGN KEY ( "LocationID" ) REFERENCES "public"."LocationHierarchy"( "LocationId" );

ALTER TABLE "public"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_DeviceID_fkey" FOREIGN KEY ( "DeviceID" ) REFERENCES "public"."PatientDeviceApp"( "DeviceSID" );

ALTER TABLE "public"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_EnteredByUserID_fkey" FOREIGN KEY ( "EnteredByUserID" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."HealthProfessional" ADD CONSTRAINT "HealthPro_SupervisorId_fkey" FOREIGN KEY ( "SupervisorId" ) REFERENCES "public"."HealthProfessional"( "HealthProfessionalId" );

ALTER TABLE "public"."HealthProfessional" ADD CONSTRAINT "HealthPro_WorkLocationId_fkey" FOREIGN KEY ( "WorkLocationId" ) REFERENCES "public"."LocationHierarchy"( "LocationId" );

ALTER TABLE "public"."HealthProfessional" ADD CONSTRAINT "HealthPro_HealthProfessionalId_fkey" FOREIGN KEY ( "HealthProfessionalId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."LocationHierarchy" ADD CONSTRAINT "Location_ParentLocationId_fkey" FOREIGN KEY ( "ParentLocationId" ) REFERENCES "public"."LocationHierarchy"( "LocationId" );

ALTER TABLE "public"."LocationHistory" ADD CONSTRAINT "LocationHistory_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."Medication" ADD CONSTRAINT "Medication_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."Patient" ADD CONSTRAINT "Patient_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."PatientDeviceApp" ADD CONSTRAINT "PatientDeviceApp_PrimaryUserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."PatientProviderRelationship" ADD CONSTRAINT "PatientProviderRelationship_ProviderId_fkey" FOREIGN KEY ( "ProviderId" ) REFERENCES "public"."HealthProfessional"( "HealthProfessionalId" );

ALTER TABLE "public"."PatientProviderRelationship" ADD CONSTRAINT "PatientProviderRelationship_RelationshipFacilityLocation_fkey" FOREIGN KEY ( "RelationshipFacilityLocation" ) REFERENCES "public"."LocationHierarchy"( "LocationId" );

ALTER TABLE "public"."PatientProviderRelationship" ADD CONSTRAINT "PatientProviderRelationship_PatientID_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "public"."Patient"( "PatientId" );

ALTER TABLE "public"."PatientStatus" ADD CONSTRAINT "PatientStatus_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "public"."Patient"( "PatientId" );

ALTER TABLE "public"."PhoneNumber" ADD CONSTRAINT "PhoneNumber_PrimaryUserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."PhoneNumber" ADD CONSTRAINT "PhoneNumber_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."PreExistingCondition" ADD CONSTRAINT "PreExistingCondition_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."PreExistingConditionsCovidDenorm" ADD CONSTRAINT "PreExistingConditionsCovidDenorm_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."User" ADD CONSTRAINT "User_ProfilePhotoId_fkey" FOREIGN KEY ( "ProfilePhotoId" ) REFERENCES "public"."UserPhotos"( "PhotoId" );

ALTER TABLE "public"."UserRequestHistory" ADD CONSTRAINT "UserRequestHistory_ResponseUserId_fkey" FOREIGN KEY ( "ResponseUserId" ) REFERENCES "public"."User"( "UserId" );

ALTER TABLE "public"."UserRequestHistory" ADD CONSTRAINT "UserRequestHistory_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "public"."User"( "UserId" );

