package com.shuaybk.sirtalksalot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shuaybk.sirtalksalot.Fragments.AddContactDialogFragment;
import com.shuaybk.sirtalksalot.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private final String ADD_CONTACT_TAG = "add contact";

    private ActivityChatBinding mBinding;
    private ChatViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        model = new ViewModelProvider(this).get(ChatViewModel.class);
        mBinding.usernameText.setText("User is: uid=" + model.getUser().getUid() + ", display name = " + model.getUser().getDisplayName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sign_out_menu_item:
                model.signOut(this);
                return true;
            case R.id.add_contact_menu_item:
                addContact();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addContact() {
        AddContactDialogFragment dialog = new AddContactDialogFragment();
        dialog.show(getSupportFragmentManager(), ADD_CONTACT_TAG);
    }

}
