package com.example.materialdesign;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MostViewedAdapter  extends RecyclerView.Adapter<MostViewedAdapter.MostViewedHolder>{

        ArrayList<MostViewedHelperClass>  mostViewedLocations=new ArrayList<>();

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewd_card,parent,false);
        return new MostViewedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass= mostViewedLocations.get(position);
        holder.imageM.setImageResource(mostViewedHelperClass.getImageMv());
        holder.titleM.setText(mostViewedHelperClass.getTitleMv());
        holder.descriptionM.setText(mostViewedHelperClass.getDescriptionMv());

    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public  static  class MostViewedHolder extends RecyclerView.ViewHolder {
        private ImageView imageM;
        private TextView titleM,descriptionM;
        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);
            imageM=itemView.findViewById(R.id.mostViewd_imageId);
            titleM=itemView.findViewById(R.id.mostViewd_titleId);
            descriptionM=itemView.findViewById(R.id.mostViewd_descriptionId);
        }
    }
}
