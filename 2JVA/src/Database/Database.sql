CREATE DATABASE Auchan

CREATE TABLE Store (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Whitelist (
    email VARCHAR(100),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(store_id)
);

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),
    pseudo VARCHAR(50),
    password VARCHAR(100),
    isUser BOOLEAN DEFAULT true,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(store_id)
);

CREATE TABLE Inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity BETWEEN 0 AND 50),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Store(store_id)
);

INSERT INTO Store (store_id, name)
VALUES (1 , ikea);

INSERT INTO Inventory (id, name, price, quantity, store_id)
VALUES (1 , trousse, 4, 3, 1);

INSERT INTO User (email, pseudo, password, isUser, store_id)
VALUES ('admin@example.com', 'admin', 'admin_password', false, NULL);

INSERT INTO User (email, pseudo, password, isUser, store_id)
VALUES ('user@example.com', 'user', 'user_password', true, 1);

INSERT INTO Whitelist (email, store_id)
VALUES ('whitelist@example.com', 1);