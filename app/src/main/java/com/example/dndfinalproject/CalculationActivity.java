package com.example.dndfinalproject;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    int mAttackBonus2,mAttackBonus3;
    int mDmgBonus,mMiscMod,mMiscDmgMod;
    EditText mEditTextMod,mEditTextDmgMod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        Intent intent = getIntent();
        mAttackBonus3= intent.getIntExtra("mAttackBonus",0);
        mDmgBonus=intent.getIntExtra("mAttackBonus",0);
        mAttackBonus2=mAttackBonus3;
    }

    public void onTWFClick(View view) {
        boolean checked =((CheckBox)view).isChecked();
            if(checked)
                mAttackBonus2= mAttackBonus2-2;

    }

    public void onBardicInspiration(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            mAttackBonus2 = mAttackBonus2 + 1;
            mDmgBonus++;
        }
    }
    public void onFlanking(View view) {
        boolean checked =((CheckBox)view).isChecked();
        if(checked)
            mAttackBonus2=mAttackBonus2+2;

    }

    public void onCalculate(View view) {

        mEditTextMod= (EditText)findViewById(R.id.editTextNumber_Misc_Mod);
        mMiscMod=parseInt(mEditTextMod.getText().toString());
        mEditTextDmgMod= (EditText)findViewById(R.id.editTextNumber_MiscDmg_Mod);
        mMiscDmgMod=parseInt(mEditTextDmgMod.getText().toString());
        mAttackBonus2+=mMiscMod;
        mDmgBonus+=mMiscDmgMod;
        setContentView(R.layout.activity_calculation);
        TextView outputTextview=(TextView) findViewById((R.id.textView_output));
        outputTextview.setText("Add "+ mAttackBonus2 + " to dice roll for attack and add "+ mDmgBonus+" to damage");
    }

    public void onReset(View view) {
        mMiscMod=0;
        mMiscDmgMod=0;
        mAttackBonus2=mAttackBonus3;
        mDmgBonus = mAttackBonus3;
        setContentView(R.layout.activity_calculation);
        TextView outputTextview=(TextView) findViewById((R.id.textView_output));
        outputTextview.setText("");
    }
}