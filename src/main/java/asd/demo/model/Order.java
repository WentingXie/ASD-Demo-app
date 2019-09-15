/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

/**
 *
 * @author suyixin
 */
public class Order {
    private String userid;
    private String OpalSN;
    private String orderDate;
    private String Price;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOpalSN() {
        return OpalSN;
    }

    public void setOpalSN(String OpalSN) {
        this.OpalSN = OpalSN;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
    
}
