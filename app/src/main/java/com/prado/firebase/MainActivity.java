package com.prado.firebase;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //reference.child("pontos").setValue("300");
       // reference.child("usuarios2").child("001").child("nome").setValue("Priscila");
        DatabaseReference produtos = reference.child("produtos");
        Produto produto = new Produto();
         produto.setName("Lg");
         produto.setDescriction("Smart tv");
         produto.setPrice(3000);

         produtos.child("002").setValue(produto);

       /* DatabaseReference usuarios = reference.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setName("Alvaro");
        usuario.setLastname("Prado");
        usuario.setIdade(39);
        usuarios.child("002").setValue(usuario);
    */}
}