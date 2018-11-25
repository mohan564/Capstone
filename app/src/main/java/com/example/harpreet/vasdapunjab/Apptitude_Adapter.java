package com.example.harpreet.vasdapunjab;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Geetansh Sharma on 11/24/2018.
 */

public class Apptitude_Adapter extends BaseExpandableListAdapter
{
    Context context;
    private List<String> list;
    private HashMap<String,List<String>> hashMap;
    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashMap.get(list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return i;
    }

    @Override
    public Object getChild(int i, int i1) {
        return i1;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup)
    {
        String tittle= (String) getGroup(i);
        if(view==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.qunats_parent,null);
        }
        TextView my_text_parent=view.findViewById(R.id.qunats_text_parent);
        my_text_parent.setTypeface(null, Typeface.BOLD);
        my_text_parent.setText(tittle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String tittle= (String) getChild(i,i1);
        if(view==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.quants_child,null);
        }
        TextView my_text_child=view.findViewById(R.id.qunats_text_child);
        my_text_child.setTypeface(null,Typeface.NORMAL);
        my_text_child.setText(tittle);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
