package model;

import java.util.ArrayList;
import java.util.List;

// Dictionary of LP problem
public class Dictionary {
    private List<List<Double>> basicVariables;
    private List<Double> objectiveFunction;

    // EFFECTS: constructs empty dictionary with empty list of basic variables and objective function
    public Dictionary() {
        basicVariables = new ArrayList<>();
        objectiveFunction = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: set basic variables to given list of basic variables
    public void setBasicVariables(List<List<Double>> list) {
        this.basicVariables = list;
    }

    // MODIFIES: this
    // EFFECTS: set objective function to give objective function
    public void setObjectiveFunction(List<Double> list) {
        this.objectiveFunction = list;
    }

    // EFFECTS: returns list of basic variables
    public List<List<Double>> getBasicVariables() {
        return basicVariables;
    }

    // EFFECTS: returns objective function
    public List<Double> getObjectiveFunction() {
        return objectiveFunction;
    }
}