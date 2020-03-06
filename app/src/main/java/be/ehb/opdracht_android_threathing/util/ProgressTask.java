package be.ehb.opdracht_android_threathing.util;

import android.icu.math.MathContext;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;
import java.util.Random;

public class ProgressTask extends AsyncTask <Void, Integer, Void> {

    //weak reference is noodzakelijk zodat dit naar de achtergrond kan gezet worden
    private WeakReference<ProgressBar> pbReference1, pbReference2, pbReference3;
    private WeakReference<Button> btnReference;


    //constructor


    public ProgressTask(ProgressBar pb1, ProgressBar pb2, ProgressBar pb3, Button btnStartTask ) {
        pbReference1 = new WeakReference<>(pb1);
        pbReference2 = new WeakReference<>(pb2);
        pbReference3 = new WeakReference<>(pb3);
        btnReference = new WeakReference<>(btnStartTask);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btnReference.get().setEnabled(false);
    }
    @Override
    protected Void doInBackground(Void... niks) {
        Random rand = new Random();
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);

        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        pbReference1.get().setProgress(values[0]);
        pbReference2.get().setProgress(values[0]);
        pbReference3.get().setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        btnReference.get().setEnabled(true);
        pbReference1 = null;
        pbReference2 = null;
        pbReference3 = null;
        btnReference = null;
    }




}
