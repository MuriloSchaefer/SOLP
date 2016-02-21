/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Mateus
 */
public class Cliente {
    private Integer id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private List<Endereco> listaEndereco;

    /**
     * Método construtor da classe
     */
    public Cliente() {
    }

    /** Método construtor com parametros
     * 
     * @param id id do cliente (gerado pelo banco)
     * @param cnpj String do CNPJ
     * @param razaoSocial String com a razão social do cliente
     * @param nomeFantasia String com o nome fantasia do cliente
     * @param listaEndereco Lista de Enderecos do cliente
     */
    public Cliente(Integer id, String cnpj, String razaoSocial, String nomeFantasia, List<Endereco> listaEndereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.listaEndereco = listaEndereco;
    }

    /** Método de retorno do id de um cliente 
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /** Método de retorno do cnpj de um cliente
     * 
     * @return cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /** Método de retorno da Razão Social de um cliente
     * 
     * @return Razão Social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /** Método de retorno do Nome Fantasia de um cliente
     * 
     * @return Nome Fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /** Método de retorno da lista de endereços de um cliente 
     * 
     * @return Lista de endereços
     */
    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    /** Método para atribuir um id ao cliente
     * 
     * @param id int 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /** Método para atribuir um cnpj ao cliente
     * 
     * @param cnpj String
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /** Método para atribuir uma Razão Social ao cliente
     * 
     * @param razaoSocial String
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**Método para atribuir um Nome Fantasia ao cliente
     * 
     * @param nomeFantasia String
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    /** Método para atribuir uma lista de endereços ao cliente
     * 
     * @param listaEndereco String
     */
    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
    
    
}
