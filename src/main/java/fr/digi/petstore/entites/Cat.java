package fr.digi.petstore.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "CAT")
public class Cat extends Animal{

    @Column(name = "CHIP_ID")
    private String chipId;

    public Cat() {}


    public Cat(Long id, LocalDate birth, String color, PetStore petStore, String chipId) {
        super(birth, color, petStore);
        this.chipId = chipId;
    }

    //Getter Setter

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cat{");
        sb.append("chipId='").append(chipId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(chipId, cat.chipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chipId);
    }
}
