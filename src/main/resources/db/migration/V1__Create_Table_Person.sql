--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-03 13:16:40 UTC

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
-- TOC entry 215 (class 1259 OID 16698)
-- Name: person; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.person (
    id bigint NOT NULL,
    first_name character varying(80) NOT NULL,
    last_name character varying(80) NOT NULL,
    addres character varying(80) NOT NULL,
    gender character varying(6) NOT NULL
);


ALTER TABLE public.person OWNER TO pguser;

--
-- TOC entry 3356 (class 0 OID 16698)
-- Dependencies: 215
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.person (id, first_name, last_name, addres, gender) FROM stdin;
\.


--
-- TOC entry 3213 (class 2606 OID 16764)
-- Name: person id; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT id PRIMARY KEY (id) INCLUDE (id);


-- Completed on 2023-04-03 13:16:40 UTC

--
-- PostgreSQL database dump complete
--

