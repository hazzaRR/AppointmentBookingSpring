CREATE TABLE if not exists users (
    ID SERIAL PRIMARY KEY,
    username VARCHAR(40) UNIQUE,
    password VARCHAR(100),
    firstname VARCHAR(40),
    surname VARCHAR(40)
);

CREATE TABLE if not exists client (
     ID SERIAL PRIMARY KEY,
     firstname VARCHAR(40),
     surname VARCHAR(40),
     Email VARCHAR(40) NOT NULL UNIQUE,
     Telephone VARCHAR(20)
);


CREATE TABLE if not exists service (
     ID SERIAL PRIMARY KEY,
     serviceName VARCHAR(40),
     Price NUMERIC(6, 2),
     durationMinutes INTEGER
);

CREATE TABLE appointment (
     ID SERIAL PRIMARY KEY,
     appDate DATE,
     startTime TIME,
     endTime TIME,
     clientID INTEGER NOT NULL,
     TotalPrice NUMERIC(6, 2) DEFAULT 0,
     FOREIGN KEY (ClientID) REFERENCES client(ID),
     CONSTRAINT unique_appointment UNIQUE (appDate, StartTime, EndTime)
);


CREATE TABLE appointmentService (
   ID SERIAL PRIMARY KEY,
   appointmentID INTEGER,
   serviceID INTEGER,
   FOREIGN KEY (serviceID) REFERENCES service(ID),
   FOREIGN KEY (appointmentID) REFERENCES appointment(ID) ON DELETE CASCADE
);
