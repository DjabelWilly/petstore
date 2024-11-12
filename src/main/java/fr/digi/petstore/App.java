package fr.digi.petstore;


import fr.digi.petstore.entites.*;
import fr.digi.petstore.enums.FishLivEnv;
import fr.digi.petstore.enums.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        // Crée une EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("traitement");
        EntityManager em = emf.createEntityManager();

        // Démarre une transaction
        em.getTransaction().begin();

        // création d'un HashSet de produits
        Product product1 = new Product();
        product1.setCode("P001");
        product1.setLabel("machin");
        product1.setType(ProdType.FOOD);  // Exemple de type de produit
        product1.setPrice(19.99);

        Product product2 = new Product();
        product2.setCode("P002");
        product2.setLabel("lala Toy");
        product2.setType(ProdType.ACCESSORY);   // Exemple de type de produit
        product2.setPrice(9.99);

        Product product3 = new Product();
        product3.setCode("P003");
        product3.setLabel("super shampoo");
        product3.setType(ProdType.CLEANING);   // Exemple de type de produit
        product3.setPrice(19.99);

        Product product4 = new Product();
        product4.setCode("P004");
        product4.setLabel("beef bites");
        product4.setType(ProdType.FOOD);   // Exemple de type de produit
        product4.setPrice(35.99);

        HashSet<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        // Création d'adresses
        Address address = new Address("1", "rue toto", "13000", "Marseille");
        Address address2 = new Address("2", "place du marché", "30000", "Nîmes");
        Address address3 = new Address("13", "rue de la paix", "34000", "Montpellier");

        // Création de PetStores
        PetStore store = new PetStore();
        store.setName("Zoo Land");
        store.setManagerName("Joe Toto");
        store.setProducts(products);
        store.setAdress(address);

        PetStore store2 = new PetStore();
        store2.setName("Zanimo");
        store2.setManagerName("Jane Doe");
        store2.setProducts(products);
        store2.setAdress(address2);

        PetStore store3 = new PetStore();
        store3.setName("Yatoo shop");
        store3.setManagerName("Mike Mayers");
        store3.setProducts(products);
        store3.setAdress(address3);

        // création d'animaux
        Cat cat = new Cat(null, LocalDate.of(2024, 1, 1), "black", store, "123GH5434");
        Cat cat2 = new Cat(null, LocalDate.of(2023, 4, 12), "grey", store2, "9987ZY434");
        Cat cat3 = new Cat(null, LocalDate.of(2024, 5, 18), "white", store3, "12XXRE56434");
        Fish fish = new Fish(null, LocalDate.of(2024, 1, 1), "blue", store, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(null, LocalDate.of(2023, 4, 12), "red", store2, FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(null, LocalDate.of(2024, 6, 11), "green", store3, FishLivEnv.SEA_WATER);


        // Persiste les produits, les Store, les animaux et adresses
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(address);
        em.persist(address2);
        em.persist(address3);
        em.persist(store);
        em.persist(store2);
        em.persist(store3);
        em.persist(cat);
        em.persist(cat2);
        em.persist(cat3);
        em.persist(fish);
        em.persist(fish2);
        em.persist(fish3);

        // Valide la transaction
        em.getTransaction().commit();

        // Ferme l'EntityManager et l'EntityManagerFactory
        em.close();
        emf.close();
    }
}