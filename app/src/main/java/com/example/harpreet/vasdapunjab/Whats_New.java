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
    ImageView image_1,image_2,image_3,image_4,image_5;
    TextView title_1,title_2,title_3,title_4,title_5;
    TextView detail_1,detail_2,detail_3,detail_4,detail_5;
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

        image_2 = view.findViewById(R.id.image_2);
        title_2 = view.findViewById(R.id.title_2);
        detail_2 = view.findViewById(R.id.details_2);

        image_3 = view.findViewById(R.id.image_3);
        title_3 = view.findViewById(R.id.title_3);
        detail_3 = view.findViewById(R.id.details_3);

        image_4 = view.findViewById(R.id.image_4);
        title_4 = view.findViewById(R.id.title_4);
        detail_4 = view.findViewById(R.id.details_4);

        image_5 = view.findViewById(R.id.image_5);
        title_5 = view.findViewById(R.id.title_5);
        detail_5 = view.findViewById(R.id.details_5);


    }

    private void updateImages() {

        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Just a Moment...");
        dialog.setMessage("Updating Data");
        dialog.show();

        storage = FirebaseStorage.getInstance();
        reference = storage.getReferenceFromUrl("gs://preuniprep-master.appspot.com");

        //1 image fetch karn layi code
        StorageReference pathreference = reference.child("image1.jpg");

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
                //Toast.makeText(getActivity(), "Image 1 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeFile(finalMyFile.getAbsolutePath());
                image_1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 1 not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //2 image fetch karn layi code

        StorageReference pathreference2 = reference.child("image2.png");

        File myFile2 = null;

        try {
            myFile2 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile2 = myFile2;
        pathreference2.getFile(myFile2).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Image 2 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap2 = BitmapFactory.decodeFile(finalMyFile2.getAbsolutePath());
                image_2.setImageBitmap(bitmap2);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 2 not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //3 image fetch karn layi code

        StorageReference pathreference3 = reference.child("image3.png");

        File myFile3 = null;

        try {
            myFile3 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile3 = myFile3;
        pathreference3.getFile(myFile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Image 3 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap3 = BitmapFactory.decodeFile(finalMyFile3.getAbsolutePath());
                image_3.setImageBitmap(bitmap3);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 3 not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //4 image fetch karn layi code
        StorageReference pathreference4 = reference.child("image4.png");

        File myFile4 = null;

        try {
            myFile4 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile4 = myFile4;
        pathreference4.getFile(myFile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Image 4 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap4 = BitmapFactory.decodeFile(finalMyFile4.getAbsolutePath());
                image_4.setImageBitmap(bitmap4);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 4 not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //5 image fetch karn layi code
        StorageReference pathreference5 = reference.child("image5.jpg");

        File myFile5 = null;

        try {
            myFile5 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile5 = myFile5;
        pathreference5.getFile(myFile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(), "Image 5 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap5 = BitmapFactory.decodeFile(finalMyFile5.getAbsolutePath());
                image_5.setImageBitmap(bitmap5);
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 5 not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


    }
}
