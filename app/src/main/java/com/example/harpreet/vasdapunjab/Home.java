package com.example.harpreet.vasdapunjab;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Home extends Fragment  {

  /*  ViewPager viewPager;
    PagerAdapter adapter;

    int[] img;

    private  static  int currentpage=0;
    private static int numpage=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Viewpager di codding
        img= new int[]{R.drawable.imgone,
                R.drawable.imgtwo
        };

         viewPager = (ViewPager) viewPager.findViewById(R.id.view_pager);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            adapter = new viewPagerAdaptor(Home.this,img);
        }
        viewPager.setAdapter(adapter);
        ///
        //Circleidicator da code
        CircleIndicator indicator =(CircleIndicator) viewPager.findViewById(R.id.Indicator);
        indicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (state==viewPager.SCROLL_STATE_IDLE)
                {
                    int pagecount = img.length;
                    if (currentpage==0)
                    {
                        viewPager.setCurrentItem(pagecount-1,false);
                    }

                    else if (currentpage==pagecount-1)
                    {
                        viewPager.setCurrentItem(0,false);
                    }
                }

            }
        });




        // SLIDE SHOW WITH TIMER
        final Handler handler = new Handler();
        final Runnable update =new Runnable() {
            @Override
            public void run() {
                if (currentpage==numpage)
                {
                    currentpage=0;
                }
                viewPager.setCurrentItem(currentpage++,true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }

        },2000,2000);

    }


*/

    ImageView image_home_1,image_home_2,image_home_3,image_home_4,image_home_5;
    FirebaseStorage storage;
    StorageReference reference;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);


        initialize(view);

        updateImagesHome();

        return view;


}

    private void updateImagesHome() {

        storage = FirebaseStorage.getInstance();
        reference = storage.getReferenceFromUrl("gs://preuniprep-master.appspot.com");

        //1st image home ch fetch karn layi code

        StorageReference pathreference = reference.child("home_1.jpg");

        File myFile1 = null;

        try {
            myFile1 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File finalMyFile1 = myFile1;
        pathreference.getFile(myFile1).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                //Toast.makeText(getActivity(), "Image 1 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeFile(finalMyFile1.getAbsolutePath());
                image_home_1.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 1 not done", Toast.LENGTH_SHORT).show();
            }
        });

        //2nd home image fetch karn layi code
        StorageReference pathreference2 = reference.child("home_2.jpg");

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
                //Toast.makeText(getActivity(), "Image 1 fetched", Toast.LENGTH_SHORT).show();
                Bitmap bitmap2 = BitmapFactory.decodeFile(finalMyFile2.getAbsolutePath());
                image_home_2.setImageBitmap(bitmap2);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 2 not done", Toast.LENGTH_SHORT).show();
            }
        });

        //3rd image fetch karn layi code
        StorageReference pathreference3 = reference.child("home_3.png");

        File myFile3 = null;
        try {
            myFile3 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File MyFile3 = myFile3;
        pathreference3.getFile(myFile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Bitmap bitmap3 = BitmapFactory.decodeFile(MyFile3.getAbsolutePath());
                image_home_3.setImageBitmap(bitmap3);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 3 not fetched", Toast.LENGTH_SHORT).show();
            }
        });

        //4th home image fetch karn layi code
        StorageReference pathreference4 = reference.child("home_4.jpg");

        File myFile4 = null;
        try {
            myFile4 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File MyFile4 = myFile4;
        pathreference4.getFile(myFile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Bitmap bitmap4 = BitmapFactory.decodeFile(MyFile4.getAbsolutePath());
                image_home_4.setImageBitmap(bitmap4);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 4 not fetched", Toast.LENGTH_SHORT).show();
            }
        });


        //5th home image stech karn layi code
        StorageReference pathreference5 = reference.child("home_5.png");

        File myFile5 = null;
        try {
            myFile5 = File.createTempFile("images","jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        final File MyFile5 = myFile5;
        pathreference5.getFile(myFile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Bitmap bitmap5 = BitmapFactory.decodeFile(MyFile5.getAbsolutePath());
                image_home_5.setImageBitmap(bitmap5);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Image 5 not fetched", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initialize(View view) {

        image_home_1 = view.findViewById(R.id.image_home_1);
        image_home_2 = view.findViewById(R.id.image_home_2);
        image_home_3 = view.findViewById(R.id.image_home_3);
        image_home_4 = view.findViewById(R.id.image_home_4);
        image_home_5 = view.findViewById(R.id.image_home_5);


       // Glide.with(getActivity()).load(R.raw.loading).into(image_home_1);





    }
}
