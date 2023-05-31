package com.example.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class TestDishCollectionUsingStreamAPI {

	public static void getDishesSortedForCaloriesLessThan400(List<Dish> menu) {
	    List<Dish> sortedDishes = menu.stream()
	            .filter(dish -> dish.getCalories() < 400)
	            .sorted(Comparator.comparingInt(Dish::getCalories))
	            .collect(Collectors.toList());

	    System.out.println(sortedDishes);
	}

	public static void getDishWithMaximumCalories(List<Dish> menu) {
	    Dish dishWithMaxCalories = menu.stream()
	            .max(Comparator.comparingInt(Dish::getCalories))
	            .orElse(null);

	    System.out.println(dishWithMaxCalories);
	}

	public static void skip2AndLimit3Dishes(List<Dish> menu) {
	    List<Dish> skippedAndLimitedDishes = menu.stream()
	            .skip(2)
	            .limit(3)
	            .collect(Collectors.toList());

	    System.out.println(skippedAndLimitedDishes);
	}

	public static void getTwoMeatDishes(List<Dish> menu) {
	    List<Dish> meatDishes = menu.stream()
	            .filter(dish -> dish.getType() == Dish.Type.MEAT)
	            .limit(2)
	            .collect(Collectors.toList());

	    System.out.println(meatDishes);
	}

	public static void getVegetarianDishes(List<Dish> menu) {
	    List<Dish> vegetarianDishes = menu.stream()
	            .filter(Dish::isVegetarian)
	            .collect(Collectors.toList());

	    System.out.println(vegetarianDishes);
	}

	public static void printAllDishTypes() {
	    Arrays.stream(Dish.Type.values())
	            .forEach(System.out::println);
	}


	public static void printSumofCalories(List<Dish> menu) {
	    int sumOfCalories = menu.stream()
	            .mapToInt(Dish::getCalories)
	            .reduce(0, Integer::sum);

	    System.out.println("Sum of calories: " + sumOfCalories);
	}

	public static void printSumofCalories1(List<Dish> menu) {
	    int sumOfCalories = menu.stream()
	            .mapToInt(Dish::getCalories)
	            .sum();

	    System.out.println("Sum of calories: " + sumOfCalories);
	}

	public static void anyDishwithCaloriesLess400(List<Dish> menu) {
	    boolean anyDishWithCaloriesLess400 = menu.stream()
	            .anyMatch(dish -> dish.getCalories() < 400);

	    System.out.println("Any dish with calories less than 400: " + anyDishWithCaloriesLess400);
	}

	public static void anyDishwithCalories1Less400(List<Dish> menu) {
	    boolean anyDishWithCaloriesLess400 = menu.stream()
	            .filter(dish -> dish.getCalories() < 400)
	            .findFirst()
	            .isPresent();

	    System.out.println("Any dish with calories less than 400: " + anyDishWithCaloriesLess400);
	}

	public static void printTotalCaloriesofEveryDish(List<Dish> menu) {
	    menu.stream()
	            .forEach(dish -> System.out.println(dish.getName() + ": " + dish.getCalories()));
	}

	public static void printTotalCaloriesofEveryDish1(List<Dish> menu) {
	    for (Dish dish : menu) {
	        System.out.println(dish.getName() + ": " + dish.getCalories());
	    }
	}




	public static void main(String[] args) {
		List<Dish> menu = Dish.getDishes();
		 System.out.println(menu);
		 getDishesSortedForCaloriesLessThan400(menu);

		 printTotalCaloriesofEveryDish(menu);
		 printTotalCaloriesofEveryDish1(menu);
		 printSumofCalories(menu);
		 printSumofCalories1(menu);
		 getVegetarianDishes(menu);
		 anyDishwithCaloriesLess400(menu);
		 anyDishwithCalories1Less400(menu);
		 getVegetarianDishes(menu);
		 getDishWithMaximumCalories(menu);
		 getDishesSortedForCaloriesLessThan400(menu);
		 getDishWithMaximumCalories(menu);
		 skip2AndLimit3Dishes(menu);
		 getTwoMeatDishes(menu);
	}
}