import java.time.LocalDate;
public class message extends billet {
    private String contenu;
    public message(LocalDate datePub, String auteur, String contenu)
    {
        super(datePub,auteur);
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

}
