package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    private static final String NUMBER = "001";


    @Test
    void testInvoiceDaoSave() {
        //Given
        Item item1 = new Item (new BigDecimal(23),3,new BigDecimal(69));
        Item item2 = new Item (new BigDecimal(44), 34,new BigDecimal(78));
        Item item3 = new Item (new BigDecimal(347), 19,new BigDecimal(6593));
        Item item4 = new Item (new BigDecimal(523),12,new BigDecimal(6276));
        Product product1 = new Product("wooden bench");
        Product product2 = new Product("wooden table");
        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);
        product2.getItems().add(item4);
        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        item4.setProduct(product2);
        Invoice invoice = new Invoice(NUMBER);
        Invoice invoice2 = new Invoice("002");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id1 = invoice.getId();
        invoiceDao.save(invoice2);
        int id2 = invoice2.getId();

        //Then
        assertNotEquals(0,id1);
        assertNotEquals(0, id2);

        //CleanUp
        invoiceDao.deleteById(id1);
        invoiceDao.deleteById(id2);
    }
}
