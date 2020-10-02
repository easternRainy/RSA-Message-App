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

public class DecryptMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_message);
    }

    public void decryptMessage(View view) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        EditText editTextEncryMsg = (EditText) findViewById(R.id.editText3);
        String encryMsg = editTextEncryMsg.getText().toString();

        EditText editTextKey = (EditText) findViewById(R.id.editText4);
        String key = editTextKey.getText().toString();

        String decryMsg = RSAUtil.decrypt(encryMsg, key);

        TextView textViewDecryMsg = (TextView) findViewById(R.id.textView4);

        textViewDecryMsg.setText(decryMsg);


    }
}
