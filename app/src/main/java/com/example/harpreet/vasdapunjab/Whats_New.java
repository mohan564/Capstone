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

public class Whats_New extends Fragment {

    FirebaseStorage storage;
    StorageReference reference;
    ImageView image_1;
    TextView title_1,detail_1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.whats_new,container,false);

        initializeValues(view);

        updateImages();

        return view;
    }



    private void initializeValues(View view) {

        image_1 = view.findViewById(R.id.image_1);
        title_1 = view.findViewById(R.id.title_1);
        detail_1 = view.findViewById(R.id.details_1);
    }

    private void updateImages() {

        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Just a Moment...");
        dialog.setMessage("Updating Data");
        dialog.show();

        storage = FirebaseStorage.getInstance();
        reference = storage.getReferenceFromUrl("gs://preuniprep-master.appspot.com");

        StorageReference pathreference = reference.child("chips_shitake.jpg");

        File myFile = null;

        try {
            myFile = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile = myFile;
        pathreference.getFile(myFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Done G", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeFile(finalMyFile.getAbsolutePath());
                image_1.setImageBitmap(bitmap);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Nahi 22 hoea ni", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
