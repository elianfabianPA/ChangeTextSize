package com.elian.changesizetext.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.elian.changesizetext.ChangeSizeTextApplication;
import com.elian.changesizetext.data.model.Message;
import com.elian.changesizetext.databinding.ActivityViewMessageBinding;


/**
 * Esta clase visualiza un mensaje que se ha inicializado en ChangeSizeTextActivity.
 * Se configura el compontent TextView con un texto y un tamaño de fuente.
 * @autor Elián F.
 * @version 1.0
 */
public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ChangeSizeTextProject";
    ActivityViewMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        // 1. Recoger Intent
        Intent intent = getIntent();

        // 2. Recoger el mensaje
        Message message = (Message) intent.getExtras().getSerializable("message");

        // 3. Actualizamos la vista
        binding.tvMessage.setText(message.getMessage());
        binding.tvMessage.setTextSize(message.getSize());

        /*
         * Todas las Activiy tienen acceso a la información de la clase
         * Application desde el método getApplication. Se debe realizar
         * un casting explicito.
         */

        Log.d( TAG, ((ChangeSizeTextApplication) getApplication()).getUser().toString() );
    }
}