import java.time.LocalDate;
public class  video extends billettaggable{
    private String url;
    public video(LocalDate datePub, String auteur, int capacité, String url) {
        super(datePub, auteur, capacité);
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    @Override
    public String toString() {
        return "Video [ "+ super.toString()+ ", url=" + url + "]";

}
}