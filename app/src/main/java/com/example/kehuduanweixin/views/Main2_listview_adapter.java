package com.example.kehuduanweixin.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kehuduanweixin.R;

import java.util.LinkedList;

public class Main2_listview_adapter extends BaseAdapter {
    private LinkedList<Main2_listview> mDate;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public Main2_listview_adapter(LinkedList<Main2_listview> mDate, Context mContext) {
        this.mDate = mDate;
        layoutInflater =LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDate.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView ==null){
            convertView=layoutInflater.inflate(R.layout.main2_listview_item,parent,false);
            holder=new ViewHolder();
            holder.img_icon=(ImageView)convertView.findViewById(R.id.ic_avatar);
            holder.txt_aName=(TextView)convertView.findViewById(R.id.name);
            convertView.setTag(holder); //将holder存储到convertView中
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        holder.img_icon.setImageResource(mDate.get(position).getaIcon());
        holder.txt_aName.setText(mDate.get(position).getaName());

        return convertView;
    }

    class ViewHolder{
        ImageView img_icon;
        TextView txt_aName;
    }
}
