package excercises.wisercat3.dto;


public record PetDTO (

        Integer id,

        String idCode,

        String name,

        String animal,

        String color,

        String country


){

    @Override
    public Integer id() {
        return id;
    }

    public String idCode() {
        return idCode;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String animal() {
        return animal;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public String country() {
        return country;
    }
}
