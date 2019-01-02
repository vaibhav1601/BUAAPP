package bramhagrjana.com.buaapp.view.SpalshScreen;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import bramhagrjana.com.buaapp.MainActivity;
import bramhagrjana.com.buaapp.R;
import bramhagrjana.com.buaapp.view.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity implements Runnable {
    public Animation anim;

   // private SharedPreferences preferences;
   // private SharedPreferences.Editor edit;

    private AppCompatTextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       // preferences = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this);
        //edit = preferences.edit();
        welcome= (AppCompatTextView) findViewById(R.id.welcome);
       // Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Snell Roundhand Script.ttf");
      //  welcome.setTypeface(custom_font);

//        Date c = Calendar.getInstance().getTime();
//        System.out.println("Current time => " + c);
//
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//
//        String formattedDate = df.format(c);
//        String arr[]=formattedDate.split("-");
//
//
//
//
//
//        String newDate=""+(Integer.parseInt(arr[0])+4)+"-"+arr[1]+"-"+arr[2];
//
//



//        if(preferences.getBoolean("CONTACTSYNC",false)){
//            StoreContacts = new ArrayList<String>();
//            EnableRuntimePermission();
//        }else{
        Thread t = new Thread(SplashActivity.this);
        t.start();
//        }



    }

    @Override
    public void run() {

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha_translate);
        anim.reset();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout.clearAnimation();
        linearLayout.startAnimation(anim);

        try {

            Thread.sleep(3000);

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);


          //  String phone=preferences.getString("phone","");
           // String email=preferences.getString("email","");
          //  String id=preferences.getString("id","");

          /*  Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);*/

/*


            if(!phone.equalsIgnoreCase("") && !id.equalsIgnoreCase("")&& !email.equalsIgnoreCase(""))
            {
                Intent intent = new Intent(this,HomeScreen.class);
                startActivity(intent);

            }else {
                Intent intent = new Intent(this,IntroActivity.class);
                startActivity(intent);
            }

*/



        } catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        finish();

    }


    private Cursor cursor ;
    private ArrayList<String> StoreContacts ;
    private String name, phonenumber ;
    public  static final int RequestPermissionCode  = 1 ;


    public void EnableRuntimePermission()
    {


        if (ActivityCompat.shouldShowRequestPermissionRationale(
                SplashActivity.this, Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(SplashActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();



        } else {

            ActivityCompat.requestPermissions(SplashActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }



    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult)
    {

        switch (RC)
        {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(SplashActivity.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                    getContactsIntoArrayList();

                } else {

                    Toast.makeText(SplashActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }


    private void getContactsIntoArrayList() {
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            StoreContacts.add(phonenumber);



        }

        cursor.close();




    }

}
