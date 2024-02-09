# MySQL table schema for indie project FitApp

create schema if not exists fit_app;

use fit_app;

drop table if exists Users;
drop table if exists WeightEntries;
drop table if exists HeightEntries;
drop table if exists NeckLengthEntries;
drop table if exists WaistLengthEntries;


CREATE TABLE Users (
                       userId INT AUTO_INCREMENT PRIMARY KEY,
                       userEmail VARCHAR(50) NOT NULL,
                       firstName VARCHAR(25) NOT NULL,
                       lastName VARCHAR(25) NOT NULL,
                       entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE WeightEntries (
                               entryId INT AUTO_INCREMENT PRIMARY KEY,
                               userId INT NOT NULL,
                               weight FLOAT NOT NULL,
                               entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE HeightEntries (
                               entryId INT AUTO_INCREMENT PRIMARY KEY,
                               userId INT NOT NULL,
                               height INTEGER,
                               entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE NeckLengthEntries (
                                   entryId INT AUTO_INCREMENT PRIMARY KEY,
                                   userId INT NOT NULL,
                                   neck_length INTEGER,
                                   entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE WaistLengthEntries (
                                    entryId INT AUTO_INCREMENT PRIMARY KEY,
                                    userId INT NOT NULL,
                                    waist_length INTEGER,
                                    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

#
# CONSTRAINTs
#
ALTER TABLE WeightEntries
    ADD CONSTRAINT Userweight_fk FOREIGN KEY (userId)
        REFERENCES Users (userId);
ALTER TABLE HeightEntries
    ADD CONSTRAINT Userheight_fk FOREIGN KEY (userId)
        REFERENCES Users (userId);
ALTER TABLE NeckLengthEntries
    ADD CONSTRAINT Userneck_fk FOREIGN KEY (userId)
        REFERENCES Users (userId);
ALTER TABLE WaistLengthEntries
    ADD CONSTRAINT Userwaist_fk FOREIGN KEY (userId)
        REFERENCES Users (userId);


#
# Indexes
#
create index UserFirstName_ix
    on Users(firstName);

create index UserLastName_ix
    on Users(lastName);

create index weight_ix
    on WeightEntries(weight);
create index height_ix
    on HeightEntries(height);
create index neck_ix
    on NeckLengthEntries(neck_length);
create index waist_ix
    on WaistLengthEntries(waist_length);
