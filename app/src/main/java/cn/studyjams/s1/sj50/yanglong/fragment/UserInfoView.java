package cn.studyjams.s1.sj50.yanglong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cn.studyjams.s1.sj50.yanglong.Listener.EditCompleteListener;
import cn.studyjams.s1.sj50.yanglong.R;

/**
 * package: cn.studyjams.s1.sj50.yanglong.fragment <br/>
 * blog:<a href="http://dr-yanglong.github.io/">dr-yanglong.github.io</a><br/>
 * <p/>
 * functional describe:个人信息更新页面
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/29 18:40
 */
public class UserInfoView extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_userinfo, null);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
