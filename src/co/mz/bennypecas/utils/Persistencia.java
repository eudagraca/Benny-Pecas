/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mz.bennypecas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Euclidio G. Venâncio
 */
public class Persistencia {
        
          //Responsavel por criar o entity manafer
            public static final EntityManagerFactory emf =  Persistence.createEntityManagerFactory("pecas");
            //Classe principal fazer operacoes para gerenciar as entidades
            public EntityManager getEntityManager(){
            
            
            return emf.createEntityManager();
        
        
    }
    
}
