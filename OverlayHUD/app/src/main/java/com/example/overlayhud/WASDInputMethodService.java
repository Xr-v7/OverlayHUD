package com.example.overlayhud;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
public class WASDInputMethodService extends InputMethodService {
    @Override public View onCreateInputView(){
        TextView tv = new TextView(this);
        tv.setText("Overlay HUD IME");
        tv.setPadding(16,16,16,16);
        return tv;
    }
    @Override public void onStartInput(EditorInfo attr, boolean restarting){
        super.onStartInput(attr,restarting);
        InputConnection ic = getCurrentInputConnection();
        InputBridge.setCurrent(ic);
    }
    @Override public void onFinishInput(){ super.onFinishInput(); InputBridge.setCurrent(null); }
}

