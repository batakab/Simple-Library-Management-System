package SimpleLibraryManagementSystem;

public class Book {

    private String title, author, availability;
    private boolean isIssued;

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle(){
        return title;
    }

    public String getAvailability() {
        return availability;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued(){
        return isIssued;
    }

    public void setIssued(boolean issued){
        isIssued = issued;
    }

    @Override
    public String toString(){
        String status = isIssued ? "Issued" : "Available";
        return "Title: " + title + ", Author: " + author + ", Status: " + status;
    }

}
