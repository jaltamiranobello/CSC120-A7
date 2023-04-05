import java.util.ArrayList;

public class CampusMap {
    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court, Northampton, MA 01063", 4));
        Cafe myCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2, false);
        Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
        House wilson = new House("Wilson", "16 Kesington Ave, Northampton, MA 01063", 4, false, false, true);
        House hubbard = new House("Hubbard", "3 Green Street, Northampton, MA 01063", 4);
        House tyler= new House("Tyler", "151-199 Green Street, Northampton, MA 01063", 4);
        House comstock = new House("Comstock", "Mandelle Rd, Northampton, MA 01063", 3, true, true, true);
        Building fordHall = new Building("Ford Hall", "100 Green St, Northampton, MA 01063", 3);
        Building campusCenter = new Building("Campus Center", "100 Elm St, Northampton, MA 01063", 2);
        Library hillyer = new Library("Hillyer Library", "20 Elm St, Northampton, MA 01063", 2, true);
        Library josten = new Library("Josten Library", "122 Green St, Northampton, MA 01063", 3, true);
        myMap.addBuilding(myCafe);
        myMap.addBuilding(neilson);
        myMap.addBuilding(wilson);
        myMap.addBuilding(hubbard);
        myMap.addBuilding(tyler);
        myMap.addBuilding(comstock);
        myMap.addBuilding(fordHall);
        myMap.addBuilding(campusCenter);
        myMap.addBuilding(hillyer);
        myMap.addBuilding(josten);
        System.out.println(myMap);
        System.out.println();

        
        for(Building b: myMap.buildings){
            b.showOptions();
        }


    }
    
}
