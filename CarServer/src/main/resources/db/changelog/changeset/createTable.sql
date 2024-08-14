create table car(
    id bigserial PRIMARY KEY,
    brand text NOT NULL,
    model text NOT NULL,
    color text NOT NULL,
    person_id bigint
);