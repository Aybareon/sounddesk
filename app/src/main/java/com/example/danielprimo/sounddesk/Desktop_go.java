package com.example.danielprimo.sounddesk;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Desktop_go extends AppCompatActivity {
    public  final  static  String EXTRA_MESSAGE =  "com.mycompany.myfirstapp.MESSAGE" ;
    String id;
    String message;
    Cards [] cartas;
    Cards actualCard;
    Cards nextCard;
    public static Cards [] []historyCards;
    public static int [] [] historyImageCard;
    public static int [] posHistory;
    public static String [][][] soundHistory;
    public static int [][] n_sHistory;
    public static ImageButton [] historyButton;
    int [] card;
    ImageButton imageCentralButton;
    LinearLayout solControl;
    LinearLayout op_card;
    LinearLayout sounds;
    int typeCards;
    int pos;
    int optDisponivel;
    int specialCase;
    public static int layoutType;
    int condEntrada;
    int centralCard;
    int rebackSelect;
    int rebackControl;
    MediaPlayer play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i,j;
        cartas = new Cards[78];
        card=new int[6];
        pos=0;
        play=new MediaPlayer();
        historyImageCard=new int[5][7];
        historyCards=new Cards[5][7];
        typeCards=0;
        rebackSelect=0;
        rebackControl=0;
        optDisponivel=0;
        soundHistory=new String[5][7][7];
        n_sHistory=new int[5][7];
        posHistory=new int [5];
        for(i=0;i<5;i++){
            posHistory[i]=0;
            for(j=0;j<7;j++){
                n_sHistory[i][j]=0;
            }
        }
        historyButton=new ImageButton[7];
        try {
            carregaBD();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Get the message from the intent
        Intent intent = getIntent();
        message = intent.getStringExtra(choose_theme.EXTRA_MESSAGE);
        int imageResource;
        Drawable img;
        int chooseCard;
        /*id="";
        char aux;
        int i=message.length()-2;
        while (true){
            if(message.charAt(i)=='/'){
                break;
            }
            aux=message.charAt(i);
            id=aux+id;
            i--;
        }
        //id="@drawable/"+id;
        //id="$"+id;
        i=message.charAt(message.length()-6);
        System.out.println("-->>>"+id);
        i=i-48;
        System.out.println("-->>>" + i);
        System.out.println("-->>>" + R.drawable.cenario1_ihc);*/
        imageResource=getResources().getIdentifier("drawable/"+message,null,getPackageName());
        /*RelativeLayout relative = (RelativeLayout)findViewById(R.id.Desktop_id);
        relative.setBackgroundResource(R.drawable.cenario1_ihc);*/


        // Create the text view
        /*TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Set the text view as the activity layout
        setContentView(textView);*/
        setContentView(R.layout.activity_desktop_go);
        RelativeLayout relative = (RelativeLayout)findViewById(R.id.Desktop_id);
        relative.setBackgroundResource(imageResource);
        /*if(i==1){
            relative.setBackgroundResource(imageResource);
        }
        else if(i==2){
            relative.setBackgroundResource(R.drawable.cenario2_ihc);
        }
        else if(i==3){
            relative.setBackgroundResource(R.drawable.cenrio3_ihc);
        }
        else{
            relative.setBackgroundResource(R.drawable.cenario4_ihc);
        }*/
        sounds=(LinearLayout)findViewById(R.id.showSounds);
        solControl=(LinearLayout)findViewById(R.id.listHistorySounds);
        imageCentralButton = (ImageButton)findViewById(R.id.central_card);
        actualCard=cartas[0];
        centralCard=getResources().getIdentifier("drawable/"+actualCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        op_card=(LinearLayout)findViewById(R.id.option_card);
        System.out.println("-___->" + actualCard.name);
        System.out.println("------------>"+actualCard.cards[0]);
        specialCase=1;
        Button allHst=(Button)findViewById(R.id.allHistory);
        allHst.setVisibility(View.INVISIBLE);
        imageSelect(actualCard);
    }

    private void carregaBD() throws IOException{
        BufferedReader buff =new BufferedReader(new InputStreamReader(getResources().getAssets().open("finalM_allCards.txt")));
        String linha="";
        int i;
        for(i=0;i<78;i++){
            linha = buff.readLine();
            if(linha==null){
                System.out.println("ERRO!!");
            }
            cartas[i]=new Cards(linha);
        }
    }

    private void imageSelect(Cards carta) {
        int i;
        ImageButton [] listButton= new ImageButton[6];
        ImageButton seeMoreButton=(ImageButton)findViewById(R.id.seeMoreButton);
        /*
        for(i=0;i<carta.n_cards;i++){
            System.out.println("-->"+carta.cards[i]);
        }*/
        condEntrada=0;
        System.out.println("Name--->" + carta.name);
        for (i=0;i<6;i++){
            System.out.println("-i-->"+i);
            /*
            card=getResources().getIdentifier("id/card"+i,null,getPackageName());
            System.out.println(card);
            System.out.println(R.id.card1);
            listButton[i]=(ImageButton)findViewById(card);*/
            if(i==0){
                listButton[i]=(ImageButton)findViewById(R.id.card1);
            }
            else if(i==1) {
                listButton[i] = (ImageButton) findViewById(R.id.card2);
            }
            else if(i==2) {
                listButton[i] = (ImageButton) findViewById(R.id.card3);
            }
            else if(i==3) {
                listButton[i] = (ImageButton) findViewById(R.id.card4);
            }
            else if(i==4) {
                listButton[i] = (ImageButton) findViewById(R.id.card5);
            }
            else if(i==5) {
                listButton[i] = (ImageButton) findViewById(R.id.card6);
            }/*
            else if(i==6) {
                listButton[i] = (ImageButton) findViewById(R.id.card7);
            }
            else if(i==7) {
                listButton[i] = (ImageButton) findViewById(R.id.card8);
            }
            else if(i==8) {
                listButton[i] = (ImageButton) findViewById(R.id.card9);
            }
            else if(i==9) {
                listButton[i] = (ImageButton) findViewById(R.id.card10);
            }
            else if(i==10) {
                listButton[i] = (ImageButton) findViewById(R.id.card11);
            }*/
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzz__"+carta.n_listCard);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzzz__"+carta.n_cards[typeCards]);
            if(pos<carta.n_cards[typeCards]){
                System.out.println("bxcnxzmksxincoishsoihsiouhsooooooooo");
                System.out.println("Nunmero de cartas-->"+carta.n_cards[typeCards]);
                listButton[i].setVisibility(View.VISIBLE);
                card[i]=getResources().getIdentifier("drawable/"+carta.cards[typeCards][pos], null, getPackageName());
                listButton[i].setBackgroundResource(card[i]);
                ViewGroup.LayoutParams params= listButton[i].getLayoutParams();
                params.width=150;
                params.height=180;
                listButton[i].setLayoutParams(params);
                pos++;
            }
            else {
                condEntrada=1;
                System.out.println("algo nao esta bem!!");
                listButton[i].setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params= listButton[i].getLayoutParams();
                params.width=0;
                params.height=0;
                listButton[i].setLayoutParams(params);
            }

           // listButton[i].setBackground(getResources().getDrawable(R.,id));

        }
        if(carta.n_cards[typeCards]>6){
            seeMoreButton.setVisibility(View.VISIBLE);
        }
        else{
            seeMoreButton.setVisibility(View.INVISIBLE);
        }
    }

    private int pesquisaCarta(String nome){
        int i;
        System.out.println("ENTREI!!");
        for(i=0;i<78;i++){
            if(nome.equals(cartas[i].name)){
                System.out.println("ENTREI2!!");
                return i;
            }
        }
        return 0;
    }

    public void getCard1(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        System.out.println("Aqui estou!!");
        play.stop();
        imageCentralButton.setBackgroundResource(card[0]);
        imageCentralButton.setEnabled(true);
        System.out.println("Aqui estou2!!");
        if(pos<=6){
            aux=0;
        }
        else if(pos<=12){
            aux=6;
        }
        else{
            aux=12;
        }
        System.out.println("Aqui estou!!3" + actualCard.cards[typeCards][aux]);
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        System.out.println("Aqui estou!!4");
        System.out.println("-->valor=" + valor);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=0;
        }
    }

    public void getCard2(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        play.stop();
        imageCentralButton.setBackgroundResource(card[1]);
        imageCentralButton.setEnabled(true);
        if(pos<=6){
            aux=1;
        }
        else if(pos<=12){
            aux=7;
        }
        else{
            aux=13;
        }
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=1;
        }
    }

    public void getCard3(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        imageCentralButton.setBackgroundResource(card[2]);
        imageCentralButton.setEnabled(true);
        if(pos<=6){
            aux=2;
        }
        else if(pos<=12){
            aux=8;
        }
        else{
            aux=14;
        }
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=2;
        }
    }

    public void getCard4(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        play.stop();
        imageCentralButton.setBackgroundResource(card[3]);
        imageCentralButton.setEnabled(true);
        if(pos<=6){
            aux=3;
        }
        else if(pos<=12){
            aux=9;
        }
        else{
            aux=15;
        }
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=3;
        }
    }

    public void getCard5(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        play.stop();
        imageCentralButton.setBackgroundResource(card[4]);
        imageCentralButton.setEnabled(true);
        if(pos<=6){
            aux=4;
        }
        else if(pos<=12){
            aux=10;
        }
        else{
            aux=16;
        }
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=4;
        }
    }

    public void getCard6(View view) {
        int valor,aux;
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        play.stop();
        imageCentralButton.setBackgroundResource(card[5]);
        imageCentralButton.setEnabled(true);
        if(pos<=6){
            aux=5;
        }
        else if(pos<=12){
            aux=11;
        }
        else{
            aux=17;
        }
        valor=pesquisaCarta(actualCard.cards[typeCards][aux]);
        if(valor!=0){
            nextCard=cartas[valor];
        }
        histSound.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        som.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.VISIBLE);
        certo.setVisibility(View.VISIBLE);
        errado.setVisibility(View.VISIBLE);
        optDisponivel=1;
        if(specialCase==1){
            layoutType=5;
        }
    }

    public void showOption_centralCard(View view){
        Vibrator treme=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        play.stop();
        treme.vibrate(1000);
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(op_card.getVisibility()==View.INVISIBLE) {
            op_card.setVisibility(View.VISIBLE);
        }
        else{
            op_card.setVisibility(View.INVISIBLE);
        }
        if(optDisponivel==0){
            certo.setVisibility(View.INVISIBLE);
            if(posHistory[layoutType]>1){
                errado.setVisibility(View.VISIBLE);
            }
            else{
                errado.setVisibility(View.INVISIBLE);
            }
            if(rebackControl==1){
                if(n_sHistory[layoutType][rebackSelect]==0){
                    histSound.setVisibility(View.INVISIBLE);
                }
                else{
                    histSound.setVisibility(View.VISIBLE);
                }
            }
            else{
                if(n_sHistory[layoutType][posHistory[layoutType]-1]==0){
                    histSound.setVisibility(View.INVISIBLE);
                }
                else{
                    histSound.setVisibility(View.VISIBLE);
                }
            }
            if(actualCard.n_musics==0){
                som.setVisibility(View.INVISIBLE);
            }
            else{
                som.setVisibility(View.VISIBLE);
            }
        }
        else if(optDisponivel==1){
            certo.setVisibility(View.VISIBLE);
            errado.setVisibility(View.VISIBLE);
            som.setVisibility(View.INVISIBLE);
            histSound.setVisibility(View.INVISIBLE);
        }
        else if(optDisponivel==2){
            certo.setVisibility(View.INVISIBLE);
            if(rebackSelect>0){
                errado.setVisibility(View.VISIBLE);
            }
            else{
                errado.setVisibility(View.INVISIBLE);
            }
            if(rebackControl==1){
                if(n_sHistory[layoutType][rebackSelect]==0){
                    histSound.setVisibility(View.INVISIBLE);
                }
                else{
                    histSound.setVisibility(View.VISIBLE);
                }
            }
            else{
                if(n_sHistory[layoutType][posHistory[layoutType]-1]==0){
                    histSound.setVisibility(View.INVISIBLE);
                }
                else{
                    histSound.setVisibility(View.VISIBLE);
                }
            }
            if(actualCard.n_musics==0){
                som.setVisibility(View.INVISIBLE);
            }
            else{
                som.setVisibility(View.VISIBLE);
            }
        }
    }

    public void openLayout(){
        int i;
        TextView [] text=new TextView[5];
        for(i=0;i<5;i++){
            if(i==0){
                text[i]=(TextView)findViewById(R.id.Ambience_text);
            }
            else if(i==1){
                text[i]=(TextView)findViewById(R.id.Foley_text);
            }
            else if(i==2){
                text[i]=(TextView)findViewById(R.id.soundEffects_text);
            }
            else if(i==3){
                text[i]=(TextView)findViewById(R.id.music_text);
            }
            else if(i==4){
                text[i]=(TextView)findViewById(R.id.dialogue_text);
            }
            if(i==layoutType){
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

    public String giveName(int type){
        String name="ERROR";
        if(type==0){
            name="Context";
        }
        else if(type==1){
            name="Contrast with";
        }
        else if(type==2){
            name="May Imply";
        }
        else if(type==3){
            name="Often Uses";
        }
        else if(type==4){
            name="Calls For";
        }
        else if(type==5){
            name="May Related To";
        }
        else if(type==6){
            name="Relates To";
        }
        else if(type==7){
            name="Peers";
        }
        else if(type==8){
            name="May use";
        }
        else if(type==9){
            name="Makes use";
        }
        else if(type==10){
            name="Possibly With";
        }
        else if(type==11){
            name="Includes";
        }
        else if(type==12){
            name="Close To";
        }
        else if(type==13){
            name="Compromises With";
        }
        else if(type==14){
            name="Differs From";
        }
        else if(type==15){
            name="Should Not Compromise";
        }
        else if(type==16){
            name="Parts";
        }
        return name;
    }

    public void listTypes(){
        int i;
        int count;
        count=0;
        LinearLayout centralLayout=(LinearLayout)findViewById(R.id.layout_types);
        TextView [] text=new TextView[5];
        for(i=0;i<5;i++){
            if(i==0){
                text[i]=(TextView)findViewById(R.id.type_1);
            }
            else if(i==1){
                text[i]=(TextView)findViewById(R.id.type_2);
            }
            else if(i==2){
                text[i]=(TextView)findViewById(R.id.type_3);
            }
            else if(i==3){
                text[i]=(TextView)findViewById(R.id.type_4);
            }
            else if(i==4){
                text[i]=(TextView)findViewById(R.id.type_5);
            }
            if(i<actualCard.n_listCard){
                count++;
                ViewGroup.LayoutParams params= text[i].getLayoutParams();
                params.width=150;
                params.height=25;
                text[i].setLayoutParams(params);
                if(i>0){
                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) text[i].getLayoutParams();
                    mlp.setMargins(10, 0, 0, 0);
                }
                text[i].setText(giveName(actualCard.type[i]));
                if(i==typeCards){
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setEnabled(false);
                    text[i].setBackgroundColor(Color.WHITE);
                    text[i].setTextColor(Color.BLACK);
                }
                else {
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setEnabled(true);
                    text[i].setBackgroundColor(Color.BLACK);
                    text[i].setTextColor(Color.WHITE);
                }
            }
            else{
                text[i].setVisibility(View.INVISIBLE);
                text[i].setEnabled(false);
                ViewGroup.LayoutParams params= text[i].getLayoutParams();
                params.width=0;
                params.height=0;
                text[i].setLayoutParams(params);
            }

        }
        if(count==1){
            ViewGroup.LayoutParams params= centralLayout.getLayoutParams();
            params.width=150;
            params.height=25;
            centralLayout.setLayoutParams(params);
        }
        else{
            ViewGroup.LayoutParams params= centralLayout.getLayoutParams();
            params.width=(150*count)+(10*(count-1));
            params.height=25;
            centralLayout.setLayoutParams(params);
        }
    }

    public void aceptCard(View view){
        int i;
        CheckBox [] check=new CheckBox[7];
        TextView [] text=new TextView[7];
        Button allHst= (Button)findViewById(R.id.allHistory);
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton histSound= (ImageButton)findViewById(R.id.sonsHist);
        pos=0;
        allHst.setVisibility(View.VISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        if(rebackControl==1){
            for(i=rebackSelect+1;i<posHistory[layoutType];i++){
                System.out.println("aqui!!");
                historyButton[i].setVisibility(View.INVISIBLE);
            }
            rebackControl=0;
            posHistory[layoutType]=rebackSelect+1;
        }
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        actualCard=nextCard;
        if(specialCase==1){
            openLayout();
        }
        specialCase=0;
        typeCards=0;
        optDisponivel=0;
        preencheHistorico(0);
        imageSelect(nextCard);
        listTypes();
        if(actualCard.n_musics!=0){
            op_card.setVisibility(View.VISIBLE);
            sounds.setVisibility(View.VISIBLE);
            certo.setVisibility(View.INVISIBLE);
            histSound.setVisibility(View.INVISIBLE);
            errado.setVisibility(View.INVISIBLE);
            som.setVisibility(View.VISIBLE);
            for(i=0;i<7;i++) {
                if (i == 0) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox1);
                    text[i] = (TextView) findViewById(R.id.musicName1);
                } else if (i == 1) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox2);
                    text[i] = (TextView) findViewById(R.id.musicName2);
                } else if (i == 2) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox3);
                    text[i] = (TextView) findViewById(R.id.musicName3);
                } else if (i == 3) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox4);
                    text[i] = (TextView) findViewById(R.id.musicName4);
                } else if (i == 4) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox5);
                    text[i] = (TextView) findViewById(R.id.musicName5);
                } else if (i == 5) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox6);
                    text[i] = (TextView) findViewById(R.id.musicName6);
                } else if (i == 6) {
                    check[i] = (CheckBox) findViewById(R.id.checkBox7);
                    text[i] = (TextView) findViewById(R.id.musicName7);
                }
                check[i].setChecked(false);
                if (i < actualCard.n_musics) {
                    check[i].setVisibility(View.VISIBLE);
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setText(actualCard.musicNames[i]);
                } else {
                    check[i].setVisibility(View.INVISIBLE);
                    text[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        posHistory[layoutType]++;
    }

    public void rejectCard(View view){
        int i;
        pos=0;
        rebackControl=0;
        op_card.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        sounds.setVisibility(View.INVISIBLE);
        if(optDisponivel==0){
            historyButton[posHistory[layoutType]-1].setVisibility(View.INVISIBLE);
            centralCard=getResources().getIdentifier("drawable/"+historyCards[layoutType][posHistory[layoutType]-2].name, null, getPackageName());
            imageCentralButton.setBackgroundResource(historyImageCard[layoutType][posHistory[layoutType]-2]);
            actualCard=historyCards[layoutType][posHistory[layoutType]-2];
            nextCard=actualCard;
            imageSelect(historyCards[layoutType][posHistory[layoutType]-2]);
            typeCards=0;
            listTypes();
            posHistory[layoutType]--;
        }
        else if(optDisponivel==1){
            imageCentralButton.setBackgroundResource(centralCard);
        }
        else if(optDisponivel==2){
            for(i=rebackSelect;i<posHistory[layoutType];i++){
                System.out.println("aqui!!");
                historyButton[i].setVisibility(View.INVISIBLE);
            }
            centralCard=getResources().getIdentifier("drawable/"+historyCards[layoutType][rebackSelect-1].name, null, getPackageName());
            imageCentralButton.setBackgroundResource(historyImageCard[layoutType][rebackSelect-1]);
            actualCard=historyCards[layoutType][rebackSelect-1];
            nextCard=actualCard;
            imageSelect(historyCards[layoutType][rebackSelect-1]);
            typeCards=0;
            listTypes();
            posHistory[layoutType]=rebackSelect;
        }

        //imageCentralButton.setEnabled(false);
        optDisponivel=0;
    }

    public void showSounds(View view){
        int i;
        Cards auxCard;
        play.stop();
        CheckBox [] check=new CheckBox[7];
        TextView [] text=new TextView[7];
        auxCard=nextCard;
        if(optDisponivel==0){
            auxCard=actualCard;
        }
        if(sounds.getVisibility()==View.INVISIBLE) {
            sounds.setVisibility(View.VISIBLE);
        }
        else{
            sounds.setVisibility(View.INVISIBLE);
        }
        for(i=0;i<7;i++){
            if(i==0){
                check[i]=(CheckBox)findViewById(R.id.checkBox1);
                text[i]=(TextView)findViewById(R.id.musicName1);
            }
            else if(i==1){
                check[i]=(CheckBox)findViewById(R.id.checkBox2);
                text[i]=(TextView)findViewById(R.id.musicName2);
            }
            else if(i==2){
                check[i]=(CheckBox)findViewById(R.id.checkBox3);
                text[i]=(TextView)findViewById(R.id.musicName3);
            }
            else if(i==3){
                check[i]=(CheckBox)findViewById(R.id.checkBox4);
                text[i]=(TextView)findViewById(R.id.musicName4);
            }
            else if(i==4){
                check[i]=(CheckBox)findViewById(R.id.checkBox5);
                text[i]=(TextView)findViewById(R.id.musicName5);
            }
            else if(i==5){
                check[i]=(CheckBox)findViewById(R.id.checkBox6);
                text[i]=(TextView)findViewById(R.id.musicName6);
            }
            else if(i==6){
                check[i]=(CheckBox)findViewById(R.id.checkBox7);
                text[i]=(TextView)findViewById(R.id.musicName7);
            }
            check[i].setChecked(false);
            if(i<auxCard.n_musics){
                check[i].setVisibility(View.VISIBLE);
                text[i].setVisibility(View.VISIBLE);
                text[i].setText(auxCard.musicNames[i]);
            }
            else{
                check[i].setVisibility(View.INVISIBLE);
                text[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    public void moreCards(View view){
        play.stop();
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(condEntrada==1 || pos==actualCard.n_cards[typeCards]){
            pos=0;
        }
        imageSelect(nextCard);
    }

    public void preencheHistorico(int type){
        int i;
        historyCards[layoutType][posHistory[layoutType]]=actualCard;
        historyImageCard[layoutType][posHistory[layoutType]]=centralCard;
        if(type==1){
            for(i=0;i<7;i++) {
                if (i == 0) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_1);
                } else if (i == 1) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_2);
                } else if (i == 2) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_3);
                } else if (i == 3) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_4);
                } else if (i == 4) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_5);
                } else if (i == 5) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_6);
                } else if (i == 6) {
                    historyButton[i] = (ImageButton) findViewById(R.id.hist_7);
                }
                if(posHistory[layoutType]==0){
                    historyButton[i].setVisibility(View.VISIBLE);
                    historyButton[i].setBackgroundResource(historyImageCard[layoutType][i]);
                }
                else if (i <posHistory[layoutType]) {
                    historyButton[i].setVisibility(View.VISIBLE);
                    historyButton[i].setBackgroundResource(historyImageCard[layoutType][i]);
                } else {
                    historyButton[i].setVisibility(View.INVISIBLE);
                }
            }
            if(posHistory[layoutType]==0){
                posHistory[layoutType]++;
            }
        }
        else{
            if(posHistory[layoutType]==0){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_1);
            }
            else if(posHistory[layoutType]==1){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_2);
            }
            else if(posHistory[layoutType]==2){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_3);
            }
            else if(posHistory[layoutType]==3){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_4);
            }
            else if(posHistory[layoutType]==4){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_5);
            }
            else if(posHistory[layoutType]==5){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_6);
            }
            else if(posHistory[layoutType]==6){
                historyButton[posHistory[layoutType]]=(ImageButton)findViewById(R.id.hist_7);
            }
            historyButton[posHistory[layoutType]].setVisibility(View.VISIBLE);
            historyButton[posHistory[layoutType]].setBackgroundResource(historyImageCard[layoutType][posHistory[layoutType]]);
        }
    }

    public void showHist_on_Reback(){
        int i;
        TextView [] text=new TextView[6];
        LinearLayout histSounds=(LinearLayout)findViewById(R.id.listHistorySounds);
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton sol=(ImageButton)findViewById(R.id.sonsHist);
        op_card.setVisibility(View.VISIBLE);
        histSounds.setVisibility(View.VISIBLE);
        certo.setVisibility(View.INVISIBLE);
        errado.setVisibility(View.INVISIBLE);
        som.setVisibility(View.VISIBLE);
        sol.setVisibility(View.VISIBLE);
        for(i=0;i<6;i++){
            if(i==0){
                text[i]=(TextView)findViewById(R.id.soundHist1);
            }
            else if(i==1){
                text[i]=(TextView)findViewById(R.id.soundHist2);
            }
            else if(i==2){
                text[i]=(TextView)findViewById(R.id.soundHist3);
            }
            else if(i==3){
                text[i]=(TextView)findViewById(R.id.soundHist4);
            }
            else if(i==4){
                text[i]=(TextView)findViewById(R.id.soundHist5);
            }
            else if(i==5){
                text[i]=(TextView)findViewById(R.id.soundHist6);
            }
            if(rebackControl==1){
                if(i<n_sHistory[layoutType][rebackSelect]){
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setText(soundHistory[layoutType][rebackSelect][i]);
                }
                else{
                    text[i].setVisibility(View.INVISIBLE);
                }
            }
            else{
                if(i<n_sHistory[layoutType][posHistory[layoutType]-1]){
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setText(soundHistory[layoutType][posHistory[layoutType]-1][i]);
                }
                else{
                    text[i].setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    public void reBack1(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=0;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);

        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][0]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][0];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][0]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();

    }

    public void reBack2(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=1;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][1]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][1];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][1]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();
    }

    public void reBack3(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=2;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][2]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][2];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][2]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();
    }

    public void reBack4(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=3;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][3]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][3];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][3]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();
    }

    public void reBack5(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=4;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][4]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][4];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][4]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();
    }

    public void reBack6(View view) {
        int i;
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=5;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][5]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][5];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][5]);
        System.out.println("aqui ando...5");
        showHist_on_Reback();
    }

    public void reBack7(View view) {
        pos=0;
        play.stop();
        typeCards=0;
        rebackSelect=6;
        rebackControl=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(historyImageCard[layoutType][6]);
        //imageCentralButton.setEnabled(false);
        System.out.println("aqui ando...3");
        actualCard=historyCards[layoutType][6];
        nextCard=actualCard;
        optDisponivel =2;
        listTypes();
        System.out.println("aqui ando...4" + actualCard.name);
        imageSelect(historyCards[layoutType][6]);
        System.out.println("aqui ando...5");
    }

    public void ambienceLayout(View view){
        pos=0;
        play.stop();
        layoutType=0;
        rebackControl=0;
        optDisponivel=0;
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(posHistory[layoutType]==0){
            actualCard=cartas[6];
        }
        else{
            actualCard=historyCards[0][posHistory[0]-1];
        }
        nextCard = actualCard;
        op_card.setVisibility(View.INVISIBLE);
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        openLayout();
        imageSelect(actualCard);
        listTypes();
        preencheHistorico(1);
    }

    public void foleyLayout(View view){
        pos=0;
        play.stop();
        layoutType=1;
        optDisponivel=0;
        rebackControl=0;
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(posHistory[layoutType]==0){
            actualCard=cartas[28];
        }
        else{
            actualCard=historyCards[1][posHistory[1]-1];
        }
        nextCard = actualCard;
        op_card.setVisibility(View.INVISIBLE);
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        openLayout();
        imageSelect(actualCard);
        listTypes();
        preencheHistorico(1);
    }

    public void soundEffectsLayout(View view){
        pos=0;
        play.stop();
        layoutType=2;
        optDisponivel=0;
        rebackControl=0;
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(posHistory[layoutType]==0){
            actualCard=cartas[63];
        }
        else{
            actualCard=historyCards[2][posHistory[2]-1];
        }
        nextCard = actualCard;
        op_card.setVisibility(View.INVISIBLE);
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        openLayout();
        imageSelect(actualCard);
        listTypes();
        preencheHistorico(1);
    }

    public void musicLayout(View view){
        pos=0;
        play.stop();
        layoutType=3;
        optDisponivel=0;
        rebackControl=0;
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(posHistory[layoutType]==0){
            actualCard=cartas[41];
        }
        else{
            actualCard=historyCards[3][posHistory[3]-1];
        }
        nextCard = actualCard;
        op_card.setVisibility(View.INVISIBLE);
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        openLayout();
        imageSelect(actualCard);
        listTypes();
        preencheHistorico(1);
    }

    public void dialogueLayout(View view){
        pos=0;
        play.stop();
        layoutType=4;
        optDisponivel=0;
        rebackControl=0;
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        if(posHistory[layoutType]==0){
            actualCard=cartas[18];
        }
        else{
            actualCard=historyCards[4][posHistory[4]-1];
        }
        nextCard = actualCard;
        op_card.setVisibility(View.INVISIBLE);
        centralCard=getResources().getIdentifier("drawable/"+nextCard.name, null, getPackageName());
        imageCentralButton.setBackgroundResource(centralCard);
        imageCentralButton.setEnabled(false);
        openLayout();
        imageSelect(actualCard);
        listTypes();
        preencheHistorico(1);
    }

    public void showType1(View view){
        pos=0;
        play.stop();
        typeCards=0;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        imageSelect(actualCard);
        listTypes();
    }

    public void showType2(View view){
        pos=0;
        play.stop();
        typeCards=1;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageSelect(actualCard);
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        listTypes();
    }

    public void showType3(View view){
        pos=0;
        play.stop();
        typeCards=2;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageSelect(actualCard);
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        listTypes();
    }

    public void showType4(View view){
        pos=0;
        play.stop();
        typeCards=3;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageSelect(actualCard);
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        listTypes();
    }

    public void showType5(View view){
        pos=0;
        play.stop();
        typeCards=4;
        sounds.setVisibility(View.INVISIBLE);
        solControl.setVisibility(View.INVISIBLE);
        op_card.setVisibility(View.INVISIBLE);
        imageSelect(actualCard);
        imageCentralButton.setBackgroundResource(centralCard);
        //imageCentralButton.setEnabled(false);
        listTypes();
    }

    public void stopPlays(){
        if(play.isPlaying()){
            play.stop();
        }

    }

    public void playMusic1(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[0], "raw", getPackageName());
        play=MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic2(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[1], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic3(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[2], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic4(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[3], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic5(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[4], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic6(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[5], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void playMusic7(View view){
        int music;
        play.stop();
        music=getResources().getIdentifier(nextCard.musicNames[6], "raw", getPackageName());
        play = MediaPlayer.create(this, music);
        play.start();
        //stopOtherPlays();
    }

    public void okButton(View view){
        int i;
        int control;
        TextView [] text=new TextView[6];
        LinearLayout histSounds=(LinearLayout)findViewById(R.id.listHistorySounds);
        ImageButton som= (ImageButton)findViewById(R.id.sons);
        ImageButton certo= (ImageButton)findViewById(R.id.acept);
        ImageButton errado= (ImageButton)findViewById(R.id.rejeita);
        ImageButton sol=(ImageButton)findViewById(R.id.sonsHist);
        Cards auxCard;
        control=0;
        play.stop();
        int [] auxList=new int[7];
        auxCard=nextCard;
        sounds.setVisibility(View.INVISIBLE);
        if(optDisponivel==0){
            auxCard=actualCard;
        }
        if(rebackControl==1){
            n_sHistory[layoutType][rebackSelect]=0;
        }
        else{
            n_sHistory[layoutType][posHistory[layoutType]-1]=0;
        }
        //n_sHistory[layoutType][posHistory[layoutType]]=0;
        CheckBox [] checkchek=new CheckBox[7];
        for(i=0;i<7;i++){
            if(i==0){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox1);
            }
            else if(i==1){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox2);
            }
            else if(i==2){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox3);
            }
            else if(i==3){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox4);
            }
            else if(i==4){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox5);
            }
            else if(i==5){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox6);
            }
            else if(i==6){
                checkchek[i]=(CheckBox)findViewById(R.id.checkBox7);
            }
            if(checkchek[i].isChecked()){
                auxList[i]=1;
                control=1;
            }
            else{
                auxList[i]=0;
            }
        }
        if(control==1){
            for(i=0;i<7;i++){
                if(auxList[i]==1){
                    System.out.println("I-->>>>>>>>>"+i);
                    if(rebackControl==1){
                        soundHistory[layoutType][rebackSelect][n_sHistory[layoutType][rebackSelect]]=auxCard.musicNames[i];
                        n_sHistory[layoutType][rebackSelect]++;
                    }
                    else{
                        soundHistory[layoutType][posHistory[layoutType]-1][n_sHistory[layoutType][posHistory[layoutType]-1]]=auxCard.musicNames[i];
                        n_sHistory[layoutType][posHistory[layoutType]-1]++;
                    }

                }
            }

            op_card.setVisibility(View.VISIBLE);
            histSounds.setVisibility(View.VISIBLE);
            certo.setVisibility(View.INVISIBLE);
            errado.setVisibility(View.INVISIBLE);
            som.setVisibility(View.VISIBLE);
            sol.setVisibility(View.VISIBLE);
            for(i=0;i<6;i++){
                if(i==0){
                    text[i]=(TextView)findViewById(R.id.soundHist1);
                }
                else if(i==1){
                    text[i]=(TextView)findViewById(R.id.soundHist2);
                }
                else if(i==2){
                    text[i]=(TextView)findViewById(R.id.soundHist3);
                }
                else if(i==3){
                    text[i]=(TextView)findViewById(R.id.soundHist4);
                }
                else if(i==4){
                    text[i]=(TextView)findViewById(R.id.soundHist5);
                }
                else if(i==5){
                    text[i]=(TextView)findViewById(R.id.soundHist6);
                }
                if(rebackControl==1){
                    if(i<n_sHistory[layoutType][rebackSelect]){
                        text[i].setVisibility(View.VISIBLE);
                        text[i].setText(soundHistory[layoutType][rebackSelect][i]);
                    }
                    else{
                        text[i].setVisibility(View.INVISIBLE);
                    }
                }
                else{
                    if(i<n_sHistory[layoutType][posHistory[layoutType]-1]){
                        text[i].setVisibility(View.VISIBLE);
                        text[i].setText(soundHistory[layoutType][posHistory[layoutType]-1][i]);
                    }
                    else{
                        text[i].setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
        System.out.println("layout->" + layoutType + "pos->" + posHistory[layoutType] + "total->" + n_sHistory[layoutType][posHistory[layoutType]]);


    }

    public void showSoundsHist(View view){
        LinearLayout histSounds=(LinearLayout)findViewById(R.id.listHistorySounds);
        int i;
        TextView [] text=new TextView[6];
        if(histSounds.getVisibility()==View.INVISIBLE) {
            histSounds.setVisibility(View.VISIBLE);
        }
        else{
            histSounds.setVisibility(View.INVISIBLE);
        }
        for(i=0;i<6;i++){
            if(i==0){
                text[i]=(TextView)findViewById(R.id.soundHist1);
            }
            else if(i==1){
                text[i]=(TextView)findViewById(R.id.soundHist2);
            }
            else if(i==2){
                text[i]=(TextView)findViewById(R.id.soundHist3);
            }
            else if(i==3){
                text[i]=(TextView)findViewById(R.id.soundHist4);
            }
            else if(i==4){
                text[i]=(TextView)findViewById(R.id.soundHist5);
            }
            else if(i==5){
                text[i]=(TextView)findViewById(R.id.soundHist6);
            }
            if(rebackControl==1){
                if(i<n_sHistory[layoutType][rebackSelect]){
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setText(soundHistory[layoutType][rebackSelect][i]);
                }
                else{
                    text[i].setVisibility(View.INVISIBLE);
                }
            }
            else{
                if(i<n_sHistory[layoutType][posHistory[layoutType]-1]){
                    text[i].setVisibility(View.VISIBLE);
                    text[i].setText(soundHistory[layoutType][posHistory[layoutType]-1][i]);
                }
                else{
                    text[i].setVisibility(View.INVISIBLE);
                }
            }
        }
        System.out.println("2222layout->" + layoutType + "pos->" + posHistory[layoutType] + "total->" + n_sHistory[layoutType][posHistory[layoutType]]);
    }

    public void playHistory1(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][0], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][0], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void playHistory2(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][1], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][1], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void playHistory3(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][2], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][2], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void playHistory4(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][3], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][3], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void playHistory5(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][4], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][4], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void playHistory6(View view){
        int music;
        play.stop();
        if(rebackControl==1){
            music=getResources().getIdentifier(soundHistory[layoutType][rebackSelect][5], "raw", getPackageName());
        }
        else{
            music=getResources().getIdentifier(soundHistory[layoutType][posHistory[layoutType]-1][5], "raw", getPackageName());
        }
        play = MediaPlayer.create(this, music);
        play.start();
    }

    public void clearHistory(View viewm){
        LinearLayout histSounds=(LinearLayout)findViewById(R.id.listHistorySounds);
        ImageButton sol=(ImageButton)findViewById(R.id.sonsHist);
        if(rebackControl==1){
            n_sHistory[layoutType][rebackSelect]=0;
        }
        else{
            n_sHistory[layoutType][posHistory[layoutType]-1]=0;
        }
        histSounds.setVisibility(View.INVISIBLE);
        sol.setVisibility(View.INVISIBLE);
    }

    public void fullLayout(View view){
        play.stop();
        Intent intent= new Intent (this, sounds_Layout.class);
        //ImageButton editIButton = (ImageButton)findViewById(R.id.cenario1_ihc);
        //String message=editIButton.toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        this.startActivity(intent);
    }

}
