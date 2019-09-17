package asd.demo.model;

import java.io.Serializable;

public class Feedback implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8899453096527351507L;
	
    private String email;
    private String name; 
    private String title;
    private String description;
    private String opalCardNo;
    private String firstName;
    private String lastName;
    private String address;
    private String street1;
    private String street2;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String enqueryType;
    private String enquery;

    public Feedback() {
    }
    public Feedback(String opalCardNo,String firstName,String lastName,String address,String street1,String street2,String city, String pinCode,String state,String country,String enqueryType,String enquery){
        this.opalCardNo=opalCardNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.enqueryType = enqueryType;
        this.enquery = enquery;
        
    }
    
    public String getOpalCardNo(){
        return opalCardNo;
    }
    
    public void setOpalCardNo(String opalCardNo){
        this.opalCardNo = opalCardNo;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    

    public boolean match(String email){
        return this.email.equalsIgnoreCase(email.trim());
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
        public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
          public String getPinCode(){
        return pinCode;
    }
    public void setPinCode(String pinCode){
        this.pinCode = pinCode;
    }
    public void setStreet1(String street1){
        this.street1 =  street1;
    }
    
    public String getStreet1(){
        return street1;
    }
    
        public void setStreet2(String street2){
        this.street2 =  street2;
    }
    
    public String getStreet2(){
        return street2;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }
    public void setCountry(String country){
        this.country = country;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setEnquery(String enquery){
        this.enquery = enquery;
    }
    public String getEnquery(){
        return enquery;
    }
    
    public void setEnqueryType(String enqueryType){
        this.enqueryType = enqueryType;
    }
    public String getEnqueryType(){
        return enqueryType;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Feedback [name="+name + ", email=" + email + ", address=" + address + ", stereet1=" + street1 + "]";
	}
 
}
