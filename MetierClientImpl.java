package Code.Genericite;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class MetierClientImpl implements IMetier<Client>{
    private String pathFileClient="clients.dat";
    private List<Client> clientList = new ArrayList<>();
    @Override
    public Client add(Client o) {
        clientList.add(o);
        return  o;

    }

    @Override
    public List<Client> getAll() throws IOException, ClassNotFoundException {
        File fP = new File(pathFileClient);
        FileInputStream fisP = new FileInputStream(fP);
        ObjectInputStream oisP = new ObjectInputStream(fisP);
        try {
            while (oisP.readObject() != null){
                Client c = (Client) oisP.readObject();
                clientList.add(c);
            }


        }
        catch (Exception e){

        }
        return clientList;
    }

    @Override
    public Client findById(long id) {
        for(Client el :clientList){
            if(el.getId()== id){
                return el;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        for(Client el :clientList){
            if(el.getId() == id){
                clientList.remove(id);
            }
        }

    }

    @Override
    public void saveAll() throws IOException {
        File fsP = new File(pathFileClient);
        FileOutputStream fosP = new FileOutputStream(fsP);
        ObjectOutputStream oosP = new ObjectOutputStream(fosP);
        for(Client c : clientList){
            oosP.writeObject(c);

        }
        oosP.close();
        fosP.close();

    }
}