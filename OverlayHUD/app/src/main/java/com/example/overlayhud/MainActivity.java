package com.example.overlayhud;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private boolean hudRunning=false;
    @Override protected void onCreate(Bundle s){
        super.onCreate(s);
        setContentView(R.layout.activity_main);
        Button bPerm = findViewById(R.id.btnOverlayPerm);
        Button bAcc = findViewById(R.id.btnAccess);
        Button bCfg = findViewById(R.id.btnConfig);
        Button bStart= findViewById(R.id.btnStart);
        bPerm.setOnClickListener(v->{
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)){
                startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName())));
            }
        });
        bAcc.setOnClickListener(v-> startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)));
        bCfg.setOnClickListener(v-> startActivity(new Intent(this, ConfigActivity.class)));
        bStart.setOnClickListener(v->{
            Intent svc = new Intent(this, OverlayHudService.class);
            if (!hudRunning) {
                if (Build.VERSION.SDK_INT>=26) startForegroundService(svc); else startService(svc);
                bStart.setText(R.string.stop_hud);
            } else stopService(svc);
            hudRunning = !hudRunning;
        });
    }
}

