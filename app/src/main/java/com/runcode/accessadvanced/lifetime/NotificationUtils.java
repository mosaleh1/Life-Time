package com.runcode.accessadvanced.lifetime;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationUtils
{
    private static final int NOTIFICATION_ID = 2002 ;
    @SuppressLint("StaticFieldLeak")
    private static  Context context  ;
    public static final String CHANNEL_ID = "LifeTimeChannelId";

    public static void showNotification(Context context,String title , String message) {
        NotificationUtils.context = context ;
        createChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.time2)
                .setContentText(message)
                .setContentTitle(title)
                .setAutoCancel(true)
                .addAction(GET_ACTION_SEND(context))
                .setContentIntent(contentIntent(context))
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManagerCompat nMCompat = NotificationManagerCompat.from(context);
        nMCompat.notify(NOTIFICATION_ID,builder.build());
    }

    private static NotificationCompat.Action  GET_ACTION_SEND(Context context){
        NotificationCompat.Action action ;
        Intent intent = new Intent(context,MainActivity.class);
        action = new NotificationCompat.Action(R.drawable.ic_time,"Ok, Start new Task",contentIntent(context));
        return action ;
    }

    private static void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel Name";
            String description = "This is the water app description";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }}

    private static PendingIntent contentIntent (Context context){
        PendingIntent pIntent ;
        Intent intent = new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pIntent = PendingIntent.getActivity(context, 0, intent, 0);
        return pIntent;
    }

}
