package com.example.danielprimo.sounddesk;

/**
 * Created by Daniel Primo on 23/11/2015.
 */
public class Cards {
    public String name;
    public int n_listCard;
    public int n_musics;
    public String [] musicNames;
    public int [] type;
    public int [] n_cards;
    public String [] [] cards;
    public Cards(String linha){
        int i;
        int j;
        int pos;
        System.out.println("ENTREI!!!!!!!!!!");
        String [] partes=linha.split(" ");
        System.out.println("ENTREI_2!!!!!!!!!!"+partes.length);
        name=partes[0];
        n_musics=Integer.parseInt(partes[1]);
        musicNames=new String[n_musics];
        pos=2;
        for(i=0;i<n_musics;i++){
            musicNames[i]=partes[pos];
            pos++;
        }
        System.out.println("ENTREI_3-->"+name+"!!!!!!!!!!");
        n_listCard=Integer.parseInt(partes[pos]);
        type=new int[n_listCard];
        n_cards=new int[n_listCard];
        System.out.println("ENTREI_4!!!!!!!!!!");
        cards=new String [n_listCard][];
        pos++;
        for(i=0;i<n_listCard;i++){
            type[i]=Integer.parseInt(partes[pos]);
            pos++;
            n_cards[i]=Integer.parseInt(partes[pos]);
            pos++;
            cards[i]=new String [n_cards[i]];
            for(j=0;j<n_cards[i];j++){
                cards[i][j]=partes[pos];
                pos++;
            }
        }
    }
}
