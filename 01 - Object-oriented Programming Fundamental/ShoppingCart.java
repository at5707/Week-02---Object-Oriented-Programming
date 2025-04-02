import java.util.ArrayList;
import java.util.List;

class CartItem{
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return price * quantity;
    }

    public String getItemName(){
        return itemName;
    }

    public int getQuantity(){
        return quantity;
    }

    public void updateQuantity(int quantity){
        if(quantity > 0){
            this.quantity = quantity;
        }else{
            System.out.println("Invalid quantity! Must be greater than 0.");
        }
    }

    public void displayItem(){
        System.out.printf("%s - Price: %.2f x %d = %.2f%n", itemName, price, quantity, getTotalPrice());
    }
}

class ShoppingCart{
    private List<CartItem> cartItems;

    public ShoppingCart(){
        this.cartItems = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity){
        if (quantity <= 0){
            System.out.println("Quantity must be at least 1.");
            return;
        }
        for (CartItem item : cartItems){
            if (item.getItemName().equalsIgnoreCase(itemName)){
                item.updateQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(itemName, price, quantity));
    }

    public void removeItem(String itemName){
        boolean removed = cartItems.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
        if (!removed){
            System.out.println("Item not found in cart.");
        }
    }

    public double getTotalCost(){
        return cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public void displayCart(){
        if (cartItems.isEmpty()){
            System.out.println("The shopping cart is empty.");
        }else{
            System.out.println("Shopping Cart:");
            cartItems.forEach(CartItem::displayItem);
            System.out.printf("Total Cost: %.2f%n", getTotalCost());
        }
    }

    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 750.50, 1);
        cart.addItem("Mouse", 25.99, 2);
        cart.displayCart();
        cart.removeItem("Mouse");
        cart.displayCart();
    }
}
