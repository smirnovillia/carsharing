CREATE TABLE "car" (
	"id" serial NOT NULL,
	"modification_id" integer NOT NULL,
	"release_date" integer NOT NULL,
	"vin" character varying(50) NOT NULL UNIQUE,
	"color_id" integer NOT NULL,
	"mileage" real NOT NULL,
	"condition" character varying(50) NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT car_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "model" (
	"id" serial NOT NULL,
	"name" character varying(50) NOT NULL,
	"brand_id" integer NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT model_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "brand" (
	"id" serial NOT NULL,
	"name" character varying NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT brand_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "customer" (
	"id" serial NOT NULL,
	"first_name" character varying(50) NOT NULL,
	"last_name" character varying(50) NOT NULL,
	"birthday" DATE NOT NULL,
	"driver_license" character varying(200) NOT NULL,
	"driver_license_status" BOOLEAN NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "black_list" (
	"id" serial NOT NULL,
	"customer_id" integer NOT NULL,
	"reason" TEXT NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT black_list_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "order_history" (
	"id" serial NOT NULL,
	"customer_id" integer NOT NULL,
	"car_id" integer NOT NULL,
	"order_date" DATE NOT NULL,
	"order_mileage" real NOT NULL,
	"rate" real NOT NULL,
	"price" real NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT order_history_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "insurance" (
	"id" serial NOT NULL,
	"car_id" integer NOT NULL,
	"insurance_company" character varying(50) NOT NULL,
	"insurance_number" character varying(50) NOT NULL,
	"issued" DATE NOT NULL,
	"expiried" DATE NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT insurance_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "modification" (
	"id" serial NOT NULL,
	"model_id" integer NOT NULL,
	"body" character varying(50) NOT NULL,
	"fuel" character varying(50) NOT NULL,
	"engine_capacity" integer NOT NULL,
	"drive" character varying(50) NOT NULL,
	"gearbox" character varying(50) NOT NULL,
	"tank_capacity" integer NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT modification_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_account" (
	"id" serial NOT NULL,
	"login" character varying(50) NOT NULL,
	"password" character varying(200) NOT NULL,
	"user_role" smallint NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT user_account_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "tracking" (
	"id" serial NOT NULL,
	"car_id" integer NOT NULL,
	"latitude" real NOT NULL,
	"longitude" real NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT tracking_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "color" (
	"id" serial NOT NULL,
	"name" character varying(20) NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT color_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "color_2_model" (
	"color_id" integer NOT NULL,
	"model_id" integer NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "car_service_history" (
	"id" serial NOT NULL,
	"car_id" integer NOT NULL,
	"service_date" DATE NOT NULL,
	"car_mileage" real NOT NULL,
	"service_company" character varying(50) NOT NULL,
	"service_price" real NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT car_service_history_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "spare_part" (
	"id" serial NOT NULL,
	"service_operation_id" integer NOT NULL,
	"name" character varying(50) NOT NULL,
	"price" real NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT spare_part_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "service_operation" (
	"id" serial NOT NULL,
	"car_service_history_id" integer NOT NULL,
	"name" character varying(50) NOT NULL,
	"price" real NOT NULL,
	"created" TIMESTAMP NOT NULL,
	"updated" TIMESTAMP NOT NULL,
	CONSTRAINT service_operation_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "car" ADD CONSTRAINT "car_fk0" FOREIGN KEY ("modification_id") REFERENCES "modification"("id");
ALTER TABLE "car" ADD CONSTRAINT "car_fk1" FOREIGN KEY ("color_id") REFERENCES "color"("id");

ALTER TABLE "model" ADD CONSTRAINT "model_fk0" FOREIGN KEY ("brand_id") REFERENCES "brand"("id");

ALTER TABLE "modification" ADD CONSTRAINT "modification_fk0" FOREIGN KEY ("model_id") REFERENCES "model"("id");


ALTER TABLE "customer" ADD CONSTRAINT "customer_fk0" FOREIGN KEY ("id") REFERENCES "user_account"("id");

ALTER TABLE "black_list" ADD CONSTRAINT "black_list_fk0" FOREIGN KEY ("customer_id") REFERENCES "customer"("id");

ALTER TABLE "order_history" ADD CONSTRAINT "order_history_fk0" FOREIGN KEY ("customer_id") REFERENCES "customer"("id");
ALTER TABLE "order_history" ADD CONSTRAINT "order_history_fk1" FOREIGN KEY ("car_id") REFERENCES "car"("id");

ALTER TABLE "insurance" ADD CONSTRAINT "insurance_fk0" FOREIGN KEY ("car_id") REFERENCES "car"("id");



ALTER TABLE "tracking" ADD CONSTRAINT "tracking_fk0" FOREIGN KEY ("car_id") REFERENCES "car"("id");


ALTER TABLE "color_2_model" ADD CONSTRAINT "color_2_model_fk0" FOREIGN KEY ("color_id") REFERENCES "color"("id");
ALTER TABLE "color_2_model" ADD CONSTRAINT "color_2_model_fk1" FOREIGN KEY ("model_id") REFERENCES "model"("id");

ALTER TABLE "car_service_history" ADD CONSTRAINT "car_service_history_fk0" FOREIGN KEY ("car_id") REFERENCES "car"("id");

ALTER TABLE "spare_part" ADD CONSTRAINT "spare_part_fk0" FOREIGN KEY ("service_operation_id") REFERENCES "service_operation"("id");

ALTER TABLE "service_operation" ADD CONSTRAINT "service_operation_fk0" FOREIGN KEY ("car_service_history_id") REFERENCES "car_service_history"("id");

