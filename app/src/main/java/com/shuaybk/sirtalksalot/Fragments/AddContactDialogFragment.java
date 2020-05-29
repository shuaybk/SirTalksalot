package com.shuaybk.sirtalksalot.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.shuaybk.sirtalksalot.databinding.AddContactDialogFragmentBinding;

public class AddContactDialogFragment extends DialogFragment {

    private AddContactDialogFragmentBinding mBinding;
    private AddContactDialogListener mCallback;

    public interface AddContactDialogListener {
        public void onAddContactPressed(String email);
        public void onCancelPressed();
        public void onDismissed();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = AddContactDialogFragmentBinding.inflate(inflater, container, false);
        initAll();
        return mBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (AddContactDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement AddContactDialogListener");
        }
    }

    private void initAll() {
        mBinding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onAddContactPressed(mBinding.emailEditText.getText().toString());
            }
        });

        mBinding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onCancelPressed();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        mCallback.onDismissed();
    }
}
