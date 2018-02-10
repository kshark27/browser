package com.uc.webview.export.internal.uc;

import android.content.Context;
import android.util.AttributeSet;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.ARManager;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.ICookieManager;
import com.uc.webview.export.internal.interfaces.IGeolocationPermissions;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IMimeTypeMap;
import com.uc.webview.export.internal.interfaces.IServiceWorkerController;
import com.uc.webview.export.internal.interfaces.IWebStorage;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.ReflectionUtil.BindingMethod;
import java.util.HashMap;

/* compiled from: ProGuard */
public class CoreFactory {
    @Reflection
    public static LazyClass Lazy = (((Boolean) UCMPackageInfo.invoke(10011, new Object[0])).booleanValue() ? new LazyClass() : null);
    @Reflection
    public static Runnable sLazyUpdateCallback;

    /* compiled from: ProGuard */
    public class LazyClass {
        final BindingMethod<IGlobalSettings> a = new BindingMethod(this.sCoreFactoryImpl, "getGlobalSettings");
        final BindingMethod<ICookieManager> b = new BindingMethod(this.sCoreFactoryImpl, "getCookieManager");
        final BindingMethod<IServiceWorkerController> c = new BindingMethod(this.sCoreFactoryImpl, "getServiceWorkerController");
        final BindingMethod<UCMobileWebKit> d = new BindingMethod(this.sCoreFactoryImpl, "getUCMobileWebKit");
        final BindingMethod<IGeolocationPermissions> e = new BindingMethod(this.sCoreFactoryImpl, "getGeolocationPermissions");
        final BindingMethod<IWebStorage> f = new BindingMethod(this.sCoreFactoryImpl, "getWebStorage");
        final BindingMethod<IMimeTypeMap> g = new BindingMethod(this.sCoreFactoryImpl, "getMimeTypeMap");
        final BindingMethod<IWebView> h = new BindingMethod(this.sCoreFactoryImpl, "createWebView", new Class[]{Context.class});
        final BindingMethod<IWebView> i;
        final BindingMethod<UCMobileWebKit> j;
        final BindingMethod<Boolean> k;
        final BindingMethod<Boolean> l;
        final BindingMethod<Boolean> m;
        final BindingMethod<Boolean> n;
        final BindingMethod<Integer> o;
        final BindingMethod<Object> p;
        final BindingMethod<Object> q;
        final BindingMethod<WebResourceResponse> r;
        final BindingMethod<ARManager> s;
        @Reflection
        public final Class<?> sCoreFactoryImpl = a();

        private static Class<?> a() {
            try {
                return Class.forName(UCMPackageInfo.CORE_FACTORY_IMPL_CLASS, true, SDKFactory.c);
            } catch (Throwable e) {
                throw new UCSetupException(4007, e);
            }
        }

        public LazyClass() {
            BindingMethod bindingMethod;
            BindingMethod bindingMethod2 = null;
            try {
                bindingMethod = new BindingMethod(this.sCoreFactoryImpl, "createWebView", new Class[]{Context.class, AttributeSet.class});
            } catch (Throwable th) {
                bindingMethod = null;
            }
            this.i = bindingMethod;
            this.j = new BindingMethod(this.sCoreFactoryImpl, "initUCMobileWebKit", new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE});
            this.o = new BindingMethod(this.sCoreFactoryImpl, "getCoreType");
            this.p = new BindingMethod(this.sCoreFactoryImpl, "initSDK", new Class[]{Context.class});
            this.q = new BindingMethod(this.sCoreFactoryImpl, "handlePerformanceTests", new Class[]{String.class});
            this.r = new BindingMethod(this.sCoreFactoryImpl, "getResponseByUrl", new Class[]{String.class});
            try {
                bindingMethod = new BindingMethod(this.sCoreFactoryImpl, "getARManager");
            } catch (Throwable th2) {
                bindingMethod = null;
            }
            this.s = bindingMethod;
            try {
                bindingMethod = new BindingMethod(this.sCoreFactoryImpl, "initUCMobileWebkitCoreSo", new Class[]{Context.class, String.class, String.class, String.class});
            } catch (Throwable th3) {
                bindingMethod = null;
            }
            this.l = bindingMethod;
            try {
                bindingMethod = new BindingMethod(this.sCoreFactoryImpl, "initUCMobileWebkitCoreSo", new Class[]{Context.class, String.class});
            } catch (Throwable th4) {
                bindingMethod = null;
            }
            this.k = bindingMethod;
            try {
                bindingMethod = new BindingMethod(this.sCoreFactoryImpl, "initUCMobileWebkitCoreSoEx", new Class[]{Context.class, String.class, String.class, String.class, String.class});
            } catch (Throwable th5) {
                bindingMethod = null;
            }
            this.m = bindingMethod;
            try {
                bindingMethod2 = new BindingMethod(this.sCoreFactoryImpl, "initUCMobileWebkitCoreSoEnv", new Class[]{Context.class, HashMap.class});
            } catch (Throwable th6) {
            }
            this.n = bindingMethod2;
        }
    }

    @Reflection
    public static void updateLazy() {
        Lazy = new LazyClass();
        if (sLazyUpdateCallback != null) {
            sLazyUpdateCallback.run();
        }
    }

    public static IGlobalSettings l() {
        return (IGlobalSettings) Lazy.a.getInstance();
    }

    @Reflection
    public static ICookieManager getCookieManager() {
        return (ICookieManager) Lazy.b.getInstance();
    }

    @Reflection
    public static IServiceWorkerController getServiceWorkerController() {
        return (IServiceWorkerController) Lazy.c.getInstance();
    }

    @Reflection
    public static UCMobileWebKit getUCMobileWebKit() {
        return (UCMobileWebKit) Lazy.d.getInstance();
    }

    public static IGeolocationPermissions m() {
        return (IGeolocationPermissions) Lazy.e.getInstance();
    }

    public static IWebStorage n() {
        return (IWebStorage) Lazy.f.getInstance();
    }

    public static IMimeTypeMap o() {
        return (IMimeTypeMap) Lazy.g.getInstance();
    }

    @Reflection
    public static IWebView createWebView(Context context, AttributeSet attributeSet) {
        if (Lazy.i == null) {
            return (IWebView) Lazy.h.invoke(new Object[]{context});
        }
        return (IWebView) Lazy.i.invoke(new Object[]{context, attributeSet});
    }

    public static boolean p() {
        return Lazy.i != null;
    }

    @Reflection
    public static UCMobileWebKit initUCMobileWebKit(Context context, boolean z, boolean z2) {
        return (UCMobileWebKit) Lazy.j.invoke(new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    @Reflection
    public static boolean initUCMobileWebkitCoreSo(Context context, String str, String str2, String str3) throws RuntimeException {
        if (Lazy.l != null) {
            return ((Boolean) Lazy.l.invoke(new Object[]{context, str, str2, str3})).booleanValue();
        }
        return ((Boolean) Lazy.k.invoke(new Object[]{context, str3})).booleanValue();
    }

    @Reflection
    public static boolean initUCMobileWebkitCoreSoEx(Context context, String str, String str2, String str3, String str4) throws RuntimeException {
        if (Lazy.m == null) {
            return initUCMobileWebkitCoreSo(context, str, str2, str3);
        }
        return ((Boolean) Lazy.m.invoke(new Object[]{context, str, str2, str3, str4})).booleanValue();
    }

    @Reflection
    public static boolean initUCMobileWebkitCoreSoEnv(Context context, HashMap<String, String> hashMap) throws RuntimeException {
        if (Lazy.n == null) {
            return initUCMobileWebkitCoreSoEx(context, (String) hashMap.get("ucm_dex_path"), (String) hashMap.get("ucm_odex_path"), (String) hashMap.get("ucm_corelib_path"), (String) hashMap.get("ucm_private_data_dir_suffix"));
        }
        return ((Boolean) Lazy.n.invoke(new Object[]{context, hashMap})).booleanValue();
    }

    @Reflection
    public static Integer getCoreType() {
        return (Integer) Lazy.o.invoke();
    }

    public static void a(Context context) {
        Lazy.p.invoke(new Object[]{context});
    }

    public static void a(String str) {
        Lazy.q.invoke(new Object[]{str});
    }

    public static WebResourceResponse b(String str) {
        return (WebResourceResponse) Lazy.r.invoke(new Object[]{str});
    }

    public static ARManager q() {
        return (ARManager) Lazy.s.invoke();
    }
}
