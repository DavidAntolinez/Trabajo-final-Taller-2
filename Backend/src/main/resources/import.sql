Insert INTO usuario(password,username) VALUES('123','david');

Insert INTO usuario(password,username) VALUES('123','juan');

Insert INTO usuario(password,username) VALUES('123','diego');

Insert INTO item(almacen_Id,descripcion,nombre) VALUES('1','espada','espada basica');

Insert INTO item(almacen_Id,descripcion,nombre) VALUES('3','maza de piedra','maza basica');

Insert INTO item(almacen_Id,descripcion,nombre) VALUES('3','hacha enorme','hacha de batalla');

Insert INTO item(almacen_Id,descripcion,nombre) VALUES('3','baston de mago','baston de sabio');

INSERT INTO almacen(capacidad_Total,items_Almacenados,usuario_Id) VALUES(1,1,1);

INSERT INTO almacen(capacidad_Total,items_Almacenados,usuario_Id) VALUES(1,0,2);

INSERT INTO almacen(capacidad_Total,items_Almacenados,usuario_Id) VALUES(5,3,2);

INSERT INTO historial(fecha,almacen_Destino_Id,Almacen_Origen_Id,item_Id,usuario_Id) VALUES('2024-11-4',1,2,1,1);