///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package model.dao;
//
//import java.sql.DataTruncation;
//import model.bean.Usuario;
//import model.bean.Historico;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Lenon
// */
//public class historicoDAOTest {
//
//    public historicoDAOTest() {
//    }
//
//    @Test
//    public void inserirHistorico() {
//        Usuario u = new Usuario();
//        u.setId(1);
//
//        Historico h = new Historico();
//        h.setPagina("google");
//        h.setUrl("www.google.com");
//        h.setId_usuario(u);
//
//        //VERIFICAR
//        //h.setData_acesso();
//        h.setFavorito(true);
//
//        historicoDAO dao = new historicoDAO();
//    }
//
//    @Test
//    public void obter() {
//        historicoDAO dao = new historicoDAO();
//        for (Historico his : dao.getAll()) {
//            System.out.println(his.getId());
//            System.out.println(his.getPagina());
//            System.out.println(his.getUrl());
//            System.out.println(his.getId_usuario().getId());
//            System.out.println(his.isFavorito());
//        }
//    }
//
//}
