package br.com.hardwares.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hardware implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idHardware;
    private String peca;

  
    public long getIdHardware() {
        return idHardware;
    }


    public void setIdHardware(long idHardware) {
        this.idHardware = idHardware;
    }

 
    public String getPeca() {
        return peca;
    }


    public void setPeca(String peca) {
        this.peca = peca;
    }
    
}
