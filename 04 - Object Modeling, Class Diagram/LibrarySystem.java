import java.util.ArrayList;
import java.util.List;
class Book{
	private String title;
	private String author;
	public Book(String title,String author){
		this.title=title;
		this.author=author;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	@Override
	public String toString(){
		return "Book{Title='" + title + "', Author='" + author + "'}";
		}
}
class Library{
	private String name;
	private List<Book> books;
	public Library(String name){
		this.name=name;
		this.books=new ArrayList<>();
	}
	public void addBook(Book book){
		books.add(book);
	}
	public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
public class LibrarySystem{
	public static void main(String[] args){
		Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");
		Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");
		library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);
		library1.displayBooks();
        library2.displayBooks();
	}
}