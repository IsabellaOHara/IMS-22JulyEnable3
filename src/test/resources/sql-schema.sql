DROP TABLE `orders_items`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers`
(
   `id` INT (11) NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR (40) NULL DEFAULT NULL,
   `surname` VARCHAR (40) NULL DEFAULT NULL,
   PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items`
(
   `id` INT (11) NOT NULL AUTO_INCREMENT,
   `item_name` VARCHAR (40) NULL DEFAULT NULL,
   `price` DECIMAL(10,2) NOT NULL,
   PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders`
(
   `order_id` INT (11) NOT NULL AUTO_INCREMENT,
   `customer_id` INT NOT NULL,
   PRIMARY KEY (`order_id`),
   FOREIGN KEY (`customer_id`) REFERENCES customers (`id`)
);

CREATE TABLE IF NOT EXISTS `orders_items`
(
   `id` INT NOT NULL,
   `item_id` INT NOT NULL,
   `quantity` INT NOT NULL,
   FOREIGN KEY (`id`) REFERENCES `orders` (`order_id`),
   FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
);