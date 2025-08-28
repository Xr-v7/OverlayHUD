package com.example.overlayhud;
import android.content.Intent;
public class MouseGestures {
    public static void tap(int pointer){
        Intent i = new Intent(MouseAccessibilityService.ACTION_MOUSE);
        i.putExtra(MouseAccessibilityService.EXTRA_CMD,"TAP");
        OverlayApp.get().sendBroadcast(i);
    }
    public static void longPress(int pointer){
        Intent i = new Intent(MouseAccessibilityService.ACTION_MOUSE);
        i.putExtra(MouseAccessibilityService.EXTRA_CMD,"LONG");
        OverlayApp.get().sendBroadcast(i);
    }
}

