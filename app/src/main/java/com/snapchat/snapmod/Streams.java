package com.snapchat.snapmod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams {

    public static void copy(InputStream src, File dst) {
        try (OutputStream out = new FileOutputStream(dst)) {
            copy(src, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[8192];
        int read;
        while ((read = in.read(buf, 0, 8192)) > -1) {
            out.write(buf, 0, read);
        }
    }
}
