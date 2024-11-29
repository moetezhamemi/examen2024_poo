import java.time.LocalDate;

public class billettaggable extends billet implements taggable{
    protected String ltags[];
    protected   int nbtags;
    public billettaggable(LocalDate datePub, String auteur, int capacité)
    {
        super(datePub,auteur);
         ltags = new String[capacité];
        nbtags = 0;
    }
    public String toString()
    {
        String c;
        String l = " ";
        for(int i = 0;i<ltags.length;i++)
        {
            l =l + " " +  ltags[i];
        }
        c = "local date" + datepub + "auteur : " + auteur + "liste tag : " +  l;
        return c;
    }


    @Override
    public void ajoutTag(String tag) {
        boolean b = false;
        for (int i = 0;i<nbtags;i++)
        {
            if(ltags[i].compareTo(tag) == 0)
                b = true;
        }
        if(b == false)
        {
            ltags[nbtags] = tag;
            nbtags++;
        } else if (b == true) {
            System.out.println("tag deja existe");

        }

    }
    @Override
    public void supprimeTag(String tag) {
        for (int i = 0;i< nbtags;i++)
        {
            if(ltags[i].compareTo(tag) == 0)
                for(int j = i;i< nbtags - 1;j++)
                {
                    ltags[j] = ltags[j+1];
                }
        }
        ltags[nbtags] = null;
        nbtags--;
    }
    @Override
    public int nombreTags() {
        return nbtags;
    }
    @Override
    public int rechercheTag(String tag) {
        for(int i = 0;i<nbtags;i++)
        {
            if(ltags[i].compareTo(tag) == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
