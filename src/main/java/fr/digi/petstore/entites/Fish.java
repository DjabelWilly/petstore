package fr.digi.petstore.entites;

import fr.digi.petstore.enums.FishLivEnv;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "FISH")
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(Long id, LocalDate birth, String color, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, color, petStore);
        this.livingEnv = livingEnv;
    }

    // Getter et Setter
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return livingEnv == fish.livingEnv;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingEnv);
    }
}
