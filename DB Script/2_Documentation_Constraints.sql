-- CREATE SCRIPTS FOR RELEASE1 SCHEMA


-- TABLE release1.users

ALTER TABLE release1.users ADD CONSTRAINT users_approx_age_yr_check CHECK (age_yrs < 125);

ALTER TABLE release1.users ADD CONSTRAINT users_admin_gender_check CHECK (admin_gender IN ('admingender_male', 'admingender_female', 'admingender_third_gender') );

ALTER TABLE release1.users ADD CONSTRAINT users_bio_sex_check CHECK (biological_sex IN ('biosex_male', 'biosex_female', 'biosex_other') );

ALTER TABLE release1.users ADD CONSTRAINT users_ls_title CHECK (ls_title IN ('title_mr', 'title_ms', 'title_mrs', 'title_miss', 'title_dr', 'title_prof') );

COMMENT ON TABLE release1.users IS 'Contains common information about all users. The two types of users are patients (for the lack fo a better name for those under quarantine, stay at home or isolation) and health professionals - this table contains common information about both types. (Note: ProfilePhoto field has been removed in this version, and a foreign key to the UserPhoto table has been added). ls_* fields are in English 26-character Lain script. ns_* fields are in native script including extended Latin characters.';

COMMENT ON COLUMN release1.users.user_id IS 'Primary key for all users (both patients and health professionals)';

COMMENT ON COLUMN release1.users.ls_title IS 'Title can be Mr, Ms, Mrs, Miss, Dr, Prof, or other regional variations.';

COMMENT ON COLUMN release1.users.ls_first_name IS 'Optional. First name in Latin (English) script if their name was entered in a different language script. This might be entered by an administrative user.';

COMMENT ON COLUMN release1.users.ls_middle_name IS 'Optional. Middle name in Latin (English) script if their name was entered in a different language script. This might be entered by an administrative user.';

COMMENT ON COLUMN release1.users.ls_last_name IS 'Optional. Last name in Latin (English) script if their name was entered in a different language script. This might be entered by an administrative user.';

COMMENT ON COLUMN release1.users.ls_suffix IS 'Optional. Suffix may include I, II, III, Jr, Sr, Esq, etc.';

COMMENT ON COLUMN release1.users.ls_degree IS 'Optional. It is customary to include earned or honorary degrees above the bachelors level. However, for some health care workers (such as nurses), bachelors degrees or fellowships may be included. Do not use periods within a degree - e.g. use ''MD'' instead of ''M.D.'' Separate multiple degrees with commas, e.g. ''MD, PhD''';

COMMENT ON COLUMN release1.users.ls_maiden_name IS 'Optional. Maiden name in Latin (English) script if their name was entered in a different language script. This might be entered by an administrative user.';

COMMENT ON COLUMN release1.users.ls_display_name IS 'Optional. Display name in Latin (English) script if their name was entered in a different language script. This might be entered by an administrative user.';

COMMENT ON COLUMN release1.users.ls_alias_name_1 IS 'Optional. If the person is known by an alternative name, enter the full alternative name.';

COMMENT ON COLUMN release1.users.ls_alias_name_2 IS 'Optional. If the person is known by another alternative name, enter the full alternative name.';

COMMENT ON COLUMN release1.users.ns_title IS 'Optional. Title in native script.';

COMMENT ON COLUMN release1.users.ns_first_name IS 'Optional. First name(s) or Given name(s) in native script';

COMMENT ON COLUMN release1.users.ns_middle_name IS 'Optional. Middle name(s) in native script';

COMMENT ON COLUMN release1.users.ns_last_name IS 'Optional. Last name in native script.';

COMMENT ON COLUMN release1.users.ns_suffix IS 'Optional. Suffix in native script.';

COMMENT ON COLUMN release1.users.ns_degree IS 'Optional. Degrees in native script.';

COMMENT ON COLUMN release1.users.ns_maiden_name IS 'Optional. Maiden name in native script.';

COMMENT ON COLUMN release1.users.ns_display_name IS 'Optional. Display name in native script.';

COMMENT ON COLUMN release1.users.ns_alias_name_1 IS 'Optional. Full alias name 1 in native script.';

COMMENT ON COLUMN release1.users.ns_alias_name_2 IS 'Optional. Full alias name 2 in native script.';

COMMENT ON COLUMN release1.users.standard_name IS 'Standardized full name of the user in the machine readable passport official travel document line 3 format (even if the user does not have a passport) - Uppercase English letters and spaces only. Max length is 30 characters. Surname, followed by two spaces, followed by given names. If there are multiple given (first and middle) names or multiple surnames, they are separated by single spaces.';

COMMENT ON COLUMN release1.users.date_of_birth IS 'Date of birth in YYYY-MM-DD format. If date of birth of an individual is not known, leave it blank and fill the ApproximateAge field instead.';

COMMENT ON COLUMN release1.users.age_yrs IS 'Approximate Age in Years. Used when date of birth is not known.';

COMMENT ON COLUMN release1.users.admin_gender IS 'Required. Administrative Gender - this is how a patient identifies themselves as in social contexts. Supported values are Male, Female and Third Gender. Third Gender may be called ''Other'' (e.g. in HL7) or ''X'' (IATS passport covention) in some contexts.';

COMMENT ON COLUMN release1.users.biological_sex IS 'Optional. The medical or biological sex of an individual, which is useful in a medical context. An exhaustive list of values is not provided, but may be obtained from a clinical terminology such as SNOMED CT. Often left blank if it is male or female, corresponding to the person''s administrative gender.';

COMMENT ON COLUMN release1.users.username IS 'OAuth username for this user. Currently used for health professionals. May be used for patients in the future';

COMMENT ON COLUMN release1.users.comments IS 'Any other comments about this user.';


-- TABLE release1.user_photo

ALTER TABLE release1.user_photo ADD CONSTRAINT user_photo_phototype_check CHECK ( photo_type IN ('phototype_profile', 'phototype_selfie', 'phototype_officialid', 'phototype_other') );

COMMENT ON TABLE release1.user_photo IS 'Photo of an individual. Photos may be stored on the filesystem and the path to that file is stored in this table. An individual may have multiple photos.';

COMMENT ON COLUMN release1.user_photo.photo_type IS 'Type may be ''profile'' (profile photo showed in patient app or health professional dashboard), identity document, selfie, etc. - see CHECK CONSTRAINT. A user MUST have only zero or one profile photo. The user may zero or many photos of other types.';

COMMENT ON COLUMN release1.user_photo.photo_path IS 'File system path where the image file is saved. May be absolute or relative based on the system configuration.';

COMMENT ON COLUMN release1.user_photo.file_saved_datetime IS 'Date and time when this file was saved.';


-- TABLE release1.location_hierarchy

ALTER TABLE release1.location_hierarchy ADD CONSTRAINT location_hierarchy_location_type_check CHECK (location_type in ('locationtype_country', 'locationtype_state', 'locationtype_territory', 'locationtype_province', 'locationtype_county', 'locationtype_district', 'locationtype_taluk', 'locationtype_city', 'locationtype_town', 'locationtype_village', 'locationtype_panchayat', 'locationtype_healthadminoffice', 'locationtype_healthcarefacility', 'locationtype_healthcarefacility') );

COMMENT ON TABLE release1.location_hierarchy IS 'This table contains a hierarchy of all locations in a given country where this system is used. The location type can be country, state/province, county/region, city/town/village, health department (based on their jurisdiction), hospital or laboratory. Locations to which patients can be assigned will have their ''CanAssignPatients'' flag set to true.';

COMMENT ON COLUMN release1.location_hierarchy.location_type IS 'The location type can be country, state/province, county/region, city/town/village, health department (based on their jurisdiction), hospital or laboratory. See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.location_hierarchy.assign_patients IS 'Locations to which patients can be assigned will have their ''CanAssignPatients'' flag set to true.';

COMMENT ON COLUMN release1.location_hierarchy.parent_location_id IS 'Parent location of this location.';

COMMENT ON COLUMN release1.location_hierarchy.country_code IS '2-letter or 3-letter country code from ISO 3166-2';

COMMENT ON COLUMN release1.location_hierarchy.address_id IS 'Foreign key to address table if this location (typically facilities) has a street address';


-- TABLE release1.health_pro

COMMENT ON TABLE release1.health_pro IS 'Contains basic information for all health professionals. Patients will not have a record in this table unless they are also a health professional in this system.';

COMMENT ON COLUMN release1.health_pro.health_pro_job_id  IS 'Autogenerated unique id of a health professional job. A single user may have multiple jobs occasionally, but most will have just 1 job.';

COMMENT ON COLUMN release1.health_pro.user_id  IS 'Foreign key to users.user_id.';

COMMENT ON COLUMN release1.health_pro.supervisor_id  IS 'Supervisor of the current health professional job, may be null. Foreign key to health_pro_job_id in this table';

COMMENT ON COLUMN release1.health_pro.job_title  IS 'Job title (free text)';

COMMENT ON COLUMN release1.health_pro.work_location_id  IS 'Work location is typically a physical/administrative location such as a health care office or facility, but sometimes it may be a geographical location';

COMMENT ON COLUMN release1.health_pro.is_active IS 'If this person does not do this job anymore, then set this to false instead of deleting this row.';


--  TABLE release1.patient

ALTER TABLE release1.patient ADD CONSTRAINT blood_group_check CHECK ( blood_group IN ('bldgrp_o_pos', 'bldgrp_o_neg', 'bldgrp_a_pos', 'bldgrp_a_neg', 'bldgrp_a1_pos', 'bldgrp_a1_neg', 'bldgrp_a2_pos', 'bldgrp_a2_neg', 'bldgrp_b_pos', 'bldgrp_b_neg', 'bldgrp_ab_pos', 'bldgrp_ab_neg', 'bldgrp_a1b_pos', 'bldgrp_a1b_neg', 'bldgrp_a2b_pos', 'bldgrp_a2b_neg', 'bldgrp_other_rare')  );

ALTER TABLE release1.patient ADD CONSTRAINT clinical_trial_status_check CHECK ( clinical_trial_status IN ('clintrial_interested', 'clintrial_enrolled', 'clintrial_notinterested') );

COMMENT ON TABLE release1.patient IS 'Contains basic information for all patients. Patient.PatientID has the same value as User.UserId for performance reasons (to avoid another join in some cases). This table is filled only for patients. Health Professionals will not have a record in this table unless they are under quarantine themselves.';

COMMENT ON COLUMN release1.patient.patient_id IS '*** In the previous version, PatientId was an autogenerated primary key and UserId was a foreign key to User.UserId. In this version, UserId column is deleted from this table, and PatientId is a foreign key to users.UserId';

COMMENT ON COLUMN release1.patient.household_id IS 'Unique id for the household. This is useful for tracing immediate contacts of a person under investigation.';

COMMENT ON COLUMN release1.patient.has_preexisting_conditions IS 'Does this person have a pre-existing condition? If true, refer to the pre_existing_condition and pre_existing_condition_covid_denorm tables.';

COMMENT ON COLUMN release1.patient.has_medications IS 'Is this person on any medications, either for the pre-existing or current health conditions? If true, refer to the medication table.';

COMMENT ON COLUMN release1.patient.has_allergies IS 'Does this person have any environmental, medication or food allergies? If true, refer to the allergy table.';

COMMENT ON COLUMN release1.patient.has_advance_directives IS 'Does this person have any advance directives such as a do not resuscitate (DNR) order or a health care power of attorney or proxy for health care decisions? (On a related note, next of kin and emergency contacts are stored in the demographics table and they should be contacted if the patient does not have an advance directive).';

COMMENT ON COLUMN release1.patient.needs_carer IS 'Does this person need a carer for every day living activities?';

COMMENT ON COLUMN release1.patient.has_international_travel IS 'Has this person traveled internationally recently (in a timeframe specified by the health authorities of this country)?';

COMMENT ON COLUMN release1.patient.has_interstate_travel IS 'Has this person traveled to other states/provinces/territories recently (in a timeframe specified by the health authorities of this country)?';

COMMENT ON COLUMN release1.patient.has_high_risk_facility_visit IS 'Has this person visited a high risk gathering or facility recently (in a timeframe specified by the health authorities of this country)?';

COMMENT ON COLUMN release1.patient.is_high_risk_health_worker IS 'Is this person a health care worker at high risk for this infection?';

COMMENT ON COLUMN release1.patient.blood_group IS 'Blood group of this person. See CHECK CONSTRAINT. Use ''other'' for rare blood groups and enter the detailed blood group in the comments.';

COMMENT ON COLUMN release1.patient.clinical_trial_status IS 'Is this person enrolled for a clinical trial? See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.patient.comments IS 'Any other comments about this person.';


-- TABLE release1.demographics

ALTER TABLE release1.demographics ADD CONSTRAINT Demographics_ResidencyStatus_check CHECK (residency_status IN ('residency_citizen', 'residency_visitor', 'residency_temporary', 'residency_permanent', 'residency_refugee', 'residency_asylee', 'residency_other') );

ALTER TABLE release1.demographics ADD CONSTRAINT Demographics_EContact1RelToPt_check CHECK (emer_contact_1_rel_to_pat IN ('relationship_parent', 'relationship_child', 'relationship_stepparent', 'relationship_stepchild', 'relationship_sibling', 'relationship_grandparent', 'relationship_grandchild', 'relationship_spouse', 'relationship_partner', 'relationship_other_relative', 'relationship_friend', 'relationship_coworker', 'relationship_attorney', 'relationship_medical_poa', 'relationship_other') );

ALTER TABLE release1.demographics ADD CONSTRAINT Demographics_EContact2RelToPt_check CHECK (emer_contact_2_rel_to_pat IN ('relationship_parent', 'relationship_child', 'relationship_stepparent', 'relationship_stepchild', 'relationship_sibling', 'relationship_grandparent', 'relationship_grandchild', 'relationship_spouse', 'relationship_partner', 'relationship_other_relative', 'relationship_friend', 'relationship_coworker', 'relationship_attorney', 'relationship_medical_poa', 'relationship_other') );

ALTER TABLE release1.demographics ADD CONSTRAINT Demographics_NofKin1RelToPt_check CHECK (next_of_kin_1_rel_to_pat IN ('relationship_parent', 'relationship_child', 'relationship_stepparent', 'relationship_stepchild', 'relationship_sibling', 'relationship_grandparent', 'relationship_grandchild', 'relationship_spouse', 'relationship_partner', 'relationship_other_relative', 'relationship_friend', 'relationship_coworker', 'relationship_attorney', 'relationship_medical_poa', 'relationship_other') );

ALTER TABLE release1.demographics ADD CONSTRAINT Demographics_NofKin2RelToPt_check CHECK (next_of_kin_2_rel_to_pat IN ('relationship_parent', 'relationship_child', 'relationship_stepparent', 'relationship_stepchild', 'relationship_sibling', 'relationship_grandparent', 'relationship_grandchild', 'relationship_spouse', 'relationship_partner', 'relationship_other_relative', 'relationship_friend', 'relationship_coworker', 'relationship_attorney', 'relationship_medical_poa', 'relationship_other') );

COMMENT ON TABLE release1.demographics IS 'Additional demographics about an individual. This table is usually populated for patients. It is optional for health professionals.';

COMMENT ON COLUMN release1.demographics.user_id IS 'Primary key. Also foreign key to user.user_id (which is the same value as patient.patient_id or health_pro.health_pro_job_id)';

COMMENT ON COLUMN release1.demographics.nationality IS '2-letter or 3-letter country code from ISO 3166-2. If this person has multiple citizenships, choose the one that they used to enter this country.';

COMMENT ON COLUMN release1.demographics.residency_status IS 'Residency status of this person in this country. See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.demographics.occupation IS 'Occupation of this person (free text)';

COMMENT ON COLUMN release1.demographics.emergency_contact_id_1 IS 'User id of emergency contact 1 to this patient. Foreign key to user.user_id. If foreign key not present, then use free text comments.';

COMMENT ON COLUMN release1.demographics.emer_contact_1_rel_to_pat IS 'Relationship to patient. See CHECK CONSTRAINT. If other is chosen, then enter free text comments';

COMMENT ON COLUMN release1.demographics.emergency_contact_id_2 IS 'User id of emergency contact 2 to this patient. Foreign key to user.user_id. If foreign key not present, then use free text comments.';

COMMENT ON COLUMN release1.demographics.emer_contact_2_rel_to_pat IS 'Relationship to patient. See CHECK CONSTRAINT. If other is chosen, then enter free text comments';

COMMENT ON COLUMN release1.demographics.next_of_kin_id_1 IS 'User id of next of kin 1 to this patient. Foreign key to user.user_id. If foreign key not present, then use free text comments.';

COMMENT ON COLUMN release1.demographics.next_of_kin_1_rel_to_pat IS 'Relationship to patient. See CHECK CONSTRAINT. If other is chosen, then enter free text comments';

COMMENT ON COLUMN release1.demographics.next_of_kin_id_2 IS 'User id of next of kin 2 to this patient. Foreign key to user.user_id. If foreign key not present, then use free text comments.';

COMMENT ON COLUMN release1.demographics.next_of_kin_2_rel_to_pat IS 'Relationship to patient. See CHECK CONSTRAINT. If other is chosen, then enter free text comments';

COMMENT ON COLUMN release1.demographics.comments IS 'Other comments about this person.';


-- TABLE release1.patient_provider_rel

ALTER TABLE release1.patient_provider_rel ADD CONSTRAINT patient_provider_rel_rel_type_check CHECK (rel_type IN ('patproreltype_screening_officer', 'patproreltype_quarantine_officer', 'patproreltype_isolation_officer', 'patproreltype_physician', 'patproreltype_nurse', 'patproreltype_labtech', 'patproreltype_field_worker', 'patproreltype_homehealth', 'patproreltype_other') );

COMMENT ON TABLE release1.patient_provider_rel IS 'Relationship between a patient and a health professional (also known as health care provider or simply ''provider'') when they provide care to a patient. Care in this context includes quarantine/isolation service to the patient. Only providers with a patient-provider relationship can view personally identifiable information or protected health information of a patient through the health professional dashboard. Other health professionals can only view summary statistics and reports.';

COMMENT ON COLUMN release1.patient_provider_rel.rel_type IS 'Type of relationship. Constrained by CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.patient_provider_rel.rel_start_date IS 'Optional.';

COMMENT ON COLUMN release1.patient_provider_rel.rel_end_date IS 'Optional.';

COMMENT ON COLUMN release1.patient_provider_rel.location_id IS 'Foreign key to Location that is pertinent to this relationship. This may be a local health department or a hospital, etc.';


-- TABLE release1.covid_contact

COMMENT ON TABLE release1.covid_contact IS 'Contact tracing table. Currently not implemented';

-- TABLE release1.email_address
ALTER TABLE release1.email_address ADD CONSTRAINT email_address_email_address_type_check CHECK ( email_address_type in ('email_personal', 'email_home', 'email_work', 'email_other') );

COMMENT ON TABLE release1.email_address IS 'Email address of the user. Optional for patients. Optional but highly recommended for health professionals to have at least one email address.';

COMMENT ON COLUMN release1.email_address.email_address IS 'Email address of the user , their household/family member or their work or their office.';

COMMENT ON COLUMN release1.email_address.email_address_type IS 'Email address type. See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.email_address.is_preferred IS 'Required. A user may have only one preferred email address (across all email types - work, personal, etc.)';

COMMENT ON COLUMN release1.email_address.is_primary_user IS 'Is this person the primary user of the email address? If the user is a child or elderly person and the email address belongs to another family/household member, or if this email address is that of an office, this field may be set to false.';

COMMENT ON COLUMN release1.email_address.primary_user_id IS 'If ''IsPrimaryUser'' is false, then enter the user id of the primary user of this email address if possible.';


--  TABLE release1.phone_number

ALTER TABLE release1.phone_number ADD CONSTRAINT PhoneNumber_PhoneType_check CHECK (phone_type IN ('phone_mobile', 'phone_home', 'phone_work', 'phone_other') );

COMMENT ON TABLE release1.phone_number IS 'Phone number of the user - for both patients and health professionals';

COMMENT ON COLUMN release1.phone_number.phone_number IS 'Phone number of the user. A user may have one or more phone numbers. If they do not have their own phone number, enter the family number of their family/household member or office.';

COMMENT ON COLUMN release1.phone_number.phone_type IS 'Phone type. See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.phone_number.is_preferred IS 'Required. A user may have only one preferred phone number (across all email types - work, personal, etc.)';

COMMENT ON COLUMN release1.phone_number.is_primary_user IS 'Is this person the primary user of the phone number? If the user is a child or elderly person and the phone number belongs to another family/household member, or if this phone number is that of a residence/office, this field may be set to false.';

COMMENT ON COLUMN release1.phone_number.primary_user_id IS 'Optional. If ''IsPrimaryUser'' is false, then enter the user id of the primary user of this phone number if possible.';

COMMENT ON COLUMN release1.phone_number.has_internet IS 'Optional. Default is false, even for mobile numbers. Assumed to be false, but update it to true if the patient installs an app using a number and the app connects to the server successfully using either cellular or wifi internet.';

COMMENT ON COLUMN release1.phone_number.has_sms IS 'Optional. Assumed to be true for mobile numbers.';

COMMENT ON COLUMN release1.phone_number.has_whatsapp IS 'Optional. Whether the user has a WhatsApp app account using this number on a smart phone. Default is false, even for mobile numbers.';

COMMENT ON COLUMN release1.phone_number.has_telegram IS 'Optional. Whether the user has a Telegram app account using this number on a smart phone. Default is false, even for mobile numbers.';

COMMENT ON COLUMN release1.phone_number.provides_location IS 'Optional. Whether this phone number is that of a phone that has location (GPS) service. Assumed to be false, but update it to true if the patient installs an app using a number and the app reports location information.';

COMMENT ON COLUMN release1.phone_number.otp_code IS 'One time password from the SMS (text message) or email-based two factor authentication system.';

COMMENT ON COLUMN release1.phone_number.phone_hash IS 'Security key for the mobile device with this phone number.';


--  TABLE release1.address
ALTER TABLE release1.address ADD CONSTRAINT address_address_type_check CHECK ( address_type IN ('address_temporary_residence', 'address_permanent_residence', 'address_work', 'address_other') );

COMMENT ON TABLE release1.address IS 'Address of the user - for both patients and health professionals. Each user must have at least one address';

COMMENT ON COLUMN release1.address.address_type IS 'Address type. See CHECK CONSTRAINT.';


--  TABLE release1.external_identifier
ALTER TABLE release1.external_identifier ADD CONSTRAINT external_identifier_id_type CHECK ( id_type IN ('id_passport', 'id_driving_license', 'id_national_id', 'id_tax_id', 'id_medical_license_num', 'id_pancard_num_in', 'id_aadhaar_num_in', 'id_oci_num_in', 'id_ssn_us', 'id_mrn', 'id_patientid_num', 'id_other') );

COMMENT ON TABLE release1.external_identifier IS 'External identifiers such as driving license numbers, passport numbers, national identity numbers, hospital medical record numbers or other externally assigned numbers, medical license numbers or national prescriber numbers. A single individual may have multiple external identifiers.';

COMMENT ON COLUMN release1.external_identifier.identification_id IS 'Primary key, autogenerated.';

COMMENT ON COLUMN release1.external_identifier.user_id IS 'User (patient or health professional) to which this external identifier belongs.';

COMMENT ON COLUMN release1.external_identifier.id_type IS 'Driving license number, passport number, national identifier number, medical license number, medical record number or another type of external identifier - specified using a check constraint.';

COMMENT ON COLUMN release1.external_identifier.id_type_uri IS 'Currently not used.';

COMMENT ON COLUMN release1.external_identifier.issuing_authority_name IS 'For driving license or medical license, enter the country and/or state acronyms. For passport or national identifier number, enter the country acronym.';

COMMENT ON COLUMN release1.external_identifier.issuing_authority_id IS 'Currently unused.';

COMMENT ON COLUMN release1.external_identifier.issuing_authority_uri IS 'Currently unused.';

COMMENT ON COLUMN release1.external_identifier.id_number IS 'Actual identifier of the individual, such as the passport number, driving license number, medical license number, national identifier, medical record number, etc.';

COMMENT ON COLUMN release1.external_identifier.issue_date IS 'Optional. Date of issue of the external identifier. May be used for documents with issue dates such as passport number or driving license number.';

COMMENT ON COLUMN release1.external_identifier.expiry_date IS 'Optional. Date of expiration of the external identifier. May be used for documents with expiry dates such as passport number or driving license number.';

-- TABLE release1.pre_existing_condition

ALTER TABLE release1.pre_existing_condition ADD CONSTRAINT pre_existing_condition_duration_units_check CHECK (duration_units IN ('duration_days', 'duration_weeks', 'duration_months', 'duration_years') );

COMMENT ON TABLE release1.pre_existing_condition IS 'Currently unused. \nAll preexisting health conditions of this patient.';


-- TABLE release1.pre_existing_condition_covid_denorm

COMMENT ON TABLE release1.pre_existing_condition_covid_denorm IS 'Currently unused. \nSpecific preexisting health conditions that are risk factors for COVID-19.';


-- TABLE release1.allergy

ALTER TABLE release1.allergy ADD CONSTRAINT allergy_allergen_type_check CHECK (allergen_type IN ('allergy_food', 'allergy_drug', 'allergy_environmental') );

ALTER TABLE release1.allergy ADD CONSTRAINT allergy_allergy_severity_check CHECK (allergy_severity IN ('severity_mild', 'severity_moderate', 'severity_severe') );

ALTER TABLE release1.allergy ADD CONSTRAINT allergy_duration_units_check CHECK (duration_units IN ('duration_days', 'duration_weeks', 'duration_months', 'duration_years') );

COMMENT ON TABLE release1.allergy IS 'Currently unused. The patient''s food, drug or environmental allergies.';

COMMENT ON COLUMN release1.allergy.allergen_type IS 'Food, drug or environmental. See CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.allergy.allergen_code_system IS 'Usually SNOMED CT. Currently unused.';


-- TABLE release1.medication

ALTER TABLE release1.medication ADD CONSTRAINT medication_duration_units_check CHECK (duration_units IN ('duration_days', 'duration_weeks', 'duration_months', 'duration_years') );

ALTER TABLE release1.medication ADD CONSTRAINT medication_intent_check CHECK (intent_type IN ('rxintent_prophylaxis', 'rxintent_treatment', 'rxintent_adjuant', 'rxintent_trial', 'rxintent_other') );

COMMENT ON TABLE release1.medication IS 'Currently unused. \nAll medications of this patient, including medications that the patient was taking before quarantine/isolation started as well as those that were prescribed during quarantine/isolation. Includes both prescription and non-prescription medications.';


-- TABLE release1.patient_status

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_quarislt_status_check CHECK (quar_islt_status IN ('quarislt_none', 'quarislt_quar_med', 'quarislt_quar_self', 'quarislt_stayhome', 'quarislt_quar_ended', 'quarislt_quar_temp_leave', 'quarislt_isolated', 'quarislt_islt_ended', 'quarislt_hospitalized') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_quarislt_request_status_check CHECK (quar_islt_request_status IN ('request_none', 'request_open', 'request_inprogress', 'request_completed') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_medical_request_status_check CHECK (medical_request_status IN ('request_none', 'request_open', 'request_inprogress', 'request_completed') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_supplies_request_status_check CHECK (supplies_request_status IN ('request_none', 'request_open', 'request_inprogress', 'request_completed') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_covid19_status_check CHECK (covid19_status IN ('seir_susceptible', 'seir_exposed', 'seir_infected', 'seir_recovered', 'seir_deceased') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_health_alert_status_check CHECK (health_status IN ('health_asymptomatic', 'health_symptomatic', 'health_severe') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_geofence_status_check CHECK (geofence_status IN ('geofence_inside', 'geofence_inside_near', 'geofence_outside_far', 'geofence_unknown') );

ALTER TABLE release1.patient_status ADD CONSTRAINT patient_status_app_heartbeat_status_check CHECK (app_heartbeat_status IN ('appheartbeat_online', 'appheartbeat_offline') );

COMMENT ON TABLE release1.patient_status IS 'Current status of the patient. It creates a snapshot based on data from multiple other tables.';

COMMENT ON COLUMN release1.patient_status.patient_id IS 'Foreign key to patient.patient_id';

COMMENT ON COLUMN release1.patient_status.covid19_status IS 'Is the patient susceptible (not exposed), exposed, infected (either symptomatic or asymptomatic, with positive clinical or lab diagnosis), recocered (clinical or lab diagnosis), or deceased (from any cause)';

COMMENT ON COLUMN release1.patient_status.health_status IS 'Asymptomatic, symptomatic or severely symptomatic for COVID-19 or other illnesses.';

COMMENT ON COLUMN release1.patient_status.quar_islt_status IS '*** In the previous version, QuarantineStatus and IsolationStatus were separate fields. Now, they are merged into a single field with a superset of values since a person may be under quarantine (when disease is not confirmed) or isolation (when disease is confirmed) at a given time, but not both at the same time.';

COMMENT ON COLUMN release1.patient_status.quar_islt_start_date_time IS '*** In the previous version, QuarantineStartDate and IsolationStartDate were separate fields. Now, they are merged into a single field since quarantine and isolation are mutually exclusive.';

COMMENT ON COLUMN release1.patient_status.quar_islt_end_date_time IS '*** In the previous version, QuarantineEndDate and IsolationEndDate were separate fields. Now, they are merged into a single field since quarantine and isolation are mutually exclusive.';

COMMENT ON COLUMN release1.patient_status.quar_islt_request_status IS '*** Formerly ''Quarantine Request Status''. Did this patient submit a request to their quarantine officer (typically, through the mobile app)?';

COMMENT ON COLUMN release1.patient_status.medical_request_status IS 'Did this patient submit a medical request (typically, through the mobile app)?';

COMMENT ON COLUMN release1.patient_status.supplies_request_status IS 'Did this patient submit a request for emergency food, water or medical supplies (typically, through the mobile app)?';

COMMENT ON COLUMN release1.patient_status.geofence_status IS 'Is this patient compliant (i.e. within) their geofence during the last check?';

COMMENT ON COLUMN release1.patient_status.app_heartbeat_status IS 'Is the patient''s cellphone app online or offline during the last check?';

COMMENT ON COLUMN release1.patient_status.updated_date_time IS 'When was this status row last updated?';

COMMENT ON COLUMN release1.patient_status.latitude IS 'Latest known location of the patient''s mobile device.';

COMMENT ON COLUMN release1.patient_status.longitude IS 'Latest known location of the patient''s mobile device.';


-- TABLE release1.device_location

ALTER TABLE release1.device_location ADD CONSTRAINT device_location_location_service_type_check CHECK (location_service_type IN ('locservoce_gps', 'locservice_highres', 'locservice_cellular', 'locservice_other') );

ALTER TABLE release1.device_location ADD CONSTRAINT device_location_LocationCheckReason_check CHECK (location_check_reason IN ('loccheck_reason_routine', 'locchec_reason_device_idle', 'loccheck_reason_random',  'loccheck_reason_other') );

ALTER TABLE release1.device_location ADD CONSTRAINT device_location_LocationCheckResult_check CHECK (location_check_result IN ('loccheck_result_success', 'loccheck_result_failed', 'loccheck_result_delayedresponse') );

ALTER TABLE release1.device_location ADD CONSTRAINT device_location_geofence_status_check CHECK (geofence_status IN ('geofence_inside', 'geofence_inside_near', 'geofence_outside_far', 'geofence_unknown') );

COMMENT ON TABLE release1.device_location IS 'Device location captured periodically captured by the application at specified time intervals. It may also be captured when the patient fills out their health history updates.';

COMMENT ON COLUMN release1.device_location.address_id IS 'Foreign key to the postal address of this location.';

COMMENT ON COLUMN release1.device_location.location_service_type IS 'GPS (from the device), high resolution (a combination of cellular, bluetooth or wifi, captured by the device), cellular (reported by the cellular company, for a future version), or ''other''. Constrained using a CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.device_location.location_check_reason IS 'Is it routine (time interval), health update history, or other. Constrained using a CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.device_location.location_check_result IS 'Did the location check succeed (location captured successfully) or failed (location was not reported - perhaps location service turned off on the mobile device?).';

COMMENT ON COLUMN release1.device_location.geofence_status IS 'Is the patient within the geofenced location/radius?';

COMMENT ON COLUMN release1.device_location.geofence_action IS 'Currently unused. What action was taken by health authorities if the patient was outside their geofence.';


--  TABLE release1.patient_request_history

ALTER TABLE release1.patient_request_history ADD CONSTRAINT patient_request_history_request_type_check CHECK (request_type IN ('request_quarantine', 'request_medical', 'request_supplies') );

ALTER TABLE release1.patient_request_history ADD CONSTRAINT patient_request_history_request_status_check CHECK (request_status IN ('request_none', 'request_open', 'request_inprogress', 'request_completed') );

ALTER TABLE release1.patient_request_history ADD CONSTRAINT patient_request_history_ResponseType_check CHECK (response_type IN ('response_phone', 'response_video', 'response_inperson', 'response_sms', 'response_whatsapp', 'response_telegram', 'response_covenant', 'response_telehealth', 'response_other') );

COMMENT ON TABLE release1.patient_request_history IS 'A patient''s requets regarding their quarantine/isolation, medical questions/concerns, or requests for emergency supplies (food, water, medicines). Each of these three types of requets may be addressed by same or different health professionals who support their local health departments.';

COMMENT ON COLUMN release1.patient_request_history.request_type IS 'Request type - quarantine/isolation, medical or supplies. See CHECK CONSTRAINT';

COMMENT ON COLUMN release1.patient_request_history.response_type IS 'Response type - mode of communication. See CHECK CONSTRAINT';

-- TABLE release1.phone_device_app

ALTER TABLE release1.phone_device_app ADD CONSTRAINT phone_device_app_device_os_check CHECK (device_os IN ('device_os_android', 'device_os_ios', 'device_os_other') );

COMMENT ON TABLE release1.phone_device_app IS 'Smart phones on which a patient may install the mobile app.';

COMMENT ON COLUMN release1.phone_device_app.phone_number_id IS 'Primary key of the phone number record for this device.';

COMMENT ON COLUMN release1.phone_device_app.device_imei IS 'IMEI number that uniquely identifies the phone handset.';

COMMENT ON COLUMN release1.phone_device_app.device_mac_id IS 'Optional. MAC ID of the network device on the phone. Need to define which network interface this pertains to.';

COMMENT ON COLUMN release1.phone_device_app.device_os IS 'OS for smart phones - Android, iOS, other. See CHECK CONSTRAINT';

COMMENT ON COLUMN release1.phone_device_app.device_os_version IS 'Device OS version if known.';

COMMENT ON COLUMN release1.phone_device_app.device_manufacturer IS 'Device manufacturer, if known.';

COMMENT ON COLUMN release1.phone_device_app.device_model IS 'Device model number, if known.';

COMMENT ON COLUMN release1.phone_device_app.device_phone_number IS 'Phone number of the device. Denormalization of the phone number record for this device.';

COMMENT ON COLUMN release1.phone_device_app.device_phone_service_provider IS 'Company that provides the cellular service for this device.';

COMMENT ON COLUMN release1.phone_device_app.app_version IS 'Version of the Covenant app installed on this phone.';

COMMENT ON COLUMN release1.phone_device_app.app_installed_date_time IS 'Last updated date/time when the Covenant app was installed or updated.';


-- TABLE release1.app_heartbeat

ALTER TABLE release1.app_heartbeat ADD CONSTRAINT app_heartbeat_heartbeat_status_check CHECK (heartbeat_status IN ('appheartbeat_online', 'appheartbeat_offline') );

COMMENT ON TABLE release1.app_heartbeat IS 'App heart beat (whether the app/device is online or offline) - captured automatically when the app reports its periodic location or the user submits health status through the app. Heart beat will not be captured if the device is offline (turned off, airplane mode or does not have internet access).';

COMMENT ON COLUMN release1.app_heartbeat.app_heartbeat_id IS 'Primary key, autogenerated.';

COMMENT ON COLUMN release1.app_heartbeat.device_app_id IS 'Foreign key to DeviceAppId of this device.';

COMMENT ON COLUMN release1.app_heartbeat.heartbeat_ip4_address IS 'IP (v4) Address';

COMMENT ON COLUMN release1.app_heartbeat.heartbeat_ip6_address IS 'IP (v6) Address';

COMMENT ON COLUMN release1.app_heartbeat.heartbeat_status IS 'Online or Offline. See CHECK CONSTRAINT';


-- TABLE release1.health_check_history 

ALTER TABLE release1.health_check_history ADD CONSTRAINT health_check_history_healthcheck_by_user_type_check CHECK (health_check_by_user_type IN ('healthcheck_by_app_pri_user', 'healthcheck_by_app_sec_user', 'healthcheck_by_health_pro', 'healthcheck_by_other') );

ALTER TABLE release1.health_check_history ADD CONSTRAINT health_check_history_healthcheck_reason_check CHECK (health_check_reason IN ('healthcheck_reason_routine', 'healthcheck_reason_device_idle', 'healthcheck_reason_user_init', 'healthcheck_reason_pro_init', 'healthcheck_reason_other') );

ALTER TABLE release1.health_check_history ADD CONSTRAINT health_check_history_progressstatus_check CHECK (progress_status IN ('healthprogress_getting_better', 'healthprogress_getting_worse', 'healthprogress_getting_same') );

COMMENT ON TABLE release1.health_check_history IS 'Health check history collected via the mobile app - the patient is prompted to fill in their current health status. Typically this is done twice a day at 10AM and 8PM. It may be done more frequently if the patient''s device hasn''t moved for approximately 2 hours. The patient may also fill in at other times if they want to.';

COMMENT ON COLUMN release1.health_check_history.patient_id IS 'PatientId to whom this health history applies.';

COMMENT ON COLUMN release1.health_check_history.entered_by_user_id IS 'UserId of the logged in user of the mobile app. May be different from UserId if the health history belongs to a child, elderly or incapacitated person.';

COMMENT ON COLUMN release1.health_check_history.health_check_by_user_type IS 'Type of user who documented this health check. Options are:\n''primary'' - done via app by primary user of the app (patient), \n''secondary'' - a patient''s helath history done by a differnt user (family/household member or carer) who logged on to the app, \n''health professional'' (via any application), or \n''other'' - any other unspecified user or application type. \nAllowed values are constrained by a CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.health_check_history.app_heartbeat_id IS 'Foreign key to App HeartBeat that is automatically captured when health history is filled out.';

COMMENT ON COLUMN release1.health_check_history.location_id IS 'Foreign key to device location that is automatically captured when health history is filled out.';

COMMENT ON COLUMN release1.health_check_history.health_check_reason IS 'Reason for this health check - routine, device idle for a certain amount of time, or ad hoc by the patient. Constrained by a CHECK CONSTRAINT.';

COMMENT ON COLUMN release1.health_check_history.progress_status IS 'Is the patient''s health getting better, worse or staying the same since the last health check (previous day or the same day).';

COMMENT ON COLUMN release1.health_check_history.temperature_celsius IS 'Temperature in celsius. If the app allows entry in Fahrenheit, unit conversion must be done on the client side (app).';


-- TABLE release1.patient_geofenced_location

COMMENT ON TABLE release1.patient_geofenced_location IS 'The location where the patient is supposed to stay during their quarantine/isolation. This is first captured when the patient presses ''Update Location'' for the first time during their quarantine/isolation. Business rules need to be defined by health officials whether this can be changed.';

COMMENT ON COLUMN release1.patient_geofenced_location.patient_id IS 'PatientId is typically the primary user of the mobile device. We need to define how the geofence location of additional users (e.g. children or elderly) will be captured.';

COMMENT ON COLUMN release1.patient_geofenced_location.address_id IS 'Foreign key to the street address of this location.';

COMMENT ON COLUMN release1.patient_geofenced_location.radius_metres IS 'Default is 15 metres (50 feet)';
