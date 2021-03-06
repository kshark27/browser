package android.mini.support.v4.view;

import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
final class bu implements an {
    final /* synthetic */ ViewPager a;
    private final Rect b = new Rect();

    bu(ViewPager viewPager) {
        this.a = viewPager;
    }

    public final cy a(View view, cy cyVar) {
        cy a = ViewCompat.a(view, cyVar);
        if (a.e()) {
            return a;
        }
        Rect rect = this.b;
        rect.left = a.a();
        rect.top = a.b();
        rect.right = a.c();
        rect.bottom = a.d();
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            cy b = ViewCompat.b(this.a.getChildAt(i), a);
            rect.left = Math.min(b.a(), rect.left);
            rect.top = Math.min(b.b(), rect.top);
            rect.right = Math.min(b.c(), rect.right);
            rect.bottom = Math.min(b.d(), rect.bottom);
        }
        return a.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
