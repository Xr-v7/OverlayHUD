package com.example.overlayhud;
import android.view.KeyEvent;
public class InputUtils {
    public static String[] availableKeys(){
        return new String[]{"","W","A","S","D","Q","E","R","F","SPACE","ENTER","UP","DOWN","LEFT","RIGHT","LEFT_CLICK","RIGHT_CLICK"};
    }
    public static int indexOf(String[] arr, String v){ for (int i=0;i<arr.length;i++) if (arr[i].equals(v)) return i; return -1; }
    public static void handleKey(String key, boolean down){
        if (key==null || key.isEmpty()) return;
        switch(key){
            case "W": InputBridge.sendKey(KeyEvent.KEYCODE_W, down); break;
            case "A": InputBridge.sendKey(KeyEvent.KEYCODE_A, down); break;
            case "S": InputBridge.sendKey(KeyEvent.KEYCODE_S, down); break;
            case "D": InputBridge.sendKey(KeyEvent.KEYCODE_D, down); break;
            case "SPACE": InputBridge.sendKey(KeyEvent.KEYCODE_SPACE, down); break;
            case "ENTER": InputBridge.sendKey(KeyEvent.KEYCODE_ENTER, down); break;
            case "UP": InputBridge.sendKey(KeyEvent.KEYCODE_DPAD_UP, down); break;
            case "DOWN": InputBridge.sendKey(KeyEvent.KEYCODE_DPAD_DOWN, down); break;
            case "LEFT": InputBridge.sendKey(KeyEvent.KEYCODE_DPAD_LEFT, down); break;
            case "RIGHT": InputBridge.sendKey(KeyEvent.KEYCODE_DPAD_RIGHT, down); break;
            case "LEFT_CLICK": MouseGestures.tap(0); break;
            case "RIGHT_CLICK": MouseGestures.longPress(0); break;
        }
    }
}

