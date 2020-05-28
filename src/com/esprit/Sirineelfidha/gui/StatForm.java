/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Sirineelfidha.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.esprit.Sirineelfidha.entities.reclamation;


/**
 *
 * @author Sirine
 */
public class StatForm extends BaseForm{
   
     private DefaultRenderer buildCategoryRenderer(int[] colors) {
        
        DefaultRenderer renderer = new DefaultRenderer();
       
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        //renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
           
           
        }
        return renderer;
    }

    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add("Project " + ++k, value);
        }

        return series;
    }

    
    public  StatForm(com.codename1.ui.util.Resources resourceObjectInstance) {
         installSidemenu(resourceObjectInstance);

        // Generate the values
     
        double[] values = new double[]{12, 14, 11};
        
      
        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.YELLOW, ColorUtil.MAGENTA};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(50);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
       r.setGradientStart(0, ColorUtil.BLUE);
       r.setGradientStop(0, ColorUtil.YELLOW);
        r.setHighlighted(true);
        
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        
        ChartComponent c = new ChartComponent(chart);
        addComponent(c);
        


}   
}
