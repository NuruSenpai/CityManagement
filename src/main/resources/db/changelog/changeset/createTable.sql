create table person(
    id bigserial PRIMARY KEY,
    name text NOT NULL,
    surname text NOT NULL,
    sex_type text,
    balance decimal(19, 2) DEFAULT 0.00
);
create table home(
    id bigserial PRIMARY KEY,
    street text NOT NULL,
    number_of_home INT NOT NULL,
    number_of_rooms INT
);
create table passport(
    id bigserial PRIMARY KEY,
    serial INT
);
create table Person_Home(
    person_id bigint references person(id),
    home_id bigint references home(id),
    primary key (person_id, home_id)
);