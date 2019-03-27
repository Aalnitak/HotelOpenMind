-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `idhabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `ocupado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idhabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (1,'Jungla',0),(2,'Isla',0),(3,'Volcan',0),(4,'Glaciar',0),(5,'Oasis',0);
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasajero` (
  `rut` int(11) NOT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  `digito_verificador` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
INSERT INTO `pasajero` VALUES (17177177,'Hugo','Perez','Pereira','F','1985-05-24','Peruano','5'),(17402852,'Jose','Aldunce','Soto','M','1989-10-31','chilena','4'),(18172729,'David','Bousquet','Perez','M','1993-03-30','chilena','2');
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Jungla_momento','habitacion',6000,-1,'Habitacion'),(2,'Jungla_jornada','habitacion',16000,-1,'Habitacion'),(3,'Isla_momento','habitacion',5000,-1,'Habitacion'),(4,'Isla_jornada','habitacion',12000,-1,'Habitacion'),(5,'Volcan_momento','habitacion',7000,-1,'Habitacion'),(6,'Volcan_jornada','habitacion',20000,-1,'Habitacion'),(7,'Glaciar_momento','habitacion',6000,-1,'Habitacion'),(8,'Glaciar_jornada','habitacion',16000,-1,'Habitacion'),(9,'Oasis_momento','habitacion',7000,-1,'Habitacion'),(10,'Oasis_jornada','habitacion',20000,-1,'Habitacion');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_pasajeros`
--

DROP TABLE IF EXISTS `registro_pasajeros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_pasajeros` (
  `pasajero_rut` int(11) NOT NULL,
  `reserva_idjornada` int(11) NOT NULL,
  `id_registro` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_registro`),
  KEY `fk_pasajero_has_reserva_reserva1_idx` (`reserva_idjornada`),
  KEY `fk_pasajero_has_reserva_pasajero1_idx` (`pasajero_rut`),
  CONSTRAINT `fk_pasajero_has_reserva_pasajero1` FOREIGN KEY (`pasajero_rut`) REFERENCES `pasajero` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pasajero_has_reserva_reserva1` FOREIGN KEY (`reserva_idjornada`) REFERENCES `reserva` (`idjornada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_pasajeros`
--

LOCK TABLES `registro_pasajeros` WRITE;
/*!40000 ALTER TABLE `registro_pasajeros` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_pasajeros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `pasajero_rut` int(11) NOT NULL,
  `habitacion_idhabitacion` int(11) NOT NULL,
  `idjornada` int(11) NOT NULL AUTO_INCREMENT,
  `inicio` datetime DEFAULT NULL,
  `limite_tiempo` datetime DEFAULT NULL,
  `num_pasajeros` int(11) DEFAULT NULL,
  `momento` tinyint(4) DEFAULT NULL,
  `momento_salida` datetime DEFAULT NULL COMMENT 'Es ingresado una vez que la persona sale, o cuando se termina el tiempo. Lo que ocurra antes.',
  PRIMARY KEY (`idjornada`),
  KEY `fk_pasajero_has_habitacion_habitacion1_idx` (`habitacion_idhabitacion`),
  KEY `fk_pasajero_has_habitacion_pasajero_idx` (`pasajero_rut`),
  CONSTRAINT `fk_pasajero_has_habitacion_habitacion1` FOREIGN KEY (`habitacion_idhabitacion`) REFERENCES `habitacion` (`idhabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pasajero_has_habitacion_pasajero` FOREIGN KEY (`pasajero_rut`) REFERENCES `pasajero` (`rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_has_producto`
--

DROP TABLE IF EXISTS `reserva_has_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva_has_producto` (
  `reserva_idjornada` int(11) NOT NULL,
  `producto_idproducto` int(11) NOT NULL,
  `idreserva_has_producto` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idreserva_has_producto`),
  KEY `fk_reserva_has_producto_producto1_idx` (`producto_idproducto`),
  KEY `fk_reserva_has_producto_reserva1_idx` (`reserva_idjornada`),
  CONSTRAINT `fk_reserva_has_producto_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_has_producto_reserva1` FOREIGN KEY (`reserva_idjornada`) REFERENCES `reserva` (`idjornada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_has_producto`
--

LOCK TABLES `reserva_has_producto` WRITE;
/*!40000 ALTER TABLE `reserva_has_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva_has_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-27 10:07:50
