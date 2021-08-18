package com.example.cocktailsdb;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cocktailsdb.model.RealmDrink;

import java.util.ArrayList;

import io.realm.Realm;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.MyViewHolder> {
    private static final String TAG = "rvAdapter";
    Realm realm;

    private final ArrayList<Drinks> drinks;
    Context context;


    public rvAdapter(ArrayList<Drinks> drinks, Context context) {
        this.drinks = drinks;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.coctailName.setText(drinks.get(position).getStrDrink());
        Glide
                .with(context)
                .load(drinks.get(position).getStrDrinkThumb())
                .into(holder.coctailImg);



        holder.cardviewC.setOnClickListener(v -> {
            realm = Realm.getDefaultInstance();
            realm.executeTransactionAsync(realm -> {
                    RealmDrink realmDrink = realm.createObject(RealmDrink.class);
                    realmDrink.setName(drinks.get(position).getStrDrink());
                    realmDrink.setThumb(drinks.get(position).getStrDrinkThumb());
                    realmDrink.setInstructions(drinks.get(position).getStrInstructions());
                    realmDrink.setGlass(drinks.get(position).getStrGlass());
                    realmDrink.setAlcoholic(drinks.get(position).getStrAlcoholic());
                    realmDrink.setIngredient1(drinks.get(position).getStrIngredient1());
                    realmDrink.setIngredient2(drinks.get(position).getStrIngredient2());
                    realmDrink.setIngredient3(drinks.get(position).getStrIngredient3());
                    realmDrink.setIngredient4(drinks.get(position).getStrIngredient4());
                    realmDrink.setIngredient5(drinks.get(position).getStrIngredient5());
                    realmDrink.setIngredient6(drinks.get(position).getStrIngredient6());
                    realmDrink.setIngredient7(drinks.get(position).getStrIngredient7());
                    realmDrink.setIngredient8(drinks.get(position).getStrIngredient8());
                    realmDrink.setIngredient9(drinks.get(position).getStrIngredient9());
                    realmDrink.setIngredient10(drinks.get(position).getStrIngredient10());
                    realmDrink.setIngredient11(drinks.get(position).getStrIngredient11());
                    realmDrink.setIngredient12(drinks.get(position).getStrIngredient12());
                    realmDrink.setIngredient13(drinks.get(position).getStrIngredient13());
                    realmDrink.setMeasure1(drinks.get(position).getStrMeasure1());
                    realmDrink.setMeasure2(drinks.get(position).getStrMeasure2());
                    realmDrink.setMeasure3(drinks.get(position).getStrMeasure3());
                    realmDrink.setMeasure4(drinks.get(position).getStrMeasure4());
                    realmDrink.setMeasure5(drinks.get(position).getStrMeasure5());
                    realmDrink.setMeasure6(drinks.get(position).getStrMeasure6());
                    realmDrink.setMeasure7(drinks.get(position).getStrMeasure7());
                    realmDrink.setMeasure8(drinks.get(position).getStrMeasure8());
                    realmDrink.setMeasure9(drinks.get(position).getStrMeasure9());
                    realmDrink.setMeasure10(drinks.get(position).getStrMeasure10());
                    realmDrink.setMeasure11(drinks.get(position).getStrMeasure11());
                    realmDrink.setMeasure12(drinks.get(position).getStrMeasure12());
                    realmDrink.setMeasure13(drinks.get(position).getStrMeasure13());
            }, () -> Log.d(TAG, "onSuccess: Data Written"), error -> Log.d(TAG, "onError: Error"));


            Intent intent = new Intent(context, Detailed.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Name", drinks.get(position).getStrDrink());
            intent.putExtra("Alcoholic", drinks.get(position).getStrAlcoholic());
            intent.putExtra("Glass", drinks.get(position).getStrGlass());
            intent.putExtra("Thumbnail", drinks.get(position).getStrDrinkThumb());
            intent.putExtra("Instruction", drinks.get(position).getStrInstructions());
            intent.putExtra("Ingredient1", drinks.get(position).getStrIngredient1());
            intent.putExtra("Ingredient2", drinks.get(position).getStrIngredient2());
            intent.putExtra("Ingredient3", drinks.get(position).getStrIngredient3());
            intent.putExtra("Ingredient4", drinks.get(position).getStrIngredient4());
            intent.putExtra("Ingredient5", drinks.get(position).getStrIngredient5());
            intent.putExtra("Ingredient6", drinks.get(position).getStrIngredient6());
            intent.putExtra("Ingredient7", drinks.get(position).getStrIngredient7());
            intent.putExtra("Ingredient8", drinks.get(position).getStrIngredient8());
            intent.putExtra("Ingredient9", drinks.get(position).getStrIngredient9());
            intent.putExtra("Ingredient10", drinks.get(position).getStrIngredient10());
            intent.putExtra("Ingredient11", drinks.get(position).getStrIngredient11());
            intent.putExtra("Ingredient12", drinks.get(position).getStrIngredient12());
            intent.putExtra("Ingredient13", drinks.get(position).getStrIngredient13());
            intent.putExtra("Measure1", drinks.get(position).getStrMeasure1());
            intent.putExtra("Measure2", drinks.get(position).getStrMeasure2());
            intent.putExtra("Measure3", drinks.get(position).getStrMeasure3());
            intent.putExtra("Measure4", drinks.get(position).getStrMeasure4());
            intent.putExtra("Measure5", drinks.get(position).getStrMeasure5());
            intent.putExtra("Measure6", drinks.get(position).getStrMeasure6());
            intent.putExtra("Measure7", drinks.get(position).getStrMeasure7());
            intent.putExtra("Measure8", drinks.get(position).getStrMeasure8());
            intent.putExtra("Measure9", drinks.get(position).getStrMeasure9());
            intent.putExtra("Measure10", drinks.get(position).getStrMeasure10());
            intent.putExtra("Measure11", drinks.get(position).getStrMeasure11());
            intent.putExtra("Measure12", drinks.get(position).getStrMeasure12());
            intent.putExtra("Measure13", drinks.get(position).getStrMeasure13());
            context.startActivity(intent);




        });


    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView coctailName;
        ImageView coctailImg;
        CardView cardviewC;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            coctailName = itemView.findViewById(R.id.cocktailName);
            coctailImg = itemView.findViewById(R.id.cocktailImg);
            cardviewC = itemView.findViewById(R.id.cardviewC);

        }
    }
}
