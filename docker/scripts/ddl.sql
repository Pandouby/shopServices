CREATE
DATABASE IF NOT EXISTS ShopServices;
USE ShopServices;
CREATE TABLE `User`
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE `Product`
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE(11, 2),
    PRIMARY KEY (id)
);
CREATE TABLE `Order`
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    order_time DATETIME NOT NULL,
    user_id INT(11) NOT NULL,
    product_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(id) ON UPDATE CASCADE
);