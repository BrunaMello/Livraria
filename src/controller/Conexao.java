package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String
            DATABASE = "Livraria";
    private static final String
            HOST = "localhost:3306";
    private static final String
            DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String
            TIMEZONE = "useTimezone=true&serverTimezone=UTC";
    private static final String
            URL = "jdbc:mysql://"+HOST+"/"+DATABASE+"?"+TIMEZONE;
    private static final String
            USR = "root";
    private static final String
            PWD = "#Bru011991";

    public static Connection Conectar() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USR, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public static void Desconectar(Connection con){
        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        if (Conectar() != null){
            System.out.println("Conexao realizada com sucesso!");
        }
    }
}
