package com.kodilla.stream.sand;


import java.math.BigDecimal;

public final class Africa implements SandStorage {


    @Override
    public BigDecimal getSandGrainsQuantity() {
        BigDecimal sandQuantity = new BigDecimal("98765432101234567890");
        return sandQuantity;
    }
}
