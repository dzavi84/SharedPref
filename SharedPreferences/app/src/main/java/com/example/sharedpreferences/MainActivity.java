package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mNameEt,mAgeEt;
    Button mSaveBtn,mInfoBtn;
    Switch mSwitch;
    TextView mInfoTv;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt = findViewById(R.id.nameEt);
        mAgeEt = findViewById(R.id.ageEt);
        mSaveBtn=findViewById(R.id.saveBtn);
        mInfoBtn=findViewById(R.id.showBtn);
        mSwitch=findViewById(R.id.switchh);
        mInfoTv=findViewById(R.id.infoTv);

        sharedPreferences = getSharedPreferences("SP_NAME",MODE_PRIVATE);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mNameEt.getText().toString();
                int age = Integer.parseInt(mAgeEt.getText().toString().trim());
                boolean experience = mSwitch.isChecked();

                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("NAME",name);
                editor.putInt("AGE",age);
                editor.putBoolean("EXPERIENCE",experience);

                editor.apply();



            }
        });

        mInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= sharedPreferences.getString("NAME","");
                int age = sharedPreferences.getInt("AGE",0);
                boolean experience = sharedPreferences.getBoolean("EXPERIENCE",false);

                mInfoTv.setText("Name: "+name
                +"\nAge: "+age
                +"\nExperience: "+experience);

            }
        });




    }
}