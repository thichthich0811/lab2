package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edthoten;
    ListView lv;
    ArrayList<Contact> list_ds;
    adapter ad;
    Button add, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edthoten=findViewById(R.id.edt_search);
        lv=findViewById(R.id.lv_danhsach);
        add=findViewById(R.id.btn_detail);
        delete=findViewById(R.id.btn_delete);
        list_ds=new ArrayList<>();
        list_ds.add(new Contact(1,"Nguyen van a","0123456789",false));
        list_ds.add(new Contact(2,"nguyen van b","0222383832",false));
        list_ds.add(new Contact(3,"nguyen van c","0318271827",false));
        ad=new adapter(list_ds,this);
        lv.setAdapter(ad);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,detail.class);
                startActivityForResult(in, 1);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có muốn xóa không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int j=0;j<list_ds.size();j++){
                            if(list_ds.get(j).isStatus()==true){
                                list_ds.remove(j);
                            }
                        }
                        ad.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không",null);
                builder.create().show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Contact newContact = (Contact) data.getSerializableExtra("newContact");
            if (newContact != null) {
                list_ds.add(newContact);
                System.out.println(list_ds.size());
                ad.notifyDataSetChanged();
            }
        }
    }
}