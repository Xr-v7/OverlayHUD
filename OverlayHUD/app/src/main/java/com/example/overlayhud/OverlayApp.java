package com.example.overlayhud;
import android.app.Application;
public class OverlayApp extends Application {
    private static OverlayApp I;
    @Override public void onCreate(){ super.onCreate(); I=this; }
    public static OverlayApp get(){ return I; }
}

