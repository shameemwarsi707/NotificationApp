package com.shaim.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID="New Channel";
    private static final int NOTIFICATION_ID=010;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.man,null);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap largeIcon=bitmapDrawable.getBitmap();

        Notification notification;
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.man)
                    .setContentText("My Message")
                     .setContentTitle("Shameem")
                    .setSubText("My new Message Shameem Warsi")
                    .setChannelId(CHANNEL_ID)
                    .build();
             manager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"My New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.man)
                    .setContentText("My Message")
                    .setSubText("My new Message Shameem Warsi")
                    //.setChannelId(CHANNEL_ID)
                    .build();
        }
        manager.notify(NOTIFICATION_ID,notification);
    }
}