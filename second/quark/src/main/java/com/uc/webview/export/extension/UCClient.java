package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import java.util.HashMap;
import java.util.Map;

@Api
/* compiled from: ProGuard */
public class UCClient {
    public static final int FORM_PROMPT_TYPE_COVER = 1;
    public static final int FORM_PROMPT_TYPE_SAVE = 0;
    public static final int WEBVIEW_EVENT_TYPE_EMPTY_SCREEN = 9;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_OTHER_TRIGGER = 11;
    public static final int WEBVIEW_EVENT_TYPE_LOADING_USER_TRIGGER = 10;
    public static final int WEBVIEW_EVENT_TYPE_NETWORK_IP_RESOLVED = 12;
    public static final int WIFI_POLICY_CONTINUE = 0;
    public static final int WIFI_POLICY_INTERRUP = 1;
    public static final int WIFI_POLICY_USE_FOXY_SERVER = 2;

    @Api
    /* compiled from: ProGuard */
    public class MoveCursorToTextInputResult {
        public boolean mCanMoveToNext;
        public boolean mCanMoveToPrevious;
        public boolean mSuccess;
    }

    public void onFirstLayoutFinished(boolean z, String str) {
    }

    public void onWifiSafePolicy(WebView webView, IGenenalSyncResult iGenenalSyncResult) {
        iGenenalSyncResult.setResult(0);
        iGenenalSyncResult.wakeUp();
    }

    public void onFirstVisuallyNonEmptyDraw() {
    }

    public void onMoveCursorToTextInput(MoveCursorToTextInputResult moveCursorToTextInputResult) {
    }

    public void onReceivedDispatchResponse(HashMap<String, String> hashMap) {
    }

    public boolean onWillInterceptResponse(HashMap<String, String> hashMap) {
        return false;
    }

    @Deprecated
    public WebResourceRequest onWillSendRequest(WebResourceRequest webResourceRequest) {
        return null;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str, int i) {
        return false;
    }

    public void onResourceDidFinishLoading(String str, long j) {
    }

    public void onWebViewEvent(WebView webView, int i, Object obj) {
    }

    public void onPrereadFinished(WebView webView, String str, boolean z) {
    }

    public void onPrereadPageOpened(WebView webView, String str) {
    }

    public void onPrereadStarted(WebView webView, String str) {
    }

    public void onPrereadAborted(WebView webView, String str) {
    }

    public void onSaveFormDataPrompt(int i, ValueCallback<Boolean> valueCallback) {
    }

    public int getTitlebarVisibleHeight() {
        return 0;
    }

    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        return null;
    }

    public void onThemeChangedFinished(WebView webView) {
    }

    public void onEndEditingTextField(String str) {
    }

    public int onBeforeURLRequest(String str, String str2) {
        return 0;
    }

    public void onGeneralPermissionsShowPrompt(Map<String, String> map, ValueCallback<Map<String, String>> valueCallback) {
    }

    public boolean onCheckSelfPermission(String str) {
        return false;
    }
}
