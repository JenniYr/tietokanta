package tietokanta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Luokan nimest‰ huolimatta ohjelmalla pystyy tekem‰‰n kyselyj‰, luomaan taulun ja lis‰‰m‰‰n tauluun tavaraa.
 * Ohjelma on todella yksinkertainen, mutta siin‰ pit‰isi olla kaikki toiminnallisuudet mit‰ teht‰v‰nannossa vaadittiin.
 * T‰ss‰ olisi hauska projekti jatkaa ohjelmaa pidemm‰llekin.
 * @author jenni yrj‰n‰
 * @version 21 Apr 2021
 */
public class CreateTable {

    /**
     * @param args
     */
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        Tietokanta DB = new Tietokanta();
        connection = DB.getConnection();
        ResultSet rs =null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String valinta;
        boolean trampoliini = true;


        try {
            while(trampoliini) {
                System.out.println();
                System.out.println("Halutko: \n 1. Kirjoittaa kyselyn? (Paina 1 ja enter) \n 2. Luoda taulun? (Paina 2 ja enter) \n 3. Lis‰t‰ jotain tauluun? (Paina 3 ja enter) \n 4. exit");
                valinta = br.readLine();
                switch(valinta) {
                case "1": // Lukee taulusta tietoja

                    System.out.println("Kirjoita t‰h‰n k‰sky: ");
                    String query = br.readLine();
                    statement = connection.createStatement();
                    rs = statement.executeQuery(query);

                    ResultSetMetaData rsMetaData = rs.getMetaData();
                    int columns = rsMetaData.getColumnCount();
                    while(rs.next()) {
                        System.out.println();
                        for(int i = 1; i<=columns; i++) {
                            System.out.print(rs.getString(i) + " "); 
                        }}
                    break;
                case "2": // Uuden taulun luonti
                    System.out.println("Kirjoita t‰h‰n k‰sky: ");
                    query = br.readLine();
                    statement = connection.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("VALMIS!");
                    break;
                case "3": // Tauluun lis‰‰minen
                    System.out.println("Kirjoita t‰h‰n k‰sky: ");
                    query = br.readLine();
                    statement = connection.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("VALMIS!");
                    break;
                case "4": // Sulkee yhteyden sek‰ antaa viestin yhteyden sulkeutumisesta
                    connection.close();
                    System.out.println("Yhteys suljettu, voit sulkea ohjelman.");
                    trampoliini = false;
                    break;
                default:
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}