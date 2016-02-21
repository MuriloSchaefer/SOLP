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
public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;
    private int permissoes;
    private int endereco;

    /** Método para atribuir um endereço ao funcionario
     * 
     * @param endereco Endereco
     */
    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    /** Método para atribuir um id ao funcionário
     * 
     * @param id Int
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Método para atribuir um nome ao funcionário
     * 
     * @param nome String
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para atribuir um cpf ao funcionário
     * 
     * @param cpf String
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    /** Método para atribuir um rg ao funcionário
     * 
     * @param rg String
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /** Método para atribuir um nome de Usuário para o funcionário
     * 
     * @param usuario String
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /** Método para atribuir uma senha ao funcionário
     * 
     * @param senha String
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /** Método de retorno do id do funcionário
     * 
     * @return (int) id 
     */
    public Integer getId() {
        return id;
    }

    /** Método para retorno do nome do funcionário
     * 
     * @return (String) nome
     */
    public String getNome() {
        return nome;
    }

    /** Método para retorno do cpf do funcionário
     * 
     * @return (String) cpf
     */
    public String getCpf() {
        return cpf;
    }

    /** Método para retorno do rg do funcionário
     * 
     * @return (String) rg
     */
    public String getRg() {
        return rg;
    }
    
    /** Método para retorno do nome de usuário do funcionário
     * 
     * @return (String) usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /** Método para retorno da senha do funcionário
     * 
     * @return (String) senha
     */
    public String getSenha() {
        return senha;
    }

    /** Método para o retorno do nível de permissão do funcionário
     * 
     * @return (int) permissoes
     */
    public int getPermissoes() {
        return permissoes;
    }

    /** Método para atribuir o nivel de permissoes do funcionário
     * 
     * @param permissoes Int
     */
    public void setPermissoes(int permissoes) {
        this.permissoes = permissoes;
    }

    /** Método para retorno do endereço do funcionário
     * 
     * @return (int) endereco
     */
    public int getEndereco() {
        return endereco;
    }
    
    
}
