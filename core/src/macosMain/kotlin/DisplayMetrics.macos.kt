/*
 * Copyright (c) 2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout

import platform.AppKit.NSScreen

@androidx.compose.runtime.Composable
internal actual fun androidx.compose.ui.Modifier.getDisplayMetrics(): DisplayMetrics {
    // XXX wrong, not tested
    val scale = NSScreen.mainScreen?.backingScaleFactor?.toFloat() ?: 1f

    @Suppress("MagicNumber")
    val dpi = scale * 163f

    return DisplayMetrics(
        density = scale,
        xdpi = dpi,
        ydpi = dpi,
    )
}
