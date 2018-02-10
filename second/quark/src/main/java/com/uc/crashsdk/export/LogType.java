package com.uc.crashsdk.export;

/* compiled from: ProGuard */
public class LogType {
    public static final int JAVA = 16;
    public static final String JAVA_TYPE = "java";
    public static final int NATIVE = 1;
    public static final String NATIVE_TYPE = "jni";
    public static final int UNEXP = 256;
    public static final String UNEXP_TYPE = "unexp";

    public static boolean isForJava(int i) {
        return (i & 16) != 0;
    }

    public static boolean isForNative(int i) {
        return (i & 1) != 0;
    }

    public static boolean isForUnexp(int i) {
        return (i & UNEXP) != 0;
    }

    public static int addType(int i, int i2) {
        return (i2 & 273) | i;
    }

    public static int removeType(int i, int i2) {
        return ((i2 & 273) ^ -1) & i;
    }
}
