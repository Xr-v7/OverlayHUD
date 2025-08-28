package com.example.overlayhud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ToggleReceiver extends BroadcastReceiver {
    public static final String ACTION_TOGGLE = "com.example.overlayhud.TOGGLE";
        public static final String ACTION_IME = "com.example.overlayhud.IME";

            @Override
                public void onReceive(Context c, Intent i) {
                        if (i == null) return;
                                String a = i.getAction();
                                        if (ACTION_TOGGLE.equals(a)) {
                                                    // Toggle HUD completo (incluye puntero si el panel está activo)
                                                                OverlayHudService.toggleHud();
                                                                        } else if (ACTION_IME.equals(a)) {
                                                                                    OverlayHudService.showImePicker(c);
                                                                                            }
                                                                                                }
                                                                                                }
                                                                                                