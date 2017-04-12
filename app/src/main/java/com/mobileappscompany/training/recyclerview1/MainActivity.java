package com.mobileappscompany.training.recyclerview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    List<Client> uClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rView);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lM = new LinearLayoutManager(this);
        rv.setLayoutManager(lM);
        initClients();
        ClientAdapter cA = new ClientAdapter(uClients, this);
        rv.setAdapter(cA);

    }

    private void initClients() {
        uClients = new ArrayList<>();
        uClients.add(new Client("Fernando","555-1212"));
        uClients.add(new Client("Joe","38"));
        uClients.add(new Client("Tim","21"));
        uClients.add(new Client("Bill","18"));
        uClients.add(new Client("Claudia","20"));
        uClients.add(new Client("Alex","21"));
        uClients.add(new Client("Jess","23"));
    }

//    public void onItemClicked(View view) {
//        TextView cN, cPh;
//
//        ViewGroup vG = (ViewGroup)view;
//        cN = (TextView) vG.getChildAt(0);
//        cPh = (TextView) vG.getChildAt(1);
//
//        Toast.makeText(this,
//                cN.getText().toString() + " with phone: "
//                + cPh.getText().toString() +
//                " was selected"
//                , Toast.LENGTH_SHORT)
//                .show();
//
//    }
}
