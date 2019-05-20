/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import service.Atributos;

/**
 *
 * @author lenon.060194
 */
public class Nos {

    ArrayList<Nos> noChildren = new ArrayList<Nos>();
    ArrayList<Atributos> atributos = new ArrayList<Atributos>();
    String nameTag;
    String atributosTag;
    String texto;

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

    public ArrayList<Atributos> getAtributos() {
        return atributos;
    }
}
