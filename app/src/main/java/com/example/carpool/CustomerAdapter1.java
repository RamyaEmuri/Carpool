package com.example.carpool;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
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



public class CustomerAdapter1 extends RecyclerView.Adapter<CustomerAdapter1.MyViewHolder> {


    Context context;
    private int mBackground;
    private ArrayList<Data1> dataset1;
    CustomerAdapter1(ArrayList<Data1> dataset1){
        this.dataset1 = dataset1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dummy1, parent,false);
        view.setBackgroundResource(mBackground);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Data1 objdata1 = dataset1.get(position);
        holder.name.setText(objdata1.name);
        holder.status.setText(objdata1.status);
        holder.time.setText(objdata1.time);
        holder.description.setText(objdata1.description);
      holder.image.setImageDrawable(holder.image.getContext().getResources().getDrawable(objdata1.image));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, Coordinator_Layout.class);
                intent.putExtra(Coordinator_Layout.EXTRA_NAME, dataset1.get(holder.getAdapterPosition()).name);
                intent.putExtra(Coordinator_Layout.EXTRA_IMAGE_DRAWABLE, dataset1.get(holder.getAdapterPosition()).image);
                context.startActivity(intent);
            }
        });
        Glide.with(holder.image.getContext())
                .load(objdata1.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataset1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView status;
        TextView time;
        TextView description;
        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView3);
            status = itemView.findViewById(R.id.textView4);
            time = itemView.findViewById(R.id.textView5);
            description = itemView.findViewById(R.id.textView6);
            image = itemView.findViewById(R.id.imageView5);
        }
    }

}
