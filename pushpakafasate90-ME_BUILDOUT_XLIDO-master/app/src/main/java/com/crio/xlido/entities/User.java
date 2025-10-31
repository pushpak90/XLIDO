package com.crio.xlido.entities;

public class User {
    private Long user_id;
    private String email;
    private String password;

    public User(){

    }

    public User(Long user_id, String email, String password){
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return user_id;
    }

    public void setId(Long user_id){
        this.user_id = user_id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
