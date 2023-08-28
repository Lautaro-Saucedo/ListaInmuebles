package com.example.listainmuebles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.listainmuebles.databinding.ActivityMainBinding;
import com.example.listainmuebles.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private List<Inmueble> lista = new ArrayList<>();
    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        MainActivityViewModel vm = ViewModelProvider.AndroidViewModelFactory
                    .getInstance(getApplication())
                    .create(MainActivityViewModel.class);
        vm.getLista().observe(this, new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {
                bind.lvLista.setAdapter(vm.getAdapter(getLayoutInflater()));
            }
        });
        vm.cargarLista();
    }

    /*
    public void generarListView(ArrayList<Inmueble> lista){

        ArrayAdapter<Inmueble> adapter1 = new InmuebleAdapter(this,R.layout.item,lista,getLayoutInflater());
        ArrayAdapter<Inmueble> adapter2 = new ArrayAdapter<Inmueble>(this, R.layout.item,lista){
            @Override
            @NonNull
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.item,parent,false);
                }
                ItemBinding ib = ItemBinding.bind(convertView);
                Inmueble i = lista.get(position);
                ib.ivFoto.setImageResource(i.getFoto());
                ib.tvDireccion.setText(i.getDireccion());
                ib.tvPrecio.setText(i.getPrecio());

                return convertView;
            }
        };
        bind.lvLista.setAdapter(adapter2);
    }

     */




}