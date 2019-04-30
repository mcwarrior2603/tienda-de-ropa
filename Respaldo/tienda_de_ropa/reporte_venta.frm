TYPE=VIEW
query=select `tienda_de_ropa`.`ventas`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ventas`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`nombre_cliente`.`NOMBRE` AS `CLIENTE`,`tienda_de_ropa`.`ventas`.`FORMA_PAGO` AS `FORMA_PAGO`,`tienda_de_ropa`.`ventas`.`TOTAL` AS `TOTAL`,`tienda_de_ropa`.`ventas`.`CANCELADO` AS `CANCELADO` from (((`tienda_de_ropa`.`ventas` left join `tienda_de_ropa`.`ventas_pendientes` on((`tienda_de_ropa`.`ventas`.`FOLIO` = `tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA`))) join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`ventas`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))) join `tienda_de_ropa`.`nombre_cliente` on((`nombre_cliente`.`ID` = `tienda_de_ropa`.`ventas`.`ID_CLIENTE`))) where isnull(`tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA`)
md5=98c38ca7edf86f19124465ad890f86bb
updatable=0
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:34
create-version=1
source=select `ventas`.`FOLIO` AS `FOLIO`,`ventas`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`nombre_cliente`.`NOMBRE` AS `CLIENTE`,`ventas`.`FORMA_PAGO` AS `FORMA_PAGO`,`ventas`.`TOTAL` AS `TOTAL`,`ventas`.`CANCELADO` AS `CANCELADO` from (((`ventas` left join `ventas_pendientes` on((`ventas`.`FOLIO` = `ventas_pendientes`.`FOLIO_VENTA`))) join `usuarios` on((`ventas`.`ID_USUARIO` = `usuarios`.`ID`))) join `nombre_cliente` on((`nombre_cliente`.`ID` = `ventas`.`ID_CLIENTE`))) where isnull(`ventas_pendientes`.`FOLIO_VENTA`)
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`ventas`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ventas`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`nombre_cliente`.`NOMBRE` AS `CLIENTE`,`tienda_de_ropa`.`ventas`.`FORMA_PAGO` AS `FORMA_PAGO`,`tienda_de_ropa`.`ventas`.`TOTAL` AS `TOTAL`,`tienda_de_ropa`.`ventas`.`CANCELADO` AS `CANCELADO` from (((`tienda_de_ropa`.`ventas` left join `tienda_de_ropa`.`ventas_pendientes` on((`tienda_de_ropa`.`ventas`.`FOLIO` = `tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA`))) join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`ventas`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))) join `tienda_de_ropa`.`nombre_cliente` on((`nombre_cliente`.`ID` = `tienda_de_ropa`.`ventas`.`ID_CLIENTE`))) where isnull(`tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA`)
