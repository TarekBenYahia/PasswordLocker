package com.example.agendarevision.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendarevision.AppDataBase;
import com.example.agendarevision.Entite.Model;
import com.example.agendarevision.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterMdp extends RecyclerView.Adapter<AdapterMdp.MyViewHolder> {
    private Context mContext;
    private List<Model> objects = new ArrayList<>();
    private AppDataBase dataBase;
    public  static Model currentUser;

    public AdapterMdp(Context context, List<Model> objects) {
        this.objects = objects;
        this.mContext = context;
        dataBase = AppDataBase.getAppDatabase(mContext);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mNom,mdp;
        private ImageView image,star;

        private LinearLayout mContainer;

        public MyViewHolder(View view) {
            super(view);
            mNom = view.findViewById(R.id.nom);
            mdp = view.findViewById(R.id.mdp);
            mContainer = view.findViewById(R.id.container_amis);
            star = view.findViewById(R.id.supprimerAmi);
            image = view.findViewById(R.id.imageAmis);
        }
    }

    public AdapterMdp() {
        super();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final Model object = objects.get(position);


        holder.mNom.setText(object.getNom());
        holder.star.setImageResource(R.drawable.ic_delete_friend);
        holder.image.setImageResource(R.drawable.ic_baseline_lock_24);
        Log.d("id " , String.valueOf(object.getUid()));

        holder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase.getAppDatabase(mContext).userDao().delete(object);
                AdapterMdp.this.notifyChange(
                        AppDataBase.getAppDatabase(mContext).userDao().getAll());
                Toaster();


            }

        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mdp.getText().toString().equals("********"))
                {holder.mdp.setText(object.getMdp());}
                else
                {
                    holder.mdp.setText("********");
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return objects.size();
    }

    public void notifyChange(List<Model> users)
    {
        this.objects =users;
        this.notifyDataSetChanged();
    }
    public void Toaster()
    {
        Toast.makeText(mContext, "Supprimé", Toast.LENGTH_SHORT).show();
    }




}