
package com.projetointegrador.physioevolui.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonatas
 */

@Entity(name = "perimetria")
public class Perimetria  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperimetria")
    private Long idperimetria;
    
       
    @Column(name = "braco_perimetria")
    private Long braco_perimetria;
    
    @Column(name = "antebraco_perimetria")
    private Long antebraco_perimetria;
    
    @Column(name = "punho_mao_perimetria")
    private Long punho_mao_perimetria;
   
    @Column(name = "coxa_perimetria")
    private Long coxa_perimetria;
    
    @Column(name = "perna_perimetria")
    private Long perna_perimetria;
    
     @Column(name = "tornozelo_pe_perimetria")
    private Long tornozelo_pe_perimetria;

    public Perimetria() {
    }

    public Perimetria(Long braco_perimetria, Long antebraco_perimetria, Long punho_mao_perimetria, Long coxa_perimetria, Long perna_perimetria, Long tornozelo_pe_perimetria) {
        this.braco_perimetria = braco_perimetria;
        this.antebraco_perimetria = antebraco_perimetria;
        this.punho_mao_perimetria = punho_mao_perimetria;
        this.coxa_perimetria = coxa_perimetria;
        this.perna_perimetria = perna_perimetria;
        this.tornozelo_pe_perimetria = tornozelo_pe_perimetria;
    }

    public Long getIdperimetria() {
        return idperimetria;
    }

    public void setIdperimetria(Long idperimetria) {
        this.idperimetria = idperimetria;
    }

    public Long getBraco_perimetria() {
        return braco_perimetria;
    }

    public void setBraco_perimetria(Long braco_perimetria) {
        this.braco_perimetria = braco_perimetria;
    }

    public Long getAntebraco_perimetria() {
        return antebraco_perimetria;
    }

    public void setAntebraco_perimetria(Long antebraco_perimetria) {
        this.antebraco_perimetria = antebraco_perimetria;
    }

    public Long getPunho_mao_perimetria() {
        return punho_mao_perimetria;
    }

    public void setPunho_mao_perimetria(Long punho_mao_perimetria) {
        this.punho_mao_perimetria = punho_mao_perimetria;
    }

    public Long getCoxa_perimetria() {
        return coxa_perimetria;
    }

    public void setCoxa_perimetria(Long coxa_perimetria) {
        this.coxa_perimetria = coxa_perimetria;
    }

    public Long getPerna_perimetria() {
        return perna_perimetria;
    }

    public void setPerna_perimetria(Long perna_perimetria) {
        this.perna_perimetria = perna_perimetria;
    }

    public Long getTornozelo_pe_perimetria() {
        return tornozelo_pe_perimetria;
    }

    public void setTornozelo_pe_perimetria(Long tornozelo_pe_perimetria) {
        this.tornozelo_pe_perimetria = tornozelo_pe_perimetria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idperimetria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perimetria other = (Perimetria) obj;
         if (!Objects.equals(this.idperimetria, other.idperimetria)) {
            return false;
        }
        return true;
    }
     
     

}
