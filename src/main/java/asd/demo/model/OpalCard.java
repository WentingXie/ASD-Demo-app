package asd.demo.model;

import java.io.Serializable;

public class OpalCard implements Serializable {
    
    private String opalCardID;
    private double balance;
    private String description;
    private String sequenceNumber;
            
public OpalCard (String opalCardID, double balance, String description, String sequenceNumber) {
    this.opalCardID = opalCardID;
    this.balance = balance;
    this.description = description;
    this.sequenceNumber = sequenceNumber;
}

public OpalCard() { }

    public void topUp(String opalCardID, double balance, String description, String sequenceNumber) {
        this.opalCardID = opalCardID;
        this.balance = balance;
        this.description = description; 
        this.sequenceNumber = sequenceNumber;
    }
    
    public String getOpalCardID() {
        return opalCardID;
    }
    
    public void setOpalCardID(String opalCardID){
        this.opalCardID = opalCardID;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getSequenceNumber() {
        return sequenceNumber;
    }
    
    public void setSequenceNumber(String sequenceNumber){
        this.sequenceNumber = sequenceNumber;
    }

    public void addBalance(double amount) {
        this.balance = Double.sum(balance, amount);
    }
}

