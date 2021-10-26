package com.snapchat.snapmod;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import io.reactivex.rxjava3.core.Observable;
import xyz.rodit.dexsearch.DexBase;
import xyz.rodit.dexsearch.Logger;
import xyz.rodit.dexsearch.schema2.resolver.Resolver;

public class BindingsManager {

    public static Observable<Resolver> resolveBindings(Context context, String packageName, String schema, File outputDir, PrintStream output, PrintStream error) {
        return Observable.create(emitter -> {
            File schemaFile = File.createTempFile("schema", "txt");
            schemaFile.deleteOnExit();
            try (InputStream schemaStream = context.getAssets().open(schema)) {
                Streams.copy(schemaStream, schemaFile);
            }

            PackageManager pm = context.getPackageManager();
            String apkFile;
            int buildCode;
            try {
                ApplicationInfo info = pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
                PackageInfo pinfo = pm.getPackageInfo(packageName, PackageManager.GET_META_DATA);
                apkFile = info.sourceDir;
                buildCode = pinfo.versionCode;
            } catch (PackageManager.NameNotFoundException ex) {
                Log.e("BindingsManager", "Package not found.", ex);
                emitter.onError(ex);
                return;
            }

            ZipFile apk = new ZipFile(apkFile);
            List<File> dexFiles = new ArrayList<>();
            Enumeration<? extends ZipEntry> entries = apk.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".dex")) {
                    Logger.info("Found dex file %s.", entry.getName());
                    File tmp = File.createTempFile("tmp", "dex");
                    tmp.deleteOnExit();
                    Streams.copy(apk.getInputStream(entry), tmp);
                    dexFiles.add(tmp);
                }
            }
            apk.close();

            DexBase base = new DexBase();
            for (File file : dexFiles) {
                int loaded = base.loadClasses(file);
                Log.i("BindingsManager", String.format("Loaded %d classes from %s.", loaded, file.getName()));
            }

            PrintStream oldOut = System.out;
            PrintStream oldErr = System.err;
            System.setOut(output);
            System.setErr(error);

            try {
                Resolver resolver = Resolver.create(base, schemaFile);
                resolver.resolveAll();
                resolver.generateBindings(outputDir, packageName, buildCode, false);
                emitter.onNext(resolver);
            } catch (Exception e) {
                Log.e("BindingsManager", "Error while generating bindings.", e);
            }

            System.setOut(oldOut);
            System.setErr(oldErr);
            emitter.onComplete();
        });
    }
}
