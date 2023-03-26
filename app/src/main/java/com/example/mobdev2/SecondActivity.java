package com.example.mobdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mobdev2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences setts;
    ActivitySecondBinding actSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setts = this.getSharedPreferences(getText(R.string.settings).toString(), Context.MODE_PRIVATE);
        actSecond = ActivitySecondBinding.inflate(getLayoutInflater());
        actSecond.textView.setText(setts.getString(getText(R.string.msg_to).toString(),"default"));
        actSecond.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setts.edit().putString(getText(R.string.msg_from).toString(),actSecond.editText.getText().toString()).apply();
            }
        });
        setContentView(actSecond.getRoot());
    }

}