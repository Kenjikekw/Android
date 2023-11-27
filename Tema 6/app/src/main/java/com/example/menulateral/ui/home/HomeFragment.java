package com.example.menulateral.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.menulateral.MainActivity;
import com.example.menulateral.R;
import com.example.menulateral.ui.gallery.GalleryFragment;

import android.content.Intent;
import android.widget.Button;

public class HomeFragment extends Fragment {

    private Button btnNext;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View view2 = inflater.inflate(R.layout.fragment_gallery, container, false);

        btnNext = view.findViewById(R.id.btnNext);

        TextView editTextName = view.findViewById(R.id.editTextName);
        TextView editTextage = view2.findViewById(R.id.editTextAge);

        Intent intent = getActivity().getIntent();

        editTextName.setText(intent.getStringExtra("name"));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("age", "20");
                startActivity(intent);
            }
        });

        return view;
    }
}
