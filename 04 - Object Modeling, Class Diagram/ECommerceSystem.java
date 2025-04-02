import java.util.ArrayList;
import java.util.List;
class Product{
	private String name;
	private double price;
	public Product(String name,double price){
		this.name=name;
		this.price=price;
	}
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	@Override
	public String toString(){
		return "Product{Name='" + name + "', Price=" + price + "}";
	}
}
class Order{
	private int orderId;
	private List<Product> products;
	private Customer customer;
	public Order(int orderId,Customer customer){
		this.orderId=orderId;
		this.customer=customer;
		this.products=new ArrayList<>();
	}
	public void addProduct(Product product){
		products.add(product);
	}
	public void displayOrderDetails(){
		System.out.println("Order ID: " + orderId + " - Customer: " + customer.getName());
        System.out.println("Products:");
		for(Product product:products){
			System.out.println(product);
		}
	}
}
class Customer{
	private String name;
	private List<Order> orders;
	public Customer(String name){
		this.name=name;
		this.orders=new ArrayList<>();
	}
	public String getName(){
		return name;
	}
	public void placeOrder(Order order){
		orders.add(order);
	}
	public void displayOrders(){
		System.out.println("Customer: "+name+" - Orders:");
		for(Order order:orders){
			order.displayOrderDetails();
		}
	}
}
public class ECommerceSystem{
	public static void main(String[] args){
		Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
		Product laptop = new Product("Laptop", 800.0);
        Product phone = new Product("Smartphone", 500.0);
        Product headphones = new Product("Headphones", 100.0);
		Order order1 = new Order(1, alice);
        order1.addProduct(laptop);
        order1.addProduct(headphones);
        alice.placeOrder(order1);
		Order order2 = new Order(2, bob);
        order2.addProduct(phone);
        bob.placeOrder(order2);
		alice.displayOrders();
        bob.displayOrders();
	}
}