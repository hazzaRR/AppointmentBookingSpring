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
     email VARCHAR NOT NULL UNIQUE,
     telephone VARCHAR
);


CREATE TABLE if not exists treatment (
     ID BIGSERIAL PRIMARY KEY,
     treatment_name VARCHAR,
     price NUMERIC,
     duration_minutes INTEGER
);

CREATE TABLE if not exists appointment (
     ID BIGSERIAL PRIMARY KEY,
     app_date DATE,
     start_time TIME,
     end_time TIME,
     clientid BIGINT NOT NULL,
     total_price NUMERIC,
     status VARCHAR,
     payment_type VARCHAR,
     FOREIGN KEY (ClientID) REFERENCES client(ID),
     CONSTRAINT unique_appointment UNIQUE (app_date, start_time, end_time)
);


CREATE TABLE if not exists appointment_treatment (
   ID BIGSERIAL PRIMARY KEY,
   appointmentID BIGINT,
   treatmentID BIGINT,
   FOREIGN KEY (treatmentID) REFERENCES treatment(ID),
   FOREIGN KEY (appointmentID) REFERENCES appointment(ID) ON DELETE CASCADE
);

INSERT INTO users (id, username, password, firstname, surname, role) VALUES (0, 'harryredman', '$2a$10$EwkR./m0nafR6GhAOErcAOawGqG.4nYbVxgZkJbWqhEJHvbP6nzZm', 'harry', 'redman', 'ROLE_USER') ON CONFLICT DO NOTHING;
