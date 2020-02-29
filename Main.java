import java.lang.Math.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        String[][] consonants = new String[][]{{"sh", "7"}, {"ch", "5"}, {"th", "12"}, {"tr", "7"}, {"st", "8"}, {"b", "2"}, {"d", "4"}, {"f", "3"}, {"ff", "1"}, {"g", "4"}, {"j", "1"}, {"ck", "4"}, {"l", "4"}, {"m", "3"}, {"n", "5"}, {"p", "2"}, {"qu", "1"}, {"r", "2"}, {"s", "4"}, {"t", "5"}, {"v", "1"}, {"wh", "2"}, {"y", "2"}};
        String[][] vowels = new String[][]{{"a", "6"}, {"e", "8"}, {"i", "4"}, {"o", "5"}, {"u", "2"}, {"ea", "3"}, {"ou", "1"}};
        for (int j = 0 ; j < 50 ; j++) {
            CityName cs = new CityName();
            System.out.println(cs);
        }
    }
}
