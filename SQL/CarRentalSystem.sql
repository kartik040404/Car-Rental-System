create database CarRentalSystem;

use CarRentalSystem;

show tables;

-- Vehicle table
create table Vehicle (
    vehicleID int primary key auto_increment,
    make varchar(50) not null,
    model varchar(50) not null,
    year int not null,
    dailyRate numeric(10,2) not null,
    status enum('Available', 'Not Available') not null,
    passengerCapacity int not null,
    engineCapacity numeric(5,2) not null
);

-- Customer table
create table Customer (
    customerID int primary key auto_increment,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    email varchar(100) unique not null,
    phoneNumber varchar(15) unique not null
);

-- Lease table
create table Lease (
    leaseID int primary key auto_increment,
    vehicleID int not null,
    customerID int not null,
    startDate date not null,
    endDate date not null,
    type enum('Daily Lease', 'Monthly Lease'),
    foreign key (vehicleID) references Vehicle(vehicleID) on update cascade on delete cascade,
    foreign key (customerID) references Customer(customerID) on update cascade on delete cascade
);

-- Payment table
create table Payment (
    paymentID int primary key auto_increment,
    leaseID int not null,
    paymentDate date not null,
    amount numeric(10,2) not null,
    foreign key (leaseID) references Lease(leaseID) on update cascade on delete cascade
);

-- Insert data into Vehicle table
insert into Vehicle (make, model, year, dailyRate, status, passengerCapacity, engineCapacity) values
('Toyota', 'Corolla', 2022, 50.00, 'Available', 5, 1.80),
('Honda', 'Civic', 2021, 55.00, 'Not Available', 5, 2.00),
('Ford', 'Focus', 2020, 48.00, 'Available', 5, 1.60),
('Chevrolet', 'Malibu', 2019, 52.00, 'Available', 5, 2.40),
('Nissan', 'Altima', 2023, 60.00, 'Available', 5, 2.50),
('BMW', 'X5', 2022, 120.00, 'Not Available', 7, 3.00),
('Mercedes', 'C-Class', 2021, 110.00, 'Available', 5, 2.80),
('Tesla', 'Model 3', 2023, 90.00, 'Available', 5, 0.00),
('Audi', 'A4', 2020, 85.00, 'Not Available', 5, 2.00),
('Hyundai', 'Elantra', 2018, 40.00, 'Available', 5, 1.60);

-- Insert data into Customer table
insert into Customer (firstName, lastName, email, phoneNumber) values
('John', 'Doe', 'johndoe@example.com', '1234567890'),
('Jane', 'Smith', 'janesmith@example.com', '0987654321'),
('Michael', 'Brown', 'michaelbrown@example.com', '1122334455'),
('Emily', 'Johnson', 'emilyjohnson@example.com', '5566778899'),
('David', 'Williams', 'davidwilliams@example.com', '6677889900'),
('Sarah', 'Davis', 'sarahdavis@example.com', '7788990011'),
('Chris', 'Miller', 'chrismiller@example.com', '8899001122'),
('Jessica', 'Wilson', 'jessicawilson@example.com', '9900112233'),
('Daniel', 'Taylor', 'danieltaylor@example.com', '1231231234'),
('Sophia', 'Anderson', 'sophiaanderson@example.com', '9876543210');

-- Insert data into Lease table
insert into Lease (vehicleID, customerID, startDate, endDate, type) values
(1, 1, '2024-03-01', '2024-03-05', 'DailyLease'),
(2, 2, '2024-03-10', '2024-03-20', 'Monthly Lease'),
(3, 3, '2024-03-15', '2024-03-18', 'Daily Lease'),
(4, 4, '2024-03-05', '2024-03-25', 'Monthly Lease'),
(5, 5, '2024-03-12', '2024-03-17', 'Daily Lease'),
(6, 6, '2024-03-20', '2024-04-20', 'Monthly Lease'),
(7, 7, '2024-03-30', '2024-04-05', 'Daily Lease'),
(8, 8, '2024-04-02', '2024-04-15', 'Monthly Lease'),
(9, 9, '2024-04-10', '2024-04-12', 'Daily Lease'),
(10, 10, '2024-04-15', '2024-05-15', 'Monthly Lease');

-- Insert data into Payment table
insert into Payment (leaseID, paymentDate, amount) values
(1, '2024-03-01', 250.00),
(2, '2024-03-10', 1100.00),
(3, '2024-03-15', 144.00),
(4, '2024-03-05', 1040.00),
(5, '2024-03-12', 300.00),
(6, '2024-03-20', 3600.00),
(7, '2024-03-30', 770.00),
(8, '2024-04-02', 1350.00),
(9, '2024-04-10', 170.00),
(10, '2024-04-15', 2700.00);

select * from customer;
select * from lease;
select * from payment;
select * from vehicle;
