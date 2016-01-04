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
public class MateriaPrimaPorProduto {
    private Integer id;
    private MateriaPrima materiaPrima;
    private double quantidade;
    private double totalAcumulado;

    public MateriaPrimaPorProduto() {
    }

    public MateriaPrimaPorProduto(Integer id, MateriaPrima materiaPrima, double quantidade, double totalAcumulado) {
        this.id = id;
        this.materiaPrima = materiaPrima;
        this.quantidade = quantidade;
        this.totalAcumulado = totalAcumulado;
    }

    public Integer getId() {
        return id;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getTotalAcumulado() {
        return totalAcumulado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setTotalAcumulado(double totalAcumulado) {
        this.totalAcumulado = totalAcumulado;
    }
    
}
