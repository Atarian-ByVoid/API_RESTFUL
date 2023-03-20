--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-03-20 17:44:16 UTC

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
-- TOC entry 215 (class 1259 OID 16391)
-- Name: person; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.person (
    id bigint NOT NULL,
    adress character varying(80) NOT NULL,
    first_name character varying(80) NOT NULL,
    gender character varying(6) NOT NULL,
    last_name character varying(80) NOT NULL
);


ALTER TABLE public.person OWNER TO pguser;

--
-- TOC entry 214 (class 1259 OID 16390)
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_id_seq OWNER TO pguser;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 214
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.person_id_seq OWNED BY public.person.id;


--
-- TOC entry 3196 (class 2604 OID 16394)
-- Name: person id; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.person ALTER COLUMN id SET DEFAULT nextval('public.person_id_seq'::regclass);


--
-- TOC entry 3342 (class 0 OID 16391)
-- Dependencies: 215
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.person (id, adress, first_name, gender, last_name) FROM stdin;
1	Maria da Fé	Carlos	Male	Alberto
3	Maria da Fé	Pedro	Male	Santiago
4	Maria da Fé	Nicola	Male	Tesla
\.


--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 214
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.person_id_seq', 4, true);


--
-- TOC entry 3198 (class 2606 OID 16396)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


-- Completed on 2023-03-20 17:44:16 UTC

--
-- PostgreSQL database dump complete
--
