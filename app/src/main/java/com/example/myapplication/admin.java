package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class admin extends AppCompatActivity {
    public String username ,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
//-----------------------time
        TextView miti = findViewById(R.id.miti);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        miti.setText(currentDate);
   //--------------------time
     //----------------------------------------

        final EditText usernm = findViewById(R.id.usrnm);
        final EditText pass = findViewById(R.id.pwd);
        Button signin =findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =usernm.getText().toString();
                String passkey = pass.getText().toString();

                if (name.equals("")&(passkey.equals(""))){
                Toast.makeText(admin.this, "enter username and passskey", Toast.LENGTH_SHORT).show();}
                else if(passkey.equals("")){
                    Toast.makeText(admin.this, "enter password", Toast.LENGTH_SHORT).show();}
                else if(name.equals("")){
                    Toast.makeText(admin.this, "name", Toast.LENGTH_SHORT).show();}
                else{



                    if("anis".equals(name) & ("985509".equals(passkey))){
                        Intent admin_add = new Intent(admin.this,adminAdd.class);
                        Toast.makeText(admin.this,"o yeah",Toast.LENGTH_SHORT).show();
                        startActivity(admin_add);
                    }
                    else{
                            Toast.makeText(admin.this,"incorrect credentials",Toast.LENGTH_SHORT).show();
                }
            }
                }
            });





    }
}
