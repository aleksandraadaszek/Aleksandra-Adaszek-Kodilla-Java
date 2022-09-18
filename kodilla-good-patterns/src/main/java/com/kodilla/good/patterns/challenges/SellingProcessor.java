package com.kodilla.good.patterns.challenges;


import java.time.LocalDateTime;

public class SellingProcessor {

    private InformationService informationService;
    private SellingRepository sellingRepository;
    private SellingService sellingService;


    public SellingProcessor(final InformationService informationService, final SellingRepository sellingRepository, final SellingService sellingService) {
        this.informationService = informationService;
        this.sellingRepository = sellingRepository;
        this.sellingService = sellingService;
    }

    public SellingDto process(final SellRequest sellRequest) {
        SellingServiceClass sellingServiceClass = new SellingServiceClass();
        boolean isSold = sellingServiceClass.sell(sellRequest.getClient(), sellRequest.getDateOfOrder(),sellRequest.getProducts());

        if (isSold) {
            informationService.sendAnEmail();
            sellingRepository.createRecord();
            ProductOrderService productOrderService = new ProductOrderService();
            productOrderService.sold(sellRequest.getClient(),sellRequest.getDateOfOrder(),sellRequest.getProducts());
            return new SellingDto(sellRequest.getClient(),true);
        } else {
            return new SellingDto(sellRequest.getClient(),false);
        }

    }
}

