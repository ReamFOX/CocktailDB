package com.example.cocktailsdb;

import android.content.Context;
import android.content.Intent;
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
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;


public class RealmAdapter extends RealmRecyclerViewAdapter<RealmDrink, RealmAdapter.MyViewHolder> {

    Context context;
    public RealmAdapter( RealmResults<RealmDrink> drink, Context context) {
        super(drink, true);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final RealmDrink drinks = getItem(position);

        assert drinks != null;
        holder.coctailName.setText(drinks.getName());


        Glide
                .with(context)
                .load(drinks.getThumb())
                .into(holder.coctailImg);

        holder.cardviewC.setOnClickListener(v -> {

            Intent intent = new Intent(context, Detailed.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Name", drinks.getName());
            intent.putExtra("Alcoholic", drinks.getAlcoholic());
            intent.putExtra("Glass", drinks.getGlass());
            intent.putExtra("Thumbnail", drinks.getThumb());
            intent.putExtra("Instruction", drinks.getInstructions());
            intent.putExtra("Ingredient1", drinks.getIngredient1());
            intent.putExtra("Ingredient2", drinks.getIngredient2());
            intent.putExtra("Ingredient3", drinks.getIngredient3());
            intent.putExtra("Ingredient4", drinks.getIngredient4());
            intent.putExtra("Ingredient5", drinks.getIngredient5());
            intent.putExtra("Ingredient6", drinks.getIngredient6());
            intent.putExtra("Ingredient7", drinks.getIngredient7());
            intent.putExtra("Ingredient8", drinks.getIngredient8());
            intent.putExtra("Ingredient9", drinks.getIngredient9());
            intent.putExtra("Ingredient10", drinks.getIngredient10());
            intent.putExtra("Ingredient11", drinks.getIngredient11());
            intent.putExtra("Ingredient12", drinks.getIngredient12());
            intent.putExtra("Ingredient13", drinks.getIngredient13());
            intent.putExtra("Measure1", drinks.getMeasure1());
            intent.putExtra("Measure2", drinks.getMeasure2());
            intent.putExtra("Measure3", drinks.getMeasure3());
            intent.putExtra("Measure4", drinks.getMeasure4());
            intent.putExtra("Measure5", drinks.getMeasure5());
            intent.putExtra("Measure6", drinks.getMeasure6());
            intent.putExtra("Measure7", drinks.getMeasure7());
            intent.putExtra("Measure8", drinks.getMeasure8());
            intent.putExtra("Measure9", drinks.getMeasure9());
            intent.putExtra("Measure10", drinks.getMeasure10());
            intent.putExtra("Measure11", drinks.getMeasure11());
            intent.putExtra("Measure12", drinks.getMeasure12());
            intent.putExtra("Measure13", drinks.getMeasure13());
            context.startActivity(intent);
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coctailName;
        ImageView coctailImg;
        CardView cardviewC;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coctailName = itemView.findViewById(R.id.cocktailName);
            coctailImg =  itemView.findViewById(R.id.cocktailImg);
            cardviewC =  itemView.findViewById(R.id.cardviewC);

        }
    }
}

