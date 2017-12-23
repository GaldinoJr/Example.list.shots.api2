package galdino.examplelistshotsapi.util;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Galdino on 22/12/2017.
 */

public class MethodsUtil
{
    public static String getDateFormated(String sDate)
    {
        DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Date date = null;
        try {
            date = inputFormat.parse(sDate);
        } catch (ParseException e) {
            return sDate;
        }
        return outputFormat.format(date);
    }

    @SuppressWarnings("deprecation")
    public static void setDescriptionHtml(TextView tvDescription, String description) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            tvDescription.setText(Html.fromHtml(description,Html.FROM_HTML_MODE_LEGACY));

        }
        else
        {
            tvDescription.setText(Html.fromHtml(description));
        }
    }
}
