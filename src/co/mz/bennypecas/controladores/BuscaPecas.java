/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.bennypecas.controladores;

import co.mz.bennypecas.modelos.Produto;
import co.mz.bennypecas.utils.Persistencia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Euclidio G. Venâncio
 */
public class BuscaPecas extends AbstractTableModel{
    
    private ArrayList linhas = null;
    private String [] colunas = null;

     public BuscaPecas() {
    
     }

    public BuscaPecas(ArrayList ln, String [] c){
            setLinhas(ln);
            setColunas(c);
        
    }

   
    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        this.linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        this.colunas = nomes;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    
    public String getColumnName(int cName){
        return colunas [cName];
    }
    
    public Object getValueAt(int numLn, int cName){
        Object[] linha = (Object[])getLinhas().get(numLn);
        return linha[cName];
    }
    
    
    
    public List<Produto> buscaTodos(){
          EntityManager em = new Persistencia().getEntityManager();
          
        List<Produto> produto = null;
        
        
        try {
            produto = em.createQuery("from Produto p where p.quantidade >0 order by p.nome").getResultList();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Erro ao buscar os dados . . . "+ e);
        }finally{
            em.close();
        }
        return produto;
    }
    
    public List<Produto> buscaTempoReal(String Parametro){
        
        EntityManager em =new Persistencia().getEntityManager();
        
        List<Produto> prod = null;
        
        try {
            String p =Parametro;
            String jpsql = "from Produto pr where pr.nome = :pNome";
            Query produtos = em.createQuery(jpsql);
            //produtos
            produtos.setParameter("pNome", p);
            prod = produtos.getResultList();
            
            if(prod.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nao existem peças  com nome "+p);
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro de busca"+ e);
        }finally{
            em.close();
        }
        return prod;
    }


    
}
