TYPE=VIEW
query=select `tienda_de_ropa`.`clientes`.`ID` AS `ID_CLIENTE`,`tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`tienda_de_ropa`.`apartados`.`TOTAL` AS `TOTAL`,`tienda_de_ropa`.`apartados`.`SALDO_PENDIENTE` AS `SALDO_PENDIENTE`,`tienda_de_ropa`.`apartados`.`CANCELADO` AS `CANCELADO`,`tienda_de_ropa`.`apartados`.`ENTREGADO` AS `ENTREGADO` from ((((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`clientes`) join `tienda_de_ropa`.`ventas`) join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos` on(((`tienda_de_ropa`.`clientes`.`ID` = `tienda_de_ropa`.`apartados`.`ID_CLIENTE`) and (`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas`.`FOLIO` = `tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA`)))) group by `tienda_de_ropa`.`apartados`.`FOLIO`
md5=1578724ca8a741562072b00fc7761931
updatable=0
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2018-05-15 23:20:52
create-version=1
source=SELECT \n	CLIENTES.ID AS ID_CLIENTE, \n	APARTADOS.FOLIO, \n	FOLIO_VENTA, 		\n	APARTADOS.TOTAL,\n	APARTADOS.SALDO_PENDIENTE, \n	APARTADOS.CANCELADO AS CANCELADO,\n	APARTADOS.ENTREGADO AS ENTREGADO\nFROM APARTADOS JOIN CLIENTES JOIN VENTAS JOIN APARTADOS_ASIGNACIONES JOIN VENTAS_PRODUCTOS \nON CLIENTES.ID=APARTADOS.ID_CLIENTE AND APARTADOS.FOLIO=APARTADOS_ASIGNACIONES.FOLIO_APARTADO \n	AND APARTADOS_ASIGNACIONES.ID_ASIGNACION=VENTAS_PRODUCTOS.ID_ASIGNACION AND VENTAS.FOLIO=VENTAS_PRODUCTOS.FOLIO_VENTA\nGROUP BY APARTADOS.FOLIO
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`clientes`.`ID` AS `ID_CLIENTE`,`tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA` AS `FOLIO_VENTA`,`tienda_de_ropa`.`apartados`.`TOTAL` AS `TOTAL`,`tienda_de_ropa`.`apartados`.`SALDO_PENDIENTE` AS `SALDO_PENDIENTE`,`tienda_de_ropa`.`apartados`.`CANCELADO` AS `CANCELADO`,`tienda_de_ropa`.`apartados`.`ENTREGADO` AS `ENTREGADO` from ((((`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`clientes`) join `tienda_de_ropa`.`ventas`) join `tienda_de_ropa`.`apartados_asignaciones`) join `tienda_de_ropa`.`ventas_productos` on(((`tienda_de_ropa`.`clientes`.`ID` = `tienda_de_ropa`.`apartados`.`ID_CLIENTE`) and (`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`) and (`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` = `tienda_de_ropa`.`ventas_productos`.`ID_ASIGNACION`) and (`tienda_de_ropa`.`ventas`.`FOLIO` = `tienda_de_ropa`.`ventas_productos`.`FOLIO_VENTA`)))) group by `tienda_de_ropa`.`apartados`.`FOLIO`
