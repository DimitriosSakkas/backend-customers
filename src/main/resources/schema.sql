drop table if exists customer;

create table customer
(
    customer_id     int,
    user_name       varchar(32),
    first_name      varchar(32),
    last_name       varchar(32),
    date_of_birth   date,
    password        varchar(64)
);