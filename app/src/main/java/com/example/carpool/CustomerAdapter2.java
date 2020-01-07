package com.example.carpool;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomerAdapter2 extends RecyclerView.Adapter<CustomerAdapter2.MyViewHolder> {


    Context context;
//    private int mBackground;

    private ArrayList<Data2> dataset;
    public CustomerAdapter2(ArrayList<Data2> dataset){
        this.dataset = dataset;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dummy2, parent,false);
//        view.setBackgroundResource(mBackground);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

    Data2 objdata = dataset.get(position);
    holder.heading.setText(objdata.heading);
    holder.reason.setText(objdata.reason);
    holder.place.setText(objdata.place);



//    holder.image.setImageDrawable(holder.image.getContext().getResources().getDrawable(objdata.image));
//    holder.itemView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Context context = view.getContext();
//            Intent intent = new Intent(context, Coordinator_Layout.class);
//            intent.putExtra(Coordinator_Layout.EXTRA_NAME, dataset.get(holder.getAdapterPosition()).reason);
//            intent.putExtra(Coordinator_Layout.EXTRA_IMAGE_DRAWABLE, dataset.get(holder.getAdapterPosition()).image);

//        }
//    });

        Glide.with(holder.image.getContext())
                .load(objdata.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView heading;
        TextView reason;
        TextView place;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        heading = itemView.findViewById(R.id.textView8);
        reason = itemView.findViewById(R.id.textView10);
        place = itemView.findViewById(R.id.textView12);
        image = itemView.findViewById(R.id.imageView2);
        
        }
    }
}



