package com.shuaybk.sirtalksalot.Fragments;

import android.app.Dialog;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = AddContactDialogFragmentBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }
}
