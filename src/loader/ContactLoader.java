package loader;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * Created by huibin on 2/19/14.
 */
public class ContactLoader extends CursorLoader {
    private Context mContext;
    private String selection;
    private String[] selectionArgs, projection;
    private Uri uri;

    public ContactLoader(Context context) {
        super(context);
        this.mContext = context;
    }

    public ContactLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
        this.projection = projection;
        this.selection = selection;
        this.selectionArgs = selectionArgs;
        this.mContext = context;
        this.uri = uri;
    }



    @Override
    protected Cursor onLoadInBackground() {
        Cursor cursor = mContext.getContentResolver().query(uri,
                projection, selection, selectionArgs, null);
        return cursor;
    }
}
