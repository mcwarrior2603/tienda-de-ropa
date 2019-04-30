TYPE=VIEW
query=select `tienda_de_ropa`.`consultas`.`ID` AS `ID`,`tienda_de_ropa`.`consultas`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO` from ((`tienda_de_ropa`.`consultas` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`productos`.`CLAVE` = `tienda_de_ropa`.`consultas`.`CLAVE_PRODUCTO`))) join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`usuarios`.`ID` = `tienda_de_ropa`.`consultas`.`ID_USUARIO`)))
md5=a0cf383157c8921fdb5929a4da5acb45
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-05-08 14:52:54
create-version=1
source=select `consultas`.`ID` AS `ID`,`consultas`.`FECHA` AS `FECHA`,`productos`.`NOMBRE` AS `NOMBRE`,`usuarios`.`NOMBRE` AS `USUARIO` from ((`consultas` join `productos` on((`productos`.`CLAVE` = `consultas`.`CLAVE_PRODUCTO`))) join `usuarios` on((`usuarios`.`ID` = `consultas`.`ID_USUARIO`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`consultas`.`ID` AS `ID`,`tienda_de_ropa`.`consultas`.`FECHA` AS `FECHA`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `USUARIO` from ((`tienda_de_ropa`.`consultas` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`productos`.`CLAVE` = `tienda_de_ropa`.`consultas`.`CLAVE_PRODUCTO`))) join `tienda_de_ropa`.`usuarios` on((`tienda_de_ropa`.`usuarios`.`ID` = `tienda_de_ropa`.`consultas`.`ID_USUARIO`)))
