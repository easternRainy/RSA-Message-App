package com.example.rsamessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GenerateKeyPair extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_key_pair);
    }

    /**
     * in GenerateKeyPair Activity, when user click button "Generate", this function
     * will generate new RSA public key and private key, and send them to view
     * @param view
     * @throws NoSuchAlgorithmException
     */
    public void generateRSAKeyPair(View view) throws NoSuchAlgorithmException {
        EditText keyLengthText = (EditText) findViewById(R.id.editText0);
        String keyLengthStr = keyLengthText.getText().toString();
        int keyLength = Integer.parseInt(keyLengthStr);

        TextView publicKeyView = (TextView) findViewById(R.id.textView0);
        TextView privateKeyView = (TextView) findViewById(R.id.textView1);

        String publicKey = "";
        String privateKey = "";

        try {
            RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator(keyLength);
            publicKey = Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded());
            privateKey = Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded());


        } catch (Exception e){
            RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator(1024);
            publicKey = Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded());
            privateKey = Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded());
        }

        publicKeyView.setText(publicKey);
        privateKeyView.setText(privateKey);
    }


    /**
     * copy the public key to clipper board
     * @param view
     */
    public void publicKeyToClipper(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        TextView publicKeyView = (TextView) findViewById(R.id.textView0);
        String publicKey= publicKeyView.getText().toString();

        ClipData clip = ClipData.newPlainText("Public Key", publicKey);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(getApplicationContext(),"Copied from Clipboard!",Toast.LENGTH_SHORT).show();
    }

    /**
     * copy the private key to clipper board
     * @param view
     */
    public void privateKeyToClipper(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        TextView privateKeyView = (TextView) findViewById(R.id.textView1);
        String privateKey= privateKeyView.getText().toString();

        ClipData clip = ClipData.newPlainText("Private Key", privateKey);
        clipboard.setPrimaryClip(clip);
    }
}
