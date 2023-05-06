CREATE TABLE categories (
  id_category SERIAL  NOT NULL ,
  name VARCHAR(100)   NOT NULL ,
  description TEXT      ,
PRIMARY KEY(id_category));

insert into categories (name, description) values ('Electrical and Fire Alarm', 'vehicula consequat morbi a ipsum integer a nibh in');
insert into categories (name, description) values ('Landscaping & Irrigation', 'justo nec condimentum neque sapien placerat ante nulla justo aliquam');
insert into categories (name, description) values ('Temp Fencing, Decorative Fencing and Gates', 'sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie');
insert into categories (name, description) values ('Sitework & Site Utilities', 'nec sem duis aliquam convallis nunc proin at turpis');
insert into categories (name, description) values ('Glass & Glazing', 'ac neque duis bibendum morbi non quam');
insert into categories (name, description) values ('Termite Control', 'consequat in consequat ut nulla sed accumsan');
insert into categories (name, description) values ('Framing (Steel)', 'sapien in sapien iaculis congue vivamus metus arcu adipiscing');
insert into categories (name, description) values ('Site Furnishings', 'risus praesent lectus vestibulum quam sapien varius');
insert into categories (name, description) values ('Casework', null);
insert into categories (name, description) values ('Roofing (Metal)', 'dui vel sem sed sagittis nam congue risus');


CREATE TABLE roles (
  id_rol SERIAL  NOT NULL ,
  name VARCHAR(100)   NOT NULL ,
  description TEXT    ,
  status INTEGER   NOT NULL   ,
PRIMARY KEY(id_rol));

insert into roles (name, description, status) values ('Administrador', null, 0);
insert into roles (name, description, status) values ('Cliente', null, 0 );


CREATE TABLE products (
  id_product SERIAL  NOT NULL ,
  category_id INTEGER   NOT NULL ,
  name VARCHAR(100)   NOT NULL ,
  image VARCHAR(255)   ,
  description TEXT    ,
  price DECIMAL(15,2)   NOT NULL ,
  stock INTEGER   NOT NULL ,
  brand VARCHAR(100)    ,
  model VARCHAR(100)    ,
  status INTEGER      ,
PRIMARY KEY(id_product)  ,
  FOREIGN KEY(category_id)
    REFERENCES categories(id_category)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX products_FKIndex1 ON products (category_id);


CREATE INDEX IFK_Rel_01 ON products (category_id);


insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Sauce - Hoisin', null, 'erat volutpat in congue etiam justo etiam pretium iaculis justo', 166.68, 910, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Flower - Commercial Spider', null, 'pulvinar lobortis est phasellus sit amet erat', 611.83, 145, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Raspberries - Fresh', null, 'malesuada in imperdiet et commodo vulputate justo in blandit', 886.18, 725, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Ham - Cooked', null, 'vestibulum sed magna at nunc commodo placerat praesent', 51.18, 670, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Cheese - Bocconcini', null, 'blandit nam nulla integer pede justo lacinia eget tincidunt', 278.83, 797, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Beef - Sushi Flat Iron Steak', null, 'quis justo maecenas rhoncus aliquam lacus morbi quis tortor', 992.35, 727, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Beef - Ox Tongue', null, 'blandit lacinia erat vestibulum sed magna at nunc commodo placerat', 820.61, 640, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Wine - Rosso Del Veronese Igt', null, 'in felis donec semper sapien a libero nam dui proin', 774.53, 831, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (10, 'Lambcasing', null, 'volutpat dui maecenas tristique est et tempus semper est', 221.49, 940, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Cloves - Whole', null, 'morbi porttitor lorem id ligula suspendisse ornare consequat lectus', 886.32, 919, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Chocolate - Sugar Free Semi Choc', null, 'aenean sit amet justo morbi ut odio', 694.46, 145, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (9, 'Shrimp - 150 - 250', null, 'magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet', 465.65, 442, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Beer - Fruli', null, 'vel nisl duis ac nibh fusce lacus purus aliquet at', 447.7, 224, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (4, 'Petit Baguette', null, 'ipsum praesent blandit lacinia erat vestibulum sed magna at', 843.07, 611, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Wine - Red, Antinori Santa', null, 'sem duis aliquam convallis nunc proin at turpis a', 913.43, 854, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (6, 'Duck - Fat', null, 'ullamcorper purus sit amet nulla quisque arcu', 677.21, 546, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (7, 'Wine - Red, Harrow Estates, Cab', null, 'eget massa tempor convallis nulla neque libero convallis eget', 419.57, 73, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (10, 'Red Currants', null, 'mi nulla ac enim in tempor turpis nec', 686.8, 364, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Tea - Camomele', null, 'sapien sapien non mi integer ac neque duis bibendum', 867.64, 258, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (10, 'Compound - Orange', null, 'aenean lectus pellentesque eget nunc donec quis', 291.05, 237, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Cauliflower', null, 'in lacus curabitur at ipsum ac tellus semper', 914.98, 909, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (1, 'Bandage - Flexible Neon', null, 'at turpis a pede posuere nonummy integer non velit donec', 913.41, 50, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Garlic - Elephant', null, 'felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet', 738.87, 847, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (5, 'Beef Ground Medium', null, 'mauris eget massa tempor convallis nulla neque libero convallis', 118.73, 428, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Oranges', null, 'ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque', 320.35, 798, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (4, 'Lemon Balm - Fresh', null, 'amet sem fusce consequat nulla nisl nunc nisl duis', 963.02, 810, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Cheese - Brie, Cups 125g', null, 'sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus', 700.25, 899, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (4, 'Savory', null, 'ut suscipit a feugiat et eros vestibulum', 52.16, 780, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Appetizer - Assorted Box', null, 'nulla tellus in sagittis dui vel nisl', 469.92, 761, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Cranberry Foccacia', null, 'porttitor pede justo eu massa donec dapibus duis at', 903.99, 821, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (3, 'Gatorade - Cool Blue Raspberry', null, 'est et tempus semper est quam pharetra magna', 315.16, 86, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Eggroll', null, 'curae duis faucibus accumsan odio curabitur convallis', 852.16, 126, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Pepper - Scotch Bonnet', null, 'ac nulla sed vel enim sit amet nunc', 402.23, 475, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (10, 'Cornflakes', null, 'sapien sapien non mi integer ac neque duis', 538.03, 730, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (7, 'Glucose', null, 'elit ac nulla sed vel enim sit amet nunc viverra', 172.1, 599, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'The Pop Shoppe Pinapple', null, 'amet sem fusce consequat nulla nisl nunc nisl', 236.57, 855, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (2, 'Wine - Balbach Riverside', null, 'elementum eu interdum eu tincidunt in leo maecenas', 468.06, 334, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (4, 'Tray - 16in Rnd Blk', null, 'varius nulla facilisi cras non velit nec', 643.03, 200, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Pastry - Butterscotch Baked', null, 'convallis duis consequat dui nec nisi volutpat eleifend donec ut', 543.82, 794, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (10, 'Chips Potato Salt Vinegar 43g', null, 'aenean auctor gravida sem praesent id massa', 340.75, 624, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (5, 'Cheese Cheddar Processed', null, 'hac habitasse platea dictumst aliquam augue quam sollicitudin', 681.37, 360, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (6, 'Container - Clear 32 Oz', null, 'platea dictumst morbi vestibulum velit id pretium iaculis diam', 227.25, 972, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (8, 'Energy Drink - Franks Pineapple', null, 'tellus nisi eu orci mauris lacinia sapien quis libero nullam', 779.53, 40, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (4, 'Dried Cranberries', null, 'ante ipsum primis in faucibus orci luctus', 323.14, 515, null, null, 0);
insert into products (category_id, name, image, description, price, stock, brand, model, status) values (5, 'Pork - Loin, Center Cut', null, 'et ultrices posuere cubilia curae duis faucibus', 139.22, 102, null, null, 0);


CREATE TABLE images (
  id_image SERIAL  NOT NULL ,
  product_id INTEGER   NOT NULL ,
  image VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id_image)  ,
  FOREIGN KEY(product_id)
    REFERENCES products(id_product)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX images_FKIndex1 ON images (product_id);


CREATE INDEX IFK_Rel_10 ON images (product_id);


CREATE TABLE persons (
  id_person SERIAL  NOT NULL ,
  rol_id INTEGER   NOT NULL ,
  first_name VARCHAR(100)   NOT NULL ,
  second_name VARCHAR(100)    ,
  first_lastname VARCHAR(100)   NOT NULL ,
  second_lastname VARCHAR(100)   NOT NULL ,
  phone VARCHAR(20)   NOT NULL ,
  email VARCHAR(200)   NOT NULL ,
  date_birth DATE      ,
PRIMARY KEY(id_person)  ,
  FOREIGN KEY(rol_id)
    REFERENCES roles(id_rol)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX persons_FKIndex1 ON persons (rol_id);


CREATE INDEX IFK_Rel_09 ON persons (rol_id);


insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (1, 'Salvidor', 'Breanne', 'Kerner', 'Valentinetti', '9203217154', 'bvalentinetti0@nba.com', '1923-02-06');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (1, 'Kym', 'Roosevelt', 'Bemment', 'Roach', '1129938286', 'rroach1@umn.edu', '1928-08-02');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (1, 'Dulcea', 'Rem', 'Castiello', 'Nise', '1964822207', 'rnise2@1688.com', '2015-04-01');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (1, 'Giavani', 'Gery', 'Shier', 'Silkston', '4453808834', 'gsilkston3@tumblr.com', '1974-10-13');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Erskine', 'Aarika', 'Forty', 'Mahomet', '5724663492', 'amahomet4@tumblr.com', '1978-12-16');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Ilsa', 'Holden', 'De la croix', 'Cotterel', '4167366594', 'hcotterel5@imgur.com', '1962-07-27');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (1, 'Bobina', 'Keven', 'Willmer', 'Lyddyard', '6299895560', 'klyddyard6@ustream.tv', '1948-04-13');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Kanya', 'Paton', 'Twopenny', 'Richardes', '7538831684', 'prichardes7@harvard.edu', '1936-09-09');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Linda', 'Ennis', 'Reicharz', 'Drinkall', '9806948882', 'edrinkall8@ed.gov', '1930-02-01');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Natalya', 'Geri', 'Loffill', 'Pretious', '9542761489', 'gpretious9@nifty.com', '1986-12-12');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Blair', 'Gasparo', 'Carnachen', 'Bubeer', '1742551473', 'gbubeera@ycombinator.com', '1961-01-18');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Maggie', null, 'Houchin', 'Blazynski', '9399535834', 'bblazynskib@abc.net.au', '1957-08-24');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Emmaline', 'Arleta', 'Cahani', 'Harnes', '9521891544', 'aharnesc@japanpost.jp', '2020-11-30');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Bald', null, 'Lassen', 'Pawlett', '7378622235', 'fpawlettd@sciencedaily.com', '1986-12-03');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Frayda', 'Georgette', 'Vallance', 'Pevsner', '4233661228', 'gpevsnere@illinois.edu', '1976-12-02');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Thomasin', 'Lilian', 'Elix', 'MacIlhagga', '1316608647', 'lmacilhaggaf@symantec.com', '2002-06-04');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Evangelia', 'Chloe', 'Gueny', 'Misson', '5038581192', 'cmissong@reverbnation.com', '2010-07-27');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Zebadiah', null, 'Readhead', 'Alaway', '5091517546', 'balawayh@narod.ru', '1938-12-22');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Justine', null, 'MacMoyer', 'Fleet', '7271958268', 'afleeti@vistaprint.com', '1926-07-03');
insert into persons (rol_id, first_name, second_name, first_lastname, second_lastname, phone, email, date_birth) values (2, 'Justus', null, 'Coonihan', 'Foyle', '2286295204', 'bfoylej@goo.gl', '2015-12-02');


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

insert into carts (person_id, product_id, quantity) values (13, 30, 82);
insert into carts (person_id, product_id, quantity) values (19, 14, 17);
insert into carts (person_id, product_id, quantity) values (16, 19, 27);
insert into carts (person_id, product_id, quantity) values (14, 9, 50);
insert into carts (person_id, product_id, quantity) values (11, 10, 23);
insert into carts (person_id, product_id, quantity) values (16, 19, 88);
insert into carts (person_id, product_id, quantity) values (2, 28, 79);
insert into carts (person_id, product_id, quantity) values (4, 18, 41);
insert into carts (person_id, product_id, quantity) values (1, 20, 85);
insert into carts (person_id, product_id, quantity) values (14, 13, 11);
insert into carts (person_id, product_id, quantity) values (20, 7, 35);
insert into carts (person_id, product_id, quantity) values (15, 6, 93);
insert into carts (person_id, product_id, quantity) values (15, 27, 91);
insert into carts (person_id, product_id, quantity) values (3, 3, 77);
insert into carts (person_id, product_id, quantity) values (1, 8, 100);
insert into carts (person_id, product_id, quantity) values (8, 23, 11);
insert into carts (person_id, product_id, quantity) values (2, 15, 18);
insert into carts (person_id, product_id, quantity) values (8, 6, 48);
insert into carts (person_id, product_id, quantity) values (20, 25, 52);
insert into carts (person_id, product_id, quantity) values (15, 12, 6);
insert into carts (person_id, product_id, quantity) values (19, 10, 12);
insert into carts (person_id, product_id, quantity) values (4, 15, 83);
insert into carts (person_id, product_id, quantity) values (20, 2, 38);
insert into carts (person_id, product_id, quantity) values (11, 24, 38);
insert into carts (person_id, product_id, quantity) values (11, 24, 84);
insert into carts (person_id, product_id, quantity) values (20, 11, 97);
insert into carts (person_id, product_id, quantity) values (6, 17, 17);
insert into carts (person_id, product_id, quantity) values (17, 21, 33);
insert into carts (person_id, product_id, quantity) values (2, 28, 1);
insert into carts (person_id, product_id, quantity) values (18, 28, 91);
insert into carts (person_id, product_id, quantity) values (1, 28, 6);
insert into carts (person_id, product_id, quantity) values (12, 22, 41);
insert into carts (person_id, product_id, quantity) values (19, 11, 44);
insert into carts (person_id, product_id, quantity) values (17, 8, 76);
insert into carts (person_id, product_id, quantity) values (5, 22, 10);
insert into carts (person_id, product_id, quantity) values (14, 22, 42);
insert into carts (person_id, product_id, quantity) values (4, 1, 51);
insert into carts (person_id, product_id, quantity) values (12, 19, 74);
insert into carts (person_id, product_id, quantity) values (11, 29, 84);
insert into carts (person_id, product_id, quantity) values (12, 28, 100);


CREATE TABLE purchases (
  id_purchase SERIAL  NOT NULL ,
  person_id INTEGER   NOT NULL ,
  date_purchase TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL  NOT NULL ,
  status INTEGER    ,
  type_payment VARCHAR(100)   NOT NULL ,
  id_transaction VARCHAR(255)    ,
  reference VARCHAR(255)      ,
PRIMARY KEY(id_purchase)  ,
  FOREIGN KEY(person_id)
    REFERENCES persons(id_person)
      ON DELETE CASCADE
      ON UPDATE CASCADE);


CREATE INDEX purchases_FKIndex1 ON purchases (person_id);


CREATE INDEX IFK_Rel_02 ON purchases (person_id);

insert into purchases (person_id, status, type_payment, id_transaction, reference) values (6, 0, 'jcb', null, '3547264784309508');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (3, 0, 'americanexpress', null, '372301533477370');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (8, 0, 'china-unionpay', null, '5610307653475574');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (10, 0, 'jcb', null, '3579610945317098');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (15, 0, 'jcb', null, '3568831079602062');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (8, 0, 'jcb', null, '3551160596428523');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (8, 0, 'jcb', null, '3528485355352964');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (13, 0, 'jcb', null, '3586516904314136');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (4, 0, 'mastercard', null, '5479066552396311');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (16, 0, 'bankcard', null, '5610544093460614');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (19, 0, 'switch', null, '633110563237674959');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (8, 0, 'jcb', null, '3538915517670349');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (11, 0, 'jcb', null, '3538073190258493');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (4, 0, 'switch', null, '675954569140836247');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (9, 0, 'jcb', null, '3528830935922135');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (9, 0, 'instapayment', null, '6396690787762597');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (20, 0, 'jcb', null, '3586484148830997');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (16, 0, 'jcb', null, '3555658204389082');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (10, 0, 'jcb', null, '3549208862932838');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (8, 0, 'visa-electron', null, '4913105455191788');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (16, 0, 'diners-club-enroute', null, '201714330802920');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (1, 0, 'mastercard', null, '5449782781173027');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (7, 0, 'jcb', null, '3569786182434986');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (12, 0, 'bankcard', null, '5602248307910345');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (3, 0, 'mastercard', null, '5010126931043053');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (14, 0, 'jcb', null, '3575237116820835');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (18, 0, 'jcb', null, '3532126677200549');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (13, 0, 'jcb', null, '3588116847278080');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (3, 0, 'americanexpress', null, '378605148429137');
insert into purchases (person_id, status, type_payment, id_transaction, reference) values (2, 0, 'jcb', null, '3553928960502257');


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


insert into users (person_id, username, password, token) values (1, 'bbuckles0', 'Bhnri3O', null);
insert into users (person_id, username, password, token) values (2, 'ftruter1', 't1HbXOr', null);
insert into users (person_id, username, password, token) values (3, 'ggashion2', 'zZyuexf', null);
insert into users (person_id, username, password, token) values (4, 'tstave3', 'J3EH1VNP3gD', null);
insert into users (person_id, username, password, token) values (5, 'lrudman4', 'UolJEYgLj9v', null);
insert into users (person_id, username, password, token) values (6, 'medelman5', 'Jvg77cIWn', null);
insert into users (person_id, username, password, token) values (7, 'lchaldecott6', '54w9myNa7', null);
insert into users (person_id, username, password, token) values (8, 'titzchaki7', 'LL1GPPrri5B', null);
insert into users (person_id, username, password, token) values (9, 'pnurden8', 'jLs34oObZ', null);
insert into users (person_id, username, password, token) values (10, 'tlamas9', 'gXF3x0pgP', null);
insert into users (person_id, username, password, token) values (11, 'kgrollmanna', 'RrzTolGwABLt', null);
insert into users (person_id, username, password, token) values (12, 'iwellfareb', 'wkVxJaiQl4B', null);
insert into users (person_id, username, password, token) values (13, 'sgedlingc', 'yFsBqw4', null);
insert into users (person_id, username, password, token) values (14, 'ggorgend', 'r8ne7E', null);
insert into users (person_id, username, password, token) values (15, 'klauthiane', 'xq6KfJ3FLxJz', null);
insert into users (person_id, username, password, token) values (16, 'pkenrackf', 'Qpdt6kR4ze0', null);
insert into users (person_id, username, password, token) values (17, 'joleksinskig', 'k7P6cX7Z', null);
insert into users (person_id, username, password, token) values (18, 'jletterickh', 'PdNSKQ', null);
insert into users (person_id, username, password, token) values (19, 'tgoulstonei', 'ZURz4spm4', null);
insert into users (person_id, username, password, token) values (20, 'sbeaconj', 'BNcEMqaoXg', null);


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

insert into addresses (person_id, address, city, country, postal_code) values (1, '9483 Mifflin Pass', 'Tanjay', 'Philippines', '0603-3181');
insert into addresses (person_id, address, city, country, postal_code) values (2, '2019 Fieldstone Way', 'Martingança-Gare', 'Portugal', '68788-0435');
insert into addresses (person_id, address, city, country, postal_code) values (3, '246 Golf Drive', 'San Francisco', 'Argentina', '52685-431');
insert into addresses (person_id, address, city, country, postal_code) values (4, '84432 Hermina Point', 'Mont-Joli', 'Canada', '10893-400');
insert into addresses (person_id, address, city, country, postal_code) values (5, '6 Waxwing Center', 'Río Alejandro', 'Panama', '57664-327');
insert into addresses (person_id, address, city, country, postal_code) values (6, '0 Cardinal Trail', 'Banjar Dukuh', 'Indonesia', '51655-290');
insert into addresses (person_id, address, city, country, postal_code) values (7, '779 Holmberg Circle', 'Haibara', 'Japan', '63323-465');
insert into addresses (person_id, address, city, country, postal_code) values (8, '3 Westport Park', 'Shancheng', 'China', '68151-4668');
insert into addresses (person_id, address, city, country, postal_code) values (9, '3 Boyd Court', 'Sukhobuzimskoye', 'Russia', '0078-0408');
insert into addresses (person_id, address, city, country, postal_code) values (10, '64450 Beilfuss Alley', 'Mahe', 'China', '42291-320');
insert into addresses (person_id, address, city, country, postal_code) values (11, '8 Kim Court', 'Čáslav', 'Czech Republic', '43063-096');
insert into addresses (person_id, address, city, country, postal_code) values (12, '22074 La Follette Park', 'Jāwā', 'Jordan', '30142-966');
insert into addresses (person_id, address, city, country, postal_code) values (13, '07867 Northview Point', 'Charenton-le-Pont', 'France', '51079-629');
insert into addresses (person_id, address, city, country, postal_code) values (14, '4 Mendota Junction', 'Youxikou', 'China', '24571-104');
insert into addresses (person_id, address, city, country, postal_code) values (15, '38721 American Plaza', 'Mulanay', 'Philippines', '59854-300');
insert into addresses (person_id, address, city, country, postal_code) values (16, '3 Dunning Circle', 'Dhangarhi', 'Nepal', '0378-0214');
insert into addresses (person_id, address, city, country, postal_code) values (17, '3082 Thompson Point', 'Jieshou', 'China', '68788-0285');
insert into addresses (person_id, address, city, country, postal_code) values (18, '92 Paget Crossing', 'Oibioin', 'Indonesia', '11673-622');
insert into addresses (person_id, address, city, country, postal_code) values (19, '36 Glendale Street', 'Hwange', 'Zimbabwe', '0168-0162');
insert into addresses (person_id, address, city, country, postal_code) values (20, '7212 Kings Place', 'Nenotes', 'Indonesia', '64720-237');


CREATE TABLE purchases_details (
  id_purchase_detail SERIAL  NOT NULL ,
  product_id INTEGER   NOT NULL ,
  purchase_id INTEGER   NOT NULL ,
  quantity INTEGER   NOT NULL ,
  price DECIMAL(15,2)   NOT NULL   ,
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


insert into purchases_details (product_id, purchase_id, quantity, price) values (5, 18, 64.81, 989.82);
insert into purchases_details (product_id, purchase_id, quantity, price) values (21, 3, 22.55, 834.31);
insert into purchases_details (product_id, purchase_id, quantity, price) values (26, 26, 216.82, 261.94);
insert into purchases_details (product_id, purchase_id, quantity, price) values (19, 28, 239.23, 611.86);
insert into purchases_details (product_id, purchase_id, quantity, price) values (9, 1, 702.78, 501.42);
insert into purchases_details (product_id, purchase_id, quantity, price) values (30, 5, 743.22, 846.63);
insert into purchases_details (product_id, purchase_id, quantity, price) values (20, 28, 743.24, 810.24);
insert into purchases_details (product_id, purchase_id, quantity, price) values (19, 21, 551.78, 154.43);
insert into purchases_details (product_id, purchase_id, quantity, price) values (8, 3, 243.15, 833.29);
insert into purchases_details (product_id, purchase_id, quantity, price) values (6, 13, 641.23, 493.31);
insert into purchases_details (product_id, purchase_id, quantity, price) values (13, 13, 731.33, 926.48);
insert into purchases_details (product_id, purchase_id, quantity, price) values (17, 3, 512.21, 564.38);
insert into purchases_details (product_id, purchase_id, quantity, price) values (20, 24, 362.44, 775.6);
insert into purchases_details (product_id, purchase_id, quantity, price) values (30, 20, 755.15, 549.59);
insert into purchases_details (product_id, purchase_id, quantity, price) values (20, 4, 624.3, 969.52);
insert into purchases_details (product_id, purchase_id, quantity, price) values (27, 30, 251.27, 394.78);
insert into purchases_details (product_id, purchase_id, quantity, price) values (19, 1, 303.22, 282.61);
insert into purchases_details (product_id, purchase_id, quantity, price) values (5, 7, 938.98, 300.92);
insert into purchases_details (product_id, purchase_id, quantity, price) values (19, 11, 618.92, 954.49);
insert into purchases_details (product_id, purchase_id, quantity, price) values (2, 29, 58.61, 17.58);
insert into purchases_details (product_id, purchase_id, quantity, price) values (12, 5, 673.31, 205.99);
insert into purchases_details (product_id, purchase_id, quantity, price) values (29, 24, 76.52, 206.45);
insert into purchases_details (product_id, purchase_id, quantity, price) values (12, 28, 447.46, 397.71);
insert into purchases_details (product_id, purchase_id, quantity, price) values (8, 14, 829.75, 31.84);
insert into purchases_details (product_id, purchase_id, quantity, price) values (11, 11, 373.25, 246.7);
insert into purchases_details (product_id, purchase_id, quantity, price) values (20, 21, 139.58, 741.86);
insert into purchases_details (product_id, purchase_id, quantity, price) values (15, 9, 421.1, 402.14);
insert into purchases_details (product_id, purchase_id, quantity, price) values (30, 19, 721.05, 413.23);
insert into purchases_details (product_id, purchase_id, quantity, price) values (3, 5, 458.87, 392.49);
insert into purchases_details (product_id, purchase_id, quantity, price) values (23, 9, 45.19, 163.36);