package com.example.cocktailsdb;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search.php")
    Call<JSONResponse> getCocktail(@Query("s") String name);

    @GET("random.php")
    Call<JSONResponse> getRandom();

}
