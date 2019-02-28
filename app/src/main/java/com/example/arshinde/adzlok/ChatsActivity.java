package com.example.arshinde.adzlok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ChatsActivity extends AppCompatActivity {

    EditText search;
    RecyclerView recyclerView;

    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    ArrayList<String> fullNameList;
    ArrayList<String> profilePicLIst;
    ArrayList<String> statusList;
    user user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        search = (EditText) findViewById(R.id.search);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        fullNameList = new ArrayList<>();
        profilePicLIst = new ArrayList<>();
        statusList = new ArrayList<>();


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().isEmpty()) {
                    setAdapter(s.toString());

                }
                else
                {
                    fullNameList.clear();
                    statusList.clear();
                    profilePicLIst.clear();
                    recyclerView.removeAllViews();
                }
            }
        });


    }
    private  void setAdapter(final String searchedString){

        databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count=0;
                fullNameList.clear();
                statusList.clear();
                profilePicLIst.clear();
                recyclerView.removeAllViews();

                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String uid=snapshot.getKey();
                    String name=snapshot.child("name").getValue(String.class);
                    String status=snapshot.child("status").getValue(String.class);
                    String image=snapshot.child("image").getValue(String.class);
                    if(name.toLowerCase().contains(searchedString.toLowerCase())){

                        fullNameList.add(name);
                        statusList.add(status);
                        profilePicLIst.add(image);
                    }
                    else if(status.toLowerCase().contains(searchedString.toLowerCase())) {

                        fullNameList.add(name);
                        statusList.add(status);
                        profilePicLIst.add(image);
                        count++;

                    }
                    if(count==15)
                    {
                        break;
                    }
                }
                user=new user(ChatsActivity.this,fullNameList,statusList,profilePicLIst);
                recyclerView.setAdapter(user);


            }
            


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
