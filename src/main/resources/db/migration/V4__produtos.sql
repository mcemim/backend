CREATE TABLE produto
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    qtd INT,
    created_at TIMESTAMP ,
    updated_at TIMESTAMP ,
    PRIMARY KEY (id)
);