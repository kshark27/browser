package com.taobao.android.binding.core;

import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: ProGuard */
final class da implements bg {
    da() {
    }

    public final Object a(ArrayList<Object> arrayList) throws NumberFormatException, JSONException {
        double doubleValue = ((Double) arrayList.get(0)).doubleValue();
        double doubleValue2 = ((Double) arrayList.get(1)).doubleValue();
        double doubleValue3 = ((Double) arrayList.get(2)).doubleValue();
        double doubleValue4 = ((Double) arrayList.get(3)).doubleValue();
        doubleValue = Math.min(doubleValue, doubleValue4);
        return Double.valueOf(doubleValue == doubleValue4 ? doubleValue2 + doubleValue3 : (((-Math.pow(2.0d, (doubleValue * -10.0d) / doubleValue4)) + 1.0d) * doubleValue3) + doubleValue2);
    }
}
