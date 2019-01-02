package bramhagrjana.com.buaapp.utilise;


import android.view.View;
import android.widget.Toast;

public class DisplayMessageUtils
{

    public static void showSnack(View v, String message)
    {

        Toast.makeText(v.getContext(),message,Toast.LENGTH_LONG).show();

    }

}
