class Author{
    private String name;
    private String bio;
    public Author(String name,String bio){
        this.name=name;
        this.bio=bio;
    }
    public String getName(){
        return name;
    }
    public String getBio(){
        return bio;
    }
    public void displayInfo(){
        System.out.println("Author: "+name);
        System.out.println("Bio: "+bio);
    }
}
class Book{
    private String title;
    private int publicationYear;
    private Author author;
    public Book(String title,int publicationYear,Author author){
        this.title=title;
        this.publicationYear=publicationYear;
        this.author=author;
    }
    public void displayInfo(){
        System.out.println("Book: "+title);
        System.out.println("Publication Year: "+publicationYear);
        author.displayInfo();
    }
}
public class BookSystem{
    public static void main(String[] args){
        Author author1 = new Author("George Orwell", "English novelist, essayist, and critic.");
        Book book1 = new Book("1984", 1949, author1);

        Author author2 = new Author("Harper Lee", "Author of the classic novel 'To Kill a Mockingbird'.");
        Book book2 = new Book("To Kill a Mockingbird", 1960, author2);
        book1.displayInfo();
        System.out.println();
        book2.displayInfo();
    }
}