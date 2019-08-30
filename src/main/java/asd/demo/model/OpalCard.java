
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author jonny
 */
public class OpalCard implements Serializable {
    
    private String opalCardID;
    private BigDecimal balance;
    private String description;
            
public OpalCard (String opalCardID, BigDecimal balance, String description) {
    this.opalCardID = opalCardID;
    this.balance = balance;
    this.description = description;
}

public OpalCard() { }


    
    public void topUp(String opalCardID, BigDecimal balance, String description) {
        this.opalCardID = opalCardID;
        this.balance = balance;
        this.description = description;    
    }
    
 
    
    public String getOpalCardID() {
        return opalCardID;
    }
    

    public void setOpalCardID(String opalCardID){
        this.opalCardID = opalCardID;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}

