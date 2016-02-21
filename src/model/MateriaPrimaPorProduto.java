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

    /** Método contrutor
     * 
     */
    public MateriaPrimaPorProduto() {
    }

    /** Método contrutor
     * 
     * @param id
     * @param materiaPrima
     * @param quantidade
     * @param totalAcumulado 
     */
    public MateriaPrimaPorProduto(Integer id, MateriaPrima materiaPrima, double quantidade, double totalAcumulado) {
        this.id = id;
        this.materiaPrima = materiaPrima;
        this.quantidade = quantidade;
        this.totalAcumulado = totalAcumulado;
    }

    /** Método para retorno do id da Matéria prima por produto
     * 
     * @return (Integer) id
     */
    public Integer getId() {
        return id;
    }

    /** Método para retorno da Matéria prima
     * 
     * @return (MateriaPrima) materiaPrima
     */
    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }
    
    /** Método para retorno da quantidade
     * 
     * @return (double) quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /** Método para retorno do total acumulado
     * 
     * @return (double) totalAcumulado
     */
    public double getTotalAcumulado() {
        return totalAcumulado;
    }

    /** Método atribuição do id
     * 
     * @param id Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Método para atribuição da Matéria Prima
     * 
     * @param materiaPrima MateriaPrima
     */
    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    /** Método para atribuição da quantidade
     * 
     * @param quantidade double
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /** Método para atribuição do total acumulado
     * 
     * @param totalAcumulado double
     */
    public void setTotalAcumulado(double totalAcumulado) {
        this.totalAcumulado = totalAcumulado;
    }
    
}
