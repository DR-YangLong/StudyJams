package cn.studyjams.s1.sj50.yanglong.Listener;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import cn.studyjams.s1.sj50.yanglong.R;

/**
 * package: cn.studyjams.s1.sj50.yanglong.Listener <br/>
 * blog:<a href="http://dr-yanglong.github.io/">dr-yanglong.github.io</a><br/>
 * <p>
 * functional describe:监听EditView输入完成
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/4/29 19:22
 */
public class EditCompleteListener implements TextView.OnEditorActionListener {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                event.getAction() == KeyEvent.ACTION_DOWN &&
                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            if (!event.isShiftPressed()) {
                // the user is done typing.
                v.setHint(v.getText());
                Toast.makeText(v.getContext(),"修改成功！",Toast.LENGTH_LONG).show();
                return true; //consume.
            }
        }
        //pass on to other listeners.
        return false;
    }
}
