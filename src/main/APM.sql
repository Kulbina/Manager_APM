-- Database: APMManagerDB

-- DROP DATABASE IF EXISTS "APMManagerDB";

CREATE DATABASE "APMManagerDB"
    WITH
    OWNER = root
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

    -- Table: public.clients

-- DROP TABLE IF EXISTS public.clients;

CREATE TABLE IF NOT EXISTS public.clients
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    second_name character varying COLLATE pg_catalog."default",
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    family_status character varying COLLATE pg_catalog."default",
    place_of_residence character varying COLLATE pg_catalog."default" NOT NULL,
    phone_number bigint NOT NULL,
    work_period character varying COLLATE pg_catalog."default" NOT NULL,
    job_title character varying COLLATE pg_catalog."default" NOT NULL,
    name_of_the_organization character varying COLLATE pg_catalog."default" NOT NULL,
    passport_series integer,
    passport_number integer,
    CONSTRAINT clients_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
    OWNER to root;

-- Table: public.contracts

-- DROP TABLE IF EXISTS public.contracts;

CREATE TABLE IF NOT EXISTS public.contracts
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    id_proposal bigint NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    date_of_singing character varying COLLATE pg_catalog."default",
    CONSTRAINT contracts_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contracts
    OWNER to root;


-- Table: public.contracts

-- DROP TABLE IF EXISTS public.contracts;

CREATE TABLE IF NOT EXISTS public.contracts
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    id_proposal bigint NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    date_of_singing character varying COLLATE pg_catalog."default",
    CONSTRAINT contracts_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contracts
    OWNER to root;
