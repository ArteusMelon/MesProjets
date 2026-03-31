CREATE TABLE category (
    idCategory UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT
);
CREATE TABLE role (
    idRole UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    roleName VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE relation_type (
    idRelationType UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    relationName VARCHAR(50) NOT NULL,
    description TEXT
);

CREATE TABLE product (
    idProduct UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(55) NOT NULL,
    price NUMERIC(10,2),
    stock INT,
    creationDate DATE NOT NULL,
    releaseDate DATE,
    display BOOLEAN NOT NULL DEFAULT false,
    productDescription TEXT,
    updateDate DATE
);

CREATE TABLE "user" (
    idUser UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    birthdate DATE,
    sex sex_enum NOT NULL DEFAULT 'unknown',
    name VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    registrationDate DATE NOT NULL DEFAULT NOW(),
    biography TEXT,
    updateDate DATE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phoneNumber VARCHAR(20),
    preference_user JSONB NOT NULL
);

CREATE TABLE address (
    idAddress UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255),
    company VARCHAR(255),
    streetNumber VARCHAR(20),
    streetName VARCHAR(255) NOT NULL,
    additionalInfo VARCHAR(255),
    postalcode VARCHAR(20) NOT NULL,
    city VARCHAR(255) NOT NULL,
    region VARCHAR(255),
    country VARCHAR(2) NOT NULL DEFAULT 'FR',  -- ISO 3166-1 alpha-2 (ex: 'FR', 'US')
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idUser UUID,
    CONSTRAINT fk_user_address FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE CASCADE
);

CREATE TABLE litter (
    idLitter UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    numberLOF VARCHAR(50),
    numberLitter VARCHAR(50),
    matingDate DATE NOT NULL,
    birthdate DATE
);

CREATE TABLE dog (
    idDog UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50),
    numberLOF VARCHAR(50),
    numberICAD VARCHAR(50),
    weight NUMERIC(10,2),
    dogCode VARCHAR(50),
    sex sex_enum NOT NULL DEFAULT 'unknown',
    birthdate DATE,
    modificationDate DATE,
    collarColor VARCHAR(15),
    idLitter UUID DEFAULT NULL,
    idUser UUID,
    CONSTRAINT fk_dog_user FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE SET NULL,
    CONSTRAINT fk_dog_litter FOREIGN KEY (idLitter) REFERENCES litter(idLitter) ON DELETE SET NULL
);


CREATE TABLE dog_media (
    idDog UUID,
    idMedia VARCHAR(24),
    PRIMARY KEY (idDog, idMedia),
    CONSTRAINT fk_dog_media_dog FOREIGN KEY (idDog) REFERENCES dog(idDog) ON DELETE CASCADE
);
CREATE TABLE product_category (
    idCategory UUID,
    idProduct UUID,
    PRIMARY KEY (idCategory, idProduct),
    CONSTRAINT fk_product_category_category FOREIGN KEY (idCategory) REFERENCES category(idCategory) ON DELETE CASCADE,
    CONSTRAINT fk_product_category_product FOREIGN KEY (idProduct) REFERENCES product(idProduct) ON DELETE CASCADE
);


CREATE TABLE product_media (
    idProduct UUID,
    idMedia VARCHAR(24),
    PRIMARY KEY (idProduct, idMedia),
    CONSTRAINT fk_product_media_product FOREIGN KEY (idProduct) REFERENCES product(idProduct) ON DELETE CASCADE
);
CREATE TABLE deliveryMode (
    idDeliveryMode UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL DEFAULT 0.00 -- Tarification
);

CREATE TABLE "order" (
    idorder UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    tracking VARCHAR(255),
    orderNumber VARCHAR(50),
    dateorder DATE NOT NULL,
    idUser UUID,
    idAddress UUID,
    idDeliveryMode UUID,
    CONSTRAINT fk_order_user FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE SET NULL,
    CONSTRAINT fk_order_address FOREIGN KEY (idAddress) REFERENCES address(idAddress) ON DELETE SET NULL,
    CONSTRAINT fk_order_deliveryMode FOREIGN KEY (idDeliveryMode) REFERENCES deliveryMode(idDeliveryMode) ON DELETE SET NULL
);

CREATE TABLE order_product (
    idorder UUID,
    idProduct UUID,
    PRIMARY KEY (idorder, idProduct),
    CONSTRAINT fk_order_product_order FOREIGN KEY (idorder) REFERENCES "order"(idorder) ON DELETE CASCADE,
    CONSTRAINT fk_order_product_product FOREIGN KEY (idProduct) REFERENCES product(idProduct) ON DELETE CASCADE
);


CREATE TABLE payment (
    idPayment UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    paymentDate DATE NOT NULL,
    idorder UUID NOT NULL,
    CONSTRAINT fk_payment_order FOREIGN KEY (idorder) REFERENCES "order"(idorder) ON DELETE CASCADE
);


CREATE TABLE user_role (
    idUser UUID,
    idRole UUID,
    PRIMARY KEY (idUser, idRole),
    CONSTRAINT fk_user_role_user FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE CASCADE,
    CONSTRAINT fk_user_role_role FOREIGN KEY (idRole) REFERENCES role(idRole) ON DELETE CASCADE
);

CREATE TABLE user_relation (
    idUserReceiver UUID,
    idSourceUser UUID,
    idRelationType UUID,
    PRIMARY KEY (idUserReceiver, idSourceUser, idRelationType),
    CONSTRAINT fk_relation_user_receiver FOREIGN KEY (idUserReceiver) REFERENCES "user"(idUser) ON DELETE CASCADE,
    CONSTRAINT fk_relation_user_source FOREIGN KEY (idSourceUser) REFERENCES "user"(idUser) ON DELETE CASCADE,
    CONSTRAINT fk_relation_reference FOREIGN KEY (idRelationType) REFERENCES relation_type(idRelationType) ON DELETE CASCADE
);

CREATE TABLE litter_media (
    idLitter UUID,
    idMedia VARCHAR(24),
    PRIMARY KEY (idLitter, idMedia),
    CONSTRAINT fk_link_litter_media FOREIGN KEY (idLitter) REFERENCES litter(idLitter) ON DELETE CASCADE
);

CREATE TABLE user_media (
    idUser UUID,
    idMedia VARCHAR(24),
    PRIMARY KEY (idUser, idMedia),
    CONSTRAINT fk_link_user FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE CASCADE
);

CREATE TABLE token (
    idToken UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    tokenName VARCHAR(50) NOT NULL,
    tokenValue TEXT NOT NULL UNIQUE,
    expiration TIMESTAMP WITH TIME ZONE NOT NULL,
    createdAt TIMESTAMP WITH TIME ZONE NOT NULL,
    ip VARCHAR(60),
    tokenRevoked BOOLEAN DEFAULT false,
    idUser UUID,
    CONSTRAINT fk_user_token FOREIGN KEY (idUser) REFERENCES "user"(idUser) ON DELETE CASCADE
);


