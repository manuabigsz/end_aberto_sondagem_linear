/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easondagemlinear;

/**
 *
 * @author Manu
 */public class Main {

    public static void main(String[] args) {
        Thea tabela = new Thea(10); // Criando uma tabela com tamanho 10

        // Inserindo os valores na tabela hash
        tabela.THEA_inserir(10, 100);
        tabela.THEA_inserir(21, 200);
        tabela.THEA_inserir(44, 300);
        tabela.THEA_inserir(32, 400);
        tabela.THEA_inserir(13, 500);
        tabela.THEA_inserir(37, 600);
        tabela.THEA_inserir(43, 700);

        // Mostrando a tabela com as chaves em cada posição
        tabela.mostrarTabela();
        
        int indiceChave10 = tabela.THEA_Buscar(10); // Buscando a chave 10
        int indiceChave15 = tabela.THEA_Buscar(15); // Buscando a chave 15

        // Exibindo os índices onde as chaves foram encontradas
        System.out.println("Chave 10 encontrada no índice: " + indiceChave10);
        System.out.println("Chave 15 encontrada no índice: " + indiceChave15);
    }
}


