package com.taobao.weex.ui.component.b;

import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.view.refresh.wrapper.a;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ ab a;
    final /* synthetic */ r b;

    p(r rVar, ab abVar) {
        this.b = rVar;
        this.a = abVar;
    }

    public final void run() {
        ((a) this.b.getHostView()).setHeaderView(this.a);
    }
}
