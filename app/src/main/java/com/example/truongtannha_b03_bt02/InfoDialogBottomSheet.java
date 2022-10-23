package com.example.truongtannha_b03_bt02;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.Contract;

public class InfoDialogBottomSheet extends BottomSheetDialog {
    TextView txFullName, txPhone, txEmail,txBirthday;
    ImageView imImage;
    ImageButton btnClose, btnEdit, btnDelete;
    Person person;
    ActivityResultLauncher mLauncher;
    PersonAdapter personAdapter;


    public InfoDialogBottomSheet(@NonNull Context context, Person person,ActivityResultLauncher mLauncher,PersonAdapter personAdapter) {
        super(context);
        this.person=person;
        this.mLauncher=mLauncher;
        this.personAdapter=personAdapter;
    }
    public void findView(){
        View view = getLayoutInflater().inflate(R.layout.activity_info,null);
        txFullName = view.findViewById(R.id.fullName);
        txPhone=view.findViewById(R.id.txPhone);
        txEmail=view.findViewById(R.id.txEmail);
        txBirthday=view.findViewById(R.id.txBirthday);
        imImage = view.findViewById(R.id.userImage);
        btnClose=view.findViewById(R.id.cancelBtn);
        btnClose.setOnClickListener( v -> {
            this.dismiss();
        });
        btnEdit=view.findViewById(R.id.editBtn);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddEditActivity.class);
                intent.putExtra("contact", person);
                intent.putExtra("flag",2);
                mLauncher.launch(intent);
                dismiss();
            }
        });
        btnDelete=view.findViewById(R.id.deleteBtn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Persons");
                builder.setMessage("Delete".concat(person.getFname()).concat("?"));
                builder.setNegativeButton("No",(dialog, i) ->{
                    dialog.cancel();
                } );
                builder.setPositiveButton("Yes",(dialog, i) ->{
                    personAdapter.deletePerson(person);
                    dialog.dismiss();
                    dismiss();
                } );
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        txFullName.setText(person.getFname());
        txEmail.setText(person.getEmail());
        txPhone.setText(person.getNumberphone());
        txBirthday.setText(person.getBirthday());
        //txBirthday.setText(person.getBirthday());
        imImage.setImageResource(person.getImage());
        setContentView(view);
    }

}
