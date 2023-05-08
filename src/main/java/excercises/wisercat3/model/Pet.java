package excercises.wisercat3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    /*@GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCode;*/

    private String idCode;

    @Column(name = "NAME", length = 100)
    private String name;


    private String animal;

    private String color;

    private String country;

    public Pet(Integer id, String idCode, String name, String animal, String color, String country, User user) {
        this.id = id;
        this.idCode = idCode;
        this.name = name;
        this.animal = animal;
        this.color = color;
        this.country = country;
        this.user = user;
    }

    public Pet(){}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getIdCode() {
        return idCode;
    }
}