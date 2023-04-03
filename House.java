import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /* This is a full constructor for the House class */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator= hasElevator;
  }
  /* This is an overloaded constructor for the House class w/ name, adress, and nFloors */
  public House (String name, String address, int nFloors){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
  }

  /* This is an overloaded constructor for the House class w/ name and address */
  public House (String name, String address){
    super(name, address);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

    /** Accessor for hasElevator */
    public boolean hasElevator() {
      return this.hasElevator();
    }

  /**
   * This moves in a person into a house if they do not already live there by adding them to an arraylist called residents
   * @param String name
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    try{
      if (this.residents.contains(name)) {
        //   if so: throw and exception
        throw new RuntimeException(name + " is already a resident of " + this.name);
      }
      // if we're good to go, add to roster
      this.residents.add(name);
      System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");

    }
    catch(RuntimeException e) {
      System.out.println(e); 
    }
    
  }

  /**
   * This moves out a person of a house if they live there by removing them from the arraylist called residents
   * @param String name
   */
  public String moveOut(String name){
    try{
    if (!this.residents.contains(name)){
      throw new RuntimeException(name + " doesn't live in " + this.name);
    }
    this.residents.remove(name);
    System.out.println(name + " has moved out of " + this.name);

    }
    catch(RuntimeException e){
      System.out.println(e);
    }  
    return name;
    
  }

  /**
   * This checks if a person is a resident of a house
   * @param String person
   * @return a true or false statement
   */
  public boolean isResident(String person) {
    if (this.residents.contains(person)){
      return true;
    }

    else{
      return false;
    }
  }
 
  /**
   * This updates the description of the building to also include the total residents and whether it has a dining room
   * @return the updated description
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    description += " This house ";
    if (this.hasElevator){
      description += "has";
    } else{
      description += "does not have";
    }
    description += " an elevator.";
    return description;
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()\n + isResident()\n");
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
    House wilson = new House("Wilson", "16 Kensington Ave", 4);
    System.out.println(wilson.hasDiningRoom);
    wilson.moveIn("Julie");
    wilson.moveIn("Julie");
    wilson.moveIn("Taylor");
    wilson.moveOut("Julie");
    wilson.moveIn("Liz");
    System.out.println(wilson);
    House scales = new House("Scales", "170 Elm Street", 4, true, true);
    scales.moveIn("Kimberly");
    scales.moveOut("Julie");
    System.out.println(scales);
    wilson.enter();
    wilson.goToFloor(2);
    scales.enter();
    scales.goToFloor(2);
  }

}