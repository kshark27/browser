package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.download.UpdateTask;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class m implements ValueCallback<UpdateTask> {
    final /* synthetic */ Callable a;

    m(Callable callable) {
        this.a = callable;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        try {
            if (this.a != null && !((Boolean) this.a.call()).booleanValue()) {
                throw new RuntimeException("Update should be in wifi network.");
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
