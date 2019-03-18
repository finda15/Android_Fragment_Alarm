package id.sch.smktelkom_mlg.www.fragmentalarm;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton buttonAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAlarm = (ImageButton) findViewById(R.id.btnjam);

        buttonAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlarm("Waktu Pulang", 16, 30);
            }

            private void createAlarm(String message, int hour, int minutes) {
                Intent alarmIntet = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarmIntet.putExtra(AlarmClock.EXTRA_MESSAGE, message);
                alarmIntet.putExtra(AlarmClock.EXTRA_HOUR, hour);
                alarmIntet.putExtra(AlarmClock.EXTRA_MINUTES, minutes);

                if (alarmIntet.resolveActivity(getPackageManager()) != null)
                    startActivity(alarmIntet);
            }
        });
    }
}
