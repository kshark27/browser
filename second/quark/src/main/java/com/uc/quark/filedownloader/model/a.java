package com.uc.quark.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class a implements Creator<FileDownloadTaskAtom> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FileDownloadTaskAtom[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FileDownloadTaskAtom(parcel);
    }
}
