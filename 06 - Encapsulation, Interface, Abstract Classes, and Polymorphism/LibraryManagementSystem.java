import java.util.*;
abstract class LibraryItem{
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId,String title,String author){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
    }
    public String getItemId(){
        return itemId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public abstract int getLoanDuration();
    public void getItemDetails(){
        System.out.println("Item ID: "+itemId);
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Loan Duration: "+getLoanDuration()+" days");
    }
}
interface Reservable{
    boolean reserveItem();
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable{
    public boolean isAvailable=true;
    public Book(String itemId,String title,String author){
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration(){
        return 14;
    }
    @Override
    public boolean reserveItem(){
        if(isAvailable){
            isAvailable=false;
            return true;
        }
        return false;
    }
    @Override
    public boolean checkAvailability(){
        return isAvailable;
    }
}
class Magazine extends LibraryItem{
    public Magazine(String itemId,String title,String author){
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration(){
        return 7;
    }
}
class DVD extends LibraryItem implements Reservable{
    private boolean isAvailable=true;
    public DVD(String itemId,String title,String author){
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration(){
        return 5;
    }
    @Override
    public boolean reserveItem(){
        if(isAvailable){
            isAvailable=false;
            return true;
        }
        return false;
    }
    @Override
    public boolean checkAvailability(){
        return isAvailable;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items=new ArrayList<>();
        items.add(new Book("B101", "Java Programming", "John Doe"));
        items.add(new Magazine("M202", "Tech Weekly", "Jane Smith"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));
        for(LibraryItem item:items){
            item.getItemDetails();
            if(item instanceof Reservable){
                Reservable reservableItem=(Reservable) item;
                System.out.println("Available: "+reservableItem.checkAvailability());
                if(reservableItem.reserveItem()){
                    System.out.println("Item reserved successfully.");
                }else{
                    System.out.println("Item is already reserved.");
                }
            }
            System.out.println("--------------");
        }
    }
}