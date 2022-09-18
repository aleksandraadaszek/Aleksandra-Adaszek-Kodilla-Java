package com.kodilla.good.patterns.challenges;


import java.time.LocalDateTime;

public interface SellingService {

    boolean sell(Client client, LocalDateTime dateOfOrder, Products products);
}
