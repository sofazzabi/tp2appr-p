import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializerPersonne {
  public static void main(final String argv[]) {

    ObjectInputStream ois = null;

    try {
      final FileInputStream fichier = new FileInputStream("personne.ser");
      ois = new ObjectInputStream(fichier);
      final Personne personne = (Personne) ois.readObject();
      System.out.println("Personne : ");
      System.out.println("nom : " + personne.getNom());
      System.out.println("prenom : " + personne.getPrenom());
      System.out.println("taille : " + personne.getTaille());
      System.out.println("valeur : " + personne.valeur);
      System.out.println("valeur : " + Personne.x);
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