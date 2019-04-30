TYPE=VIEW
query=select `tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA` AS `FOLIO`,`nombre_cliente`.`ID` AS `ID_CLIENTE`,`nombre_cliente`.`NOMBRE` AS `CLIENTE` from ((`tienda_de_ropa`.`ventas_pendientes` join `tienda_de_ropa`.`ventas` on((`tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA` = `tienda_de_ropa`.`ventas`.`FOLIO`))) join `tienda_de_ropa`.`nombre_cliente` on((`nombre_cliente`.`ID` = `tienda_de_ropa`.`ventas`.`ID_CLIENTE`)))
md5=504a15c018b23289e65094c23df6a32a
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:33
create-version=1
source=select `ventas_pendientes`.`FOLIO_VENTA` AS `FOLIO`,`nombre_cliente`.`ID` AS `ID_CLIENTE`,`nombre_cliente`.`NOMBRE` AS `CLIENTE` from ((`ventas_pendientes` join `ventas` on((`ventas_pendientes`.`FOLIO_VENTA` = `ventas`.`FOLIO`))) join `nombre_cliente` on((`nombre_cliente`.`ID` = `ventas`.`ID_CLIENTE`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA` AS `FOLIO`,`nombre_cliente`.`ID` AS `ID_CLIENTE`,`nombre_cliente`.`NOMBRE` AS `CLIENTE` from ((`tienda_de_ropa`.`ventas_pendientes` join `tienda_de_ropa`.`ventas` on((`tienda_de_ropa`.`ventas_pendientes`.`FOLIO_VENTA` = `tienda_de_ropa`.`ventas`.`FOLIO`))) join `tienda_de_ropa`.`nombre_cliente` on((`nombre_cliente`.`ID` = `tienda_de_ropa`.`ventas`.`ID_CLIENTE`)))
