package com.sp.orderpizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spnSize;
    CheckBox cbCorn, cbOnion, cbCheese, cbOlive;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnSize = (Spinner)findViewById(R.id.spnSize);
        cbCorn = (CheckBox)findViewById(R.id.cbCorn);
        cbOnion = (CheckBox)findViewById(R.id.cbOnion);
        cbCheese = (CheckBox)findViewById(R.id.cbCheese);
        cbOlive = (CheckBox)findViewById(R.id.cbOlive);
        btnOrder = (Button)findViewById(R.id.btnOrder);

        final ArrayList<String> size = new ArrayList<>();
        size.add("Small");
        size.add("Medium");
        size.add("Large");

        ArrayAdapter a = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, size);
        spnSize.setAdapter(a);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = spnSize.getSelectedItemPosition();
                String s = size.get(i);
                String top = "";
                if (cbCorn.isChecked())
                    top = top + "Corn ";
                if (cbCheese.isChecked())
                    top = top + "Cheese ";
                if (cbOlive.isChecked())
                    top = top + "Olive ";
                if (cbOnion.isChecked())
                    top = top + "Onion ";

                String msg = "Size " + s + " Toppings " + top;
                Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
