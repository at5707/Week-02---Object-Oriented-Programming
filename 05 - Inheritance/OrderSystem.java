import java.time.LocalDate;
class Order{
    protected int orderId;
    protected LocalDate orderDate;
    public Order(int orderId,LocalDate orderDate){
        this.orderId=orderId;
        this.orderDate=orderDate;
    }
    public String getOrderStatus(){
        return "Order placed on "+orderDate;
    }
    public void displayOrderDetails(){
        System.out.println("Order ID: "+orderId);
        System.out.println("Order Date: "+orderDate);
        System.out.println("Status: "+getOrderStatus());
    }
}
class ShippedOrder extends Order{
    protected String trackingNumber;
    public ShippedOrder(int orderId,LocalDate orderDate,String trackingNumber){
        super(orderId,orderDate);
        this.trackingNumber=trackingNumber;
    }
    @Override
    public String getOrderStatus(){
        return "Order shipped with tracking number: "+trackingNumber;
    }
    @Override
    public void displayOrderDetails(){
        super.displayOrderDetails();
        System.out.println("Tracking Number: "+trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder{
    private LocalDate deliveryDate;
    public DeliveredOrder(int orderId,LocalDate orderDate,String trackingNumber,LocalDate deliveryDate){
        super(orderId,orderDate,trackingNumber);
        this.deliveryDate=deliveryDate;
    }
    @Override
    public String getOrderStatus(){
        return "Order delivered on "+deliveryDate;
    }
    @Override
    public void displayOrderDetails(){
        super.displayOrderDetails();
        System.out.println("Delivery Date: "+deliveryDate);
    }
}
public class OrderSystem{
    public static void main(String[] args){
        Order order = new Order(101, LocalDate.of(2025, 3, 20));
        ShippedOrder shippedOrder = new ShippedOrder(102, LocalDate.of(2025, 3, 18), "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, LocalDate.of(2025, 3, 15), "TRK67890", LocalDate.of(2025, 3, 22));
        System.out.println("Order Details:\n");
        order.displayOrderDetails();
        System.out.println("\n------------------------\n");
        shippedOrder.displayOrderDetails();
        System.out.println("\n------------------------\n");
        deliveredOrder.displayOrderDetails();
    }
}