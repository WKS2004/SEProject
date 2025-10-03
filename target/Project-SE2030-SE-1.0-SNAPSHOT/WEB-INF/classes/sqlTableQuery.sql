CREATE TABLE Users (
                       ID char(40) PRIMARY KEY,
                       CreatedAt DateTime ,
                       UpdatedAt DateTime ,
                       Username VarChar(30) UNIQUE,
                       PasswordHash VarChar(100) ,
                       FirstName VarChar(50) ,
                       LastName VarChar(50) ,
                       DisplayName VarChar(100) ,
                       Address VarChar(200) ,
                       Email VarChar(50) UNIQUE,
                       PhoneNumber INT  ,
                       Role VarChar(20) ,
                       ActiveStatus VarChar(10)
);

CREATE TABLE Items (
                       ID char(40) PRIMARY KEY,
                       CreatedAt DateTime ,
                       UpdatedAt DateTime ,
                       Name VarChar(30) UNIQUE,
                       Description VarChar(200) ,
                       Category VarChar(20) ,
                       Price INT ,
                       Quantity INT,
                       AvailableStatus VarChar(10)
);

CREATE TABLE Courses (
                         ID char(40) PRIMARY KEY,
                         CreatedAt DateTime ,
                         UpdatedAt DateTime ,
                         Name VarChar(30) UNIQUE,
                         Code VarChar(20) ,
                         Description VarChar(200) ,
                         DurationMinutes INT ,
                         Price INT ,
                         Level VarChar(20) ,
                         CourseStatus VarChar(10)
);

CREATE TABLE Notifications (
                               ID char(40) PRIMARY KEY,
                               CreatedAt DateTime ,
                               UpdatedAt DateTime ,
                               Title VarChar(30) UNIQUE,
                               Message VarChar(200) ,
                               Type VarChar(20) ,
                               TargetGroups VarChar(60) ,
                               NotificationStatus VarChar(10)
);

CREATE TABLE Payments (
                          ID char(40) PRIMARY KEY,
                          CreatedAt DateTime ,
                          UpdatedAt DateTime ,
                          Amount INT ,
                          Currency INT ,
                          PaymentMethod VarChar(20) ,
                          PaymentStatus VarChar(10)
);