INSERT IGNORE INTO country (id, name, phone_prefix, currency) VALUES (0 ,'Беларусь', '375', 'by'),(3 ,'Россия', '312', 'ru');;
INSERT IGNORE INTO city (id, name, country_fk) VALUES (1 ,'Полоцк', 0), (4 ,'Москва', 3);;
INSERT IGNORE INTO commercial_network (id, name, logo) VALUES (2 ,'CommNetwork', 'logo-url');;