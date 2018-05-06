-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: tienda_de_ropa
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `abonos`
--

DROP TABLE IF EXISTS `abonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abonos` (
  `FOLIO_TICKET` int(11) NOT NULL,
  `FOLIO_APARTADO` int(11) NOT NULL,
  PRIMARY KEY (`FOLIO_TICKET`),
  KEY `FOLIO_APARTADO` (`FOLIO_APARTADO`),
  CONSTRAINT `abonos_ibfk_1` FOREIGN KEY (`FOLIO_TICKET`) REFERENCES `ingresos` (`FOLIO`) ON UPDATE CASCADE,
  CONSTRAINT `abonos_ibfk_2` FOREIGN KEY (`FOLIO_APARTADO`) REFERENCES `apartados` (`FOLIO`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonos`
--

LOCK TABLES `abonos` WRITE;
/*!40000 ALTER TABLE `abonos` DISABLE KEYS */;
INSERT INTO `abonos` VALUES (1,1),(3,2),(4,2),(5,3),(6,4),(7,4),(8,5),(9,6),(10,6),(11,7),(12,7),(13,8),(14,9);
/*!40000 ALTER TABLE `abonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `abonos_apartados`
--

DROP TABLE IF EXISTS `abonos_apartados`;
/*!50001 DROP VIEW IF EXISTS `abonos_apartados`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `abonos_apartados` AS SELECT 
 1 AS `FOLIO_APARTADO`,
 1 AS `FOLIO_TICKET`,
 1 AS `FECHA`,
 1 AS `USUARIO`,
 1 AS `MONTO`,
 1 AS `CANCELADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `apartados`
--

DROP TABLE IF EXISTS `apartados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartados` (
  `FOLIO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ASIGNACION` int(11) NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `ENTREGADO` tinyint(1) NOT NULL DEFAULT '0',
  `COSTO` float NOT NULL,
  `SALDO_PENDIENTE` float NOT NULL,
  `CANCELADO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`FOLIO`),
  KEY `ID_ASIGNACION` (`ID_ASIGNACION`),
  KEY `ID_CLIENTE` (`ID_CLIENTE`),
  CONSTRAINT `apartados_ibfk_1` FOREIGN KEY (`ID_ASIGNACION`) REFERENCES `ventas_productos` (`ID_ASIGNACION`) ON UPDATE CASCADE,
  CONSTRAINT `apartados_ibfk_2` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `clientes` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartados`
--

LOCK TABLES `apartados` WRITE;
/*!40000 ALTER TABLE `apartados` DISABLE KEYS */;
INSERT INTO `apartados` VALUES (1,4,3,0,1200,960,0),(2,8,6,0,2300,600,0),(3,9,7,0,1300,910,0),(4,10,8,0,1500,1000,0),(5,11,9,0,1000,700,0),(6,13,10,0,900,600,0),(7,14,2,0,1600,1100,0),(8,15,11,0,1000,700,0),(9,17,12,0,2000,1400,0);
/*!40000 ALTER TABLE `apartados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `apartados_por_cliente`
--

DROP TABLE IF EXISTS `apartados_por_cliente`;
/*!50001 DROP VIEW IF EXISTS `apartados_por_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `apartados_por_cliente` AS SELECT 
 1 AS `ID_CLIENTE`,
 1 AS `FOLIO`,
 1 AS `FOLIO_VENTA`,
 1 AS `CLAVE_PRODUCTO`,
 1 AS `NOMBRE`,
 1 AS `PRECIO`,
 1 AS `SALDO_PENDIENTE`,
 1 AS `CANCELADO`,
 1 AS `ENTREGADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `aperturas_de_caja`
--

DROP TABLE IF EXISTS `aperturas_de_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aperturas_de_caja` (
  `FECHA` date NOT NULL,
  `MONTO` float NOT NULL,
  PRIMARY KEY (`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aperturas_de_caja`
--

LOCK TABLES `aperturas_de_caja` WRITE;
/*!40000 ALTER TABLE `aperturas_de_caja` DISABLE KEYS */;
INSERT INTO `aperturas_de_caja` VALUES ('2018-02-24',0),('2018-02-26',1600),('2018-02-28',400),('2018-03-03',200),('2018-03-05',100),('2018-03-06',200),('2018-03-07',200),('2018-03-08',200),('2018-03-09',200);
/*!40000 ALTER TABLE `aperturas_de_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `buscar_por_subfolio`
--

DROP TABLE IF EXISTS `buscar_por_subfolio`;
/*!50001 DROP VIEW IF EXISTS `buscar_por_subfolio`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `buscar_por_subfolio` AS SELECT 
 1 AS `ID_CLIENTE`,
 1 AS `SUBFOLIO`,
 1 AS `FOLIO`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'TENIS PARA CORRER'),(2,'TENIS CASUALES'),(3,'chutes'),(4,'futbol rapido'),(5,'basketbol'),(6,'nike'),(7,'reebok'),(8,'under armour'),(9,'adidas'),(10,'sketshers'),(11,'puma'),(12,'vanz');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO_PATERNO` varchar(30) NOT NULL,
  `APELLIDO_MATERNO` varchar(30) NOT NULL,
  `TELEFONO1` varchar(15) NOT NULL,
  `TELEFONO2` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Publico','General','','0000000000',''),(2,'yury','gastelum','g','6271193341','0'),(3,'Clara','Barron','','6271029838',''),(4,'Rocio','Rubio','','6271139802',''),(5,'Flor','Flores','','6271084073',''),(6,'juan','cazarez','.','2','2'),(7,'eduardo','infante','i','0000','0000'),(8,'flor','flores','f','9','9'),(9,'rocio','rubio','r','6271139802',''),(10,'julio cesar','chaves','o','6272791603','12'),(11,'martina','zapien','o','6271153329','12'),(12,'carlos','torres','p','5234026','22');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `clientes_con_formato`
--

DROP TABLE IF EXISTS `clientes_con_formato`;
/*!50001 DROP VIEW IF EXISTS `clientes_con_formato`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `clientes_con_formato` AS SELECT 
 1 AS `ID`,
 1 AS `NOMBRE`,
 1 AS `TELEFONO1`,
 1 AS `TELEFONO2`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `compra_detalle`
--

DROP TABLE IF EXISTS `compra_detalle`;
/*!50001 DROP VIEW IF EXISTS `compra_detalle`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `compra_detalle` AS SELECT 
 1 AS `FOLIO_COMPRA`,
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `CANTIDAD`,
 1 AS `PRECIO_UNITARIO`,
 1 AS `PRECIO_TOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `FOLIO` int(11) NOT NULL AUTO_INCREMENT,
  `FOLIO_EGRESO` int(11) NOT NULL,
  `CANCELADO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`FOLIO`),
  KEY `FOLIO_EGRESO` (`FOLIO_EGRESO`),
  CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`FOLIO_EGRESO`) REFERENCES `egresos` (`FOLIO`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,1,0),(2,2,0);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_productos`
--

DROP TABLE IF EXISTS `compras_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras_productos` (
  `FOLIO_COMPRA` int(11) NOT NULL,
  `CLAVE_PRODUCTO` varchar(15) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIO_UNITARIO` float NOT NULL,
  KEY `FOLIO_COMPRA` (`FOLIO_COMPRA`),
  KEY `CLAVE_PRODUCTO` (`CLAVE_PRODUCTO`),
  CONSTRAINT `compras_productos_ibfk_1` FOREIGN KEY (`FOLIO_COMPRA`) REFERENCES `compras` (`FOLIO`) ON UPDATE CASCADE,
  CONSTRAINT `compras_productos_ibfk_2` FOREIGN KEY (`CLAVE_PRODUCTO`) REFERENCES `productos` (`CLAVE`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_productos`
--

LOCK TABLES `compras_productos` WRITE;
/*!40000 ALTER TABLE `compras_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `consulta_producto`
--

DROP TABLE IF EXISTS `consulta_producto`;
/*!50001 DROP VIEW IF EXISTS `consulta_producto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `consulta_producto` AS SELECT 
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `CATEGORIA`,
 1 AS `PRECIO`,
 1 AS `EXISTENCIA`,
 1 AS `IMAGEN`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `consultas`
--

DROP TABLE IF EXISTS `consultas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` int(11) NOT NULL,
  `CLAVE_PRODUCTO` varchar(15) NOT NULL,
  `FECHA` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `CLAVE_PRODUCTO` (`CLAVE_PRODUCTO`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`CLAVE_PRODUCTO`) REFERENCES `productos` (`CLAVE`) ON UPDATE CASCADE,
  CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas`
--

LOCK TABLES `consultas` WRITE;
/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
INSERT INTO `consultas` VALUES (1,2,'1264221','2018-02-24 16:16:52'),(2,2,'1264221','2018-02-24 16:19:00'),(3,2,'1264221-669','2018-02-24 16:20:09'),(9,2,'54152','2018-02-26 15:29:43'),(10,2,'065297146','2018-02-26 15:30:47'),(11,2,'1264221-669','2018-02-28 10:37:08'),(13,2,'1264221-669','2018-03-02 09:17:03'),(14,2,'1264221-669','2018-03-02 09:17:06'),(15,2,'1264221-669','2018-03-02 09:17:06'),(16,2,'1264221-669','2018-03-02 09:17:06'),(17,2,'1264221-669','2018-03-02 09:17:11'),(18,2,'1264221-669','2018-03-02 09:17:11'),(19,2,'1264221-669','2018-03-02 09:17:11'),(20,2,'844595','2018-03-03 09:36:16'),(21,2,'831943','2018-03-03 10:12:40'),(22,2,'831943','2018-03-05 09:53:14'),(23,2,'903599','2018-03-05 09:55:22'),(24,2,'117684761','2018-03-05 09:56:03'),(25,2,'1259034-410','2018-03-05 11:04:30'),(26,3,'917742-004-','2018-03-05 12:40:29'),(27,2,'917742-004-','2018-03-05 12:43:34'),(28,4,'917742-004-','2018-03-05 15:29:46'),(29,4,'1259034-410','2018-03-05 16:12:20'),(30,4,'1264221-669','2018-03-05 17:14:39'),(31,4,'1274062 ','2018-03-05 17:30:08'),(32,2,'118370143','2018-03-05 19:48:41'),(33,4,'749891','2018-03-06 09:00:47'),(34,4,'113955746','2018-03-06 09:10:18'),(35,4,'118281461','2018-03-06 10:21:25'),(36,4,'1266305','2018-03-06 15:36:55'),(37,4,'724382','2018-03-06 16:01:22'),(38,4,'118281461','2018-03-06 16:09:55'),(39,4,'1255782','2018-03-06 16:22:14'),(40,4,'917769','2018-03-06 16:40:14'),(41,4,'1259034','2018-03-06 18:50:46'),(42,2,'4501275287','2018-03-06 19:41:12'),(43,4,'897644-005','2018-03-07 11:00:29'),(44,4,'917742-004','2018-03-07 14:00:56'),(45,4,'917742-004','2018-03-07 14:01:11'),(46,2,'1258736-039','2018-03-07 15:36:03'),(47,2,'1266379-427','2018-03-07 15:41:13'),(48,2,'1266252-037','2018-03-07 15:42:36'),(49,2,'1258728','2018-03-07 15:43:31'),(50,4,'903599','2018-03-08 11:13:03'),(51,4,'721356','2018-03-08 13:16:57'),(52,4,'698001','2018-03-08 13:20:18'),(53,4,'698007','2018-03-08 14:58:44'),(54,4,'897644-005','2018-03-08 15:58:15'),(55,4,'852554','2018-03-08 17:16:59'),(56,4,'1266302','2018-03-08 18:02:23'),(57,4,'1258736-039','2018-03-09 09:38:10'),(58,4,'1258736-039','2018-03-09 09:38:13'),(59,4,'065297146','2018-03-09 09:38:23'),(60,4,'1258728-540','2018-03-09 09:39:49'),(61,4,'852577','2018-03-09 10:05:09'),(62,4,'698007','2018-03-09 10:27:41');
/*!40000 ALTER TABLE `consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `corte_caja`
--

DROP TABLE IF EXISTS `corte_caja`;
/*!50001 DROP VIEW IF EXISTS `corte_caja`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `corte_caja` AS SELECT 
 1 AS `FECHA`,
 1 AS `APERTURA`,
 1 AS `INGRESOS`,
 1 AS `EGRESOS`,
 1 AS `CIERRE`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!50001 DROP VIEW IF EXISTS `detalle_venta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `detalle_venta` AS SELECT 
 1 AS `FOLIO_VENTA`,
 1 AS `ASIGNACION`,
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `PRECIO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `detalles_productos`
--

DROP TABLE IF EXISTS `detalles_productos`;
/*!50001 DROP VIEW IF EXISTS `detalles_productos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `detalles_productos` AS SELECT 
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `NUEVO`,
 1 AS `CATEGORIA`,
 1 AS `PRECIO`,
 1 AS `DETALLES`,
 1 AS `IMAGEN`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `detalles_ventas_pendientes`
--

DROP TABLE IF EXISTS `detalles_ventas_pendientes`;
/*!50001 DROP VIEW IF EXISTS `detalles_ventas_pendientes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `detalles_ventas_pendientes` AS SELECT 
 1 AS `FOLIO`,
 1 AS `ID_CLIENTE`,
 1 AS `CLIENTE`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `egresos` (
  `FOLIO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID_USUARIO` int(11) NOT NULL,
  `TIPO` varchar(50) NOT NULL,
  `MONTO` float NOT NULL,
  `DETALLES` varchar(511) NOT NULL,
  `CANCELADO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`FOLIO`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  KEY `TIPO` (`TIPO`),
  CONSTRAINT `egresos_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `egresos_ibfk_2` FOREIGN KEY (`TIPO`) REFERENCES `tipos_egresos` (`TIPO`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
INSERT INTO `egresos` VALUES (1,'2018-03-05 11:02:39',2,'Compra de mercancia',0,'',0),(2,'2018-03-05 12:10:50',2,'Compra de mercancia',2,'',0);
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formas_de_pago`
--

DROP TABLE IF EXISTS `formas_de_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formas_de_pago` (
  `NOMBRE` varchar(30) NOT NULL,
  PRIMARY KEY (`NOMBRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formas_de_pago`
--

LOCK TABLES `formas_de_pago` WRITE;
/*!40000 ALTER TABLE `formas_de_pago` DISABLE KEYS */;
INSERT INTO `formas_de_pago` VALUES ('Apartado'),('Cancelado'),('Efectivo'),('Pendiente'),('Tarjeta');
/*!40000 ALTER TABLE `formas_de_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `FOLIO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID_USUARIO` int(11) NOT NULL,
  `TIPO` varchar(50) NOT NULL,
  `MONTO` float NOT NULL,
  `DETALLES` varchar(511) NOT NULL,
  `CANCELADO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`FOLIO`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  KEY `TIPO` (`TIPO`),
  CONSTRAINT `ingresos_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `ingresos_ibfk_2` FOREIGN KEY (`TIPO`) REFERENCES `tipos_ingresos` (`TIPO`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` VALUES (1,'2018-03-03 09:18:22',2,'Abono',240,'Apartado:under naranja-verde',0),(2,'2018-03-03 11:34:27',2,'Pago de contado',2300,'persona de fuera',0),(3,'2018-03-05 11:22:45',2,'Abono',690,'Apartado:nike lebron camuflaje',0),(4,'2018-03-05 11:24:54',2,'Abono',1010,'Apartado:nike lebron camuflaje',0),(5,'2018-03-05 11:33:24',2,'Abono',390,'Apartado:nike airmax naranja-azul',0),(6,'2018-03-05 11:40:12',2,'Abono',450,'Apartado:nike rapido naranja',0),(7,'2018-03-05 11:40:46',2,'Abono',50,'Apartado:nike rapido naranja',0),(8,'2018-03-05 11:44:48',2,'Abono',300,'Apartado:under negro-cinta blanca',0),(9,'2018-03-06 12:50:43',2,'Abono',270,'Apartado:nike rosa-morado',0),(10,'2018-03-06 12:51:35',2,'Abono',30,'Apartado:nike rosa-morado',0),(11,'2018-03-06 12:56:14',2,'Abono',480,'Apartado:adidas predator negro-blanco',0),(12,'2018-03-06 12:56:51',2,'Abono',20,'Apartado:adidas predator negro-blanco',0),(13,'2018-03-06 18:51:41',4,'Abono',300,'Apartado:under azul',0),(14,'2018-03-08 12:18:43',4,'Abono',600,'Apartado:nike jaeson keed negro',0);
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!50001 DROP VIEW IF EXISTS `inventario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inventario` AS SELECT 
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `NUEVO`,
 1 AS `CATEGORIA`,
 1 AS `EXISTENCIA`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `nivel_de_usuario`
--

DROP TABLE IF EXISTS `nivel_de_usuario`;
/*!50001 DROP VIEW IF EXISTS `nivel_de_usuario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `nivel_de_usuario` AS SELECT 
 1 AS `ID_USUARIO`,
 1 AS `NOMBRE`,
 1 AS `ID_NIVEL`,
 1 AS `NIVEL`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `niveles_usuario`
--

DROP TABLE IF EXISTS `niveles_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `niveles_usuario` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `NOMBRE` (`NOMBRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveles_usuario`
--

LOCK TABLES `niveles_usuario` WRITE;
/*!40000 ALTER TABLE `niveles_usuario` DISABLE KEYS */;
INSERT INTO `niveles_usuario` VALUES (1,'Administrador'),(2,'Cajero'),(0,'Superusuario');
/*!40000 ALTER TABLE `niveles_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `nombre_cliente`
--

DROP TABLE IF EXISTS `nombre_cliente`;
/*!50001 DROP VIEW IF EXISTS `nombre_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `nombre_cliente` AS SELECT 
 1 AS `ID`,
 1 AS `NOMBRE`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pagos_de_contado`
--

DROP TABLE IF EXISTS `pagos_de_contado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos_de_contado` (
  `FOLIO_VENTA` int(11) NOT NULL,
  `FOLIO_INGRESO` int(11) NOT NULL,
  PRIMARY KEY (`FOLIO_VENTA`),
  KEY `FOLIO_INGRESO` (`FOLIO_INGRESO`),
  CONSTRAINT `pagos_de_contado_ibfk_1` FOREIGN KEY (`FOLIO_VENTA`) REFERENCES `ventas` (`FOLIO`) ON UPDATE CASCADE,
  CONSTRAINT `pagos_de_contado_ibfk_2` FOREIGN KEY (`FOLIO_INGRESO`) REFERENCES `ingresos` (`FOLIO`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos_de_contado`
--

LOCK TABLES `pagos_de_contado` WRITE;
/*!40000 ALTER TABLE `pagos_de_contado` DISABLE KEYS */;
INSERT INTO `pagos_de_contado` VALUES (8,2);
/*!40000 ALTER TABLE `pagos_de_contado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `CLAVE` varchar(15) NOT NULL,
  `NOMBRE` varchar(511) NOT NULL,
  `NUEVO` tinyint(1) NOT NULL,
  `ID_CATEGORIA` int(11) NOT NULL,
  `PRECIO` float NOT NULL,
  `TALLA` varchar(20) NOT NULL DEFAULT '',
  `DETALLES` varchar(511) NOT NULL,
  `EXISTENCIA` int(11) NOT NULL DEFAULT '0',
  `IMAGEN` varchar(511) NOT NULL,
  PRIMARY KEY (`CLAVE`),
  KEY `ID_CATEGORIA` (`ID_CATEGORIA`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`ID_CATEGORIA`) REFERENCES `categorias` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('065297146','puma ferrari rojo',0,11,1200,'','numero 9',0,''),('113955746','adidas chute naranja',0,3,1200,'','numero 7',0,''),('116612218','adidas superstar blanco-azul',0,9,1200,'','numero 8',0,''),('117684761','chute nemesis verde rayas',0,3,1400,'','numero 8',0,''),('118221058','chute nemessis blanco',0,3,1400,'','numero 8',0,''),('118281461','adidas rapido negro-blanco',0,3,1600,'','numero8.5',0,''),('118370143','adidas predator negro-blanco',0,4,1200,'','numero 19',0,''),('118403028','adidas rapido predator',0,3,1600,'','numero 7',0,''),('118727479','adidas predator negro-blanco',0,4,1600,'','numero 6',0,''),('118727513','nemessis dorado',0,3,1300,'','',0,''),('1238581','under rojo',0,8,1000,'','numero 7',0,''),('1247997','under negro-cinta blanca',0,8,1000,'','numero 4',0,''),('1252307-040','under gris azul verde',0,8,1000,'','numero 4',0,''),('1254879','under crema -cafe',0,8,800,'','numero 7',0,''),('1254879-001','under negro-blanco',0,8,800,'','numero 7',0,''),('1255782','under cafe casual',0,8,800,'','numero 10',0,''),('1258728','under morado',0,8,1000,'','numero 5.5',0,''),('1258728-540','under morado',0,8,1000,'','numero 5.5',0,''),('1258736-039','under gris-azul',0,8,1000,'','numero 4',0,''),('1258785','under rojo',0,8,1200,'','numero 8',0,''),('1259034','under azul',0,5,1000,'','numero 4',0,''),('1259034-410','under de bota',0,1,1000,'','numero 4',0,''),('1263712','under azul-naranja',0,4,900,'','numero 7',0,''),('1264221','under naranja',0,8,1200,'','numero7',0,''),('1264221-669','under naranja-verde',0,4,1200,'','numero 7',0,''),('1266224','under negro-blanco',0,8,0,'','numero 7.5',0,''),('1266252-037','under gris-azul under blanca',0,8,1000,'','numero 4',0,''),('1266302','under gris-negro',0,7,1000,'','numero 3',0,''),('1266305','under negro- rosa',0,8,1000,'','numero 3',0,''),('1266306','under morado',0,8,850,'','numero 20',0,''),('1266320','under negro-verde',0,8,1000,'','numero 3',0,''),('1266376','under azul-negro',0,8,1000,'','numero 7',0,''),('1266379-427','under azul-verde',0,8,1000,'','numero 4',0,''),('1268334','under verde-rosa',0,8,1000,'','numero 7',0,''),('1272293','under negro-morado',0,8,1000,'','numero 3',0,''),('1272294','under azul-amarillo',0,8,850,'','numero 20',0,''),('1274062','under bota currey gris claro',0,5,1000,'','numero 3',0,''),('1274422','under amarillo',0,8,1000,'','',0,''),('1274425','under negro-rojo',0,5,1500,'','numero 7',0,''),('1299028','under azul-verde',0,5,1000,'','numero 3',0,''),('18851401','puma blanco-rojo',0,11,1000,'','numero 2',0,''),('18920101','puma blanco-rojo',0,11,800,'','numero 17',0,''),('19007602','puma negro-amarillo',0,11,650,'','numero19',0,''),('3000314','under azul-blanco',0,8,1000,'','numero 7',0,''),('4501212516','under azul-amarillo',0,5,1800,'','numero 7.5',0,''),('4501275287','under negro',0,8,1100,'','numero 5.5',0,''),('526628','nike verde-morado',0,6,1000,'','numero 8',0,''),('54152','sketshers gris metedera',0,10,1000,'','numero 9.5',0,''),('55061','sketshers negro- azul',0,10,1000,'','numero 7.5',0,''),('6491386','newbalance negro-amarillo',0,4,900,'','numero 9,5',0,''),('698001','adidas predator nego-blanco botin',0,4,1600,'','numero 6 viene amplio',0,''),('698007','adidas predator blanco botin',0,4,1600,'','numero 8 viene amplio',0,''),('698181','nike morado negro',0,6,1000,'','numero 8',0,''),('719912-602','nike airmax naranja-azul',0,6,1300,'','numero 9.5',0,''),('721356','vanz negro-blanco',0,12,600,'','numero 20',0,''),('721356-','vanz negro-colores',0,12,700,'','numero 7.5',0,''),('724382','nike negro-naranja',0,6,1200,'','numero 8',0,''),('747486','nike rapido negro',0,4,1600,'','numero 5',0,''),('747966','nike negro-rosa',0,6,800,'','numero 5',0,''),('749361','nike rosa-gris',0,6,1000,'','numero 8',0,''),('749891','nike naranja-morado',0,4,800,'','numero 8',0,''),('789006','adidas blanco-negro',0,9,1200,'','numero 6',0,''),('818952','nike kobe bryan negro-rosa',0,5,1200,'','numero 7\n',0,''),('819167-601','nike rosa-negro',0,6,900,'','numero 5',0,''),('819316','nike negro-verde',0,6,1000,'','numero 8',0,''),('831408-601','nike rosa-morado',0,6,900,'','talla 5',0,''),('831943','nike rapido negro-rosa botin',0,3,1250,'','numero 3.5',0,''),('831976','futbol rapido nike morado',0,4,1600,'','numero 10',0,''),('833412','nike airmaxazul-blanco',0,6,1000,'','numero 4',0,''),('843957','rapido nike naranja botin',0,4,1500,'','numero 8.5 mexicano',0,''),('843957-805','nike rapido naranja',0,6,1500,'','numero 8.5',0,''),('844378','lebron camuflajeado',0,5,2000,'','numero 7.5',0,''),('844408','nike verde fosforecente',0,4,800,'','numero 8',0,''),('844595','chute nike negro-naranja botin magista',0,3,1500,'','numero 8',0,''),('844595-008','nike magista negro-naranja botin',0,3,1500,'','numero 4',0,''),('852554','chute nike amarillo-negro',0,3,1500,'','numero 7',0,''),('852577','nike negro-plata botin ',0,4,1600,'','numero 8',0,''),('852601','nike negro-plata',0,4,1400,'','numero 3.5',0,''),('875943-200','nike air max verde',0,6,1400,'','numero8.5',0,''),('882087','chute nike verde-naranja',0,3,1500,'','numero 4',0,''),('897644-005','nike lebron james soldier',0,5,2300,'','numero 10',0,''),('897644-005-','nike lebron james negro-azul',0,5,2300,'','numero 9',0,''),('897644-200','nike lebron camuflaje',0,5,2300,'','numero 9',0,''),('903592','nike cr7 gris-verde botin',0,3,1250,'','numero 3',0,''),('903599','nike amarillo rallas',0,4,1250,'','numero 4',0,''),('903600','chute nike amarillo botin',0,3,1200,'','numero 4',0,''),('917742-004','nike jaeson keed negro',0,4,2000,'','numero 9',0,''),('917742-004-','nike jason keed negro',0,1,0,'','numero 8',0,''),('917769','rapido botin negro-amarillo',0,4,1600,'','numero 8',0,''),('97530L','sketshers azul-naranja',0,10,650,'','numero18 ',0,''),('AA1282','Jordan negro-rojo',0,6,2000,'','numero 9 mexicano',0,'');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productos_para_venta`
--

DROP TABLE IF EXISTS `productos_para_venta`;
/*!50001 DROP VIEW IF EXISTS `productos_para_venta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `productos_para_venta` AS SELECT 
 1 AS `CLAVE`,
 1 AS `NOMBRE`,
 1 AS `PRECIO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `reporte_compras`
--

DROP TABLE IF EXISTS `reporte_compras`;
/*!50001 DROP VIEW IF EXISTS `reporte_compras`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `reporte_compras` AS SELECT 
 1 AS `FOLIO`,
 1 AS `FOLIO_EGRESO`,
 1 AS `USUARIO`,
 1 AS `FECHA`,
 1 AS `TOTAL`,
 1 AS `CANCELADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `reporte_consultas`
--

DROP TABLE IF EXISTS `reporte_consultas`;
/*!50001 DROP VIEW IF EXISTS `reporte_consultas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `reporte_consultas` AS SELECT 
 1 AS `ID`,
 1 AS `FECHA`,
 1 AS `NOMBRE`,
 1 AS `USUARIO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `reporte_egresos`
--

DROP TABLE IF EXISTS `reporte_egresos`;
/*!50001 DROP VIEW IF EXISTS `reporte_egresos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `reporte_egresos` AS SELECT 
 1 AS `FOLIO`,
 1 AS `MONTO`,
 1 AS `FECHA`,
 1 AS `USUARIO`,
 1 AS `DETALLES`,
 1 AS `TIPO`,
 1 AS `CANCELADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `reporte_ingresos`
--

DROP TABLE IF EXISTS `reporte_ingresos`;
/*!50001 DROP VIEW IF EXISTS `reporte_ingresos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `reporte_ingresos` AS SELECT 
 1 AS `FOLIO`,
 1 AS `MONTO`,
 1 AS `FECHA`,
 1 AS `USUARIO`,
 1 AS `DETALLES`,
 1 AS `TIPO`,
 1 AS `CANCELADO`,
 1 AS `FOLIO_APARTADO`,
 1 AS `FOLIO_VENTA`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `reporte_venta`
--

DROP TABLE IF EXISTS `reporte_venta`;
/*!50001 DROP VIEW IF EXISTS `reporte_venta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `reporte_venta` AS SELECT 
 1 AS `FOLIO`,
 1 AS `FECHA`,
 1 AS `USUARIO`,
 1 AS `CLIENTE`,
 1 AS `FORMA_PAGO`,
 1 AS `TOTAL`,
 1 AS `CANCELADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `suma_egresos`
--

DROP TABLE IF EXISTS `suma_egresos`;
/*!50001 DROP VIEW IF EXISTS `suma_egresos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `suma_egresos` AS SELECT 
 1 AS `FECHA`,
 1 AS `MONTO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `suma_ingresos`
--

DROP TABLE IF EXISTS `suma_ingresos`;
/*!50001 DROP VIEW IF EXISTS `suma_ingresos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `suma_ingresos` AS SELECT 
 1 AS `FECHA`,
 1 AS `MONTO`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tipos_egresos`
--

DROP TABLE IF EXISTS `tipos_egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_egresos` (
  `TIPO` varchar(50) NOT NULL,
  PRIMARY KEY (`TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_egresos`
--

LOCK TABLES `tipos_egresos` WRITE;
/*!40000 ALTER TABLE `tipos_egresos` DISABLE KEYS */;
INSERT INTO `tipos_egresos` VALUES ('Compra de mercancia'),('Proveedor'),('Servicios');
/*!40000 ALTER TABLE `tipos_egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_ingresos`
--

DROP TABLE IF EXISTS `tipos_ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_ingresos` (
  `TIPO` varchar(50) NOT NULL,
  PRIMARY KEY (`TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_ingresos`
--

LOCK TABLES `tipos_ingresos` WRITE;
/*!40000 ALTER TABLE `tipos_ingresos` DISABLE KEYS */;
INSERT INTO `tipos_ingresos` VALUES ('Abono'),('Pago de contado'),('Recarga');
/*!40000 ALTER TABLE `tipos_ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(127) NOT NULL,
  `CONTRASENIA` varchar(511) NOT NULL,
  `ID_NIVEL` int(11) NOT NULL,
  `ACTIVO` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOMBRE` (`NOMBRE`),
  KEY `ID_NIVEL` (`ID_NIVEL`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_NIVEL`) REFERENCES `niveles_usuario` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Fenixoft','$2a$10$AitzRhvWtVIfcVagoHj8x.Ov.GrSpJ48U9pWF3bRMJobDpVvEdTOK',0,1),(2,'Admin','$2a$10$iVBRIjSjRoNfxUaowyMh.u2Yg4lW2HoPM3ryacKmRzXdT1OuxYDh6',1,1),(3,'diana','$2a$10$zDt8AMEINzg9cU6edRKInO.3JDzJC9ZSv73gz7/a2mgKQIyOFJuD6',2,1),(4,'abril','$2a$10$EvYDkKaqa.P1ZDJmO6MVpuCabl0KyFIYKF0rWC8FjtiE24Gvu0xQi',2,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `FOLIO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ID_USUARIO` int(11) NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `FORMA_PAGO` varchar(30) NOT NULL,
  `CANCELADO` tinyint(1) NOT NULL DEFAULT '0',
  `TOTAL` float NOT NULL,
  PRIMARY KEY (`FOLIO`),
  KEY `ID_CLIENTE` (`ID_CLIENTE`),
  KEY `ID_USUARIO` (`ID_USUARIO`),
  KEY `FORMA_PAGO` (`FORMA_PAGO`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `clientes` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID`) ON UPDATE CASCADE,
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`FORMA_PAGO`) REFERENCES `formas_de_pago` (`NOMBRE`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'2018-02-24 18:07:31',2,1,'Cancelado',1,3200),(2,'2018-03-03 09:13:48',2,1,'Cancelado',1,1600),(3,'2018-03-03 09:18:22',2,3,'Apartado',0,1200),(4,'2018-03-03 09:18:39',2,4,'Apartado',0,0),(5,'2018-03-03 09:20:03',2,3,'Apartado',0,0),(6,'2018-03-03 09:20:13',2,6,'Apartado',0,0),(7,'2018-03-03 10:17:25',2,1,'Cancelado',1,1200),(8,'2018-03-03 11:34:27',2,1,'Efectivo',0,2300),(9,'2018-03-05 11:03:41',2,1,'Cancelado',1,1000),(10,'2018-03-05 11:22:45',2,6,'Apartado',0,2300),(11,'2018-03-05 11:33:24',2,7,'Apartado',0,1300),(12,'2018-03-05 11:40:12',2,8,'Apartado',0,1500),(13,'2018-03-05 11:44:48',2,9,'Apartado',0,1000),(14,'2018-03-06 09:03:47',4,1,'Cancelado',1,800),(15,'2018-03-06 09:06:22',4,9,'Apartado',0,0),(16,'2018-03-06 11:29:21',4,1,'Apartado',0,0),(17,'2018-03-06 11:30:49',4,10,'Apartado',0,0),(18,'2018-03-06 11:32:58',4,10,'Apartado',0,0),(19,'2018-03-06 12:50:43',2,10,'Apartado',0,900),(20,'2018-03-06 12:56:14',2,2,'Apartado',0,1600),(21,'2018-03-06 18:49:15',4,11,'Apartado',0,0),(22,'2018-03-06 18:51:41',4,11,'Apartado',0,1000),(23,'2018-03-07 15:33:40',2,1,'Cancelado',1,1100),(24,'2018-03-08 12:18:44',4,12,'Apartado',0,2000),(25,'2018-03-08 12:18:45',4,1,'Pendiente',0,0);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas_pendientes`
--

DROP TABLE IF EXISTS `ventas_pendientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas_pendientes` (
  `FOLIO_VENTA` int(11) NOT NULL,
  PRIMARY KEY (`FOLIO_VENTA`),
  CONSTRAINT `ventas_pendientes_ibfk_1` FOREIGN KEY (`FOLIO_VENTA`) REFERENCES `ventas` (`FOLIO`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_pendientes`
--

LOCK TABLES `ventas_pendientes` WRITE;
/*!40000 ALTER TABLE `ventas_pendientes` DISABLE KEYS */;
INSERT INTO `ventas_pendientes` VALUES (25);
/*!40000 ALTER TABLE `ventas_pendientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas_productos`
--

DROP TABLE IF EXISTS `ventas_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas_productos` (
  `ID_ASIGNACION` int(11) NOT NULL AUTO_INCREMENT,
  `FOLIO_VENTA` int(11) NOT NULL,
  `CLAVE_PRODUCTO` varchar(15) NOT NULL,
  `PRECIO` float NOT NULL,
  PRIMARY KEY (`ID_ASIGNACION`),
  KEY `FOLIO_VENTA` (`FOLIO_VENTA`),
  KEY `CLAVE_PRODUCTO` (`CLAVE_PRODUCTO`),
  CONSTRAINT `ventas_productos_ibfk_1` FOREIGN KEY (`FOLIO_VENTA`) REFERENCES `ventas` (`FOLIO`) ON UPDATE CASCADE,
  CONSTRAINT `ventas_productos_ibfk_2` FOREIGN KEY (`CLAVE_PRODUCTO`) REFERENCES `productos` (`CLAVE`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_productos`
--

LOCK TABLES `ventas_productos` WRITE;
/*!40000 ALTER TABLE `ventas_productos` DISABLE KEYS */;
INSERT INTO `ventas_productos` VALUES (1,1,'747486',1600),(2,1,'747486',1600),(3,2,'747486',1600),(4,3,'1264221-669',1200),(5,7,'1264221-669',1200),(6,8,'897644-005',2300),(7,9,'1259034-410',1000),(8,10,'897644-200',2300),(9,11,'719912-602',1300),(10,12,'843957-805',1500),(11,13,'1247997',1000),(12,14,'749891',800),(13,19,'831408-601',900),(14,20,'118727479',1600),(15,22,'1259034',1000),(16,23,'4501275287',1100),(17,24,'917742-004',2000);
/*!40000 ALTER TABLE `ventas_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `abonos_apartados`
--

/*!50001 DROP VIEW IF EXISTS `abonos_apartados`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `abonos_apartados` AS select `abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`abonos`.`FOLIO_TICKET` AS `FOLIO_TICKET`,`ingresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`ingresos`.`MONTO` AS `MONTO`,`ingresos`.`CANCELADO` AS `CANCELADO` from (((`abonos` join `apartados`) join `ingresos`) join `usuarios` on(((`ingresos`.`FOLIO` = `abonos`.`FOLIO_TICKET`) and (`usuarios`.`ID` = `ingresos`.`ID_USUARIO`) and (`apartados`.`FOLIO` = `abonos`.`FOLIO_APARTADO`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `apartados_por_cliente`
--

/*!50001 DROP VIEW IF EXISTS `apartados_por_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `apartados_por_cliente` AS select `clientes`.`ID` AS `ID_CLIENTE`,`apartados`.`FOLIO` AS `FOLIO`,`ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`productos`.`CLAVE` AS `CLAVE_PRODUCTO`,`productos`.`NOMBRE` AS `NOMBRE`,`ventas_productos`.`PRECIO` AS `PRECIO`,`apartados`.`SALDO_PENDIENTE` AS `SALDO_PENDIENTE`,`apartados`.`CANCELADO` AS `CANCELADO`,`apartados`.`ENTREGADO` AS `ENTREGADO` from (((`apartados` join `ventas_productos`) join `clientes`) join `productos` on(((`apartados`.`ID_ASIGNACION` = `ventas_productos`.`ID_ASIGNACION`) and (`ventas_productos`.`CLAVE_PRODUCTO` = `productos`.`CLAVE`) and (`apartados`.`ID_CLIENTE` = `clientes`.`ID`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `buscar_por_subfolio`
--

/*!50001 DROP VIEW IF EXISTS `buscar_por_subfolio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `buscar_por_subfolio` AS select `apartados`.`ID_CLIENTE` AS `ID_CLIENTE`,`apartados`.`ID_ASIGNACION` AS `SUBFOLIO`,`apartados`.`FOLIO` AS `FOLIO` from `apartados` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `clientes_con_formato`
--

/*!50001 DROP VIEW IF EXISTS `clientes_con_formato`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_con_formato` AS select `clientes`.`ID` AS `ID`,concat(`clientes`.`NOMBRE`,' ',`clientes`.`APELLIDO_PATERNO`,' ',`clientes`.`APELLIDO_MATERNO`) AS `NOMBRE`,`clientes`.`TELEFONO1` AS `TELEFONO1`,`clientes`.`TELEFONO2` AS `TELEFONO2` from `clientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `compra_detalle`
--

/*!50001 DROP VIEW IF EXISTS `compra_detalle`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `compra_detalle` AS select `compras_productos`.`FOLIO_COMPRA` AS `FOLIO_COMPRA`,`productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`compras_productos`.`CANTIDAD` AS `CANTIDAD`,`compras_productos`.`PRECIO_UNITARIO` AS `PRECIO_UNITARIO`,(`compras_productos`.`CANTIDAD` * `compras_productos`.`PRECIO_UNITARIO`) AS `PRECIO_TOTAL` from (`compras_productos` join `productos` on((`compras_productos`.`CLAVE_PRODUCTO` = `productos`.`CLAVE`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `consulta_producto`
--

/*!50001 DROP VIEW IF EXISTS `consulta_producto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `consulta_producto` AS select `productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`categorias`.`NOMBRE` AS `CATEGORIA`,`productos`.`PRECIO` AS `PRECIO`,`productos`.`EXISTENCIA` AS `EXISTENCIA`,`productos`.`IMAGEN` AS `IMAGEN` from (`productos` join `categorias` on((`productos`.`ID_CATEGORIA` = `categorias`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `corte_caja`
--

/*!50001 DROP VIEW IF EXISTS `corte_caja`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `corte_caja` AS select `tienda_de_ropa`.`aperturas_de_caja`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`aperturas_de_caja`.`MONTO` AS `APERTURA`,if(isnull(`ingresos`.`MONTO`),0,`ingresos`.`MONTO`) AS `INGRESOS`,if(isnull(`egresos`.`MONTO`),0,`egresos`.`MONTO`) AS `EGRESOS`,((`tienda_de_ropa`.`aperturas_de_caja`.`MONTO` + if(isnull(`ingresos`.`MONTO`),0,`ingresos`.`MONTO`)) - if(isnull(`egresos`.`MONTO`),0,`egresos`.`MONTO`)) AS `CIERRE` from ((`tienda_de_ropa`.`aperturas_de_caja` left join (select `tienda_de_ropa`.`ingresos`.`FECHA` AS `FECHA`,sum(`tienda_de_ropa`.`ingresos`.`MONTO`) AS `MONTO` from `tienda_de_ropa`.`ingresos` where (`tienda_de_ropa`.`ingresos`.`CANCELADO` = FALSE) group by cast(`tienda_de_ropa`.`ingresos`.`FECHA` as date)) `ingresos` on((`tienda_de_ropa`.`aperturas_de_caja`.`FECHA` = cast(`ingresos`.`FECHA` as date)))) left join (select `tienda_de_ropa`.`egresos`.`FECHA` AS `FECHA`,sum(`tienda_de_ropa`.`egresos`.`MONTO`) AS `MONTO` from `tienda_de_ropa`.`egresos` where (`tienda_de_ropa`.`egresos`.`CANCELADO` = FALSE) group by cast(`tienda_de_ropa`.`egresos`.`FECHA` as date)) `egresos` on((cast(`ingresos`.`FECHA` as date) = cast(`egresos`.`FECHA` as date)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `detalle_venta`
--

/*!50001 DROP VIEW IF EXISTS `detalle_venta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detalle_venta` AS select `ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`ventas_productos`.`ID_ASIGNACION` AS `ASIGNACION`,`productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`ventas_productos`.`PRECIO` AS `PRECIO` from (`ventas_productos` join `productos` on((`ventas_productos`.`CLAVE_PRODUCTO` = `productos`.`CLAVE`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `detalles_productos`
--

/*!50001 DROP VIEW IF EXISTS `detalles_productos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detalles_productos` AS select `productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`productos`.`NUEVO` AS `NUEVO`,`categorias`.`NOMBRE` AS `CATEGORIA`,`productos`.`PRECIO` AS `PRECIO`,`productos`.`DETALLES` AS `DETALLES`,`productos`.`IMAGEN` AS `IMAGEN` from (`productos` join `categorias` on((`productos`.`ID_CATEGORIA` = `categorias`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `detalles_ventas_pendientes`
--

/*!50001 DROP VIEW IF EXISTS `detalles_ventas_pendientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detalles_ventas_pendientes` AS select `ventas_pendientes`.`FOLIO_VENTA` AS `FOLIO`,`nombre_cliente`.`ID` AS `ID_CLIENTE`,`nombre_cliente`.`NOMBRE` AS `CLIENTE` from ((`ventas_pendientes` join `ventas` on((`ventas_pendientes`.`FOLIO_VENTA` = `ventas`.`FOLIO`))) join `nombre_cliente` on((`nombre_cliente`.`ID` = `ventas`.`ID_CLIENTE`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `inventario`
--

/*!50001 DROP VIEW IF EXISTS `inventario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inventario` AS select `productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`productos`.`NUEVO` AS `NUEVO`,`categorias`.`NOMBRE` AS `CATEGORIA`,`productos`.`EXISTENCIA` AS `EXISTENCIA` from (`productos` join `categorias` on((`productos`.`ID_CATEGORIA` = `categorias`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nivel_de_usuario`
--

/*!50001 DROP VIEW IF EXISTS `nivel_de_usuario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nivel_de_usuario` AS select `usuarios`.`ID` AS `ID_USUARIO`,`usuarios`.`NOMBRE` AS `NOMBRE`,`niveles_usuario`.`ID` AS `ID_NIVEL`,`niveles_usuario`.`NOMBRE` AS `NIVEL` from (`usuarios` join `niveles_usuario` on((`usuarios`.`ID_NIVEL` = `niveles_usuario`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nombre_cliente`
--

/*!50001 DROP VIEW IF EXISTS `nombre_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nombre_cliente` AS select `clientes`.`ID` AS `ID`,concat(`clientes`.`NOMBRE`,' ',`clientes`.`APELLIDO_PATERNO`,' ',`clientes`.`APELLIDO_MATERNO`) AS `NOMBRE` from `clientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos_para_venta`
--

/*!50001 DROP VIEW IF EXISTS `productos_para_venta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos_para_venta` AS select `productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`productos`.`PRECIO` AS `PRECIO` from `productos` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reporte_compras`
--

/*!50001 DROP VIEW IF EXISTS `reporte_compras`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reporte_compras` AS select `compras`.`FOLIO` AS `FOLIO`,`compras`.`FOLIO_EGRESO` AS `FOLIO_EGRESO`,`usuarios`.`NOMBRE` AS `USUARIO`,`egresos`.`FECHA` AS `FECHA`,`egresos`.`MONTO` AS `TOTAL`,`compras`.`CANCELADO` AS `CANCELADO` from ((`compras` join `egresos`) join `usuarios` on(((`compras`.`FOLIO_EGRESO` = `egresos`.`FOLIO`) and (`egresos`.`ID_USUARIO` = `usuarios`.`ID`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reporte_consultas`
--

/*!50001 DROP VIEW IF EXISTS `reporte_consultas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reporte_consultas` AS select `consultas`.`ID` AS `ID`,`consultas`.`FECHA` AS `FECHA`,`productos`.`NOMBRE` AS `NOMBRE`,`usuarios`.`NOMBRE` AS `USUARIO` from ((`consultas` join `productos` on((`productos`.`CLAVE` = `consultas`.`CLAVE_PRODUCTO`))) join `usuarios` on((`usuarios`.`ID` = `consultas`.`ID_USUARIO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reporte_egresos`
--

/*!50001 DROP VIEW IF EXISTS `reporte_egresos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reporte_egresos` AS select `egresos`.`FOLIO` AS `FOLIO`,`egresos`.`MONTO` AS `MONTO`,`egresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`egresos`.`DETALLES` AS `DETALLES`,`egresos`.`TIPO` AS `TIPO`,`egresos`.`CANCELADO` AS `CANCELADO` from (`egresos` join `usuarios` on((`egresos`.`ID_USUARIO` = `usuarios`.`ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reporte_ingresos`
--

/*!50001 DROP VIEW IF EXISTS `reporte_ingresos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reporte_ingresos` AS select `ingresos`.`FOLIO` AS `FOLIO`,`ingresos`.`MONTO` AS `MONTO`,`ingresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`ingresos`.`DETALLES` AS `DETALLES`,`ingresos`.`TIPO` AS `TIPO`,`ingresos`.`CANCELADO` AS `CANCELADO`,`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`pagos_de_contado`.`FOLIO_VENTA` AS `FOLIO_VENTA` from (((`ingresos` join `usuarios` on((`ingresos`.`ID_USUARIO` = `usuarios`.`ID`))) left join `abonos` on((`abonos`.`FOLIO_TICKET` = `ingresos`.`FOLIO`))) left join `pagos_de_contado` on((`ingresos`.`FOLIO` = `pagos_de_contado`.`FOLIO_INGRESO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `reporte_venta`
--

/*!50001 DROP VIEW IF EXISTS `reporte_venta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reporte_venta` AS select `ventas`.`FOLIO` AS `FOLIO`,`ventas`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`nombre_cliente`.`NOMBRE` AS `CLIENTE`,`ventas`.`FORMA_PAGO` AS `FORMA_PAGO`,`ventas`.`TOTAL` AS `TOTAL`,`ventas`.`CANCELADO` AS `CANCELADO` from (((`ventas` left join `ventas_pendientes` on((`ventas`.`FOLIO` = `ventas_pendientes`.`FOLIO_VENTA`))) join `usuarios` on((`ventas`.`ID_USUARIO` = `usuarios`.`ID`))) join `nombre_cliente` on((`nombre_cliente`.`ID` = `ventas`.`ID_CLIENTE`))) where isnull(`ventas_pendientes`.`FOLIO_VENTA`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `suma_egresos`
--

/*!50001 DROP VIEW IF EXISTS `suma_egresos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `suma_egresos` AS select `egresos`.`FECHA` AS `FECHA`,sum(`egresos`.`MONTO`) AS `MONTO` from `egresos` group by `egresos`.`FECHA` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `suma_ingresos`
--

/*!50001 DROP VIEW IF EXISTS `suma_ingresos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `suma_ingresos` AS select `ingresos`.`FECHA` AS `FECHA`,sum(`ingresos`.`MONTO`) AS `MONTO` from `ingresos` group by `ingresos`.`FECHA` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-09 12:28:57
