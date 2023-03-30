
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams; 
    private int nCups;

    /* This is a constructor for the Cafe class */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
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
            this.restock(size, nSugarPackets, nCreams, 1);
         }
    }

  /**
   * This checks what items are running low and restocks them to have enough to make the coffee that was just ordered
   * @param1 int nCoffeeOunces
   * @param2 int nSugarPackets
   * @param3 int nCreams
   * @param4 int nCups
   */ 
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces < nCoffeeOunces){
            this.nCoffeeOunces = nCoffeeOunces;
        }
        if(this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = nSugarPackets;
        }
        if (this.nCreams < nCreams){
            this.nCreams = nCreams;
        }
        if (this.nCups < nCups){
            this.nCups = nCups;
        }

    }
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2);
        myCafe.sellCoffee(12, 2, 2);
        myCafe.sellCoffee(16, 4, 4);
        myCafe.sellCoffee(12, 2, 2);
    }
    
}