package com.elian.changesizetext.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.elian.changesizetext.ChangeSizeTextApplication;
import com.elian.changesizetext.data.model.Message;
import com.elian.changesizetext.data.model.User;
import com.elian.changesizetext.databinding.ActivityChangeSizeTextBinding;


/**
 * Clase que pide al usuario un texto y un tamaño mediante el componente Seekbar.
 * Después se inicializa un TextView @see {@link ViewMessageActivity#onCreate(Bundle)}.
 */
public class ChangeSizeTextActivity extends AppCompatActivity {

    private static final String TAG = "ChangeSizeProject";
    ActivityChangeSizeTextBinding binding;


    // Si se gira la pantalla, por defecto, se destruye la Activity y en savedInstance
    // Se guarda el estado anterior, por lo que aunque se destruya conservamos la misma información
    // que antes, aunque podemos modificar si un elemento guarda su estado al destruir una Activity
    // Esto es el estado estático, que es lo que se guarda,
    // el estado dinámico no se guarda, como las variables que usamos para insertar información
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChangeSizeTextBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btSend.setOnClickListener(view -> {
            // 1. Crear objeto Bundle
            Bundle bundle = new Bundle();

            // 2. Añadir mensaje al Bundle
            User user = ((ChangeSizeTextApplication) getApplication()).getUser();

            Message message = new Message(user, binding.edMessage.getText().toString(), binding.skSize.getProgress());

            bundle.putSerializable("message", message);

            // 3. Enviar Intent con el Bundle
            Intent intent = new Intent(this, ViewMessageActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ChangeSizeTextActivty -> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ChangeSizeTextActivty -> onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ChangeSizeTextActivty -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ChangeSizeTextActivty -> onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "ChangeSizeTextActivity -> onDestroy()");
    }
}