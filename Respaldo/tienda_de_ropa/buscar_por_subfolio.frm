TYPE=VIEW
query=select `tienda_de_ropa`.`apartados`.`ID_CLIENTE` AS `ID_CLIENTE`,`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` AS `SUBFOLIO`,`tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO` from (`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones` on((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`)))
md5=12f45d2f93f39e96048ee0fa592595a6
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=2
with_check_option=0
timestamp=2018-05-15 23:20:53
create-version=1
source=SELECT ID_CLIENTE, ID_ASIGNACION AS SUBFOLIO, FOLIO \nFROM APARTADOS JOIN APARTADOS_ASIGNACIONES \nON APARTADOS.FOLIO = APARTADOS_ASIGNACIONES.FOLIO_APARTADO
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`apartados`.`ID_CLIENTE` AS `ID_CLIENTE`,`tienda_de_ropa`.`apartados_asignaciones`.`ID_ASIGNACION` AS `SUBFOLIO`,`tienda_de_ropa`.`apartados`.`FOLIO` AS `FOLIO` from (`tienda_de_ropa`.`apartados` join `tienda_de_ropa`.`apartados_asignaciones` on((`tienda_de_ropa`.`apartados`.`FOLIO` = `tienda_de_ropa`.`apartados_asignaciones`.`FOLIO_APARTADO`)))
