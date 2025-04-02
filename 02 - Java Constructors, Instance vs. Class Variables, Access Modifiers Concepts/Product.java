class Product{
	private static int totalProducts=0;
	private String productName;
	private double price;
	public Product(String productName,double price){
		this.productName=productName;
		this.price=price;
		totalProducts++;
	}
	public void displayProductDetails(){
		System.out.println("Product Name: "+productName);
		System.out.println("Price: $"+String.format("%.2f",price));
	}
	public static void displayTotalDetails(){
		System.out.println("Total Products: "+totalProducts);
	}
	public static void main(String[] args){
		Product p1=new Product("Laptop",999.99);
		Product p2=new Product("Smartphone",599.99);
		p1.displayProductDetails();
		p2.displayProductDetails();
		Product.displayTotalDetails();
	}
}