import java.time.LocalDate;

public class blog {
    private String titre;
    private publiable[] lbillets;
    private int nbbillet;

    public blog(String titre, int capacité) {
        this.titre = titre;
        this.lbillets = new publiable[capacité];
        this.nbbillet = 0;
    }

    public void post(publiable billet) throws InvalidURLException {
        if (billet instanceof video) {
            video v = (video) billet;
            if (!v.getUrl().startsWith("https")) {
                throw new InvalidURLException("lurl de la vidéo doit commencer par https.");
            }
        }
        if (nbbillet < lbillets.length) {
            lbillets[nbbillet] = billet;
            nbbillet++;
        } else {
            System.out.println("plein.");
        }
    }
    public int getNombreBilletsTaggables() {
        int count = 0;
        for (int i = 0; i < nbbillet; i++) {
            if (lbillets[i] instanceof taggable) {
                count++;
            }
        }
        return count;
    }
    public publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
        publiable[] result = new publiable[nbbillet];
        int index = 0;
        for (int i = 0; i < nbbillet; i++) {
            if (lbillets[i] instanceof taggable && lbillets[i].getAuteur().equals(auteur)) {
                result[index++] = lbillets[i];
            }
        }
        return java.util.Arrays.copyOf(result, index);
    }

    public publiable getPlusRécentBillet() {
        publiable dernierBillet = null;
        for (int i = 0; i < nbbillet; i++) {
            if (dernierBillet == null || lbillets[i].getDatePublication().isAfter(dernierBillet.getDatePublication())) {
                dernierBillet = lbillets[i];
            }
        }
        return dernierBillet;
    }
    public publiable[] RechercheBilletsParContenu(String[] mots) {
        publiable[] result = new publiable[nbbillet];
        int index = 0;
        for (int i = 0; i < nbbillet; i++) {
            if (lbillets[i] instanceof message) {
                message m = (message) lbillets[i];
                boolean containsAllWords = true;
                for (String mot : mots) {
                    if (m.getContenu().indexOf(mot) == -1) {
                        containsAllWords = false;
                        break;
                    }
                }
                if (containsAllWords) {
                    result[index++] = lbillets[i];
                }
            }
        }
        return java.util.Arrays.copyOf(result, index);
    }
}
