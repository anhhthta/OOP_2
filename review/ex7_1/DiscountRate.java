package ex7_1;

public class DiscountRate {
    private double serviceDiscountPremium = 0.2;
    private double serviceDiscountGold = 0.15;
    private double serviceDiscountSilver = 0.1;
    private double productDiscount = 0.1;

    public double getServiceDiscountRate(String type){
        switch (type){
            case "premium":{
                return serviceDiscountPremium;
            }
            case "gold": {
                return serviceDiscountGold;
            }
            case "Silver":{
                return serviceDiscountSilver;
            }
            default:{
                return 0;
            }
        }
    }


    public double getProductDiscountRate(String type){
        switch (type){
            case "premium":
            case "gold":
            case "silver":{
                return productDiscount;
            }
            default:{
                return 0;
            }
        }
    };
}
