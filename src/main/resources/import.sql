-- ================================
-- JAIR: ROL Y USUARIO
-- ================================

INSERT INTO rol (nombre, descripcion) VALUES ('ADMIN', 'Administrador del gimnasio');
INSERT INTO rol (nombre, descripcion) VALUES ('ENTRENADOR', 'Dicta clases en el gimnasio');
INSERT INTO rol (nombre, descripcion) VALUES ('CLIENTE', 'Cliente del gimnasio');

INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Carlos', 'Perez Mendoza', 'carlos.perez@gmail.com', '1234', '987654301', 'ACTIVO', 1);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Vilma', 'Sanchez Carrion', 'vilma.sanchez@gmail.com', '1234', '987654302', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Juan', 'Tardeli Munoz', 'juan.tardeli@gmail.com', '1234', '987654303', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Pablo', 'Caceres Torres', 'pablo.caceres@gmail.com', '1234', '987654304', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Daniel', 'Soto Herrera', 'daniel.soto@gmail.com', '1234', '987654305', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Camila', 'Paredes Rojas', 'camila.paredes@gmail.com', '1234', '987654306', 'ACTIVO', 2);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Luis', 'Gomez Paredes', 'luis.gomez@gmail.com', '1234', '987654307', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Maria', 'Lopez Huanca', 'maria.lopez@gmail.com', '1234', '987654308', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Sofia', 'Chavez Mamani', 'sofia.chavez@gmail.com', '1234', '987654309', 'ACTIVO', 3);
INSERT INTO usuario (nombres, apellidos, correo, password, telefono, estado, id_rol) VALUES ('Elena', 'Ruiz Turpo', 'elena.ruiz@gmail.com', '1234', '987654310', 'INACTIVO', 3);

-- ================================
-- ALDAIR: PLAN Y MIEMBRO
-- ================================

INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Mensual', 'Acceso completo al gimnasio por 30 dias', 80.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Trimestral', 'Acceso completo al gimnasio por 90 dias', 210.00, 90);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Semestral', 'Acceso completo al gimnasio por 180 dias', 380.00, 180);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Anual', 'Acceso completo al gimnasio por 365 dias', 650.00, 365);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Estudiante', 'Plan especial para estudiantes por 30 dias', 55.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Familiar', 'Acceso para familia de hasta 4 personas', 200.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Diurno', 'Acceso solo en horario diurno', 50.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Noche', 'Acceso solo en horario nocturno', 50.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan VIP', 'Acceso ilimitado mas clases personalizadas', 350.00, 30);
INSERT INTO plan (nombre, descripcion, precio, duracion_dias) VALUES ('Plan Basico', 'Acceso limitado a areas de cardio', 35.00, 30);

INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-01-01', '2026-01-31', 'ACTIVO', 7, 1);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-01-15', '2026-04-15', 'ACTIVO', 8, 2);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-02-01', '2026-07-31', 'ACTIVO', 9, 3);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-02-10', '2027-02-10', 'ACTIVO', 10, 4);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-03-01', '2026-03-31', 'INACTIVO', 7, 5);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-03-15', '2026-04-15', 'ACTIVO', 8, 6);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-04-01', '2026-04-30', 'ACTIVO', 9, 7);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-04-10', '2026-05-10', 'INACTIVO', 10, 8);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-05-01', '2026-05-31', 'ACTIVO', 7, 9);
INSERT INTO miembro (fecha_inicio, fecha_fin, estado, id_usuario, id_plan) VALUES ('2026-06-01', '2026-06-30', 'ACTIVO', 8, 10);

-- ================================
-- CRISTHIAN: ESPECIALIDAD Y ENTRENADOR
-- ================================

INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Musculacion', 'Entrenamiento de fuerza y desarrollo muscular', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Yoga', 'Rutinas de flexibilidad y relajacion', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Spinning', 'Clases de ciclismo indoor', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Boxeo', 'Entrenamiento de combate y resistencia', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Funcional', 'Ejercicios integrales de alto rendimiento', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Pilates', 'Trabajo de control, postura y respiracion', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Crossfit', 'Entrenamiento de alta intensidad', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Zumba', 'Baile y ejercicio cardiovascular', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Natacion', 'Entrenamiento acuatico', 'ACTIVO');
INSERT INTO especialidad (nombre, descripcion, estado) VALUES ('Cardio', 'Trabajo cardiovascular general', 'ACTIVO');

INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 2, 1);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 3, 2);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 4, 3);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 5, 4);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 6, 5);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 2, 6);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 3, 7);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 4, 8);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 5, 9);
INSERT INTO entrenador (estado, usuario_id, especialidad_id) VALUES ('ACTIVO', 6, 10);

-- ================================
-- EDUARDO: CLASE E INSCRIPCION
-- ================================

INSERT INTO clase (nombre, horario, capacidad) VALUES ('Spinning', '06:00', 20);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Zumba', '07:00', 25);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Crossfit', '08:00', 15);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Yoga', '09:00', 30);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Pilates', '10:00', 20);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Boxeo', '11:00', 18);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Funcional', '12:00', 25);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('TRX', '13:00', 15);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Aerobicos', '14:00', 30);
INSERT INTO clase (nombre, horario, capacidad) VALUES ('Kick Boxing', '15:00', 20);

INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Luis Gomez Paredes', '2026-06-01', 1);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Maria Lopez Huanca', '2026-06-01', 2);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Sofia Chavez Mamani', '2026-06-02', 3);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Elena Ruiz Turpo', '2026-06-02', 4);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Luis Gomez Paredes', '2026-06-03', 5);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Maria Lopez Huanca', '2026-06-03', 6);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Sofia Chavez Mamani', '2026-06-04', 7);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Elena Ruiz Turpo', '2026-06-04', 8);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Luis Gomez Paredes', '2026-06-05', 9);
INSERT INTO inscripcion (nombre_cliente, fecha_inscripcion, id_clase) VALUES ('Maria Lopez Huanca', '2026-06-05', 10);

-- ================================
-- JHOE: EQUIPAMIENTO Y MANTENIMIENTO
-- ================================

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

INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-10', 'Ajuste de faja y lubricacion completa', 120.00, 1);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-12', 'Cambio de sensor de pantalla digital', 85.00, 2);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-15', 'Engrase de rieles y calibracion', 50.00, 3);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-18', 'Tapizado de respaldar de cuero roto', 140.00, 4);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-20', 'Limpieza y mantenimiento preventivo', 40.00, 5);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-22', 'Cambio de cables trenzados rotos', 210.00, 6);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-25', 'Pintado antioxidante de barras de agarre', 35.00, 7);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-26', 'Limpieza profunda de oxido', 25.00, 8);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-05-28', 'Reparacion de bomba hidraulica de agua', 160.00, 9);
INSERT INTO mantenimiento (fecha, descripcion, costo, id_equipamiento) VALUES ('2026-06-01', 'Ajuste de motor electrico interno', 190.00, 10);
