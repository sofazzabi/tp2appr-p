import java.io.Serializable;

public class CompteBancaire implements Serializable {
    private double solde=0;
    private int code=0;
    private Adresse monadresse=null;
    public CompteBancaire(double solde,int code,Adresse monadresse){
        this.code=code;
        this.monadresse=monadresse;
        this.solde=solde;
    }
    public String afficher(){
        return "le code est : "+ this.code+" l'adresse est : "+this.monadresse.afficher()+" et le sold est : "+this.solde;

    }
}
