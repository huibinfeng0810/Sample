package loader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.huibinfeng0810.Sample.R;

/**
 * Created by huibin on 2/19/14.
 */
public class ContactSearchFragment extends Activity implements LoaderManager.LoaderCallbacks<Cursor>, TextWatcher {
    private Uri uri = ContactsContract.Contacts.CONTENT_URI;

    private EditText searchEditText;
    private ListView mListView;
    private String keyWorld;


    private SimpleCursorAdapter mAdapter;

    private ContactLoader loader;

    private LoaderManager loaderManager;


    // These are the Contacts rows that we will retrieve
    final String[] PROJECTION = new String[]{ContactsContract.Data._ID,
            ContactsContract.Data.DISPLAY_NAME};

    // This is the select criteria
    String SELECTION = null;

    String[] SELECTION_ARGS = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactsearch);

        searchEditText = (EditText) findViewById(R.id.search_edittext);
        searchEditText.addTextChangedListener(this);
        mListView = (ListView) findViewById(R.id.list);
        mAdapter = new SimpleCursorAdapter(this, R.layout.item_contactsearch,
                null, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, new int[]{R.id.name});
        mListView.setAdapter(mAdapter);

        loaderManager = getLoaderManager();
        loaderManager.initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new ContactLoader(getApplicationContext(), uri, PROJECTION, SELECTION, SELECTION_ARGS, null);
    }


    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        mAdapter.changeCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        mAdapter.swapCursor(null);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        loaderManager.destroyLoader(1);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        SELECTION = new String(ContactsContract.Contacts.DISPLAY_NAME
                + " LIKE ?");
        keyWorld = "%" + charSequence.toString() + "%";
        Log.d("key world", keyWorld);
        SELECTION_ARGS = new String[]{keyWorld};


    }

    @Override
    public void afterTextChanged(Editable editable) {
        loaderManager.restartLoader(1, null, this);
    }


    /**
     * adapter
     */
    public class ContactAdapter extends CursorAdapter {


        public ContactAdapter(Context context, Cursor c, boolean autoRequery) {
            super(context, c, autoRequery);
        }

        public ContactAdapter(Context context, Cursor c, int flags) {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return null;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

        }
    }
}
