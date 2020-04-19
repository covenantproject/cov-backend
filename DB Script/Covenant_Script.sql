--UserPhotos
--CREATE TYPE PhotoType AS ENUM ('AppProfile','Selfie');
CREATE TABLE public."UserPhotos"
(
    "PhotoId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "PhotoType" character varying(15) DEFAULT 'AppProfile',
	"PhotoPath" character varying(150) COLLATE pg_catalog."default",
	"FileSavedDateTime" timestamp without time zone default (now() at time zone 'utc'),
    CONSTRAINT "UserPhotos_pkey" PRIMARY KEY ("PhotoId")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--User
CREATE TABLE public."User"
(
    "UserId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Title" character varying(10) COLLATE pg_catalog."default",
	"FirstName" character varying(32) COLLATE pg_catalog."default",
	"MiddleName" character varying(32) COLLATE pg_catalog."default",
	"LastName" character varying(32) COLLATE pg_catalog."default",
	"PreferredName" character varying(32) COLLATE pg_catalog."default",
	"ShortName" character varying(16) COLLATE pg_catalog."default",
	"Suffix" character varying(10) COLLATE pg_catalog."default",
    "DateOfBirth" timestamp without time zone,
    "Gender" character varying(10) COLLATE pg_catalog."default",
    "ProfilePhotoId" integer,
	"OTPCode" character varying COLLATE pg_catalog."default",
    CONSTRAINT "User_pkey" PRIMARY KEY ("UserId"),
	CONSTRAINT "User_ProfilePhotoId_fkey" FOREIGN KEY ("ProfilePhotoId")
        REFERENCES public."UserPhotos" ("PhotoId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--PatientGroup/HouseHold
--CREATE TABLE public."HouseHold"
--(
--    "HouseHoldId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
--    "IsPhonePrimaryUser" boolean DEFAULT FALSE,
--	"PhonePrimaryUserId" integer DEFAULT NULL,
--    CONSTRAINT "HouseHold_pkey" PRIMARY KEY ("HouseHoldId"),
--	CONSTRAINT "HouseHold_PhonePrimaryUserId_fkey" FOREIGN KEY ("PhonePrimaryUserId")
--        REFERENCES public."User" ("UserId") MATCH SIMPLE
--        ON UPDATE NO ACTION
--       ON DELETE NO ACTION
--)
--WITH (
--    OIDS = FALSE
--)
--TABLESPACE pg_default;

--LocationHierarchy
CREATE TABLE public."LocationHierarchy"
(
    "LocationId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "LocationName" character varying COLLATE pg_catalog."default",
	"LocationAbbreviation" character varying COLLATE pg_catalog."default",
	"AssignPatients" boolean DEFAULT false,
	"ParentLocationId" integer DEFAULT NULL,
	"CountryCode" character varying COLLATE pg_catalog."default",
    CONSTRAINT "Location_pkey" PRIMARY KEY ("LocationId"),
	CONSTRAINT "Location_ParentLocationId_fkey" FOREIGN KEY ("ParentLocationId")
        REFERENCES public."LocationHierarchy" ("LocationId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--HealthProfessional
CREATE TABLE public."HealthProfessional"
(
    "HealthProfessionalId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"SupervisorId" integer,
	"HealthProfessionalJobTitle" character varying(15) COLLATE pg_catalog."default",
	"AssignedLocationID" integer,
	"IsActive" boolean DEFAULT true,
    CONSTRAINT "HealthProfessional_pkey" PRIMARY KEY ("HealthProfessionalId"),
	CONSTRAINT "HealthProfessional_SupervisorId_fkey" FOREIGN KEY ("SupervisorId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "HealthProfessional_AssignedLocationID_fkey" FOREIGN KEY ("AssignedLocationID")
        REFERENCES public."LocationHierarchy" ("LocationId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--Patient
CREATE TABLE public."Patient"
(
    "PatientId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"Nationality" boolean,
	"EmergencyContact1" character varying(20) COLLATE pg_catalog."default",
	"EContact1RelToPt" character varying(10) COLLATE pg_catalog."default",
	"EmergencyContact2" character varying(20) COLLATE pg_catalog."default",
	"EContact2RelToPt" character varying(10) COLLATE pg_catalog."default",
	"NextOfKin1" boolean,
	"NofKin1RelToPt" character varying(10) COLLATE pg_catalog."default",
	"NextofKin2" boolean,
	"NofKin2RelToPt" character varying(10) COLLATE pg_catalog."default",
	"HasPreExistingConditions" boolean,
	"HasMedications" boolean,
	"HasAllergies" boolean,
	"HasAdvanceDirectives" boolean,
	"NeedsCarer" boolean,
	"HasInternationalTravel" boolean,
	"HasInterstateTravel" boolean,
	"HasHighRiskFacilityVisit" boolean,
	"IsHighRiskHealthWorker" boolean,
	"ClinicalTrialStatus" character varying(10) COLLATE pg_catalog."default",
	"Comments" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "Patient_pkey" PRIMARY KEY ("PatientId"),
	CONSTRAINT "Patient_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--PatientProviderRelationship
CREATE TABLE public."PatientProviderRelationship"
(
    "PatProRelationshipId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"PatientId" integer,
	"ProviderId" integer,
	"RelationshipType" character varying(15) COLLATE pg_catalog."default",
	"RelationshipStartDate" timestamp without time zone,
	"RelationshipEndDate" timestamp without time zone,
	"RelationshipFacilityLocation" integer,
    CONSTRAINT "PatientProviderRelationship_pkey" PRIMARY KEY ("PatProRelationshipId"),
	CONSTRAINT "PatientProviderRelationship_PatientID_fkey" FOREIGN KEY ("PatientId")
        REFERENCES public."Patient" ("PatientId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "PatientProviderRelationship_ProviderId_fkey" FOREIGN KEY ("ProviderId")
        REFERENCES public."HealthProfessional" ("HealthProfessionalId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "PatientProviderRelationship_RelationshipFacilityLocation_fkey" FOREIGN KEY ("RelationshipFacilityLocation")
        REFERENCES public."LocationHierarchy" ("LocationId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--CovidContact
CREATE TABLE public."CovidContact"
(
    "ContactId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "ContactUserID1" character varying(10) COLLATE pg_catalog."default",
	"ContactUserID2" character varying(10) COLLATE pg_catalog."default",
	"ContactTimeStart" character varying(10) COLLATE pg_catalog."default",
	"ContactTimeEnd" character varying(10) COLLATE pg_catalog."default",
	"ContactLocation" character varying(10) COLLATE pg_catalog."default",
	"ContactRelationship" character varying(10) COLLATE pg_catalog."default",
	"ContactExposure" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "CovidContact_pkey" PRIMARY KEY ("ContactId")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--EmailAddress
CREATE TABLE public."EmailAddress"
(
    "EmailAddressId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "EmailAddress" character varying(25) COLLATE pg_catalog."default",
	"PersonalOrWork" character varying(10) COLLATE pg_catalog."default",
	"IsPreferred" boolean,
	"IsPrimaryUser" boolean,
	"PrimaryUserId" integer DEFAULT NULL,
    CONSTRAINT "EmailAddress_pkey" PRIMARY KEY ("EmailAddressId"),
	CONSTRAINT "EmailAddress_PrimaryUserId_fkey" FOREIGN KEY ("PrimaryUserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "EmailAddress_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--PhoneNumber
CREATE TABLE public."PhoneNumber"
(
    "PhoneNumberId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "PhoneType" character varying(10) COLLATE pg_catalog."default",
	"PhoneNumber" character varying(20) COLLATE pg_catalog."default",
	"PersonalOrWork" character varying(10) COLLATE pg_catalog."default",
	"IsPreferred" boolean,
	"IsPrimaryUser" boolean,
	"PrimaryUserId" integer DEFAULT NULL,
	"HasInternetAccess" boolean,
	"HasSMSAccess" boolean,
	"HasWhatsAppAccess" boolean,
	"HasTelegramAccess" boolean,	
    CONSTRAINT "PhoneNumber_pkey" PRIMARY KEY ("PhoneNumberId"),
	CONSTRAINT "PhoneNumber_PrimaryUserId_fkey" FOREIGN KEY ("PrimaryUserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "PhoneNumber_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--Address
CREATE TABLE public."Address"
(
    "AddressId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "AddressType" character varying(10) COLLATE pg_catalog."default",
	"CompanyName" character varying(10) COLLATE pg_catalog."default",
	"InCareOf" character varying(10) COLLATE pg_catalog."default",
	"AddressLine1" character varying(10) COLLATE pg_catalog."default",
	"AddressLine2" character varying(10) COLLATE pg_catalog."default",
	"AddressLine3" character varying(10) COLLATE pg_catalog."default",
	"City" character varying(10) COLLATE pg_catalog."default",
	"DistrictCounty" character varying(10) COLLATE pg_catalog."default",
	"State" character varying(10) COLLATE pg_catalog."default",
	"PostCode" character varying(10) COLLATE pg_catalog."default",
	"Country" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "Address_pkey" PRIMARY KEY ("AddressId"),
	CONSTRAINT "Address_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--External Identifier
CREATE TABLE public."ExternalIdentifier"
(
    "IdentificationId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "IDType" character varying(10) COLLATE pg_catalog."default",
	"IDTypeURI" character varying(10) COLLATE pg_catalog."default",
	"IssuingAuthorityName" character varying(10) COLLATE pg_catalog."default",
	"IssuingAuthorityID" character varying(10) COLLATE pg_catalog."default",
	"IssuingAuthorityURI" character varying(10) COLLATE pg_catalog."default",
	"IDNumber" character varying(20) COLLATE pg_catalog."default",
	"IssueDate" character varying(10) COLLATE pg_catalog."default",
	"ExpirationDate" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "ExternalIdentifier_pkey" PRIMARY KEY ("IdentificationId"),
	CONSTRAINT "ExternalIdentifier_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--PreExistingCondition
CREATE TABLE public."PreExistingCondition"
(
    "PreExistingConditionId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "PreExistingCondtionSCT" character varying(10) COLLATE pg_catalog."default",
	"Active" character varying(10) COLLATE pg_catalog."default",
	"Controlled" character varying(10) COLLATE pg_catalog."default",
	"Duration" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "PreExistingCondition_pkey" PRIMARY KEY ("PreExistingConditionId"),
	CONSTRAINT "PreExistingCondition_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--Allergy
CREATE TABLE public."Allergy"
(
    "AllergyId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
    "AllergenType" character varying(10) COLLATE pg_catalog."default",
	"AllergenSCT" character varying(10) COLLATE pg_catalog."default",
	"AllergicReactionSCT" character varying(10) COLLATE pg_catalog."default",
	"AllergySeverity" character varying(10) COLLATE pg_catalog."default",
	"Current" character varying(10) COLLATE pg_catalog."default",
	"Duration" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "Allergy_pkey" PRIMARY KEY ("AllergyId"),
	CONSTRAINT "Allergy_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--PreExistingConditionsCovidDenorm
CREATE TABLE public."PreExistingConditionsCovidDenorm"
(
    "CovidPreExistingConditionId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"COPD" character varying(10) COLLATE pg_catalog."default",
	"Bronchitis" character varying(10) COLLATE pg_catalog."default",
	"DiabetesMellitus" character varying(10) COLLATE pg_catalog."default",
	"Hypertension" character varying(10) COLLATE pg_catalog."default",
	"ChronicRenalDisease" character varying(10) COLLATE pg_catalog."default",
	"Malignancy" character varying(10) COLLATE pg_catalog."default",
	"HeartDisease" character varying(10) COLLATE pg_catalog."default",
	"Asthma" character varying(10) COLLATE pg_catalog."default",
	"Other" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "PreExistingConditionsCovidDenorm_pkey" PRIMARY KEY ("CovidPreExistingConditionId"),
	CONSTRAINT "PreExistingConditionsCovidDenorm_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--Medication
CREATE TABLE public."Medication"
(
    "MedicationId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"IngredientRxCUI" character varying(10) COLLATE pg_catalog."default",
	"BrandedName" character varying(10) COLLATE pg_catalog."default",
	"IngredientName" character varying(10) COLLATE pg_catalog."default",
	"IsCurrent" character varying(10) COLLATE pg_catalog."default",
	"Duration" character varying(10) COLLATE pg_catalog."default",
	"Strength" character varying(10) COLLATE pg_catalog."default",
	"Dose" character varying(10) COLLATE pg_catalog."default",
	"Frequency" character varying(10) COLLATE pg_catalog."default",
	"Route" character varying(10) COLLATE pg_catalog."default",
	"Indication" character varying(10) COLLATE pg_catalog."default",
	"Intent" character varying(10) COLLATE pg_catalog."default",
	"Comments" character varying COLLATE pg_catalog."default",
    CONSTRAINT "Medication_pkey" PRIMARY KEY ("MedicationId"),
	CONSTRAINT "Medication_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--CREATE TYPE COVIDStatusType AS ENUM ('Susceptible', 'Exposed', 'Infected', 'Recovered', 'Deceased');
--CREATE TYPE PatientType AS ENUM ('Medical quarantine', 'Self quarantine', 'Staying at home', 'Home isolation', 'Hospitalized', 'Not applicable');
--CREATE TYPE QuarantineStatus AS ENUM ('Not quarantined', 'Quarantine started', 'Quarantine ended', 'On leave');
--CREATE TYPE IsolationStatus AS ENUM ('Not isolated', 'Isolation started', 'Isolation ended');
--PatientStatus
CREATE TABLE public."PatientStatus"
(
    "PatientStatusId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"PatientId" integer,
	"COVID19Status" character varying DEFAULT 'Susceptible',
	"PatientType" character varying DEFAULT 'Not applicable',
	"Latitude" float,
	"Longitude" float,
	"GeofenceStatus" character varying COLLATE pg_catalog."default",
	"QuarantineStatus" character varying COLLATE pg_catalog."default",
	"IsolationStatus" character varying COLLATE pg_catalog."default",
	"QuarantineStartDateTime" timestamp without time zone,
	"QuarantineEndDateTime" timestamp without time zone,
	"IsolationStartDateTime" timestamp without time zone,
	"IsolationEndDateTime" timestamp without time zone,
	"QuarantineRequestStatus" character varying(10) COLLATE pg_catalog."default",
	"MedicalRequestStatus" character varying(10) COLLATE pg_catalog."default",
	"SuppliesRequestStatus" character varying(10) COLLATE pg_catalog."default",
	"HeartbeatStatus" character varying COLLATE pg_catalog."default",
	"HealthStatusAlert" character varying COLLATE pg_catalog."default",
    CONSTRAINT "PatientStatus_pkey" PRIMARY KEY ("PatientStatusId"),
	CONSTRAINT "PatientStatus_PatientId_fkey" FOREIGN KEY ("PatientId")
        REFERENCES public."Patient" ("PatientId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--LocationHistory
CREATE TABLE public."LocationHistory"
(
    "LocationHistoryId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"Latitude" float,
	"Longitude" float,
	"Code" character varying(50) COLLATE pg_catalog."default",
	"LocationDateTime" timestamp without time zone default (now() at time zone 'utc'),
    CONSTRAINT "LocationHistory_pkey" PRIMARY KEY ("LocationHistoryId"),
	CONSTRAINT "LocationHistory_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--CREATE TYPE RequestType AS ENUM ('Quarantine', 'Medical', 'Supplies');
--CREATE TYPE RequestStatusType AS ENUM ('Open', 'In Progress', 'Closed');
--CREATE TYPE ResponseType AS ENUM ('Phone', 'In Person');
--UserRequestHistory
CREATE TABLE public."UserRequestHistory"
(
    "UserRequestHistoryId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"RequestType" character varying DEFAULT 'Supplies',
	"RequestDateTime" timestamp without time zone default (now() at time zone 'utc'),
	"RequestStatus" character varying DEFAULT 'Open',
	"RequestComments" character varying COLLATE pg_catalog."default",
	"ResponseType" character varying DEFAULT 'Phone',
	"ResponseUserId" integer,
	"ResponseDateTime" timestamp without time zone,
	"ResponseComments" character varying COLLATE pg_catalog."default",
    CONSTRAINT "UserRequestHistory_pkey" PRIMARY KEY ("UserRequestHistoryId"),
	CONSTRAINT "UserRequestHistory_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "UserRequestHistory_ResponseUserId_fkey" FOREIGN KEY ("ResponseUserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--PatientDeviceApp
CREATE TABLE public."PatientDeviceApp"
(
    "DeviceSID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "PrimaryUserId" integer DEFAULT NULL,
	"DeviceIMEI" character varying COLLATE pg_catalog."default",
	"DeviceMacID" character varying COLLATE pg_catalog."default",
    "DeviceOS" character varying COLLATE pg_catalog."default",
	"DeviceOSVersion" character varying COLLATE pg_catalog."default",
	"DeviceManufacturer" character varying COLLATE pg_catalog."default",
	"DeviceModel" character varying COLLATE pg_catalog."default",
	"DevicePhoneNumber" character varying COLLATE pg_catalog."default",
	"DevicePhoneServiceProvider" character varying COLLATE pg_catalog."default",
	"AppVersion" character varying COLLATE pg_catalog."default",
	"AppInstalledDateTime" timestamp without time zone default (now() at time zone 'utc'),
    CONSTRAINT "PatientDeviceApp_pkey" PRIMARY KEY ("DeviceSID"),
	CONSTRAINT "PatientDeviceApp_PrimaryUserId_fkey" FOREIGN KEY ("PrimaryUserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--CREATE TYPE ProgressType AS ENUM ('Worsening', 'Improving', 'Stay the same');
--HealthCheckHistory
CREATE TABLE public."HealthCheckHistory"
(
    "HealthHistoryId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	"UserId" integer,
	"EnteredByUserID" integer,
	"DeviceID" integer,
	"LocationID" integer,
	"HealthDateTime" timestamp without time zone default (now() at time zone 'utc'),
	"HealthCheckReason" character varying COLLATE pg_catalog."default",
	"HealthCheckMethod" character varying COLLATE pg_catalog."default",
	"CoughPresent" boolean DEFAULT false,
	"FeverPresent" boolean DEFAULT false,
	"BreathingDifficultyPresent" boolean DEFAULT false,
	"ProgressStatus" character varying DEFAULT 'Stay the same',
	"TemperatureCelsius" float,
	"HeartRatePerMin" integer,
	"RespRatePerMin" integer,
	"SpO2Percent" integer,
	"SystolicBPMMHg" integer,
	"DiastolicBPMMHg" integer,
	"Comments" character varying COLLATE pg_catalog."default",
    CONSTRAINT "HealthHistory_pkey" PRIMARY KEY ("HealthHistoryId"),
	CONSTRAINT "HealthHistory_UserId_fkey" FOREIGN KEY ("UserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "HealthHistory_EnteredByUserID_fkey" FOREIGN KEY ("EnteredByUserID")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "HealthHistory_DeviceID_fkey" FOREIGN KEY ("DeviceID")
        REFERENCES public."PatientDeviceApp" ("DeviceSID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "HealthHistory_LocationID_fkey" FOREIGN KEY ("LocationID")
        REFERENCES public."LocationHierarchy" ("LocationId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--GeofenceLocation
CREATE TABLE public."GeofenceLocation"
(
    "GeofenceLocationId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "PatientId" integer,
    "GeoFenceLatitude" float,
    "GeoFenceLongitude" float,
	"GeoFenceRadiusMetres" float,
	"GeoFenceStartDate" timestamp without time zone,
	"GeoFenceEndDate" timestamp without time zone,
    CONSTRAINT "GeofenceLocation_pkey" PRIMARY KEY ("GeofenceLocationId"),
	CONSTRAINT "GeofenceLocation_PatientId_fkey" FOREIGN KEY ("PatientId")
        REFERENCES public."Patient" ("PatientId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


--AppHeartbeatHistory
CREATE TABLE public."AppHeartbeatHistory"
(
    "AppHeartbeatHistoryId" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "PrimaryUserId" integer,
	"DeviceId" integer,
    "HeartbeatDateTime" timestamp without time zone default (now() at time zone 'utc'),
	"HeartBeatStatus" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "AppHeartbeatHistory_pkey" PRIMARY KEY ("AppHeartbeatHistoryId"),
	CONSTRAINT "AppHeartbeatHistory_UserId_fkey" FOREIGN KEY ("PrimaryUserId")
        REFERENCES public."User" ("UserId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "AppHeartbeatHistory_DeviceId_fkey" FOREIGN KEY ("DeviceId")
        REFERENCES public."PatientDeviceApp" ("DeviceSID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;