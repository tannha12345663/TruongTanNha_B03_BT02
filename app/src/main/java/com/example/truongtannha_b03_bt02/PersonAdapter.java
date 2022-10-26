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
    List<Person> peoplesFilter; // Tìm item
    List<Person> peoples;
    Listener listener;

    public PersonAdapter(List<Person> peoples,Listener listener) {
        this.peoples = peoples;
        this.listener=listener;
        this.peoplesFilter=peoples;
    }


    @NonNull
    @Override
    public PersonVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_row,parent,false);
        return new PersonVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonVH holder, int position) {
        Person person = peoplesFilter.get(position);
        holder.imagperson.setImageResource(person.getImage());
        holder.txName.setText(person.getFname());
        holder.txNumber.setText(person.getNumberphone());
        holder.txEmail.setText(person.getEmail());
        //Bắt sự kiện onClick Listen
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemListener(position,person);
            }
        });
    }


    @Override
    public int getItemCount() {
        return peoplesFilter.size();
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
        void onItemListener(int pos,Person person);
    }
    @Override
    public Filter getFilter() {
        return new PeoplesFilter();
    }

    private class PeoplesFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charstring = constraint.toString();
            if (charstring.isEmpty()){
                peoplesFilter=peoples;
            }else {
                List<Person>filteredList = new ArrayList<>();
                for (Person row : peoples){
                    //Xét chuỗi phù hợp với ký tự đã nhập vào
                    if (row.getFname().toLowerCase().contains(charstring.toLowerCase())
                    ||row.getNumberphone().contains(charstring)
                    ||row.getLname().contains(charstring)){
                        filteredList.add(row);
                    }
                }
                peoplesFilter = (ArrayList<Person>) filteredList;
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = peoplesFilter;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            peoplesFilter = (ArrayList<Person>) results.values;
            notifyDataSetChanged();
        }
    }

    public void addPerson(Person person){
        peoples.add(person);
        notifyDataSetChanged();
    }
    public void editPerson(Person person, int pos){
        peoples.set(pos,person);
        notifyDataSetChanged();
    }
    public void deletePerson(int pos){
        peoples.remove(pos);
        notifyDataSetChanged();
    }
    public void deletePerson(Person person){
        peoples.remove(person);
        notifyDataSetChanged();
    }


}
