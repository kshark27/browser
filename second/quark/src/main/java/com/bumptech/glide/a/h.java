package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class h implements Closeable {
    final Charset a;
    int b;
    private final InputStream c;
    private byte[] d;
    private int e;

    public h(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private h(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(i.a)) {
            this.c = inputStream;
            this.a = charset;
            this.d = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void close() throws IOException {
        synchronized (this.c) {
            if (this.d != null) {
                this.d = null;
                this.c.close();
            }
        }
    }

    public final String a() throws IOException {
        String str;
        synchronized (this.c) {
            if (this.d == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.e >= this.b) {
                b();
            }
            int i2 = this.e;
            while (i2 != this.b) {
                if (this.d[i2] == (byte) 10) {
                    int i3 = (i2 == this.e || this.d[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                    str = new String(this.d, this.e, i3 - this.e, this.a.name());
                    this.e = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream gVar = new g(this, (this.b - this.e) + 80);
            loop1:
            while (true) {
                gVar.write(this.d, this.e, this.b - this.e);
                this.b = -1;
                b();
                i = this.e;
                while (i != this.b) {
                    if (this.d[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.e) {
                gVar.write(this.d, this.e, i - this.e);
            }
            this.e = i + 1;
            str = gVar.toString();
        }
        return str;
    }

    private void b() throws IOException {
        int read = this.c.read(this.d, 0, this.d.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.e = 0;
        this.b = read;
    }
}
