package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admincollegeapp.faculty.UpdateFaculty;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.example.admincollegeapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
CardView uploadNotice,addGalleryImage,addEBook,faculty,deleteNotice ; // 1
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
      editor = sharedPreferences.edit();
      if (sharedPreferences.getString("isLogin","false").equals("false")){
           openLogin();
      }
          logoutBtn = findViewById(R.id.logoutBtn);
        uploadNotice=findViewById(R.id.addNotice); // 1
        addGalleryImage = findViewById(R.id.addGalleryImage);//2
        addEBook  = findViewById(R.id.addEBook);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);
        uploadNotice.setOnClickListener(this); //1
        addGalleryImage.setOnClickListener(this);
        addEBook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        //here we are using switch so we can easily switch from one card view to another card view easily
        Intent intent;
        switch(view.getId()){
            //here we choose addNotice id and with help of intent we are moving from main activity to uploadnotice activity
            case R.id.addNotice :
                 intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage :
                 intent = new Intent(MainActivity.this,UploadImage.class);
                 startActivity(intent);
                break;
            case R.id.addEBook :
                intent = new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent);
                break;
            case R.id.faculty :
                intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;
            case  R.id.deleteNotice:
                intent = new Intent(MainActivity.this ,DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.logoutBtn:
                editor.putString("isLogin","false");
                editor.commit();
                openLogin();
                break;

        }
    }
}