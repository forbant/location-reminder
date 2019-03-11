package com.example.andrii.reminder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

   private ArrayList<ExampleItem> exampleItems;

   public static class ExampleViewHolder extends RecyclerView.ViewHolder {
       public ImageView imageView;
       public TextView text1;
       public TextView text2;

       public ExampleViewHolder(View itemView) {
           super(itemView);
           imageView = itemView.findViewById(R.id.imageView);
           text1 = itemView.findViewById(R.id.textView1);
           text2 = itemView.findViewById(R.id.textView2);
       }
   }

   public ExampleAdapter(ArrayList<ExampleItem> exampleItems) {
        this.exampleItems = exampleItems;
   }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(v);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleItem item = exampleItems.get(i);

        exampleViewHolder.imageView.setImageResource(item.getImageResource());
        exampleViewHolder.text1.setText(item.getText1());
        exampleViewHolder.text2.setText(item.getText2());
    }

    @Override
    public int getItemCount() {
        return exampleItems.size();
    }
}
