/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Stack;

/**
 *
 * @author Lenon
 */
public class Pilha {

    public Stack<String> pilhaEsquerda = new Stack<String>();
    public Stack<String> pilhaDireita = new Stack<String>();

    public Stack<String> getPilhaDireita() {
        return pilhaDireita;
    }

    public Stack<String> getPilhaEsquerda() {
        return pilhaEsquerda;
    }

    public String voltar() {
        pilhaDireita.push(pilhaEsquerda.pop());
        String urlAnterior = pilhaEsquerda.pop();
        return urlAnterior;

    }

    public String avancar() {
        pilhaEsquerda.push(pilhaDireita.pop());
        String urlProxima = pilhaEsquerda.pop();
        return urlProxima;
    }

    public void limparPilhaDireita() {
        while (!pilhaDireita.empty()) {
            String lixo = pilhaDireita.pop();
        }
    }

}
