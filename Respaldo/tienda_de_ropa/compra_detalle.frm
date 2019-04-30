TYPE=VIEW
query=select `tienda_de_ropa`.`compras_productos`.`FOLIO_COMPRA` AS `FOLIO_COMPRA`,`tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`compras_productos`.`CANTIDAD` AS `CANTIDAD`,`tienda_de_ropa`.`compras_productos`.`PRECIO_UNITARIO` AS `PRECIO_UNITARIO`,(`tienda_de_ropa`.`compras_productos`.`CANTIDAD` * `tienda_de_ropa`.`compras_productos`.`PRECIO_UNITARIO`) AS `PRECIO_TOTAL` from (`tienda_de_ropa`.`compras_productos` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`compras_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`)))
md5=948011d214e6c34db5177386d4c24a7e
updatable=1
algorithm=0
definer_user=root
definer_host=localhost
suid=1
with_check_option=0
timestamp=2018-03-09 22:08:33
create-version=1
source=select `compras_productos`.`FOLIO_COMPRA` AS `FOLIO_COMPRA`,`productos`.`CLAVE` AS `CLAVE`,`productos`.`NOMBRE` AS `NOMBRE`,`compras_productos`.`CANTIDAD` AS `CANTIDAD`,`compras_productos`.`PRECIO_UNITARIO` AS `PRECIO_UNITARIO`,(`compras_productos`.`CANTIDAD` * `compras_productos`.`PRECIO_UNITARIO`) AS `PRECIO_TOTAL` from (`compras_productos` join `productos` on((`compras_productos`.`CLAVE_PRODUCTO` = `productos`.`CLAVE`)))
client_cs_name=utf8
connection_cl_name=utf8_general_ci
view_body_utf8=select `tienda_de_ropa`.`compras_productos`.`FOLIO_COMPRA` AS `FOLIO_COMPRA`,`tienda_de_ropa`.`productos`.`CLAVE` AS `CLAVE`,`tienda_de_ropa`.`productos`.`NOMBRE` AS `NOMBRE`,`tienda_de_ropa`.`compras_productos`.`CANTIDAD` AS `CANTIDAD`,`tienda_de_ropa`.`compras_productos`.`PRECIO_UNITARIO` AS `PRECIO_UNITARIO`,(`tienda_de_ropa`.`compras_productos`.`CANTIDAD` * `tienda_de_ropa`.`compras_productos`.`PRECIO_UNITARIO`) AS `PRECIO_TOTAL` from (`tienda_de_ropa`.`compras_productos` join `tienda_de_ropa`.`productos` on((`tienda_de_ropa`.`compras_productos`.`CLAVE_PRODUCTO` = `tienda_de_ropa`.`productos`.`CLAVE`)))
