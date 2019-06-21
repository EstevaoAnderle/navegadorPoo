/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

/**
 * Classe Nos, onde todo o html e feito o parser instanciando um novo nó
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Nos {

    ArrayList<Nos> noChildren = new ArrayList<Nos>();
    String nameTag;
    String atributosTag;
    String texto;

    /**
     * construtor da classe
     */
    public Nos(String nameTag, String conteudoTag, String texto) {
        this.nameTag = nameTag;
        this.atributosTag = conteudoTag;
        this.texto = texto;
    }

    public ArrayList<Nos> getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(ArrayList<Nos> noChildren) {
        this.noChildren = noChildren;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setAtributosTag(String conteudoTag) {
        this.atributosTag = conteudoTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public String getAtributosTag() {
        return atributosTag;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
