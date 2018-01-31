package com.example.cdsm.tp_11dictionnaireavecfichier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static android.widget.Toast.LENGTH_SHORT;

public class Version2 extends AppCompatActivity {

    Map<String, String> LigneFichier;
    List keys;
    TextView Tv_Def;
    ListView Lv_Mot;
    String Mot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version2);

        Tv_Def = (TextView) findViewById(R.id.textView2);
        Lv_Mot = (ListView) findViewById(R.id.listView);

        LigneFichier = new HashMap<String, String>();

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

        keys = new ArrayList(LigneFichier.keySet());
        Collections.shuffle(keys);

        Mot = keys.get(0).toString();
        Tv_Def.setText(LigneFichier.get(keys.get(0)));

        keys = keys.subList(0,4);

        Collections.shuffle(keys);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, keys);
        Lv_Mot.setAdapter(adapter);

        Lv_Mot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String sMot = keys.get(i).toString();

                if (sMot == Mot)
                {
                    Toast.makeText(getApplicationContext(),"Vrai",LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Faux",LENGTH_SHORT).show();


            }
        });
    }



}
