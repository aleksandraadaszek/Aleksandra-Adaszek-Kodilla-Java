package com.kodilla.hibernate.invoice;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ITEM")
public class Item {

    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;


    public Item() {

    }

    public Item(BigDecimal price, int quantity, BigDecimal value) {
        this.price=price;
        this.quantity=quantity;
        this.value=value;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="ID", unique = true)
    public int getId() {
        return id;
    }
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name="QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name="VALUE")
    public BigDecimal getValue() {
        return value;
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )

    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    private void setId(int id) {
        this.id=id;
    }

    public void setProduct(Product product) {
        this.product=product;
    }

    private void setPrice(BigDecimal price) {
        this.price=price;
    }

    private void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    private void setValue(BigDecimal value) {
        this.value=value;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice=invoice;
    }
}
