/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author estev
 */
public class Log {

    private PrintWriter out;
    private File file = new File("Log.txt");

    public Log() {
        try {
            if (!file.exists()) {
                file.createNewFile();
                out = new PrintWriter(new FileWriter(file), true);
            } else {
                out = new PrintWriter(new FileWriter(file, true));
            }
        } catch (IOException e) {
            /*
            * Se der algum erro com o arquivo de log, imprime a stacktrace no console, mas a
            * aplicação continua funcionando
             */
            e.printStackTrace();
        }
    }

    public void gravaErro(Throwable erro) {
        try {
            if (!file.exists()) {
                file.createNewFile();
                out = new PrintWriter(new FileWriter(file, true));
            } else {
                out = new PrintWriter(new FileWriter(file, true));
            }

            //Imprime o log
            out.print("Data do erro: ");
            out.println(new Date());
            out.print("Mensagem de erro: ");
            out.println(erro);
            out.print("Stacktrace: ");
            erro.printStackTrace(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
