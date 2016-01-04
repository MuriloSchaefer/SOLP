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
public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;
    private int permissoes;
    private int endereco;

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public int getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(int permissoes) {
        this.permissoes = permissoes;
    }

    public int getEndereco() {
        return endereco;
    }
    
    
}
