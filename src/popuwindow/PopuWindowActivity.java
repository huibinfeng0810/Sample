package popuwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.huibinfeng0810.Sample.R;

/**
 * Created by huibin on 1/13/14.
 */
public class PopuWindowActivity extends Activity {

    private Button button;
    private PopupWindow popupWindow;
    private LinearLayout layout;
    private ListView listView;
    private String title[] = {"全部", "我的微博", "周边", "智能排版", "同学"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popu);

    }


    public void showPopupWindow(int x, int y) {
        layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.dialog, null);
        listView = (ListView) layout.findViewById(R.id.lv_dialog);
        listView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.text, R.id.tv_text, title));

        popupWindow = new PopupWindow(this);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow
                .setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);
        popupWindow.setHeight(300);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(layout);
        // showAsDropDown会把里面的view作为参照物，所以要那满屏幕parent
        // popupWindow.showAsDropDown(findViewById(R.id.tv_title), x, 10);
        popupWindow.showAtLocation(findViewById(R.id.main), Gravity.LEFT
                | Gravity.TOP, x, y);//需要指定Gravity，默认情况是center.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                button.setText(title[arg2]);
                popupWindow.dismiss();
                popupWindow = null;
            }
        });
    }


}
