/*
 * Copyright (c) 2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout

import androidx.compose.ui.text.PlatformParagraphStyle
import androidx.compose.ui.text.PlatformSpanStyle
import androidx.compose.ui.text.PlatformTextStyle

internal actual fun getDefaultPlatformTextStyle(): PlatformTextStyle = PlatformTextStyle(
    spanStyle = PlatformSpanStyle.Default,
    paragraphStyle = PlatformParagraphStyle.Default
)
