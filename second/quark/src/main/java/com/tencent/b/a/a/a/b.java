package com.tencent.b.a.a.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

final class b extends f {
    b(Context context) {
        super(context);
    }

    protected final void a(String str) {
        synchronized (this) {
            a.a(Environment.getExternalStorageDirectory() + "/" + h.c("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), h.c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(h.c("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
    }

    protected final boolean a() {
        return h.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    protected final String b() {
        String str;
        synchronized (this) {
            try {
                for (String str2 : a.a(new File(Environment.getExternalStorageDirectory(), h.c("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(h.c("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        new StringBuilder("read mid from InternalStorage:").append(split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Log.w("MID", e);
                str2 = null;
            }
        }
        return str2;
    }
}
