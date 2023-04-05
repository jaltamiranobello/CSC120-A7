
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams; 
    private int nCups;
    private boolean hasElevator;


    /* This is a constructor for the Cafe class */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
    }

    /** Accessor for nCoffeeOunces */
    public int getnCoffeeOunces(){
        return this.nCoffeeOunces;
    }

    /** Accessor for nSugarPackets */
    public int getnSugarPackets(){
        return this.nSugarPackets;
    }

    /** Accessor for nCreams */
    public int getnCreams(){
        return this.nCreams;
    }

    /** Accessor for nCups */
    public int getnCups(){
        return this.nCups;
    }

    /** Accessor for hasElevator */
    public boolean hasElevator() {
        return this.hasElevator();
    }

    
  /**
   * This checks if there is enough inventory to make a coffee, if there is a coffee is sold
   * @param1 int size
   * @param2 int nSugarPackets
   * @param3 int nCreams
   */    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        try {
            if (this.nCoffeeOunces <= size - 1 | this.nSugarPackets <= nSugarPackets - 1 | this.nCreams <= nCreams - 1 | this.nCups == 0){
                throw new RuntimeException("Sorry we don't have enough inventory to make the coffee. Please give us a moment and try again!");
            }

            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        }
         catch(RuntimeException e){
            System.out.println(e);
            this.restock(size, nSugarPackets, nCreams, nCups);
         }
    }

    /* This is an overloaded method for sellCoffee if the person orders an americano */
    public void sellCoffee(int size){
        try{
            if (this.nCoffeeOunces <= size -1 | this.nCups == 0){
                throw new RuntimeException("Sorry we don't have enough inventory to make the coffee. Please give us a moment and try again!");
            }
            this.nCoffeeOunces -= size;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        }
        catch(RuntimeException e){
            System.out.println(e);
            this.restock(size);
        }
    }


  /**
   * This checks what items are running low and restocks them to a specific amount
   * @param1 int nCoffeeOunces
   * @param2 int nSugarPackets
   * @param3 int nCreams
   * @param4 int nCups
   */ 
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces < nCoffeeOunces){
            this.nCoffeeOunces = nCoffeeOunces + 50;
        }
        if(this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = nSugarPackets + 30 ;
        }
        if (this.nCreams < nCreams){
            this.nCreams = nCreams + 30;
        }
        if (this.nCups == 0){
            this.nCups = nCups + 50;
        }

    }

    /* This is an overloaded method for restock if the person orders an americano and there isn't enough coffee to make it so no need to restock cream and sugar */
    private void restock(int nCoffeeOunces){
        this.nCoffeeOunces = nCoffeeOunces + 50;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock() ");
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
        Cafe myCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2, false);
        myCafe.sellCoffee(12, 2, 2);
        myCafe.sellCoffee(16, 4, 4);    
        myCafe.sellCoffee(2);
    }
    
}