package com.mofunsky.mofundownloadmanager;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mofunsky.downloadmanager.library.core.DownloadManagerPro;
import com.mofunsky.downloadmanager.library.report.listener.DownloadManagerListener;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements DownloadManagerListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String dir = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/downloadManager/";
        File f = new File(dir);
        if (!f.isDirectory()) {
            f.mkdirs();
        }
        DownloadManagerPro dm = new DownloadManagerPro(this.getApplicationContext());

        dm.init(dir, 1, this);


        int taskToken = dm.addTask("save_name", "http://7jptcs.com5.z0.glb.clouddn.com/144/65/20150721215246648668000535_mfs.mp4", false, false);
        try {
            dm.startDownload(taskToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnDownloadStarted(long taskId) {

    }

    @Override
    public void OnDownloadPaused(long taskId) {

    }

    @Override
    public void onDownloadProcess(long taskId, double percent, long downloadedLength) {
        Log.e("download", taskId + ":" + percent + "%");
    }

    @Override
    public void OnDownloadFinished(long taskId) {

    }

    @Override
    public void OnDownloadRebuildStart(long taskId) {

    }

    @Override
    public void OnDownloadRebuildFinished(long taskId) {

    }

    @Override
    public void OnDownloadCompleted(long taskId) {

    }

    @Override
    public void connectionLost(long taskId) {

    }
}
