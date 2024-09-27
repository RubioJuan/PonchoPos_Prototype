-- SQLBook: Code
use PonchoPos;
-- Datos de prueba para la tabla categoria
INSERT INTO categoria (nombre, ubicacion, descripcion) VALUES ('Electrónica', 'Primer Piso', 'Artículos electrónicos y gadgets');
INSERT INTO categoria (nombre, ubicacion, descripcion) VALUES ('Ropa', 'Segundo Piso', 'Ropa y accesorios para todas las edades');
INSERT INTO categoria (nombre, ubicacion, descripcion) VALUES ('Alimentos', 'Tercer Piso', 'Alimentos y bebidas de consumo diario');
INSERT INTO categoria (nombre, ubicacion, descripcion) VALUES ('Muebles', 'Cuarto Piso', 'Mobiliario para el hogar y oficina');
INSERT INTO categoria (nombre, ubicacion, descripcion) VALUES ('Libros', 'Quinto Piso', 'Gran selección de libros de diferentes géneros');
-- Datos de prueba para Inventario
INSERT INTO inventario (nombre, cantidad, precio_costo, iva, precio_venta, ean, descripcion, fecha_ingreso, id_categoria) VALUES ('Televisor 4K', 10, 400.00, 16.00, 464.00, '1234567890123', 'Televisor 4K UHD de 55 pulgadas', '2024-09-01', 1);
INSERT INTO inventario (nombre, cantidad, precio_costo, iva, precio_venta, ean, descripcion, fecha_ingreso, id_categoria) VALUES ('Camisa de algodón', 50, 10.00, 12.00, 11.20, '1234567890124', 'Camisa de algodón talla M', '2024-09-01', 2);
INSERT INTO inventario (nombre, cantidad, precio_costo, iva, precio_venta, ean, descripcion, fecha_ingreso, id_categoria) VALUES ('Paquete de galletas', 100, 2.50, 16.00, 2.90, '1234567890125', 'Paquete de galletas surtidas', '2024-09-01', 3);
INSERT INTO inventario (nombre, cantidad, precio_costo, iva, precio_venta, ean, descripcion, fecha_ingreso, id_categoria) VALUES ('Silla de oficina', 20, 80.00, 16.00, 92.80, '1234567890126', 'Silla ergonómica con respaldo alto', '2024-09-01', 4);
INSERT INTO inventario (nombre, cantidad, precio_costo, iva, precio_venta, ean, descripcion, fecha_ingreso, id_categoria) VALUES ('Libro: El Quijote', 30, 15.00, 16.00, 17.40, '1234567890127', 'Libro de Miguel de Cervantes', '2024-09-01', 5);

-- Datos para clientes
INSERT INTO clientes (documento, nombre, apellido, pais, ciudad, email, telefono, direccion, fecha_nacimiento) VALUES ('123456789', 'Juan', 'Pérez', 'México', 'Ciudad de México', 'juan.perez@example.com', '555-1234', 'Calle Falsa 123', '1985-03-15');
INSERT INTO clientes (documento, nombre, apellido, pais, ciudad, email, telefono, direccion, fecha_nacimiento) VALUES ('987654321', 'María', 'Gómez', 'España', 'Madrid', 'maria.gomez@example.com', '912-3456', 'Av. Siempre Viva 456', '1990-07-22');
INSERT INTO clientes (documento, nombre, apellido, pais, ciudad, email, telefono, direccion, fecha_nacimiento) VALUES ('555444333', 'Pedro', 'López', 'Argentina', 'Buenos Aires', 'pedro.lopez@example.com', '011-7890', 'Calle Corrientes 789', '1978-11-30');
INSERT INTO clientes (documento, nombre, apellido, pais, ciudad, email, telefono, direccion, fecha_nacimiento) VALUES ('111222333', 'Ana', 'Martínez', 'Chile', 'Santiago', 'ana.martinez@example.com', '222-3333', 'Calle 8 de Marzo 111', '1982-05-14');
INSERT INTO clientes (documento, nombre, apellido, pais, ciudad, email, telefono, direccion, fecha_nacimiento) VALUES ('222333444', 'Luis', 'Rodríguez', 'Colombia', 'Bogotá', 'luis.rodriguez@example.com', '333-4444', 'Av. Libertador 222', '1975-09-09');

-- Datos Facturaciòn
INSERT INTO facturacion (numero_factura, id_cliente, fecha, subtotal, descuento, iva_total, total, metodo_pago) VALUES ('FAC001', 1, '2024-09-10', 500.00, 0, 80.00, 580.00, 'Tarjeta de crédito');
INSERT INTO facturacion (numero_factura, id_cliente, fecha, subtotal, descuento, iva_total, total, metodo_pago) VALUES ('FAC002', 2, '2024-09-10', 300.00, 20.00, 44.80, 324.80, 'Efectivo');
INSERT INTO facturacion (numero_factura, id_cliente, fecha, subtotal, descuento, iva_total, total, metodo_pago) VALUES ('FAC003', 3, '2024-09-11', 1000.00, 50.00, 152.00, 1102.00, 'Transferencia bancaria');
INSERT INTO facturacion (numero_factura, id_cliente, fecha, subtotal, descuento, iva_total, total, metodo_pago) VALUES ('FAC004', 4, '2024-09-12', 250.00, 0, 40.00, 290.00, 'Tarjeta de débito');
INSERT INTO facturacion (numero_factura, id_cliente, fecha, subtotal, descuento, iva_total, total, metodo_pago) VALUES ('FAC005', 5, '2024-09-12', 150.00, 10.00, 22.40, 162.40, 'Paypal');

-- Datos Factura_detalle
INSERT INTO factura_detalle (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES (1, 1, 1, 464.00, 464.00);
INSERT INTO factura_detalle (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES (2, 2, 2, 11.20, 22.40);
INSERT INTO factura_detalle (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES (3, 3, 10, 2.90, 29.00);
INSERT INTO factura_detalle (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES (4, 4, 1, 92.80, 92.80);
INSERT INTO factura_detalle (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES (5, 5, 3, 17.40, 52.20);

