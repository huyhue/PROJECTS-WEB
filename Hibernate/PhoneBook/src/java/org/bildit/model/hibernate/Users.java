package org.bildit.model.hibernate;
// Generated Apr 1, 2021 11:45:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="USERS"
    ,schema="dbo"
    ,catalog="newDB"
)
public class Users  implements java.io.Serializable {


     private int id;
     private String username;
     private String password;
     private String email;

    public Users() {
    }

	
    public Users(int id) {
        this.id = id;
    }
    public Users(int id, String username, String password, String email) {
       this.id = id;
       this.username = username;
       this.password = password;
       this.email = email;
    }
    public Users(String username, String password, String email) {
       this.username = username;
       this.password = password;
       this.email = email;
    }
   
     @Id 

    
    @Column(name="ID", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="USERNAME", length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="PASSWORD", length=50)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="EMAIL", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}

