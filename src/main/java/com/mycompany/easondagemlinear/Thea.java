/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.easondagemlinear;

/**
 *
 * @author Manu
 */
public class Thea {
    int tam; // tamanho da tabela
    Elem[] tabelaHash; // tabela hash

    public Thea(int tam) {
        this.tam = tam;
        this.tabelaHash = new Elem[tam];
        for (int i = 0; i < tam; i++) {
            this.tabelaHash[i] = new Elem();
        }
    }
    
    private int THEA_Hash(int chave) {
        return chave % tam;
    }

    public int THEA_inserir(int chave, int valor) {
        int h = THEA_Hash(chave);

        while (tabelaHash[h].estado == Estado.E_OCUPADO) {
            if (tabelaHash[h].chave == chave) {
                return -1; // Chave já existe
            }
            h = (h + 1) % tam; // Tentativa de sondagem linear
        }

        tabelaHash[h].chave = chave;
        tabelaHash[h].valor = valor;
        tabelaHash[h].estado = Estado.E_OCUPADO;

        return h; // Índice onde a chave foi inserida
    }
    
    public int THEA_Buscar(int chave) {
        int k = 0;
        int h = THEA_Hash(chave);
        int h_inicial = h;

        while (tabelaHash[h].estado != Estado.E_LIVRE) {
            if (tabelaHash[h].estado == Estado.E_OCUPADO && tabelaHash[h].chave == chave) {
                return h; // Retorna o índice se a chave for encontrada
            }

            k++;
            h = (h + 1) % tam; // Sondagem linear

            if (h_inicial == h) {
                return -1; // Retorna -1 se a chave não for encontrada após uma iteração completa
            }
        }
        return -1; // Retorna -1 se a chave não for encontrada
    }
    
    public void THEA_remover(int chave) {
    int posicao = THEA_Buscar(chave);

    if (posicao != -1) {
        tabelaHash[posicao].estado = Estado.E_APAGADO;
    }
}

    
    public void mostrarTabela() {
        for (int i = 0; i < tam; i++) {
            if (tabelaHash[i].estado == Estado.E_OCUPADO) {
                System.out.println("Posição " + i + ": Chave " + tabelaHash[i].chave);
            } else if (tabelaHash[i].estado == Estado.E_LIVRE) {
                System.out.println("Posição " + i + ": Vazia");
            } else {
                System.out.println("Posição " + i + ": Apagada");
            }
        }
    }
}