-- release1 schema. All tables/columns renamed in lowercase with underscores.
-- Some columns' datatypes/size changed. All char fields changed to varcha) 
-- as per tip at https://www.postgresql.org/docs/current/datatype-character.html
-- Check constraints added, character varying(32) for all check constraint fields.
-- Display_strings table added to support multiple languages.
-- Note: Postgres varchar field size is in characters (UTF-8 safe), not bytes.

CREATE SCHEMA release1;

--Formerly users. Using plural for this table name because user is a reserved keyword
CREATE TABLE release1.users
(
    user_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	-- The ls_* fields are in Latin English 26-character script. (ls denotes latin script)
	ls_title character varying(16),
    ls_first_name character varying(32),
	ls_middle_name character varying(32),
	ls_last_name character varying(32),
	ls_maiden_name character varying(32),
	ls_display_name character varying(16),
	ls_suffix character varying(16),
	ls_degree character varying(16),
	ls_alias_name_1 character varying(32),
	ls_alias_name_2 character varying(32),
	-- the ns_* fields are in native script of the user, including extended Latin characters (with diacritics/accent marks)
    ns_title character varying(16),
	ns_first_name character varying(32),
	ns_middle_name character varying(32),
	ns_last_name character varying(32),
	ns_maiden_name character varying(32),
	ns_display_name character varying(16),
	ns_suffix character varying(16),
	ns_degree character varying(16),
	ns_alias_name_1 character varying(32),
	ns_alias_name_2 character varying(32),
	standard_name character varying(30), -- standardized passport format in English script
    date_of_birth date,
	age_yrs smallint   ,
    admin_gender character varying(32),
	biological_sex character varying(32),
	username character varying(32),
	comments character varying(255),
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

--formerly UserPhotos. Moved fkey to this from users table, reordering CREATE script
CREATE TABLE release1.user_photo
(
    photo_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	user_id    integer  NOT NULL ,
    photo_type character varying(32) DEFAULT 'phototype_profile',
	photo_path  character varying(255),
	file_saved_datetime timestamp without time zone default (now() at time zone 'utc'),
    CONSTRAINT user_photo_pkey PRIMARY KEY (photo_id),
	CONSTRAINT user_photo_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users(user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly LocationHierarchy
CREATE TABLE release1.location_hierarchy
(
    location_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    location_name character varying(255),
	location_abbr character varying(32),
	assign_patients boolean DEFAULT false,
	parent_location_id integer DEFAULT NULL,
	country_code character varying(32),
	address_id INTEGER,
	location_type character varying(32),
    CONSTRAINT location_pkey PRIMARY KEY (location_id),
	CONSTRAINT location_parent_location_id_fkey FOREIGN KEY (parent_location_id)
        REFERENCES release1.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly HealthProfessional.
CREATE TABLE release1.health_pro
(
    health_pro_job_id integer GENERATED ALWAYS AS IDENTITY NOT NULL, -- a single user may have multiple jobs
	user_id integer NOT NULL, -- fk to users.user_id
    supervisor_id integer,
    job_title character varying(32),
    work_location_id integer, -- work location may denote a specific office
    is_active boolean DEFAULT true,
    CONSTRAINT health_pro_pkey PRIMARY KEY (health_pro_job_id), -- one person may have multiple jobs in different offices, so creating a composite primary key that includes office location
    CONSTRAINT health_pro_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users(user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT health_pro_supervisor_id_fkey FOREIGN KEY (supervisor_id)
        REFERENCES release1.health_pro (health_pro_job_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT health_pro_work_location_id FOREIGN KEY (work_location_id)
        REFERENCES release1.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--Formerly Patient. Some columns moved to Demographics table
CREATE TABLE release1.patient
(
    patient_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	household_id integer,
	has_preexisting_conditions boolean,
	has_medications boolean,
	has_allergies boolean,
	has_advance_directives boolean,
	needs_carer boolean,
	has_international_travel boolean,
	has_interstate_travel boolean,
	has_high_risk_facility_visit boolean,
	is_high_risk_health_worker boolean,
	blood_group character varying(32),
	clinical_trial_status character varying(10),
	comments character varying(10),
    CONSTRAINT patient_pkey PRIMARY KEY (patient_id),
	CONSTRAINT patient_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE  TABLE release1.demographics ( 
	user_id             integer  NOT NULL ,
	nationality        character varying(32)   ,
	residency_status    character varying(32)   ,
	occupation         character varying(32)   ,
	emergency_contact_id_1 integer   ,
	emer_contact_1_rel_to_pat   character varying(32)   ,
	emergency_contact_id_2 integer   ,
	emer_contact_2_rel_to_pat   character varying(32)   ,
	next_of_kin_id_1 integer   ,
	next_of_kin_1_rel_to_pat   character varying(32)   ,
	next_of_kin_id_2 integer   ,
	next_of_kin_2_rel_to_pat   character varying(32)   ,
	comments character varying(2048),
	CONSTRAINT demographics_pkey PRIMARY KEY ( user_id ),
	CONSTRAINT demographics_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

 );



--Formerly PatientProviderRelationship
CREATE TABLE release1.patient_provider_rel
(
    pat_pro_rel_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	patient_id integer,
	health_pro_job_id integer,
	rel_type character varying(32),
	rel_start_date timestamp without time zone,
	rel_end_date timestamp without time zone,
	location_id integer,
    CONSTRAINT patient_provider_rel_pkey PRIMARY KEY (pat_pro_rel_id),
	CONSTRAINT patient_provider_rel_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT patient_provider_rel_health_pro_job_id_fkey FOREIGN KEY (health_pro_job_id)
        REFERENCES release1.health_pro (health_pro_job_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT patient_provider_location_id_fkey FOREIGN KEY (location_id)
        REFERENCES release1.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly: CovidContact
CREATE  TABLE release1.covid_contact ( 
	contact_id          integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	contact_user_id_1     integer not null  ,
	contact_user_id_2     integer not null   ,
	contact_time_start   timestamp without time zone   ,
	contact_time_end     timestamp without time zone   ,
	contact_location_id    integer   ,
	contact_relationship character varying(10)   ,
	contact_exposure    character varying(10)   ,
	CONSTRAINT covid_contact_pkey PRIMARY KEY (contact_id)
 );


--Formerly: EmailAddress
CREATE  TABLE release1.email_address ( 
	email_address_id     integer GENERATED ALWAYS AS IDENTITY  NOT NULL ,
	user_id             integer  NOT NULL ,
	email_address       character varying(64)  NOT NULL ,
	email_address_type   character varying(32)  NOT NULL ,
	is_preferred        bool   ,
	is_primary_user      bool DEFAULT true  ,
	primary_user_id      integer   ,
	CONSTRAINT email_address_pkey PRIMARY KEY (email_address_id),
	CONSTRAINT email_address_primary_user_id_fkey FOREIGN KEY (primary_user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT email_address_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--phone_number
CREATE  TABLE release1.phone_number ( 
	phone_number_id      integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	user_id             integer  NOT NULL ,
	phone_type          character varying(32)  NOT NULL ,
	phone_number        character varying(20)   ,
	phone_number_extn    character varying(8)   ,
	phone_number_formatted character varying(32)   ,
	is_preferred        bool   ,
	is_primary_user      bool DEFAULT true  ,
	primary_user_id      integer   ,
	has_internet  bool   ,
	has_sms       bool   ,
	has_whatsapp  bool   ,
	has_telegram  bool   ,
	provides_location   bool   ,
	otp_code          character varying (8),
	phone_hash        character varying(1024)   ,
	CONSTRAINT phone_number_pkey PRIMARY KEY (phone_number_id), 
	CONSTRAINT phone_number_primary_user_id_fkey FOREIGN KEY (primary_user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT phone_number_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Address
CREATE TABLE release1.address
(
    address_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	user_id integer,
    address_type character varying(10),
	company_name character varying(10),
	in_care_of character varying(10),
	address_line_1 character varying(10),
	address_line_2 character varying(10),
	address_line_3 character varying(10),
	city character varying(10),
	district_county character varying(10),
	state_territory character varying(10), -- State is a reserved keyword
	post_code character varying(10),
	country character varying(10),
    CONSTRAINT address_pkey PRIMARY KEY (address_id),
	CONSTRAINT address_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--External Identifier
CREATE TABLE release1.external_identifier
(
    identification_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	user_id integer,
    id_type character varying(32),
	id_type_uri character varying(10),
	issuing_authority_name character varying(10),
	issuing_authority_id character varying(10),
	issuing_authority_uri character varying(10),
	id_number character varying(20),
	issue_date character varying(10),
	expiry_date character varying(10),
    CONSTRAINT external_identifier_pkey PRIMARY KEY (identification_id),
	CONSTRAINT external_identifier_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--PreExistingCondition
CREATE  TABLE release1.pre_existing_condition ( 
	pre_existing_condition_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	patient_id          integer  NOT NULL ,
	pre_existing_condition_code_system character varying(32)   ,
	pre_existing_condtion_concept_code character varying(32)   ,
	pre_existing_condtion_description character varying(255)   ,
	is_active           bool   ,
	is_controlled         bool   ,
	duration_num        integer   ,
	duration_units      character varying(10)   ,
	CONSTRAINT pre_existing_condition_pkey PRIMARY KEY ( pre_existing_condition_id ),
	CONSTRAINT pre_existing_condition_user_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly: PreExistingConditionsCovidDenorm. Moving up due to natural sequence
CREATE  TABLE release1.pre_existing_condition_covid_denorm ( 
	covid_pre_existing_condition_id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	patient_id          integer   NOT NULL ,
	pre_existing_condition_id integer,
	copd                 bool   ,
	bronchitis         bool   ,
	diabetes_mellitus   bool   ,
	diabetes_mellitus_type_1   bool   ,
	diabetes_mellitus_type_2   bool   ,
	hypertension       bool   ,
	chronic_renal_disease bool   ,
	malignancy         bool   ,
	heart_disease       bool   ,
	asthma             bool   ,
	obesity            bool   ,
	comments              character varying(255)   ,
    CONSTRAINT pre_existing_condition_covid_denorm_pkey PRIMARY KEY (covid_pre_existing_condition_id),
	CONSTRAINT pre_existing_condition_covid_denorm_user_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT pre_existing_condition_covid_denorm_condition_fkey FOREIGN KEY (pre_existing_condition_id)
        REFERENCES release1.pre_existing_condition (pre_existing_condition_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Allergy
CREATE  TABLE release1.allergy ( 
	allergy_id          integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer  NOT NULL ,
	allergen_type       character varying(32)   ,
	allergen_code_system character varying(32)   ,
	allergen_concept_code character varying(32)   ,
	allergen_description character varying(255)   ,
	allergic_rxn_code_system character varying(32)   ,
	allergic_rxn_concept_code character varying(32)   ,
	allergic_rxn_description character varying(255)   ,
	allergy_severity    character varying(10)   ,
	is_active           bool   ,
	duration_num        integer   ,
	duration_units      character varying(10)   ,
	CONSTRAINT allergy_pkey PRIMARY KEY ( allergy_id ),
	CONSTRAINT allergy_user_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--Formerly: Medication
CREATE  TABLE release1.medication ( 
	medication_id       integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer NOT NULL  ,
	ingredient_code_system character varying(32)   ,
	ingredient_concept_code character varying(32)   ,
	ingredient_description character varying(255)   ,
	branded_name        character varying(255)   ,
	is_active           bool   ,
	duration_num        integer   ,
	duration_units      character varying(10)   ,
	strength_num_and_units character varying(32)   ,
	dose_num_and_units    character varying(32)   ,
	frequency          character varying(32)   ,
	route              character varying(32)   ,
	indication         character varying(32)   ,
	intent_type        character varying(32)   , -- treatment, prophylaxis, other
	comments           character varying(255)   ,
	CONSTRAINT medication_pkey PRIMARY KEY (medication_id),
 	CONSTRAINT medication_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--CREATE TYPE COVIDStatusType AS ENUM ('Susceptible', 'Exposed', 'Infected', 'Recovered', 'Deceased');
--CREATE TYPE PatientType AS ENUM ('Medical quarantine', 'Self quarantine', 'Staying at home', 'Home isolation', 'Hospitalized', 'Not applicable');
--CREATE TYPE QuarantineStatus AS ENUM ('Not quarantined', 'Quarantine started', 'Quarantine ended', 'On leave');
--CREATE TYPE IsolationStatus AS ENUM ('Not isolated', 'Isolation started', 'Isolation ended');
--PatientStatus
-- latitude and longitude changed from double/float to numeric for exact precision
CREATE  TABLE release1.patient_status ( 
	patient_status_id    integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer  NOT NULL ,
	covid19_status      character varying(32) DEFAULT 'covid19_susceptible'::character varying  ,
	health_status       character varying(32)   ,
	quar_islt_status     character varying(32)   ,
	quar_islt_start_date_time timestamp   ,
	quar_islt_end_date_time timestamp   ,
	quar_islt_request_status character varying(32)   ,
	medical_request_status character varying(32)   ,
	supplies_request_status character varying(32)   ,
	geofence_status     character varying(16)   ,
	app_heartbeat_status character varying(16)   ,
	updated_date_time    timestamp DEFAULT timezone('utc'::text, now())  ,
	latitude           numeric(10, 8)   , -- -90 to +90 degrees
	longitude          numeric(11, 8)   , -- -180 to +180 degrees
	comments           character varying(128)   ,
	CONSTRAINT patient_status_pkey PRIMARY KEY (patient_status_id),
	CONSTRAINT patient_status_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly: LocationHistory
CREATE  TABLE release1.device_location ( 
	device_location_id   integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	device_app_id        integer  NOT NULL ,
	latitude           numeric(10, 8)   , -- -90 to +90 degrees
	longitude          numeric(11, 8)   , -- -180 to +180 degrees
	location_id         integer   ,
	address_id          integer   ,
	location_service_type character varying(10)   ,
	location_date_time   timestamp DEFAULT timezone('utc'::text, now())  ,
	location_check_reason character varying(16)   ,
	location_check_result character varying(16)   ,
	geofence_status     character varying(16)   ,
	geofence_action     character varying(255)   ,
	comments           character varying(255)   ,
	CONSTRAINT device_location_pkey PRIMARY KEY ( device_location_id ),
	CONSTRAINT device_location_location_id_fkey FOREIGN KEY (location_id)
        REFERENCES release1.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT device_location_address_id_fkey FOREIGN KEY (address_id)
        REFERENCES release1.address (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

);


--CREATE TYPE RequestType AS ENUM ('Quarantine', 'Medical', 'Supplies');
--CREATE TYPE RequestStatusType AS ENUM ('Open', 'In Progress', 'Closed');
--CREATE TYPE ResponseType AS ENUM ('Phone', 'In Person');
--Formerly: UserRequestHistory
CREATE  TABLE release1.patient_request_history ( 
	patient_request_history_id integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer  NOT NULL ,
	request_type        character varying(16)   ,
	request_date_time    timestamp DEFAULT timezone('utc'::text, now())  ,
	request_status      varchar DEFAULT 'Open'::character varying  ,
	request_comments    character varying(255)   ,
	response_type       character varying(16)   ,
	response_user_id     integer   ,
	response_date_time   timestamp   ,
	response_comments   character varying(255)   ,
	CONSTRAINT patient_request_history_pkey PRIMARY KEY ( patient_request_history_id ),
	CONSTRAINT patient_request_history_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT user_request_history_response_user_id_fkey FOREIGN KEY (response_user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly: PatientDeviceApp
CREATE  TABLE release1.phone_device_app ( 
	device_app_id        integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	phone_number_id      integer  NOT NULL ,
	device_imei         character varying(20)   ,
	device_mac_id        character varying(20)   ,
	device_os           character varying(10)   ,
	device_os_version    character varying(10)   ,
	device_manufacturer character varying(16)   ,
	device_model        character varying(16)   ,
	device_phone_number  character varying(20)   ,
	device_phone_service_provider character varying(20)   ,
	app_version         character varying(10)   ,
	app_installed_date_time timestamp DEFAULT timezone('utc'::text, now())  ,
	CONSTRAINT phone_device_app_pkey PRIMARY KEY ( device_app_id ),
	CONSTRAINT phone_device_app_phone_number_id_fkey FOREIGN KEY (phone_number_id)
        REFERENCES release1.phone_number (phone_number_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--Formerly: AppHeartbeatHistory. Moved up due to fkey reference.
CREATE  TABLE release1.app_heartbeat ( 
	app_heartbeat_id     integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	device_app_id        integer  NOT NULL ,
	heartbeat_date_time  timestamp DEFAULT timezone('utc'::text, now())  ,
	heartbeat_ip4_address character varying(16)   ,
	heartbeat_ip6_address character varying(40)   ,
	heartbeat_status    character varying(10)   ,
	CONSTRAINT app_heartbeat_pkey PRIMARY KEY ( app_heartbeat_id ),
	CONSTRAINT app_heartbeat_device_app_id_fkey FOREIGN KEY (device_app_id)
        REFERENCES release1.phone_device_app (device_app_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--CREATE TYPE ProgressType AS ENUM ('Worsening', 'Improving', 'Stay the same');
--Formerly: HealthCheckHistory
CREATE  TABLE release1.health_check_history ( 
	health_history_id    integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer  NOT NULL ,
	entered_by_user_id    integer   ,
	health_check_by_user_type character varying(32)   ,
	app_heartbeat_id     integer   ,
	location_id         integer   ,
	health_check_date_time timestamp DEFAULT timezone('utc'::text, now())  ,
	health_check_reason  character varying(255)   ,
	cough_present       bool DEFAULT false  ,
	fever_present       bool DEFAULT false  ,
	breathing_difficulty_present bool DEFAULT false  ,
	progress_status     character varying(32)   ,
	temperature_celsius float8   ,
	heart_rate_per_min    integer   ,
	resp_rate_per_min     integer   ,
	spo2_percent        integer   ,
	systolic_bp_mmhg     integer   ,
	diastolic_bp_mmhg    integer   ,
	comments           character varying(255)   ,
	CONSTRAINT health_check_history_pkey PRIMARY KEY ( health_history_id ),
	CONSTRAINT health_check_history_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT Hhealth_check_history_entered_by_user_id_fkey FOREIGN KEY (entered_by_user_id)
        REFERENCES release1.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT health_check_history_app_heartbeat_id_fkey FOREIGN KEY (app_heartbeat_id)
        REFERENCES release1.app_heartbeat (app_heartbeat_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT health_check_history_location_id_fkey FOREIGN KEY (location_id)
        REFERENCES release1.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


--Formerly: GeofenceLocation
CREATE  TABLE release1.patient_geofenced_location ( 
	geofenced_location_id integer GENERATED ALWAYS AS IDENTITY NOT NULL ,
	patient_id          integer  NOT NULL ,
	address_id integer   ,
	latitude           numeric(10, 8)   , -- -90 to +90 degrees
	longitude          numeric(11, 8)   , -- -180 to +180 degrees
	radius_metres float8   ,
	geofence_status character varying(32),
	CONSTRAINT geofenced_location_pkey PRIMARY KEY ( geofenced_location_id ),
	CONSTRAINT geofenced_location_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES release1.patient (patient_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT geofenced_location_address_id_fkey FOREIGN KEY (address_id)
        REFERENCES release1.address (address_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

);
