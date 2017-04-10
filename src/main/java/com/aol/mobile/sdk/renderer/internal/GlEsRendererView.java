/*
 * Copyright (c) 2016 One by Aol : Publishers. All rights reserved.
 */

package com.aol.mobile.sdk.renderer.internal;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.aol.mobile.sdk.renderer.gles.GLESModel;
import com.aol.mobile.sdk.renderer.gles.SceneRenderer;
import com.aol.mobile.sdk.renderer.gles.VideoSurfaceListener;

@MainThread
public final class GlEsRendererView extends GLSurfaceView {
    private final SceneRenderer renderer;

    public GlEsRendererView(@NonNull Context context) {
        this(context, null);
    }

    public GlEsRendererView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode()) {
            renderer = null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public GlEsRendererView(@NonNull Context context, @NonNull GLESModel model, @NonNull VideoSurfaceListener videoSurfaceListener) {
        super(context);

        setEGLContextClientVersion(2);

        setRenderer(renderer = new SceneRenderer(model, videoSurfaceListener));
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }

    public void dispose() {
        queueEvent(new Runnable() {
            @Override
            public void run() {
                renderer.dispose();
            }
        });
    }

    public void setCameraOrientation(final double longitude, final double latitude) {
        queueEvent(new Runnable() {
            @Override
            public void run() {
                renderer.setCameraOrientation(longitude, latitude);
            }
        });
    }
}
