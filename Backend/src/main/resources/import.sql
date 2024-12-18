Insert INTO usuario(password,username) VALUES('123','david');

Insert INTO usuario(password,username) VALUES('123','juan');

Insert INTO usuario(password,username) VALUES('123','diego');

Insert INTO item(almacen_Id,descripcion,nombre) VALUES('1','espada','espada basica');

INSERT INTO almacen(capacidad_Total,items_Almacenados,usuario_Id) VALUES(1,1,1);

INSERT INTO almacen(capacidad_Total,items_Almacenados,usuario_Id) VALUES(1,0,2);

INSERT INTO historial_Transferencias(fecha,almacen_Destino_Id,Almacen_Origen_Id,item_Id) VALUES('2024-11-4',1,2,1);

