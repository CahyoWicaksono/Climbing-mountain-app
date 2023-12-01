package com.example.mountainclimbingapp.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class ForgotActivity extends AppCompatActivity {
    private Button send;
    private EditText editTextResetPwd, editTextName;
    FirebaseAuth firebaseAuth;
    private ImageView back;
    private static final String TAG = "ForgotActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_activity);

        send = findViewById(R.id.button_Forget);
        editTextName = findViewById(R.id.editText_fullname_forget);
        editTextResetPwd = findViewById(R.id.ForgetPasswordEmail);
        firebaseAuth = FirebaseAuth.getInstance();

        onBackPressed();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextResetPwd.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ForgotActivity.this, "Please enter you registered email !!", Toast.LENGTH_SHORT).show();
                    editTextResetPwd.setError("Email is required");
                    editTextResetPwd.requestFocus();
                }else  if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(ForgotActivity.this, "Please enter valid email !!", Toast.LENGTH_SHORT).show();
                    editTextResetPwd.setError("Valid email is required");
                    editTextResetPwd.requestFocus();
                }else {
                    resetpassword(email);
                }
            }
        });
    }
    private void resetpassword(String email) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotActivity.this, "Please check your email for password reset link"
                            , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        editTextResetPwd.setText("User does not exits is no longer valid. Please register again !!");
                    }catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(ForgotActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the app?")
                .setPositiveButton("AGREE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
}
