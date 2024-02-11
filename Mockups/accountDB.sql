# MySQL table schema for indie project FitApp

create schema if not exists fit_app;

use fit_app;

drop table if exists user_profiles;
drop table if exists weight_records;
drop table if exists height_records;
drop table if exists neck_length_records;
drop table if exists waist_length_records;

#
# TABLEs
#
CREATE TABLE user_profiles (
                       userId INT AUTO_INCREMENT PRIMARY KEY,
                       userEmail VARCHAR(50) NOT NULL,
                       firstName VARCHAR(25) NOT NULL,
                       lastName VARCHAR(25) NOT NULL,
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
                               height INTEGER COMMENT 'As inches',
                               entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE neck_length_records (
                                   entryId INT AUTO_INCREMENT PRIMARY KEY,
                                   userId INT NOT NULL,
                                   neck_length INTEGER COMMENT 'As inches',
                                   entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE waist_length_records (
                                    entryId INT AUTO_INCREMENT PRIMARY KEY,
                                    userId INT NOT NULL,
                                    waist_length INTEGER COMMENT 'As inches',
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
ALTER TABLE neck_length_records
    ADD CONSTRAINT Userneck_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);
ALTER TABLE waist_length_records
    ADD CONSTRAINT Userwaist_fk FOREIGN KEY (userId)
        REFERENCES user_profiles (userId);

#
# INDEXEs
#
create index userFirstName_ix
    on user_profiles(firstName);

create index userLastName_ix
    on user_profiles(lastName);

create index weight_ix
    on weight_records(weight);
create index height_ix
    on height_records(height);
create index neck_ix
    on neck_length_records(neck_length);
create index waist_ix
    on waist_length_records(waist_length);
