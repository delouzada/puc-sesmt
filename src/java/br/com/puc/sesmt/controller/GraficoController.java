/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.puc.sesmt.controller;

import br.com.puc.sesmt.dao.EpiDao;
import br.com.puc.sesmt.dao.ItensAdquiridosDao;
import br.com.puc.sesmt.dao.ItensDevolvidosDao;
import br.com.puc.sesmt.modelo.Adquirirepi;
import br.com.puc.sesmt.modelo.Epi;
import br.com.puc.sesmt.modelo.Itensadquiridos;
import br.com.puc.sesmt.modelo.Itensdevolvidos;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Louzada
 */
@ManagedBean(name="Mbgrafico")
@SessionScoped
public class GraficoController implements Serializable{

    private CartesianChartModel categoryModel;
   
    private Itensadquiridos itensadquiridos;
    
    private Itensdevolvidos itensdevolvidos;
    
    private Integer totalEpi;
    
    /**
     * Creates a new instance of GraficoController
     */
    
    
    public GraficoController() {
        
        
        
        categoryModel = new CartesianChartModel();
        
        itensadquiridos = new Itensadquiridos();
        
        itensdevolvidos = new Itensdevolvidos();
    
   geraGrafico();
    
    }

    public CartesianChartModel getCategoryModel() {
    
        
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }
    

    private void geraGrafico(){
        try {
            
            categoryModel = new CartesianChartModel();
        
           List<Itensadquiridos> itens = new ItensAdquiridosDao().findAll();
           
           List<Itensdevolvidos> itensd = new ItensDevolvidosDao().findAll();
           
           
           ChartSeries adquiridos = new ChartSeries();
           
           adquiridos.setLabel("Adquiridos");
           Integer la = 0;
           
           for(Itensadquiridos lista : itens){
           
               String sdf = new SimpleDateFormat( "dd/MM/yyy" ).format(lista.getDataaquisicao());
         
               
               la += lista.getQuantidade();
               adquiridos.set(sdf, la);
        
           }
           
           
            ChartSeries devolvidos = new ChartSeries();
           
            devolvidos.setLabel("Devolvidos");

            
          Integer ld = 0;   
          
          
                
          for(Itensdevolvidos lista: itensd){
         
          
                String sdf = new SimpleDateFormat( "dd/MM/yyyy" ).format(lista.getDataDevolucao());
         
                
                ld += lista.getQuantidade();
                devolvidos.set(sdf.toString(), ld);
                
           
           }
    
           categoryModel.addSeries(adquiridos);
           
           categoryModel.addSeries(devolvidos);
            
        } catch (Exception ex) {
            
            Logger.getLogger(GraficoController.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
    
    }

    public Itensadquiridos getItensadquiridos() {
        return itensadquiridos;
    }

    public void setItensadquiridos(Itensadquiridos itensadquiridos) {
        this.itensadquiridos = itensadquiridos;
    }

    public Itensdevolvidos getItensdevolvidos() {
        return itensdevolvidos;
    }

    public void setItensdevolvidos(Itensdevolvidos itensdevolvidos) {
        this.itensdevolvidos = itensdevolvidos;
    }

    public Integer getTotalEpi() {
        try {
            
           
            
            List<Itensadquiridos> listadaqueridos = new ItensAdquiridosDao().findAll();
            List<Itensdevolvidos> listaDeItensdevolvidoses = new ItensDevolvidosDao().findAll();
            List<Epi> epises = new EpiDao().findAll();
            
           Integer adqcount = 0;
           
           Integer devcount = 0;
             
           Integer epicount = 0;
           
            Integer count = 0;
            
            
            for (Itensadquiridos lista : listadaqueridos) {
                
                adqcount += lista.getQuantidade();
                
            }
            
            for (Itensdevolvidos lista : listaDeItensdevolvidoses) {
                devcount += lista.getQuantidade();
                
            }
            
            
            for (Epi lista : epises) {
                epicount += lista.getQuantidade();
         
            }
            
            count = epicount + adqcount + devcount;
            
            totalEpi = count;
            
        } catch (Exception ex) {
            Logger.getLogger(GraficoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return totalEpi;
    }

    public void setTotalEpi(Integer totalEpi) {
        this.totalEpi = totalEpi;
    }
    
    
    
    
    
}
