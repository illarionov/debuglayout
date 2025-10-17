/*
 * Copyright (c) 2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout.ruler

import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter

internal actual operator fun MarkerTextFormatter.Companion.invoke(): MarkerTextFormatter {
    return AppleMarkerTextFormatter()
}

private class AppleMarkerTextFormatter(
    private val formatter: NSNumberFormatter = NSNumberFormatter().apply {
        maximumFractionDigits = 1UL
    }
) : MarkerTextFormatter {
    override fun format(value: Float): String {
        return formatter.stringFromNumber(NSNumber(value)) ?: error("Can not format `$value`")
    }
}
