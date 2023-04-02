import java.util.Hashtable;

public class Library extends Building {
    private Hashtable <String, Boolean> collection;
    private boolean hasElevator;

    /* This is a constructor for the Library class */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable <String, Boolean> ();
    }

    /** Accessor for collection */
    public Hashtable <String, Boolean> getCollection(){
      return this.collection;
    }

    /** Accessor for hasElevator */
    public boolean hasElevator() {
      return this.hasElevator();
    }

  /**
   * This checks if a title is part of the collection and if not it adds it
   * @param String title
   */
    public void addTitle(String title){
      try{
        if (this.collection.containsKey(title)){
          throw new RuntimeException("This book is already in the library cannot add again.");
        }
        this.collection.put(title, true);
      }
        catch(RuntimeException e){
          System.out.println(e);
        }
    }

  /**
   * This checks if a book is in a collection and if it is, it gets removed
   * @param String title
   * @return the title that we removed
   */
    public String removeTitle(String title){
      try{
      if (!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library.");
      }
      this.collection.remove(title);
      }
      catch(RuntimeException e) {
        System.out.println(e);
      }
      return title;
    }

  /**
   * This checks if a book is in a collection and whether it is available, if both are true then it gets a false value
   * @param String title
   */
    public void checkOut(String title){
      try{
        if (!this.collection.containsKey(title)){
          throw new RuntimeException("This book is not in the library.");
        }
        else if(this.collection.get(title).equals(false)){
          throw new RuntimeException("This book is currently checked out sorry.");
        }
        this.collection.replace(title, false);
        System.out.println(title + " was successfully checked-out!");
        }
        catch(RuntimeException e) {
          System.out.println(e);
        }
      }

  /**
   * This checks if a book is in a collection and whether it is chekcked out, if both are true then it gets a true value
   * @param String title
   */      
    public void returnBook(String title){
      try{
        if(!this.collection.containsKey(title)){
          throw new RuntimeException("Cannot return " + title + " because the library does not own this.");
        }
        else if(this.collection.get(title).equals(true)){
          throw new RuntimeException("This book has already been returned to the library.");
        }
        this.collection.replace(title, true);
        System.out.println(title + " was successfully returned!");
        }

        catch(RuntimeException e){
          System.out.println(e);
        }
  
    }

  /**
   * This checks if a book is in a collection
   * @param String title
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
      
    }

  /**
   * This checks if a book is available
   * @param String title
   * @return true if the title is currently available, false otherwise
   */
    public boolean isAvailable(String title){
      if(this.collection.get(title).equals(true)){
        return true;
      }
      else{
        return false;
      }
    }

  /**
   * This updates the description of the building to also include the total books the library owns
   * @return the updated description
   */
    public String toString() {
      String description = super.toString();
      description += ". There are currently " + this.collection.size() + " books in this collection.";
      return description;
    }

  /**
   * prints out the entire collection in an easy-to-read way (including checkout status)
   */
    public void printCollection() {
      System.out.println(this.collection.toString());
    } 

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }

    public void goToFloor(int floorNum) {
      try{
        if (this.hasElevator == false){
          throw new RuntimeException("Sorry, there is no elevator.");
        }
        super.goToFloor(floorNum);
      }
      catch(RuntimeException e){
        System.out.println(e);
      }
    } 



    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Smith St", 4, true);
      neilson.addTitle("The Cat in The Hat By Dr. Seuss");
      System.out.println(neilson);
      neilson.printCollection();
      neilson.checkOut("The Cat in The Hat By Dr. Seuss");
      neilson.checkOut("The Cat in The Hat By Dr. Seuss");
      neilson.checkOut("The Bible");
      neilson.returnBook("The Cat in The Hat By Dr. Seuss");
      neilson.returnBook("The Cat in The Hat By Dr. Seuss");
      neilson.returnBook("The Bible");
      neilson.printCollection();


    }
  
  }