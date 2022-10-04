package com.example.truongtannha_b03_bt02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonVH> implements Filterable {
    List<Person> peoples;
    Listener listener;
    List<Person> getPeoplesFilter; // Tìm item
    public PersonAdapter(List<Person> peoples,Listener listener) {
        this.peoples = peoples;
        this.listener=listener;
        this.getPeoplesFilter=peoples;
    }


    @NonNull
    @Override
    public PersonVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_row,parent,false);
        return new PersonVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonVH holder, int position) {
        Person person = peoples.get(position);
        holder.imagperson.setImageResource(person.getImage());
        holder.txName.setText(person.getName());
        holder.txNumber.setText(person.getNumberphone());
        holder.txEmail.setText(person.getEmail());
        //Bắt sự kiện onClick Listen
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemListener(person);
            }
        });
    }


    @Override
    public int getItemCount() {
        return peoples.size();
    }



    class PersonVH extends RecyclerView.ViewHolder{
        CircleImageView imagperson;
        TextView txName, txNumber,txEmail;

        public PersonVH(@NonNull View itemView) {
            super(itemView);
            imagperson=itemView.findViewById(R.id.imagPerson);
            txName=itemView.findViewById(R.id.txName);
            txNumber=itemView.findViewById(R.id.txNumber);
            txEmail=itemView.findViewById(R.id.txEmail);
        }
    }
    interface Listener{
        void onItemListener(Person person);
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint==null|| constraint.length()==0){
                    filterResults.values=getPeoplesFilter;
                    filterResults.count= getPeoplesFilter.size();
                }else {
                    String searchStr=constraint.toString().toLowerCase();
                    List<Person> personList = new ArrayList<>();
                    for (Person person : getPeoplesFilter){
                        if (person.getName().toLowerCase().contains(searchStr)||person.getNumberphone().toLowerCase().contains(searchStr)|| person.getNumberphone().toLowerCase().contains(searchStr)){
                            personList.add(person);
                        }
                    }
                    filterResults.values = personList;
                    filterResults.count=personList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                peoples = (List<Person>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


    public static void sort(List<Person> sapxep, final int asc){
        Collections.sort(sapxep, new Comparator<Person>() {
            @Override
            public int compare(Person t1, Person t2) {
                int  n1,n2 ;
                n1 = t1.getId();
                n2 = t2.getId();
                int s1 = n1;
                int s2 = n2;
                return s1> s2 ? asc:-asc;
            }
        });
    }
}
