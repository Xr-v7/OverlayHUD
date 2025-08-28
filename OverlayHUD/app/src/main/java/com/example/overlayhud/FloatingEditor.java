package com.example.overlayhud;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.LinearLayout;
public class FloatingEditor {
    public interface OnSaveListener { void onSave(Preset.Button updated); }
    private final Context ctx; private final Preset.Button data; private final OnSaveListener listener;
    private WindowManager wm; private View root;
    public FloatingEditor(Context ctx, Preset.Button data, OnSaveListener l){ this.ctx=ctx; this.data=data; this.listener=l; }
    public void show(ViewGroup parent){
        wm=(WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE);
        LinearLayout v=new LinearLayout(ctx); v.setOrientation(LinearLayout.VERTICAL); v.setPadding(20,20,20,20); v.setBackgroundColor(0xCC222222);
        Spinner sp=new Spinner(ctx); sp.setAdapter(new ArrayAdapter<>(ctx,android.R.layout.simple_spinner_dropdown_item, InputUtils.availableKeys()));
        CheckBox cb=new CheckBox(ctx); cb.setText("Modo Toggle"); cb.setChecked("toggle".equals(data.mode));
        CheckBox cbEx=new CheckBox(ctx); cbEx.setText("Toque exclusivo"); cbEx.setChecked(data.exclusive);
        SeekBar sz=new SeekBar(ctx); sz.setMax(500); sz.setProgress(data.size);
        SeekBar op=new SeekBar(ctx); op.setMax(255); op.setProgress(data.alpha);
        Button bOk=new Button(ctx); bOk.setText("Aceptar"); Button bCancel=new Button(ctx); bCancel.setText("Cancelar");
        v.addView(sp); v.addView(cb); v.addView(cbEx); v.addView(sz); v.addView(op); v.addView(bOk); v.addView(bCancel);
        WindowManager.LayoutParams lp=new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, android.graphics.PixelFormat.TRANSLUCENT); lp.gravity=Gravity.CENTER;
        root=v; wm.addView(root,lp);
        bOk.setOnClickListener(x->{ data.key=(String)sp.getSelectedItem(); data.mode=cb.isChecked()?"toggle":"hold"; data.size=sz.getProgress(); data.alpha=op.getProgress(); data.exclusive=cbEx.isChecked(); listener.onSave(data); dismiss(); });
        bCancel.setOnClickListener(x->dismiss());
    }
    public void dismiss(){ if (wm!=null && root!=null){ try{ wm.removeView(root);}catch(Exception ignored){} root=null; wm=null; } }
}

