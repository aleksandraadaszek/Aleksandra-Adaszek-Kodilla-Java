package com.kodilla.stream.sand;


import java.math.BigDecimal;

public final class Asia implements SandStorage {


    @Override
    public BigDecimal getSandGrainsQuantity() {
        BigDecimal sandQuantity = new BigDecimal("99999999901234567890");
        return sandQuantity;
    }
}
