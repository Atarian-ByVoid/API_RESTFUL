--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-06 20:09:02 UTC

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
-- TOC entry 217 (class 1259 OID 16894)
-- Name: books; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.books (
    id bigint NOT NULL,
    author character varying(200),
    launch_date timestamp(6) with time zone NOT NULL,
    price money NOT NULL,
    title character varying
);


ALTER TABLE public.books OWNER TO pguser;

--
-- TOC entry 216 (class 1259 OID 16893)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

ALTER TABLE public.books ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3355 (class 0 OID 16894)
-- Dependencies: 217
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.books (id, author, launch_date, price, title) FROM stdin;
\.


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 216
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.books_id_seq', 1, false);


--
-- TOC entry 3211 (class 2606 OID 16898)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


-- Completed on 2023-04-06 20:09:02 UTC

--
-- PostgreSQL database dump complete
--

