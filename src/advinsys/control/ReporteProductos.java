/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advinsys.control;

import advinsys.entidad.Articulo;
import advinsys.entidad.Despachos;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author PC
 */
public class ReporteProductos {

    private static int can = 0, can1 = 0, can2 = 0, can3 = 0, can4 = 0, can5 = 0, can6 = 0, can7 = 0, can8 = 0;
    private static List<String> lis = new ArrayList<>();

    public void Moda() {
        GestionInventario gi = new GestionInventario();
        GestionDespachos gd = new GestionDespachos();

        List<Despachos> listaDespachos = gd.getListarDespachos();
        List<String> lista = new ArrayList<>();
        List<Articulo> listaProductos = gi.getListarArticulos();

        for (int i = 0; i < listaDespachos.size(); i++) {

            lista.add(listaDespachos.get(i).getIdArticulo());

        }
        for (int i = 0; i < listaProductos.size(); i++) {

            lis.add(listaProductos.get(i).getIdArticulo());

        }

        for (int i = 0; i < listaDespachos.size(); i++) {

            if (lis.get(0).equals(listaDespachos.get(i).getIdArticulo())) {
                can = can + listaDespachos.get(i).getCantidadDespacho();

            }

        }

        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(1).equals(listaDespachos.get(i).getIdArticulo())) {
                can1 = can1 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(2).equals(listaDespachos.get(i).getIdArticulo())) {
                can2 = can2 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(3).equals(listaDespachos.get(i).getIdArticulo())) {
                can3 = can3 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(4).equals(listaDespachos.get(i).getIdArticulo())) {
                can4 = can4 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(5).equals(listaDespachos.get(i).getIdArticulo())) {
                can5 = can5 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(6).equals(listaDespachos.get(i).getIdArticulo())) {
                can6 = can6 + listaDespachos.get(i).getCantidadDespacho();

            }

        }
        for (int i = 0; i < listaDespachos.size(); i++) {
            if (lis.get(6).equals(listaDespachos.get(i).getIdArticulo())) {
                can6 = can6 + listaDespachos.get(i).getCantidadDespacho();

            }

        }




    }

    public void grafica() {
        Moda();
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(can, lis.get(0), "");
            ds.addValue(can1, lis.get(1), "");
            ds.addValue(can2, lis.get(2), "");
            ds.addValue(can3, lis.get(3), "");
            ds.addValue(can4, lis.get(4), "");
            ds.addValue(can5, lis.get(5), "");
            ds.addValue(can6, lis.get(6), "");
 
            

            JFreeChart jf = ChartFactory.createBarChart3D("REPORTE  PRODUCTOS", "PRODUCTO", "Despachos", ds, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame f = new ChartFrame("DESPACHOS PRODUCTOS", jf);
            f.setSize(1130, 675);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            can1 = 0;
            can = 0;
            can4 = 0;
            can3 = 0;
            can2 = 0;
            can5 = 0;
            can6 = 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
