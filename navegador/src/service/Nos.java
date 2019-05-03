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
    String conteudoTag;

    public Nos(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setConteudoTag(String conteudoTag) {
        this.conteudoTag = conteudoTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public ArrayList<Atributos> getAtributos() {
        return atributos;
    }
}
