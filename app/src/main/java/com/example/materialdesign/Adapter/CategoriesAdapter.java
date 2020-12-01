package com.example.materialdesign.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.HelperClass.CategoriesHelperClass;
import com.example.materialdesign.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {

ArrayList<CategoriesHelperClass> mostViewedLocations=new ArrayList<>();

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        return new AdapterAllCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass=mostViewedLocations.get(position);

        holder.title.setText(categoriesHelperClass.getTitle());
        holder.image.setImageResource(categoriesHelperClass.getImage());

    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageId);
            title=itemView.findViewById(R.id.titleId);
        }
    }
}
