package com.ucweb.common.util.i;

import java.io.UnsupportedEncodingException;

/* compiled from: ProGuard */
public final class b {
    private static final byte[] a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i = (length / 4) * 3;
        if (i == 0) {
            return new byte[0];
        }
        Object obj = new byte[i];
        i = length;
        length = 0;
        while (true) {
            byte b = bArr[i - 1];
            if (!(b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9)) {
                if (b != (byte) 61) {
                    break;
                }
                length++;
            }
            i--;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < i) {
            int i6;
            b = bArr[i2];
            if (b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9) {
                i6 = i3;
                i3 = i5;
                i5 = i4;
            } else {
                if (b >= (byte) 65 && b <= (byte) 90) {
                    i6 = b - 65;
                } else if (b >= (byte) 97 && b <= (byte) 122) {
                    i6 = b - 71;
                } else if (b >= (byte) 48 && b <= (byte) 57) {
                    i6 = b + 4;
                } else if (b == (byte) 43) {
                    i6 = 62;
                } else if (b != (byte) 47) {
                    return null;
                } else {
                    i6 = 63;
                }
                i3 = (i3 << 6) | ((byte) i6);
                if (i4 % 4 == 3) {
                    i6 = i5 + 1;
                    obj[i5] = (byte) ((16711680 & i3) >> 16);
                    i5 = i6 + 1;
                    obj[i6] = (byte) ((65280 & i3) >> 8);
                    i6 = i5 + 1;
                    obj[i5] = (byte) (i3 & 255);
                } else {
                    i6 = i5;
                }
                i5 = i4 + 1;
                int i7 = i3;
                i3 = i6;
                i6 = i7;
            }
            i2++;
            i4 = i5;
            i5 = i3;
            i3 = i6;
        }
        if (length > 0) {
            i6 = i3 << (length * 6);
            i = i5 + 1;
            obj[i5] = (byte) ((16711680 & i6) >> 16);
            if (length == 1) {
                i5 = i + 1;
                obj[i] = (byte) ((65280 & i6) >> 8);
            } else {
                i5 = i;
            }
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(obj, 0, bArr2, 0, i5);
        return bArr2;
    }

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + ((length / 76) + 3))];
        int length2 = bArr.length - (bArr.length % 3);
        length = 0;
        int i = 0;
        for (int i2 = 0; i2 < length2; i2 += 3) {
            int i3 = i + 1;
            bArr2[i] = a[(bArr[i2] & 255) >> 2];
            i = i3 + 1;
            bArr2[i3] = a[((bArr[i2] & 3) << 4) | ((bArr[i2 + 1] & 255) >> 4)];
            int i4 = i + 1;
            bArr2[i] = a[((bArr[i2 + 1] & 15) << 2) | ((bArr[i2 + 2] & 255) >> 6)];
            i3 = i4 + 1;
            bArr2[i4] = a[bArr[i2 + 2] & 63];
            if ((i3 - length) % 76 != 0 || i3 == 0) {
                i = i3;
            } else {
                i = i3 + 1;
                bArr2[i3] = (byte) 10;
                length++;
            }
        }
        switch (bArr.length % 3) {
            case 1:
                length = i + 1;
                bArr2[i] = a[(bArr[length2] & 255) >> 2];
                i = length + 1;
                bArr2[length] = a[(bArr[length2] & 3) << 4];
                i3 = i + 1;
                bArr2[i] = (byte) 61;
                length = i3 + 1;
                bArr2[i3] = (byte) 61;
                break;
            case 2:
                length = i + 1;
                bArr2[i] = a[(bArr[length2] & 255) >> 2];
                i = length + 1;
                bArr2[length] = a[((bArr[length2] & 3) << 4) | ((bArr[length2 + 1] & 255) >> 4)];
                i3 = i + 1;
                bArr2[i] = a[(bArr[length2 + 1] & 15) << 2];
                length = i3 + 1;
                bArr2[i3] = (byte) 61;
                break;
            default:
                length = i;
                break;
        }
        return new String(bArr2, 0, length, str);
    }
}
