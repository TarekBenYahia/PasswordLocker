package com.example.agendarevision;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agendarevision.Entite.Model;

public class Ajouter extends Fragment {
    Button Ajouter;
    EditText pass,name;
    private AppDataBase dataBase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ajouter, container, false);

        Ajouter = view.findViewById(R.id.Ajouter);
        pass = view.findViewById(R.id.pass);
        name = view.findViewById(R.id.name);

        

        
        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().equals("") || name.getText().toString().equals(""))
                {
                    Toast.makeText(getContext(), "Champs Vides", Toast.LENGTH_SHORT).show();
                }
                else {
                    String titre = name.getText().toString();
                    String motDP = pass.getText().toString();
                    Model model1 =new Model(titre,motDP);
                    dataBase = AppDataBase.getAppDatabase(getContext());
                    AppDataBase.getAppDatabase(getContext()).userDao().insertOne(model1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Succès");
                    builder.setMessage("Ajouté Avec Succès");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                            getFragmentManager().beginTransaction().replace (R.id.fragment_container, new acceuil()).commit();
                        }
                    });
                    builder.create();
                    builder.show();


                }
            }
        });

        return view;
    }
}