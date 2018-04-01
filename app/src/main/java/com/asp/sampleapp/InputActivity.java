package com.asp.sampleapp;

import android.content.DialogInterface;
import android.media.MediaCodec;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class InputActivity extends AppCompatActivity {

    EditText editTextNama,editTextUser, editTextEmail, editTextPassword, editTextPhone, editTextAlamat;
    String sNama, sUser, sEmail, sPassword, sPhone, sAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextNama = findViewById(R.id.nama);
        editTextUser = findViewById(R.id.user);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextPhone = findViewById(R.id.phone);
        editTextAlamat = findViewById(R.id.alamat);
    }

    public void validasi(View view){
        boolean nama = editTextNama.getText().toString().isEmpty();
        boolean user = editTextUser.getText().toString().isEmpty();
        boolean email = editTextEmail.getText().toString().isEmpty();
        boolean password = editTextPassword.getText().toString().isEmpty();
        boolean phone = editTextPhone.getText().toString().isEmpty();
        boolean alamat = editTextAlamat.getText().toString().isEmpty();

        if (nama){
            editTextNama.setError("Nama harus diisi!");
            editTextNama.requestFocus();
        }
        else if(user){
            editTextUser.setError("Username harus diisi!");
            editTextNama.requestFocus();
        }
        else if(email){
            editTextEmail.setError("Email harus diisi!");
            editTextEmail.requestFocus();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches()){
            editTextEmail.setText("");
            editTextEmail.setError("Email tidak valid!");
            editTextEmail.requestFocus();
        }
        else if(password){
            editTextPassword.setError("Password harus diisi!");
            editTextPassword.requestFocus();
        }
        else if(phone){
            editTextPhone.setError("Phone harus diisi!");
            editTextPhone.requestFocus();
        }
        else if(!Patterns.PHONE.matcher(editTextPhone.getText().toString()).matches()){
            editTextPhone.setText("");
            editTextPhone.setError("Phone tidak valid!");
            editTextPhone.requestFocus();
        }
        else if(alamat){
            editTextAlamat.setError("Alamat harus diisi!");
            editTextAlamat.requestFocus();
        }
        else {
            sNama = editTextNama.getText().toString().trim();
            sUser = editTextUser.getText().toString().trim();
            sEmail = editTextEmail.getText().toString().trim();
            sPassword = editTextPassword.getText().toString().trim();
            sPhone = editTextPhone.getText().toString().trim();
            sAlamat = editTextAlamat.getText().toString().trim();

            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.camera)
                    .setTitle("Confirmation Message")
                    .setMessage("Nama : "+sNama+ " " +
                            "\nUsername : "+sUser+
                            " \nEmail : "+sEmail+
                            " \nPassword : "+sPassword+
                            " \nPhone : "+sPhone+
                            " \nAlamat : "+sAlamat)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .create()
                    .show();
            Toast.makeText(this, "Okay", Toast.LENGTH_SHORT).show();
        }
    }

}
