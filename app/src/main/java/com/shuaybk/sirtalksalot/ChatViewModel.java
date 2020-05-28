package com.shuaybk.sirtalksalot;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChatViewModel extends ViewModel {

    private final String TAG = this.getClass().getSimpleName();

    private FirebaseAuth fbAuth = FirebaseAuth.getInstance();

    public FirebaseUser getUser() {
        return fbAuth.getCurrentUser();
    }

    public void signOut(final Context context) {
        //Display loading UI here!
        AuthUI.getInstance().signOut(context).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(context, "Signed out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
