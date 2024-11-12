package fr.digi.petstore.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ANIMAL")
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BIRTH_DATE")
    private LocalDate birth;

    @Column(name = "COLOR")
    private String color;

    // Relation avec PetStore
    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    public Animal() {}

    public Animal(LocalDate birth, String color, PetStore petStore) {
        this.birth = birth;
        this.color = color;
        this.petStore = petStore;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", color='").append(color).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(birth, animal.birth) && Objects.equals(color, animal.color) && Objects.equals(petStore, animal.petStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birth, color, petStore);
    }
}
