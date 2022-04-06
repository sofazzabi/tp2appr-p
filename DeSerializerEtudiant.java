import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializerEtudiant {
    public static void main(final String argv[]) {

        ObjectInputStream ois = null;

        try {
            final FileInputStream fichier = new FileInputStream("personne.ser");
            ois = new ObjectInputStream(fichier);
            final Etudiant etudiant = (Etudiant) ois.readObject();
            System.out.println("Personne : ");
            System.out.println("nom : " + etudiant.getNom());
            System.out.println("prenom : " + etudiant.getPrenom());
            System.out.println("taille : " + etudiant.getTaille());
            System.out.println("valeur : " + etudiant.valeur);
            System.out.println("spec : " + etudiant.getSpec());
            System.out.println(etudiant.monCb.afficher());

        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
