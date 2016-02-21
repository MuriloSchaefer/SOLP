/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author murilo
 * @since Release 1
 */
public class Fornecedor {
    private Integer id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private List<Endereco> listaEndereco;

    /** Método contrutor
     * 
     * @param id
     * @param cnpj
     * @param razaoSocial
     * @param nomeFantasia
     * @param listaEndereco 
     */
    public Fornecedor(int id, String cnpj, String razaoSocial, String nomeFantasia, List<Endereco> listaEndereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.listaEndereco = listaEndereco;
    }

    /** Método contrutor
     * 
     */
    public Fornecedor() {
    }

    /** Método de retorno do id do Fornecedor
     * 
     * @return (int) id
     */
    public Integer getId() {
        return id;
    }

    /** Método de retorno do cnpj do Fornecedor
     * 
     * @return (String) cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /** Método de retorno da razão social do Fornecedor
     * 
     * @return (String) razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /** Método para retorno do nome fantasia do Fornecedor
     * 
     * @return (String) nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /** Método para retorno da lista de endereços do Fornecedor
     * 
     * @return (List) listaEndereco
     */
    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    /** Método para atribuição de um id para o Fornecedor
     * 
     * @param id Int
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Método para atribuição de um cnpj para o Fornecedor
     * 
     * @param cnpj String
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /** Método para atribuição de uma razão social para o Fornecedor
     * 
     * @param razaoSocial String
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /** Método para atribuição de um nome fantasia para o Fornecedor
     * 
     * @param nomeFantasia String
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /** Método para atribuição de uma lista de Endereços para o Fornecedor
     * 
     * @param listaEndereco List
     */
    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
    
    
}
