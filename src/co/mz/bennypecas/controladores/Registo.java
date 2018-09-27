/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.bennypecas.controladores;

import co.mz.bennypecas.modelos.Alerta;
import co.mz.bennypecas.modelos.Produto;
import co.mz.bennypecas.utils.Persistencia;
import javax.persistence.EntityManager;


/**
 *
 * @author Euclidio G. Venâncio
 */
public class Registo {
        
        public void registarProduto( Produto product){
            
            //Classe principal fazer operacoes para gerenciar as entidades
            EntityManager em = new Persistencia().getEntityManager();
            
            product.getDescricao();
            product.getNome();
            product.getEstado();
            product.getPreco();
            product.getQuantidade();
            product.getAlerta();            
            product.getModelo();
            product.getMarcaReferente();                     
            
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        
            em.close();
                    
        }
    
}
