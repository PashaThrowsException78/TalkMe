CREATE TABLE actions_detail
(
    actions_detail_id BIGINT AUTO_INCREMENT NOT NULL,
    program_id        BIGINT                NULL,
    name              VARCHAR(255)          NULL,
    type              INT                   NULL,
    CONSTRAINT pk_actions_detail PRIMARY KEY (actions_detail_id)
);

CREATE TABLE category
(
    category_id BIGINT       NOT NULL,
    name        VARCHAR(255) UNIQUE NOT NULL,
    language    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id)
);

CREATE TABLE picture
(
    id      BIGINT       NOT NULL,
    picture VARCHAR(255) NULL
);

CREATE TABLE product
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)          NOT NULL,
    price BIGINT                NOT NULL,
    model VARCHAR(255)          NULL,
    url   VARCHAR(255)          NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE program
(
    program_id        BIGINT AUTO_INCREMENT NOT NULL,
    name              VARCHAR(255)          NULL,
    gotolink          VARCHAR(255)          NULL,
    products_xml_link VARCHAR(255)          NULL,
    CONSTRAINT pk_program PRIMARY KEY (program_id)
);

CREATE TABLE program_categories
(
    categories_category_id BIGINT NOT NULL,
    posts_program_id       BIGINT NOT NULL,
    CONSTRAINT pk_program_categories PRIMARY KEY (categories_category_id, posts_program_id)
);


ALTER TABLE actions_detail
    ADD CONSTRAINT FK_ACTIONS_DETAIL_ON_PROGRAM FOREIGN KEY (program_id) REFERENCES program (program_id);

ALTER TABLE picture
    ADD CONSTRAINT fk_picture_on_product FOREIGN KEY (id) REFERENCES product (id);

ALTER TABLE program_categories
    ADD CONSTRAINT fk_procat_on_category FOREIGN KEY (categories_category_id) REFERENCES category (category_id);

ALTER TABLE program_categories
    ADD CONSTRAINT fk_procat_on_program FOREIGN KEY (posts_program_id) REFERENCES program (program_id);