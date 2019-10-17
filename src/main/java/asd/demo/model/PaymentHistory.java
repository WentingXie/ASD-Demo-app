package asd.demo.model;

import java.io.Serializable;

public class PaymentHistory implements Serializable {
    
    private String id;
    private String opalcardSequenceNumber;
    private double topUpAmount;
    private String timeStamp;
    
            
public PaymentHistory (String id, String opalcardSequenceNumber, double topUpAmount, String timeStamp) {
    this.id = id;
    this.opalcardSequenceNumber = opalcardSequenceNumber;
    this.topUpAmount = topUpAmount;
    this.timeStamp = timeStamp;
}

public PaymentHistory() { }

    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getOpalCardSequenceNumber() {
        return opalcardSequenceNumber;
    }
    
    public void setOpalCardSequenceNumber(String opalcardSequenceNumber){
        this.opalcardSequenceNumber = opalcardSequenceNumber;
    }
    
    public double getTopUpAmount() {
        return topUpAmount;
    }
    
    public void setTopUpAmount(double topUpAmount){
        this.topUpAmount = topUpAmount;
    }
    
    public String getTimeStamp() {
        return timeStamp;
    }
    
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
    
