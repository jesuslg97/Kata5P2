package Kata5p2.model;

/**
 *
 * @author Jesús López
 */

public class Mail {
    private final String mail;
    
    public String getDomain(){
        return mail.split("@")[1];
    }
    public Mail(String mail) {
        this.mail = mail;
    }
    public String getMail() {
        return mail;
    }   
}
