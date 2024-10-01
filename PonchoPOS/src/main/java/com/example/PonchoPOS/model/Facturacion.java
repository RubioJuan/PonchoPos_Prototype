package com.example.PonchoPOS.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "facturacion")
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_factura;

    @Column(name = "numero_factura", unique = true, nullable = false)
    private String numero_factura;

    @Column(name = "id_cliente", nullable = false)
    private Integer id_cliente;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "descuento", precision = 10, scale = 2, columnDefinition = "decimal(10, 2) default 0")
    private BigDecimal descuento;

    @Column(name = "iva_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal iva_total;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "metodo_pago", nullable = false)
    private String metodo_pago;

    @Column(name = "factura_electronica", columnDefinition = "boolean default false")
    private Boolean factura_electronica;

    @Column(name = "estado", columnDefinition = "varchar(50) default 'pagada'")
    private String estado;

    // Constructor vacío
    public Facturacion() {}

    // Constructor con parámetros
    public Facturacion(Integer id_factura, String numero_factura, Integer id_cliente, Date fecha,
                       BigDecimal subtotal, BigDecimal descuento, BigDecimal iva_total,
                       BigDecimal total, String metodo_pago, Boolean factura_electronica, String estado) {
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

    // Getters y Setters
    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getIva_total() {
        return iva_total;
    }

    public void setIva_total(BigDecimal iva_total) {
        this.iva_total = iva_total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public Boolean getFactura_electronica() {
        return factura_electronica;
    }

    public void setFactura_electronica(Boolean factura_electronica) {
        this.factura_electronica = factura_electronica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
