DROP TABLE `orderitem`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(100) NOT NULL,
    `price` DEC(6,2) NOT NULL,
    `stock_level` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `total` DEC(6,2) DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS `orderitem` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` INT(11) NOT NULL,
    `item_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);