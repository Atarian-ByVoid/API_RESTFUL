--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-04-06 20:12:22 UTC

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
-- TOC entry 222 (class 1259 OID 16915)
-- Name: user_permission; Type: TABLE; Schema: public; Owner: pguser
--

CREATE TABLE public.user_permission (
    id_user bigint NOT NULL,
    id_permission bigint NOT NULL
);


ALTER TABLE public.user_permission OWNER TO pguser;

--
-- TOC entry 3356 (class 0 OID 16915)
-- Dependencies: 222
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: pguser
--

COPY public.user_permission (id_user, id_permission) FROM stdin;
\.


--
-- TOC entry 3211 (class 2606 OID 16919)
-- Name: user_permission user_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT user_permission_pkey PRIMARY KEY (id_user, id_permission);


--
-- TOC entry 3212 (class 2606 OID 16920)
-- Name: user_permission fk_user_permission; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT fk_user_permission FOREIGN KEY (id_user) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 3213 (class 2606 OID 16925)
-- Name: user_permission fk_user_permission_permission; Type: FK CONSTRAINT; Schema: public; Owner: pguser
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES public.permission(id) NOT VALID;


-- Completed on 2023-04-06 20:12:23 UTC

--
-- PostgreSQL database dump complete
--

