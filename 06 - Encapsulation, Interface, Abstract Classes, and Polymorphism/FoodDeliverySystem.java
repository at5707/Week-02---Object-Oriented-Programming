import java.util.*;
abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName,double price,int quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }
    public String getItemName(){
        return itemName;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails(){
        System.out.println("Item Name: "+itemName);
        System.out.println("Price: "+price);
        System.out.println("Quantity: "+quantity);
        System.out.println("Total Price: "+calculateTotalPrice());
    }
}
interface Discountable{
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable{
    private double disocuntRate=0.10;
    public VegItem(String itemName,double price,int quantity){
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice(){
        return getPrice()*getQuantity()-applyDiscount();
    }
    @Override
    public double applyDiscount(){
        return getPrice()*getQuantity()*disocuntRate;
    }
    @Override
    public String getDiscountDetails(){
        return "Discount: "+(disocuntRate*100)+"% applied";
    }
}
class NonVegItem extends FoodItem{
    private double additionalCharge=20;
    public NonVegItem(String itemName,double price,int quantity){
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice(){
        return(getPrice()+additionalCharge)*getQuantity();
    }
}
public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order=new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));
        for(FoodItem item:order){
            item.getItemDetails();
            if(item instanceof Discountable){
                Discountable discountableItem=(Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println("------------------------");
        }
    }
}