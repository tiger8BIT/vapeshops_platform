CREATE TABLE `product` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) UNIQUE NOT NULL,
    `info` mediumtext,
    `brand_fk` int NOT NULL
);;

CREATE TABLE `product_image` (
    `product_fk` int NOT NULL,
    `image_fk` int NOT NULL UNIQUE,
    PRIMARY KEY (`product_fk`, `image_fk`)
);;

CREATE TABLE `vapeshop_image` (
    `vapeshop_fk` int NOT NULL,
    `image_fk` int NOT NULL UNIQUE,
    PRIMARY KEY (`vapeshop_fk`, `image_fk`)
);;

CREATE TABLE `order` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `delivery_fk` int DEFAULT NULL,
    `datetime` datetime DEFAULT CURRENT_TIMESTAMP
);;

CREATE TABLE `order_price` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `amount` int CHECK(`amount` > 1),
    `price_fk` int NOT NULL,
    `order_fk` int NOT NULL
);;

CREATE TABLE `delivery` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `datetime` datetime NOT NULL,
    `price_fk` int NOT NULL,
    `address_fk` int NOT NULL
);;

CREATE TABLE `delivery_price` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `price` float NOT NULL CHECK(`price` > 0),
    `city_fk` int NOT NULL,
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `commercial_network` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) UNIQUE NOT NULL,
    `info` mediumtext,
    `image_fk` int UNIQUE
);;

CREATE TABLE `vapeshop` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `address_fk` int NOT NULL,
    `commercial_network_fk` int,
    `pickup` boolean
);;

CREATE TABLE `address` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `address` varchar(30),
    `city_fk` int NOT NULL
);;

CREATE TABLE `country` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) UNIQUE NOT NULL,
    `phone_prefix` varchar(5) UNIQUE NOT NULL,
    `currency_fk` int NOT NULL
);;

CREATE TABLE `city` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255) UNIQUE NOT NULL,
    `country_fk` int NOT NULL
);;

CREATE TABLE `phone_number` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `number` varchar(15) NOT NULL,
    `country_fk` int NOT NULL,
    `description` mediumtext,
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `contact_link` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `link` varchar(100),
    `type_fk` int,
    `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `contact_link_type` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(54) NOT NULL UNIQUE
);;

CREATE TABLE `price` (
     `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
     `product_fk` int NOT NULL,
     `value` float CHECK(`value` > 0),
     `vapeshop_fk` int NOT NULL
);;

CREATE TABLE `e_liquid` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `product_fk` int NOT NULL UNIQUE,
    `blend_ratio_fk` int NOT NULL,
    `volume` int  CHECK(`volume` > 0),
    `mint_menthol` boolean
);;

CREATE TABLE `nicotine` (
     `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
     `value` int NOT NULL CHECK(`value` >= 0),
     `nicotine_type` varchar(10) NOT NULL CHECK (`nicotine_type` in ('SALT', 'DEFAULT', 'GIBRID')) ,
     `eliquid_fk` int NOT NULL
);;

CREATE TABLE `e_liquid_flavor_profile` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `flavor_profile_fk` int NOT NULL,
    `e_liquid_fk` int NOT NULL
);;

CREATE TABLE `flavor_profile` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` varchar(255)
);;

CREATE TABLE `blend_ratio` (
    `id` int UNIQUE PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `vg` int CHECK(`vg` > 0),
    `pg` int CHECK(`pg` > 0)
);;

CREATE TABLE `brand` (
     `id` int UNIQUE PRIMARY KEY AUTO_INCREMENT,
     `name` varchar(255) UNIQUE NOT NULL,
     `image_fk` int UNIQUE,
     `info` mediumtext
);;

CREATE TABLE `sale` (
    `id` int UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `percent` int NOT NULL CHECK('percent' > 0 and 'percent' < 100),
    `vapeshop_fk` int NOT NULL,
    `info` mediumtext
);;

CREATE TABLE `price_sale` (
      `price_fk` int NOT NULL,
      `sale_fk` int NOT NULL UNIQUE,
      PRIMARY KEY (`price_fk`, `sale_fk`)
);;

CREATE TABLE `currency` (
    `id` int UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(5) UNIQUE NOT NULL
);;

CREATE TABLE `vapeshop_currency` (
    `vapeshop_fk` int NOT NULL,
    `currency_fk` int NOT NULL,
    PRIMARY KEY (`vapeshop_fk`, `currency_fk`)
);;

CREATE TABLE `image`
(
    `id`  int UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `url` varchar(512) UNIQUE NOT NULL
);;

ALTER TABLE `nicotine` ADD FOREIGN KEY (`eliquid_fk`) REFERENCES `e_liquid` (`id`);;

ALTER TABLE `price_sale` ADD FOREIGN KEY (`price_fk`) REFERENCES `price` (`id`);;

ALTER TABLE `price_sale` ADD FOREIGN KEY (`sale_fk`) REFERENCES `sale` (`id`);;

ALTER TABLE `sale` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`);;

ALTER TABLE `commercial_network` ADD FOREIGN KEY (`image_fk`) REFERENCES `image` (`id`);;

ALTER TABLE `brand` ADD FOREIGN KEY (`image_fk`) REFERENCES `image` (`id`);;

ALTER TABLE `country` ADD FOREIGN KEY (`currency_fk`) REFERENCES `currency` (`id`);;

ALTER TABLE `vapeshop_currency` ADD FOREIGN KEY (`currency_fk`) REFERENCES `currency` (`id`);;

ALTER TABLE `vapeshop_currency` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`);;

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

ALTER TABLE `product_image` ADD FOREIGN KEY (`product_fk`) REFERENCES `product` (`id`) ON DELETE CASCADE;;

ALTER TABLE `product_image` ADD FOREIGN KEY (`image_fk`) REFERENCES `image` (`id`) ON DELETE CASCADE;;

ALTER TABLE `vapeshop_image` ADD FOREIGN KEY (`vapeshop_fk`) REFERENCES `vapeshop` (`id`) ON DELETE CASCADE;;

ALTER TABLE `vapeshop_image` ADD FOREIGN KEY (`image_fk`) REFERENCES `image` (`id`) ON DELETE CASCADE;;

ALTER TABLE `e_liquid_flavor_profile` ADD FOREIGN KEY (`e_liquid_fk`) REFERENCES `e_liquid` (`id`);;

ALTER TABLE `e_liquid_flavor_profile` ADD FOREIGN KEY (`flavor_profile_fk`) REFERENCES `flavor_profile` (`id`);;

ALTER TABLE `contact_link` ADD FOREIGN KEY (`type_fk`) REFERENCES `contact_link_type` (`id`);;

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

CREATE TRIGGER img_url_validate_insert
    BEFORE INSERT ON image FOR EACH ROW
BEGIN
    IF NEW.url NOT REGEXP '(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: bad link';
    END IF;
END;;

CREATE TRIGGER img_url_validate_update
    BEFORE UPDATE ON image FOR EACH ROW
BEGIN
    IF NEW.url NOT REGEXP '(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})'
    THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot add or update row: bad link';
    END IF;
END;;

CREATE PROCEDURE add_vapeshop(IN p_address varchar(30),
                              IN p_city_fk int, IN p_commercial_network_fk int,
                              IN p_pickup boolean, OUT p_vapeshop_id int)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
            SELECT @p1 as RETURNED_SQLSTATE  , @p2 as MESSAGE_TEXT;
            ROLLBACK;
        END;
    START TRANSACTION;
        INSERT INTO address (address, city_fk) VALUES (p_address, p_city_fk);
        INSERT INTO vapeshop (address_fk, commercial_network_fk, pickup)
            VALUES ((SELECT LAST_INSERT_ID()), p_commercial_network_fk, p_pickup);
        SELECT LAST_INSERT_ID() INTO p_vapeshop_id;
    COMMIT;
END;;

CREATE PROCEDURE update_vapeshop(pvapeshop_id int, IN paddress varchar(30),
                              IN pcity_fk int, IN pcommercial_network_fk int,
                              IN ppickup boolean)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
            SELECT @p1 as RETURNED_SQLSTATE  , @p2 as MESSAGE_TEXT;
            ROLLBACK;
        END;
    UPDATE address SET address = paddress, city_fk = pcity_fk
        WHERE id = (SELECT address_fk FROM vapeshop WHERE id = pvapeshop_id);
    UPDATE vapeshop SET commercial_network_fk = pcommercial_network_fk, pickup = ppickup
        WHERE id = pvapeshop_id;
    COMMIT;
END;;

CREATE PROCEDURE add_eliquid(IN p_name varchar(255), IN p_info mediumtext, IN p_brand_fk int,
                             IN p_blend_ratio_fk int, IN p_volume int,
                             IN p_mint_menthol boolean, OUT p_eliquid_id int)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
            SELECT @p1 as RETURNED_SQLSTATE  , @p2 as MESSAGE_TEXT;
            ROLLBACK;
        END;
    START TRANSACTION;
    INSERT INTO product (name, info, brand_fk) VALUES (p_name, p_info, p_brand_fk);
    INSERT INTO e_liquid (product_fk, blend_ratio_fk, volume, mint_menthol)
        VALUES ((SELECT LAST_INSERT_ID()), p_blend_ratio_fk, p_volume,
                p_mint_menthol);
        SELECT LAST_INSERT_ID() INTO p_eliquid_id;
    COMMIT;
END;;

CREATE PROCEDURE update_eliquid(IN p_eliquid_id int, IN p_name varchar(255), IN p_info mediumtext,
                                IN p_brand_fk int, IN p_blend_ratio_fk int, IN p_volume int,
                                 IN p_mint_menthol boolean)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
            SELECT @p1 as RETURNED_SQLSTATE  , @p2 as MESSAGE_TEXT;
            ROLLBACK;
        END;
    START TRANSACTION;
    UPDATE product SET name = p_name, info = p_info, brand_fk = p_brand_fk
        WHERE id = (SELECT product_fk FROM e_liquid WHERE id = p_eliquid_id);
    UPDATE e_liquid SET blend_ratio_fk = p_blend_ratio_fk, volume = p_volume,
                        mint_menthol = p_mint_menthol
        WHERE  id = p_eliquid_id;
    COMMIT;
END;;

CREATE PROCEDURE add_image(IN p_url varchar(512))
BEGIN
    DECLARE l_image_id int;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
            SELECT @p1 as RETURNED_SQLSTATE  , @p2 as MESSAGE_TEXT;
            ROLLBACK;
        END;
    SET l_image_id = (SELECT id FROM image WHERE url like p_url);
    IF l_image_id IS NOT NULL
    THEN
        SELECT * FROM image WHERE id = l_image_id;
    ELSE
        INSERT INTO image (url) VALUE (p_url);
        SELECT * FROM image WHERE id = (SELECT LAST_INSERT_ID());
    end if;
    COMMIT;
END;;