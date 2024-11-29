import java.time.LocalDate;
public class billet implements publiable{
    protected LocalDate datepub;
    protected String auteur;
    public billet(LocalDate datePub, String auteur)
    {
        this.auteur = auteur;
        this.datepub = datePub;
    }
    public String toStriing()
    {
        String c;
        c = "date publication : " + datepub + " auteur: " + auteur;
        return c;
    }

    @Override
    public LocalDate getDatePublication() {
        return datepub;
    }
    @Override
    public String getAuteur() {
        return auteur;
    }
}
