package ex7_1;

import java.util.Date;

public class Visit extends Customer{
    private Customer customer;
    private Date date;
    private  double serviceExpense, productExpense;


    public Visit(String name, Date date) {
        super(name);
        this.date = date;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double TotalExpense(){
        return this.productExpense + this.serviceExpense;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer=" + customer +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}
