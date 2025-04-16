interface MealPlan {
    void showMeal();
}

class VegetarianMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegetarian Meal Plan");
    }
}

class VeganMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Vegan Meal Plan");
    }
}

class KetoMeal implements MealPlan {
    public void showMeal() {
        System.out.println("Keto Meal Plan");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;
    Meal(T mealPlan) { this.mealPlan = mealPlan; }
    public T getMealPlan() { return mealPlan; }
}

public class MealPlanner {
    public static <T extends MealPlan> void generateMeal(Meal<T> meal) {
        System.out.print("Generated: ");
        meal.getMealPlan().showMeal();
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarian = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());

        generateMeal(vegetarian);
        generateMeal(vegan);
        generateMeal(keto);
    }
}
