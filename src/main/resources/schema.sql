CREATE TABLE if not exists users (
    ID BIGSERIAL PRIMARY KEY,
    username VARCHAR UNIQUE,
    password VARCHAR,
    firstname VARCHAR,
    surname VARCHAR,
    role VARCHAR
);

CREATE TABLE if not exists client (
     ID BIGSERIAL PRIMARY KEY,
     firstname VARCHAR,
     surname VARCHAR,
     Email VARCHAR NOT NULL UNIQUE,
     Telephone VARCHAR
);


CREATE TABLE if not exists service (
     ID BIGSERIAL PRIMARY KEY,
     serviceName VARCHAR,
     Price NUMERIC,
     durationMinutes INTEGER
);

CREATE TABLE if not exists appointment (
     ID BIGSERIAL PRIMARY KEY,
     appDate DATE,
     startTime TIME,
     endTime TIME,
     clientID BIGINT NOT NULL,
     TotalPrice NUMERIC,
     status VARCHAR,
     paymentType VARCHAR,
     FOREIGN KEY (ClientID) REFERENCES client(ID),
     CONSTRAINT unique_appointment UNIQUE (appDate, StartTime, EndTime)
);


CREATE TABLE if not exists appointment_service (
   ID BIGSERIAL PRIMARY KEY,
   appointmentID BIGINT,
   serviceID BIGINT,
   FOREIGN KEY (serviceID) REFERENCES service(ID),
   FOREIGN KEY (appointmentID) REFERENCES appointment(ID) ON DELETE CASCADE
);

INSERT INTO users (id, username, password, firstname, surname, role) VALUES (0, 'harryredman', '$2a$10$EwkR./m0nafR6GhAOErcAOawGqG.4nYbVxgZkJbWqhEJHvbP6nzZm', 'harry', 'redman', 'ROLE_USER');
