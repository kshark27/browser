package com.uc.webview.export.internal.setup;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: ProGuard */
final class bi implements FilenameFilter {
    bi() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith("libkernel") && str.endsWith("_uc.so");
    }
}
