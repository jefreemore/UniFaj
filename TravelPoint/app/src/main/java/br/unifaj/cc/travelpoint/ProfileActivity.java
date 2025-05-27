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

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ProfileNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.profile_screen_button) {
            Toast.makeText(this, "Você já está nessa tela!", Toast.LENGTH_SHORT).show();
        }
    }
    public void HomeNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.home_screen_button) {
            Toast.makeText(this, "Abrindo a tela de principal!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void SearchNavigationButton(@NonNull View v) {
        if (v.getId() == R.id.search_screen_button) {
            Toast.makeText(this, "Abrindo a tela de pesquisa!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }
}