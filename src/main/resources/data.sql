INSERT INTO currency (id, name)
    VALUES (1, 'by'), (2, 'ru');;
INSERT INTO country (id, name, phone_prefix, currency_fk)
    VALUES (1 ,'Беларусь', '375', 1),(2 ,'Россия', '7', 2);;
INSERT INTO city (name, country_fk) VALUES ('Полоцк', 1), ('Москва', 2);;
INSERT INTO blend_ratio (id, vg, pg) VALUES (1, 50, 50), (2, 40, 60);;
INSERT INTO commercial_network (id, name) VALUES (2 ,'CommNetwork');;
INSERT INTO contact_link_type (id, name)
    VALUES (1, 'emale'), (2, 'instagram'), (3, 'vk');;
insert into image (id, url)
    values (1 , 'https://cdn.shopify.com/s/files/1/0662/4695/products/2019-04-23_900x.jpg?v=1556080202'),
    (2, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Halcyon_-_100_Apachi_FDA_Black_Cap_2000x.jpg?v=1552542838'),
    (3, 'https://cdn.shopify.com/s/files/1/0280/7756/products/Halcyon_-_100_Dragon_Chi_FDA_Black_Cap_800x.jpg?v=1552542840')
    ;;
INSERT INTO brand (id, name, image_fk, info)
    VALUES (1, 'HALCYON VAPORS', 1,
            'Halcyon Vapors ® was founded in 2012 and officially formed in 2013.  We are a robust creative team based out of California, USA. All of our manufacturing is done by our partner Molecule Labs Inc who is also based out of California, USA.');;

call add_eliquid('APACH\'I', 'Apach''i by Halcyon Vapors is a unique blend of apricot, peach, and signature Halcyon undertones. The third flavor in the masterful trilogy from Halcyon Vapors which continue to stand the test of time.',
    1, 1, 100, true, @id);;
INSERT INTO product_image (product_fk, image_fk)
    VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 2);;

call add_eliquid('DRAGON CH\'I', 'Dragon Ch''i by Halcyon Vapors is a dragon fruit and pomegranate flavor with unique lychee-like accents. For more than a half a decade, this truly unique flavor has yet to be matched.',
                 1, 1, 100, true, @id);;
INSERT INTO product_image (product_fk, image_fk)
VALUES ((SELECT p.id FROM product as p, e_liquid as e WHERE p.id = e.product_fk AND e.id = @id), 3);;