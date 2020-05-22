import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;
//выводит топ 5 самых популярных

public class CreateChart extends JFrame {
    TreeMap<String,Integer> aaaaa = new TreeMap<>();

    public CreateChart(String appTitle, String chartTitle, TreeMap<String,Integer> aa) {
        this.aaaaa = aa;
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset,chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
    }


    private PieDataset createDataset() {
        TreeMap<String,Integer> map = aaaaa;
        System.out.println(map.size());

        DefaultPieDataset result = new DefaultPieDataset();
        int count = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if (count == 5){
                break;
            }
            result.setValue(entry.getKey(), entry.getValue());
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " => " + value);
            count++;
        }


        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(90);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }

}