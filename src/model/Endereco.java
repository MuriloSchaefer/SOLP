/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author murilo
 * @since Release 1
 */
public class Endereco {
    private int id;
    private String rua;

    private int num;
    private String bairro;
    private String cidade;
    private String estado;

    /** Método contrutor
     * 
     */
    public Endereco() {
    }

    /** Método contrutor 
     * 
     * @param rua
     * @param num
     * @param bairro
     * @param cidade
     * @param estado 
     */
    public Endereco(String rua, int num, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    /** Método que retorna o id do endereço
     * 
     * @return (int) id
     */
    public int getId() {
        return id;
    }

    /** Método que retorna a rua do endereço
     * 
     * @return (String) rua
     */
    public String getRua() {
        return rua;
    }

    /** Método que retorna o numero do endereço
     * 
     * @return (int) num
     */
    public int getNum() {
        return num;
    }

    /** Método que retorna o bairro do endereço
     * 
     * @return (String) bairro
     */
    public String getBairro() {
        return bairro;
    }

    /** Método que retorna a cidade do endereço
     * 
     * @return (String) cidade
     */
    public String getCidade() {
        return cidade;
    }

    /** Método que retorna o estado do endereço
     * 
     * @return (String) estado
     */
    public String getEstado() {
        return estado;
    }

    /** Método que atribui uma rua para o endereço
     * 
     * @param rua String
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /** Método que atribui um numero para o endereço
     * 
     * @param num Int
     */
    public void setNum(int num) {
        this.num = num;
    }

    /** Método que atribui um bairro para o endereço
     * 
     * @param bairro String
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    /** Método que atribui  uma cidade para o endereço
     * 
     * @param cidade String
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /** Método que atribui um estado para o endereço
     * 
     * @param estado String
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** Método que atribui um id para o endereço
     * 
     * @param id Int
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
