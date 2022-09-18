package com.kodilla.good.patterns.challenges;



public class SellingProcessor {

    private InformationService informationService;
    private SellingRepository sellingRepository;
    private SellingService sellingService;


    public SellingProcessor(InformationService informationService, SellingRepository sellingRepository, SellingService sellingService) {
        this.informationService = informationService;
        this.sellingRepository = sellingRepository;
        this.sellingService = sellingService;
    }


    }

