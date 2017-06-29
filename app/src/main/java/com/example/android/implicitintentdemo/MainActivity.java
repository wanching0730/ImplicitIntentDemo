package com.example.android.implicitintentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){

        EditText etMessage = (EditText) findViewById(R.id.message);
        String message = etMessage.getText().toString();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("text/plain");
       // startActivity(intent);

        String title = getResources().getString(R.string.app_chooser);
        Intent chooser = Intent.createChooser(intent, title);
        //will be able to choose app if more than 1 related app

        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(chooser);

    }
}
