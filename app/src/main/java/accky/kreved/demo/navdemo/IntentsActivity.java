package accky.kreved.demo.navdemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.List;

public class IntentsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_res);

        TextView tv = (TextView) findViewById(R.id.content);

        ContentResolver cr = getContentResolver();

        Cursor c = cr.query(Uri.parse("content://my.provider.provider/items"),
                null, null, null, null
        );

        if (c != null) {
            if(c.getCount() > 0) {
                c.moveToNext();
                tv.setText(c.getString(0));
            }
        }





//        implicit();

//        chooser();

//        view();
//        send();
//
//        ContentUris.withAppendedId(Uri.parse("content://authority/"), 12);
//
//        try {
//            getContentResolver().openFileDescriptor(Uri.parse(""), "");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void view() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://ya.ru"));
        startActivity(i);
    }

    private void send() {
        Intent ii = new Intent(Intent.ACTION_SEND);
        ii.putExtra(Intent.EXTRA_TEXT, "blah");
        ii.setType("text/plain");
        startActivity(ii);
    }

    private void implicit() {
        Intent i = new Intent("my.action.VIEW");
        i.setData(Uri.parse("http://ya.ru/hello/world"));
        startActivity(i);
    }

    private void explicit() {
        Intent i = new Intent(this, CalledActivity.class);
        i.putExtra("test_sting", "Hello World");
        startActivityForResult(i, 20);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    private void chooser() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        Intent c = Intent.createChooser(i, "View with");

//        List<ResolveInfo> res = getPackageManager().queryIntentActivities(i, 0);
//        if(res != null && !res.isEmpty()) {
//            String p = res.get(0).activityInfo.packageName;
//        }


        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(c);
        }
    }


}
