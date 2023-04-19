package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "document")
/*@NamedNativeQuery(
        name =  "Document.findByUserBranche",
        query = "select d.iddoc,d.file_name,d.content,"+
                "d.iduser from document d IN (SELECT u.iduser from" +
                "utilisateur u INNER JOIN branche b ON u.idbranche=b.idbranche where u.iduser=:id)",
        resultClass = Document.class
)*/
@NamedNativeQuery(
        name =  "Document.findByUserBranche",
        query = "select d.iddoc,d.file_name,d.content,"+
                "d.iduser from document d INNER JOIN utilisateur u " +
                "ON d.iduser=u.iduser where u.idbranche=:id",
        resultClass = Document.class
)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddoc;
    private String file_name;
    @Column(name = "content",columnDefinition="TEXT")
    private String content;
    @JoinColumn(name = "iduser",referencedColumnName = "iduser")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Utilisateur iduser;

    public Document() {
    }

    public Document(String file_name, String content, Utilisateur iduser) {
        this.file_name = file_name;
        this.content = content;
        this.iduser = iduser;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Utilisateur getIduser() {
        return iduser;
    }

    public void setIduser(Utilisateur idutilisateur) {
        this.iduser = idutilisateur;
    }
}
