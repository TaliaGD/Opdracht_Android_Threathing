package be.ehb.opdracht_android_threathing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import be.ehb.opdracht_android_threathing.util.ProgressTask;

public class MainActivity extends AppCompatActivity {

//    private TextView tv1, tv2, tv3;
    private ProgressBar pb1, pb2, pb3;
    private Button btnStartTask;
    private boolean isRunning = false;
   private View.OnClickListener startTaskListener = new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           ProgressTask task = new ProgressTask(pb1, pb2, pb3, btnStartTask);
           task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
           startThread();
       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv1 = findViewById(R.id.tv_firstParty);
//        tv2 = findViewById(R.id.tv_secondParty);
//        tv3 = findViewById(R.id.tv_thirdParty);

        pb1 = findViewById(R.id.pb_progressParty1);
        pb2 = findViewById(R.id.pb_progressParty2);
        pb3 = findViewById(R.id.pb_progressParty3);

        btnStartTask = findViewById(R.id.btn_start);

        btnStartTask.setOnClickListener(startTaskListener);
    }
    private void startThread() {
        Thread bgThread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i=0; i<20; i++){
                    Message msg = new Message();
                    msg.arg1 = i;


                }
                isRunning = false;
            }
        });
        bgThread.start();
    }
}
