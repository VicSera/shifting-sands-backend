create schema if not exists shifting_sands_schema;

create extension if not exists pgcrypto;

create table shifting_sands_schema.form (
    id uuid primary key default gen_random_uuid(),
    readId char(15) unique,
    writeId char(15) unique
);

create table shifting_sands_schema.response (
    id uuid primary key default gen_random_uuid(),
    writeId char(15) references shifting_sands_schema.form(writeId),
    goodText text,
    badText text,
    time timestamp default current_timestamp
);
