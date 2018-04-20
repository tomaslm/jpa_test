--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: produto; Type: TABLE; Schema: public; Owner: tomas
--

CREATE TABLE produto (
    id integer NOT NULL,
    nome character varying(255),
    descricao character varying(255)
);


ALTER TABLE produto OWNER TO tomas;

--
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: tomas
--

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produto_id_seq OWNER TO tomas;

--
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tomas
--

ALTER SEQUENCE produto_id_seq OWNED BY produto.id;


--
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: tomas
--

ALTER TABLE ONLY produto ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);


--
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: tomas
--

COPY produto (id, nome, descricao) FROM stdin;
1	carro	um carro
3	casa	um casa
9	notebook	notebook semi-novo
\.


--
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tomas
--

SELECT pg_catalog.setval('produto_id_seq', 9, true);


--
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: tomas
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

