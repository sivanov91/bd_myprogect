
------------ ROLE ------------
INSERT INTO role(
            role_id, role_name)
    VALUES (1, 'ROLE_NAME_1');

INSERT INTO role(
            role_id, role_name)
    VALUES (2, 'ROLE_NAME_2');

INSERT INTO role(
            role_id, role_name)
    VALUES (3, 'ROLE_NAME_3');

INSERT INTO role(
            role_id, role_name)
    VALUES (4, 'ROLE_NAME_4');

INSERT INTO role(
            role_id, role_name)
    VALUES (5, 'ROLE_NAME_5');

INSERT INTO role(
            role_id, role_name)
    VALUES (6, 'ROLE_NAME_6');

INSERT INTO role(
            role_id, role_name)
    VALUES (7, 'ROLE_NAME_7');

INSERT INTO role(
            role_id, role_name)
    VALUES (8, 'ROLE_NAME_8');

INSERT INTO role(
            role_id, role_name)
    VALUES (9, 'ROLE_NAME_9');

INSERT INTO role(
            role_id, role_name)
    VALUES (10, 'ROLE_NAME_10');


------------ USERS ------------
INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (1, 'USER_NAME_1', 'EMAIL', 'pass', 'phone', 'NIKNAME_1', 'second_name_1', 'patronymic_1', 1);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (2, 'USER_NAME_2', 'EMAIL', 'pass', 'phone', 'NIKNAME_2', 'second_name_2', 'patronymic_2', 2);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (3, 'USER_NAME_3', 'EMAIL', 'pass', 'phone', 'NIKNAME_3', 'second_name_3', 'patronymic_3', 3);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (4, 'USER_NAME_4', 'EMAIL', 'pass', 'phone', 'NIKNAME_4', 'second_name_4', 'patronymic_4', 4);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (5, 'USER_NAME_5', 'EMAIL', 'pass', 'phone', 'NIKNAME_5', 'second_name_5', 'patronymic_5', 5);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (6, 'USER_NAME_6', 'EMAIL', 'pass', 'phone', 'NIKNAME_6', 'second_name_6', 'patronymic_6', 6);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (7, 'USER_NAME_7', 'EMAIL', 'pass', 'phone', 'NIKNAME_7', 'second_name_7', 'patronymic_7', 7);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (8, 'USER_NAME_8', 'EMAIL', 'pass', 'phone', 'NIKNAME_8', 'second_name_8', 'patronymic_8', 8);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (9, 'USER_NAME_9', 'EMAIL', 'pass', 'phone', 'NIKNAME_9', 'second_name_9', 'patronymic_9', 9);

INSERT INTO users(
            user_id, name, email, password_hash, phone, nikname, second_name, 
            patronymic, role_id)
    VALUES (10, 'USER_NAME_10', 'EMAIL', 'pass', 'phone', 'NIKNAME_10', 'second_name_10', 'patronymic_10', 10);


------------ payment_type ------------
INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (1, 'payment_type_1');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (2, 'payment_type_2');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (3, 'payment_type_3');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (4, 'payment_type_4');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (5, 'payment_type_5');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (6, 'payment_type_6');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (7, 'payment_type_7');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (8, 'payment_type_8');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (9, 'payment_type_9');

INSERT INTO payment_type(
            payment_type_id, name)
    VALUES (10, 'payment_type_10');


------------ payment ------------
INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (1, 1, 1, 1111, 1111);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (2, 2, 2, 2222, 2222);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (3, 3, 3, 3333, 3333);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (4, 4, 4, 4444, 4444);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (5, 5, 5, 5555, 5555);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (6, 6, 6, 6666, 6666);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (7, 7, 7, 7777, 7777);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (8, 8, 8, 8888, 8888);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (9, 9, 9, 9999, 9999);

INSERT INTO payment(
            payment_id, user_id, payment_type_id, card_number, card_security_code)
    VALUES (10, 10, 10, 10101010, 10101010);


------------ product ------------
INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (1, 'PRODUCT_1', 111, 'description_1', 11);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (2, 'PRODUCT_2', 222, 'description_2', 22);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (3, 'PRODUCT_3', 333, 'description_3', 33);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (4, 'PRODUCT_4', 444, 'description_4', 44);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (5, 'PRODUCT_5', 555, 'description_5', 55);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (6, 'PRODUCT_6', 666, 'description_6', 66);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (7, 'PRODUCT_7', 777, 'description_7', 77);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (8, 'PRODUCT_8', 888, 'description_8', 88);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (9, 'PRODUCT_9', 999, 'description_9', 99);

INSERT INTO product(
            product_id, product_name, price, description, quantity)
    VALUES (10, 'PRODUCT_10', 101010, 'description_10', 1010);


------------ deliver_type ------------
INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (1, 'deliver_type_1', 'description_1');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (2, 'deliver_type_2', 'description_2');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (3, 'deliver_type_3', 'description_3');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (4, 'deliver_type_4', 'description_4');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (5, 'deliver_type_5', 'description_5');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (6, 'deliver_type_6', 'description_6');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (7, 'deliver_type_7', 'description_7');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (8, 'deliver_type_8', 'description_8');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (9, 'deliver_type_9', 'description_9');

INSERT INTO deliver_type(
            dekivery_type_id, name, description)
    VALUES (10, 'deliver_type_10', 'description_10');


------------ deliver ------------
INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (1, 'deliver_name_1', 'addres_1', 'phone_1', 11, 1);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (2, 'deliver_name_2', 'addres_2', 'phone_2', 22, 2);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (3, 'deliver_name_3', 'addres_3', 'phone_3', 33, 3);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (4, 'deliver_name_4', 'addres_4', 'phone_4', 44, 4);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (5, 'deliver_name_5', 'addres_5', 'phone_5', 55, 5);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (6, 'deliver_name_6', 'addres_6', 'phone_6', 66, 6);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (7, 'deliver_name_7', 'addres_7', 'phone_7', 77, 7);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (8, 'deliver_name_8', 'addres_8', 'phone_8', 88, 8);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (9, 'deliver_name_9', 'addres_9', 'phone_9', 99, 9);

INSERT INTO deliver(
            deliver_id, name, addres, phone, price, dekivery_type_id)
    VALUES (10, 'deliver_name_10', 'addres_10', 'phone_10', 1010, 10);


------------ basket ------------
INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (1, 1, 1);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (2, 2, 2);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (3, 3, 3);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (4, 4, 4);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (5, 5, 5);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (6, 6, 6);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (7, 7, 7);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (8, 8, 8);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (9, 9, 9);

INSERT INTO basket(
            basket_id, session_id, user_id)
    VALUES (10, 10, 10);


------------ basket_ithem ------------
INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (1, 1, 1);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (2, 2, 2);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (3, 3, 3);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (4, 4, 4);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (5, 5, 5);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (6, 6, 6);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (7, 7, 7);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (8, 8, 8);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (9, 9, 9);

INSERT INTO basket_ithem(
            quantity, basket_id, product_id)
    VALUES (10, 10, 10);


------------ queue ------------
INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (1, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 1, 1, 1);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (2, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 2, 2, 2);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (3, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 3, 3, 3);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (4, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 4, 4, 4);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (5, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 5, 5, 5);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (6, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 6, 6, 6);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (7, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 7, 7, 7);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (8, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 8, 8, 8);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (9, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 9, 9, 9);

INSERT INTO queue(
            queue_id, order_date, confirmation_data, soled_data, delivery_data, 
            payment_id, deliver_id, basket_id)
    VALUES (10, 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', 10, 10, 10);

