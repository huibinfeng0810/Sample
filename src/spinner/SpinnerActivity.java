package spinner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.huibinfeng0810.Sample.R;

/**
 * User: fenghb
 * Date: 14-1-8
 * Time: 下午12:22
 */
public class SpinnerActivity extends Activity {
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initSpinner();
    }

    public void initSpinner() {
        mSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.calllog_spinner_text, R.layout.calllog_spinner_item);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mSpinnerAdapter);

    }

}
