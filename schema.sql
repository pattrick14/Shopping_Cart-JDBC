CREATE DATABASE Shoppingdb;
USE Shoppingdb;

CREATE TABLE Users (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    email VARCHAR(100),
    password varchar(100),
    userType ENUM('Admin', 'Customer')
);

CREATE TABLE Products (
    productId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    price DECIMAL(10,2),
    stockQuantity INT
);

CREATE TABLE Orders (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    status ENUM('Pending', 'Completed', 'Delivered', 'Cancelled'),
    FOREIGN KEY (customerId) REFERENCES Users(userId)
);

CREATE TABLE OrderDetails (
    orderId INT,
    productId INT,
    quantity INT,
    PRIMARY KEY (orderId, productId),
    FOREIGN KEY (orderId) REFERENCES Orders(orderId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

INSERT into Users(username, email, password, usertype) VALUES ("admin", "a@gmail.com", "admin", "Admin"),("user", "a@gmail.com", "user", "Customer");
