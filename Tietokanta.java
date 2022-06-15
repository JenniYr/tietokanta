package tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* Luo yhteyden tietokantaan.
* Host muuttuu joka kerta ohjelmaa uudestaan käynnistäessä, tarkista oikea osoite pgadminista
* 
* @author jenni yrjänä
* @version 19 Apr 2021
*/
public class Tietokanta {
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Tietokanta DB = new Tietokanta();
        System.out.println(DB.getConnection());
    }
    /**
     * @return jotain
     * 
     */
    public Connection getConnection() {
        
        Connection connection = null;
        
        try {
            
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.8.131"
                    + ":5432/tjta3501","jenni","jenni");
            
            if (connection != null) {
                System.out.println("Connection ok");
            }else {
                System.out.println("Connection failed");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;

    }

}
