-- SQLBook: Code
drop database if exists PonchoPos;
create database PonchoPos;
use PonchoPos;
drop table if exists categoria;
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(255),
    descripcion TEXT,
    activo BOOLEAN DEFAULT TRUE
);

drop table if exists inventario;
CREATE TABLE inventario (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio_costo DECIMAL(10, 2) NOT NULL,
    iva DECIMAL(5, 2) NOT NULL, 
    precio_venta DECIMAL(10, 2) NOT NULL,
    ean VARCHAR(50) UNIQUE, 
    descripcion TEXT,
    fecha_ingreso DATE,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria) ON DELETE CASCADE
);

drop table if exists clientes;
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    documento VARCHAR(50) UNIQUE NOT NULL, 
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(50),
    direccion VARCHAR(255),
    fecha_nacimiento DATE,
    estado BOOLEAN DEFAULT TRUE
);

drop table if exists facturacion;
CREATE TABLE facturacion (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    numero_factura VARCHAR(50) UNIQUE NOT NULL,
    id_cliente INT,
    fecha DATE,
    subtotal DECIMAL(10, 2) NOT NULL,
    descuento DECIMAL(10, 2) DEFAULT 0,
    iva_total DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    metodo_pago VARCHAR(50) NOT NULL, 
    factura_electronica BOOLEAN DEFAULT FALSE,
    estado VARCHAR(50) DEFAULT 'pagada', 
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

drop table if exists factura_detalle;
CREATE TABLE factura_detalle (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_factura INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL, 
    FOREIGN KEY (id_factura) REFERENCES facturacion(id_factura) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES inventario(id_producto) ON DELETE CASCADE
);

show tables;