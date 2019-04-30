TYPE=VIEW
query=select `tienda_de_ropa`.`compras`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`compras`.`FOLIO_EGRESO` AS `FOLIO_EGRESO`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`egresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`egresos`.`MONTO` AS `TOTAL`,`tienda_de_ropa`.`compras`.`CANCELADO` AS `CANCELADO` from ((`tienda_de_ropa`.`compras` join `tienda_de_ropa`.`egresos`) join `tienda_de_ropa`.`usuarios` on(((`tienda_de_ropa`.`compras`.`FOLIO_EGRESO` = `tienda_de_ropa`.`egresos`.`FOLIO`) and (`tienda_de_ropa`.`egresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))))
md5=68aab0202bccc583be7a784bdeb77d16
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-05-08 14:52:54
create-version=1
source=select `compras`.`FOLIO` AS `FOLIO`,`compras`.`FOLIO_EGRESO` AS `FOLIO_EGRESO`,`usuarios`.`NOMBRE` AS `USUARIO`,`egresos`.`FECHA` AS `FECHA`,`egresos`.`MONTO` AS `TOTAL`,`compras`.`CANCELADO` AS `CANCELADO` from ((`compras` join `egresos`) join `usuarios` on(((`compras`.`FOLIO_EGRESO` = `egresos`.`FOLIO`) and (`egresos`.`ID_USUARIO` = `usuarios`.`ID`))))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`compras`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`compras`.`FOLIO_EGRESO` AS `FOLIO_EGRESO`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`egresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`egresos`.`MONTO` AS `TOTAL`,`tienda_de_ropa`.`compras`.`CANCELADO` AS `CANCELADO` from ((`tienda_de_ropa`.`compras` join `tienda_de_ropa`.`egresos`) join `tienda_de_ropa`.`usuarios` on(((`tienda_de_ropa`.`compras`.`FOLIO_EGRESO` = `tienda_de_ropa`.`egresos`.`FOLIO`) and (`tienda_de_ropa`.`egresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))))
