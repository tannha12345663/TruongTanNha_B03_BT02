package com.example.truongtannha_b03_bt02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapte extends RecyclerView.Adapter<ContactAdapte.ContactVH> implements Filterable {
    Context context;
    ArrayList<Person> persons;
    ArrayList<Person> personsFilter;



    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    class ContactVH extends RecyclerView.ViewHolder{
        TextView txName, txPhone, txEmail;
        ImageView imgProfile;

        public ContactVH(@NonNull View itemView) {
            super(itemView);
            txName=itemView.findViewById(R.id.txName);
            txPhone = itemView.findViewById(R.id.txNumber);
            txEmail = itemView.findViewById(R.id.txEmail);
            

        }
    }
}
