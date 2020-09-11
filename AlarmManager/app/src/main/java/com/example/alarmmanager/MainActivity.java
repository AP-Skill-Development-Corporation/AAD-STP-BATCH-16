package com.example.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton button;

    AlarmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager= (AlarmManager) getSystemService(ALARM_SERVICE);

        button=findViewById(R.id.toogle);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (b)
                {
                    Intent intent=new Intent(getApplicationContext(),MyService.class);


                    PendingIntent pi=PendingIntent.getService(getApplicationContext(),
                            1,
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT);


                    long trigger= SystemClock.elapsedRealtime()+(1*60*1000);

                    long interval=1*60*1000;

                    manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,trigger,interval,pi);

                    Toast.makeText(MainActivity.this, "ALARM IS ON", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(),MyService.class);


                    PendingIntent pi=PendingIntent.getService(getApplicationContext(),
                            1,
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT);


                    long trigger= SystemClock.elapsedRealtime()+(1*60*1000);

                    long interval=1*60*1000;

                    manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,trigger,interval,pi);


                    Toast.makeText(MainActivity.this, "ALARM IS OFF", Toast.LENGTH_SHORT).show();

                    manager.cancel(pi);
                }


            }

        });


    }
}
