import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;



public class SerializerEtudiant {

    public static void main(final String argv[]) {
        Adresse ad1=new Adresse("habib bourguiba",2000);
        CompteBancaire cb1=new CompteBancaire(1500,1248,ad1);
        final Etudiant etudiant = new Etudiant("Dupond", "Jean", 175,"GL",cb1);
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream("personne.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(etudiant);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}