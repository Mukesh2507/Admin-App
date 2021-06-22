package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


     private EditText user_email,user_password;
     private TextView tvShow;
     private RelativeLayout loginBtn;
    private  String email,password;
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferences.getString("isLogin","false").equals("yes")){
            openDash();
        }
        setContentView(R.layout.activity_login);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        tvShow = findViewById(R.id.txt_show);
        loginBtn = findViewById(R.id.loginBtn);


         tvShow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //getting type show mode or hide mode
                 if (user_password.getInputType()==144){ //144 for hide and 129 for show
                     user_password.setInputType(129);
                     tvShow.setText("Hdde");
                 }else {
                     user_password.setInputType(144);
                     tvShow.setText("Show");
                 }
                 user_password.setSelection(user_password.getText().length()); // subham hide if we do not write this then cursor go the ahead of subham so set it we wrote this line

             }

         });
         loginBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 validateDate();
             }
         });
    }

    private void validateDate() {
              email = user_email.getText().toString();
              password = user_password.getText().toString();
              if (email.isEmpty()){
                  user_email.setError("Email Required");
                  user_email.requestFocus();
              }else if(password.isEmpty()){
                  user_password.setError("Password Required");
                  user_password.requestFocus();
              }else if(email.equals("admin@gmail.com") && password.equals("12345")){

                  openDash();
              }else{
                  Toast.makeText(this, "Incorrect Password or Email", Toast.LENGTH_SHORT).show();
              }

    }

    private void openDash() {
          editor.putString("isLogin","yes");
          editor.commit();
          startActivity(new Intent(LoginActivity.this,MainActivity.class));
          finish();
    }
}