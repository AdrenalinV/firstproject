DROP TABLE IF EXISTS details_addresses;
DROP TABLE IF EXISTS users_details;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS users;

CREATE TABLE products (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(255),
cost FLOAT NOT NULL,
created_at   timestamp default current_timestamp,
updated_at   timestamp default current_timestamp
);

CREATE TABLE order_items(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(255),
    quantity INTEGER,
    price_per_product FLOAT,
    price FLOAT
    );

CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username VARCHAR(30),
    password  VARCHAR(80),
    delete_at timestamp default null
);

CREATE TABLE roles(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

CREATE TABLE users_roles(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE addresses(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    country VARCHAR(40) NOT NULL,
    region VARCHAR(40) NOT NULL,
    city VARCHAR(40) NOT NULL,
    street VARCHAR(40) NOT NULL,
    house_number INTEGER NOT NULL,
    apartment_number INTEGER,
    postcode INTEGER NOT NULL
);

CREATE TABLE users_details(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    birthdate timestamp,
    gender VARCHAR(1),
    status VARCHAR(10),
    delete_at timestamp,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE details_addresses(
    details_id INTEGER NOT NULL,
    address_id INTEGER NOT NULL,
    PRIMARY KEY (details_id , address_id),
    FOREIGN KEY (details_id) REFERENCES users_details (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);
INSERT INTO products (title, cost) VALUES
('Product_1',125.23),
('Product_2',256.32),
('Product_3',1258.23),
('Product_4',125.36),
('Product_5',256.52);

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

