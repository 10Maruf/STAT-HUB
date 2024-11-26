package StatGraphChart;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

// import javafx.scene.paint.Color;
// import javafx.scene.text.Font;
import java.awt.Color;
import java.awt.Font;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

 public class GraphChartGUI extends JFrame {

    private String chartTitle = "Chart Name";
    private JPanel chartPanel;

    public GraphChartGUI() {
        setTitle("Stat Hub - Graph and Chart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem pieChartItem = new JMenuItem("Show Pie Chart");
        JMenuItem barChartItem = new JMenuItem("Show Bar Chart");
        JMenuItem scatterChartItem = new JMenuItem("Show Scatter Chart");
        JMenuItem loadCSVItem = new JMenuItem("Load CSV");
        JMenuItem changeTitleItem = new JMenuItem("Change Chart Name");
        JMenuItem closeItem = new JMenuItem("Close");

        fileMenu.add(pieChartItem);
        fileMenu.add(barChartItem);
        fileMenu.add(scatterChartItem);
        fileMenu.add(loadCSVItem);
        fileMenu.add(changeTitleItem);
        fileMenu.addSeparator();
        fileMenu.add(closeItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Chart Panel
        chartPanel = new JPanel();
        add(chartPanel, BorderLayout.CENTER);

        // Button Actions
        loadCSVItem.addActionListener(this::loadCSVData);
        pieChartItem.addActionListener(e -> showPieChart());
        barChartItem.addActionListener(e -> showBarChart());
        scatterChartItem.addActionListener(e -> showScatterChart());
        changeTitleItem.addActionListener(e -> changeChartName());
        closeItem.addActionListener(e -> dispose());

        setVisible(true);
    }

    private List<DataPoint> dataPoints = new ArrayList<>();

    private void loadCSVData(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                dataPoints.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length == 2) {
                        String name = fields[0].trim();
                        try {
                            double value = Double.parseDouble(fields[1].trim());
                            dataPoints.add(new DataPoint(name, value));
                        } catch (NumberFormatException ex) {
                            System.err.println("Skipping invalid data: " + line);
                        }
                    }
                }
                chartTitle = file.getName();
                JOptionPane.showMessageDialog(this, "Data Loaded Successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Failed to load data.");
            }
        }
    }

    private void changeChartName() {
        String newTitle = JOptionPane.showInputDialog(this, "Enter new chart title:", chartTitle);
        if (newTitle != null && !newTitle.trim().isEmpty()) {
            chartTitle = newTitle.trim();
        }
    }

    // Pie Chart
    private void showPieChart() {
        if (dataPoints.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data available. Please load a CSV file first.");
            return;
        }
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());

        chartPanel.add(new PieChartPanel(dataPoints), BorderLayout.CENTER);

        chartPanel.revalidate();
        chartPanel.repaint();
    }

    // Bar Chart
    private void showBarChart() {
        if (dataPoints.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data available. Please load a CSV file first.");
            return;
        }
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());

        chartPanel.add(new BarChartPanel(dataPoints), BorderLayout.CENTER);

        chartPanel.revalidate();
        chartPanel.repaint();
    }

    // Scatter Chart
    private void showScatterChart() {
        if (dataPoints.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data available. Please load a CSV file first.");
            return;
        }
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());

        chartPanel.add(new ScatterChartPanel(dataPoints), BorderLayout.CENTER);

        chartPanel.revalidate();
        chartPanel.repaint();
    }

    public static class DataPoint {
        public final String name;
        public final double value;

        public DataPoint(String name, double value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public double getValue() {
            return value;
        }
    }

    // Custom panel for Pie Chart
    public class PieChartPanel extends JPanel {
        public final List<DataPoint> dataPoints;

        public PieChartPanel(List<DataPoint> dataPoints) {
            this.dataPoints = dataPoints;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            int radius = Math.min(width, height) / 3;
            int centerX = width / 2;
            int centerY = height / 2;

            double totalValue = dataPoints.stream().mapToDouble(DataPoint::getValue).sum();
            int startAngle = 0;

            // Fonts and rendering settings for better text clarity
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(new Font("Arial", Font.PLAIN, 12));

            for (DataPoint dp : dataPoints) {
                // Calculate arc angle
                double percentage = (dp.getValue() / totalValue) * 100;
                int arcAngle = (int) Math.round((dp.getValue() / totalValue) * 360);

                // Set color for each segment
                g2.setColor(new Color((int) (Math.random() * 0x1000000)));
                g2.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, startAngle, arcAngle);

                // Draw label
                double angle = Math.toRadians(startAngle + arcAngle / 2.0);
                int labelX = (int) (centerX + (radius + 20) * Math.cos(angle));
                int labelY = (int) (centerY + (radius + 20) * Math.sin(angle));
                String label = String.format("%s (%.1f%%)", dp.getName(), percentage);
                g2.setColor(Color.BLACK);
                g2.drawString(label, labelX - g2.getFontMetrics().stringWidth(label) / 2, labelY);

                startAngle += arcAngle;
            }

            // Draw chart title
            g2.setFont(new Font("Arial", Font.BOLD, 16));
            g2.drawString(chartTitle, centerX - g2.getFontMetrics().stringWidth(chartTitle) / 2, 30);
        }
    }

    // Custom panel for Bar Chart
public class BarChartPanel extends JPanel {
    public final List<DataPoint> dataPoints;

    public BarChartPanel(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate max value for scaling the bar heights
        int maxValue = (int) dataPoints.stream().mapToDouble(DataPoint::getValue).max().orElse(1);

        // Bar width
        int barWidth = getWidth() / dataPoints.size();
        int barHeight;

        // Draw axes
        drawAxes(g, maxValue);

        // Draw bars and labels
        for (int i = 0; i < dataPoints.size(); i++) {
            DataPoint dp = dataPoints.get(i);
            barHeight = (int) (getHeight() * (dp.getValue() / maxValue));

            g.setColor(new Color((int) (Math.random() * 0x1000000)));
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth - 10, barHeight);

            // Label for bars
            g.setColor(Color.BLACK);
            String label = dp.getName() + " (" + dp.getValue() + ")";
            g.drawString(label, i * barWidth + (barWidth - g.getFontMetrics().stringWidth(label)) / 2, getHeight() - barHeight - 5);
        }

        // Title
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(chartTitle, getWidth() / 2 - g.getFontMetrics().stringWidth(chartTitle) / 2, 30);
    }

    // Method to draw the x and y axes with labels
    private void drawAxes(Graphics g, int maxValue) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        // Draw X-axis
        g2.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);

        // Draw Y-axis
        g2.drawLine(50, 50, 50, getHeight() - 50);

        // Draw X-axis labels
        for (int i = 0; i < dataPoints.size(); i++) {
            String label = dataPoints.get(i).getName();
            g2.drawString(label, i * (getWidth() / dataPoints.size()) + 50, getHeight() - 30);
        }

        // Draw Y-axis labels
        int step = (int) (getHeight() / 10);
        for (int i = 0; i <= 10; i++) {
            int yValue = (int) (i * (double) getHeight() / 10);
            g2.drawString(String.valueOf((int) (i * (maxValue / 10))), 30, getHeight() - yValue - 50);
        }
    }
}

// Custom panel for Scatter Chart
public class ScatterChartPanel extends JPanel {
    public final List<DataPoint> dataPoints;

    public ScatterChartPanel(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw axes
        drawAxes(g);

        // Draw scatter points
        for (DataPoint dp : dataPoints) {
            int x = (int) (dp.getValue() * getWidth() / 100);
            int y = (int) (dp.getValue() * getHeight() / 100);

            g.setColor(new Color((int) (Math.random() * 0x1000000)));
            g.fillOval(x, y, 8, 8); // Draw circles for scatter points
        }

        // Title
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(chartTitle, getWidth() / 2 - g.getFontMetrics().stringWidth(chartTitle) / 2, 30);
    }

    // Method to draw the x and y axes with labels
    private void drawAxes(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        // Draw X-axis
        g2.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);

        // Draw Y-axis
        g2.drawLine(50, 50, 50, getHeight() - 50);

        // Draw X-axis labels (for simplicity, using simple range values)
        for (int i = 0; i <= 10; i++) {
            int x = (int) (i * (double) getWidth() / 10);
            g2.drawString(String.valueOf(i * 10), x, getHeight() - 30);
        }

        // Draw Y-axis labels (for simplicity, using simple range values)
        for (int i = 0; i <= 10; i++) {
            int y = (int) (i * (double) getHeight() / 10);
            g2.drawString(String.valueOf(i * 10), 30, getHeight() - y - 50);
        }
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphChartGUI::new);
    }
}
