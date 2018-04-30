package accky.kreved.demo.navdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    UriMatcher mUriMatcher;

    public static final String auth = "my.provider.provider";
    public static final int CODE1 = 1;
    public static final int CODE2 = 2;

    @Override
    public boolean onCreate() {
        mUriMatcher = new UriMatcher(0);
        mUriMatcher.addURI(auth, "items", CODE1);
        mUriMatcher.addURI(auth, "item/#", CODE2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE1:
                break;
            case CODE2:
                break;
        }

        String[] cols = {"col1", "col2", "col3"};
        MatrixCursor mc = new MatrixCursor(cols);

        mc.addRow(new Object[] {"val1", 7, "hello"});
        mc.addRow(new Object[] {"val5", 5, "hello"});
        mc.addRow(new Object[] {"val6", 7, "hello"});

        return mc;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
