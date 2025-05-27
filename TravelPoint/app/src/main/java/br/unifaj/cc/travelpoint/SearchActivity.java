package br.unifaj.cc.travelpoint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    List<DataItem> listData;
    int current_page = 0;
    CustomAdapter adapter;
    SearchView searchView;
    ListView listView;
    Button btnLoadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);

        listView = findViewById(R.id.list_view);
        searchView = findViewById(R.id.search_view);

        listData = new ArrayList<>();
        listData.add(new DataItem(R.drawable.carousel_image1, "Thermas dos Laranjais"));
        listData.add(new DataItem(R.drawable.carousel_image2, "Aparecida do Norte"));
        listData.add(new DataItem(R.drawable.carousel_image3, "Torre de Miroku"));

        adapter = new CustomAdapter(this, R.layout.itemrow, getData(current_page));
        listView.setAdapter(adapter);

        btnLoadMore = new Button(this);
        btnLoadMore.setText("Load more");
        listView.addFooterView(btnLoadMore);

        btnLoadMore.setOnClickListener(v -> {
            current_page += 1;
            int currentPosition = listView.getFirstVisiblePosition();
            if ((current_page * 3) < listData.size()) {
                List<DataItem> newItems = getData(current_page);
                adapter.addAll(newItems);
                adapter.notifyDataSetChanged();
                listView.setSelectionFromTop(currentPosition + 1, 0);
            }
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            DataItem item = adapter.getItem(position);
            Intent intent = new Intent(SearchActivity.this, MainActivity.class);
            intent.putExtra("Country", item.countryName);
            intent.putExtra("Flag", item.resIdThumbnail);
            startActivity(intent);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterData(newText);
                return true;
            }
        });

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private List<DataItem> getData(int pageNo) {
        List<DataItem> output = new ArrayList<>();
        int start = pageNo * 3; // mostra 3 itens por página
        int end = Math.min(start + 3, listData.size());
        for (int i = start; i < end; i++) {
            output.add(listData.get(i));
        }
        return output;
    }

    private void filterData(String query) {
        List<DataItem> filteredList = new ArrayList<>();
        for (DataItem item : listData) {
            if (item.countryName.toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter = new CustomAdapter(this, R.layout.itemrow, filteredList);
        listView.setAdapter(adapter);
    }

    public void ProfileNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.profile_screen_button) {
            Toast.makeText(this, "Abrindo a tela de perfil!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }

    public void HomeNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.home_screen_button) {
            Toast.makeText(this, "Abrindo a tela principal!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void SearchNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.search_screen_button) {
            Toast.makeText(this, "Você já está nessa tela!", Toast.LENGTH_SHORT).show();
        }
    }
}
