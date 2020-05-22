import javax.swing.*;
import java.io.IOException;
import java.util.TreeMap;
//основной класс запуска

public class Main {
    public static void main(String[] args) throws IOException {
        Task_Two a = new Task_Two();
        a.run();
        TreeMap<String, Integer> map = a.getMap();
        System.out.println(map.toString());
        CreateChart CC = new CreateChart("Pie Chart Test","Top 7", map);
        CC.pack();
        CC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CC.setVisible(true);
    }
}
