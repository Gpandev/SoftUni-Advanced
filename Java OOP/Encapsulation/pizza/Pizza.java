package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();

    }

    private void setToppings (int numberOfToppings) {
        Validator.validateNumberOfToppings(numberOfToppings);
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    public void setDough(Dough dough){

        this.dough = dough;
    }

    public String getName(){
        return this.name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {

        return dough.calculateCalories() +
                this.toppings
                        .stream()
                        .mapToDouble(Topping::calculateCalories)
                        .sum();
    }
}
