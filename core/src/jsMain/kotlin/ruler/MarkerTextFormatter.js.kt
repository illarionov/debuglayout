/*
 * Copyright (c) 2024-2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout.ruler

internal actual operator fun MarkerTextFormatter.Companion.invoke(): MarkerTextFormatter = JsTextFormatter()

private class JsTextFormatter : MarkerTextFormatter {
    val formatter = createIntFormatter()
    override fun format(value: Float): String = formatter.format(value + 0f)
}

private external interface IntlNumberFormat {
    fun format(number: Number): String
}

private fun createIntFormatter(): IntlNumberFormat = js(
    """
        Intl.NumberFormat('en-US', {
            maximumFractionDigits: 1,
            trailingZeroDisplay: 'stripIfInteger'
        })
        """,
).unsafeCast<IntlNumberFormat>()
