CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  author character varying(100) NOT NULL,
  launch_date timestamp NOT NULL,
  price decimal(65,2) NOT NULL,
  title character varying(100) NOT NULL
);