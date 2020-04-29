CREATE TABLE employee
(
    id         BIGSERIAL PRIMARY KEY,
    name       varchar(255) NOT NULL,
    department_id BIGINT    NOT NULL
);