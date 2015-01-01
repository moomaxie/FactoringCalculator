package max.hubbard.Factoring;

import max.hubbard.Factoring.Utils.Separate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Graphing {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    public static void graph(String equation){
        LinkedList<LinkedHashMap<Float, Integer>> list = Separate.separate(equation);


        XYDataset set = createDataset(list, equation);
        final JFreeChart chart = createChart(set,equation);
        final ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setVisible(true);
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        chartPanel.setMouseWheelEnabled(true);

        chartPanel.setPreferredSize(new java.awt.Dimension(Main.label.getWidth(), Main.label.getHeight()));

        Main.getPanel().removeAll();
        Main.getPanel().updateUI();
        Main.getPanel().add(chartPanel,BorderLayout.CENTER);
        Main.getPanel().add(Interface.box, BorderLayout.EAST);

        Main.getFrame().pack();
    }

    private static JFreeChart createChart(final XYDataset dataset, String equation) {


        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                equation,      // chart title
                "X",                      // x axis label
                "Y",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);



//        final StandardLegend legend = (StandardLegend) chart.getLegend();
//              legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(new Range(-50,50));
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    private static XYDataset createDataset(LinkedList<LinkedHashMap<Float,Integer>> list, String orig) {

        final XYSeries series1 = new XYSeries(orig);

        for (double i = -10; i < 11; i++) {
            float v = 0;
            for (LinkedHashMap<Float,Integer> map : list) {
                for (Float f : map.keySet()) {
                    if (map.get(f) != 0){
                        v = v + f * (float)Math.pow(i,map.get(f));
                    } else {
                        v = v + f;
                    }
                }
            }
            series1.add(i, v);
        }


        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        return dataset;

    }

    public static void makeGraphingInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(3, 225));

        JPanel pan = new JPanel();
        JLabel area = new JLabel("Graphing");
        area.setBackground(Color.lightGray);
        area.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(area, BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);

        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.CENTER);
        field.setFont(new Font("Times New Roman", Font.BOLD, 25));
        field.setText("x^4-2x^2-8");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                 graph(field.getText());
            }
        });

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);

        Main.getFrame().pack();

    }

    public static void removeGraphingInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
