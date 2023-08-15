create database project;
use project;

CREATE TABLE DoctorDetails(
DId INT PRIMARY KEY, 
DName VARCHAR(25) NOT NULL, 
Qualification varchar(25) NOT NULL, 
Department VARCHAR(25),
RoomNo INT,
PhoneNo VARCHAR(10) NOT NULL,
WorkingHours VARCHAR(15))ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE PatientDetails(
PId INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(20) NOT NULL,
Age INT,
Gender VARCHAR(10),
PhoneNo VARCHAR(10))ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE PatientDetails auto_increment = 1000;

CREATE TABLE Appointment(
AppNo INT PRIMARY KEY AUTO_INCREMENT, 
PId INT, DId INT,
AppDate VARCHAR(10) NOT NULL, 
AppTime VARCHAR(15) NOT NULL)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO DoctorDetails VALUES(101,"Sanjay Singh","MBBS,MD","Cardiology", 203, 8769345211,"10am - 2pm");

Select * from DoctorDetails;

INSERT INTO DoctorDetails VALUES(102,"Param Kumar","MBBS,MD","Cardiology", 206, 9087634522,"10am - 1pm"),
								(103,"Manish Chandra","MBBS,MD","Oncology", 108, 976123423,"2pm - 5pm"),
                                (104,"Swathi Rajput","MBBS","General Medicine", 102, 9456345227,"10am - 4pm"),
                                (105,"Ankita Kapoor","MBBS,MD","Gynaecology", 110, 9663429522,"10am - 1pm");

INSERT INTO DoctorDetails VALUES(106,"Abhin Pankaj","MDS","Dental Surgery", 201, 9345830022,"12pm - 5pm");
INSERT INTO DoctorDetails VALUES(107,"Pooja Sharma","MBBS,MD","Hepatology", 215, 8432303328,"11am - 2pm");

Select * from PatientDetails;

Select * from Appointment;

ALTER TABLE Appointment auto_increment = 100;
