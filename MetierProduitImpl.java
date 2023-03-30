package Code.Genericite;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MetierProduitImpl implements IMetier<Produit>{
    private String pathFileProduit="produits.dat";
    private List<Produit> produitsList = new ArrayList<>();

    public MetierProduitImpl(String pathFileProduit) {
        this.pathFileProduit = pathFileProduit;
    }

    public MetierProduitImpl() {
    }

    @Override
    public Produit add(Produit o) {
        produitsList.add(o);
        return  o;
    }

    @Override
    public List<Produit> getAll() throws IOException, ClassNotFoundException {


        File fP = new File(pathFileProduit);
        FileInputStream fisP = new FileInputStream(fP);
        ObjectInputStream oisP = new ObjectInputStream(fisP);
        try {
            while (oisP.readObject() != null){

                Produit p = (Produit) oisP.readObject();
                produitsList.add(p);
            }
        }
        catch (Exception e){

        }
        fisP.close();
        oisP.close();
        return produitsList;

    }

    @Override
    public Produit findById(long id) {
        for(Code.Genericite.Produit el :produitsList){
            if(el.getId() == id){
                return el;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        for(Code.Genericite.Produit el :produitsList){
            if(el.getId() == id){
                produitsList.remove(id);
            }
        }
    }

    @Override
    public void saveAll() throws IOException {
        File fsP = new File(pathFileProduit);
        FileOutputStream fosP = new FileOutputStream(fsP);
        ObjectOutputStream oosP = new ObjectOutputStream(fosP);
        for(Produit p : produitsList){
            oosP.writeObject(p);

        }
        oosP.close();
        fosP.close();

    }
}
