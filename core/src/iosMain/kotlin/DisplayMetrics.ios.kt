/*
 * Copyright (c) 2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import platform.UIKit.UIScreen

@Composable
internal actual fun Modifier.getDisplayMetrics(): DisplayMetrics {
    // XXX wrong, not tested
    val scale = UIScreen.mainScreen.scale.toFloat()

    @Suppress("MagicNumber")
    val dpi = scale * 163f

    return DisplayMetrics(
        density = scale,
        xdpi = dpi,
        ydpi = dpi,
    )
}
