/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kadam
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserBean implements Serializable {

    private String name;
    private String password;
    private String greeting = "pusto";
    
    public UserBean () {
        
    }

    public String getGreeting() {
        if( name == null ) return "";
        else 
            return "Witaj w swiecie JSF2 i AJAX." +name +"!";
    }
    

    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
