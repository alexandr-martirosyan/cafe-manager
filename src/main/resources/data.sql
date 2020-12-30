-- User
INSERT INTO PUBLIC."user" ("id", "created", "deleted", "email", "first_name", "gender", "last_name", "password", "updated", "username") VALUES ('127ad388-e461-4fe1-bb97-fb664061f528', '2020-12-30 07:58:07.725768', null, 'manager1@gmail.com', 'Manager1', 'MALE', 'Manyan1', 'password1', '2020-12-30 07:58:07.725844', 'manager1');
INSERT INTO PUBLIC."user" ("id", "created", "deleted", "email", "first_name", "gender", "last_name", "password", "updated", "username") VALUES ('08080823-958c-41db-ada6-1afc1ed07da8', '2020-12-30 07:58:25.631915', null, 'manager2@gmail.com', 'Manager2', 'FEMALE', 'Manyan2', 'password2', '2020-12-30 07:58:25.631956', 'manager2');
INSERT INTO PUBLIC."user" ("id", "created", "deleted", "email", "first_name", "gender", "last_name", "password", "updated", "username") VALUES ('78214e27-da7d-4a99-a1d3-672f8e023fae', '2020-12-30 07:58:45.470585', null, 'manager3@gmail.com', 'Manager3', 'MALE', 'Manyan3', 'password3', '2020-12-30 07:58:45.470630', 'manager3');
INSERT INTO PUBLIC."user" ("id", "created", "deleted", "email", "first_name", "gender", "last_name", "password", "updated", "username") VALUES ('b39f2d62-ba89-44c1-baf8-55234239da44', '2020-12-30 07:59:13.622350', null, 'waiter1@gmail.com', 'Waiter1', 'FEMALE', 'Waiteryan1', 'password1', '2020-12-30 07:59:13.622392', 'waiter_1');
INSERT INTO PUBLIC."user" ("id", "created", "deleted", "email", "first_name", "gender", "last_name", "password", "updated", "username") VALUES ('1871a769-3e85-49c7-b56f-b91feff6bb63', '2020-12-30 07:59:33.931542', null, 'waiter2@gmail.com', 'Waiter2', 'MALE', 'Waiteryan2', 'password2', '2020-12-30 07:59:33.931587', 'waiter_2');
-- Manager
INSERT INTO PUBLIC."manager" ("id") VALUES ('08080823-958c-41db-ada6-1afc1ed07da8');
INSERT INTO PUBLIC."manager" ("id") VALUES ('127ad388-e461-4fe1-bb97-fb664061f528');
INSERT INTO PUBLIC."manager" ("id") VALUES ('78214e27-da7d-4a99-a1d3-672f8e023fae');
-- Waiter
INSERT INTO PUBLIC."waiter" ("id") VALUES ('b39f2d62-ba89-44c1-baf8-55234239da44');
INSERT INTO PUBLIC."waiter" ("id") VALUES ('1871a769-3e85-49c7-b56f-b91feff6bb63');
-- Role
INSERT INTO PUBLIC."role" ("role_name") VALUES ('MANAGER');
INSERT INTO PUBLIC."role" ("role_name") VALUES ('WAITER');
-- User_Role
INSERT INTO PUBLIC."user_role" ("user_id", "role_name") VALUES ('b39f2d62-ba89-44c1-baf8-55234239da44', 'WAITER');
INSERT INTO PUBLIC."user_role" ("user_id", "role_name") VALUES ('08080823-958c-41db-ada6-1afc1ed07da8', 'MANAGER');
INSERT INTO PUBLIC."user_role" ("user_id", "role_name") VALUES ('127ad388-e461-4fe1-bb97-fb664061f528', 'MANAGER');
INSERT INTO PUBLIC."user_role" ("user_id", "role_name") VALUES ('1871a769-3e85-49c7-b56f-b91feff6bb63', 'WAITER');
INSERT INTO PUBLIC."user_role" ("user_id", "role_name") VALUES ('78214e27-da7d-4a99-a1d3-672f8e023fae', 'MANAGER');
-- Table
INSERT INTO PUBLIC."table" ("id", "capacity", "created", "deleted", "updated", "waiter_id") VALUES ('f4d11d0f-307a-4a70-98b7-8a51a56e9621', 4, '2020-12-30 07:59:47.669336', null, '2020-12-30 07:59:47.669371', null);
INSERT INTO PUBLIC."table" ("id", "capacity", "created", "deleted", "updated", "waiter_id") VALUES ('fb998232-0895-42d6-abe5-54bd255178eb', 3, '2020-12-30 07:59:54.269099', null, '2020-12-30 07:59:54.269124', null);
-- Product
INSERT INTO PUBLIC."product" ("id", "cook_duration", "created", "deleted", "description", "name", "price", "updated", "weight") VALUES ('0e0df6ee-ab2d-463c-8821-576e435e7846', null, '2020-12-30 08:00:22.678589', null, 'Pork barbeque', 'barbeque', 10, '2020-12-30 08:00:22.678629', 400);
INSERT INTO PUBLIC."product" ("id", "cook_duration", "created", "deleted", "description", "name", "price", "updated", "weight") VALUES ('e8e82ed7-ec60-43a6-8b9d-bd6a3ba92f0d', null, '2020-12-30 08:01:07.770378', null, 'best cheesburger in city', 'cheesburger', 7, '2020-12-30 08:01:07.770415', 250);
-- Order
INSERT INTO PUBLIC."order" ("id", "created", "deleted", "status", "updated", "table_id") VALUES ('1fb53167-b659-4cc6-8d0d-6001c5de0dc3', '2020-12-30 08:03:51.777229', null, 'OPEN', '2020-12-30 08:03:51.777284', 'f4d11d0f-307a-4a70-98b7-8a51a56e9621');
INSERT INTO PUBLIC."order" ("id", "created", "deleted", "status", "updated", "table_id") VALUES ('d522b020-4641-4b0c-8f81-21b22a1c3d89', '2020-12-30 08:04:01.154169', null, 'OPEN', '2020-12-30 08:04:01.154207', 'fb998232-0895-42d6-abe5-54bd255178eb');
-- Product in Order
INSERT INTO PUBLIC."product_in_order" ("amount", "created", "deleted", "status", "updated", "order_id", "product_id") VALUES (3, '2020-12-30 08:04:28.992707', null, 'ACTIVE', '2020-12-30 08:04:28.992757', '1fb53167-b659-4cc6-8d0d-6001c5de0dc3', '0e0df6ee-ab2d-463c-8821-576e435e7846');
INSERT INTO PUBLIC."product_in_order" ("amount", "created", "deleted", "status", "updated", "order_id", "product_id") VALUES (3, '2020-12-30 08:04:53.123107', null, 'ACTIVE', '2020-12-30 08:04:53.123140', 'd522b020-4641-4b0c-8f81-21b22a1c3d89', 'e8e82ed7-ec60-43a6-8b9d-bd6a3ba92f0d');
