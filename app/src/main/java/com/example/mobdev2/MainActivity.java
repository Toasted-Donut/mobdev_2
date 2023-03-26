package com.example.mobdev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mobdev2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    SharedPreferences setts;
    ActivityMainBinding actMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setts = this.getSharedPreferences(getText(R.string.settings).toString(), Context.MODE_PRIVATE);
        actMain = ActivityMainBinding.inflate(this.getLayoutInflater());
        actMain.img1.setImageDrawable(AppCompatResources.getDrawable(this,R.drawable.car_1));
        actMain.txtView.setText(R.string.name);
        actMain.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("gg","button clicked");
                Intent secAct = new Intent(MainActivity.this,SecondActivity.class);
                setts.edit().putString(getText(R.string.msg_to).toString(),actMain.editTxt.getText().toString()).apply();
                startActivity(secAct);
            }
        });
        setContentView(actMain.getRoot());
    }

    @Override
    protected void onRestart() {
        Log.i("gg","onres");

        super.onRestart();
        actMain.txtView.setText(setts.getString(getText(R.string.msg_from).toString(),actMain.txtView.getText().toString()));
    }
}