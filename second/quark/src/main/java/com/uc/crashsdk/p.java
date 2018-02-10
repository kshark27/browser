package com.uc.crashsdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;

/* compiled from: ProGuard */
public class p {
    static final /* synthetic */ boolean a = (!p.class.desiredAssertionStatus());
    private static CustomInfo b = null;
    private static VersionInfo c = null;
    private static Object d = new Object();
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static Object h = new Object();

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        b = customInfo2;
        c(customInfo2);
        c = new VersionInfo(versionInfo);
        try {
            b.n();
            b.m();
            if (b.mBackupLogs) {
                File file = new File(P());
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        } catch (Throwable th) {
            a.a(th, false);
        }
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
    }

    public static void a(CustomInfo customInfo) {
        if (!a && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        } else if (!a && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        } else if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static boolean a() {
        return b != null;
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (d) {
            c = new VersionInfo(versionInfo);
            f.a();
            if (b.d) {
                JNIBridge.nativeSetVersionInfo(c.mVersion, c.mSubVersion, c.mBuildSeq, "170706161743");
                JNIBridge.nativeUpdateCrashLogNames();
            }
        }
    }

    private static void a(String str) {
        String a = f.a(str);
        JNIBridge.nativeSyncInfo("mLogTypeSuffix", a, 0, 0);
        f.b(a);
    }

    public static void b() {
        JNIBridge.nativeSetFolderNames(e.a, b.mTagFilesFolderName, b.mCrashLogsFolderName, P());
        JNIBridge.nativeSetProcessNames(f.d(), b.a());
        JNIBridge.nativeSetVersionInfo(c.mVersion, c.mSubVersion, c.mBuildSeq, "170706161743");
        JNIBridge.nativeSetMobileInfo(Build.MODEL, VERSION.RELEASE, f.j());
        JNIBridge.nativeSetLogStrategy(b.mCallNativeDefaultHandler, b.mDumpUserSolibBuildId, b.mReservedNativeMemoryBytes);
        Q();
    }

    private static void Q() {
        JNIBridge.nativeSetCrashLogFileNames(b.mNativeCrashLogFileName, b.mUnexpCrashLogFileName, b.mCrashLogPrefix);
    }

    public static void c() {
        R();
        S();
        T();
        a(b.mLogTypeSuffix);
    }

    private static void R() {
        JNIBridge.nativeSetCrashCustoms(G(), b.mBackupLogs, b.mCrashRestartInterval, b.mMaxCrashLogFilesCount, b.mMaxNativeLogcatLineCount, b.mMaxUnexpLogcatLineCount, b.mOverrideLibcMalloc, b.mModifyAbortCode, b.mUnexpOnlyKnownReason, b.mIsUsedByUCM, VERSION.SDK_INT, b.mOmitNativeCrash);
    }

    private static void S() {
        JNIBridge.nativeUpdateSignals(b.mDisableSignals, b.mDisableBackgroundSignals, 0);
    }

    private static void T() {
        JNIBridge.nativeSetZip(b.mZipLog, b.mZippedLogExtension, b.mLogMaxBytesLimit);
    }

    public static void d() {
        W();
        if (f.e()) {
            JNIBridge.nativeSetCrashLogFilesUploaded();
        }
        JNIBridge.nativeReserveFileHandle(b.mReservedNativeFileHandleCount, b.mFdDumpMinLimit);
        JNIBridge.nativeSetForeground(b.o());
        JNIBridge.nativeSetProcessType(b.s());
        a.b();
        a.d();
        a.e();
        a.f();
        JNIBridge.nativeSetPackageInfo(a.a, "", "");
        U();
        JNIBridge.nativeSyncInfo("aver", a.a(), 0, 0);
        V();
        b.v();
    }

    private static void U() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("thdump", null, (long) b.mThreadsDumpMinLimit, 0);
        }
    }

    public static String e() {
        return b.mCrashLogPrefix;
    }

    static boolean f() {
        if (h.b(b.mJavaCrashLogFileName) || h.b(b.mNativeCrashLogFileName) || h.b(b.mUnexpCrashLogFileName)) {
            return true;
        }
        return false;
    }

    static String g() {
        return b.mJavaCrashLogFileName;
    }

    public static int h() {
        return b.mCrashRestartInterval;
    }

    static boolean i() {
        return b.mCallJavaDefaultHandler;
    }

    static boolean j() {
        return b.mDumpHprofDataForJavaOOM;
    }

    static boolean k() {
        return b.mRenameFileToDefaultName;
    }

    static int l() {
        return b.mMaxCrashLogFilesCount;
    }

    static int m() {
        return b.mMaxCustomLogFilesCount;
    }

    static int n() {
        return b.mMaxJavaLogcatLineCount;
    }

    static int o() {
        return b.mUnexpDelayMillSeconds;
    }

    static boolean p() {
        return b.mBackupLogs;
    }

    public static boolean q() {
        return b.mUploadUcebuCrashLog;
    }

    public static boolean r() {
        return b.mSyncUploadSetupCrashLogs;
    }

    static boolean s() {
        return b.mOmitJavaCrash;
    }

    static boolean t() {
        return b.mAutoDeleteOldVersionStats;
    }

    static boolean u() {
        return b.mZipLog;
    }

    static String v() {
        return b.mZippedLogExtension;
    }

    static int w() {
        return b.mLogMaxBytesLimit;
    }

    static int x() {
        return b.mLogMaxUploadBytesLimit;
    }

    static long y() {
        return b.mMaxUploadBytesPerDay;
    }

    static int z() {
        return b.mMaxUploadCrashLogCountPerDay;
    }

    static int A() {
        return b.mMaxUploadCustomLogCountPerDay;
    }

    static int B() {
        return b.mMaxCustomLogCountPerTypePerDay;
    }

    static int C() {
        return b.mUnexpInfoUpdateInterval;
    }

    static int D() {
        return b.mReservedJavaFileHandleCount;
    }

    static int E() {
        return b.mFdDumpMinLimit;
    }

    static int F() {
        return b.mThreadsDumpMinLimit;
    }

    public static boolean G() {
        return b == null || b.mDebugCrashSDK;
    }

    static String H() {
        return b.mLogTypeSuffix;
    }

    public static boolean I() {
        return b.mEnableStatReport;
    }

    public static boolean J() {
        return b.mIsInternational;
    }

    public static String K() {
        return c.mVersion;
    }

    public static String L() {
        return c.mSubVersion;
    }

    public static String M() {
        return c.mBuildSeq;
    }

    public static String N() {
        if (e == null) {
            e = e.a + File.separatorChar + b.mTagFilesFolderName + File.separatorChar;
        }
        return e;
    }

    public static String O() {
        if (f == null) {
            f = e.a + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
        }
        return f;
    }

    public static String P() {
        if (g == null) {
            String str;
            if (h.a(b.mLogsBackupPathName)) {
                str = "/sdcard";
                try {
                    str = Environment.getExternalStorageDirectory().getPath();
                } catch (Throwable th) {
                    a.a(th, false);
                }
                g = str + File.separatorChar + b.mCrashLogsFolderName + File.separatorChar;
            } else {
                str = b.mLogsBackupPathName.trim();
                if (!str.endsWith(File.separator)) {
                    str = str + File.separator;
                }
                g = str;
            }
        }
        return g;
    }

    public static CustomInfo a(Bundle bundle) {
        CustomInfo customInfo;
        if (b == null) {
            customInfo = new CustomInfo();
        } else {
            customInfo = new CustomInfo(b);
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Throwable e) {
                        a.a(e, false);
                        throw new IllegalArgumentException("Field " + str + " must be a " + field.getType().getName() + ", but give a " + (obj != null ? obj.getClass().getName() : "(null)"));
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo b(Bundle bundle) {
        VersionInfo versionInfo;
        if (c == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(c);
        }
        String string = bundle.getString("mVersion");
        if (!h.a(string)) {
            versionInfo.mVersion = string;
        }
        string = bundle.getString("mSubVersion");
        if (!h.a(string)) {
            versionInfo.mSubVersion = string;
        }
        string = bundle.getString("mBuildSeq");
        if (!h.a(string)) {
            versionInfo.mBuildSeq = string;
        }
        string = bundle.getString("crver");
        if (!h.a(string)) {
            a.b = string;
            V();
        }
        return versionInfo;
    }

    private static void V() {
        if (b.d) {
            JNIBridge.nativeSyncInfo("crver", a.b, 0, 1);
        }
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static int b(CustomInfo customInfo) {
        int i = 0;
        int i2 = 1;
        synchronized (h) {
            if (customInfo != null) {
                int i3;
                int i4;
                c(customInfo);
                if (b == null) {
                    b = new CustomInfo();
                }
                CustomInfo customInfo2 = b;
                if (a(customInfo.mCrashLogPrefix, customInfo2.mCrashLogPrefix)) {
                    i3 = 0;
                    i4 = 0;
                } else {
                    customInfo2.mCrashLogPrefix = customInfo.mCrashLogPrefix;
                    i3 = 1;
                    i4 = 1;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i4++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    customInfo2.mNativeCrashLogFileName = customInfo.mNativeCrashLogFileName;
                    i4++;
                    i3 = 1;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    customInfo2.mUnexpCrashLogFileName = customInfo.mUnexpCrashLogFileName;
                    i4++;
                    i3 = 1;
                }
                if (i3 != 0) {
                    f.a();
                    if (b.d) {
                        Q();
                        JNIBridge.nativeUpdateCrashLogNames();
                    }
                }
                if (customInfo2.mDebugCrashSDK != customInfo.mDebugCrashSDK) {
                    customInfo2.mDebugCrashSDK = customInfo.mDebugCrashSDK;
                    i4++;
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (customInfo2.mBackupLogs != customInfo.mBackupLogs) {
                    customInfo2.mBackupLogs = customInfo.mBackupLogs;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mOmitNativeCrash != customInfo.mOmitNativeCrash) {
                    customInfo2.mOmitNativeCrash = customInfo.mOmitNativeCrash;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mCrashRestartInterval != customInfo.mCrashRestartInterval) {
                    customInfo2.mCrashRestartInterval = customInfo.mCrashRestartInterval;
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        r.a();
                    }
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mMaxCrashLogFilesCount != customInfo.mMaxCrashLogFilesCount) {
                    customInfo2.mMaxCrashLogFilesCount = customInfo.mMaxCrashLogFilesCount;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mMaxNativeLogcatLineCount != customInfo.mMaxNativeLogcatLineCount) {
                    customInfo2.mMaxNativeLogcatLineCount = customInfo.mMaxNativeLogcatLineCount;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mMaxJavaLogcatLineCount != customInfo.mMaxJavaLogcatLineCount) {
                    customInfo2.mMaxJavaLogcatLineCount = customInfo.mMaxJavaLogcatLineCount;
                    i4++;
                }
                if (customInfo2.mMaxUnexpLogcatLineCount != customInfo.mMaxUnexpLogcatLineCount) {
                    customInfo2.mMaxUnexpLogcatLineCount = customInfo.mMaxUnexpLogcatLineCount;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mUnexpOnlyKnownReason != customInfo.mUnexpOnlyKnownReason) {
                    customInfo2.mUnexpOnlyKnownReason = customInfo.mUnexpOnlyKnownReason;
                    i4++;
                    i3 = 1;
                }
                if (customInfo2.mIsUsedByUCM != customInfo.mIsUsedByUCM) {
                    customInfo2.mIsUsedByUCM = customInfo.mIsUsedByUCM;
                    i3 = i4 + 1;
                    i4 = 1;
                } else {
                    int i5 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                if (i4 != 0 && b.d) {
                    R();
                }
                if (customInfo2.mZipLog != customInfo.mZipLog) {
                    customInfo2.mZipLog = customInfo.mZipLog;
                    i3++;
                    i = 1;
                }
                if (!a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i3++;
                    i = 1;
                }
                if (customInfo2.mLogMaxBytesLimit != customInfo.mLogMaxBytesLimit) {
                    customInfo2.mLogMaxBytesLimit = customInfo.mLogMaxBytesLimit;
                    i = i3 + 1;
                } else {
                    i2 = i;
                    i = i3;
                }
                if (i2 != 0 && b.d) {
                    T();
                }
                if (customInfo2.mSyncUploadSetupCrashLogs != customInfo.mSyncUploadSetupCrashLogs) {
                    customInfo2.mSyncUploadSetupCrashLogs = customInfo.mSyncUploadSetupCrashLogs;
                    i++;
                }
                if (customInfo2.mMaxCustomLogFilesCount != customInfo.mMaxCustomLogFilesCount) {
                    customInfo2.mMaxCustomLogFilesCount = customInfo.mMaxCustomLogFilesCount;
                    i++;
                }
                if (customInfo2.mOmitJavaCrash != customInfo.mOmitJavaCrash) {
                    customInfo2.mOmitJavaCrash = customInfo.mOmitJavaCrash;
                    i++;
                }
                if (customInfo2.mLogMaxUploadBytesLimit != customInfo.mLogMaxUploadBytesLimit) {
                    customInfo2.mLogMaxUploadBytesLimit = customInfo.mLogMaxUploadBytesLimit;
                    i++;
                }
                if (customInfo2.mMaxUploadBytesPerDay != customInfo.mMaxUploadBytesPerDay) {
                    customInfo2.mMaxUploadBytesPerDay = customInfo.mMaxUploadBytesPerDay;
                    i++;
                }
                if (customInfo2.mMaxUploadCrashLogCountPerDay != customInfo.mMaxUploadCrashLogCountPerDay) {
                    customInfo2.mMaxUploadCrashLogCountPerDay = customInfo.mMaxUploadCrashLogCountPerDay;
                    i++;
                }
                if (customInfo2.mMaxUploadCustomLogCountPerDay != customInfo.mMaxUploadCustomLogCountPerDay) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = customInfo.mMaxUploadCustomLogCountPerDay;
                    i++;
                }
                if (customInfo2.mMaxCustomLogCountPerTypePerDay != customInfo.mMaxCustomLogCountPerTypePerDay) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = customInfo.mMaxCustomLogCountPerTypePerDay;
                    i++;
                }
                if (customInfo2.mCallJavaDefaultHandler != customInfo.mCallJavaDefaultHandler) {
                    customInfo2.mCallJavaDefaultHandler = customInfo.mCallJavaDefaultHandler;
                    i++;
                }
                if (!(customInfo2.mCallNativeDefaultHandler == customInfo.mCallNativeDefaultHandler && customInfo2.mDumpUserSolibBuildId == customInfo.mDumpUserSolibBuildId)) {
                    customInfo2.mCallNativeDefaultHandler = customInfo.mCallNativeDefaultHandler;
                    customInfo2.mDumpUserSolibBuildId = customInfo.mDumpUserSolibBuildId;
                    if (customInfo2.mCallNativeDefaultHandler != customInfo.mCallNativeDefaultHandler) {
                        i++;
                    }
                    if (customInfo2.mDumpUserSolibBuildId != customInfo.mDumpUserSolibBuildId) {
                        i++;
                    }
                    if (b.d) {
                        JNIBridge.nativeSetLogStrategy(b.mCallNativeDefaultHandler, b.mDumpUserSolibBuildId, b.mReservedNativeMemoryBytes);
                    }
                    i++;
                }
                if (customInfo2.mDumpHprofDataForJavaOOM != customInfo.mDumpHprofDataForJavaOOM) {
                    customInfo2.mDumpHprofDataForJavaOOM = customInfo.mDumpHprofDataForJavaOOM;
                    i++;
                }
                if (customInfo2.mRenameFileToDefaultName != customInfo.mRenameFileToDefaultName) {
                    customInfo2.mRenameFileToDefaultName = customInfo.mRenameFileToDefaultName;
                    i++;
                }
                if (customInfo2.mAutoDeleteOldVersionStats != customInfo.mAutoDeleteOldVersionStats) {
                    customInfo2.mAutoDeleteOldVersionStats = customInfo.mAutoDeleteOldVersionStats;
                    i++;
                }
                if (customInfo2.mFdDumpMinLimit != customInfo.mFdDumpMinLimit) {
                    customInfo2.mFdDumpMinLimit = customInfo.mFdDumpMinLimit;
                    if (b.d) {
                        JNIBridge.nativeReserveFileHandle(0, b.mFdDumpMinLimit);
                    }
                    i++;
                }
                if (customInfo2.mThreadsDumpMinLimit != customInfo.mThreadsDumpMinLimit) {
                    customInfo2.mThreadsDumpMinLimit = customInfo.mThreadsDumpMinLimit;
                    U();
                }
                if (customInfo2.mUnexpInfoUpdateInterval != customInfo.mUnexpInfoUpdateInterval) {
                    if (customInfo2.mUnexpInfoUpdateInterval <= 0 && customInfo.mUnexpInfoUpdateInterval > 0) {
                        a.a(false);
                    }
                    customInfo2.mUnexpInfoUpdateInterval = customInfo.mUnexpInfoUpdateInterval;
                    i++;
                }
                if (!a(customInfo.mLogTypeSuffix, customInfo2.mLogTypeSuffix)) {
                    customInfo2.mLogTypeSuffix = customInfo.mLogTypeSuffix;
                    if (b.d) {
                        a(customInfo2.mLogTypeSuffix);
                    }
                    i++;
                }
                if (customInfo2.mDisableBackgroundSignals != customInfo.mDisableBackgroundSignals) {
                    customInfo2.mDisableBackgroundSignals = customInfo.mDisableBackgroundSignals;
                    if (b.d) {
                        S();
                    }
                    i++;
                }
                if (customInfo2.mEnableStatReport != customInfo.mEnableStatReport) {
                    customInfo2.mEnableStatReport = customInfo.mEnableStatReport;
                    i++;
                }
                if (customInfo2.mIsInternational != customInfo.mIsInternational) {
                    customInfo2.mIsInternational = customInfo.mIsInternational;
                    W();
                    i++;
                }
            }
        }
        return i;
    }

    private static void W() {
        if (b.d) {
            long j = 1;
            if (b.mIsInternational) {
                j = 2;
            }
            JNIBridge.nativeSyncInfo("inter", null, j, 0);
        }
    }
}
