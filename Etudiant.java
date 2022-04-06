public class Etudiant extends Personne {

    public Etudiant(final String nom, final String prenom, final int taille,final String spec,CompteBancaire cb){
       super(nom,prenom,taille);
        this.spec=spec;
        this.monCb=cb;
    }
    private String spec="";
    public CompteBancaire monCb=null;

    public String getSpec() {
        return this.spec;
    }



}
