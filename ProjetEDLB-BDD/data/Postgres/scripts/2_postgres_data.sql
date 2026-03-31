-- Insérer des données dans la table `category`
INSERT INTO category (name, description) 
VALUES 
  ('Toys', 'Various dog toys'),
  ('Food', 'Dog food products'),
  ('Grooming', 'Dog grooming accessories'),
  ('Training', 'Training materials for dogs'),
  ('Health', 'Dog health and wellness products');

-- Insérer des données dans la table `deliveryMode`
INSERT INTO deliveryMode (name, description, price)  
VALUES  
('STANDARD', 'Standard delivery in 3 to 5 days', 4.99),  
('EXPRESS', 'Fast delivery within 24h', 9.99),  
('CLICK_AND_COLLECT', 'In-store pickup', 0.00),  
('PICKUP_POINT', 'Delivery to a partner pickup point', 3.50),  
('HOME_DELIVERY', 'Direct home delivery', 6.99),  
('INTERNATIONAL', 'Delivery to other countries', 14.99),  
('COURIER', 'Ultra-fast delivery by local courier', 19.99);  


-- Insérer des données dans la table `role`
INSERT INTO role (roleName, description)
VALUES 
  ('Admin', 'Site Administrator'),  
  ('User', 'Regular user with limited access'),  
  ('Merch Manager', 'Manages the shop’s products'),  
  ('Document Manager', 'Handles document generation management'),  
  ('Moderator', 'Moderates posts and comments'),  
  ('Developer', 'Ultimate Access Developer (UAD)'),  
  ('Dog Owner', 'Owner of a dog from the breeding kennel'),  
  ('New Register', 'New registered user, we do validate is mail'),  
  ('Customer', 'User who buys from the shop');

-- Insérer des données dans la table `relation_type`
INSERT INTO relation_type (relationName, description)
VALUES
  ('Friend', 'A mutual friend relationship'),
  ('Family', 'Family relationship between users'),
  ('Business', 'Business relation'),
  ('Colleague', 'Professional relation'),
  ('Acquaintance', 'Casual acquaintance');

-- Insérer des données dans la table `product`
INSERT INTO product (name, price, stock, creationDate, display, productDescription)
VALUES 
  ('Ball Toy', 10.99, 100, CURRENT_DATE, TRUE, 'A durable ball toy for dogs'),
  ('Premium Dog Food', 29.99, 50, CURRENT_DATE, TRUE, 'High-quality food for dogs'),
  ('Shampoo', 12.49, 30, CURRENT_DATE, TRUE, 'Gentle shampoo for dogs'),
  ('Training Collar', 25.99, 75, CURRENT_DATE, TRUE, 'Effective training collar for dogs'),
  ('Vet Supplies', 15.49, 60, CURRENT_DATE, TRUE, 'Essential veterinary supplies for dogs');

-- Insérer des données dans la table `address`
INSERT INTO address (name, company, streetNumber, streetName, postalcode, city, region, country, createdAt, updatedAt, idUser)
VALUES
  ('Ma petite maison', NULL, '12', 'Main Street', '1000', 'Bruxelles', 'Bruxelles', 'BE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1)),
  ('Chez mon amant', NULL, '34', 'Elm Road', '75001', 'Paris', 'Île-de-France', 'FR', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, (SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1)),
  ('Chez woam', NULL, '56', 'Pine Street', '69001', 'Lyon', 'Auvergne-Rhône-Alpes', 'FR', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, (SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1)),
  ('Résidence principale', NULL, '78', 'Highway Street', '90001', 'Los Angeles', 'California', 'US', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, (SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1)),
  ('Maison de vacances', 'Test enterprise', '90', 'Green Lane', 'M2 6DD', 'Manchester', 'Lancashire', 'GB', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, (SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1));


-- Insérer des données dans la table `user`
INSERT INTO "user" (name, firstname, nickname, email, password, sex, birthdate, phoneNumber, preference_user)
VALUES
  ('John', 'Doe', 'john.doe@example.com', 'alwaysHere', 'password123', 'male', '1985-06-15', '0123456789', '{"notificationFollow": true, "notificationMessage": true, "darkTheme": false, "notificationPublicity": true, "notificationPublication": false, "notificationFriend": true}'),
  ('Jane', 'Smith', 'jane.smith@example.com', '007Like', 'password123', 'female', '1990-09-25', '0123456780', '{"notificationFollow": false, "notificationMessage": true, "darkTheme": true, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": false}'),
  ('Alice', 'Johnson', 'alice.johnson@example.com', 'Wanderland', 'password123', 'female', '1992-03-12', '0123456781', '{"notificationFollow": true, "notificationMessage": false, "darkTheme": true, "notificationPublicity": true, "notificationPublication": true, "notificationFriend": true}'),
  ('Bob', 'Brown', 'bob.brown@example.com', 'shitsAppened', 'password123', 'male', '1987-11-30', '0123456782', '{"notificationFollow": false, "notificationMessage": false, "darkTheme": false, "notificationPublicity": true, "notificationPublication": false, "notificationFriend": false}'),
  ('Charlie', 'Davis', 'charlie.davis@example.com', 'Dark_Kevin_du_93_naruto_SSJ5', 'password123', 'male', '1995-02-22', '0123456783', '{"notificationFollow": true, "notificationMessage": true, "darkTheme": true, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": false}');

-- Insérer des données dans la table `litter`
INSERT INTO litter (numberLOF, numberLitter, matingDate, birthdate)
VALUES
  ('LOF123', 'Litter001', '2024-01-01', '2024-03-15'),
  ('LOF124', 'Litter002', '2024-02-05', '2024-04-10'),
  ('LOF125', 'Litter003', '2024-03-01', '2024-05-12'),
  ('LOF126', 'Litter004', '2024-04-10', '2024-06-20'),
  ('LOF127', 'Litter005', '2024-05-15', '2024-07-22');

-- Insérer des données dans la table `dog`
INSERT INTO dog (name, sex, birthdate, idLitter, idUser)
VALUES
  ('Max', 'male', '2024-03-16', (SELECT idLitter FROM litter WHERE numberLitter = 'Litter001' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1)),
  ('Bella', 'female', '2024-04-11', (SELECT idLitter FROM litter WHERE numberLitter = 'Litter002' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1)),
  ('Luna', 'female', '2024-05-13', (SELECT idLitter FROM litter WHERE numberLitter = 'Litter003' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1)),
  ('Rocky', 'male', '2024-06-21', (SELECT idLitter FROM litter WHERE numberLitter = 'Litter004' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1)),
  ('Rex', 'male', '2024-07-23', (SELECT idLitter FROM litter WHERE numberLitter = 'Litter005' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1));

-- Insérer des données dans la table `dog_media`
INSERT INTO dog_media (idDog, idMedia)
VALUES
  ((SELECT idDog FROM dog WHERE name = 'Max' LIMIT 1), 'media1'),
  ((SELECT idDog FROM dog WHERE name = 'Bella' LIMIT 1), 'media2'),
  ((SELECT idDog FROM dog WHERE name = 'Luna' LIMIT 1), 'media3'),
  ((SELECT idDog FROM dog WHERE name = 'Rocky' LIMIT 1), 'media4'),
  ((SELECT idDog FROM dog WHERE name = 'Rex' LIMIT 1), 'media5');

-- Insérer des données dans la table `product_category`
INSERT INTO product_category (idCategory, idProduct)
VALUES
  ((SELECT idCategory FROM category WHERE name = 'Toys' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Ball Toy' LIMIT 1)),
  ((SELECT idCategory FROM category WHERE name = 'Food' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Premium Dog Food' LIMIT 1)),
  ((SELECT idCategory FROM category WHERE name = 'Grooming' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Shampoo' LIMIT 1)),
  ((SELECT idCategory FROM category WHERE name = 'Training' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Training Collar' LIMIT 1)),
  ((SELECT idCategory FROM category WHERE name = 'Health' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Vet Supplies' LIMIT 1));

-- Insérer des données dans la table `product_media`
INSERT INTO product_media (idProduct, idMedia)
VALUES
  ((SELECT idProduct FROM product WHERE name = 'Ball Toy' LIMIT 1), 'media1'),
  ((SELECT idProduct FROM product WHERE name = 'Premium Dog Food' LIMIT 1), 'media2'),
  ((SELECT idProduct FROM product WHERE name = 'Shampoo' LIMIT 1), 'media3'),
  ((SELECT idProduct FROM product WHERE name = 'Training Collar' LIMIT 1), 'media4'),
  ((SELECT idProduct FROM product WHERE name = 'Vet Supplies' LIMIT 1), 'media5');

-- Insérer des données dans la table `order`
INSERT INTO "order" (status, tracking, orderNumber, dateorder, idDeliveryMode, idUser, idAddress)
VALUES
  ('PENDING', 'TRACK123', 'ORD123', CURRENT_DATE, (SELECT idDeliveryMode FROM "deliverymode" WHERE name = 'CLICK_AND_COLLECT' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idAddress FROM address WHERE idUser = (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1) LIMIT 1)),
  ('PREPARATION', 'TRACK124', 'ORD124', CURRENT_DATE, (SELECT idDeliveryMode FROM "deliverymode" WHERE name = 'HOME_DELIVERY' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1), (SELECT idAddress FROM address WHERE idUser = (SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1) LIMIT 1)),
  ('SHIPPED', 'TRACK125', 'ORD125', CURRENT_DATE, (SELECT idDeliveryMode FROM "deliverymode" WHERE name = 'STANDARD' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1), (SELECT idAddress FROM address WHERE idUser = (SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1) LIMIT 1)),
  ('CANCELLED', 'TRACK126', 'ORD126', CURRENT_DATE, (SELECT idDeliveryMode FROM "deliverymode" WHERE name = 'COURIER' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1), (SELECT idAddress FROM address WHERE idUser = (SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1) LIMIT 1)),
  ('SHIPPED', 'TRACK127', 'ORD127', CURRENT_DATE, (SELECT idDeliveryMode FROM "deliverymode" WHERE name = 'HOME_DELIVERY' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1), (SELECT idAddress FROM address WHERE idUser = (SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1) LIMIT 1));

-- Insérer des données dans la table `order_product`
INSERT INTO order_product (idorder, idProduct)
VALUES
  ((SELECT idorder FROM "order" WHERE orderNumber = 'ORD123' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Ball Toy' LIMIT 1)),
  ((SELECT idorder FROM "order" WHERE orderNumber = 'ORD124' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Premium Dog Food' LIMIT 1)),
  ((SELECT idorder FROM "order" WHERE orderNumber = 'ORD125' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Shampoo' LIMIT 1)),
  ((SELECT idorder FROM "order" WHERE orderNumber = 'ORD126' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Training Collar' LIMIT 1)),
  ((SELECT idorder FROM "order" WHERE orderNumber = 'ORD127' LIMIT 1), (SELECT idProduct FROM product WHERE name = 'Vet Supplies' LIMIT 1));

-- Insérer des données dans la table `payment`
INSERT INTO payment (type, paymentDate, idorder)
VALUES
  ('Credit Card', CURRENT_DATE, (SELECT idorder FROM "order" WHERE orderNumber = 'ORD123' LIMIT 1)),
  ('PayPal', CURRENT_DATE, (SELECT idorder FROM "order" WHERE orderNumber = 'ORD124' LIMIT 1)),
  ('Bank Transfer', CURRENT_DATE, (SELECT idorder FROM "order" WHERE orderNumber = 'ORD125' LIMIT 1)),
  ('Credit Card', CURRENT_DATE, (SELECT idorder FROM "order" WHERE orderNumber = 'ORD126' LIMIT 1)),
  ('PayPal', CURRENT_DATE, (SELECT idorder FROM "order" WHERE orderNumber = 'ORD127' LIMIT 1));


-- Insérer des données dans la table `user_relation`
INSERT INTO user_relation (idUserReceiver, idSourceUser, idRelationType)
VALUES
  ((SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idRelationType FROM relation_type WHERE relationName = 'Friend' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idRelationType FROM relation_type WHERE relationName = 'Family' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1), (SELECT idRelationType FROM relation_type WHERE relationName = 'Business' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idRelationType FROM relation_type WHERE relationName = 'Colleague' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1), (SELECT idRelationType FROM relation_type WHERE relationName = 'Acquaintance' LIMIT 1));

-- Insérer des données dans la table `litter_media`
INSERT INTO litter_media (idLitter, idMedia)
VALUES
  ((SELECT idLitter FROM litter WHERE numberLitter = 'Litter001' LIMIT 1), 'media1'),
  ((SELECT idLitter FROM litter WHERE numberLitter = 'Litter002' LIMIT 1), 'media2'),
  ((SELECT idLitter FROM litter WHERE numberLitter = 'Litter003' LIMIT 1), 'media3'),
  ((SELECT idLitter FROM litter WHERE numberLitter = 'Litter004' LIMIT 1), 'media4'),
  ((SELECT idLitter FROM litter WHERE numberLitter = 'Litter005' LIMIT 1), 'media5');

-- Insérer des données dans la table `link`
INSERT INTO user_media (idUser, idMedia)
VALUES
  ((SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), 'media1'),
  ((SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1), 'media2'),
  ((SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1), 'media3'),
  ((SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1), 'media4'),
  ((SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1), 'media5');

-- Insérer des données dans la table user, qui correspond au UUI dans la mongoDB
INSERT INTO "user" (
    idUser, 
    birthdate, 
    sex, 
    name, 
    firstname, 
    nickname, 
    password, 
    registrationDate, 
    biography, 
    updateDate, 
    email, 
    phoneNumber, 
    preference_user
) 
VALUES
    ('123e4567-e89b-12d3-a456-426614174000', '1985-06-15', 'male', 'Martin', 'Lucas', 'dark_lucas_skywolker', 'hashed_password', NOW(), 'Bio of Lucas Martin', NOW(), 'lucas.martin@example.com', '0123456789', '{"notificationFollow": true, "notificationMessage": true, "darkTheme": false, "notificationPublicity": true, "notificationPublication": false, "notificationFriend": true}'),
    ('123e4567-e89b-12d3-a456-426614174001', '1990-08-20', 'female', 'Lemoine', 'Sophie', 'sophie_l', 'hashed_password', NOW(), 'Bio of Sophie Lemoine', NOW(), 'sophie.lemoine@example.com', '0987654321', '{"notificationFollow": true, "notificationMessage": false, "darkTheme": true, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": false}'),
    ('123e4567-e89b-12d3-a456-426614174002', '1988-11-30', 'unknown', 'Dupont', 'Julien', 'dark_sayan_62', 'hashed_password', NOW(), 'Bio of Julien Dupont', NOW(), 'julien.dupont@example.com', '0246813579', '{"notificationFollow": false, "notificationMessage": true, "darkTheme": false, "notificationPublicity": true, "notificationPublication": true, "notificationFriend": true}'),
    ('123e4567-e89b-12d3-a456-426614174003', '1995-02-25', 'female', 'Benoit', 'Claire', 'claire_b', 'hashed_password', NOW(), 'Bio of Claire Benoit', NOW(), 'claire.benoit@example.com', '0129876543', '{"notificationFollow": true, "notificationMessage": true, "darkTheme": true, "notificationPublicity": false, "notificationPublication": false, "notificationFriend": true}'),
    ('123e4567-e89b-12d3-a456-426614174004', '2000-03-10', 'male', 'Fournier', 'Thomas', 'dark_bergerbblanc_du_30', 'hashed_password', NOW(), 'Bio of Thomas Fournier', NOW(), 'thomas.fournier@example.com', '0567890123', '{"notificationFollow": false, "notificationMessage": false, "darkTheme": true, "notificationPublicity": true, "notificationPublication": true, "notificationFriend": false}'),
    ('123e4567-e89b-12d3-a456-426614174005', '1982-04-18', 'other', 'Garcia', 'Gabriel', 'naruto_bg_92', 'hashed_password', NOW(), 'Bio of Gabriel Garcia', NOW(), 'gabriel.garcia@example.com', '0678901234', '{"notificationFollow": true, "notificationMessage": false, "darkTheme": false, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": true}'),
    ('123e4567-e89b-12d3-a456-426614174006', '1970-01-01', 'other', 'Dieu', 'Developpeur', 'RaptorJesus', 'Dieu', NOW(), 'Dieux créa le développeur, puis le développeur coda lIA, puis lIA crea les Lambda', NOW(), 'Dieu', '777-444-0000', '{"notificationFollow": true, "notificationMessage": false, "darkTheme": true, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": true}');

-- Insérer des données dans la table `user_role`
INSERT INTO user_role (idUser, idRole)
VALUES
  ((SELECT idUser FROM "user" WHERE name = 'John' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'Admin' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Jane' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'User' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Alice' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'Document Manager' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Bob' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'Merch Manager' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Charlie' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'Moderator' LIMIT 1)),
  ((SELECT idUser FROM "user" WHERE name = 'Dieu' LIMIT 1), (SELECT idRole FROM role WHERE roleName = 'Developer' LIMIT 1));