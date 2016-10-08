package com.example.android.bullyreportingsystem;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        takeAPicture();
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void takeAPicture () {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    //creates unique file name - need to avoid collisions
    private File createFile() throws IOException {

        Random rand = new Random();
        String fileName = "Picture_" + rand.nextInt(); //how do I create a unique file name
        File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(fileName, ".jpg", dir);

        return  image;
    }
}
