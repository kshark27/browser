package android.mini.support.v7.widget;

import android.mini.support.v7.widget.StaggeredGridLayoutManager.SavedState;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class bo implements Creator<SavedState> {
    bo() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }
}
