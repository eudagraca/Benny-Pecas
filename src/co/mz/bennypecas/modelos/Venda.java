package co.mz.bennypecas.modelos;

import java.time.LocalDate;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Euclidio G. Venâncio
 */

//@Entity
public class Venda {
    
    private Produto nome;
    private double valorPago;
    
    @Temporal (TemporalType.TIMESTAMP)
    private LocalDate dataVenda = LocalDate.now();
       
    @ManyToOne
    private Produto produto;

    
}