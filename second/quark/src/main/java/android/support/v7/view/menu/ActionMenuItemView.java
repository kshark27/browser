package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.c.h;
import android.support.v7.c.i;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.eu;
import android.support.v7.widget.fm;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class ActionMenuItemView extends AppCompatTextView implements k, eu, OnClickListener, OnLongClickListener {
    private i a;
    private CharSequence b;
    private Drawable c;
    private t d;
    private fm e;
    private j f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.g = resources.getBoolean(i.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ActionMenuItemView, i, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(h.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.g = getContext().getResources().getBoolean(i.abc_config_allowActionMenuItemTextWithIcon);
        e();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public i getItemData() {
        return this.a;
    }

    public final void a(i iVar) {
        this.a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((k) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.e == null) {
            this.e = new o(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a.hasSubMenu() && this.e != null && this.e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.d != null) {
            this.d.a(this.a);
        }
    }

    public void setItemInvoker(t tVar) {
        this.d = tVar;
    }

    public void setPopupCallback(j jVar) {
        this.f = jVar;
    }

    public final boolean a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (this.a != null) {
                this.a.b.h();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r0 = r5.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r5.c;
        if (r3 == 0) goto L_0x0023;
    L_0x000f:
        r3 = r5.a;
        r3 = r3.c;
        r3 = r3 & 4;
        r4 = 4;
        if (r3 != r4) goto L_0x002f;
    L_0x0018:
        r3 = r1;
    L_0x0019:
        if (r3 == 0) goto L_0x0024;
    L_0x001b:
        r3 = r5.g;
        if (r3 != 0) goto L_0x0023;
    L_0x001f:
        r3 = r5.h;
        if (r3 == 0) goto L_0x0024;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        r0 = r0 & r2;
        if (r0 == 0) goto L_0x0031;
    L_0x0027:
        r0 = r5.b;
    L_0x0029:
        r5.setText(r0);
        return;
    L_0x002d:
        r0 = r2;
        goto L_0x000b;
    L_0x002f:
        r3 = r2;
        goto L_0x0019;
    L_0x0031:
        r0 = 0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.ActionMenuItemView.e():void");
    }

    public void setIcon(Drawable drawable) {
        this.c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.k) {
                f = ((float) this.k) / ((float) intrinsicWidth);
                intrinsicWidth = this.k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.k) {
                f = ((float) this.k) / ((float) intrinsicHeight);
                intrinsicHeight = this.k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.b = charSequence;
        setContentDescription(this.b);
        e();
    }

    public final boolean c() {
        return b() && this.a.getIcon() == null;
    }

    public final boolean d() {
        return b();
    }

    public boolean onLongClick(View view) {
        if (b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ViewCompat.h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = b();
        if (b && this.j >= 0) {
            super.setPadding(this.j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == SectionHeader.SHT_LOUSER ? Math.min(size, this.i) : this.i;
        if (mode != UCCore.VERIFY_POLICY_QUICK && this.i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, UCCore.VERIFY_POLICY_QUICK), i2);
        }
        if (!b && this.c != null) {
            super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
