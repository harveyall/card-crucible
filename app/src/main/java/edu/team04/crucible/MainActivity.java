package edu.team04.crucible;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

/**
 * The Main Activity, with buttons for Settings, Study Mode & Game Mode.
 */
public class MainActivity extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private final static String default_notification_channel_id = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ThemeHandler(this, getApplicationContext()).updateTheme();
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.study_mode);
        //((android.widget.Button)findViewById(R.id.button_begin)).setText(R.string.game_mode);
        setContentView(R.layout.activity_main);

        TestData test = new TestData(this);
        new Thread(test, "TestCategoryList").start();
        scheduleNotification(getNotification("It's Study time!"), 20000);
    }

    /**
     * Button to Settings Activity.
     * @param button Settings Activity button
     */
    public void settings (View button) {
        Intent settingsActivity = new Intent(this, SettingsActivity.class);
        startActivity(settingsActivity);
    }

    /**
     * Button to Card Selection Activity with Study Mode intent.
     * @param button Study Mode button
     */
    public void cardSelectForStudy (View button) {
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        cardSelectionActivity.putExtra("ACTIVITY","Study");
        startActivity(cardSelectionActivity);
    }

    /**
     * Button to Card Selection Activity with Game Mode intent.
     * @param button Game Mode button
     */
    public void cardSelectForGame (View button) {
        Intent cardSelectionActivity = new Intent(this, CardSelectionActivity.class);
        cardSelectionActivity.putExtra("ACTIVITY","Game");
        startActivity(cardSelectionActivity);
    }

    private void scheduleNotification(Notification notification, int delay) {
        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent. getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }
    private Notification getNotification(String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, default_notification_channel_id);
        builder.setContentTitle("Card Crucible");
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.card_crucible_app_icon);
        builder.setVibrate(new long[]{500, 500});
        builder.setLights(Color.BLUE, 750, 250);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        builder.setAutoCancel(true);
        builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        return builder.build();
    }
}