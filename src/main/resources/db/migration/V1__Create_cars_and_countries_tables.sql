create extension if not exists "uuid-ossp";

create table if not exists countries
(
    id varchar(255) default uuid_generate_v4() not null
        constraint countries_pkey
            primary key,
    code varchar(2) not null
        constraint uk_5dhgnik9p8t72kaktdb8kd8dt
            unique,
    created_at timestamp with time zone not null,
    title varchar(100)
);

alter table countries owner to cars_user;

create table if not exists cars
(
    id varchar(255) default uuid_generate_v4() not null
        constraint cars_pkey
            primary key,
    created_at timestamp with time zone not null,
    price numeric(19,2),
    title varchar(100),
    country_id varchar(255)
        constraint fkgqfhteisk1igubj28ymn0wlb1
            references countries
);

alter table cars owner to cars_user;

