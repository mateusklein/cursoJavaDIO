package com.dio.springboot.springbeans;

import org.springframework.beans.factory.annotation.Autowired;

public class Livro {

    private String nome;
    private String codigo;

    @Autowired
    AutorLivro autor;

    public AutorLivro getAutor() {
        return autor;
    }

    public void setAutor(AutorLivro autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Codigo: " + codigo);
        autor.exibirAutor();
    }
}
