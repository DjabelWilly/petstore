package fr.digi.petstore.entites;

import fr.digi.petstore.enums.ProdType;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRICE")
    private double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<PetStore>petStores;

    public Product() {
    }

    public Product(String code, String label, ProdType type, double price, Set<PetStore> petStores) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petStores = petStores;
    }

    // Getters, Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petStores=").append(petStores);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(label, product.label) && type == product.type && Objects.equals(petStores, product.petStores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, label, type, price, petStores);
    }
}
