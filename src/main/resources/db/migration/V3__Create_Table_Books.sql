--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-03 13:24:49 UTC

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
-- TOC entry 217 (class 1259 OID 16702)
-- Name: books; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.books (
    id integer NOT NULL,
    author character varying(100),
    launch_date timestamp without time zone NOT NULL,
    price numeric(65,2) NOT NULL,
    title character varying(100) NOT NULL
);


ALTER TABLE public.books OWNER TO pguser;

--
-- TOC entry 216 (class 1259 OID 16701)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: pguser
--

CREATE SEQUENCE public.books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO pguser;

--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 216
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pguser
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- TOC entry 3212 (class 2604 OID 16705)
-- Name: books id; Type: DEFAULT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- TOC entry 3358 (class 0 OID 16702)
-- Dependencies: 217
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.books (id, author, launch_date, price, title) FROM stdin;
\.


--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 216
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pguser
--

SELECT pg_catalog.setval('public.books_id_seq', 16, true);


--
-- TOC entry 3214 (class 2606 OID 16707)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


-- Completed on 2023-04-03 13:24:49 UTC

--
-- PostgreSQL database dump complete
--

