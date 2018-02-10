package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class ActionBarContainer extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable fjVar;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            fjVar = new fj(this);
        } else {
            fjVar = new db(this);
        }
        setBackgroundDrawable(fjVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ActionBar);
        this.a = obtainStyledAttributes.getDrawable(h.ActionBar_background);
        this.b = obtainStyledAttributes.getDrawable(h.ActionBar_backgroundStacked);
        this.j = obtainStyledAttributes.getDimensionPixelSize(h.ActionBar_height, -1);
        if (getId() == j.split_action_bar) {
            this.d = true;
            this.c = obtainStyledAttributes.getDrawable(h.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.d ? this.c == null : this.a == null && this.b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(j.action_bar);
        this.i = findViewById(j.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.a != null) {
            this.a.setCallback(null);
            unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (!(this.a == null && this.b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.b != null) {
            this.b.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (!(this.a == null && this.b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.c != null) {
            this.c.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.d) {
            if (this.c != null) {
                z = false;
            }
        } else if (!(this.a == null && this.b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.a != null) {
            this.a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.a && !this.d) || ((drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.a != null) {
                this.a.jumpToCurrentState();
            }
            if (this.b != null) {
                this.b.jumpToCurrentState();
            }
            if (this.c != null) {
                this.c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(fu fuVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = fuVar;
        if (fuVar != null) {
            addView(fuVar);
            LayoutParams layoutParams = fuVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            fuVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private static boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.h == null && MeasureSpec.getMode(i2) == SectionHeader.SHT_LOUSER && this.j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.j, MeasureSpec.getSize(i2)), SectionHeader.SHT_LOUSER);
        }
        super.onMeasure(i, i2);
        if (this.h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.g != null && this.g.getVisibility() != 8 && mode != UCCore.VERIFY_POLICY_QUICK) {
                int b;
                if (!a(this.h)) {
                    b = b(this.h);
                } else if (a(this.i)) {
                    b = 0;
                } else {
                    b = b(this.i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + b(this.g), mode == SectionHeader.SHT_LOUSER ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.d) {
            int i6;
            if (this.a != null) {
                if (this.h.getVisibility() == 0) {
                    this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i == null || this.i.getVisibility() != 0) {
                    this.a.setBounds(0, 0, 0, 0);
                } else {
                    this.a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.e = z2;
            if (!z2 || this.b == null) {
                i5 = i6;
            } else {
                this.b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.c != null) {
            this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
