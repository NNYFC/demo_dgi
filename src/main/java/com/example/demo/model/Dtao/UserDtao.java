package com.example.demo.model.Dtao;

public class UserDtao {
    private String name;
    private String email;
    private String password;
    private int idrole;
    private int idbranche;

    public UserDtao() {
    }

    public UserDtao(String name, String email, String password, int idrole, int idbranche) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.idrole = idrole;
        this.idbranche = idbranche;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public int getIdbranche() {
        return idbranche;
    }

    public void setIdbranche(int idbranche) {
        this.idbranche = idbranche;
    }
}
