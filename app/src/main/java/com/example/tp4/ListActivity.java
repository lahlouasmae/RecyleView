package com.example.tp4;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



import androidx.core.app.ShareCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp4.adapter.ModelAdapter;
import com.example.tp4.beans.Model;
import com.example.tp4.service.ModelService;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;



public class ListActivity extends AppCompatActivity {
    private List<Model> models;
    private RecyclerView recyclerView;
    private ModelAdapter modelAdapter = null;
    private ModelService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Utiliser androidx.appcompat.widget.Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        models = new ArrayList<>();
        service = ModelService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);

        modelAdapter = new ModelAdapter(this, service.findAll());
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void init(){
        service.create(new Model("Bella Hadida", "https://www.yournextshoes.com/wp-content/uploads/2017/05/Bella-Hadid-earrings.jpg", 4.5f));
        service.create(new  Model("Gigi Hadid", "https://media1.popsugar-assets.com/files/thumbor/pbAKvq2JfZ5-ZKwfjAzJKo9YmK8/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2017/11/20/827/n/43698391/4d3885770587c355_GettyImages-873807656/i/Gigi-Hadid.jpg", 4));
        service.create(new  Model("kendall jenner",
                "https://i.pinimg.com/736x/22/0f/ac/220fac86fa04f4fae1d11f0a1c3a6701.jpg", 5));
        service.create(new  Model("Vittoria Ceretti", "https://stories.cnnbrasil.com.br/wp-content/uploads/sites/9/2023/11/cropped-Sem-titulo-97.png", 4));
        service.create(new  Model("Yasmin Wijnaldum", "https://w0.peakpx.com/wallpaper/23/627/HD-wallpaper-yasmin-wijnaldum-women-model-dutch-green-eyes-simple-background-white-background-face-brunette-dark-hair-long-hair.jpg", 5));
        service.create(new Model("Imaan Hammam", "https://static.harpersbazaar.de/3840x5486/focal_580x870:581x871/images/2021-02/biotin-haarausfall-fendi-bbt-f17-017.jpg", 4));
        service.create(new Model("Irina Shayk", "https://i.pinimg.com/originals/ba/84/8f/ba848fcc57bd529b4f27e07829787e2c.jpg", 3.5f));
        service.create(new Model("Gisele Bündchen", "https://i.pinimg.com/736x/73/2b/cd/732bcde891f79def3254f15f587b5cde--gisele-model-hair-colors-.jpg", 3.5f));
        service.create(new Model("Shalom Harlow", "https://i.pinimg.com/736x/0c/45/af/0c45af8e14f418b6a51e0c59dfc7968e--shalom-harlow-layered-curly-hairstyles.jpg", 4));
        service.create(new Model("Naomi Campbell", "https://www.velvetgossip.it/wp-content/uploads/2019/09/naomi-campbell-1.jpg", 3));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.loupe);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (modelAdapter != null) {
                    // Utilisation correcte de l'instance pour appeler le filtre
                    modelAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Models";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Models")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }


}
