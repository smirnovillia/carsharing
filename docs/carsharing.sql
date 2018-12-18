--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.5

-- Started on 2018-12-18 16:37:57 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12544)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2589 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16791)
-- Name: black_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.black_list (
    id integer NOT NULL,
    customer_id integer NOT NULL,
    reason text NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.black_list OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16789)
-- Name: black_list_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.black_list_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.black_list_id_seq OWNER TO postgres;

--
-- TOC entry 2590 (class 0 OID 0)
-- Dependencies: 204
-- Name: black_list_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.black_list_id_seq OWNED BY public.black_list.id;


--
-- TOC entry 201 (class 1259 OID 16772)
-- Name: brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.brand (
    id integer NOT NULL,
    name character varying NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.brand OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16770)
-- Name: brand_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.brand_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.brand_id_seq OWNER TO postgres;

--
-- TOC entry 2591 (class 0 OID 0)
-- Dependencies: 200
-- Name: brand_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.brand_id_seq OWNED BY public.brand.id;


--
-- TOC entry 197 (class 1259 OID 16754)
-- Name: car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car (
    id integer NOT NULL,
    modification_id integer NOT NULL,
    release_date integer NOT NULL,
    vin character varying(50) NOT NULL,
    color_id integer NOT NULL,
    mileage real NOT NULL,
    condition character varying(50) NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.car OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16752)
-- Name: car_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.car_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_id_seq OWNER TO postgres;

--
-- TOC entry 2592 (class 0 OID 0)
-- Dependencies: 196
-- Name: car_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_id_seq OWNED BY public.car.id;


--
-- TOC entry 220 (class 1259 OID 16853)
-- Name: car_service_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car_service_history (
    id integer NOT NULL,
    car_id integer NOT NULL,
    service_date date NOT NULL,
    car_mileage real NOT NULL,
    service_company character varying(50) NOT NULL,
    service_price real NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.car_service_history OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16851)
-- Name: car_service_history_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.car_service_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_service_history_id_seq OWNER TO postgres;

--
-- TOC entry 2593 (class 0 OID 0)
-- Dependencies: 219
-- Name: car_service_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_service_history_id_seq OWNED BY public.car_service_history.id;


--
-- TOC entry 217 (class 1259 OID 16842)
-- Name: color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.color (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.color OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16848)
-- Name: color_2_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.color_2_model (
    color_id integer NOT NULL,
    model_id integer NOT NULL
);


ALTER TABLE public.color_2_model OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16840)
-- Name: color_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.color_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.color_id_seq OWNER TO postgres;

--
-- TOC entry 2594 (class 0 OID 0)
-- Dependencies: 216
-- Name: color_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.color_id_seq OWNED BY public.color.id;


--
-- TOC entry 203 (class 1259 OID 16783)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    birthday date NOT NULL,
    driver_license character varying(200) NOT NULL,
    driver_license_status boolean NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16781)
-- Name: customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_id_seq OWNER TO postgres;

--
-- TOC entry 2595 (class 0 OID 0)
-- Dependencies: 202
-- Name: customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;


--
-- TOC entry 209 (class 1259 OID 16810)
-- Name: insurance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.insurance (
    id integer NOT NULL,
    car_id integer NOT NULL,
    insurance_company character varying(50) NOT NULL,
    insurance_number character varying(50) NOT NULL,
    issued date NOT NULL,
    expiried date NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.insurance OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16808)
-- Name: insurance_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.insurance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.insurance_id_seq OWNER TO postgres;

--
-- TOC entry 2596 (class 0 OID 0)
-- Dependencies: 208
-- Name: insurance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.insurance_id_seq OWNED BY public.insurance.id;


--
-- TOC entry 199 (class 1259 OID 16764)
-- Name: model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.model (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    brand_id integer NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.model OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16762)
-- Name: model_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.model_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.model_id_seq OWNER TO postgres;

--
-- TOC entry 2597 (class 0 OID 0)
-- Dependencies: 198
-- Name: model_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.model_id_seq OWNED BY public.model.id;


--
-- TOC entry 211 (class 1259 OID 16818)
-- Name: modification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.modification (
    id integer NOT NULL,
    model_id integer NOT NULL,
    body character varying(50) NOT NULL,
    fuel character varying(50) NOT NULL,
    engine_capacity integer NOT NULL,
    drive character varying(50) NOT NULL,
    gearbox character varying(50) NOT NULL,
    tank_capacity integer NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.modification OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16816)
-- Name: modification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.modification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modification_id_seq OWNER TO postgres;

--
-- TOC entry 2598 (class 0 OID 0)
-- Dependencies: 210
-- Name: modification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modification_id_seq OWNED BY public.modification.id;


--
-- TOC entry 207 (class 1259 OID 16802)
-- Name: order_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_history (
    id integer NOT NULL,
    customer_id integer NOT NULL,
    car_id integer NOT NULL,
    order_date date NOT NULL,
    order_mileage real NOT NULL,
    rate real NOT NULL,
    price real NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.order_history OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16800)
-- Name: order_history_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_history_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_history_id_seq OWNER TO postgres;

--
-- TOC entry 2599 (class 0 OID 0)
-- Dependencies: 206
-- Name: order_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_history_id_seq OWNED BY public.order_history.id;


--
-- TOC entry 224 (class 1259 OID 16869)
-- Name: service_operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.service_operation (
    id integer NOT NULL,
    car_service_history_id integer NOT NULL,
    name character varying(50) NOT NULL,
    price real NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.service_operation OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16867)
-- Name: service_operation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.service_operation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.service_operation_id_seq OWNER TO postgres;

--
-- TOC entry 2600 (class 0 OID 0)
-- Dependencies: 223
-- Name: service_operation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_operation_id_seq OWNED BY public.service_operation.id;


--
-- TOC entry 222 (class 1259 OID 16861)
-- Name: spare_part; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spare_part (
    id integer NOT NULL,
    service_operation_id integer NOT NULL,
    name character varying(50) NOT NULL,
    price real NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.spare_part OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16859)
-- Name: spare_part_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.spare_part_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spare_part_id_seq OWNER TO postgres;

--
-- TOC entry 2601 (class 0 OID 0)
-- Dependencies: 221
-- Name: spare_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spare_part_id_seq OWNED BY public.spare_part.id;


--
-- TOC entry 215 (class 1259 OID 16834)
-- Name: tracking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tracking (
    id integer NOT NULL,
    car_id integer NOT NULL,
    latitude real NOT NULL,
    longitude real NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.tracking OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16832)
-- Name: tracking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tracking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tracking_id_seq OWNER TO postgres;

--
-- TOC entry 2602 (class 0 OID 0)
-- Dependencies: 214
-- Name: tracking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tracking_id_seq OWNED BY public.tracking.id;


--
-- TOC entry 213 (class 1259 OID 16826)
-- Name: user_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_account (
    id integer NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(200) NOT NULL,
    user_role smallint NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.user_account OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16824)
-- Name: user_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_account_id_seq OWNER TO postgres;

--
-- TOC entry 2603 (class 0 OID 0)
-- Dependencies: 212
-- Name: user_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_id_seq OWNED BY public.user_account.id;


--
-- TOC entry 2377 (class 2604 OID 16794)
-- Name: black_list id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list ALTER COLUMN id SET DEFAULT nextval('public.black_list_id_seq'::regclass);


--
-- TOC entry 2375 (class 2604 OID 16775)
-- Name: brand id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand ALTER COLUMN id SET DEFAULT nextval('public.brand_id_seq'::regclass);


--
-- TOC entry 2373 (class 2604 OID 16757)
-- Name: car id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car ALTER COLUMN id SET DEFAULT nextval('public.car_id_seq'::regclass);


--
-- TOC entry 2384 (class 2604 OID 16856)
-- Name: car_service_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history ALTER COLUMN id SET DEFAULT nextval('public.car_service_history_id_seq'::regclass);


--
-- TOC entry 2383 (class 2604 OID 16845)
-- Name: color id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color ALTER COLUMN id SET DEFAULT nextval('public.color_id_seq'::regclass);


--
-- TOC entry 2376 (class 2604 OID 16786)
-- Name: customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);


--
-- TOC entry 2379 (class 2604 OID 16813)
-- Name: insurance id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance ALTER COLUMN id SET DEFAULT nextval('public.insurance_id_seq'::regclass);


--
-- TOC entry 2374 (class 2604 OID 16767)
-- Name: model id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model ALTER COLUMN id SET DEFAULT nextval('public.model_id_seq'::regclass);


--
-- TOC entry 2380 (class 2604 OID 16821)
-- Name: modification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification ALTER COLUMN id SET DEFAULT nextval('public.modification_id_seq'::regclass);


--
-- TOC entry 2378 (class 2604 OID 16805)
-- Name: order_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history ALTER COLUMN id SET DEFAULT nextval('public.order_history_id_seq'::regclass);


--
-- TOC entry 2386 (class 2604 OID 16872)
-- Name: service_operation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation ALTER COLUMN id SET DEFAULT nextval('public.service_operation_id_seq'::regclass);


--
-- TOC entry 2385 (class 2604 OID 16864)
-- Name: spare_part id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part ALTER COLUMN id SET DEFAULT nextval('public.spare_part_id_seq'::regclass);


--
-- TOC entry 2382 (class 2604 OID 16837)
-- Name: tracking id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking ALTER COLUMN id SET DEFAULT nextval('public.tracking_id_seq'::regclass);


--
-- TOC entry 2381 (class 2604 OID 16829)
-- Name: user_account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account ALTER COLUMN id SET DEFAULT nextval('public.user_account_id_seq'::regclass);


--
-- TOC entry 2562 (class 0 OID 16791)
-- Dependencies: 205
-- Data for Name: black_list; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2558 (class 0 OID 16772)
-- Dependencies: 201
-- Data for Name: brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.brand (id, name, created, updated) VALUES (1, 'Audi', '2018-12-17 20:02:20.766', '2018-12-17 20:02:20.766');
INSERT INTO public.brand (id, name, created, updated) VALUES (2, 'Mercedes', '2018-12-17 20:03:29.028', '2018-12-17 20:03:29.028');
INSERT INTO public.brand (id, name, created, updated) VALUES (3, 'Opel', '2018-12-17 20:03:56.756', '2018-12-17 20:03:56.756');
INSERT INTO public.brand (id, name, created, updated) VALUES (4, 'Kia', '2018-12-17 20:04:03.435', '2018-12-17 20:04:03.435');
INSERT INTO public.brand (id, name, created, updated) VALUES (5, 'Hyundai', '2018-12-17 20:04:37.275', '2018-12-17 20:04:37.275');
INSERT INTO public.brand (id, name, created, updated) VALUES (6, 'Toyota', '2018-12-17 20:05:01.753', '2018-12-17 20:05:01.753');


--
-- TOC entry 2554 (class 0 OID 16754)
-- Dependencies: 197
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.car (id, modification_id, release_date, vin, color_id, mileage, condition, created, updated) VALUES (1, 1, 2012, 'QPOKLSG98234LKM', 1, 15000, 'AVAILABLE', '2018-12-17 20:48:27.601', '2018-12-17 20:48:27.601');
INSERT INTO public.car (id, modification_id, release_date, vin, color_id, mileage, condition, created, updated) VALUES (2, 3, 2015, 'ZCLA914LKMADF', 2, 20000, 'AVAILABLE', '2018-12-17 20:49:06.345', '2018-12-17 20:49:06.345');
INSERT INTO public.car (id, modification_id, release_date, vin, color_id, mileage, condition, created, updated) VALUES (3, 4, 2010, 'WOKPOKL90134OSDF', 9, 30000, 'AVAILABLE', '2018-12-17 20:50:26.395', '2018-12-17 20:50:26.395');
INSERT INTO public.car (id, modification_id, release_date, vin, color_id, mileage, condition, created, updated) VALUES (4, 5, 2017, 'OIJKSLDMGL93PO5FA', 7, 5000, 'AVAILABLE', '2018-12-17 20:53:30.688', '2018-12-17 20:53:30.688');


--
-- TOC entry 2577 (class 0 OID 16853)
-- Dependencies: 220
-- Data for Name: car_service_history; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2574 (class 0 OID 16842)
-- Dependencies: 217
-- Data for Name: color; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.color (id, name, created, updated) VALUES (1, 'Black', '2018-12-17 20:05:42.825', '2018-12-17 20:05:42.825');
INSERT INTO public.color (id, name, created, updated) VALUES (2, 'White', '2018-12-17 20:05:48.521', '2018-12-17 20:05:48.521');
INSERT INTO public.color (id, name, created, updated) VALUES (3, 'Yellow', '2018-12-17 20:05:59.244', '2018-12-17 20:05:59.244');
INSERT INTO public.color (id, name, created, updated) VALUES (4, 'Orange', '2018-12-17 20:06:12.115', '2018-12-17 20:06:12.115');
INSERT INTO public.color (id, name, created, updated) VALUES (5, 'Red', '2018-12-17 20:06:17.558', '2018-12-17 20:06:17.558');
INSERT INTO public.color (id, name, created, updated) VALUES (6, 'Blue', '2018-12-17 20:06:23.011', '2018-12-17 20:06:23.011');
INSERT INTO public.color (id, name, created, updated) VALUES (7, 'Purple', '2018-12-17 20:06:30.842', '2018-12-17 20:06:30.842');
INSERT INTO public.color (id, name, created, updated) VALUES (8, 'Grey', '2018-12-17 20:06:48.496', '2018-12-17 20:06:48.496');
INSERT INTO public.color (id, name, created, updated) VALUES (9, 'Green', '2018-12-17 20:06:54.099', '2018-12-17 20:06:54.099');
INSERT INTO public.color (id, name, created, updated) VALUES (10, 'Silver', '2018-12-17 20:07:17.207', '2018-12-17 20:07:17.207');


--
-- TOC entry 2575 (class 0 OID 16848)
-- Dependencies: 218
-- Data for Name: color_2_model; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 1);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (10, 1);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (5, 1);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (6, 1);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (1, 1);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (5, 2);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (8, 2);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (1, 2);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 2);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 3);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (6, 3);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (1, 3);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (9, 3);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (3, 4);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (4, 4);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (7, 4);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 4);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 5);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (10, 5);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (8, 5);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (8, 6);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (2, 6);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (10, 6);
INSERT INTO public.color_2_model (color_id, model_id) VALUES (6, 6);


--
-- TOC entry 2560 (class 0 OID 16783)
-- Dependencies: 203
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (2, 'Bill', 'Murey', '2002-12-01', 'https://murey64e2fd78-2a1e-419d-b1cc-7f0e32dbf3ea.s3.amazonaws.com/washington-drivers-license.jpg', true, '2018-12-17 18:10:22.547', '2018-12-17 18:10:22.547');
INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (3, 'Jack', 'Sparrow', '2000-12-25', 'https://sparrow7017e981-6535-4f1c-9793-62d7813fd626.s3.amazonaws.com/jack_sparrow_dl.jpg', true, '2018-12-18 15:09:40.369', '2018-12-18 15:09:40.369');
INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (4, 'Sandra', 'Bullok', '2002-03-01', 'https://bullok829bb213-e627-44b5-8fa9-dc01a7a26445.s3.amazonaws.com/sandra_bullok_dl.jpg', true, '2018-12-18 15:10:39.276', '2018-12-18 15:10:39.276');
INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (5, 'Michel', 'Phapher', '2005-05-11', 'https://phapher3c3eb2cc-f4bb-46ce-9cbf-ccc1f27c079b.s3.amazonaws.com/michel_phapher_dl.png', true, '2018-12-18 15:11:39.405', '2018-12-18 15:11:39.405');


--
-- TOC entry 2566 (class 0 OID 16810)
-- Dependencies: 209
-- Data for Name: insurance; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2556 (class 0 OID 16764)
-- Dependencies: 199
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (1, 'A6', 1, '2018-12-17 20:07:45.721', '2018-12-17 20:07:45.721');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (2, 'GLE', 2, '2018-12-17 20:08:29.416', '2018-12-17 20:08:29.416');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (3, 'Captiva', 3, '2018-12-17 20:08:59.865', '2018-12-17 20:08:59.865');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (4, 'Sportage', 4, '2018-12-17 20:09:24.027', '2018-12-17 20:09:24.027');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (5, 'Creta', 5, '2018-12-17 20:09:49.572', '2018-12-17 20:09:49.572');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (6, 'RAV4', 6, '2018-12-17 20:10:15.825', '2018-12-17 20:10:15.825');


--
-- TOC entry 2568 (class 0 OID 16818)
-- Dependencies: 211
-- Data for Name: modification; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (1, 1, 'SEDAN', 'PETROL', 3000, 'AWD', 'AUTOMATIC', 70, '2018-12-17 20:27:07.786', '2018-12-17 20:27:07.786');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (2, 1, 'ESTATE', 'DIESEL', 2000, 'FWD', 'CVT', 60, '2018-12-17 20:28:29.449', '2018-12-17 20:28:29.449');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (3, 2, 'SUV', 'DIESEL', 3000, 'AWD', 'AUTOMATIC', 75, '2018-12-17 20:36:57.362', '2018-12-17 20:36:57.362');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (4, 3, 'SUV', 'PETROL', 2400, 'FWD', 'MANUAL', 60, '2018-12-17 20:46:35.399', '2018-12-17 20:46:35.399');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (5, 4, 'SUV', 'PETROL', 2000, 'FWD', 'AUTOMATIC', 55, '2018-12-17 20:47:03.967', '2018-12-17 20:47:03.967');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (6, 5, 'HATCHBACK', 'PETROL', 1600, 'FWD', 'MANUAL', 50, '2018-12-17 20:47:26.91', '2018-12-17 20:47:26.91');
INSERT INTO public.modification (id, model_id, body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) VALUES (7, 6, 'SUV', 'PETROL', 2000, 'FWD', 'CVT', 60, '2018-12-17 20:47:53.389', '2018-12-17 20:47:53.389');


--
-- TOC entry 2564 (class 0 OID 16802)
-- Dependencies: 207
-- Data for Name: order_history; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2581 (class 0 OID 16869)
-- Dependencies: 224
-- Data for Name: service_operation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2579 (class 0 OID 16861)
-- Dependencies: 222
-- Data for Name: spare_part; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2572 (class 0 OID 16834)
-- Dependencies: 215
-- Data for Name: tracking; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tracking (id, car_id, latitude, longitude, created, updated) VALUES (1, 3, 53.9002533, 27.5590229, '2018-12-18 13:20:56.395', '2018-12-18 13:20:56.395');
INSERT INTO public.tracking (id, car_id, latitude, longitude, created, updated) VALUES (2, 2, 53.9158134, 27.5718098, '2018-12-18 13:21:22.128', '2018-12-18 13:21:22.128');


--
-- TOC entry 2570 (class 0 OID 16826)
-- Dependencies: 213
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (1, 'admin', '$2y$12$N3.XX56YRIoUjO2Z/baM8OjIdxId8948EhDoXKtyH68468JdG5dM6', 0, '2018-12-17 17:18:03.316898', '2018-12-17 17:18:03.316898');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (2, 'bill@mail.com', '$2a$12$6BeAn.VXeJEExsxRsTBie.WIi2yTKw3tRl78ozF47FtBolugY55K6', 1, '2018-12-17 18:10:22.547', '2018-12-17 18:10:22.547');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (3, 'jack@mail.com', '$2a$12$2ZQbuuMEn5MP5wUOf5rWuel8schHbgFiI8eBz/EfS7wNSsvCz5yJu', 1, '2018-12-18 15:09:40.369', '2018-12-18 15:09:40.369');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (4, 'sandra@mail.com', '$2a$12$LPIChAz.N1jFUEOxwIazce7mWv4XaK34Hlgta3u0hyEv1gjlkvtyW', 1, '2018-12-18 15:10:39.276', '2018-12-18 15:10:39.276');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (5, 'michel@mail.com', '$2a$12$mVS/wf6fDWMlnSeEHmSgPeb5nfJWm1iaeNt1wKtI5zKM/YWBamSuK', 1, '2018-12-18 15:11:39.405', '2018-12-18 15:11:39.405');


--
-- TOC entry 2604 (class 0 OID 0)
-- Dependencies: 204
-- Name: black_list_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.black_list_id_seq', 1, false);


--
-- TOC entry 2605 (class 0 OID 0)
-- Dependencies: 200
-- Name: brand_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.brand_id_seq', 6, true);


--
-- TOC entry 2606 (class 0 OID 0)
-- Dependencies: 196
-- Name: car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_id_seq', 4, true);


--
-- TOC entry 2607 (class 0 OID 0)
-- Dependencies: 219
-- Name: car_service_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_service_history_id_seq', 1, false);


--
-- TOC entry 2608 (class 0 OID 0)
-- Dependencies: 216
-- Name: color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.color_id_seq', 10, true);


--
-- TOC entry 2609 (class 0 OID 0)
-- Dependencies: 202
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_id_seq', 1, false);


--
-- TOC entry 2610 (class 0 OID 0)
-- Dependencies: 208
-- Name: insurance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.insurance_id_seq', 1, false);


--
-- TOC entry 2611 (class 0 OID 0)
-- Dependencies: 198
-- Name: model_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.model_id_seq', 6, true);


--
-- TOC entry 2612 (class 0 OID 0)
-- Dependencies: 210
-- Name: modification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modification_id_seq', 7, true);


--
-- TOC entry 2613 (class 0 OID 0)
-- Dependencies: 206
-- Name: order_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_history_id_seq', 1, false);


--
-- TOC entry 2614 (class 0 OID 0)
-- Dependencies: 223
-- Name: service_operation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.service_operation_id_seq', 1, false);


--
-- TOC entry 2615 (class 0 OID 0)
-- Dependencies: 221
-- Name: spare_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.spare_part_id_seq', 1, false);


--
-- TOC entry 2616 (class 0 OID 0)
-- Dependencies: 214
-- Name: tracking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tracking_id_seq', 2, true);


--
-- TOC entry 2617 (class 0 OID 0)
-- Dependencies: 212
-- Name: user_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_account_id_seq', 5, true);


--
-- TOC entry 2398 (class 2606 OID 16799)
-- Name: black_list black_list_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list
    ADD CONSTRAINT black_list_pk PRIMARY KEY (id);


--
-- TOC entry 2394 (class 2606 OID 16780)
-- Name: brand brand_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_pk PRIMARY KEY (id);


--
-- TOC entry 2388 (class 2606 OID 16759)
-- Name: car car_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_pk PRIMARY KEY (id);


--
-- TOC entry 2412 (class 2606 OID 16858)
-- Name: car_service_history car_service_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history
    ADD CONSTRAINT car_service_history_pk PRIMARY KEY (id);


--
-- TOC entry 2390 (class 2606 OID 16761)
-- Name: car car_vin_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_vin_key UNIQUE (vin);


--
-- TOC entry 2410 (class 2606 OID 16847)
-- Name: color color_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color
    ADD CONSTRAINT color_pk PRIMARY KEY (id);


--
-- TOC entry 2396 (class 2606 OID 16788)
-- Name: customer customer_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pk PRIMARY KEY (id);


--
-- TOC entry 2402 (class 2606 OID 16815)
-- Name: insurance insurance_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance
    ADD CONSTRAINT insurance_pk PRIMARY KEY (id);


--
-- TOC entry 2392 (class 2606 OID 16769)
-- Name: model model_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pk PRIMARY KEY (id);


--
-- TOC entry 2404 (class 2606 OID 16823)
-- Name: modification modification_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification
    ADD CONSTRAINT modification_pk PRIMARY KEY (id);


--
-- TOC entry 2400 (class 2606 OID 16807)
-- Name: order_history order_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_pk PRIMARY KEY (id);


--
-- TOC entry 2416 (class 2606 OID 16874)
-- Name: service_operation service_operation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation
    ADD CONSTRAINT service_operation_pk PRIMARY KEY (id);


--
-- TOC entry 2414 (class 2606 OID 16866)
-- Name: spare_part spare_part_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part
    ADD CONSTRAINT spare_part_pk PRIMARY KEY (id);


--
-- TOC entry 2408 (class 2606 OID 16839)
-- Name: tracking tracking_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT tracking_pk PRIMARY KEY (id);


--
-- TOC entry 2406 (class 2606 OID 16831)
-- Name: user_account user_account_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pk PRIMARY KEY (id);


--
-- TOC entry 2421 (class 2606 OID 16900)
-- Name: black_list black_list_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list
    ADD CONSTRAINT black_list_fk0 FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 2417 (class 2606 OID 16875)
-- Name: car car_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_fk0 FOREIGN KEY (modification_id) REFERENCES public.modification(id);


--
-- TOC entry 2418 (class 2606 OID 16880)
-- Name: car car_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_fk1 FOREIGN KEY (color_id) REFERENCES public.color(id);


--
-- TOC entry 2429 (class 2606 OID 16935)
-- Name: car_service_history car_service_history_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history
    ADD CONSTRAINT car_service_history_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2427 (class 2606 OID 16925)
-- Name: color_2_model color_2_model_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color_2_model
    ADD CONSTRAINT color_2_model_fk0 FOREIGN KEY (color_id) REFERENCES public.color(id);


--
-- TOC entry 2428 (class 2606 OID 16930)
-- Name: color_2_model color_2_model_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color_2_model
    ADD CONSTRAINT color_2_model_fk1 FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- TOC entry 2420 (class 2606 OID 16895)
-- Name: customer customer_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_fk0 FOREIGN KEY (id) REFERENCES public.user_account(id);


--
-- TOC entry 2424 (class 2606 OID 16915)
-- Name: insurance insurance_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance
    ADD CONSTRAINT insurance_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2419 (class 2606 OID 16885)
-- Name: model model_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_fk0 FOREIGN KEY (brand_id) REFERENCES public.brand(id);


--
-- TOC entry 2425 (class 2606 OID 16890)
-- Name: modification modification_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification
    ADD CONSTRAINT modification_fk0 FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- TOC entry 2422 (class 2606 OID 16905)
-- Name: order_history order_history_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_fk0 FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 2423 (class 2606 OID 16910)
-- Name: order_history order_history_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_fk1 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2431 (class 2606 OID 16945)
-- Name: service_operation service_operation_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation
    ADD CONSTRAINT service_operation_fk0 FOREIGN KEY (car_service_history_id) REFERENCES public.car_service_history(id);


--
-- TOC entry 2430 (class 2606 OID 16940)
-- Name: spare_part spare_part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part
    ADD CONSTRAINT spare_part_fk0 FOREIGN KEY (service_operation_id) REFERENCES public.service_operation(id);


--
-- TOC entry 2426 (class 2606 OID 16920)
-- Name: tracking tracking_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT tracking_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


-- Completed on 2018-12-18 16:37:58 +03

--
-- PostgreSQL database dump complete
--

