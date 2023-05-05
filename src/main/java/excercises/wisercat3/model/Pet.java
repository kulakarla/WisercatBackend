package excercises.wisercat3.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_code;

    @Column(name = "NAME", length = 100)
    private String name;


    private String animal;

    private String color;

    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getId_code() {
        return id_code;
    }

    public void setId_code(UUID id_code) {
        this.id_code = id_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnimal() {
        return animal;
    }

    public String getColor() {
        return color;
    }

    public String getCountry() {
        return country;
    }
}