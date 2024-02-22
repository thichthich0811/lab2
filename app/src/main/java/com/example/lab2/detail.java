package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class detail extends AppCompatActivity {

    EditText edtId,edtPhone,edtName;
    Button add, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        edtId=findViewById(R.id.edt_id);
        edtPhone=findViewById(R.id.edt_phone);
        edtName=findViewById(R.id.edt_name);
        add=findViewById(R.id.btn_add);
        back=findViewById(R.id.btn_back);
        Intent in=getIntent();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(edtId.getText().toString());
                String phone=edtPhone.getText().toString();
                String name=edtName.getText().toString();
                Contact newContact=new Contact(id,phone,name,false);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newContact", (Serializable)newContact);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}