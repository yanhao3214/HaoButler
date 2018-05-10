package com.gogo.haobutler.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gogo.haobutler.R;
import com.gogo.haobutler.adapter.MoocAdapter;
import com.gogo.haobutler.entity.MoocBean;
import com.gogo.haobutler.utils.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 闫昊
 * @date: 2018/5/8
 * @function: ListView、AsyncTask、CardView、json、
 */
public class MoocFragment extends BaseFragment {
    private View view;
    private ListView mListView;
    private MoocAdapter mMoocAdapter;
    private String url = "http://www.imooc.com/api/teacher?type=4&num=30";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mooc_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        mListView = view.findViewById(R.id.lv_mooc);
        new AgainAsyncTask().execute(url);
    }

    /**
     * 实现网络地异步访问
     */
    class AgainAsyncTask extends AsyncTask<String, Void, List<MoocBean>> {

        @Override
        protected List<MoocBean> doInBackground(String... strings) {
            return gainJsonData(strings[0]);
        }

        @Override
        protected void onPostExecute(List<MoocBean> moocBeans) {
            super.onPostExecute(moocBeans);
            mMoocAdapter = new MoocAdapter(getContext(), -1, moocBeans);
            mListView.setAdapter(mMoocAdapter);
        }
    }

    /**
     * 解析url对应的String对象
     * 将String对象里的json数据转化、封装成MoocBean对象列表
     *
     * @param url
     * @return
     */
    private List<MoocBean> gainJsonData(String url) {
        String result = "";
        List<MoocBean> moocBeans = new ArrayList<>();
        try {
            StringBuilder sb = new StringBuilder();
            String line = "";
            InputStream is = new URL(url).openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                sb = sb.append(line);
            }
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jo = new JSONObject(result);
            JSONArray ja = jo.getJSONArray("data");
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jsonObject = ja.getJSONObject(i);
                MoocBean moocBean = new MoocBean();
                moocBean.setIcon(jsonObject.getString("picSmall"));
                moocBean.setTitle(jsonObject.getString("name"));
                moocBean.setContent(jsonObject.getString("description"));
                moocBeans.add(moocBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return moocBeans;
    }
}
