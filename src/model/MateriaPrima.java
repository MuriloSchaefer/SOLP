/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author murilo
 */
public class MateriaPrima {
    private Integer id;
    private String nome;
    private String descricao;
    private Fornecedor fornecedor;
    private String und;
    private double valorUnd;

    /** Método contrutor
     * 
     * @param id
     * @param nome
     * @param descricao
     * @param fornecedor 
     */
    public MateriaPrima(Integer id, String nome, String descricao, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    /** Método contrutor
     * 
     */
    public MateriaPrima() {
    }

    /** Método para retorno do id da Matéria Prima
     * 
     * @return (Integer) id
     */
    public Integer getId() {
        return id;
    }

    /** Método para retorno do nome da Matéria Prima
     * 
     * @return (String) nome
     */
    public String getNome() {
        return nome;
    }

    /** Método para retorno da descrição da Matéria Prima
     * 
     * @return (String) descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /** Método para retorno do Fornecedor da Matéria Prima
     * 
     * @return (Fornecedor) fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /** Método para atribuição de um id para a Matéria Prima
     * 
     * @param id Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Método para atribuição de um nome para Matéria Prima
     * 
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para atribuição de uma descrição para Matéria Prima
     * 
     * @param descricao String
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** Método para atribuição de um Fornecedor para a Matéria Prima
     * 
     * @param fornecedor Fornecedor
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /** Método para atribuição de uma unidade para a Matéria Prima
     * 
     * @param und String
     */
    public void setUnd(String und) {
        this.und = und;
    }

    /** Método para atribuição de um valor Unitário para a Matéria Prima
     * 
     * @param valorUnd double
     */
    public void setValorUnd(double valorUnd) {
        this.valorUnd = valorUnd;
    }

    /** Método para atribuição de uma unidade para a Matéria Prima
     * 
     * @return (String) und
     */
    public String getUnd() {
        return und;
    }

    /** Método para atribuição de um valor unitário para a Matéria Prima
     * 
     * @return (double) valorUnd
     */
    public double getValorUnd() {
        return valorUnd;
    }
    
    
}
