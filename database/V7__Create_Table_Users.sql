--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-06 20:13:47 UTC

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
-- TOC entry 221 (class 1259 OID 16908)
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
    enabled bit(1)
);


ALTER TABLE public.users OWNER TO pguser;

--
-- TOC entry 220 (class 1259 OID 16907)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3355 (class 0 OID 16908)
-- Dependencies: 221
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.users (id, user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) FROM stdin;
\.


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 220
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- TOC entry 3211 (class 2606 OID 16912)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2023-04-06 20:13:47 UTC

--
-- PostgreSQL database dump complete
--

