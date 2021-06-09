-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tienda_musical
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tienda_musical
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tienda_musical` DEFAULT CHARACTER SET utf8 ;
USE `tienda_musical` ;

-- -----------------------------------------------------
-- Table `tienda_musical`.`disquera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`disquera` (
  `idDisquera` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idDisquera`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`genero` (
  `idGenero` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idGenero`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`subgenero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`subgenero` (
  `idSubGenero` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `idGenero` INT(11) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idSubGenero`),
  INDEX `fk_subgenero_genero1_idx` (`idGenero` ASC) VISIBLE,
  CONSTRAINT `fk_subgenero_genero1`
    FOREIGN KEY (`idGenero`)
    REFERENCES `tienda_musical`.`genero` (`idGenero`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`nacionalidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`nacionalidad` (
  `idNacionalidad` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(60) NOT NULL,
  `abreviacion` VARCHAR(4) NULL DEFAULT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idNacionalidad`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`artista` (
  `idArtista` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `imagen` VARCHAR(100) NOT NULL,
  `idNacionalidad` INT(11) NOT NULL,
  `idSubGenero` INT(11) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idArtista`),
  INDEX `fk_artista_nacionalidad1_idx` (`idNacionalidad` ASC) VISIBLE,
  INDEX `fk_artista_genero1_idx` (`idSubGenero` ASC) VISIBLE,
  CONSTRAINT `fk_artista_genero1`
    FOREIGN KEY (`idSubGenero`)
    REFERENCES `tienda_musical`.`subgenero` (`idSubGenero`),
  CONSTRAINT `fk_artista_nacionalidad1`
    FOREIGN KEY (`idNacionalidad`)
    REFERENCES `tienda_musical`.`nacionalidad` (`idNacionalidad`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`album` (
  `idAlbum` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `imagen` VARCHAR(100) NULL DEFAULT NULL,
  `descripcion` TEXT NULL DEFAULT NULL,
  `anio` INT(11) NOT NULL,
  `formato` VARCHAR(10) NULL DEFAULT NULL,
  `valor` DECIMAL(6,2) NULL DEFAULT NULL,
  `idDisquera` INT(11) NOT NULL,
  `idArtista` INT(11) NOT NULL,
  `raiting` INT(11) NULL DEFAULT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idAlbum`),
  INDEX `disquera_idx` (`idDisquera` ASC) VISIBLE,
  INDEX `fk_album_artista1_idx` (`idArtista` ASC) VISIBLE,
  CONSTRAINT `disquera`
    FOREIGN KEY (`idDisquera`)
    REFERENCES `tienda_musical`.`disquera` (`idDisquera`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_album_artista1`
    FOREIGN KEY (`idArtista`)
    REFERENCES `tienda_musical`.`artista` (`idArtista`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`rol` (
  `idRol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`tipoidentificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`tipoidentificacion` (
  `idTipoIdentificacion` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idTipoIdentificacion`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`persona` (
  `idPersona` INT(11) NOT NULL AUTO_INCREMENT,
  `numeroIdentificacion` VARCHAR(12) NULL DEFAULT NULL,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `primerApellido` VARCHAR(100) NULL DEFAULT NULL,
  `segundoApellido` VARCHAR(45) NULL DEFAULT NULL,
  `imagen` VARCHAR(100) NULL DEFAULT NULL,
  `idTipoIdentificacion` INT(11) NULL DEFAULT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `idRol` INT(11) NULL DEFAULT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `nro_identificacion_UNIQUE` (`numeroIdentificacion` ASC) VISIBLE,
  INDEX `fk_persona_tipoIdentificacion1_idx` (`idTipoIdentificacion` ASC) VISIBLE,
  INDEX `fk_persona_rol1_idx` (`idRol` ASC) VISIBLE,
  CONSTRAINT `fk_persona_rol1`
    FOREIGN KEY (`idRol`)
    REFERENCES `tienda_musical`.`rol` (`idRol`),
  CONSTRAINT `fk_persona_tipoIdentificacion1`
    FOREIGN KEY (`idTipoIdentificacion`)
    REFERENCES `tienda_musical`.`tipoidentificacion` (`idTipoIdentificacion`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`carrito` (
  `idCarrito` INT(11) NOT NULL AUTO_INCREMENT,
  `idPersona` INT(11) NOT NULL,
  PRIMARY KEY (`idCarrito`),
  INDEX `fk_carrito_persona1_idx` (`idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_carrito_persona1`
    FOREIGN KEY (`idPersona`)
    REFERENCES `tienda_musical`.`persona` (`idPersona`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`factura` (
  `idFactura` INT(11) NOT NULL AUTO_INCREMENT,
  `orderId` VARCHAR(50) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  `impuestoTotal` DECIMAL(10,2) NOT NULL,
  `envio` DECIMAL(10,2) NOT NULL,
  `envioDescuento` DECIMAL(10,2) NOT NULL,
  `handling` DECIMAL(10,2) NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `direccion` VARCHAR(500) NOT NULL,
  `codigoPostal` VARCHAR(5) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `divisa` VARCHAR(45) NOT NULL,
  `idPersona` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_factura_has_persona_idx` (`idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_factura_has_persona`
    FOREIGN KEY (`idPersona`)
    REFERENCES `tienda_musical`.`persona` (`idPersona`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`carrito_album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`carrito_album` (
  `idCarritoAlbum` INT(11) NOT NULL AUTO_INCREMENT,
  `idCarrito` INT(11) NOT NULL,
  `idAlbum` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `estatus` VARCHAR(45) NOT NULL,
  `fechaCompra` DATETIME NULL DEFAULT NULL,
  `idFactura` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCarritoAlbum`, `idCarrito`, `idAlbum`),
  INDEX `fk_carrito_has_album_album1_idx` (`idAlbum` ASC) VISIBLE,
  INDEX `fk_carrito_has_album_carrito1_idx` (`idCarrito` ASC) VISIBLE,
  INDEX `fk_carrito_has_album_factura_idx` (`idFactura` ASC) VISIBLE,
  CONSTRAINT `fk_carrito_has_album_album1`
    FOREIGN KEY (`idAlbum`)
    REFERENCES `tienda_musical`.`album` (`idAlbum`),
  CONSTRAINT `fk_carrito_has_album_carrito1`
    FOREIGN KEY (`idCarrito`)
    REFERENCES `tienda_musical`.`carrito` (`idCarrito`),
  CONSTRAINT `fk_carrito_has_album_factura`
    FOREIGN KEY (`idFactura`)
    REFERENCES `tienda_musical`.`factura` (`idFactura`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tienda_musical`.`tema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda_musical`.`tema` (
  `idTema` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `letra` TEXT NULL DEFAULT NULL,
  `idAlbum` INT(11) NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `fechaModificacion` DATETIME NULL DEFAULT NULL,
  `estatus` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idTema`),
  INDEX `fk_tema_album1_idx` (`idAlbum` ASC) VISIBLE,
  CONSTRAINT `fk_tema_album1`
    FOREIGN KEY (`idAlbum`)
    REFERENCES `tienda_musical`.`album` (`idAlbum`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
