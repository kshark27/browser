package com.uc.webview.export;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import java.lang.reflect.Constructor;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ Class a;
    final /* synthetic */ Class[] b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ ValueCallback d;

    d(Class cls, Class[] clsArr, Object[] objArr, ValueCallback valueCallback) {
        this.a = cls;
        this.b = clsArr;
        this.c = objArr;
        this.d = valueCallback;
    }

    public final void run() {
        try {
            Constructor declaredConstructor = this.a.getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            Handler handler = new Handler(Looper.getMainLooper());
            Runnable eVar = new e(this, declaredConstructor);
            if (((Boolean) SDKFactory.invoke(10050, new Object[0])).booleanValue() && WebView.getCoreType() == 0) {
                throw new RuntimeException("coreType is not valid. init maybe failed.");
            }
            handler.postAtFrontOfQueue(eVar);
        } catch (Throwable th) {
            this.d.onReceiveValue(new Pair(null, th));
        }
    }
}
