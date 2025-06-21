# Prueba 2

## Creacion base de dato

CREATE DATABASE perfulandia; use perfulandia;

CREATE TABLE perfulandia.product (
id_product INT NOT NULL,
name_product VARCHAR(45) NOT NULL,
desc_product VARCHAR(45) NOT NULL,
precio VARCHAR(45) NOT NULL,
PRIMARY KEY (id_product));

CREATE TABLE `perfulandia`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_client` VARCHAR(100) NULL,
  `email_client` VARCHAR(45) NULL,
  `phone_client` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client`));

CREATE TABLE `perfulandia`.`sales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NOT NULL,
  `sales_date` VARCHAR(45) NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `client_id_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `perfulandia`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `perfulandia`.`sales_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  `sales_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `sales_detail_product_idx` (`product_id` ASC) VISIBLE,
  INDEX `sales_detail_sales_idx` (`sales_id` ASC) VISIBLE,
  CONSTRAINT `sales_detail_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `perfulandia`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sales_detail_sales`
    FOREIGN KEY (`sales_id`)
    REFERENCES `perfulandia`.`sales` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

## DTO

### ProductDTO

private Long id;

@JsonProperty(value="Nombre_Producto")

private String name_product;

@JsonProperty(value="Descripcion_Producto")

 private String desc_product;

 @JsonProperty(value="precio_Producto")

  private Long precio;
