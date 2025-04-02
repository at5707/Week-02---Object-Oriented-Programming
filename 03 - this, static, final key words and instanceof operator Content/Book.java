class Book{
	private static String libraryName="City Library";
	private final String isbn;
	private String title;
	private String author;
	public Book(String title,String author,String isbn){
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	public static void displayLibraryName(){
		System.out.println("Library Name: "+libraryName);
	}
	public void displayBookDetails(){
		if(this instanceof Book){
			System.out.println("Library: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
		}else{
			System.out.println("Invalid book object.");
		}
	}
	public static void main(String[] args){
		Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
		Book.displayLibraryName();
        System.out.println();
		book1.displayBookDetails();
        System.out.println();
        book2.displayBookDetails();
	}
}
