TYPE=VIEW
query=select `tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos`) join `tienda_de_ropa`.`productos` on(((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`))))
md5=227007787fc670e641ce13dd76ff46b2
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2018-05-10 14:27:05
create-version=1
source=SELECT \nAPARTADOS.FOLIO AS FOLIO_APARTADO,\nPRODUCTOS.NOMBRE,\nVENTAS_PRODUCTOS.PRECIO\nFROM APARTADOS JOIN APARTADOS_ASIGNACIONES JOIN VENTAS_PRODUCTOS JOIN PRODUCTOS\nON APARTADOS.FOLIO = APARTADOS_ASIGNACIONES.FOLIO_APARTADO AND APARTADOS_ASIGNACIONES.ID_ASIGNACION = VENTAS_PRODUCTOS.ID_ASIGNACION\nAND VENTAS_PRODUCTOS.CLAVE_PRODUCTO = PRODUCTOS.CLAVE
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos`) join `tienda_de_ropa`.`productos` on(((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`))))
