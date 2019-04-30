TYPE=VIEW
query=select `tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`productos`.`NUEVO` AS `NUEVO`,`tienda_de_ropa`.`categorias`.`NOMBRE` AS `CATEGORIA`,`tienda_de_ropa`.`productos`.`EXISTENCIA` AS `EXISTENCIA` from (`tienda_de_ropa`.`productos` join `tienda_de_ropa`.`categorias` on((`tienda_de_ropa`.`productos`.`ID_CATEGORIA` = `tienda_de_ropa`.`categorias`.`ID`)))
md5=46170105bdc801d4582221a8b870987c
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:33
create-version=1
source=select `productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`productos`.`NUEVO` AS `NUEVO`,`categorias`.`NOMBRE` AS `CATEGORIA`,`productos`.`EXISTENCIA` AS `EXISTENCIA` from (`productos` join `categorias` on((`productos`.`ID_CATEGORIA` = `categorias`.`ID`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`productos`.`NUEVO` AS `NUEVO`,`tienda_de_ropa`.`categorias`.`NOMBRE` AS `CATEGORIA`,`tienda_de_ropa`.`productos`.`EXISTENCIA` AS `EXISTENCIA` from (`tienda_de_ropa`.`productos` join `tienda_de_ropa`.`categorias` on((`tienda_de_ropa`.`productos`.`ID_CATEGORIA` = `tienda_de_ropa`.`categorias`.`ID`)))
