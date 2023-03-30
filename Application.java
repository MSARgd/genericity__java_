package Code.Genericite;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void menu(){
        System.out.println("1. Afficher la liste des produits");
        System.out.println("2. Rechercher un produit par son id");
        System.out.println("3. Ajouter un nouveau produit dans la liste");
        System.out.println("4. Supprimer un produit par id");
        System.out.println("5. Sauvegarder les produits");
        System.out.println("6. Quitter ce programme");
    }
    public static void main(String[] args) throws Exception {
        int t;
        Scanner sc = new Scanner(System.in);
        MetierProduitImpl mPI = new MetierProduitImpl();
        while (true) {
            menu();
            t = sc.nextInt();
            switch (t){
                case 1 :
                        List<Produit>  produits = mPI.getAll();
                        for (Produit p : produits){
                            System.out.println(p.toString());
                        }
                        break;
                case 2 :
                        System.out.print("entrer L'id du produit : ");
                        Produit pc = mPI.findById(sc.nextInt());
                        System.out.println("la prouit " +(pc != null ? pc.toString()
                            :  "n'existe pas "));
                        break;
                case 3 :
                    Produit p = new Produit();
                    System.out.print("id : ");
                    p.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("nom : ");
                    p.setNom(sc.nextLine());
                    System.out.print("marque : ");
                    p.setMarque(sc.nextLine());
                    System.out.print("prix : ");
                    p.setPrix(sc.nextFloat());
                    sc.nextLine();
                    System.out.print("description : ");
                    p.setDescription(sc.nextLine());
                    System.out.print("nb en stocke : ");
                    p.setNbStocke(sc.nextInt());
                    sc.nextLine();
                    mPI.add(p);
                    break;
                case 4 :
                        System.out.print("Enter l' id :");
                        mPI.delete(sc.nextInt()); break;
                case 5 : mPI.saveAll(); break;
                default: System.exit(1); break;

            }
        }
    }
}