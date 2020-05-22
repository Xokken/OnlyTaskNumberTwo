import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
//класс отвечает за работу с данными и их сортировкой

public class Task_Two {
    public TreeMap<String, Integer> map = new TreeMap<>();
    public void run() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Xokken\\IdeaProjects\\Data_Mining\\data.csv"), ';' , '"' , 1);
        String[] nextLine;
        int count = 0;

        while ((nextLine = reader.readNext()) != null) {
            count++;
            if(!(map.containsKey(nextLine[0]))){
                map.put(nextLine[0], 1);
            }
            else{
                map.put(nextLine[0], map.get(nextLine[0]) + 1);
            }
        }

        map = (TreeMap<String, Integer>) sortByValues(map);
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                return map.get(k1).compareTo(map.get(k2));
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public TreeMap<String, Integer> getMap() {
        return map;
    }
}
