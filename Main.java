import java.lang.Math.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        String[][] consonants = new String[][]{{"sh", "7"}, {"ch", "5"}, {"th", "12"}, {"tr", "7"}, {"st", "8"}, {"b", "2"}, {"d", "4"}, {"f", "3"}, {"ff", "1"}, {"g", "4"}, {"j", "1"}, {"ck", "4"}, {"l", "4"}, {"m", "3"}, {"n", "5"}, {"p", "2"}, {"qu", "1"}, {"r", "2"}, {"s", "4"}, {"t", "5"}, {"v", "1"}, {"wh", "2"}, {"y", "2"}};
        String[][] vowels = new String[][]{{"a", "6"}, {"e", "8"}, {"i", "4"}, {"o", "5"}, {"u", "2"}, {"ea", "3"}, {"ou", "1"}};
        for (int j = 0 ; j < 50 ; j++) {
            String wd = "";
            int counts = 2 + (int) (Math.random() * 2);
            if (Math.random() < 0.2) {
                counts++;
            }
            String lt = consonants[chooseElement(consonants)][0];
            while (lt == "ck") {
                lt = consonants[chooseElement(consonants)][0];
            }
            wd += lt;
            for (int i = 0 ; i < counts ; i++) {
                wd += vowels[chooseElement(vowels)][0];
                if (i < counts - 1) {
                    wd += consonants[chooseElement(consonants)][0];
                }
            }
            lt = consonants[chooseElement(consonants)][0];
            while (lt == "tr") {
                lt = consonants[chooseElement(consonants)][0];
            }
            wd += lt;
            double nm = Math.random();
            if (nm < 0.07) {
                wd += " City";
            }
            else if (nm < 0.20) {
                wd += "ville";
            }
            else if (nm < 0.25) {
                wd += "ton";
            }
            else if (nm < 0.34) {
                wd += "burg";
            }
            wd = wd.substring(0, 1).toUpperCase() + wd.substring(1);
            System.out.println(wd);
        }
    }
    
    public static int chooseElement(String[][] consonants) {
        int sum = 0;
        for (int k = 0 ; k < consonants.length ; k++) {
            sum += Integer.parseInt(consonants[k][1]);
        }
        
        int nms = (int) (Math.random() * sum);
        
        int sm = 0;
        int k = 0;
        while (k < consonants.length - 1) {
            sm += Integer.parseInt(consonants[k][1]);
            if (sm >= nms) {
                break;
            }
            k ++;
        }
        
        return k;
    }
}
