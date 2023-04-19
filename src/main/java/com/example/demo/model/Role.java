package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrole;
    private String rolename;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idrole")
    @JsonIgnore
    private Collection<Utilisateur> utilisateurCollection;

    public Role() {
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
