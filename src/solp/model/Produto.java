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
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private List<MateriaPrimaPorProduto> materiasPrimas;
    private double total;

    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, List<MateriaPrimaPorProduto> materiasPrimas, double total) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.materiasPrimas = materiasPrimas;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<MateriaPrimaPorProduto> getMateriasPrimas() {
        return materiasPrimas;
    }

    public double getTotal() {
        return total;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMateriasPrimas(List<MateriaPrimaPorProduto> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
