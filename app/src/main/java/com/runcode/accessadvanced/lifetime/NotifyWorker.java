package com.runcode.accessadvanced.lifetime;


import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotifyWorker extends Worker
{

    public NotifyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        NotificationUtils.showNotification(MyApplication.getContext(),"one hour passed","your time is limited.");
        return Result.success();
    }
}
