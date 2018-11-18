package kata5p2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import Kata5p2.model.Histogram;
import Kata5p2.model.Mail;
import Kata5p2.view.HistogramDisplay;
import Kata5p2.view.MailHistogramBuilder;
import Kata5p2.view.MailListReader;
import java.sql.SQLException;
import kata5p2.view.MailListReaderBD;

public class Kata5P2 {

   private List<Mail> mailList;
   private Histogram<String> histogram;
   private HistogramDisplay histoDisplay;
   public static void main(String[] args) {
       Kata5P2 kata4 = new Kata5P2();
 
       try {
           kata4.execute();
       }catch (ClassNotFoundException e) {
           System.out.println("Error al conectar con la base de datos: " + e.getMessage());
       }catch (IOException e) {
           System.out.println("Error de entrada salida: " + e.getMessage());
       }catch (SQLException ex) {
           System.out.println("Error de SQL:" + ex.getMessage());
        }
    }
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    public void input() throws IOException, ClassNotFoundException, SQLException {
        mailList = MailListReaderBD.read();
    }
    public void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}