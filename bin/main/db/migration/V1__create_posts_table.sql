CREATE TABLE posts(
    id        SERIAL       NOT NULL,
    memo      VARCHAR(256) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id) 
);