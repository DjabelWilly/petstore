package fr.digi.petstore.entites;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    @OneToOne
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    public Address() {
    }

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;

    }

    // Getters, Setters
    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", petStore=").append(petStore);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(number, address.number) && Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode) && Objects.equals(city, address.city) && Objects.equals(petStore, address.petStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, street, zipCode, city, petStore);
    }
}
