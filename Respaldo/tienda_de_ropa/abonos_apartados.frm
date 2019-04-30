TYPE=VIEW
query=select `tienda_de_ropa`.`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`abonos`.`FOLIO_TICKET` AS `FOLIO_TICKET`,`tienda_de_ropa`.`ingresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`ingresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`ingresos`.`CANCELADO` AS `CANCELADO` from (((`tienda_de_ropa`.`abonos` join `tienda_de_ropa`.`apartados`) join `tienda_de_ropa`.`ingresos`) join `tienda_de_ropa`.`usuarios` on(((`tienda_de_ropa`.`ingresos`.`FOLIO` = `tienda_de_ropa`.`abonos`.`FOLIO_TICKET`) and (`tienda_de_ropa`.`usuarios`.`ID` = `tienda_de_ropa`.`ingresos`.`ID_USUARIO`) and (`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`abonos`.`FOLIO_APARTADO`))))
md5=9f1c6b232d62999312e3455709ff454a
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:32
create-version=1
source=select `abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`abonos`.`FOLIO_TICKET` AS `FOLIO_TICKET`,`ingresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`ingresos`.`MONTO` AS `MONTO`,`ingresos`.`CANCELADO` AS `CANCELADO` from (((`abonos` join `apartados`) join `ingresos`) join `usuarios` on(((`ingresos`.`FOLIO` = `abonos`.`FOLIO_TICKET`) and (`usuarios`.`ID` = `ingresos`.`ID_USUARIO`) and (`apartados`.`FOLIO` = `abonos`.`FOLIO_APARTADO`))))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`abonos`.`FOLIO_TICKET` AS `FOLIO_TICKET`,`tienda_de_ropa`.`ingresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`ingresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`ingresos`.`CANCELADO` AS `CANCELADO` from (((`tienda_de_ropa`.`abonos` join `tienda_de_ropa`.`apartados`) join `tienda_de_ropa`.`ingresos`) join `tienda_de_ropa`.`usuarios` on(((`tienda_de_ropa`.`ingresos`.`FOLIO` = `tienda_de_ropa`.`abonos`.`FOLIO_TICKET`) and (`tienda_de_ropa`.`usuarios`.`ID` = `tienda_de_ropa`.`ingresos`.`ID_USUARIO`) and (`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`abonos`.`FOLIO_APARTADO`))))
