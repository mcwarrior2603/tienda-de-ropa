TYPE=VIEW
query=select `tienda_de_ropa`.`usuarios`.`ID` AS `ID_USUARIO`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`niveles_usuario`.`ID` AS `ID_NIVEL`,`tienda_de_ropa`.`niveles_usuario`.`NOMBRE` AS `NIVEL` from (`tienda_de_ropa`.`usuarios` join `tienda_de_ropa`.`niveles_usuario` on((`tienda_de_ropa`.`usuarios`.`ID_NIVEL` = `tienda_de_ropa`.`niveles_usuario`.`ID`)))
md5=7ab96e25391793815368476f8cf58681
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:33
create-version=1
source=select `usuarios`.`ID` AS `ID_USUARIO`,`usuarios`.`NOMBRE` AS `NOMBRE`,`niveles_usuario`.`ID` AS `ID_NIVEL`,`niveles_usuario`.`NOMBRE` AS `NIVEL` from (`usuarios` join `niveles_usuario` on((`usuarios`.`ID_NIVEL` = `niveles_usuario`.`ID`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`usuarios`.`ID` AS `ID_USUARIO`,`tienda_de_ropa`.`usuarios`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`niveles_usuario`.`ID` AS `ID_NIVEL`,`tienda_de_ropa`.`niveles_usuario`.`NOMBRE` AS `NIVEL` from (`tienda_de_ropa`.`usuarios` join `tienda_de_ropa`.`niveles_usuario` on((`tienda_de_ropa`.`usuarios`.`ID_NIVEL` = `tienda_de_ropa`.`niveles_usuario`.`ID`)))
