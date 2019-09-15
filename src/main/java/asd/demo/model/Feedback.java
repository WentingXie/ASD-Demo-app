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

    public Feedback() {
    }

    public Feedback(String name, String email, String title, String description) {
        this.email = email;
        this.title = title;
        this.description = description;
    }

    public boolean match(String email){
        return this.email.equalsIgnoreCase(email.trim());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
		return "Feedback [name="+name + ", email=" + email + ", title=" + title + ", description=" + description + "]";
	}
 
}
