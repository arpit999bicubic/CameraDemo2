package com.bicubic.camerademo2.Task;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.bicubic.camerademo2.MainActivity;
import com.bicubic.camerademo2.Utility.FileHelper;

import static com.bicubic.camerademo2.Utility.Constant.*;

/**
 * Created by vishnu on 08/07/15.
 */
public class SaveImageTask extends AsyncTask<Bitmap, Void, FileSaveStatus> {

    private Context context;

    public SaveImageTask(Context context){
        this.context = context;
    }

    @Override
    protected FileSaveStatus doInBackground(Bitmap... params) {

        return FileHelper.saveFile(context, MEDIA_TYPE_IMAGE, params[0]);
    }

    @Override
    protected void onPostExecute(FileSaveStatus fileSaveStatus) {
        if(context instanceof MainActivity){
            ((MainActivity)context).fileSaveComplete(fileSaveStatus);
        }
    }
}
