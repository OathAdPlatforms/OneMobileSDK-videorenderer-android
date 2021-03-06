/*
 * Copyright 2018, Oath Inc.
 * Licensed under the terms of the MIT License. See LICENSE.md file in project root for terms.
 */

package com.aol.mobile.sdk.renderer.gles;

import android.support.annotation.NonNull;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public interface GLESModel {
    @NonNull
    FloatBuffer getVBO();

    @NonNull
    ShortBuffer getIBO();

    int getVBOSize();

    int getIBOSize();

    int getIndicesCount();

    int getVertexStride();

    int getTextureCoordinatesOffset();
}
