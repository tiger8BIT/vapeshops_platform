INSERT IGNORE INTO country (id, name, phone_prefix, currency) VALUES (1 ,'Беларусь', '375', 'by'),(2 ,'Россия', '7', 'ru');;
INSERT IGNORE INTO city (name, country_fk) VALUES ('Полоцк', 1), ('Москва', 2);;
INSERT IGNORE INTO blend_ratio (vg, pg) VALUES (50, 50), (40, 60);;
INSERT IGNORE INTO brand (name) VALUES ('Trix');;
INSERT IGNORE INTO commercial_network (id, name, logo) VALUES (2 ,'CommNetwork', 'logo-url');;
call add_vapeshop('д.7, кв.75', 1, 2, true, @a);;