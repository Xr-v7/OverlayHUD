package com.example.overlayhud;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.lang.ref.WeakReference;
public class InputBridge {
    private static WeakReference<InputConnection> current = new WeakReference<>(null);
    public static void setCurrent(InputConnection ic){ current = new WeakReference<>(ic); }
    public static boolean sendKey(int keyCode, boolean down){
        InputConnection ic = current.get();
        if (ic==null) return false;
        ic.sendKeyEvent(new KeyEvent(down?KeyEvent.ACTION_DOWN:KeyEvent.ACTION_UP, keyCode));
        return true;
    }
}

