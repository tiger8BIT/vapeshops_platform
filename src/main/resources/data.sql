INSERT INTO currency (id, name)
    VALUES (1, 'by'), (2, 'ru');;
INSERT INTO country (id, name, phone_prefix, currency_fk)
    VALUES (1 ,'Беларусь', '375', 1),(2 ,'Россия', '7', 2);;
INSERT INTO city (name, country_fk) VALUES ('Полоцк', 1), ('Москва', 2);;
INSERT INTO blend_ratio (id, vg, pg) VALUES (1, 50, 50), (2, 40, 60);;
INSERT INTO contact_link_type (id, name)
    VALUES (1, 'emale'), (2, 'instagram'), (3, 'vk');;
insert into image (id, url)
    values (1 , 'https://cdn.shopify.com/s/files/1/0662/4695/products/2019-04-23_900x.jpg?v=1556080202'),
    (2, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Halcyon_-_100_Apachi_FDA_Black_Cap_2000x.jpg?v=1552542838'),
    (3, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Halcyon_-_100_Dragon_Chi_FDA_Black_Cap_800x.jpg?v=1552542840'),
    (4, 'https://cdn10.bigcommerce.com/s-paatz/products/2842/images/5386/SN7MXNL__88973.1553209749.1280.1280.png?c=2'),
    (9, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Fruit_Pops_Salt_-_30_Blizzard_Tail_2000x.jpg?v=1520334880'),
    (8, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Fruit_Pops_-_100_Tropical_Winter_2000x.jpg?v=1557856360'),
    (7, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Fruit_Pops_-_100_Polar_Peach_2000x.jpg?v=1557856356'),
    (6, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Fruit_Pops_Salt_-_30_Polar_Peach_2000x.jpg?v=1520342313'),
    (5, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Fruit_Pops_Salt_-_30_Frozen_Passion_2000x.jpg?v=1520342835'),
    (10, 'https://image.shutterstock.com/image-vector/vape-shop-logo-hot-girl-260nw-539667337.jpg')
    ;;
INSERT INTO brand (id, name, image_fk, info)
    VALUES (1, 'HALCYON VAPORS', 1,
            'Halcyon Vapors ® was founded in 2012 and officially formed in 2013.  We are a robust creative team based out of California, USA. All of our manufacturing is done by our partner Molecule Labs Inc who is also based out of California, USA.'),
            (2, 'FRUIT POP', 4, 'USA lab');;

call add_eliquid('APACH\'I', 'Apach''i by Halcyon Vapors is a unique blend of apricot, peach, and signature Halcyon undertones. The third flavor in the masterful trilogy from Halcyon Vapors which continue to stand the test of time.',
    1, 1, 100, false, @id);;
INSERT INTO product_image (product_fk, image_fk)
    VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 2);;

call add_eliquid('DRAGON CH\'I', 'Dragon Ch''i by Halcyon Vapors is a dragon fruit and pomegranate flavor with unique lychee-like accents. For more than a half a decade, this truly unique flavor has yet to be matched.',
                 1, 1, 100, false, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 3);;

call add_eliquid('FROZEN PASSION SALT', '',
                 2, 1, 100, true, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 5);;

call add_eliquid('POLAR PEACH SALT', '',
                 2, 1, 100, false, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 6);;

call add_eliquid('POLAR PEACH', '',
                 2, 1, 100, false, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 7);;

call add_eliquid('TROPIC WINTER', '',
                 2, 1, 100, true, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 8);;

call add_eliquid('BLIZZARD TAIL SALT', '',
                 2, 1, 100, true, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 9);;

INSERT INTO commercial_network (id, name, info, image_fk, username, password)
VALUES (1, 'Smoke and Steam', 'Торговая сеть',	10,	'comnet',
        '$2a$10$hjBXxwD4WDi//Q/K8S3BQuZ0QDJqSPNc2z1BYq/8o0GV1tgVhb9x2');;