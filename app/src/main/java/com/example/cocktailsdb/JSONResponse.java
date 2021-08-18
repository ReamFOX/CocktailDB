package com.example.cocktailsdb;

public class JSONResponse {
    private final Drinks[] drinks;

    public JSONResponse(Drinks[] drinks) {
        this.drinks = drinks;
    }

    public Drinks[] getDrinks() {
        return drinks;
    }
}
