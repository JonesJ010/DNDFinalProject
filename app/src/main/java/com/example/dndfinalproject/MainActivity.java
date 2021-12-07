package com.example.dndfinalproject;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditDex,mEditBAB;
    int mAttackBonus, mBAB,mDex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditDex= (EditText) findViewById(R.id.editTextNumber_Dex);
        mEditBAB= (EditText) findViewById(R.id.editTextNumber_BAB);

    }
        public void toCalculation(View view){
            mDex=parseInt(mEditDex.getText().toString());
            mBAB=parseInt(mEditBAB.getText().toString());
            mAttackBonus=mDex+mBAB;
            Intent intent = new Intent(this, CalculationActivity.class);
            intent.putExtra("mAttackBonus",mAttackBonus);
            startActivity(intent);
        }
    }