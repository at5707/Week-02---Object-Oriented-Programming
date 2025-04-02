class Book{
	public String ISBN;
	protected String title;
	private String author;
	public Book(String ISBN,String title,String author){
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public void displayBookDetails(){
		System.out.println("ISBN: "+ISBN);
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
	}
}
class EBook extends Book{
	private double fileSize;
	public EBook(String ISBN,String title,String author,double fileSize){
		super(ISBN,title,author);
		this.fileSize=fileSize;
	}
	public void displayEBookDetails(){
		System.out.println("ISBN: "+ISBN);
		System.out.println("Title: "+title);
		System.out.println("File Size: "+fileSize+" MB");
	}
	public static void main(String[] args){
		Book b1=new Book("123-456-789","Java Programming","John Doe");
		b1.displayBookDetails();
		b1.setAuthor("Jane Doe");
		System.out.println("Updated Author: "+b1.getAuthor());
		System.out.println();
		EBook e1=new EBook("987-654-321","Python Essentials","Alice Smith",5.2);
		e1.displayEBookDetails();
	}
}