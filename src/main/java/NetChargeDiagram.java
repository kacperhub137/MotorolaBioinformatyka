import javax.swing.*;
import java.awt.Color;
import java.awt.BasicStroke;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class NetChargeDiagram extends JPanel {
    Protein protein;
    public NetChargeDiagram(Protein protein)
    {
        this.protein = protein;
        JFreeChart netChargeDiagram = ChartFactory.createXYLineChart("Net Charge","pH","Net Charge",createDataset(),PlotOrientation.VERTICAL,false,true,false);
        ChartPanel chartPanel = new ChartPanel( netChargeDiagram );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = netChargeDiagram.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        plot.setRenderer( renderer );
        NumberAxis YAxis = (NumberAxis) plot.getRangeAxis();
        YAxis.setAutoRangeMinimumSize(6);
        YAxis.setVerticalTickLabels(true);
        this.add(chartPanel);
    }
    private XYDataset createDataset()
    {
        final XYSeries netCharge = new XYSeries( "netCharge" );
        for(double i=0.0;i<=14;i+=0.5)
        {
            netCharge.add(i,protein.getNetCharge(i));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries(netCharge);
        return dataset;
    }
}