package com.kodilla.good.patterns.challenges;



public class Application {

    public static void main(String[] args) {

        SellingRequestRetriever sellingRequestRetriever = new SellingRequestRetriever();
        SellRequest sellRequest = sellingRequestRetriever.retrieveSellData();

        SellingProcessor sellingProcessor = new SellingProcessor(new InformationServiceClass(), new SellingRepositoryClass(),new SellingServiceClass());
        sellingProcessor.process(sellRequest);

    }
}
