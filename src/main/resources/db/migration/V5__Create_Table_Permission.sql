--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-06 20:09:53 UTC

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
-- TOC entry 219 (class 1259 OID 16902)
-- Name: permission; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.permission (
    id bigint NOT NULL,
    description character varying(255)
);


ALTER TABLE public.permission OWNER TO pguser;

--
-- TOC entry 218 (class 1259 OID 16901)
-- Name: permission_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

ALTER TABLE public.permission ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3355 (class 0 OID 16902)
-- Dependencies: 219
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.permission (id, description) FROM stdin;
\.


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 218
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.permission_id_seq', 1, false);


--
-- TOC entry 3211 (class 2606 OID 16906)
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id);


-- Completed on 2023-04-06 20:09:53 UTC

--
-- PostgreSQL database dump complete
--

