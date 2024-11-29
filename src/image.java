import java.time.LocalDate;
public class image extends billettaggable{
    private String url;
    public image(LocalDate datePub, String auteur, int capacité, String url) {
        super(datePub, auteur, capacité);
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    @Override
    public String toString() {
        return "image ["+ super.toString()+", url= " + url + "]";
    }

}