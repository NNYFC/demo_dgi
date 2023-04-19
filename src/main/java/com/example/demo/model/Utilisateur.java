package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "utilisateur")
@NamedNativeQuery(
        name =  "Utilisateur.findByEmail",
        query = "select u.iduser,u.name,u.email,u.password,u.idrole,"+
                "u.idbranche from utilisateur u where u.email=:email ",
        resultClass = Utilisateur.class
)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;
    private String name;
    private String email;
    private String password;
    @JoinColumn(name = "idrole",referencedColumnName = "idrole")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @Fetch(FetchMode.JOIN)
    private Role idrole;
    @JoinColumn(name = "idbranche",referencedColumnName = "idbranche")
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @Fetch(FetchMode.JOIN)
    private Branche idbranche;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "iduser")
    @JsonIgnore
    private Collection<Document> documentCollection;

    public Utilisateur() {
    }

    public Utilisateur(String name, String email, String password, Role idrole, Branche idbranche) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.idrole = idrole;
        this.idbranche = idbranche;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public Role getIdrole() {
        return idrole;
    }

    public void setIdrole(Role idrole) {
        this.idrole = idrole;
    }

    public Branche getIdbranche() {
        return idbranche;
    }

    public void setIdbranche(Branche idbranche) {
        this.idbranche = idbranche;
    }

    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }
}
