create table users
(
    id       bigserial
        constraint users_pkey
            primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    enabled  boolean      not null
);

create table roles
(
    id   bigserial
        constraint roles_pkey
            primary key,
    name varchar(100) not null
);

create table users_roles
(
    user_id integer not null
        constraint users_roles_user_id_fkey
            references users,
    role_id integer not null
        constraint users_roles_role_id_fkey
            references roles,
    constraint users_roles_user_id_role_id_key
        unique (user_id, role_id)
);

create table act_notes
(
    id                                   bigint generated by default as identity
        constraint act_notes_pkey
            primary key,
    child_patronymic                     varchar(255),
    child_country                        varchar(255),
    child_date_of_birth                  varchar(255),
    child_date_of_issue_of_the_document  varchar(255),
    child_gender                         varchar(255),
    child_iin                            varchar(255),
    child_issuing_authority              varchar(255),
    child_name                           varchar(255),
    child_number_of_children_born        varchar(255),
    child_number_of_document             varchar(255),
    child_populated_locality             varchar(255),
    child_surname                        varchar(255),
    child_type_of_document               varchar(255),
    date_of_change                       varchar(255),
    date_of_registration                 varchar(255),
    parent_citizenship                   varchar(255),
    parent_country                       varchar(255),
    parent_date_of_birth                 varchar(255),
    parent_date_of_issue_of_the_document varchar(255),
    parent_gender                        varchar(255),
    parent_iin                           varchar(255),
    parent_issuing_authority             varchar(255),
    parent_name                          varchar(255),
    parent_nationality                   varchar(255),
    parent_number_of_document            varchar(255),
    parent_patronymic                    varchar(255),
    parent_populated_locality            varchar(255),
    parent_series_of_document            varchar(255),
    parent_surname                       varchar(255),
    parent_type_of_document              varchar(255),
    status_of_newborn                    varchar(255)
);

INSERT INTO roles (name)
VALUES ('USER');
INSERT INTO roles (name)
VALUES ('ADMIN');

-- login password
-- admin admin has role ADMIN
-- user user has role USER
INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$KcULg0Ojbc6icFt6WujHr.MDmdxT6/ix5Uw7wsI1RNz5MPxWXStGO', true);
INSERT INTO users (username, password, enabled)
VALUES ('user', '$2a$10$eId5dYrGWCwhqqfEBUH4me76K/Sm6sS67c9b1G3ApbwfLjU2VtNoi', true);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);