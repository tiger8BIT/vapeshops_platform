create sequence mariadb_sequence start with 1 increment by 1;;

CREATE TABLE `product` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `name` varchar(255) UNIQUE NOT NULL,
    `info` mediumtext,
    `brand_fk` int NOT NULL
);;

CREATE TABLE `product_image` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `product_fk` int NOT NULL,
    `image` varchar(2048) UNIQUE NOT NULL
);;

CREATE TABLE `vapeshop_image` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `vapeshop_fk` int NOT NULL,
    `image` varchar(2048) UNIQUE NOT NULL
);;

CREATE TABLE `order` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `delivery_fk` int DEFAULT NULL,
    `datetime` datetime DEFAULT CURRENT_TIMESTAMP
);;

CREATE TABLE `order_price` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `amount` int CHECK(`amount` > 1),
    `price_fk` int NOT NULL,
    `order_fk` int NOT NULL
);;

CREATE TABLE `delivery` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `datetime` datetime NOT NULL,
    `price_fk` int NOT NULL,
    `address_fk` int NOT NULL
);;

CREATE TABLE `delivery_price` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `price` float NOT NULL CHECK(`price` > 0),
    `city_fk` int NOT NULL,
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `commercial_network` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `name` varchar(255) UNIQUE NOT NULL,
    `info` mediumtext,
    `logo` varchar(2048) UNIQUE
);;

CREATE TABLE `vapeshop` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `address_fk` int NOT NULL,
    `commercial_network_fk` int,
    `pickup` boolean
);;

CREATE TABLE `address` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `address` varchar(30),
    `city_fk` int NOT NULL
);;

CREATE TABLE `country` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `name` varchar(255) UNIQUE NOT NULL,
    `phone_prefix` varchar(5) UNIQUE NOT NULL,
    `currency` varchar(5) UNIQUE NOT NULL
);;

CREATE TABLE `city` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `name` varchar(255) UNIQUE NOT NULL,
    `country_fk` int NOT NULL
);;

CREATE TABLE `phone_number` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `number` varchar(15) NOT NULL,
    `country_fk` int NOT NULL,
    `description` mediumtext,
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `contact_link` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `link` varchar(100),
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `price` (
     `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
     `product_fk` int NOT NULL,
     `value` float CHECK(`value` > 0),
     `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `e_liquid` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `product_fk` int NOT NULL UNIQUE,
    `blend_ratio_fk` int NOT NULL,
    `nicotine` int CHECK(`nicotine` >= 0),
    `salt_nicotine` int  CHECK(`salt_nicotine` >= 0),
    `volume` int  CHECK(`volume` > 0),
    `mint_menthol` boolean
);;

CREATE TABLE `e_liquid_flavor_profile` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `flavor_profile_fk` int NOT NULL,
    `e_liquid_fk` int NOT NULL
);;

CREATE TABLE `flavor_profile` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `name` varchar(255)
);;

CREATE TABLE `blend_ratio` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `vg` int CHECK(`vg` > 0),
    `pg` int CHECK(`pg` > 0)
);;

CREATE TABLE `brand` (
     `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
     `name` varchar(255) UNIQUE NOT NULL,
     `logo` varchar(2048) UNIQUE,
     `info` mediumtext
);;

CREATE TABLE `sale` (
    `id` int UNIQUE PRIMARY KEY NOT NULL DEFAULT (NEXT VALUE FOR mariadb_sequence),
    `percent` int CHECK('percent' > 0 and 'percent' < 100),
    `price_fk` int NOT NULL
);;

ALTER TABLE `product` ADD FOREIGN KEY (`brand_fk`) REFERENCES `brand` (`id`) ON DELETE CASCADE;;

ALTER TABLE `order_price` ADD FOREIGN KEY (`price_fk`) REFERENCES `price` (`id`);;

ALTER TABLE `order_price` ADD FOREIGN KEY (`order_fk`) REFERENCES `order` (`id`) ON DELETE CASCADE;;

ALTER TABLE `order` ADD FOREIGN KEY (`delivery_fk`) REFERENCES `delivery` (`id`);;

ALTER TABLE `delivery` ADD FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`);;

ALTER TABLE `delivery` ADD FOREIGN KEY (`price_fk`) REFERENCES `delivery_price` (`id`);;

ALTER TABLE `delivery_price` ADD FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`) ON DELETE CASCADE;;

ALTER TABLE `delivery_price` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `vapeshop` ADD FOREIGN KEY (`address_fk`) REFERENCES `address` (`id`);;

ALTER TABLE `vapeshop` ADD FOREIGN KEY (`commercial_network_fk`) REFERENCES `commercial_network` (`id`);;

ALTER TABLE `address` ADD FOREIGN KEY (`city_fk`) REFERENCES `city` (`id`);;

ALTER TABLE `city` ADD FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`) ON DELETE CASCADE;;

ALTER TABLE `phone_number` ADD FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`) ON DELETE CASCADE;;

ALTER TABLE `phone_number` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `contact_link` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `price` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `price` ADD FOREIGN KEY (`product_fk`) REFERENCES `product` (`id`) ON DELETE CASCADE;;

ALTER TABLE `e_liquid` ADD FOREIGN KEY (`product_fk`) REFERENCES `product` (`id`) ON DELETE CASCADE;;

ALTER TABLE `e_liquid` ADD FOREIGN KEY (`blend_ratio_fk`) REFERENCES `blend_ratio` (`id`);;

ALTER TABLE `sale` ADD FOREIGN KEY (`price_fk`) REFERENCES `price` (`id`)  ON DELETE CASCADE;;

ALTER TABLE `product_image` ADD FOREIGN KEY (`product_fk`) REFERENCES `product` (`id`) ON DELETE CASCADE;;

ALTER TABLE `vapeshop_image` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `e_liquid_flavor_profile` ADD FOREIGN KEY (`e_liquid_fk`) REFERENCES `e_liquid` (`id`);;

ALTER TABLE `e_liquid_flavor_profile` ADD FOREIGN KEY (`flavor_profile_fk`) REFERENCES `flavor_profile` (`id`);;

CREATE FUNCTION `GetSumm` (order_price_id int)
    RETURNS int DETERMINISTIC
BEGIN
    DECLARE Summ int;
    SELECT op.amount*p.value INTO Summ
    FROM order_price as op, price as p
    WHERE op.id = order_price_id AND p.product_fk = op.price_fk;
    RETURN Summ;
END;;

CREATE FUNCTION `GetOrderPrice` (order_id int)
    RETURNS int DETERMINISTIC
BEGIN
    DECLARE Summ int DEFAULT 0;
    SELECT Summ + GetSumm(op.id) INTO Summ
    FROM `order` as o, order_price as op
    WHERE op.order_fk = o.id;
    SELECT Summ + dp.price INTO Summ
    FROM `order` as o, delivery as d, delivery_price as dp
    WHERE o.delivery_fk IS NOT NULL AND o.delivery_fk = d.id AND d.price_fk = dp.id;
    RETURN Summ;
END;;

CREATE PROCEDURE getAvailableCountries(vepeshop_id int)
BEGIN
    SELECT DISTINCT co.id
    FROM vapeshop as v, delivery_price as dp, country as co, city as ci
    WHERE vepeshop_id = v.id AND dp.vapeshop_fk = v.id
      AND ci.id = dp.city_fk AND co.id = ci.country_fk;
END;;

CREATE PROCEDURE getAvailableCities(vepeshop_id int)
BEGIN
    SELECT DISTINCT ci.id
    FROM vapeshop as v, delivery_price as dp, country as co, city as ci
    WHERE vepeshop_id = v.id AND dp.vapeshop_fk = v.id
      AND ci.id = dp.city_fk AND co.id = ci.country_fk
    UNION
    SELECT c.id
    FROM vapeshop as v, address as a, city as c
    WHERE vepeshop_id = v.id AND v.pickup AND v.address_fk = a.id AND a.city_fk = c.id;
END;;

CREATE FUNCTION `isCommNetworkCanDeliverByCountry` (vapeshop_id int, country_id int)
    RETURNS boolean DETERMINISTIC
BEGIN
    RETURN (country_id IN (getAvailableCountries(vapeshop_id)));
END;;

CREATE FUNCTION `isCommNetworkCanDeliverByCity` (vapeshop_id int, city_id int)
    RETURNS boolean DETERMINISTIC
BEGIN
    RETURN (city_id IN (getAvailableCities(vapeshop_id)));
END;;

CREATE FUNCTION `capitalize`(s varchar(255)) RETURNS varchar(255)
BEGIN
    declare c int;
    declare x varchar(255);
    declare y varchar(255);
    declare z varchar(255);

    set s = LOWER(s);
    set x = UPPER( SUBSTRING( s, 1, 1));
    set y = SUBSTR( s, 2);
    set c = instr( y, ' ');

    while c > 0
        do
            set z = SUBSTR( y, 1, c);
            set x = CONCAT( x, z);
            set z = UPPER( SUBSTR( y, c+1, 1));
            set x = CONCAT( x, z);
            set y = SUBSTR( y, c+2);
            set c = INSTR( y, ' ');
        end while;
    set x = CONCAT(x, y);
    return x;
END;;

CREATE PROCEDURE getPricesByProductId(product_id int)
BEGIN
    SELECT * FROM price
    WHERE product_id = product_fk;
END;;

CREATE TRIGGER city_first_l_up_insert BEFORE INSERT ON city FOR EACH ROW
    SET NEW.name = capitalize(NEW.name);;

CREATE TRIGGER city_first_l_up_update BEFORE UPDATE ON city FOR EACH ROW
    SET NEW.name = capitalize(NEW.name);;

CREATE TRIGGER country_first_l_up_insert BEFORE INSERT ON country FOR EACH ROW
    SET NEW.name = capitalize(NEW.name);;

CREATE TRIGGER country_first_l_up_update BEFORE UPDATE ON country FOR EACH ROW
    SET NEW.name = capitalize(NEW.name);;

CREATE TRIGGER vapeshop_image_lower_insert BEFORE INSERT ON vapeshop_image FOR EACH ROW
    SET NEW.image = LOWER(NEW.image);;

CREATE TRIGGER vapeshop_image_lower_update BEFORE UPDATE ON vapeshop_image FOR EACH ROW
    SET NEW.image = LOWER(NEW.image);;

CREATE TRIGGER phone_number_validate_insert
    BEFORE INSERT ON phone_number FOR EACH ROW
BEGIN
    IF NEW.number REGEXP '[^0-9]+'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: only digits allows';
    END IF;
END;;

CREATE TRIGGER phone_number_validate_update
    BEFORE UPDATE ON phone_number FOR EACH ROW
BEGIN
    IF NEW.number REGEXP '[^0-9]+'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: only digits allows';
    END IF;
END;;

CREATE TRIGGER delivery_price_validate_insert
    BEFORE INSERT ON delivery_price FOR EACH ROW
BEGIN
    IF 0 != (SELECT COUNT(*)
            FROM delivery_price
            WHERE NEW.id != delivery_price.id
                AND delivery_price.city_fk = NEW.city_fk
                AND delivery_price.vapeshop_fk = NEW.vapeshop_fk)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: there is price for this city';
    END IF;
END;;

CREATE TRIGGER delivery_price_validate_update
    BEFORE UPDATE ON delivery_price FOR EACH ROW
BEGIN
    IF 0 != (SELECT COUNT(*)
            FROM delivery_price
            WHERE NEW.id != delivery_price.id
                AND delivery_price.city_fk = NEW.city_fk
                AND delivery_price.vapeshop_fk = NEW.vapeshop_fk)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: there is price for this city';
    END IF;
END;;

CREATE TRIGGER price_validate_insert
    BEFORE INSERT ON price FOR EACH ROW
BEGIN
    IF 0 != (SELECT COUNT(*)
             FROM price
             WHERE NEW.id != price.id
               AND price.product_fk = NEW.product_fk
               AND price.vapeshop_fk = NEW.vapeshop_fk)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: there is price for this product';
    END IF;
END;;

CREATE TRIGGER price_validate_update
    BEFORE UPDATE ON price FOR EACH ROW
BEGIN
    IF 0 != (SELECT COUNT(*)
             FROM price
             WHERE NEW.id != price.id
               AND price.product_fk = NEW.product_fk
               AND price.vapeshop_fk = NEW.vapeshop_fk)
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: there is price for this product';
    END IF;
END;;

CREATE TRIGGER blend_ratio_validate_insert
    BEFORE INSERT ON blend_ratio FOR EACH ROW
BEGIN
    IF NEW.pg + NEW.vg != 100
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: sum of vg and pg is not 100';
    END IF;
END;;

CREATE TRIGGER blend_ratio_validate_update
    BEFORE UPDATE ON blend_ratio FOR EACH ROW
BEGIN
    IF NEW.pg + NEW.vg != 100
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: sum of vg and pg is not 100';
    END IF;
END;;

CREATE TRIGGER product_img_url_validate_insert
    BEFORE INSERT ON product_image FOR EACH ROW
BEGIN
    IF NEW.image REGEXP 'https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: only digits allows';
    END IF;
END;;

CREATE TRIGGER product_img_url_validate_update
    BEFORE UPDATE ON product_image FOR EACH ROW
BEGIN
    IF NEW.image REGEXP 'https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: only digits allows';
    END IF;
END;;