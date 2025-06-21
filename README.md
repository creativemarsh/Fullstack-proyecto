# Prueba 2

### Contrasena base de dato

##### Samuel

Admin

System

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
  `amount` VARCHAR(45) NOT NULL,
  `sales_date` VARCHAR(45) NOT NULL,
  `client_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

## DTO

### ProductDTO

private Long id;

@JsonProperty(value="Nombre_Producto")

private String name_product;

@JsonProperty(value="Descripcion_Producto")

 private String desc_product;

 @JsonProperty(value="precio_Producto")

  private Long precio;
