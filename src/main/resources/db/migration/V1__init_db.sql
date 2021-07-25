DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users_roles;

CREATE TABLE products (id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
title VARCHAR(255),
cost FLOAT NOT NULL,
created_at   timestamp default current_timestamp,
updated_at   timestamp default current_timestamp);
INSERT INTO products (title, cost) VALUES
('Product_1',125.23),
('Product_2',256.32),
('Product_3',1258.23),
('Product_4',125.36),
('Product_5',256.52);


CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username VARCHAR(30),
    password  VARCHAR(80),
    score NUMERIC
);

CREATE TABLE roles(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name)
VALUES
('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (username, password, score)
VALUES
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 99),
('user_1', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 50),
('user_2', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 10),
('user_3', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 75);

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2);
