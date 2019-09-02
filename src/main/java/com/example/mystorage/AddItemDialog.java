package com.example.mystorage;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddItemDialog extends DialogFragment {

    private static final String TAG = "AddItemDialog";

    public interface OnInputListener{
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;

    //widgets
    private EditText mInput;
    private TextView mAdd, mCancel;
    private ImageView mImage;

    //vars

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_item, container, false);
        mAdd = view.findViewById(R.id.action_ok);
        mCancel = view.findViewById(R.id.action_cancel);
        mInput = view.findViewById(R.id.input);
        mImage = view.findViewById(R.id.imagePreview);

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: dismiss");
                getDialog().dismiss();
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: adding text");

                String input = mInput.getText().toString();
                if (!input.equals("")) {
                    //((MainActivity)getActivity().mItemViewModel)
                    mOnInputListener.sendInput(input);
                }

                getDialog().dismiss();
            }
        });

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ImagePickerActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnInputListener = (OnInputListener)getActivity();
    }
}
