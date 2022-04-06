import java.io.Serializable;

public class Adresse implements Serializable {
    Adresse(String rue,int cp){
        this.rue=rue;
        this.cp=cp;
    }
    private String rue="";
    private int cp=0;//code postal
    public String afficher(){
        return"la rue est: "+rue+" et le cp est: "+cp;
    }
}
