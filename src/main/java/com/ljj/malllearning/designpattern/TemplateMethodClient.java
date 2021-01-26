package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public class TemplateMethodClient {
    public static void main(String[] args) {

        Meal meal = new Meal();
        meal.order();
        AfternoonTea afternoonTea = new AfternoonTea();
        afternoonTea.order();


    }
}
