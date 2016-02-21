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
 */
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private List<MateriaPrimaPorProduto> materiasPrimas;
    private double total;

    /** Método contrutor
     * 
     */
    public Produto() {
    }

    /** Método contrutor
     * 
     * @param id
     * @param nome
     * @param descricao
     * @param materiasPrimas
     * @param total 
     */
    public Produto(Integer id, String nome, String descricao, List<MateriaPrimaPorProduto> materiasPrimas, double total) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.materiasPrimas = materiasPrimas;
        this.total = total;
    }

    /** Método para retorno do id do Produto
     * 
     * @return (Integer) id
     */
    public Integer getId() {
        return id;
    }

    /** Método para retorno do nome do Produto
     * 
     * @return (String) nome
     */
    public String getNome() {
        return nome;
    }

    /** Método para retorno da descrição do Produto
     * 
     * @return (String) descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /** Método para retorno dalistade Matérias Primas por produtos
     * 
     * @return (List)materiasPrimas
     */
    public List<MateriaPrimaPorProduto> getMateriasPrimas() {
        return materiasPrimas;
    }

    /** Método para retorno do total do custo do Produto
     * 
     * @return (double) total
     */
    public double getTotal() {
        return total;
    }

    /** Método para atribuição do id do Produto
     * 
     * @param id (Integer)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Método para atribuição do nome do Produto
     * 
     * @param nome (String)
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para atribuição da descrição de um Produto
     * 
     * @param descricao String
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** Método para atribuição da lista de matérias primas para o Produto
     * 
     * @param materiasPrimas (List)
     */
    public void setMateriasPrimas(List<MateriaPrimaPorProduto> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    /** Método para atribuição de um total para o Produto
     * 
     * @param total (double)
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
}
