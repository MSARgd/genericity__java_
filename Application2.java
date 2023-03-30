package Code.Genericite;

import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void menu(){
        System.out.println("1. Afficher la liste des clients");
        System.out.println("2. Rechercher un client par son id");
        System.out.println("3. Ajouter un nouveau client dans la liste");
        System.out.println("4. Supprimer un client par id");
        System.out.println("5. Sauvegarder les clients");
        System.out.println("6. Quitter ce programme");
    }
    public static void main(String[] args) throws Exception {
        int t;
        Scanner sc = new Scanner(System.in);
        MetierClientImpl mCI = new MetierClientImpl();
        while (true) {
            menu();
            t = sc.nextInt();
            switch (t){
                case 1 :
                    List<Client> clients =  mCI.getAll();
                    for (Client c : clients){
                        System.out.println(c.toString());
                    }
                    break;
                case 2 :
                    System.out.print("entrer L'id du client : ");
                    Client clt = mCI.findById(sc.nextInt());
                    System.out.println("la Client " +(clt != null ? clt.toString()
                            :  "n'existe pas "));
                    break;
                case 3 :
                    Client cltc = new Client();
                    System.out.print("id : ");
                    cltc.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("nom : ");
                    cltc.setNom(sc.nextLine());
                    System.out.print("prenom : ");
                    cltc.setPrenom(sc.nextLine());
                    System.out.print("address : ");
                    cltc.setAdresse(sc.nextLine());
                    System.out.print("tel : ");
                    cltc.setTel(sc.nextLine());
                    System.out.print("email : ");
                    cltc.setEmail(sc.nextLine());
                    mCI.add(cltc);
                    break;
                case 4 :
                    System.out.print("Enter l' id :");
                    mCI.delete(sc.nextInt()); break;
                case 5 : mCI.saveAll(); break;
                default: System.exit(1); break;

            }
        }
    }
}

