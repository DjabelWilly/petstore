package fr.digi.petstore.entites;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGER_NAME")
    private String managerName;

    // Relation avec Product
    @ManyToMany
    @JoinTable(name = "STORE_PRODUCT",
            joinColumns = @JoinColumn(name = "PETSTORE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    )
    private Set<Product>products;

    // Relation avec Animal
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;

    // Relation avec Adress
    @OneToOne
    @JoinColumn(name = "ADRESS_ID")
    private Address adress;

    public PetStore() {
    }

    public PetStore(String name, String managerName, Set<Product> products, Set<Animal> animals) {
        this.name = name;
        this.managerName = managerName;
        this.products = products;
        this.animals = animals;
    }

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", products=").append(products);
        sb.append(", animals=").append(animals);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetStore petStore = (PetStore) o;
        return Objects.equals(id, petStore.id) && Objects.equals(name, petStore.name) && Objects.equals(managerName, petStore.managerName) && Objects.equals(products, petStore.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, managerName, products, animals);
    }
}
