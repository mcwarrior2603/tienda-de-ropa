TYPE=VIEW
query=select `tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos`) join `tienda_de_ropa`.`productos` on(((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`))))
md5=8f3b7db40bb9fae112617412fb71d180
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2018-05-15 23:21:55
create-version=1
source=SELECT \n	APARTADOS.FOLIO,\n	PRODUCTOS.NOMBRE,\n	VENTAS_PRODUCTOS.PRECIO\n	FROM APARTADOS JOIN APARTADOS_ASIGNACIONES JOIN VENTAS_PRODUCTOS JOIN PRODUCTOS\n	ON APARTADOS.FOLIO = APARTADOS_ASIGNACIONES.FOLIO_APARTADO AND APARTADOS_ASIGNACIONES.ID_ASIGNACION = VENTAS_PRODUCTOS.ID_ASIGNACION\n		AND VENTAS_PRODUCTOS.CLAVE_PRODUCTO = PRODUCTOS.CLAVE
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos`) join `tienda_de_ropa`.`productos` on(((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`))))
