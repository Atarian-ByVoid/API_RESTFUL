--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-06 20:11:33 UTC

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
-- TOC entry 214 (class 1259 OID 16884)
-- Name: person; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.person (
    id bigint NOT NULL,
    first_name character varying(80) NOT NULL,
    last_name character varying(80) NOT NULL,
    address character varying(100) NOT NULL,
    gender character varying(6) NOT NULL
);


ALTER TABLE public.person OWNER TO pguser;

--
-- TOC entry 215 (class 1259 OID 16887)
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

ALTER TABLE public.person ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3354 (class 0 OID 16884)
-- Dependencies: 214
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.person (id, first_name, last_name, address, gender) FROM stdin;
\.


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 215
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.person_id_seq', 1, false);


--
-- TOC entry 3211 (class 2606 OID 16892)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


-- Completed on 2023-04-06 20:11:33 UTC

--
-- PostgreSQL database dump complete
--

