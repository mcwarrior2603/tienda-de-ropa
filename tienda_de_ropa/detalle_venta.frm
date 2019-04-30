TYPE=VIEW
query=select `tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION` AS `ASIGNACION`,`tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (`tienda_de_ropa`.`ventas_productos` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`)))
md5=708806fa0692ba02e9bffd7fb626144a
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-05-08 14:52:54
create-version=1
source=select `ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`ventas_productos`.`ID_ASIGNACION` AS `ASIGNACION`,`productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`ventas_productos`.`PRECIO` AS `PRECIO` from (`ventas_productos` join `productos` on((`ventas_productos`.`CLAVE_PRODUCTO` = `productos`.`CLAVE`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION` AS `ASIGNACION`,`tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`ventas_productos`.`PRECIO` AS `PRECIO` from (`tienda_de_ropa`.`ventas_productos` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`ventas_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`)))
