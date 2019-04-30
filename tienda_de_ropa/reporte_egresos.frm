TYPE=VIEW
query=select `tienda_de_ropa`.`egresos`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`egresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`egresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`egresos`.`DETALLES` AS `DETALLES`,`tienda_de_ropa`.`egresos`.`TIPO` AS `TIPO`,`tienda_de_ropa`.`egresos`.`CANCELADO` AS `CANCELADO` from (`tienda_de_ropa`.`egresos` join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`egresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`)))
md5=815448010d0e6525149ad87c6ca7a490
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-05-08 14:52:54
create-version=1
source=select `egresos`.`FOLIO` AS `FOLIO`,`egresos`.`MONTO` AS `MONTO`,`egresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`egresos`.`DETALLES` AS `DETALLES`,`egresos`.`TIPO` AS `TIPO`,`egresos`.`CANCELADO` AS `CANCELADO` from (`egresos` join `usuarios` on((`egresos`.`ID_USUARIO` = `usuarios`.`ID`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`egresos`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`egresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`egresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`egresos`.`DETALLES` AS `DETALLES`,`tienda_de_ropa`.`egresos`.`TIPO` AS `TIPO`,`tienda_de_ropa`.`egresos`.`CANCELADO` AS `CANCELADO` from (`tienda_de_ropa`.`egresos` join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`egresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`)))
