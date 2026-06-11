-- ADMIN
INSERT INTO rol (nombre, descripcion)
VALUES ('ADMIN', 'Administrador del gimnasio');

-- ENTRENADOR
INSERT INTO rol (nombre, descripcion)
VALUES ('ENTRENADOR', 'Dicta clases en el gimnasio');

-- CLIENTE
INSERT INTO rol (nombre, descripcion)
VALUES ('CLIENTE', 'Cliente del gimnasio');


---------------------------------------------------------------------------------------------

-- ADMIN
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Carlos', 'Perez Mendoza', 'carlos.perez.mendoza@gmail.com', '1234', '987654321', 'ACTIVO', 1);

-- ENTRENADORES
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Ana', 'Torres Villanueva', 'ana.torres.villanueva@gmail.com', '1234', '987654322', 'ACTIVO', 2);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Jose', 'Rios Quispe', 'jose.rios.quispe@gmail.com', '1234', '987654325', 'ACTIVO', 2);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Pedro', 'Salas Condori', 'pedro.salas.condori@gmail.com', '1234', '987654327', 'ACTIVO', 2);

-- CLIENTES
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Luis', 'Gomez Paredes', 'luis.gomez.paredes@gmail.com', '1234', '987654323', 'ACTIVO', 3);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Maria', 'Lopez Huanca', 'maria.lopez.huanca@gmail.com', '1234', '987654324', 'ACTIVO', 3);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Sofia', 'Chavez Mamani', 'sofia.chavez.mamani@gmail.com', '1234', '987654326', 'ACTIVO', 3);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Lucia', 'Vega Flores', 'lucia.vega.flores@gmail.com', '1234', '987654328', 'ACTIVO', 3);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Miguel', 'Castro Huamani', 'miguel.castro.huamani@gmail.com', '1234', '987654329', 'ACTIVO', 3);

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) 
VALUES ('Elena', 'Ruiz Turpo', 'elena.ruiz.turpo@gmail.com', '1234', '987654330', 'INACTIVO', 3);

-- EQUIPAMIENTOS
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Trotadora Profesional X', 'Operativo', 'Cardio');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Bicicleta Estatica V2', 'Operativo', 'Cardio');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Prensa de Piernas 45 Grados', 'Operativo', 'Musculacion');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Banco de Pecho Plano', 'Mantenimiento', 'Musculacion');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Eliptica Premium', 'Operativo', 'Cardio');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Multigimnasio de Poleas', 'Averiado', 'Musculacion');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Mancuernas de Goma Set', 'Operativo', 'Pesas Libres');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Barra Olimpica de Acero', 'Operativo', 'Pesas Libres');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Maquina de Remo Premium', 'Operativo', 'Cardio');
INSERT INTO equipamiento (nombre, estado, area) VALUES ('Escaladora de Escalones', 'Mantenimiento', 'Cardio');

-- MANTENIMIENTOS
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-10', 'Ajuste de faja y lubricacion completa', 120.00, 1);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-12', 'Cambio de sensor de pantalla digital', 85.00, 2);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-15', 'Engrase de rieles y calibracion', 50.00, 3);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-18', 'Tapizado de respaldar de cuero roto', 140.00, 4);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-20', 'Limpieza y mantenimiento preventivo', 40.00, 5);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-22', 'Cambio de cables trenzados rotos', 210.00, 6);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-25', 'Pintado antioxidante de barras de agarre', 35.00, 7);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-26', 'Limpieza profunda de óxido', 25.00, 8);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-28', 'Reparacion de bomba hidraulica de agua', 160.00, 9);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-06-01', 'Ajuste de motor electrico interno', 190.00, 10);