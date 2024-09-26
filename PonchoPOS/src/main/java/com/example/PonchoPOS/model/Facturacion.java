package com.example.PonchoPOS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_factura;

    private String numero_factura;
    private int id_cliente;
    private String fecha;
    private double subtotal;
    private double descuento;
    private double iva_total;
    private double total;
    private String metodo_pago;
    private boolean factura_electronica;
    private String estado;

    public Facturacion(int id_factura, String numero_factura, int id_cliente, String fecha, double subtotal, double descuento, double iva_total, double total, String metodo_pago, boolean factura_electronica, String estado) {
        this.id_factura = id_factura;
        this.numero_factura = numero_factura;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva_total = iva_total;
        this.total = total;
        this.metodo_pago = metodo_pago;
        this.factura_electronica = factura_electronica;
        this.estado = estado;
    }

    public Facturacion() {

    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva_total() {
        return iva_total;
    }

    public void setIva_total(double iva_total) {
        this.iva_total = iva_total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public boolean isFactura_electronica() {
        return factura_electronica;
    }

    public void setFactura_electronica(boolean factura_electronica) {
        this.factura_electronica = factura_electronica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
