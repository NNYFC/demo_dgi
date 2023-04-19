package com.example.demo.model.Dtao;

public class DocumentDtao {
    private String file_name;
    private String content;
    private int iduser;

    public DocumentDtao() {
    }

    public DocumentDtao(String file_name, String content, int iduser) {
        this.file_name = file_name;
        this.content = content;
        this.iduser = iduser;
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

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
