package com.example.carpool;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class Coordinator_Layout extends AppCompatActivity {

    ImageView imageView;
    AlertDialog.Builder builder;

    public static final String EXTRA_NAME = "personName";
    public static final String EXTRA_IMAGE_DRAWABLE = "ImageDrawable";
    ArrayList<Data1> dataset1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_coordinator__layout);

//        -------------------------------
        imageView = (ImageView) findViewById(R.id.backImageicon);
        builder = new AlertDialog.Builder(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                builder.setMessage("Do you want to close this activity ?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener(){
                            public  void onClick(DialogInterface dialog, int id){
                                finish();
                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                        Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(),"you choose nno action for alertbox",
                                        Toast.LENGTH_SHORT).show();

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });

//--------------------------------------------------------------

        setContentView(R.layout.activity_coordinator__layout);


        final Toolbar toolbar = findViewById(R.id.toolBarCordinator);
       setSupportActionBar(toolbar);


       ImageView imageView = findViewById(R.id.backImageicon);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent second = new Intent(Coordinator_Layout.this, SecondActivity.class);
               startActivity(second);
           }
       });


//       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();



        if (intent != null) {
            final String name;
            name = intent.getStringExtra(EXTRA_NAME);
            int ImageDrawable = intent.getIntExtra(EXTRA_IMAGE_DRAWABLE, 0);

            CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolBar);
            collapsingToolbarLayout.setTitle(name);
            loadBackdrop(ImageDrawable);
        }
    }

    private void loadBackdrop(int image) {
        final ImageView imageView = findViewById(R.id.backview1);


        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.person21)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView);
    }
}
