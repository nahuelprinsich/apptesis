package com.tesis.actions;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityAction extends ActionSupport{

	private String username;
    private String password;
 
    @Override
    public String execute() {
 
        //Principal principal = ServletActionContext.getRequest().getUserPrincipal();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("username: " + userDetails.getUsername());
        System.out.println("password: " + userDetails.getPassword());
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails.getAuthorities();
        for (Iterator it = authorities.iterator(); it.hasNext();) {
            SimpleGrantedAuthority authority = (SimpleGrantedAuthority) it.next();
            System.out.println("Role: " + authority.getAuthority());
        }
 
        return SUCCESS;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getPassword() {
        return password;
    }
}
