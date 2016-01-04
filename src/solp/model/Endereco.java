/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solp.model;

/**
 *
 * @author murilo
 */
public class Endereco {
    private int id;
    private String rua;

    private int num;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(String rua, int num, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public int getNum() {
        return num;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
