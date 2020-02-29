public class CityName {
    private String name = "";
    
    public CityName() {
        String[] genNames = new String[]{" City", "burg", "ton", "ville", "", "", "", "", ""};
        name = generateName(genNames[(int) (Math.random() * genNames.length)]);
    }
    
    public CityName(String suf) {
        name = generateName(suf);
    }
    
    public static String generateName(String suf) {
        String[][] consonants = new String[][]{{"sh", "7"}, {"ch", "5"}, {"th", "12"}, {"tr", "7"}, {"st", "8"}, {"b", "2"}, {"d", "4"}, {"f", "3"}, {"ff", "1"}, {"g", "4"}, {"j", "1"}, {"ck", "4"}, {"l", "4"}, {"m", "3"}, {"n", "5"}, {"p", "2"}, {"qu", "1"}, {"r", "2"}, {"s", "4"}, {"t", "5"}, {"v", "1"}, {"wh", "2"}, {"y", "2"}};
        String[][] vowels = new String[][]{{"a", "6"}, {"e", "8"}, {"i", "4"}, {"o", "5"}, {"u", "2"}, {"ea", "1"}, {"ou", "2"}};
        
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
        wd += suf;
        wd = wd.substring(0, 1).toUpperCase() + wd.substring(1);
        
        return wd;
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
    
    public String toString() {
        return name;
    }
}