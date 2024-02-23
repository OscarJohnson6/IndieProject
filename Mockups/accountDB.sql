# MySQL table schema for indie project FitApp
DROP SCHEMA IF EXISTS fit_app;

create schema if not exists fit_app;

use fit_app;

drop table if exists user_profiles;
drop table if exists weight_records;
drop table if exists height_records;
drop table if exists hip_records;
drop table if exists waist_records;

#
# TABLEs
#
CREATE TABLE user_profiles (
                       userId INT AUTO_INCREMENT PRIMARY KEY,
                       userEmail VARCHAR(75) NOT NULL,
                       firstName VARCHAR(25) NULL,
                       lastName VARCHAR(25) NULL,
                       gender VARCHAR(8) NULL,
                       date_of_birth DATE NULL,
                       activity_level VARCHAR(10) NULL,
                       entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE weight_records (
                               entryId INT AUTO_INCREMENT PRIMARY KEY,
                               userId INT NOT NULL,
                               weight INTEGER NOT NULL COMMENT 'As kg',
                               entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE height_records (
                               entryId INT AUTO_INCREMENT PRIMARY KEY,
                               userId INT NOT NULL,
                               height INTEGER NOT NULL COMMENT 'As cm',
                               entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE hip_records (
                                   entryId INT AUTO_INCREMENT PRIMARY KEY,
                                   userId INT NOT NULL,
                                   hip INTEGER NOT NULL COMMENT 'As cm',
                                   entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE waist_records (
                                    entryId INT AUTO_INCREMENT PRIMARY KEY,
                                    userId INT NOT NULL,
                                    waist INTEGER NOT NULL COMMENT 'As cm',
                                    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

#
# CONSTRAINTs
#
ALTER TABLE weight_records
    ADD CONSTRAINT Userweight_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);
ALTER TABLE height_records
    ADD CONSTRAINT Userheight_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);
ALTER TABLE hip_records
    ADD CONSTRAINT Userhip_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);
ALTER TABLE waist_records
    ADD CONSTRAINT Userwaist_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);

#
# INDEXEs
#
create index useEmail_ix
    on user_profiles(userEmail);
create index userFirstName_ix
    on user_profiles(firstName);
create index userLastName_ix
    on user_profiles(lastName);
create index userGender_ix
    on user_profiles(gender);

create index weight_ix
    on weight_records(weight);
create index height_ix
    on height_records(height);
create index hip_ix
    on hip_records(hip);
create index waist_ix
    on waist_records(waist);
