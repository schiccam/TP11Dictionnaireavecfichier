package com.example.cdsm.tp_11dictionnaireavecfichier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity
{

    EditText Edt_Nom;
    TextView Tv_Definition;
    Map<String, String> LigneFichier;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edt_Nom = (EditText) findViewById(R.id.editText);
        Tv_Definition = (TextView) findViewById(R.id.textView);


    }


    public void RechercheisClicked(View view)
    {
        String Mot;

        LigneFichier = new HashMap<String, String>();
        Mot = Edt_Nom.getText().toString();


        Scanner scan =  new Scanner(getResources().openRawResource(R.raw.dict));
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] arr = line.split(" ",2);
            String First = arr[0];
            String Second = arr[1];

            LigneFichier.put(First, Second);
        }
        scan.close();

        Tv_Definition.setText(LigneFichier.get(Mot));
    }

    public void V2isClicked(View view)
    {
        Intent intent = new Intent(this,Version2.class);
        startActivity(intent);
    }
}
