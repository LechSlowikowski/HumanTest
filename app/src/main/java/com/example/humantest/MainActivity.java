package com.example.humantest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] pytania ={"Jakie miasto jest stolicą Polski?",
                       "Jakie miasto jest stolicą Francji?",
                       "Jakie miasto jest stolicą Niemiec?",
                       "Ilu było cymbalistów?",
                       "Jak się wabił pies Boryny?"};
    String[] odpowiedzi = {"Warszawa",
                           "Paryż",
                           "Berlin",
                           "wielu",
                           "Łapa"};

    int wylosowane = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pytanie = (TextView) findViewById(R.id.pytanie);
        wylosowane = (int) (Math.random() * 5);
        pytanie.setText(pytania[wylosowane]);
    }

    public void sprawdz(View view) {
        String komunikatStr = "";
        EditText imie = (EditText) findViewById(R.id.imie);
        String imieStr = imie.getText().toString();
        if(imieStr.length()==0) {
            komunikatStr += "Imię jest wymagane. ";
        }

        EditText nazwisko = (EditText) findViewById(R.id.nazwisko);
        String nazwiskoStr = nazwisko.getText().toString();
        if(nazwiskoStr.length()==0) {
            komunikatStr += "Nazwisko jest wymagane. ";
        }

        EditText odpowiedz = (EditText) findViewById(R.id.odpowiedz);
        String odpowiedzStr = odpowiedz.getText().toString();
        odpowiedzStr = odpowiedzStr.toUpperCase();
        String prawidlowaOdpowiedz = odpowiedzi[wylosowane];
        prawidlowaOdpowiedz = prawidlowaOdpowiedz.toUpperCase();

        if(odpowiedzStr.equals(prawidlowaOdpowiedz)){
            komunikatStr = "Zweryfikowano użytkownika " + imieStr + " " + nazwiskoStr + " - witamy w systemie";
        }else{
            komunikatStr += "Nie jesteś istotą ludzką.";
        }

        TextView komunikat = (TextView) findViewById(R.id.komunikat);
        komunikat.setText(komunikatStr);
    }
}