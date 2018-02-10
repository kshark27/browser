package com.ucpro.feature.video.c.d;

/* compiled from: ProGuard */
public enum a {
    VPS_UNKNOWN(100000, "VPS_UNKNOWN"),
    VPS_RESOLUTION_LIST_SIZE_ZERO(100001, "VPS_RESOLUTION_LIST_SIZE_ZERO"),
    VPS_RESOLUTION_LIST_RESPOND_PB_ERROR(100002, "VPS_RESOLUTION_LIST_RESPOND_PB_ERROR"),
    VPS_VIDEO_LIST_RESPOND_PB_ERROR(100003, "VPS_VIDEO_LIST_RESPOND_PB_ERROR"),
    VPS_RESPONSE_VIDEO_LIST_SIZE_ZERO(100004, "VPS_RESPONSE_VIDEO_LIST_SIZE_ZERO"),
    VPS_FILITERED_VIDEO_LIST_SIZE_ZERO(100005, "VPS_FILITERED_VIDEO_LIST_SIZE_ZERO"),
    VPS_REQUEST_RESOLUTION_NOT_ILLEGAL(100006, "VPS_REQUEST_RESOLUTION_NOT_ILLEGAL"),
    VPS_RESPONSE_UNKNOW_ERROR(110001, "VPS_RESPONSE_UNKNOW_ERROR"),
    VPS_RESPONSE_UNSUPPORT_ERROR(110002, "VPS_RESPONSE_UNSUPPORT_ERROR"),
    VPS_RESPONSE_PAY_NEED_ERROR(110003, "VPS_RESPONSE_PAY_NEED_ERROR"),
    VPS_RESPONSE_ENCODED_VIDEO_ERROR(110004, "VPS_RESPONSE_ENCODED_VIDEO_ERROR"),
    VPS_RESPONSE_FRIEND_VIDEO_ERROR(110005, "VPS_RESPONSE_FRIEND_VIDEO_ERROR"),
    VPS_RESPONSE_DELETED_VIDEO_ERROR(110006, "VPS_RESPONSE_DELETED_VIDEO_ERROR"),
    VPS_REQUEST_NETWORK_UN_CONNECT_ERROR(120000, "VPS_REQUEST_NETWORK_UN_CONNECT_ERROR"),
    VPS_REPARSE_ERROR(130000, "VPS_REPARSE_ERROR");
    
    public int p;
    String q;
    String r;

    private a(int i, String str) {
        this.p = i;
        this.q = str;
    }

    public final String toString() {
        return "ErrorID is:" + this.p + ", ErrorMsg is:" + this.q + (this.r == null ? "" : this.r);
    }
}