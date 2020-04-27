-- CREATE SCRIPTS FOR RELEASE1 SCHEMA

CREATE SCHEMA "release1";

CREATE  TABLE "release1"."AppHeartbeat" ( 
	"AppHeartbeatId"     integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"DeviceAppId"        integer  NOT NULL ,
	"HeartbeatDateTime"  timestamp DEFAULT timezone('utc'::text, now())  ,
	"HeartBeatIp4Address" varchar(16)   ,
	"HeartBeatIp6Address" varchar(40)   ,
	"HeartbeatStatus"    varchar(10)   ,
	CONSTRAINT "AppHeartbeatHistory_pkey" PRIMARY KEY ( "AppHeartbeatId" )
 );

ALTER TABLE "release1"."AppHeartbeat" ADD CONSTRAINT "AppHeartbeat_HeartbeatStatus_check" CHECK (  ((("HeartbeatStatus")::text = ANY ((ARRAY['Online'::character varying, 'Offline'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."AppHeartbeat" IS 'App heart beat (whether the app/device is online or offline) - captured automatically when the app reports its periodic location or the user submits health status through the app. Heart beat will not be captured if the device is offline (turned off, airplane mode or does not have internet access).';

COMMENT ON COLUMN "release1"."AppHeartbeat"."DeviceAppId" IS 'Foreign key to DeviceAppId of this device.';

COMMENT ON COLUMN "release1"."AppHeartbeat"."HeartbeatStatus" IS 'Online or Offline.';

CREATE  TABLE "release1"."CovidContact" ( 
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

CREATE  TABLE "release1"."LocationHierarchy" ( 
	"LocationId"         integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"LocationName"       varchar   ,
	"LocationAbbreviation" varchar   ,
	"LocationType"       varchar(32)   ,
	"CanAssignPatients"  bool DEFAULT false  ,
	"Latitude"           float8   ,
	"Longitude"          float8   ,
	"ParentLocationId"   integer   ,
	"CountryCode"        varchar   ,
	CONSTRAINT "Location_pkey" PRIMARY KEY ( "LocationId" )
 );

ALTER TABLE "release1"."LocationHierarchy" ADD CONSTRAINT "LocationHierarchy_LocationType_check" CHECK (  ((("LocationType")::text = ANY ((ARRAY['Country'::character varying, 'State'::character varying, 'Territory'::character varying, 'Province'::character varying, 'County'::character varying, 'District'::character varying, 'Taluk'::character varying, 'City'::character varying, 'Town'::character varying, 'Village'::character varying, 'Panchayat'::character varying, 'HealthAdminOffice'::character varying, 'HealthCareFacility'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."LocationHierarchy" IS 'This table contains a hierarchy of all locations in a given country where this system is used. The location type can be country, state/province, county/region, city/town/village, health department (based on their jurisdiction), hospital or laboratory. Locations to which patients can be assigned will have their ''CanAssignPatients'' flag set to true.';

COMMENT ON COLUMN "release1"."LocationHierarchy"."LocationType" IS 'The location type can be country, state/province, county/region, city/town/village, health department (based on their jurisdiction), hospital or laboratory. Constrained by a CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."LocationHierarchy"."CanAssignPatients" IS 'Locations to which patients can be assigned will have their ''CanAssignPatients'' flag set to true.';

COMMENT ON COLUMN "release1"."LocationHierarchy"."ParentLocationId" IS 'Parent location of this location.';

COMMENT ON COLUMN "release1"."LocationHierarchy"."CountryCode" IS '2-letter country code from ISO 3166-2';

CREATE  TABLE "release1"."Users" ( 
	"UserId"             integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"Title"              varchar(10)   ,
	"FirstName"          varchar(32)   ,
	"MiddleName"         varchar(32)   ,
	"LastName"           varchar(32)   ,
	"Suffix"             varchar(10)   ,
	"Degrees"            varchar(16)   ,
	"PreferredName"      varchar(16)   ,
	"ShortName"          varchar(32)   ,
	"DateOfBirth"        timestamp   ,
	"ApproxAgeYr"        smallint   ,
	"AdminGender"        varchar(10)   ,
	"BiologicalSex"      varchar(32)   ,
	"OTPCode"            varchar   ,
	"Comments"           varchar(128)   ,
	CONSTRAINT "Users_pkey" PRIMARY KEY ( "UserId" )
 );

ALTER TABLE "release1"."Users" ADD CONSTRAINT "Users_ApproxAgeYr_check" CHECK (  (("ApproxAgeYr"< 125)) );

ALTER TABLE "release1"."Users" ADD CONSTRAINT "Users_AdminGender_check" CHECK (  ((("AdminGender")::text = ANY ((ARRAY['Male'::character varying, 'Female'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."Users" ADD CONSTRAINT "Users_BiologicalSex_check" CHECK (  ((("BiologicalSex")::text = ANY ((ARRAY['Male'::character varying, 'Female'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."Users" IS 'Contains common information about all users. The two types of users are patients (for the lack fo a better name for those under quarantine, stay at home or isolation) and health professionals - this table contains common information about both types. (Note: ProfilePhoto field has been removed in this version, and a foreign key to the UserPhoto table has been added).';

COMMENT ON COLUMN "release1"."Users"."UserId" IS 'Primary key for all users (both patients and health professionals)';

COMMENT ON COLUMN "release1"."Users"."Title" IS 'Title can be Mr, Ms, Mrs, Miss, Dr, Prof, or other regional variations.';

COMMENT ON COLUMN "release1"."Users"."FirstName" IS 'Required. First name(s) or Given name(s) of an individual. In some countries, middle name(s) may also be used in addition to First Name(s). If not known or ''no first name''.';

COMMENT ON COLUMN "release1"."Users"."MiddleName" IS 'Optional. Middle name(s) of an individual. Some countries use separate First Name(s) and Middle Name(s) - in such cases, the Middle Name(s) are saved in this field. May also store middle initial(s) instead of middle name(s) based on the individual''s preference.';

COMMENT ON COLUMN "release1"."Users"."LastName" IS 'Required. Last name(s), Surname(s) or Family name(s) of an individual.';

COMMENT ON COLUMN "release1"."Users"."Suffix" IS 'Optional. Suffix may include I, II, III, Jr, Sr, Esq, etc.';

COMMENT ON COLUMN "release1"."Users"."Degrees" IS 'Optional. It is customary to include earned or honorary degrees above the bachelors level. However, for some health care workers (such as nurses), bachelors degrees may be included. Do not use periods within a degree - e.g. use ''MD'' instead of ''M.D.'' Separate multiple degrees with commas, e.g. ''MD, PhD''';

COMMENT ON COLUMN "release1"."Users"."PreferredName" IS 'Optional. This may just be the first name, or ''Dr. Last Name'' or an individual, that will be shown on the user interface.';

COMMENT ON COLUMN "release1"."Users"."ShortName" IS 'Optional. This is the preferred name (combination of first name, optional middle intial and last name.';

COMMENT ON COLUMN "release1"."Users"."DateOfBirth" IS 'Date of birth in YYYY-MM-DD format. If date of birth of an individual is not known, leave it blank and fill the ApproximateAge field instead.';

COMMENT ON COLUMN "release1"."Users"."ApproxAgeYr" IS 'Approximate Age in Years. Used when date of birth is not known.';

COMMENT ON COLUMN "release1"."Users"."AdminGender" IS 'Required. Administrative Gender - this is how a patient identifies themselves as in social contexts. Supported values are Male, Female and Third Gender. Third Gender may be called ''Other'' (e.g. in HL7) or ''X'' (IATS passport covention) in some contexts.';

COMMENT ON COLUMN "release1"."Users"."BiologicalSex" IS 'Optional. The medical or biological sex of an individual, which is useful in a medical context. An exhaustive list of values is not provided, but may be obtained from a clinical terminology such as SNOMED CT. Often left blank if it is male or female, corresponding to the person''s administrative gender.';

COMMENT ON COLUMN "release1"."Users"."OTPCode" IS 'One time password from the SMS (text message) or email-based two factor authentication system.';

COMMENT ON COLUMN "release1"."Users"."Comments" IS 'Any other comments about this user.';

CREATE  TABLE "release1"."Address" ( 
	"AddressId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer  NOT NULL ,
	"AddressType"        char(16)   ,
	"CompanyName"        varchar(32)   ,
	"InCareOf"           varchar(32)   ,
	"AddressLine1"       varchar(125)   ,
	"AddressLine2"       varchar(32)   ,
	"AddressLine3"       varchar(32)   ,
	"City"               varchar(32)   ,
	"DistrictCounty"     varchar(32)   ,
	"State"              varchar(32)   ,
	"PostCode"           varchar(12)   ,
	"Country"            varchar(32)   ,
	CONSTRAINT "Address_pkey" PRIMARY KEY ( "AddressId" )
 );

ALTER TABLE "release1"."Address" ADD CONSTRAINT "Address_AddressType_check" CHECK (  (("AddressType" = ANY (ARRAY['TemporaryResidence'::bpchar, 'PermanentResidence'::bpchar, 'Work'::bpchar, 'Other'::bpchar]))) );

CREATE  TABLE "release1"."Demographics" ( 
	"UserId"             integer  NOT NULL ,
	"Nationality"        varchar(32)   ,
	"ResidencyStatus"    varchar(32)   ,
	"Occupation"         varchar(32)   ,
	"EmergencyContact1Id" integer   ,
	"EContact1RelToPt"   varchar(16)   ,
	"EmergencyContact2Id" integer   ,
	"EContact2RelToPt"   varchar(16)   ,
	"NextOfKin1Id"       integer   ,
	"NofKin1RelToPt"     varchar(32)   ,
	"NextofKin2Id"       integer   ,
	"NofKin2RelToPt"     varchar(32)   ,
	CONSTRAINT "Demographics_pkey" PRIMARY KEY ( "UserId" )
 );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_ResidencyStatus_check" CHECK (  ((("ResidencyStatus")::text = ANY ((ARRAY['Citizen'::character varying, 'Nonresident Visitor'::character varying, 'Temporary Resident'::character varying, 'Permanent Resident'::character varying, 'Asylee'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_EContact1RelToPt_check" CHECK (  ((("EContact1RelToPt")::text = ANY ((ARRAY['Parent'::character varying, 'Child'::character varying, 'Step parent'::character varying, 'Step child'::character varying, 'Sibling'::character varying, 'Grand parent'::character varying, 'Grand child'::character varying, 'Spouse'::character varying, 'Partner'::character varying, 'Other relative'::character varying, 'Friend'::character varying, 'Colleague'::character varying, 'Attorney'::character varying, 'Medical PoA'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_EContact2RelToPt_check" CHECK (  ((("EContact2RelToPt")::text = ANY ((ARRAY['Parent'::character varying, 'Child'::character varying, 'Step parent'::character varying, 'Step child'::character varying, 'Sibling'::character varying, 'Grand parent'::character varying, 'Grand child'::character varying, 'Spouse'::character varying, 'Partner'::character varying, 'Other relative'::character varying, 'Friend'::character varying, 'Colleague'::character varying, 'Attorney'::character varying, 'Medical PoA'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_NofKin1RelToPt_check" CHECK (  ((("NofKin1RelToPt")::text = ANY ((ARRAY['Parent'::character varying, 'Child'::character varying, 'Step parent'::character varying, 'Step child'::character varying, 'Sibling'::character varying, 'Grand parent'::character varying, 'Grand child'::character varying, 'Spouse'::character varying, 'Partner'::character varying, 'Other relative'::character varying, 'Friend'::character varying, 'Colleague'::character varying, 'Attorney'::character varying, 'Medical PoA'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_NofKin2RelToPt_check" CHECK (  ((("NofKin2RelToPt")::text = ANY ((ARRAY['Parent'::character varying, 'Child'::character varying, 'Step parent'::character varying, 'Step child'::character varying, 'Sibling'::character varying, 'Grand parent'::character varying, 'Grand child'::character varying, 'Spouse'::character varying, 'Partner'::character varying, 'Other relative'::character varying, 'Friend'::character varying, 'Colleague'::character varying, 'Attorney'::character varying, 'Medical PoA'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."Demographics" IS 'Additional demographics about an individual. This table is usually populated for patients. It is optional for health professionals.';

CREATE  TABLE "release1"."EmailAddress" ( 
	"EmailAddressId"     integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer  NOT NULL ,
	"EmailAddress"       varchar(32)  NOT NULL ,
	"EmailAddressType"   char(16)  NOT NULL ,
	"IsPreferred"        bool   ,
	"IsPrimaryUser"      bool DEFAULT true  ,
	"PrimaryUserId"      integer   ,
	CONSTRAINT "EmailAddress_pkey" PRIMARY KEY ( "EmailAddressId" )
 );

ALTER TABLE "release1"."EmailAddress" ADD CONSTRAINT "EmailAddress_EmailAddressType_check" CHECK (  (("EmailAddressType" = ANY (ARRAY['Personal'::bpchar, 'Home'::bpchar, 'Work'::bpchar, 'Other'::bpchar]))) );

COMMENT ON TABLE "release1"."EmailAddress" IS 'Email address of the user. Optional for patients. Optional but highly recommended for health professionals to have at least one email address.';

COMMENT ON COLUMN "release1"."EmailAddress"."IsPreferred" IS 'Required. A user may have only one preferred email address (across all email types - work, personal, etc.)';

COMMENT ON COLUMN "release1"."EmailAddress"."IsPrimaryUser" IS 'Is this person the primary user of the email address? If the user is a child or elderly person and the email address belongs to another family/household member, or if this email address is that of an office, this field may be set to false.';

COMMENT ON COLUMN "release1"."EmailAddress"."PrimaryUserId" IS 'If ''IsPrimaryUser'' is false, then enter the user id of the primary user of this email address if possible.';

CREATE  TABLE "release1"."ExternalIdentifier" ( 
	"IdentifierId"       integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer  NOT NULL ,
	"IDType"             varchar(32)   ,
	"IDTypeURI"          varchar(128)   ,
	"IssuingAuthorityName" varchar(32)   ,
	"IssuingAuthorityID" varchar(128)   ,
	"IssuingAuthorityURI" varchar(128)   ,
	"IdNumber"           varchar(20)   ,
	"IssueDate"          varchar(10)   ,
	"ExpirationDate"     varchar(10)   ,
	CONSTRAINT "ExternalIdentifier_pkey" PRIMARY KEY ( "IdentifierId" )
 );

COMMENT ON TABLE "release1"."ExternalIdentifier" IS 'External identifiers such as driving license numbers, passport numbers, national identity numbers, hospital medical record numbers or other externally assigned numbers, medical license numbers or national prescriber numbers. A single individual may have multiple external identifiers.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IdentifierId" IS 'Primary key, autogenerated.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."UserId" IS 'User (patient or health professional) to which this external identifier pertains.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IDType" IS 'Driving license number, passport number, national identifier number, medical license number, medical record number or another type of external identifier - specified using a check constraint.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IDTypeURI" IS 'Currently not used.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IssuingAuthorityName" IS 'For driving license or medical license, enter the country or state acronyms. For passport or national identifier number, enter the country acronym.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IssuingAuthorityID" IS 'Currently unused.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IssuingAuthorityURI" IS 'Currently unused.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IdNumber" IS 'Actual identifier of the individual, such as the passport number, driving license number, medical license number, national identifier, medical record number, etc.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."IssueDate" IS 'Optional. Date of issue of the external identifier. May be used for documents with issue dates such as passport number or driving license number.';

COMMENT ON COLUMN "release1"."ExternalIdentifier"."ExpirationDate" IS 'Optional. Date of expiration of the external identifier. May be used for documents with expiry dates such as passport number or driving license number.';

CREATE  TABLE "release1"."HealthProfessional" ( 
	"HealthProId"        integer  NOT NULL ,
	"SupervisorId"       integer   ,
	"HealthProJobTitle"  varchar(15)   ,
	"WorkLocationId"     integer   ,
	"IsActive"           bool DEFAULT true  ,
	CONSTRAINT "HealthPro_pkey" PRIMARY KEY ( "HealthProId" )
 );

COMMENT ON TABLE "release1"."HealthProfessional" IS 'Contains basic information for all health professionals. HealthProfessional.HealthProId has the same value as User.UserId for performance reasons (to avoid another join in some cases). This table is filled only for Health Professionals. Patients will not have a record in this table unless they are a health professional working on this health project.';

CREATE  TABLE "release1"."Patient" ( 
	"PatientId"          integer  NOT NULL ,
	"HouseholdId"        integer  NOT NULL ,
	"HasPreExistingConditions" bool   ,
	"HasMedications"     bool   ,
	"HasAllergies"       bool   ,
	"HasAdvanceDirectives" bool   ,
	"NeedsCarer"         bool   ,
	"HasInternationalTravel" bool   ,
	"HasInterstateTravel" bool   ,
	"HasHighRiskFacilityVisit" bool   ,
	"IsHighRiskHealthWorker" bool   ,
	"BloodGroup"         varchar(16)   ,
	"ClinicalTrialStatus" varchar(16)   ,
	"Comments"           varchar(128)   ,
	CONSTRAINT "Patient_pkey" PRIMARY KEY ( "PatientId" )
 );

COMMENT ON TABLE "release1"."Patient" IS 'Contains basic information for all patients. Patient.PatientID has the same value as User.UserId for performance reasons (to avoid another join in some cases). This table is filled only for patients. Health Professionals will not have a record in this table unless they are under quarantine themselves.';

COMMENT ON COLUMN "release1"."Patient"."PatientId" IS '*** In the previous version, PatientId was an autogenerated primary key and UserId was a foreign key to User.UserId. In this version, UserId column is deleted from this table, and PatientId is a foreign key to Users.UserId';

COMMENT ON COLUMN "release1"."Patient"."HouseholdId" IS 'Unique id for the household. This is useful for tracing immediate contacts of a person under investigation.';

CREATE  TABLE "release1"."PatientGeofencedLocation" ( 
	"GeofencedLocationId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"GeofencedAddressId" integer   ,
	"GeoFencedLatitude"  float8   ,
	"GeoFencedLongitude" float8   ,
	"GeoFencedRadiusMetres" float8   ,
	CONSTRAINT "GeofencedLocation_pkey" PRIMARY KEY ( "GeofencedLocationId" )
 );

COMMENT ON TABLE "release1"."PatientGeofencedLocation" IS 'The location where the patient is supposed to stay during their quarantine/isolation. This is first captured when the patient presses ''Update Location'' for the first time during their quarantine/isolation. Business rules need to be defined by health officials whether this can be changed.';

COMMENT ON COLUMN "release1"."PatientGeofencedLocation"."PatientId" IS 'PatientId is typically the primary user of the mobile device. We need to define how the geofence location of additional users (e.g. children or elderly) will be captured.';

COMMENT ON COLUMN "release1"."PatientGeofencedLocation"."GeofencedAddressId" IS 'Foreign key to the street address of this location.';

COMMENT ON COLUMN "release1"."PatientGeofencedLocation"."GeoFencedRadiusMetres" IS 'Default is 15 metres (50 feet)';

CREATE  TABLE "release1"."PatientRequestHistory" ( 
	"PatientRequestHistoryId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"RequestType"        varchar(16)   ,
	"RequestDateTime"    timestamp DEFAULT timezone('utc'::text, now())  ,
	"RequestStatus"      varchar DEFAULT 'Open'::character varying  ,
	"RequestComments"    varchar(255)   ,
	"ResponseType"       varchar(16)   ,
	"ResponseUserId"     integer   ,
	"ResponseDateTime"   timestamp   ,
	"ResponseComments"   varchar(255)   ,
	CONSTRAINT "PatientRequestHistory_pkey" PRIMARY KEY ( "PatientRequestHistoryId" )
 );

ALTER TABLE "release1"."PatientRequestHistory" ADD CONSTRAINT "PatientRequestHistory_RequestType_check" CHECK (  ((("RequestType")::text = ANY ((ARRAY['Quarantine'::character varying, 'Medical'::character varying, 'Supplies'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientRequestHistory" ADD CONSTRAINT "PatientRequestHistory_RequestStatus_check" CHECK (  ((("RequestStatus")::text = ANY ((ARRAY['Open'::character varying, 'In Progress'::character varying, 'Closed'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientRequestHistory" ADD CONSTRAINT "PatientRequestHistory_ResponseType_check" CHECK (  ((("ResponseType")::text = ANY ((ARRAY['Phone'::character varying, 'Video'::character varying, 'In Person'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."PatientRequestHistory" IS 'A patient''s requets regarding their quarantine/isolation, medical questions/concerns, or requests for emergency supplies (food, water, medicines). Each of these three types of requets may be addressed by same or different health professionals who support their local health departments.';

CREATE  TABLE "release1"."PatientStatus" ( 
	"PatientStatusId"    integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"COVID19Status"      varchar(16) DEFAULT 'Susceptible'::character varying  ,
	"HealthStatus"       varchar(16)   ,
	"QuarIsltStatus"     varchar(16)   ,
	"QuarIsltStartDateTime" timestamp   ,
	"QuarIsltEndDateTime" timestamp   ,
	"QuarIsltRequestStatus" varchar(16)   ,
	"MedicalRequestStatus" varchar(16)   ,
	"SuppliesRequestStatus" varchar(16)   ,
	"GeofenceStatus"     varchar(16)   ,
	"AppHeartbeatStatus" varchar(16)   ,
	"UpdatedDateTime"    timestamp DEFAULT timezone('utc'::text, now())  ,
	"Latitude"           float8   ,
	"Longitude"          float8   ,
	"Comments"           varchar(128)   ,
	CONSTRAINT "PatientStatus_pkey" PRIMARY KEY ( "PatientStatusId" )
 );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_QuarIsltStatus_check" CHECK (  ((("QuarIsltStatus")::text = ANY ((ARRAY['None'::character varying, 'Medical Quarantine'::character varying, 'Self quarantine'::character varying, 'Stay at home'::character varying, 'Quarantine ended'::character varying, 'Temporary leave from quarantine'::character varying, 'Isolated'::character varying, 'Isolation ended'::character varying, 'Hospitalized'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_QuarIsltRequestStatus_check" CHECK (  ((("QuarIsltRequestStatus")::text = ANY ((ARRAY['None'::character varying, 'Open'::character varying, 'In Progress'::character varying, 'Completed'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_MedicalRequestStatus_check" CHECK (  ((("MedicalRequestStatus")::text = ANY ((ARRAY['None'::character varying, 'Open'::character varying, 'In Progress'::character varying, 'Completed'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_SuppliesRequestStatus_check" CHECK (  ((("SuppliesRequestStatus")::text = ANY ((ARRAY['None'::character varying, 'Open'::character varying, 'In Progress'::character varying, 'Completed'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_COVID19Status_check" CHECK (  ((("COVID19Status")::text = ANY ((ARRAY['Susceptible'::character varying, 'Exposed'::character varying, 'Infected'::character varying, 'Recovered'::character varying, 'Deceased'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_HealthStatus_check" CHECK (  ((("HealthStatus")::text = ANY ((ARRAY['Asymptomatic'::character varying, 'Symptomatic'::character varying, 'Severe'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_GeofenceStatus_check" CHECK (  ((("GeofenceStatus")::text = ANY ((ARRAY['Inside'::character varying, 'Outside - near'::character varying, 'Outside - far'::character varying, 'Unknown'::character varying])::text[]))) );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_AppHeartbeatStatus_check" CHECK (  ((("AppHeartbeatStatus")::text = ANY ((ARRAY['Online'::character varying, 'Offline'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."PatientStatus" IS 'Current status of the patient. It creates a snapshot based on data from multiple other tables.';

COMMENT ON COLUMN "release1"."PatientStatus"."QuarIsltStatus" IS '*** In the previous version, QuarantineStatus and IsolationStatus were separate fields. Now, they are merged into a single field with a superset of values since a person may be under quarantine (when disease is not confirmed) or isolation (when disease is confirmed) at a given time, but not both at the same time.';

COMMENT ON COLUMN "release1"."PatientStatus"."QuarIsltStartDateTime" IS '*** In the previous version, QuarantineStartDate and IsolationStartDate were separate fields. Now, they are merged into a single field since quarantine and isolation are mutually exclusive.';

COMMENT ON COLUMN "release1"."PatientStatus"."QuarIsltEndDateTime" IS '*** In the previous version, QuarantineEndDate and IsolationEndDate were separate fields. Now, they are merged into a single field since quarantine and isolation are mutually exclusive.';

COMMENT ON COLUMN "release1"."PatientStatus"."QuarIsltRequestStatus" IS '*** Formerly ''Quarantine Request Status''. Did this patient submit a request to their quarantine officer (typically, through the mobile app)?';

COMMENT ON COLUMN "release1"."PatientStatus"."MedicalRequestStatus" IS 'Did this patient submit a medical request (typically, through the mobile app)?';

COMMENT ON COLUMN "release1"."PatientStatus"."SuppliesRequestStatus" IS 'Did this patient submit a request for emergency food, water or medical supplies (typically, through the mobile app)?';

COMMENT ON COLUMN "release1"."PatientStatus"."GeofenceStatus" IS 'Is this patient compliant (i.e. within) their geofence during the last check?';

COMMENT ON COLUMN "release1"."PatientStatus"."AppHeartbeatStatus" IS 'Is the patient''s cellphone app online or offline during the last check?';

COMMENT ON COLUMN "release1"."PatientStatus"."UpdatedDateTime" IS 'When was this status row last updated?';

COMMENT ON COLUMN "release1"."PatientStatus"."Latitude" IS 'Latest known location of the patient''s mobile device.';

COMMENT ON COLUMN "release1"."PatientStatus"."Longitude" IS 'Latest known location of the patient''s mobile device.';

CREATE  TABLE "release1"."PhoneNumber" ( 
	"PhoneNumberId"      integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer  NOT NULL ,
	"PhoneType"          varchar(10)  NOT NULL ,
	"PhoneNumber"        varchar(20)   ,
	"PhoneNumberExtn"    varchar(8)   ,
	"PhoneNumberFormatted" varchar(32)   ,
	"IsPreferred"        bool   ,
	"IsPrimaryUser"      bool DEFAULT true  ,
	"PrimaryUserId"      integer   ,
	"HasInternetAccess"  bool   ,
	"HasSMSAccess"       bool   ,
	"HasWhatsAppAccess"  bool   ,
	"HasTelegramAccess"  bool   ,
	"ProvidesLocation"   bool   ,
	CONSTRAINT "PhoneNumber_pkey" PRIMARY KEY ( "PhoneNumberId" )
 );

ALTER TABLE "release1"."PhoneNumber" ADD CONSTRAINT "PhoneNumber_PhoneType_check" CHECK (  ((("PhoneType")::text = ANY ((ARRAY['Mobile'::character varying, 'Home'::character varying, 'Work'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON COLUMN "release1"."PhoneNumber"."IsPreferred" IS 'Required. A user may have only one preferred phone number (across all email types - work, personal, etc.)';

COMMENT ON COLUMN "release1"."PhoneNumber"."IsPrimaryUser" IS 'Is this person the primary user of the phone number? If the user is a child or elderly person and the phone number belongs to another family/household member, or if this phone number is that of a residence/office, this field may be set to false.';

COMMENT ON COLUMN "release1"."PhoneNumber"."PrimaryUserId" IS 'Optional. If ''IsPrimaryUser'' is false, then enter the user id of the primary user of this phone number if possible.';

COMMENT ON COLUMN "release1"."PhoneNumber"."HasInternetAccess" IS 'Optional. Default is false, even for mobile numbers. Assumed to be false, but update it to true if the patient installs an app using a number and the app connects to the server successfully using either cellular or wifi internet.';

COMMENT ON COLUMN "release1"."PhoneNumber"."HasSMSAccess" IS 'Optional. Assumed to be true for mobile numbers.';

COMMENT ON COLUMN "release1"."PhoneNumber"."HasWhatsAppAccess" IS 'Optional. Whether the user has a WhatsApp app account using this number on a smart phone. Default is false, even for mobile numbers.';

COMMENT ON COLUMN "release1"."PhoneNumber"."HasTelegramAccess" IS 'Optional. Whether the user has a Telegram app account using this number on a smart phone. Default is false, even for mobile numbers.';

COMMENT ON COLUMN "release1"."PhoneNumber"."ProvidesLocation" IS 'Optional. Whether this phone number is that of a phone that has location (GPS) service. Assumed to be false, but update it to true if the patient installs an app using a number and the app reports location information.';

CREATE  TABLE "release1"."PreExistingCondition" ( 
	"PreExistingConditionId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"PreExistingConditionCodeSystem" varchar(32)   ,
	"PreExistingCondtionConceptCode" varchar(32)   ,
	"PreExistingCondtionDescription" varchar(255)   ,
	"IsActive"           bool   ,
	"Controlled"         bool   ,
	"DurationNum"        integer   ,
	"DurationUnits"      varchar(10)   ,
	CONSTRAINT "PreExistingCondition_pkey" PRIMARY KEY ( "PreExistingConditionId" )
 );

ALTER TABLE "release1"."PreExistingCondition" ADD CONSTRAINT "PreExistingCondition_DurationUnits_check" CHECK (  ((("DurationUnits")::text = ANY ((ARRAY['Days'::character varying, 'Weeks'::character varying, 'Months'::character varying, 'Years'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."PreExistingCondition" IS 'Currently unused. \nAll preexisting health conditions of this patient.';

CREATE  TABLE "release1"."PreExistingConditionsCovidDenorm" ( 
	"CovidPreExistingConditionId" integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer   ,
	COPD                 bool   ,
	"Bronchitis"         bool   ,
	"DiabetesMellitus"   bool   ,
	"Hypertension"       bool   ,
	"ChronicRenalDisease" bool   ,
	"Malignancy"         bool   ,
	"HeartDisease"       bool   ,
	"Asthma"             bool   ,
	"Obesity"            bool   ,
	"Other"              varchar(255)   ,
	CONSTRAINT "PreExistingConditionsCovidDenorm_pkey" PRIMARY KEY ( "CovidPreExistingConditionId" )
 );

COMMENT ON TABLE "release1"."PreExistingConditionsCovidDenorm" IS 'Currently unused. \nSpecific preexisting health conditions that are risk factors for COVID-19.';

CREATE  TABLE "release1"."UserPhoto" ( 
	"PhotoId"            integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"UserId"             integer  NOT NULL ,
	"PhotoType"          char(16)   ,
	"PhotoPath"          varchar(255)   ,
	"FileSavedDateTime"  timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT "UserPhotos_pkey" PRIMARY KEY ( "PhotoId" )
 );

ALTER TABLE "release1"."UserPhoto" ADD CONSTRAINT "UserPhoto_PhotoType_check" CHECK (  (("PhotoType" = ANY (ARRAY['Profile'::bpchar, 'Selfie'::bpchar, 'OfficialId'::bpchar, 'Other'::bpchar]))) );

COMMENT ON TABLE "release1"."UserPhoto" IS 'Photo of an individual. Photos may be stored on the filesystem and the path to that file is stored in this table. An individual may have multiple photos.';

COMMENT ON COLUMN "release1"."UserPhoto"."PhotoType" IS 'Type may be ''profile'' (profile photo showed in patient app or health professional dashboard), identity document, selfie, etc. - specified using CHECK CONSTRAINTS.';

COMMENT ON COLUMN "release1"."UserPhoto"."PhotoPath" IS 'File system path where the image file is saved. May be absolute or relative based on the system configuration.';

CREATE  TABLE "release1"."Allergy" ( 
	"AllergyId"          integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"AllergenType"       varchar(16)   ,
	"AllergenCodeSystem" varchar(32)   ,
	"AllergenConceptCode" varchar(32)   ,
	"AllergenDescription" varchar(255)   ,
	"AllergicRxnCodeSystem" varchar(32)   ,
	"AllergicRxnConceptCode" varchar(32)   ,
	"AllergicRxnDescription" varchar(255)   ,
	"AllergySeverity"    varchar(10)   ,
	"IsActive"           bool   ,
	"DurationNum"        integer   ,
	"DurationUnits"      varchar(10)   ,
	CONSTRAINT "Allergy_pkey" PRIMARY KEY ( "AllergyId" )
 );

ALTER TABLE "release1"."Allergy" ADD CONSTRAINT "Allergy_AllergenType_check" CHECK (  ((("AllergenType")::text = ANY ((ARRAY['Food'::character varying, 'Drug'::character varying, 'Environmental'::character varying])::text[]))) );

ALTER TABLE "release1"."Allergy" ADD CONSTRAINT "Allergy_AllergySeverity_check" CHECK (  ((("AllergySeverity")::text = ANY ((ARRAY['Mild'::character varying, 'Moderate'::character varying, 'Severe'::character varying])::text[]))) );

ALTER TABLE "release1"."Allergy" ADD CONSTRAINT "Allergy_DurationUnits_check" CHECK (  ((("DurationUnits")::text = ANY ((ARRAY['Days'::character varying, 'Weeks'::character varying, 'Months'::character varying, 'Years'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."Allergy" IS 'Currently unused. The patient''s food, drug or environmental allergies.';

COMMENT ON COLUMN "release1"."Allergy"."AllergenType" IS 'Food, drug or environmental.';

COMMENT ON COLUMN "release1"."Allergy"."AllergenCodeSystem" IS 'Usually SNOMED CT. Currently unused.';

CREATE  TABLE "release1"."HealthCheckHistory" ( 
	"HealthHistoryId"    integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"EnteredByUserId"    integer   ,
	"HealthCheckByUserType" varchar   ,
	"AppHeartbeatId"     integer   ,
	"LocationId"         integer   ,
	"HealthCheckDateTime" timestamp DEFAULT timezone('utc'::text, now())  ,
	"HealthCheckReason"  varchar   ,
	"CoughPresent"       bool DEFAULT false  ,
	"FeverPresent"       bool DEFAULT false  ,
	"BreathingDifficultyPresent" bool DEFAULT false  ,
	"ProgressStatus"     varchar(16)   ,
	"TemperatureCelsius" float8   ,
	"HeartRatePerMin"    integer   ,
	"RespRatePerMin"     integer   ,
	"SpO2Percent"        integer   ,
	"SystolicBPMMHg"     integer   ,
	"DiastolicBPMMHg"    integer   ,
	"Comments"           varchar(255)   ,
	CONSTRAINT "HealthHistory_pkey" PRIMARY KEY ( "HealthHistoryId" )
 );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthCheckHistory_HealthCheckByUserType_check" CHECK (  ((("HealthCheckByUserType")::text = ANY ((ARRAY['App - primary user'::character varying, 'App - secondary user'::character varying, 'Health Pro'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthCheckHistory_HealthCheckReason_check" CHECK (  ((("HealthCheckReason")::text = ANY ((ARRAY['Routine'::character varying, 'Device idle'::character varying, 'App user initiated'::character varying, 'Health pro initiated'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthCheckHistory_ProgressStatus_check" CHECK (  ((("ProgressStatus")::text = ANY ((ARRAY['Getting better'::character varying, 'Getting worse'::character varying, 'Staying the same'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."HealthCheckHistory" IS 'Health check history collected via the mobile app - the patient is prompted to fill in their current health status. Typically this is done twice a day at 10AM and 8PM. It may be done more frequently if the patient''s device hasn''t moved for approximately 2 hours. The patient may also fill in at other times if they want to.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."PatientId" IS 'PatientId to whom this health history applies.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."EnteredByUserId" IS 'UserId of the logged in user of the mobile app. May be different from UserId if the health history belongs to a child, elderly or incapacitated person.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."HealthCheckByUserType" IS 'Type of user who documented this health check. Options are:\n''primary'' - done via app by primary user of the app (patient), \n''secondary'' - a patient''s helath history done by a differnt user (family/household member or carer) who logged on to the app, \n''health professional'' (via any application), or \n''other'' - any other unspecified user or application type. \nAllowed values are constrained by a CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."AppHeartbeatId" IS 'Foreign key to App HeartBeat that is automatically captured when health history is filled out.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."LocationId" IS 'Foreign key to device location that is automatically captured when health history is filled out.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."HealthCheckReason" IS 'Reason for this health check - routine, device idle for a certain amount of time, or ad hoc by the patient. Constrained by a CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."ProgressStatus" IS 'Is the patient''s health getting better, worse or staying the same since the last health check (previous day or the same day).';

COMMENT ON COLUMN "release1"."HealthCheckHistory"."TemperatureCelsius" IS 'Temperature in celsius. If the app allows entry in Fahrenheit, unit conversion must be done on the client side (app).';

CREATE  TABLE "release1"."Medication" ( 
	"MedicationId"       integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer   ,
	"IngredientCodeSystem" varchar(32)   ,
	"IngredientConceptCode" varchar(32)   ,
	"IngredientDescription" varchar(255)   ,
	"BrandedName"        varchar(255)   ,
	"IsActive"           bool   ,
	"DurationNum"        integer   ,
	"DurationUnits"      varchar(10)   ,
	"StrengthNumAndUnits" varchar(32)   ,
	"DoseNumAndUnits"    varchar(32)   ,
	"Frequency"          varchar(32)   ,
	"Route"              varchar(32)   ,
	"Indication"         varchar(32)   ,
	"Intent"             varchar(10)   ,
	"Comments"           varchar(255)   ,
	CONSTRAINT "Medication_pkey" PRIMARY KEY ( "MedicationId" )
 );

ALTER TABLE "release1"."Medication" ADD CONSTRAINT "Medication_DurationUnits_check" CHECK (  ((("DurationUnits")::text = ANY ((ARRAY['Days'::character varying, 'Weeks'::character varying, 'Months'::character varying, 'Years'::character varying])::text[]))) );

ALTER TABLE "release1"."Medication" ADD CONSTRAINT "Medication_Intent_check" CHECK (  ((("Intent")::text = ANY ((ARRAY['Prophylaxis'::character varying, 'Treatment'::character varying, 'Adjuant'::character varying, 'Clinical Trial'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."Medication" IS 'Currently unused. \nAll medications of this patient, including medications that the patient was taking before quarantine/isolation started as well as those that were prescribed during quarantine/isolation. Includes both prescription and non-prescription medications.';

CREATE  TABLE "release1"."PatProRelationship" ( 
	"PatProRelId"        integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PatientId"          integer  NOT NULL ,
	"HealthProId"        integer  NOT NULL ,
	"RelType"            varchar(16)   ,
	"RelStartDate"       timestamp   ,
	"RelEndDate"         timestamp   ,
	"RelFacilityLocation" integer   ,
	"Comments"           varchar(255)   ,
	CONSTRAINT "PatProRel_pkey" PRIMARY KEY ( "PatProRelId" )
 );

ALTER TABLE "release1"."PatProRelationship" ADD CONSTRAINT "PatProRelationship_RelType_check" CHECK (  ((("RelType")::text = ANY ((ARRAY['Screening official'::character varying, 'Quarantine official'::character varying, 'Isolation official'::character varying, 'Medical official'::character varying, 'Field worker'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."PatProRelationship" IS 'Relationship between a patient and a health professional (also known as health care provider or simply ''provider'') when they provide care to a patient. Care in this context includes quarantine/isolation service to the patient. Only providers with a patient-provider relationship can view personally identifiable information or protected health information of a patient through the health professional dashboard. Other health professionals can only view summary statistics and reports.';

COMMENT ON COLUMN "release1"."PatProRelationship"."RelType" IS 'Type of relationship. Constrained by CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."PatProRelationship"."RelStartDate" IS 'Optional.';

COMMENT ON COLUMN "release1"."PatProRelationship"."RelEndDate" IS 'Optional.';

COMMENT ON COLUMN "release1"."PatProRelationship"."RelFacilityLocation" IS 'Foreign key to Location that is pertinent to this relationship. This may be a local health department or a hospital, etc.';

CREATE  TABLE "release1"."PhoneDeviceApp" ( 
	"DeviceAppId"        integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"PhoneNumberId"      integer  NOT NULL ,
	"DeviceIMEI"         varchar(20)   ,
	"DeviceMacId"        varchar(20)   ,
	"DeviceOS"           varchar(10)   ,
	"DeviceOSVersion"    varchar(10)   ,
	"DeviceManufacturer" varchar(16)   ,
	"DeviceModel"        varchar(16)   ,
	"DevicePhoneNumber"  varchar(20)   ,
	"DevicePhoneServiceProvider" varchar(20)   ,
	"AppVersion"         varchar(10)   ,
	"AppInstalledDateTime" timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT "PatientDeviceApp_pkey" PRIMARY KEY ( "DeviceAppId" )
 );

ALTER TABLE "release1"."PhoneDeviceApp" ADD CONSTRAINT "PhoneDeviceApp_DeviceOS_check" CHECK (  ((("DeviceOS")::text = ANY ((ARRAY['Android'::character varying, 'iOS'::character varying, 'Other'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."PhoneDeviceApp" IS 'Smart phones on which a patient may install the mobile app.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."PhoneNumberId" IS 'Primary key of the phone number record for this device.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceIMEI" IS 'IMEI number that uniquely identifies the phone handset.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceMacId" IS 'Optional. MAC ID of the network device on the phone. Need to define which network interface this pertains to.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceOS" IS 'OS for smart phones, either Android or iOS.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceOSVersion" IS 'Device OS version if known.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceManufacturer" IS 'Device manufacturer, if known.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DeviceModel" IS 'Device model number, if known.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DevicePhoneNumber" IS 'Phone number of the device. Denormalization of the phone number record for this device.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."DevicePhoneServiceProvider" IS 'Company that provides the cellular service for this device.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."AppVersion" IS 'Version of the Covenant app installed on this phone.';

COMMENT ON COLUMN "release1"."PhoneDeviceApp"."AppInstalledDateTime" IS 'Last updated date/time when the Covenant app was installed or updated.';

CREATE  TABLE "release1"."DeviceLocation" ( 
	"DeviceLocationId"   integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	"DeviceAppId"        integer  NOT NULL ,
	"Latitude"           float8   ,
	"Longitude"          float8   ,
	"LocationId"         integer   ,
	"AddressId"          integer   ,
	"LocationServiceType" varchar(10)   ,
	"LocationDateTime"   timestamp DEFAULT timezone('utc'::text, now())  ,
	"LocationCheckReason" varchar(16)   ,
	"LocationCheckResult" varchar(16)   ,
	"GeofenceStatus"     varchar(16)   ,
	"GeofenceAction"     varchar(255)   ,
	"Comments"           varchar(255)   ,
	CONSTRAINT "DeviceLocation_pkey" PRIMARY KEY ( "DeviceLocationId" )
 );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_LocationServiceType_check" CHECK (  ((("LocationServiceType")::text = ANY ((ARRAY['GPS'::character varying, 'High resolution'::character varying, 'Cellular'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_LocationCheckReason_check" CHECK (  ((("LocationCheckReason")::text = ANY ((ARRAY['Routine'::character varying, 'Device Idle'::character varying, 'Random'::character varying, 'Manual'::character varying, 'Other'::character varying])::text[]))) );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_LocationCheckResult_check" CHECK (  ((("LocationCheckResult")::text = ANY ((ARRAY['Success'::character varying, 'Failed'::character varying, 'Delayed'::character varying])::text[]))) );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_GeofenceStatus_check" CHECK (  ((("GeofenceStatus")::text = ANY ((ARRAY['Inside'::character varying, 'Outside - near'::character varying, 'Outside - far'::character varying, 'Unknown'::character varying])::text[]))) );

COMMENT ON TABLE "release1"."DeviceLocation" IS 'Device location captured periodically captured by the application at specified time intervals. It may also be captured when the patient fills out their health history updates.';

COMMENT ON COLUMN "release1"."DeviceLocation"."AddressId" IS 'Foreign key to the postal address of this location.';

COMMENT ON COLUMN "release1"."DeviceLocation"."LocationServiceType" IS 'GPS (from the device), high resolution (a combination of cellular, bluetooth or wifi, captured by the device), cellular (reported by the cellular company, for a future version), or ''other''. Constrained using a CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."DeviceLocation"."LocationCheckReason" IS 'Is it routine (time interval), health update history, or other. Constrained using a CHECK CONSTRAINT.';

COMMENT ON COLUMN "release1"."DeviceLocation"."LocationCheckResult" IS 'Did the location check succeed (location captured successfully) or failed (location was not reported - perhaps location service turned off on the mobile device?).';

COMMENT ON COLUMN "release1"."DeviceLocation"."GeofenceStatus" IS 'Is the patient within the geofenced location/radius?';

COMMENT ON COLUMN "release1"."DeviceLocation"."GeofenceAction" IS 'Currently unused. What action was taken by health authorities if the patient was outside their geofence.';

ALTER TABLE "release1"."Address" ADD CONSTRAINT "Address_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."Allergy" ADD CONSTRAINT "Allergy_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."Demographics" ADD CONSTRAINT "Demographics_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_AddressId_fkey" FOREIGN KEY ( "AddressId" ) REFERENCES "release1"."Address"( "AddressId" );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_LocationId_fkey" FOREIGN KEY ( "LocationId" ) REFERENCES "release1"."LocationHierarchy"( "LocationId" );

ALTER TABLE "release1"."DeviceLocation" ADD CONSTRAINT "DeviceLocation_AppHeartbeatId_fkey" FOREIGN KEY ( "DeviceAppId" ) REFERENCES "release1"."PhoneDeviceApp"( "DeviceAppId" );

ALTER TABLE "release1"."EmailAddress" ADD CONSTRAINT "EmailAddress_PrimaryUserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."EmailAddress" ADD CONSTRAINT "EmailAddress_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."ExternalIdentifier" ADD CONSTRAINT "ExternalIdentifier_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_AppHeartbeatId_fkey" FOREIGN KEY ( "AppHeartbeatId" ) REFERENCES "release1"."AppHeartbeat"( "AppHeartbeatId" );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_LocationID_fkey" FOREIGN KEY ( "LocationId" ) REFERENCES "release1"."LocationHierarchy"( "LocationId" );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_UserId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."HealthCheckHistory" ADD CONSTRAINT "HealthHistory_EnteredByUserID_fkey" FOREIGN KEY ( "EnteredByUserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."HealthProfessional" ADD CONSTRAINT "HealthPro_SupervisorId_fkey" FOREIGN KEY ( "SupervisorId" ) REFERENCES "release1"."HealthProfessional"( "HealthProId" );

ALTER TABLE "release1"."HealthProfessional" ADD CONSTRAINT "HealthPro_WorkLocationId_fkey" FOREIGN KEY ( "WorkLocationId" ) REFERENCES "release1"."LocationHierarchy"( "LocationId" );

ALTER TABLE "release1"."HealthProfessional" ADD CONSTRAINT "HealthPro_HealthProId_fkey" FOREIGN KEY ( "HealthProId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."LocationHierarchy" ADD CONSTRAINT "Location_ParentLocationId_fkey" FOREIGN KEY ( "ParentLocationId" ) REFERENCES "release1"."LocationHierarchy"( "LocationId" );

ALTER TABLE "release1"."Medication" ADD CONSTRAINT "Medication_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."PatProRelationship" ADD CONSTRAINT "PatProRel_HealthProId_fkey" FOREIGN KEY ( "HealthProId" ) REFERENCES "release1"."HealthProfessional"( "HealthProId" );

ALTER TABLE "release1"."PatProRelationship" ADD CONSTRAINT "PatProRel_RelFacilityLocation_fkey" FOREIGN KEY ( "RelFacilityLocation" ) REFERENCES "release1"."LocationHierarchy"( "LocationId" );

ALTER TABLE "release1"."PatProRelationship" ADD CONSTRAINT "PatProRel_PatientID_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."Patient" ADD CONSTRAINT "Patient_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."PatientGeofencedLocation" ADD CONSTRAINT "GeofenceLocation_GeofencedAddressId_fkey" FOREIGN KEY ( "GeofencedAddressId" ) REFERENCES "release1"."Address"( "AddressId" );

ALTER TABLE "release1"."PatientGeofencedLocation" ADD CONSTRAINT "GeofenceLocation_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."PatientRequestHistory" ADD CONSTRAINT "PatientRequestHistory_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."PatientRequestHistory" ADD CONSTRAINT "PatientRequestHistory_ResponseUserId_fkey" FOREIGN KEY ( "ResponseUserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."PatientStatus" ADD CONSTRAINT "PatientStatus_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."PhoneDeviceApp" ADD CONSTRAINT "PatientDeviceApp_PhoneNumberId_fkey" FOREIGN KEY ( "PhoneNumberId" ) REFERENCES "release1"."PhoneNumber"( "PhoneNumberId" );

ALTER TABLE "release1"."PhoneNumber" ADD CONSTRAINT "PhoneNumber_PrimaryUserId_fkey" FOREIGN KEY ( "PrimaryUserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."PhoneNumber" ADD CONSTRAINT "PhoneNumber_UserId_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

ALTER TABLE "release1"."PreExistingCondition" ADD CONSTRAINT "PreExistingCondition_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."PreExistingConditionsCovidDenorm" ADD CONSTRAINT "PreExistingConditionsCovidDenorm_PatientId_fkey" FOREIGN KEY ( "PatientId" ) REFERENCES "release1"."Patient"( "PatientId" );

ALTER TABLE "release1"."UserPhoto" ADD CONSTRAINT "UserPhotos_UserID_fkey" FOREIGN KEY ( "UserId" ) REFERENCES "release1"."Users"( "UserId" );

