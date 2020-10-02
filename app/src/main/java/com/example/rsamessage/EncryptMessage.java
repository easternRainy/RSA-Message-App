package com.example.rsamessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_message);
    }

    public void encryptMessage(View view) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {

        EditText editTextMessage = (EditText)findViewById(R.id.editText);
        String message = editTextMessage.getText().toString();

        EditText editTextKey = (EditText)findViewById(R.id.editText2);
        String key = editTextKey.getText().toString();

        TextView textViewEncryptedMessage = (TextView)findViewById(R.id.textView3);


        // Encrypt Message
        String encryptedMessage = RSAUtil.encryptToString(message, key);

        textViewEncryptedMessage.setText(encryptedMessage);

    }
}
