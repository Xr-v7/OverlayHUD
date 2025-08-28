package com.example.overlayhud;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
public class Preset {
    public String name="Default";
    public List<Button> buttons = new ArrayList<>();
    public JSONObject toJson(){
        JSONObject o=new JSONObject();
        try{ o.put("presetName",name); JSONArray arr=new JSONArray(); for(Button b:buttons) arr.put(b.toJson()); o.put("buttons",arr);}catch(Exception e){}
        return o;
    }
    public static Preset fromJson(JSONObject o){
        Preset p=new Preset();
        p.name=o.optString("presetName","Default");
        JSONArray arr=o.optJSONArray("buttons");
        if (arr!=null) for (int i=0;i<arr.length();i++) p.buttons.add(Button.fromJson(arr.optJSONObject(i)));
        return p;
    }
    public static class Button {
        public String id; public String type="button"; public int x=100,y=100,size=120,alpha=180; public String key=""; public String mode="hold"; public boolean exclusive=false;
        public static Button defaultButton(String id){ Button b=new Button(); b.id=id; b.type="button"; return b; }
        public static Button mousePanel(String id){ Button b=new Button(); b.id=id; b.type="panel"; b.size=300; b.alpha=64; return b; }
        public JSONObject toJson(){ JSONObject o=new JSONObject(); try{ o.put("id",id); o.put("type",type); o.put("x",x); o.put("y",y); o.put("size",size); o.put("alpha",alpha); o.put("key",key); o.put("mode",mode); o.put("exclusive",exclusive);}catch(Exception e){} return o;}
        public static Button fromJson(JSONObject o){ Button b=new Button(); if (o==null) return b; b.id=o.optString("id",""); b.type=o.optString("type","button"); b.x=o.optInt("x",100); b.y=o.optInt("y",100); b.size=o.optInt("size",120); b.alpha=o.optInt("alpha",180); b.key=o.optString("key",""); b.mode=o.optString("mode","hold"); b.exclusive=o.optBoolean("exclusive",false); return b;}
    }
}

