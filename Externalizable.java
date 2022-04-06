import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
 
class ExternalizableEtudiant implements Externalizable {
    private int id;
    private Etudiant unEtudiant;


    public ExternalizableEtudiant(){

    }

    @Override
    public String toString() {
        return "l'id est: "+this.id+" et la specialité est  : "+this.unEtudiant.getSpec();
    }

    public ExternalizableEtudiant(int id, Etudiant unEtudiant) {
        this.id = id;
        this.unEtudiant = unEtudiant;
    }



    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(unEtudiant);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.unEtudiant = (Etudiant) in.readObject();
    }

}

class ExternalizableExample {
private final static String OUTPUT_FILE = "externalizable_file";
     
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableEtudiant test = new ExternalizableEtudiant(53, new Etudiant("Azzabi","Sofiene",18,"GL",new CompteBancaire(1200,1818,new Adresse("Soukra",2080))));

 

        FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        test.writeExternal(objectOutputStream);
 

        objectOutputStream.flush();
        outputStream.close();
 

        ExternalizableEtudiant copyOfEtudiant = new ExternalizableEtudiant();
 
        FileInputStream inputStream = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        copyOfEtudiant.readExternal(objectInputStream);
 


        objectInputStream.close();
        inputStream.close();
        System.out.println(copyOfEtudiant.toString());
    }
}