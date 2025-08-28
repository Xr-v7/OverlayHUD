package com.example.overlayhud;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.UUID;
public class ConfigActivity extends AppCompatActivity implements FloatingEditor.OnSaveListener {
    private FrameLayout canvas;
    private Preset preset;
    private FloatingEditor editor;
    @Override protected void onCreate(Bundle s){
        super.onCreate(s); setContentView(R.layout.activity_config);
        canvas = findViewById(R.id.editorCanvas);
        Button btnAdd = findViewById(R.id.btnAddButton);
        Button btnPanel = findViewById(R.id.btnAddPanel);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnClear = findViewById(R.id.btnClear);
        preset = PresetManager.load(this,"Default");
        redraw();
        btnAdd.setOnClickListener(v->{ Preset.Button b=Preset.Button.defaultButton(UUID.randomUUID().toString()); preset.buttons.add(b); redraw(); openEditor(b);});
        btnPanel.setOnClickListener(v->{ Preset.Button p=Preset.Button.mousePanel(UUID.randomUUID().toString()); preset.buttons.add(p); redraw(); openEditor(p);});
        btnSave.setOnClickListener(v->{ PresetManager.save(this,preset); finish();});
        btnExit.setOnClickListener(v-> finish());
        btnClear.setOnClickListener(v->{ preset.buttons.clear(); redraw();});
    }
    private void redraw(){
        canvas.removeAllViews();
        for (Preset.Button b: preset.buttons){
            if ("panel".equals(b.type)){
                MousePanelView mv = new MousePanelView(this,b,true);
                canvas.addView(mv, new FrameLayout.LayoutParams(b.size,b.size));
                mv.setOnClickListener(v-> openEditor(b));
            } else {
                FloatingButtonView fb = new FloatingButtonView(this,b,true);
                canvas.addView(fb, new FrameLayout.LayoutParams(b.size,b.size));
                fb.setOnClickListener(v-> openEditor(b));
            }
        }
    }
    private void openEditor(Preset.Button b){
        if (editor!=null) editor.dismiss();
        editor = new FloatingEditor(this,b,this);
        editor.show(canvas);
    }
    @Override public void onSave(Preset.Button updated){
        for (int i=0;i<preset.buttons.size();i++) if (preset.buttons.get(i).id.equals(updated.id)) { preset.buttons.set(i,updated); break; }
        redraw();
    }
}

