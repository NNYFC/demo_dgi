package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "branche")
public class Branche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbranche;
    private String branche_name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idbranche")
    @JsonIgnore
    private Collection<Utilisateur> utilisateurCollection;

    public Branche() {
    }

    public Branche(String branche_name) {
        this.branche_name = branche_name;
    }

    public int getIdbranche() {
        return idbranche;
    }

    public void setIdbranche(int idbranche) {
        this.idbranche = idbranche;
    }

    public String getBranche_name() {
        return branche_name;
    }

    public void setBranche_name(String branche_name) {
        this.branche_name = branche_name;
    }

    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }
}
