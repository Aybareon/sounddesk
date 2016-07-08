package com.example.danielprimo.sounddesk;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sounds_Layout extends AppCompatActivity {
    int newLayoutType;
    MediaPlayer play1,play2,play3,play4,play5,play6,play7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int imageResource;
        Intent intent = getIntent();
        String message = intent.getStringExtra(choose_theme.EXTRA_MESSAGE);
        imageResource=getResources().getIdentifier("drawable/"+message,null,getPackageName());
        setContentView(R.layout.activity_sounds__layout);
        RelativeLayout relative = (RelativeLayout)findViewById(R.id.power_layout);
        relative.setBackgroundResource(imageResource);
        newLayoutType=Desktop_go.layoutType;
        play1=new MediaPlayer();
        play2=new MediaPlayer();
        play3=new MediaPlayer();
        play4=new MediaPlayer();
        play5=new MediaPlayer();
        play6=new MediaPlayer();
        play7=new MediaPlayer();
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
    }

    public void pinta_layouts(){
        int i;
        TextView [] text= new TextView[5];
        for(i=0;i<5;i++){
            if(i==0){
                text[i]=(TextView)findViewById(R.id.ambience_player);
            }
            else if(i==1){
                text[i]=(TextView)findViewById(R.id.foley_player);
            }
            else if(i==2){
                text[i]=(TextView)findViewById(R.id.sound_effects_player);
            }
            else if(i==3){
                text[i]=(TextView)findViewById(R.id.music_player);
            }
            else if(i==4){
                text[i]=(TextView)findViewById(R.id.dialogue_player);
            }
            if(i==newLayoutType){
                text[i].setVisibility(View.VISIBLE);
                text[i].setEnabled(false);
                text[i].setBackgroundColor(Color.WHITE);
                text[i].setTextColor(Color.BLACK);
            }
            else{
                text[i].setVisibility(View.VISIBLE);
                text[i].setEnabled(true);
                text[i].setBackgroundColor(Color.BLACK);
                text[i].setTextColor(Color.WHITE);
            }
        }
    }

    public void editLayout_1(){
        int i;
        int count1;
        int count2;
        count1=count2=0;
        ImageButton [] btn=new ImageButton[7];
        LinearLayout lr_0=(LinearLayout)findViewById(R.id.layout_0);
        LinearLayout lr_1=(LinearLayout)findViewById(R.id.layout_1);
        for(i=0;i<7;i++){
            if(i==0){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_1);
            }
            else if(i==1){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_2);
            }
            else if(i==2){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_3);
            }
            else if(i==3){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_4);
            }
            else if(i==4){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_5);
            }
            else if(i==5){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_6);
            }
            else if(i==6){
                btn[i]=(ImageButton)findViewById(R.id.layout_1_7);
            }
            if(Desktop_go.posHistory[newLayoutType]>i){
                btn[i].setVisibility(View.VISIBLE);
                if(Desktop_go.posHistory[newLayoutType]-1==i){
                    btn[i].setBackgroundResource(Desktop_go.historyImageCard[newLayoutType][i]);
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=180;
                    btn[i].setLayoutParams(params);
                    count1++;
                }
                else{
                    btn[i].setBackgroundResource(Desktop_go.historyImageCard[newLayoutType][i]);
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=180;
                    btn[i].setLayoutParams(params);
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                    mlp.setMargins(0, 0, 15, 0);
                    count1++;
                    count2++;

                }
            }
            else{
                btn[i].setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                params.width=0;
                params.height=0;
                btn[i].setLayoutParams(params);
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                mlp.setMargins(0, 0, 0, 0);
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!-----------");
        ViewGroup.LayoutParams params= lr_0.getLayoutParams();
        params.width=(count1*150)+(count2*15);
        lr_0.setLayoutParams(params);
        ViewGroup.LayoutParams params2= lr_1.getLayoutParams();
        params2.width=(count1*150)+(count2*15);
        lr_1.setLayoutParams(params2);
    }

    public void editLayout_2(){
        int i;
        int count1;
        int count2;
        count1=count2=0;
        LinearLayout lr_2=(LinearLayout)findViewById(R.id.layout_2);
        TextView [] txt=new TextView[7];
        for(i=0;i<7;i++){
            if(i==0){
                txt[i]=(TextView)findViewById(R.id.layout_2_1);
            }
            else if(i==1){
                txt[i]=(TextView)findViewById(R.id.layout_2_2);
            }
            else if(i==2){
                txt[i]=(TextView)findViewById(R.id.layout_2_3);
            }
            else if(i==3){
                txt[i]=(TextView)findViewById(R.id.layout_2_4);
            }
            else if(i==4){
                txt[i]=(TextView)findViewById(R.id.layout_2_5);
            }
            else if(i==5){
                txt[i]=(TextView)findViewById(R.id.layout_2_6);
            }
            else if(i==6){
                txt[i]=(TextView)findViewById(R.id.layout_2_7);
            }
            if(Desktop_go.posHistory[newLayoutType]>i){
                txt[i].setVisibility(View.INVISIBLE);
                if(Desktop_go.posHistory[newLayoutType]-1==i){
                    ViewGroup.LayoutParams params= txt[i].getLayoutParams();
                    params.width=150;
                    params.height=30;
                    txt[i].setLayoutParams(params);
                    count1++;
                }
                else{
                    ViewGroup.LayoutParams params= txt[i].getLayoutParams();
                    params.width=150;
                    params.height=30;
                    txt[i].setLayoutParams(params);
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) txt[i].getLayoutParams();
                    mlp.setMargins(0, 0, 15, 0);
                    count1++;
                    count2++;

                }
                if(Desktop_go.n_sHistory[newLayoutType][i]==0) {
                    txt[i].setVisibility(View.INVISIBLE);
                }
            }
            else{
                txt[i].setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params= txt[i].getLayoutParams();
                params.width=0;
                params.height=0;
                txt[i].setLayoutParams(params);
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) txt[i].getLayoutParams();
                mlp.setMargins(0, 0, 0, 0);
            }
        }
        ViewGroup.LayoutParams params2= lr_2.getLayoutParams();
        params2.width=(count1*150)+(count2*15);
        lr_2.setLayoutParams(params2);
    }

    public void editLayout_3(){
        int i;
        int count1;
        int count2;
        count1=count2=0;
        LinearLayout lr_3=(LinearLayout)findViewById(R.id.layout_3);
        Button [] btn=new Button[7];
        for(i=0;i<7;i++) {
            if (i == 0) {
                btn[i] = (Button) findViewById(R.id.layout_3_1);
            } else if (i == 1) {
                btn[i] = (Button) findViewById(R.id.layout_3_2);
            } else if (i == 2) {
                btn[i] = (Button) findViewById(R.id.layout_3_3);
            } else if (i == 3) {
                btn[i] = (Button) findViewById(R.id.layout_3_4);
            } else if (i == 4) {
                btn[i] = (Button) findViewById(R.id.layout_3_5);
            } else if (i == 5) {
                btn[i] = (Button) findViewById(R.id.layout_3_6);
            } else if (i == 6) {
                btn[i] = (Button) findViewById(R.id.layout_3_7);
            }
            if(Desktop_go.posHistory[newLayoutType]>i){
                btn[i].setVisibility(View.INVISIBLE);
                if(Desktop_go.posHistory[newLayoutType]-1==i){
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=40;
                    btn[i].setLayoutParams(params);
                    count1++;
                }
                else{
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=40;
                    btn[i].setLayoutParams(params);
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                    mlp.setMargins(0, 0, 15, 0);
                    count1++;
                    count2++;

                }
                if(Desktop_go.n_sHistory[newLayoutType][i]==0) {
                    btn[i].setVisibility(View.INVISIBLE);
                }
            }
            else{
                btn[i].setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                params.width=0;
                params.height=0;
                btn[i].setLayoutParams(params);
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                mlp.setMargins(0, 0, 0, 0);
            }
        }
        ViewGroup.LayoutParams params= lr_3.getLayoutParams();
        params.width=(count1*150)+(count2*15);
        lr_3.setLayoutParams(params);
    }

    public void editLayout_4(){
        int i;
        int count1;
        int count2;
        count1=count2=0;
        LinearLayout [] btn=new LinearLayout[7];
        LinearLayout lr_4=(LinearLayout)findViewById(R.id.layout_4);
        for(i=0;i<7;i++){
            if(i==0){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_1);
            }
            else if(i==1){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_2);
            }
            else if(i==2){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_3);
            }
            else if(i==3){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_4);
            }
            else if(i==4){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_5);
            }
            else if(i==5){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_6);
            }
            else if(i==6){
                btn[i]=(LinearLayout)findViewById(R.id.layout_4_7);
            }
            if(Desktop_go.posHistory[newLayoutType]>i){
                btn[i].setVisibility(View.VISIBLE);
                if(Desktop_go.posHistory[newLayoutType]-1==i){
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=190;
                    btn[i].setLayoutParams(params);
                    count1++;
                }
                else{
                    ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                    params.width=150;
                    params.height=190;
                    btn[i].setLayoutParams(params);
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                    mlp.setMargins(0, 0, 15, 0);
                    count1++;
                    count2++;

                }
                if(Desktop_go.n_sHistory[newLayoutType][i]==0) {
                    btn[i].setVisibility(View.INVISIBLE);
                }
                else{
                    editSuperText(i);
                }
            }
            else{
                btn[i].setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params= btn[i].getLayoutParams();
                params.width=0;
                params.height=0;
                btn[i].setLayoutParams(params);
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) btn[i].getLayoutParams();
                mlp.setMargins(0, 0, 0, 0);
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!-----------");
        ViewGroup.LayoutParams params= lr_4.getLayoutParams();
        params.width=(count1*150)+(count2*15);
        lr_4.setLayoutParams(params);

    }

    public void editSuperText(int pos){
        int i;
        TextView [] txt=new TextView[7];
        if(pos==0){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_1_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][0]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][0][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==1){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_2_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][1]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][1][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==2){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_3_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][2]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][2][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==3){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_4_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][3]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][3][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==4){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_5_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][4]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][4][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==5){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_6_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][5]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][5][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }
        else if(pos==6){
            for(i=0;i<7;i++){
                if(i==0){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_1);
                }
                else if(i==1){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_2);
                }
                else if(i==2){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_3);
                }
                else if(i==3){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_4);
                }
                else if(i==4){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_5);
                }
                else if(i==5){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_6);
                }
                else if(i==6){
                    txt[i]=(TextView)findViewById(R.id.layout_4_7_7);
                }
                if(i<Desktop_go.n_sHistory[newLayoutType][6]){
                    txt[i].setVisibility(View.VISIBLE);
                    txt[i].setText(Desktop_go.soundHistory[newLayoutType][6][i]);
                    txt[i].setTextColor(Color.BLACK);
                }
                else{
                    txt[i].setVisibility(View.INVISIBLE);
                }

            }
        }


    }

    public void playerAmbience(View view){
        newLayoutType=0;
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
        stopPLays();
    }

    public void playerFoley(View view){
        newLayoutType=1;
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
        stopPLays();
    }

    public void playerSoundEffects(View view){
        newLayoutType=2;
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
        stopPLays();
    }

    public void playerMusic(View view){
        newLayoutType=3;
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
        stopPLays();
    }

    public void playerDialogue(View view){
        newLayoutType=4;
        pinta_layouts();
        editLayout_1();
        editLayout_2();
        editLayout_3();
        editLayout_4();
        stopPLays();
    }

    public void stopPLays(){
        play1.stop();
        play2.stop();
        play3.stop();
        play4.stop();
        play5.stop();
        play6.stop();
        play7.stop();
    }

    public void editLr_4_1_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_1_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_1);
        TextView txt=(TextView)findViewById(R.id.layout_2_1);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][0][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_2_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_2);
        TextView txt=(TextView)findViewById(R.id.layout_2_2);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_3_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_3);
        TextView txt=(TextView)findViewById(R.id.layout_2_3);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][2][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_3_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_4_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_4);
        TextView txt=(TextView)findViewById(R.id.layout_2_4);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][3][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][1][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_5_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_5);
        TextView txt=(TextView)findViewById(R.id.layout_2_5);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][4][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_6_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_6);
        TextView txt=(TextView)findViewById(R.id.layout_2_6);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][5][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_1(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][0]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_2(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][1]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_3(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][2]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_4(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][3]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_5(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][4]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_6(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][5]);
        txt.setTextColor(Color.BLACK);
    }

    public void editLr_4_7_7(View view){
        Button btn= (Button)findViewById(R.id.layout_3_7);
        TextView txt=(TextView)findViewById(R.id.layout_2_7);
        stopPLays();
        btn.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(Desktop_go.soundHistory[newLayoutType][6][6]);
        txt.setTextColor(Color.BLACK);
    }

    public void play_1(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_1);
        int music;
        play1.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>" + name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play1= MediaPlayer.create(this, music);
        play1.start();
    }

    public void play_2(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_2);
        int music;
        play2.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play2= MediaPlayer.create(this, music);
        play2.start();
    }

    public void play_3(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_3);
        int music;
        play3.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play3= MediaPlayer.create(this, music);
        play3.start();
    }

    public void play_4(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_4);
        int music;
        play4.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play4= MediaPlayer.create(this, music);
        play4.start();
    }

    public void play_5(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_5);
        int music;
        play5.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play5= MediaPlayer.create(this, music);
        play5.start();
    }

    public void play_6(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_6);
        int music;
        play6.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play6= MediaPlayer.create(this, music);
        play6.start();
    }

    public void play_7(View view){
        //MediaPlayer play;
        String name;
        TextView txt =(TextView)findViewById(R.id.layout_2_7);
        int music;
        play7.stop();
        name=txt.getText().toString();
        System.out.println("------------------------>"+name);
        music=getResources().getIdentifier(name, "raw", getPackageName());
        play7= MediaPlayer.create(this, music);
        play7.start();
    }

    public void stopAllMsc(View view){
        stopPLays();
    }

}
