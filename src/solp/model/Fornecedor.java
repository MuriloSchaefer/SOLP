/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solp.model;

import java.util.List;

/**
 *
 * @author murilo
 */
public class Fornecedor {
    private Integer id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private List<Endereco> listaEndereco;

    public Fornecedor(int id, String cnpj, String razaoSocial, String nomeFantasia, List<Endereco> listaEndereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.listaEndereco = listaEndereco;
    }

    public Fornecedor() {
    }

    public Integer getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
    
    
}
