package Code.Genericite;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetier<T> {

    public T add(T o);
    public List<T> getAll() throws IOException, ClassNotFoundException;
    public T findById(long id);
    public void delete(long id);
    public void saveAll() throws IOException;












//    déclarer les méthodes pour gérer nos entités Produit et Client
}
