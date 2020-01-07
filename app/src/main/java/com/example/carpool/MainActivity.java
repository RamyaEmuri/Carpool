package com.example.carpool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.rd.PageIndicatorView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    final Context context = this;
    AlertDialog.Builder builder;

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SliderAdapter sliderAdapter;
    private ImageView moviePager;
    private PageIndicatorView pageIndicatorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

//        -------------------------------Dialog Box----------------------------------------


        textView = (TextView) findViewById(R.id.textView2);
        builder = new AlertDialog.Builder(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                builder.setMessage("Confirm by clicking yes to go to next activity")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener(){
                            public  void onClick(DialogInterface dialog, int id){
                                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                    startActivity(intent);
//                                finish();
                                Toast.makeText(getApplicationContext(),"you confirmed to go to next activity",
                                        Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                Toast.makeText(getApplicationContext(),"you canceled to go",
                                        Toast.LENGTH_SHORT).show();

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Confirmation");
                alert.show();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager1);
        pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        pageIndicatorView.setViewPager(viewPager);
        moviePager = (ImageView) findViewById(R.id.backView);
        moviePager.setBackgroundResource(R.drawable.background);

//        TextView t1 = findViewById(R.id.textView2);
//        t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent second = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(second);
//            }
//        });

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

















// textView = (TextView) findViewById(R.id.textView2);
////        textView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
////                        context);
////                alertDialogBuilder.setTitle("Do you Want to Go");
////                alertDialogBuilder.setMessage("Click Yes to go")
////                        .setCancelable(false)
////                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////                                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////                                startActivity(intent);
////
////                                MainActivity.this.finish();
//
////                            }
////                        })
////                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////                                dialogInterface.cancel();
////                            }
////                        });
////                AlertDialog alertDialog = alertDialogBuilder.create();
////                alertDialog.show();
////            }
////        });
//
//
////        --------------------------------------------------------------















//textView = (TextView) findViewById(R.id.textView2);
//        builder = new AlertDialog.Builder(this);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
//                builder.setMessage("Do you want to close this activity ?")
//                        .setCancelable(false)
//                        .setPositiveButton("yes", new DialogInterface.OnClickListener(){
//                            public  void onClick(DialogInterface dialog, int id){
//                                finish();
//                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
//                                        Toast.LENGTH_SHORT).show();
//
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                                Toast.makeText(getApplicationContext(),"you choose nno action for alertbox",
//                                        Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//                AlertDialog alert = builder.create();
//                alert.setTitle("AlertDialogExample");
//                alert.show();
//            }
//        });
