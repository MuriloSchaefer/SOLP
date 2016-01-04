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
public class MateriaPrima {
    private Integer id;
    private String nome;
    private String descricao;
    private Fornecedor fornecedor;
    private String und;
    private double valorUnd;

    public MateriaPrima(Integer id, String nome, String descricao, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }

    public MateriaPrima() {
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

    public Fornecedor getFornecedor() {
        return fornecedor;
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

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public void setValorUnd(double valorUnd) {
        this.valorUnd = valorUnd;
    }

    public String getUnd() {
        return und;
    }

    public double getValorUnd() {
        return valorUnd;
    }
    
    
}
