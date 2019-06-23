package service;

import java.util.Stack;

/**
 * Classe Pilha, é reponsavel em armazenar os sites acessados, podendo ir e
 * voltar no navegador
 *
 * @author Estêvão Anderle, Lenon de Paula
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

    /**
     * Metodo faz a troca de url entre as pilhas
     *
     * @return Retorna a url anterior
     */
    public String voltar() {
        pilhaDireita.push(pilhaEsquerda.pop());
        String urlAnterior = pilhaEsquerda.pop();
        return urlAnterior;

    }

    /**
     * Metodo faz a troca de url entre as pilhas
     *
     * @return Retorna a próxima url
     */
    public String avancar() {
        pilhaEsquerda.push(pilhaDireita.pop());
        String urlProxima = pilhaEsquerda.pop();
        return urlProxima;
    }

    /**
     * Metodo esvazia a pilha da direira sempre chamado quando for acessado um
     * novo site no navegador
     */
    public void limparPilhaDireita() {
        while (!pilhaDireita.empty()) {
            String lixo = pilhaDireita.pop();
        }
    }

}
