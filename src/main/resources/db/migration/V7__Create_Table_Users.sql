--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-03 12:42:37 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16727)
-- Name: users; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    user_name character varying(255),
    full_name character varying(255),
    password character varying(255),
    account_non_expired bit(1),
    account_non_locked bit(1),
    credentials_non_expired bit(1),
    enable bit(1)
);


ALTER TABLE public.users OWNER TO pguser;

--
-- TOC entry 3354 (class 0 OID 16727)
-- Dependencies: 220
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.users (id, user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enable) FROM stdin;
\.


--
-- TOC entry 3209 (class 2606 OID 16735)
-- Name: users uk_user_name; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_user_name UNIQUE (user_name);


--
-- TOC entry 3211 (class 2606 OID 16733)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2023-04-03 12:42:37 UTC

--
-- PostgreSQL database dump complete
--

