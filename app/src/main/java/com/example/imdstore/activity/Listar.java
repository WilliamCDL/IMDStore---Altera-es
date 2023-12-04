package com.example.imdstore.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;


import com.example.imdstore.R;
import com.example.imdstore.adpter.Adapter;
import com.example.imdstore.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Listar extends AppCompatActivity {

    ImageButton voltar;
    List<Produto> list = new ArrayList<Produto>();
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);

        voltar = findViewById(R.id.voltar);
        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        if (intent.hasExtra("produtos")) {
            list = (List<Produto>) intent.getSerializableExtra("produtos");
        }

        List<Produto> listAuxiliar = new ArrayList<>();
        for (Produto produto : list) {
            listAuxiliar.add(produto);
        }
        if (list.size() != 0) {
            adapter = new Adapter(listAuxiliar);
            recyclerView.setAdapter(adapter);
        }


    }


    public void setVoltar(View vien){
        finish();
    }
}