package com.example.harpreet.vasdapunjab;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Ask_Your_Parents extends Fragment {

    FirebaseDatabase database;
    DatabaseReference databaseReference,databaseReference2;
    FirebaseStorage storage;
    StorageReference storageReference;
    ImageView imageView;
    TextView textView,textView_details;
    ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ask_your_parents,container,false);

        initialize(view);

        updateImage();

        updateText();

        return view;
    }

    private void updateText() {

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("ayp");
        databaseReference2 = database.getReference("ayp_detail");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue().toString();
                textView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue().toString();
                textView_details.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void initialize(View view) {

        textView = view.findViewById(R.id.ayp_text);
        imageView = view.findViewById(R.id.image_ayp);
        textView_details = view.findViewById(R.id.ayp_detail);
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Please Wait");
        dialog.setMessage("Data is being Loaded");
        dialog.show();
    }

    private void updateImage() {

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReferenceFromUrl("gs://preuniprep-master.appspot.com");

        StorageReference path = storageReference.child("ayp.png");

        File myFile = null;

        try {
            myFile = File.createTempFile("images","png");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile = myFile;
        path.getFile(myFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                Bitmap bitmap = BitmapFactory.decodeFile(finalMyFile.getAbsolutePath());
                imageView.setImageBitmap(bitmap);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image not fetched", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
