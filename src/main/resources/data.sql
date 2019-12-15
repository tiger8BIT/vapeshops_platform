INSERT INTO currency (id, name)
    VALUES (1, 'by'), (2, 'ru');;
INSERT INTO country (id, name, phone_prefix, currency_fk)
    VALUES (1 ,'Беларусь', '375', 1),(2 ,'Россия', '7', 2);;
INSERT INTO city (name, country_fk) VALUES ('Полоцк', 1), ('Москва', 2);;
INSERT INTO blend_ratio (vg, pg) VALUES (50, 50), (40, 60);;
INSERT INTO brand (name) VALUES ('Trix');;
INSERT INTO commercial_network (id, name) VALUES (2 ,'CommNetwork');;
INSERT INTO contact_link_type (id, name)
    VALUES (1, 'emale'), (2, 'instagram'), (3, 'vk');;