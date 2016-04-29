package cn.studyjams.s1.sj50.yanglong.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import cn.studyjams.s1.sj50.yanglong.MainActivity;
import cn.studyjams.s1.sj50.yanglong.R;

/**
 * 左边菜单栏
 */
public class LeftFragment extends Fragment implements OnClickListener{
	private View mainListView;
	private View enrolledListView;
	private View nearListView;
	private View reviewListView;
	private View aboutPageView;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.layout_menu, null);
		//给所有右边视图加上监听器
		findViews(view);
		return view;
	}


	/***
	 * 给右边所有视图加监听器
	 * @param view
     */
	public void findViews(View view) {
		//查找到相应视图
		mainListView = view.findViewById(R.id.main_list);
		enrolledListView = view.findViewById(R.id.enrolled_list);
		nearListView = view.findViewById(R.id.near_list);
		reviewListView = view.findViewById(R.id.review_list);
		aboutPageView = view.findViewById(R.id.about_view);
		/**
		 * 所有视图绑定上菜单
		 */
		mainListView.setOnClickListener(this);
		enrolledListView.setOnClickListener(this);
		nearListView.setOnClickListener(this);
		reviewListView.setOnClickListener(this);
		aboutPageView.setOnClickListener(this);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/**
	 * 处理左边菜单相应文字被点击后切换视图到相应的视图，并改变主view的标题
	 * @param v
     */
	@Override
	public void onClick(View v) {
		Fragment newContent = null;
		String title = null;
		switch (v.getId()) {
		case R.id.main_list: //主页
			newContent = new MainListFragment();
			title = getString(R.string.main_title);
			break;
		case R.id.enrolled_list://已报名
			newContent = new EnrolledListFragment();
			title = getString(R.string.iEnrolled);
			break;
		case R.id.near_list: // 附近的分享
			newContent = new NearListFragment();
			title = getString(R.string.nearShare);
			break;
		case R.id.review_list: // 分享回顾
			newContent = new ReviewListFragment();
			title = getString(R.string.reviewTitle);
			break;
		case R.id.about_view: // 关于
			newContent = new AboutFragment();
			title = getString(R.string.aboutTitle);
			break;
		default:
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, title);
		}
	}
	
	/**
	 * 切换fragment
	 * @param fragment
	 */
	private void switchFragment(Fragment fragment, String title) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment, title);
		}
	}
	
}
