import java.util.*;
abstract class Product{
    private int productId;
    private String name;
    private double price;
    public Product(int productId,String name,double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
    public int getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public abstract double calculateDiscount();
}
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable{
    public static final double TAX_RATE=0.18;
    public Electronics(int productId,String name,double price){
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount(){
        return getPrice()*0.10;
    }
    @Override
    public double calculateTax(){
        return getPrice()*TAX_RATE;
    }
    @Override
    public String getTaxDetails(){
        return "Electronics Tax: 18%";
    }
}
class Clothing extends Product implements Taxable{
    private static final double TAX_RATE=0.05;
    public Clothing(int productId,String name,double price){
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount(){
        return getPrice()*0.15;
    }
    @Override
    public double calculateTax(){
        return getPrice()*TAX_RATE;
    }
    @Override
    public String getTaxDetails(){
        return "Clothing Tax: 5%";
    }
}
class Groceries extends Product{
    public Groceries(int productId,String name,double price){
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount(){
        return getPrice()*0.05;
    }
}
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> productList=new ArrayList<>();
        productList.add(new Electronics(101, "Laptop", 60000));
        productList.add(new Clothing(102, "T-Shirt", 1000));
        productList.add(new Groceries(103, "Rice", 500));
        System.out.println("Product Details and Final Prices:");
        for(Product product:productList){
            double discount=product.calculateDiscount();
            double tax=(product instanceof Taxable)?((Taxable) product).calculateTax():0;
            double finalPrice=product.getPrice()+tax-discount;
            System.out.println("---------------------");
            System.out.println("Product ID: "+product.getProductId());
            System.out.println("Name: "+product.getName());
            System.out.println("Base Price: "+product.getPrice());
            System.out.println("Discount: "+discount);
            System.out.println("Tax: "+tax);
            System.out.println("Final Price: "+finalPrice);
            if(product instanceof Taxable){
                System.out.println(((Taxable) product).getTaxDetails());
            }
        }
    }
}
