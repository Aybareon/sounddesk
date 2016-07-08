package com.example.danielprimo.sounddesk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class choose_theme extends AppCompatActivity {
    public  final  static  String EXTRA_MESSAGE =  "com.mycompany.myfirstapp.MESSAGE" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_theme);

    }

    public void desktop(View view) {
        Intent intent= new Intent (this, Desktop_go.class);
        //ImageButton editIButton = (ImageButton)findViewById(R.id.cenario1_ihc);
        //String message=editIButton.toString();
        String message=getResources().getResourceEntryName(view.getId());
        System.out.println("__________"+getResources().getResourceEntryName(view.getId()));
        intent.putExtra(EXTRA_MESSAGE,message);
        this.startActivity(intent);
    }

}
