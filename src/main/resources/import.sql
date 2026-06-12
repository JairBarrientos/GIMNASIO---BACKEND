---ROL
INSERT INTO rol (nombre, descripcion) VALUES('ADMIN', 'Administrador del gimnasio');
INSERT INTO rol (nombre, descripcion) VALUES ('ENTRENADOR', 'Dicta clases en el gimnasio');
INSERT INTO rol (nombre, descripcion) VALUES ('CLIENTE', 'Cliente del gimnasio');

---USUARIO
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Carlos', 'Perez Mendoza', 'carlos.perez.mendoza@gmail.com', '1234', '987654321', 'ACTIVO', 1);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Ana', 'Torres Villanueva', 'ana.torres.villanueva@gmail.com', '1234', '987654322', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Jose', 'Rios Quispe', 'jose.rios.quispe@gmail.com', '1234', '987654325', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Pedro', 'Salas Condori', 'pedro.salas.condori@gmail.com', '1234', '987654327', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Luis', 'Gomez Paredes', 'luis.gomez.paredes@gmail.com', '1234', '987654323', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Maria', 'Lopez Huanca', 'maria.lopez.huanca@gmail.com', '1234', '987654324', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Sofia', 'Chavez Mamani', 'sofia.chavez.mamani@gmail.com', '1234', '987654326', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Lucia', 'Vega Flores', 'lucia.vega.flores@gmail.com', '1234', '987654328', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Miguel', 'Castro Huamani', 'miguel.castro.huamani@gmail.com', '1234', '987654329', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Elena', 'Ruiz Turpo', 'elena.ruiz.turpo@gmail.com', '1234', '987654330', 'INACTIVO', 3);