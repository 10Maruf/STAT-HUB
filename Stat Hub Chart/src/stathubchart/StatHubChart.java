package stathubchart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class StatHubChart implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox vBox;
    @FXML
    private Button btnSetChartName;
    @FXML
    private Button btnLoadCSV;

    private String chartTitle = "Chart Name";
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    private ObservableList<XYChart.Series<String, Number>> barChartData = FXCollections.observableArrayList();
    private ObservableList<XYChart.Series<Number, Number>> scatterChartData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vBox.setVisible(true); // Show initial buttons
    }

    @FXML
    private void handleShowBarChart() {
        if (!barChartData.isEmpty()) {
            borderPane.setCenter(buildBarChart());
        } else {
            System.out.println("No bar chart data available. Please load a CSV file first.");
        }
    }

    @FXML
    private void handleShowPieChart() {
        if (!pieChartData.isEmpty()) {
            borderPane.setCenter(buildPieChart());
        } else {
            System.out.println("No pie chart data available. Please load a CSV file first.");
        }
    }

    @FXML
    private void handleShowScatterChart() {
        if (!scatterChartData.isEmpty()) {
            borderPane.setCenter(buildScatterChart());
        } else {
            System.out.println("No scatter chart data available. Please load a CSV file first.");
        }
    }

    @FXML
    private void handleLoadCSVandTXT() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV and TXT Files", "*.csv", "*.txt"));
        File file = fileChooser.showOpenDialog(borderPane.getScene().getWindow());

        if (file != null) {
            try {
                loadCSVData(file);
                // Automatically set the chart title based on the file name
                chartTitle = file.getName();
                // Automatically show the chart
                handleShowPieChart(); // or handleShowBarChart(); or handleShowScatterChart();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleChangeChartName() {
        TextInputDialog dialog = new TextInputDialog(chartTitle);
        dialog.setTitle("Set Chart Name");
        dialog.setHeaderText("Enter the Name of the Chart:");
        dialog.setContentText("Chart Name:");

        // dialog.showAndWait().ifPresent(name -> chartTitle = name);
        Optional<String> name = dialog.showAndWait();
        if (name.isPresent()) {
            chartTitle = name.get();
        }
    }

    private void loadCSVData(File file) throws IOException {
        pieChartData.clear();
        barChartData.clear();
        scatterChartData.clear();

        XYChart.Series<String, Number> barSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> scatterSeries = new XYChart.Series<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    String name = fields[0].trim();
                    String valueStr = fields[1].trim();
                    try {
                        double value = Double.parseDouble(valueStr);
                        pieChartData.add(new PieChart.Data(name, value));
                        barSeries.getData().add(new XYChart.Data<>(name, value));
                        scatterSeries.getData().add(new XYChart.Data<>(Double.parseDouble(name), value)); // Assuming x
                                                                                                          // value can
                                                                                                          // be parsed
                                                                                                          // as double
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid data: " + line);
                    }
                }
            }
        }
        barChartData.add(barSeries);
        scatterChartData.add(scatterSeries);
        vBox.setVisible(false);

        // Set percentage values for pie chart data
        double total = pieChartData.stream().mapToDouble(PieChart.Data::getPieValue).sum();
        pieChartData.forEach(data -> data.nameProperty().bind(
                Bindings.concat(data.getName(), " ", String.format("%.2f%%", (data.getPieValue() / total) * 100))));
    }

    private BarChart<String, Number> buildBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Category");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle(chartTitle);
        barChart.setData(barChartData);

        return barChart;
    }

    private PieChart buildPieChart() {
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle(chartTitle);
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setLegendVisible(false);
        pieChart.setStartAngle(180);

        createToolTips(pieChart);

        return pieChart;
    }

    private ScatterChart<Number, Number> buildScatterChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X Value");
        yAxis.setLabel("Y Value");

        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setTitle(chartTitle);
        scatterChart.setData(scatterChartData);

        return scatterChart;
    }

    @FXML
    private void handleClose() {
        System.exit(0);
    }

    private void createToolTips(PieChart pc) {
        for (PieChart.Data data : pc.getData()) {
            String msg = String.format("%.2f%%", data.getPieValue());

            Tooltip tp = new Tooltip(msg);
            tp.setShowDelay(Duration.seconds(0));

            Tooltip.install(data.getNode(), tp);

            data.pieValueProperty().addListener(
                    (observable, oldValue, newValue) -> tp.setText(String.format("%.2f%%", newValue.doubleValue())));
        }
    }
}
