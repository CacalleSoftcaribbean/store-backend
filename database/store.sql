CREATE TABLE categories (
  id_category SERIAL  NOT NULL ,
  name VARCHAR(100)   NOT NULL ,
  description TEXT      ,
PRIMARY KEY(id_category));




CREATE TABLE persons (
  id_person SERIAL  NOT NULL ,
  first_name VARCHAR(100)   NOT NULL ,
  second_name VARCHAR(100)    ,
  first_lastname VARCHAR(100)   NOT NULL ,
  second_lastname VARCHAR(100)   NOT NULL ,
  phone VARCHAR(20)   NOT NULL ,
  email VARCHAR(200)   NOT NULL ,
  date_birth DATE   NOT NULL   ,
PRIMARY KEY(id_person));




CREATE TABLE purchases (
  id_purchase SERIAL  NOT NULL ,
  person_id INTEGER   NOT NULL ,
  date_purchase TIMESTAMP   NOT NULL   ,
PRIMARY KEY(id_purchase)  ,
  FOREIGN KEY(person_id)
    REFERENCES persons(id_person)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX purchases_FKIndex1 ON purchases (person_id);


CREATE INDEX IFK_Rel_02 ON purchases (person_id);


CREATE TABLE users (
  id_user SERIAL  NOT NULL ,
  person_id INTEGER UNIQUE  NOT NULL ,
  username VARCHAR(100)   NOT NULL ,
  password VARCHAR(50)   NOT NULL ,
  token TEXT      ,
PRIMARY KEY(id_user)  ,
  FOREIGN KEY(person_id)
    REFERENCES persons(id_person)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX users_FKIndex1 ON users (person_id);


CREATE INDEX IFK_Rel_06 ON users (person_id);


CREATE TABLE products (
  id_product SERIAL  NOT NULL ,
  category_id INTEGER   NOT NULL ,
  name VARCHAR(100)   NOT NULL ,
  description TEXT    ,
  price DECIMAL(15,2)   NOT NULL ,
  stock INTEGER   NOT NULL ,
  brand VARCHAR(100)    ,
  model VARCHAR(100)      ,
PRIMARY KEY(id_product)  ,
  FOREIGN KEY(category_id)
    REFERENCES categories(id_category)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX products_FKIndex1 ON products (category_id);


CREATE INDEX IFK_Rel_01 ON products (category_id);


CREATE TABLE addresses (
  id_address SERIAL  NOT NULL ,
  person_id INTEGER   NOT NULL ,
  address VARCHAR(200)   NOT NULL ,
  city VARCHAR(100)   NOT NULL ,
  country VARCHAR(100)   NOT NULL ,
  postal_code VARCHAR(20)   NOT NULL   ,
PRIMARY KEY(id_address)  ,
  FOREIGN KEY(person_id)
    REFERENCES persons(id_person)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX addresses_FKIndex1 ON addresses (person_id);


CREATE INDEX IFK_Rel_05 ON addresses (person_id);


CREATE TABLE carts (
  id_cart SERIAL  NOT NULL ,
  person_id INTEGER   NOT NULL ,
  product_id INTEGER   NOT NULL ,
  quantity INTEGER   NOT NULL   ,
PRIMARY KEY(id_cart)    ,
  FOREIGN KEY(product_id)
    REFERENCES products(id_product)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(person_id)
    REFERENCES persons(id_person)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX carts_FKIndex1 ON carts (product_id);
CREATE INDEX carts_FKIndex2 ON carts (person_id);


CREATE INDEX IFK_Rel_07 ON carts (product_id);
CREATE INDEX IFK_Rel_08 ON carts (person_id);


CREATE TABLE purchases_details (
  id_purchase_detail SERIAL  NOT NULL ,
  product_id INTEGER   NOT NULL ,
  purchase_id INTEGER   NOT NULL ,
  quantity INTEGER   NOT NULL   ,
PRIMARY KEY(id_purchase_detail)    ,
  FOREIGN KEY(purchase_id)
    REFERENCES purchases(id_purchase)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(product_id)
    REFERENCES products(id_product)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX purchases_details_FKIndex1 ON purchases_details (purchase_id);
CREATE INDEX purchases_details_FKIndex2 ON purchases_details (product_id);


CREATE INDEX IFK_Rel_03 ON purchases_details (purchase_id);
CREATE INDEX IFK_Rel_04 ON purchases_details (product_id);



