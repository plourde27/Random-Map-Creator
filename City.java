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
}