package com.example.menulateral.ui.gallery;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.menulateral.MainActivity;
import com.example.menulateral.R;
import com.example.menulateral.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View view2 = inflater.inflate(R.layout.fragment_home, container, false);
        EditText editText = root.findViewById(R.id.editTextAge);
        TextView textViewGreeting = root.findViewById(R.id.textViewGreeting);
        Intent intent = getActivity().getIntent();
        String receivedData = intent.getStringExtra("name");
        textViewGreeting.setText(textViewGreeting.getText() + " " + receivedData.toString());
        TextView editTextName = root.findViewById(R.id.editTextName);


        Button btnNext = root.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("name", editTextName.getText().toString());
                intent.putExtra("age", editText.getText().toString());
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}