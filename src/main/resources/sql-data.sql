INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('green sweatshirt', 35.50);

INSERT INTO `ims`.`orders` (`customer_id`) VALUES (1);

INSERT INTO `orders_items` (`id`, `item_id`, `quantity`) VALUES (1, 1, 2);