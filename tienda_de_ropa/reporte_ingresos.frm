TYPE=VIEW
query=select `tienda_de_ropa`.`ingresos`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ingresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`ingresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`ingresos`.`DETALLES` AS `DETALLES`,`tienda_de_ropa`.`ingresos`.`TIPO` AS `TIPO`,`tienda_de_ropa`.`ingresos`.`CANCELADO` AS `CANCELADO`,`tienda_de_ropa`.`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`pagos_de_contado`.`FOLIO_VENTA` AS `FOLIO_VENTA` from (((`tienda_de_ropa`.`ingresos` join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`ingresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))) left join `tienda_de_ropa`.`abonos` on((`tienda_de_ropa`.`abonos`.`FOLIO_TICKET` = `tienda_de_ropa`.`ingresos`.`FOLIO`))) left join `tienda_de_ropa`.`pagos_de_contado` on((`tienda_de_ropa`.`ingresos`.`FOLIO` = `tienda_de_ropa`.`pagos_de_contado`.`FOLIO_INGRESO`)))
md5=52cf94f1ed7f750719282659e0e336ed
updatable=0
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-05-08 14:52:54
create-version=1
source=select `ingresos`.`FOLIO` AS `FOLIO`,`ingresos`.`MONTO` AS `MONTO`,`ingresos`.`FECHA` AS `FECHA`,`usuarios`.`NOMBRE` AS `USUARIO`,`ingresos`.`DETALLES` AS `DETALLES`,`ingresos`.`TIPO` AS `TIPO`,`ingresos`.`CANCELADO` AS `CANCELADO`,`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`pagos_de_contado`.`FOLIO_VENTA` AS `FOLIO_VENTA` from (((`ingresos` join `usuarios` on((`ingresos`.`ID_USUARIO` = `usuarios`.`ID`))) left join `abonos` on((`abonos`.`FOLIO_TICKET` = `ingresos`.`FOLIO`))) left join `pagos_de_contado` on((`ingresos`.`FOLIO` = `pagos_de_contado`.`FOLIO_INGRESO`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`ingresos`.`FOLIO` AS `FOLIO`,`tienda_de_ropa`.`ingresos`.`MONTO` AS `MONTO`,`tienda_de_ropa`.`ingresos`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO`,`tienda_de_ropa`.`ingresos`.`DETALLES` AS `DETALLES`,`tienda_de_ropa`.`ingresos`.`TIPO` AS `TIPO`,`tienda_de_ropa`.`ingresos`.`CANCELADO` AS `CANCELADO`,`tienda_de_ropa`.`abonos`.`FOLIO_APARTADO` AS `FOLIO_APARTADO`,`tienda_de_ropa`.`pagos_de_contado`.`FOLIO_VENTA` AS `FOLIO_VENTA` from (((`tienda_de_ropa`.`ingresos` join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`ingresos`.`ID_USUARIO` = `tienda_de_ropa`.`usuarios`.`ID`))) left join `tienda_de_ropa`.`abonos` on((`tienda_de_ropa`.`abonos`.`FOLIO_TICKET` = `tienda_de_ropa`.`ingresos`.`FOLIO`))) left join `tienda_de_ropa`.`pagos_de_contado` on((`tienda_de_ropa`.`ingresos`.`FOLIO` = `tienda_de_ropa`.`pagos_de_contado`.`FOLIO_INGRESO`)))
