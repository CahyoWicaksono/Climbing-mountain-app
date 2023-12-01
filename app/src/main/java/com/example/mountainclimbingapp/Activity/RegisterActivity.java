package com.example.mountainclimbingapp.Activity;

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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mountainclimbingapp.Model.WriteAccountDetailsModel;
import com.example.mountainclimbingapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    EditText nama,email,pasword,confirmpassword;
    Button register;
    ImageView back;
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        nama = findViewById(R.id.register_editText_name);
        email = findViewById(R.id.register_editText_email);
        pasword = findViewById(R.id.register_password_1);
        confirmpassword = findViewById(R.id.register_password_2);

        register = findViewById(R.id.button_SignUp);

        back = findViewById(R.id.back_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFullname = nama.getText().toString();
                String textEmail = email.getText().toString();
                String textPwd = pasword.getText().toString();
                String textConPwd = confirmpassword.getText().toString();

                if (TextUtils.isEmpty(textFullname)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your fullname", Toast.LENGTH_SHORT).show();
                    nama.setError("your fullname is required");
                    nama.requestFocus();
                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    email.setError("email is required");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(RegisterActivity.this, "Please re-enter your email", Toast.LENGTH_SHORT).show();
                    email.setError("Email is required");
                    email.requestFocus();
                } else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                    pasword.setError("Your Password is required");
                    pasword.requestFocus();
                } else if (textPwd.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Pasword should be at least 6 digit", Toast.LENGTH_SHORT).show();
                    pasword.setError("Your password too weak");
                    pasword.requestFocus();
                } else if (TextUtils.isEmpty(textConPwd)) {
                    Toast.makeText(RegisterActivity.this, "Please confirm your Password", Toast.LENGTH_SHORT).show();
                    confirmpassword.setError("Confirm Password is required");
                    confirmpassword.requestFocus();
                } else if (!textPwd.equals(textConPwd)) {
                    Toast.makeText(RegisterActivity.this, "Please same password", Toast.LENGTH_SHORT).show();
                    confirmpassword.setError("Confirm Password is required");
                    confirmpassword.requestFocus();
                    confirmpassword.clearComposingText();
                    confirmpassword.clearComposingText();
                    SignUp(textFullname, textEmail, textPwd, textConPwd);
                    ClearAll();
                }

            }
        });
    }
    private void SignUp(String textFullname, String textEmail,  String textPwd, String textConPwd) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(textEmail, textPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullname).build();
                    firebaseUser.updateProfile(profileChangeRequest);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Register");


                    WriteAccountDetailsModel writeAccountDetailsModel = new WriteAccountDetailsModel();

                    databaseReference.child(firebaseUser.getUid()).setValue(writeAccountDetailsModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                firebaseUser.sendEmailVerification();
//                                showAlertDialog();
                                Toast.makeText(RegisterActivity.this, "Create Access is Succesfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Register Failed !!!,Please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        pasword.setError("Your password is too weak. Kindly use a mix of alphabets, number or special character");
                        pasword.requestFocus();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        confirmpassword.setError("Your email is invalid or already in use. Kindly re-enter");
                        confirmpassword.requestFocus();
                    }catch (FirebaseAuthUserCollisionException e){
                        confirmpassword.setError("User is already registered whit this email.");
                        confirmpassword.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    private void ClearAll()
    {
        nama.setText("");
        email.setText("");
        confirmpassword.setText("");
        pasword.setText("");
    }

}
