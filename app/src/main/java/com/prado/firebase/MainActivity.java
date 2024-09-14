package com.prado.firebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth authUser = FirebaseAuth.getInstance();
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
        /* Verificar se o usuario esta logado */
        if(authUser.getCurrentUser() != null){
            Log.i("CreaterUser","Usuario logado!");
        }else {
            Log.i("CreaterUser","Usuario não esta logado!");
        }
        /* Cadastro de usuario para autenticação */
       /* authUser.createUserWithEmailAndPassword("chico@gmail.com","a12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("CreaterUser","Sucesso ao cadastrar usuario!");
                        }else {
                            Log.i("CreaterUser","Erro ao cadastrar usuario!");
                        }
                    }
                });*/

       /*
        DatabaseReference usuarios = reference.child("usuarios");
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", Objects.requireNonNull(dataSnapshot.getValue()).toString());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        DatabaseReference usuarios2 = reference.child("usuarios").child("001");
        usuarios2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FIRE", Objects.requireNonNull(snapshot.getValue()).toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        //reference.child("pontos").setValue("300");
       // reference.child("usuarios2").child("001").child("nome").setValue("Priscila");

       /* DatabaseReference produtos = reference.child("produtos");
        Produto produto = new Produto();
         produto.setName("Lg");
         produto.setDescriction("Smart tv");
         produto.setPrice(3000);
         produtos.child("002").setValue(produto);*/

       /* DatabaseReference usuarios = reference.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setName("Alvaro");
        usuario.setLastname("Prado");
        usuario.setIdade(39);
        usuarios.child("002").setValue(usuario);
    */}
}