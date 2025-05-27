package br.unifaj.cc.travelpoint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText login_input_email;
    EditText login_input_password;
    String current_email = "travel.point@gmail.com.br";
    String current_password = "tp@123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onLogin(@NonNull View v) {
        int id = v.getId();
        login_input_email = findViewById(R.id.login_input_email);
        login_input_password = findViewById(R.id.login_input_password);
        String input_email = login_input_email.getText().toString().trim();
        String input_password = login_input_password.getText().toString().trim();
        if (id == R.id.login_button_start) {
            if (input_email.isEmpty() && input_password.isEmpty()) {
                Toast.makeText(this, "Preenche todos os campus!", Toast.LENGTH_SHORT).show();
            } else if (input_email.isEmpty()) {
                Toast.makeText(this, "Preencha o campo de email!", Toast.LENGTH_SHORT).show();
            } else if (input_password.isEmpty()) {
                Toast.makeText(this, "Preencha o campo de senha!", Toast.LENGTH_SHORT).show();
            } else if (!input_email.equals(current_email) && !input_password.equals(current_password)) {
                Toast.makeText(this, "Email e senha incorretos!", Toast.LENGTH_SHORT).show();
            } else if (!input_email.equals(current_email)) {
                Toast.makeText(this, "Email incorreto!", Toast.LENGTH_SHORT).show();
            } else if (!input_password.equals(current_password)) {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}