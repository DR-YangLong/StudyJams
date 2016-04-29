package cn.studyjams.s1.sj50.yanglong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import cn.studyjams.s1.sj50.yanglong.fragment.DetailView;
import cn.studyjams.s1.sj50.yanglong.fragment.LeftFragment;
import cn.studyjams.s1.sj50.yanglong.fragment.MainListFragment;
import cn.studyjams.s1.sj50.yanglong.fragment.UserInfoView;

public class MainActivity extends SlidingFragmentActivity implements View.OnClickListener {

    private ImageView topButton;
    private Fragment mContent;
    private TextView topTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSlidingMenu(savedInstanceState);

        topButton = (ImageView) findViewById(R.id.topButton);
        if(topButton!=null) {
            topButton.setOnClickListener(this);
        }
        topTextView = (TextView) findViewById(R.id.topTv);
        //初始化列表
        this.switchContent(new MainListFragment(), getString(R.string.main_title));
    }

    /**
     * 初始化侧边栏
     */
    private void initSlidingMenu(Bundle savedInstanceState) {
        // 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
        if (savedInstanceState != null) {
            String key = getString(R.string.main_content);
            mContent = getSupportFragmentManager().getFragment(
                    savedInstanceState, key);
        }

        if (mContent == null) {
            mContent = new MainListFragment();
        }

        // 设置左侧滑动菜单
        setBehindContentView(R.layout.menu_frame_left);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, new LeftFragment()).commit();
        // 实例化滑动菜单对象
        SlidingMenu sm = getSlidingMenu();
        // 设置可以左右滑动的菜单
        sm.setMode(SlidingMenu.LEFT);
        // 设置滑动阴影的宽度
        sm.setShadowWidthRes(R.dimen.shadow_width);
        // 设置滑动菜单阴影的图像资源
        sm.setShadowDrawable(null);
        // 设置滑动菜单视图的宽度
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        sm.setFadeDegree(0.35f);
        // 设置触摸屏幕的模式,这里设置为全屏
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置下方视图的在滚动时的缩放比例
        sm.setBehindScrollScale(0.0f);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String key = getString(R.string.main_content);
        getSupportFragmentManager().putFragment(outState, key, mContent);
    }

    /**
     * 切换Fragment
     *
     * @param fragment
     */
    public void switchContent(Fragment fragment, String title) {
        mContent = fragment;
        //将于预占位的Fragment替换为新的Fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
        getSlidingMenu().showContent();
        //设置标题
        topTextView.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.topButton:
                toggle();
                break;
            default:
                break;
        }
    }

    /**
     * 点击头像打开用户详情
     *
     * @param view 头像view
     */
    public void openUserInfoView(View view) {
        switchContent(new UserInfoView(), getString(R.string.user_info_title));
    }

    /**
     * 打开详情页
     * @param view
     */
    public void openDetail(View view){
        switchContent(new DetailView(),"详情");
    }

    /**
     * 报名
     * @param view
     */
    public void enrollShare(View view){
        Toast.makeText(this,getString(R.string.user_enroll),Toast.LENGTH_LONG).show();
    }
}
