package com.example.truongtannha_b03_bt02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdapter.Listener {
    RecyclerView recyclerView;
    List<Person> people;
    PersonAdapter personAdapter;
    SearchView searchView;
    FloatingActionButton floatingActionButton;
    int pos;

    ActivityResultLauncher<Intent> mLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            Person person = (Person) result.getData().getSerializableExtra("contact");
                            personAdapter.addPerson(person);
                        } else {
                            Person person = (Person) result.getData().getSerializableExtra("contact");
                            personAdapter.editPerson(person, pos);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rcPerson);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        people=new ArrayList<>();
        people=App.ininitPerson();
        personAdapter= new PersonAdapter(people,MainActivity.this);
        recyclerView.setAdapter(personAdapter);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent=new Intent(MainActivity.this,AddEditActivity.class);
                intent.putExtra("flag",1);
                mLauncher.launch(intent);
            }
        });
        // Bắt buộc khai báo để set kiểu layout cho RecyleView


    }


    @Override
    public void onItemListener(@NonNull Person person) {
//        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Contacts");
//        builder.setIcon(getDrawable(person.getImage()));
//        builder.setMessage(person.getName()+"\n"+person.getNumberphone());
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//                dialogInterface.cancel();
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
        InfoDialogBottomSheet dialog = new InfoDialogBottomSheet(MainActivity.this,person,mLauncher,personAdapter);
        dialog.findView();
        dialog.show();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.menuSearch){
            return true;
        }
        switch (id){
            case (R.id.menuSearch):
                Toast.makeText(this, "Bạn chọn Search", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.menuSort):
                Toast.makeText(this, "Bạn chọn bộ lọc ", Toast.LENGTH_SHORT).show();
                break;
            case (R.id.tangdan):
                Toast.makeText(this, "Bạn chọn tăng dần ", Toast.LENGTH_SHORT).show();
//                PersonAdapter.sort(people,1);
//                personAdapter.notifyDataSetChanged();
                break;
            case (R.id.giamdan):
                Toast.makeText(this, "Bạn chọn giảm dần", Toast.LENGTH_SHORT).show();
//                PersonAdapter.sort(people,-1);
//                personAdapter.notifyDataSetChanged();
                break;
            case (R.id.deletesort):
                Toast.makeText(this, "Bạn chọn xóa bộ lọc ", Toast.LENGTH_SHORT).show();
//                recyclerView.setAdapter(personAdapter);
//                personAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_01,menu); // Khai báo hiển thị menu
        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                String searchStr= newText;
//                personAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}