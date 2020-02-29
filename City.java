public class City {
    private CityName name;
    private long population;
    private double xcoord;
    private double ycoord;
    
    public City(long pop, double x, double y) {
        name = new CityName();
        population = pop;
        xcoord = x;
        ycoord = y;
    }
    
    public long getPopulation() {
        return population;
    }
    
    public double dist(double x, double y) { //Used for checking if a newly created city is too close to an existing one
        return Math.pow((y - ycoord) * (y - ycoord) + (x - xcoord) * (x - xcoord), 0.5);
    }
    
    public String toString() {
        return "Name: " + name + ", Population: " + population + ", Position: " + (int) xcoord + "," + (int) ycoord;
    }
}