package br.unifaj.cc.travelpoint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ProfileNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.profile_screen_button) {
            Toast.makeText(this, "Abrindo a tela de perfil!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }
    public void HomeNavigationButton(@NonNull View v) {
        Toast.makeText(this, "Você já está nessa tela!", Toast.LENGTH_SHORT).show();
    }
    public void SearchNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.search_screen_button) {
            Toast.makeText(this, "Abrindo a tela de pesquisa!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }
}
