import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /* This is a constructor for the House class */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
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
    return description;
  }

  public static void main(String[] args) {
    House wilson = new House("Wilson", "16 Kensington Ave", 4, false);
    System.out.println(wilson);
    wilson.moveIn("Julie");
    wilson.moveIn("Julie");
    wilson.moveIn("Taylor");
    wilson.moveOut("Julie");
    wilson.moveIn("Liz");
    System.out.println(wilson);
    House scales = new House("Scales", "170 Elm Street", 4, true);
    scales.moveIn("Kimberly");
    scales.moveOut("Julie");
    System.out.println(scales);
  }

}