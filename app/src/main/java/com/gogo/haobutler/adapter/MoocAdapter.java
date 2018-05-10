package com.gogo.haobutler.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogo.haobutler.R;
import com.gogo.haobutler.entity.MoocBean;
import com.gogo.haobutler.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 闫昊
 * @date: 2018/5/8
 * @function:
 */
public class MoocAdapter extends ArrayAdapter {
    private List<MoocBean> moocBeanList;
    private int resource;
    private Context context;

    public MoocAdapter(@NonNull Context context, int resource, @NonNull List<MoocBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.moocBeanList = objects;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MoocBean moocBean = moocBeanList.get(position);
        String urlIcon = moocBean.getIcon();
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(resource == -1 ? R.layout.item_mooc_layout : resource, null);
            holder = new ViewHolder();
            holder.ivIcon = convertView.findViewById(R.id.iv_icon);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
            holder.ivIcon.setTag(urlIcon);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /**
         * 避免图片重复刷新：绑定ImageView和图片url，让正确的ImageView显示正确的url图片
         * 原因：当前convertView是复用缓冲池中的其它的view
         * 当页面滑动，会从缓冲池中取出已经存在的convertView，而此convertView图片已经存在，
         * 导致新的图片加载前会显示旧的图片
         */
        if (holder.ivIcon.getTag() == urlIcon) {
            new ImageLoader().showImage(urlIcon, holder.ivIcon);
        }
        holder.tvTitle.setText(moocBean.getTitle());
        holder.tvContent.setText(moocBean.getContent());
        return convertView;
    }

    class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvContent;
    }
}
