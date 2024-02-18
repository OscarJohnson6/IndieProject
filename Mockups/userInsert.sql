# INSERTs for the table user_profiles in the schema fit_app
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('oscarJ@email.com', 'Oscar', 'Johnson', 'male', '2004-01-27');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth, activity_level) values ('joecoy@email.com', 'Joe', 'Coyne', 'male', '1994-03-07', 'low');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('frensen@email.com', 'Fred', 'Hensen', 'male', '2001-9-25');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('barry@email.com', 'Barney', 'Curry', 'male', '1986-10-16');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('maren@email.com', 'Karen', 'Mack', 'female', '1999-08-14');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('cleandine@email.com', 'Dianne', 'Klein', 'female', '2000-01-2');
insert into user_profiles (userEmail, firstName, lastName, gender, date_of_birth) values ('tilldawn@email.com', 'Dawn', 'Tillman', 'male', '1990-06-05');
insert into user_profiles (userEmail) values ('filler@email.com');
insert into user_profiles (userEmail) values ('test@email.com');

insert into weight_records (userId, weight) values (1, 111);
insert into weight_records (userId, weight) values (1, 123);
insert into weight_records (userId, weight) values (2, 99);

insert into height_records (userId, height) values (1, 111);
insert into height_records (userId, height) values (1, 123);
insert into height_records (userId, height) values (2, 99);

insert into hip_records (userId, hip) values (1, 111);
insert into hip_records (userId, hip) values (1, 123);
insert into hip_records (userId, hip) values (2, 99);

insert into waist_records (userId, waist) values (1, 111);
insert into waist_records (userId, waist) values (1, 123);
insert into waist_records (userId, waist) values (2, 99);
