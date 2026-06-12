-- ADMIN
INSERT INTO rol (nombre, descripcion)
VALUES ('ADMIN', 'Administrador del gimnasio');

-- ENTRENADOR
INSERT INTO rol (nombre, descripcion)
VALUES ('ENTRENADOR', 'Dicta clases en el gimnasio');

-- CLIENTE
INSERT INTO rol (nombre, descripcion)
VALUES ('CLIENTE', 'Cliente del gimnasio');


-- -------------------------------------------------------------------------------------------

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

-- --------------------------------------------------------------------------------------------------
-- ESPECIALIDADES
INSERT INTO especialidad (nombre, descripcion, estado) VALUES
('Musculación', 'Entrenamiento de fuerza y desarrollo muscular', 'ACTIVO'),
('Yoga', 'Rutinas de flexibilidad y relajación', 'ACTIVO'),
('Spinning', 'Clases de ciclismo indoor', 'ACTIVO'),
('Boxeo', 'Entrenamiento de combate y resistencia', 'ACTIVO'),
('Funcional', 'Ejercicios integrales de alto rendimiento', 'ACTIVO'),
('Pilates', 'Trabajo de control, postura y respiración', 'ACTIVO'),
('Crossfit', 'Entrenamiento de alta intensidad', 'ACTIVO'),
('Zumba', 'Baile y ejercicio cardiovascular', 'ACTIVO'),
('Natación', 'Entrenamiento acuático', 'ACTIVO'),
('Cardio', 'Trabajo cardiovascular general', 'ACTIVO');

-- ----------------------------------------------------------------------------------------------------
-- USUARIOS ENTRENADORES
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES
('Vilma', 'Sanchez Carrion', 'vilma@gmail.com', '1234', '987654322', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Juan', 'Tardeli Muñoz', 'juane@gmail.com', '1234', '987654325', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Pablo', 'Caceres Torres', 'pablori@gmail.com', '1234', '987654327', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Lucia', 'Vega Flores', 'lucia.vega.flores@gmail.com', '1234', '987654328', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Miguel', 'Castro Huamani', 'miguel.castro.huamani@gmail.com', '1234', '987654329', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Elena', 'Ruiz Turpo', 'elena.ruiz.turpo@gmail.com', '1234', '987654330', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Daniel', 'Soto Herrera', 'daniel.soto.herrera@gmail.com', '1234', '987654331', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Camila', 'Paredes Rojas', 'camila.paredes.rojas@gmail.com', '1234', '987654332', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Kevin', 'Mamani Flores', 'kevin.mamani.flores@gmail.com', '1234', '987654333', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR')),
('Valeria', 'Gutierrez Chambi', 'valeria.gutierrez.chambi@gmail.com', '1234', '987654334', 'ACTIVO', (SELECT id_rol FROM rol WHERE nombre = 'ENTRENADOR'));

-- ----------------------------------------------------------------------------------------------------------------
-- ENTRENADORES
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Vilma'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Musculación')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Juan'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Yoga')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Pablo'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Spinning')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Lucia'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Boxeo')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Miguel'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Funcional')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Elena'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Pilates')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Daniel'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Crossfit')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Camila'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Zumba')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Kevin'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Natación')),
('ACTIVO', (SELECT id_usuario FROM usuario WHERE nombres = 'Valeria'), (SELECT id_especialidad FROM especialidad WHERE nombre = 'Cardio'));

