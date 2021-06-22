package com.example.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
       FloatingActionButton fab;
       private RecyclerView csDepartment,itDepartment,mechanicalDepartment,civilDepartment,electricalDepartmen,ecDepartment;
  private LinearLayout  csNoData,itNoData,meNoData,ceNoData,eeNoData,ecNoData;
  private List<TeacherData> list1,list2,list3,list4,list5,list6;
  private DatabaseReference reference,dbRef;
  private TeacherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
         csDepartment = findViewById(R.id.csDepartment);
         itDepartment = findViewById(R.id.itDepartment);
         mechanicalDepartment = findViewById(R.id.mechanicalDepartment);
         civilDepartment = findViewById(R.id.civilDepartment);
         electricalDepartmen = findViewById(R.id.electricalDepartment);
         ecDepartment = findViewById(R.id.ecDepartment);
         csNoData  = findViewById(R.id.csNoData);
         itNoData = findViewById(R.id.itNoData);
         meNoData=findViewById(R.id.meNoData);
         ceNoData =findViewById(R.id.ceNoData);
         eeNoData =findViewById(R.id.eeNoData);
         ecNoData = findViewById(R.id.ecNoData);


          reference = FirebaseDatabase.getInstance().getReference().child("teacher");

          csDepartment();
          itDepartment();
          mechanicalDepartment();
          civilDepartment();
        electricalDepartmen();
        ecDepartment();


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void ecDepartment() {
        dbRef = reference.child("Electrical and Communication");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    ecNoData.setVisibility(View.VISIBLE);
                    ecDepartment.setVisibility(View.GONE);
                } else {
                    ecNoData.setVisibility(View.GONE);
                    ecDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    ecDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list6, UpdateFaculty.this,"Electrical and Communication");
                    ecDepartment.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

            private void electricalDepartmen() {
                dbRef = reference.child("Electrical Engineering");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull  DataSnapshot dataSnapshot) {
                        list5 = new ArrayList<>();
                        if (!dataSnapshot.exists()){
                            eeNoData.setVisibility(View.VISIBLE);
                            electricalDepartmen.setVisibility(View.GONE);
                        }else
                        {
                            eeNoData.setVisibility(View.GONE);
                            electricalDepartmen.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                                TeacherData data = snapshot.getValue(TeacherData.class);
                                list5.add(data);
                            }
                            civilDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                            adapter = new TeacherAdapter(list5,UpdateFaculty.this,"Electrical Engineering");
                            electricalDepartmen.setAdapter(adapter);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void civilDepartment() {
                dbRef = reference.child("Civil Engineering");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list4 = new ArrayList<>();
                        if (!dataSnapshot.exists()) {
                            ceNoData.setVisibility(View.VISIBLE);
                            civilDepartment.setVisibility(View.GONE);
                        } else {
                            ceNoData.setVisibility(View.GONE);
                            civilDepartment.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                TeacherData data = snapshot.getValue(TeacherData.class);
                                list4.add(data);
                            }
                            civilDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                            adapter = new TeacherAdapter(list4, UpdateFaculty.this,"Civil Engineering");
                            civilDepartment.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void mechanicalDepartment() {
                dbRef = reference.child("Mechanical Engineering");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        list3 = new ArrayList<>();
                        if (!datasnapshot.exists()) {
                            meNoData.setVisibility(View.VISIBLE);
                            mechanicalDepartment.setVisibility(View.GONE);
                        } else {
                            meNoData.setVisibility(View.GONE);
                            mechanicalDepartment.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                                TeacherData data = snapshot.getValue(TeacherData.class);
                                list3.add(data);
                            }
                            mechanicalDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                            adapter = new TeacherAdapter(list3, UpdateFaculty.this,"Mechanical Engineering");
                            mechanicalDepartment.setAdapter(adapter);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }

            private void itDepartment() {
                dbRef = reference.child("Information and Technology");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list2 = new ArrayList<>();
                        if (!dataSnapshot.exists()) {
                            itNoData.setVisibility(View.VISIBLE);
                            itDepartment.setVisibility(View.GONE);
                        } else {
                            itNoData.setVisibility(View.GONE);
                            itDepartment.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                TeacherData data = snapshot.getValue(TeacherData.class);
                                list2.add(data);
                            }
                            itDepartment.setHasFixedSize(true);
                            itDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                            adapter = new TeacherAdapter(list2, UpdateFaculty.this,"Information and Technology");
                            itDepartment.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

            private void csDepartment() {
                dbRef = reference.child("Computer Science");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        list1 = new ArrayList<>();
                        if (!datasnapshot.exists()) {
                            csNoData.setVisibility(View.VISIBLE);
                            csDepartment.setVisibility(View.GONE);
                        } else {
                            csNoData.setVisibility(View.GONE);
                            csDepartment.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                                TeacherData data = snapshot.getValue(TeacherData.class); //getting teachers data to show and adding  to list
                                list1.add(data);
                            }
                            csDepartment.setHasFixedSize(true);
                            csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                            adapter = new TeacherAdapter(list1, UpdateFaculty.this,"Computer Science");
                            csDepartment.setAdapter(adapter);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }