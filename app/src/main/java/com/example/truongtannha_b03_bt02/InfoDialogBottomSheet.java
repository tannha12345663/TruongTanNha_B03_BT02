package com.example.truongtannha_b03_bt02;

import android.content.Context;
import android.content.Intent;
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


    public InfoDialogBottomSheet(@NonNull Context context, Person person) {
        super(context);
        this.person=person;

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

        txFullName.setText(person.getName());
        txEmail.setText(person.getEmail());
        txPhone.setText(person.getNumberphone());
        txBirthday.setText(person.getDescription());
        //txBirthday.setText(person.getBirthday());
        imImage.setImageResource(person.getImage());
        setContentView(view);
    }

}
