package animals;

public abstract class Animal{
    private String name;
    private int age;
    private String gender;

    protected Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.gender = gender;
    }

    private void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }


    public abstract String produceSound();

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s"
        , this.getClass().getSimpleName()
        , this.getName()
        , this.getAge()
        , this.getGender()
        , this.produceSound());
    }
}
