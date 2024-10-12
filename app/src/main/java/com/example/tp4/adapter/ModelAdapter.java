package com.example.tp4.adapter;

import android.app.AlertDialog;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tp4.R;
import com.example.tp4.beans.Model;
import com.example.tp4.service.ModelService;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> implements Filterable {
    private static final String TAG = "ModelAdapter";
    private List<Model> models;
    private List<Model> modelsFilter;
    private Context context;
    private static NewFilter mfilter;

    public ModelAdapter(Context context, List<Model> models) {
        this.models = models;  // Correction de l'initialisation de la liste
        this.context = context;
        modelsFilter = new ArrayList<>();
        modelsFilter.addAll(models);  // Utilisation correcte de `stars` pour la liste filtrée
        mfilter = new NewFilter(this);
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.model_item, viewGroup, false);
        final ModelViewHolder holder = new ModelViewHolder(v);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popup = LayoutInflater.from(context).inflate(R.layout.model_edit_item, null,
                        false);
                final ImageView img = popup.findViewById(R.id.img);
                final RatingBar bar = popup.findViewById(R.id.ratingBar);
                final TextView idss = popup.findViewById(R.id.idss);
                Bitmap bitmap =
                        ((BitmapDrawable)((ImageView)v.findViewById(R.id.img)).getDrawable()).getBitmap();
                img.setImageBitmap(bitmap);
                bar.setRating(((RatingBar)v.findViewById(R.id.stars)).getRating());
                idss.setText(((TextView)v.findViewById(R.id.ids)).getText().toString());
                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Notez : ")
                        .setMessage("Donner une note entre 1 et 5 :")
                        .setView(popup)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                float s = bar.getRating();
                                int ids = Integer.parseInt(idss.getText().toString());
                                Model star = ModelService.getInstance().findById(ids);
                                star.setStar(s);
                                ModelService.getInstance().update(star);
                                notifyItemChanged(holder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("Annuler", null)
                        .create();
                dialog.show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder starViewHolder, int i) {
        Log.d(TAG, "onBindView call! " + i);
        Glide.with(context)
                .asBitmap()
                .load(modelsFilter.get(i).getImg())
                .apply(new RequestOptions().override(100, 100))
                .into(starViewHolder.img);
        starViewHolder.name.setText(modelsFilter.get(i).getName().toUpperCase());
        starViewHolder.stars.setRating(modelsFilter.get(i).getStar());
        starViewHolder.idss.setText(String.valueOf(modelsFilter.get(i).getId()));
    }

    @Override
    public int getItemCount() {
        return modelsFilter.size();
    }


    public Filter getFilter() {
        return mfilter;
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        TextView idss;
        ImageView img;
        TextView name;
        RatingBar stars;
        RelativeLayout parent;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);

            idss = itemView.findViewById(R.id.ids);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            stars = itemView.findViewById(R.id.stars);
            parent = itemView.findViewById(R.id.parent);
        }
    }

    public class NewFilter extends Filter {
        private final RecyclerView.Adapter mAdapter;

        public NewFilter(RecyclerView.Adapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Model> filteredList = new ArrayList<>();  // Nouvelle liste temporaire pour les résultats filtrés
            final FilterResults results = new FilterResults();
            if (charSequence.length() == 0) {
                filteredList.addAll(models);  // Utilisation de la liste originale lors de l'absence de filtre
            } else {
                final String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Model p : models) {
                    if (p.getName().toLowerCase().startsWith(filterPattern)) {
                        filteredList.add(p);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            modelsFilter.clear();
            modelsFilter.addAll((List<Model>) filterResults.values);
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
