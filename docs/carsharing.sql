--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.5

-- Started on 2018-12-16 15:50:25 +03

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
-- TOC entry 2590 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16591)
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
-- TOC entry 204 (class 1259 OID 16589)
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
-- TOC entry 2591 (class 0 OID 0)
-- Dependencies: 204
-- Name: black_list_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.black_list_id_seq OWNED BY public.black_list.id;


--
-- TOC entry 201 (class 1259 OID 16569)
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
-- TOC entry 200 (class 1259 OID 16567)
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
-- TOC entry 2592 (class 0 OID 0)
-- Dependencies: 200
-- Name: brand_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.brand_id_seq OWNED BY public.brand.id;


--
-- TOC entry 197 (class 1259 OID 16551)
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
-- TOC entry 196 (class 1259 OID 16549)
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
-- TOC entry 2593 (class 0 OID 0)
-- Dependencies: 196
-- Name: car_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_id_seq OWNED BY public.car.id;


--
-- TOC entry 220 (class 1259 OID 16653)
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
-- TOC entry 219 (class 1259 OID 16651)
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
-- TOC entry 2594 (class 0 OID 0)
-- Dependencies: 219
-- Name: car_service_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_service_history_id_seq OWNED BY public.car_service_history.id;


--
-- TOC entry 217 (class 1259 OID 16642)
-- Name: color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.color (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    created timestamp without time zone NOT NULL,
    updated timestamp without time zone NOT NULL
);


ALTER TABLE public.color OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16648)
-- Name: color_2_model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.color_2_model (
    color_id integer NOT NULL,
    model_id integer NOT NULL
);


ALTER TABLE public.color_2_model OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16640)
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
-- TOC entry 2595 (class 0 OID 0)
-- Dependencies: 216
-- Name: color_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.color_id_seq OWNED BY public.color.id;


--
-- TOC entry 203 (class 1259 OID 16580)
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
-- TOC entry 202 (class 1259 OID 16578)
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
-- TOC entry 2596 (class 0 OID 0)
-- Dependencies: 202
-- Name: customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;


--
-- TOC entry 209 (class 1259 OID 16610)
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
-- TOC entry 208 (class 1259 OID 16608)
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
-- TOC entry 2597 (class 0 OID 0)
-- Dependencies: 208
-- Name: insurance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.insurance_id_seq OWNED BY public.insurance.id;


--
-- TOC entry 199 (class 1259 OID 16561)
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
-- TOC entry 198 (class 1259 OID 16559)
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
-- TOC entry 2598 (class 0 OID 0)
-- Dependencies: 198
-- Name: model_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.model_id_seq OWNED BY public.model.id;


--
-- TOC entry 211 (class 1259 OID 16618)
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
-- TOC entry 210 (class 1259 OID 16616)
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
-- TOC entry 2599 (class 0 OID 0)
-- Dependencies: 210
-- Name: modification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.modification_id_seq OWNED BY public.modification.id;


--
-- TOC entry 207 (class 1259 OID 16602)
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
-- TOC entry 206 (class 1259 OID 16600)
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
-- TOC entry 2600 (class 0 OID 0)
-- Dependencies: 206
-- Name: order_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_history_id_seq OWNED BY public.order_history.id;


--
-- TOC entry 224 (class 1259 OID 16669)
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
-- TOC entry 223 (class 1259 OID 16667)
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
-- TOC entry 2601 (class 0 OID 0)
-- Dependencies: 223
-- Name: service_operation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.service_operation_id_seq OWNED BY public.service_operation.id;


--
-- TOC entry 222 (class 1259 OID 16661)
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
-- TOC entry 221 (class 1259 OID 16659)
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
-- TOC entry 2602 (class 0 OID 0)
-- Dependencies: 221
-- Name: spare_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spare_part_id_seq OWNED BY public.spare_part.id;


--
-- TOC entry 215 (class 1259 OID 16634)
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
-- TOC entry 214 (class 1259 OID 16632)
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
-- TOC entry 2603 (class 0 OID 0)
-- Dependencies: 214
-- Name: tracking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tracking_id_seq OWNED BY public.tracking.id;


--
-- TOC entry 213 (class 1259 OID 16626)
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
-- TOC entry 212 (class 1259 OID 16624)
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
-- TOC entry 2604 (class 0 OID 0)
-- Dependencies: 212
-- Name: user_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_account_id_seq OWNED BY public.user_account.id;


--
-- TOC entry 2378 (class 2604 OID 16594)
-- Name: black_list id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list ALTER COLUMN id SET DEFAULT nextval('public.black_list_id_seq'::regclass);


--
-- TOC entry 2376 (class 2604 OID 16572)
-- Name: brand id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand ALTER COLUMN id SET DEFAULT nextval('public.brand_id_seq'::regclass);


--
-- TOC entry 2374 (class 2604 OID 16554)
-- Name: car id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car ALTER COLUMN id SET DEFAULT nextval('public.car_id_seq'::regclass);


--
-- TOC entry 2385 (class 2604 OID 16656)
-- Name: car_service_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history ALTER COLUMN id SET DEFAULT nextval('public.car_service_history_id_seq'::regclass);


--
-- TOC entry 2384 (class 2604 OID 16645)
-- Name: color id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color ALTER COLUMN id SET DEFAULT nextval('public.color_id_seq'::regclass);


--
-- TOC entry 2377 (class 2604 OID 16583)
-- Name: customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);


--
-- TOC entry 2380 (class 2604 OID 16613)
-- Name: insurance id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance ALTER COLUMN id SET DEFAULT nextval('public.insurance_id_seq'::regclass);


--
-- TOC entry 2375 (class 2604 OID 16564)
-- Name: model id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model ALTER COLUMN id SET DEFAULT nextval('public.model_id_seq'::regclass);


--
-- TOC entry 2381 (class 2604 OID 16621)
-- Name: modification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification ALTER COLUMN id SET DEFAULT nextval('public.modification_id_seq'::regclass);


--
-- TOC entry 2379 (class 2604 OID 16605)
-- Name: order_history id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history ALTER COLUMN id SET DEFAULT nextval('public.order_history_id_seq'::regclass);


--
-- TOC entry 2387 (class 2604 OID 16672)
-- Name: service_operation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation ALTER COLUMN id SET DEFAULT nextval('public.service_operation_id_seq'::regclass);


--
-- TOC entry 2386 (class 2604 OID 16664)
-- Name: spare_part id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part ALTER COLUMN id SET DEFAULT nextval('public.spare_part_id_seq'::regclass);


--
-- TOC entry 2383 (class 2604 OID 16637)
-- Name: tracking id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking ALTER COLUMN id SET DEFAULT nextval('public.tracking_id_seq'::regclass);


--
-- TOC entry 2382 (class 2604 OID 16629)
-- Name: user_account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account ALTER COLUMN id SET DEFAULT nextval('public.user_account_id_seq'::regclass);


--
-- TOC entry 2563 (class 0 OID 16591)
-- Dependencies: 205
-- Data for Name: black_list; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2559 (class 0 OID 16569)
-- Dependencies: 201
-- Data for Name: brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.brand (id, name, created, updated) VALUES (1, 'Audi', '2018-12-15 23:37:37.358', '2018-12-15 23:37:37.358');
INSERT INTO public.brand (id, name, created, updated) VALUES (2, 'Opel', '2018-12-15 23:37:45.607', '2018-12-15 23:37:45.607');
INSERT INTO public.brand (id, name, created, updated) VALUES (3, 'Mercedes', '2018-12-16 14:40:29.622', '2018-12-16 14:40:29.622');


--
-- TOC entry 2555 (class 0 OID 16551)
-- Dependencies: 197
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2578 (class 0 OID 16653)
-- Dependencies: 220
-- Data for Name: car_service_history; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2575 (class 0 OID 16642)
-- Dependencies: 217
-- Data for Name: color; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.color (id, name, created, updated) VALUES (1, 'Black', '2018-12-16 14:40:50.599', '2018-12-16 14:40:50.599');
INSERT INTO public.color (id, name, created, updated) VALUES (2, 'White', '2018-12-16 14:40:56.821', '2018-12-16 14:40:56.821');
INSERT INTO public.color (id, name, created, updated) VALUES (3, 'Blue', '2018-12-16 14:41:03.317', '2018-12-16 14:41:03.317');
INSERT INTO public.color (id, name, created, updated) VALUES (4, 'Red', '2018-12-16 14:41:08.148', '2018-12-16 14:41:08.148');


--
-- TOC entry 2576 (class 0 OID 16648)
-- Dependencies: 218
-- Data for Name: color_2_model; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2561 (class 0 OID 16580)
-- Dependencies: 203
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (3, 'Bill', 'Murey', '2000-04-01', 'https://mureyfe620cb3-bfbc-4d35-a1ee-7d524ce3ef65.s3.amazonaws.com/washington-drivers-license.jpg', true, '2018-12-10 06:21:05.404', '2018-12-10 06:21:05.404');
INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (4, 'Bob', 'Torton', '1999-05-01', 'https://tortondd63a93e-7e16-4b91-b483-4893971b1f29.s3.amazonaws.com/washington-drivers-license.jpg', true, '2018-12-11 21:45:23.433', '2018-12-11 21:45:23.433');
INSERT INTO public.customer (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) VALUES (6, 'Jack', 'Black', '2015-12-01', 'https://black2b8ce756-2639-4dad-9986-c7865323bbd5.s3.amazonaws.com/washington-drivers-license.jpg', true, '2018-12-11 22:21:06.071', '2018-12-11 22:21:06.071');


--
-- TOC entry 2567 (class 0 OID 16610)
-- Dependencies: 209
-- Data for Name: insurance; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2557 (class 0 OID 16561)
-- Dependencies: 199
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (1, 'Mokka', 2, '2018-12-15 23:42:09.235', '2018-12-15 23:42:09.235');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (2, 'A7', 1, '2018-12-16 14:39:29.418', '2018-12-16 14:39:29.418');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (3, 'Astra', 2, '2018-12-16 14:39:46.562', '2018-12-16 14:39:46.562');
INSERT INTO public.model (id, name, brand_id, created, updated) VALUES (4, 'GLE', 3, '2018-12-16 14:40:41.534', '2018-12-16 14:40:41.534');


--
-- TOC entry 2569 (class 0 OID 16618)
-- Dependencies: 211
-- Data for Name: modification; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2565 (class 0 OID 16602)
-- Dependencies: 207
-- Data for Name: order_history; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2582 (class 0 OID 16669)
-- Dependencies: 224
-- Data for Name: service_operation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2580 (class 0 OID 16661)
-- Dependencies: 222
-- Data for Name: spare_part; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2573 (class 0 OID 16634)
-- Dependencies: 215
-- Data for Name: tracking; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2571 (class 0 OID 16626)
-- Dependencies: 213
-- Data for Name: user_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (2, 'admin', '$2a$12$Wo3jv4dqJa.PqxPUgbyBAOJfb4v9INABEPHBSa4ESoxStDu1Q.PyK', 0, '2018-12-06 00:00:00', '2018-12-06 00:00:00');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (3, 'bill@mail.com', '$2a$12$zuhSnn0sD0Hmqj.t2YPVNeV6MZlz3oftweplmMOf1yjgTdpwMPZsW', 1, '2018-12-10 06:21:05.404', '2018-12-10 06:21:05.404');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (4, 'bob@mail.com', '$2a$12$uw0Qw8dqx7CjDr4xWoTk1O5QkpZiGiipa/K/Gq2fgzZ6xunArMwTq', 1, '2018-12-11 21:45:23.433', '2018-12-11 21:45:23.433');
INSERT INTO public.user_account (id, login, password, user_role, created, updated) VALUES (6, 'jack@mail.com', '$2a$12$tgqYdw9Sjz3L29IIf1nTpevLKXufGZfzm4KM1HnGD2I2YPVcgxBCS', 1, '2018-12-11 22:21:06.071', '2018-12-11 22:21:06.071');


--
-- TOC entry 2605 (class 0 OID 0)
-- Dependencies: 204
-- Name: black_list_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.black_list_id_seq', 1, false);


--
-- TOC entry 2606 (class 0 OID 0)
-- Dependencies: 200
-- Name: brand_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.brand_id_seq', 3, true);


--
-- TOC entry 2607 (class 0 OID 0)
-- Dependencies: 196
-- Name: car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_id_seq', 1, false);


--
-- TOC entry 2608 (class 0 OID 0)
-- Dependencies: 219
-- Name: car_service_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_service_history_id_seq', 1, false);


--
-- TOC entry 2609 (class 0 OID 0)
-- Dependencies: 216
-- Name: color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.color_id_seq', 4, true);


--
-- TOC entry 2610 (class 0 OID 0)
-- Dependencies: 202
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_id_seq', 2, true);


--
-- TOC entry 2611 (class 0 OID 0)
-- Dependencies: 208
-- Name: insurance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.insurance_id_seq', 1, false);


--
-- TOC entry 2612 (class 0 OID 0)
-- Dependencies: 198
-- Name: model_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.model_id_seq', 4, true);


--
-- TOC entry 2613 (class 0 OID 0)
-- Dependencies: 210
-- Name: modification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.modification_id_seq', 1, false);


--
-- TOC entry 2614 (class 0 OID 0)
-- Dependencies: 206
-- Name: order_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_history_id_seq', 1, false);


--
-- TOC entry 2615 (class 0 OID 0)
-- Dependencies: 223
-- Name: service_operation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.service_operation_id_seq', 1, false);


--
-- TOC entry 2616 (class 0 OID 0)
-- Dependencies: 221
-- Name: spare_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.spare_part_id_seq', 1, false);


--
-- TOC entry 2617 (class 0 OID 0)
-- Dependencies: 214
-- Name: tracking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tracking_id_seq', 1, false);


--
-- TOC entry 2618 (class 0 OID 0)
-- Dependencies: 212
-- Name: user_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_account_id_seq', 6, true);


--
-- TOC entry 2399 (class 2606 OID 16599)
-- Name: black_list black_list_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list
    ADD CONSTRAINT black_list_pk PRIMARY KEY (id);


--
-- TOC entry 2395 (class 2606 OID 16577)
-- Name: brand brand_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_pk PRIMARY KEY (id);


--
-- TOC entry 2389 (class 2606 OID 16556)
-- Name: car car_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_pk PRIMARY KEY (id);


--
-- TOC entry 2413 (class 2606 OID 16658)
-- Name: car_service_history car_service_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history
    ADD CONSTRAINT car_service_history_pk PRIMARY KEY (id);


--
-- TOC entry 2391 (class 2606 OID 16558)
-- Name: car car_vin_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_vin_key UNIQUE (vin);


--
-- TOC entry 2411 (class 2606 OID 16647)
-- Name: color color_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color
    ADD CONSTRAINT color_pk PRIMARY KEY (id);


--
-- TOC entry 2397 (class 2606 OID 16588)
-- Name: customer customer_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pk PRIMARY KEY (id);


--
-- TOC entry 2403 (class 2606 OID 16615)
-- Name: insurance insurance_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance
    ADD CONSTRAINT insurance_pk PRIMARY KEY (id);


--
-- TOC entry 2393 (class 2606 OID 16566)
-- Name: model model_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pk PRIMARY KEY (id);


--
-- TOC entry 2405 (class 2606 OID 16623)
-- Name: modification modification_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification
    ADD CONSTRAINT modification_pk PRIMARY KEY (id);


--
-- TOC entry 2401 (class 2606 OID 16607)
-- Name: order_history order_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_pk PRIMARY KEY (id);


--
-- TOC entry 2417 (class 2606 OID 16674)
-- Name: service_operation service_operation_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation
    ADD CONSTRAINT service_operation_pk PRIMARY KEY (id);


--
-- TOC entry 2415 (class 2606 OID 16666)
-- Name: spare_part spare_part_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part
    ADD CONSTRAINT spare_part_pk PRIMARY KEY (id);


--
-- TOC entry 2409 (class 2606 OID 16639)
-- Name: tracking tracking_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT tracking_pk PRIMARY KEY (id);


--
-- TOC entry 2407 (class 2606 OID 16631)
-- Name: user_account user_account_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_account
    ADD CONSTRAINT user_account_pk PRIMARY KEY (id);


--
-- TOC entry 2423 (class 2606 OID 16700)
-- Name: black_list black_list_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.black_list
    ADD CONSTRAINT black_list_fk0 FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 2418 (class 2606 OID 16675)
-- Name: car car_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.modification
    ADD CONSTRAINT car_fk0 FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- TOC entry 2419 (class 2606 OID 16680)
-- Name: car car_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_fk1 FOREIGN KEY (modification_id) REFERENCES public.modification(id);


--
-- TOC entry 2420 (class 2606 OID 16685)
-- Name: car car_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_fk2 FOREIGN KEY (color_id) REFERENCES public.color(id);


--
-- TOC entry 2430 (class 2606 OID 16735)
-- Name: car_service_history car_service_history_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_service_history
    ADD CONSTRAINT car_service_history_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2428 (class 2606 OID 16725)
-- Name: color_2_model color_2_model_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color_2_model
    ADD CONSTRAINT color_2_model_fk0 FOREIGN KEY (color_id) REFERENCES public.color(id);


--
-- TOC entry 2429 (class 2606 OID 16730)
-- Name: color_2_model color_2_model_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.color_2_model
    ADD CONSTRAINT color_2_model_fk1 FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- TOC entry 2422 (class 2606 OID 16695)
-- Name: customer customer_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_fk0 FOREIGN KEY (id) REFERENCES public.user_account(id);


--
-- TOC entry 2426 (class 2606 OID 16715)
-- Name: insurance insurance_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insurance
    ADD CONSTRAINT insurance_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2421 (class 2606 OID 16690)
-- Name: model model_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_fk0 FOREIGN KEY (brand_id) REFERENCES public.brand(id);


--
-- TOC entry 2424 (class 2606 OID 16705)
-- Name: order_history order_history_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_fk0 FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 2425 (class 2606 OID 16710)
-- Name: order_history order_history_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_history
    ADD CONSTRAINT order_history_fk1 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2432 (class 2606 OID 16745)
-- Name: service_operation service_operation_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.service_operation
    ADD CONSTRAINT service_operation_fk0 FOREIGN KEY (car_service_history_id) REFERENCES public.car_service_history(id);


--
-- TOC entry 2431 (class 2606 OID 16740)
-- Name: spare_part spare_part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spare_part
    ADD CONSTRAINT spare_part_fk0 FOREIGN KEY (service_operation_id) REFERENCES public.service_operation(id);


--
-- TOC entry 2427 (class 2606 OID 16720)
-- Name: tracking tracking_fk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tracking
    ADD CONSTRAINT tracking_fk0 FOREIGN KEY (car_id) REFERENCES public.car(id);


-- Completed on 2018-12-16 15:50:25 +03

--
-- PostgreSQL database dump complete
--

