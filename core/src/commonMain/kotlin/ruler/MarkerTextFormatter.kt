/*
 * Copyright (c) 2024-2025, Alexey Illarionov and the compose-debuglayout project contributors.
 * Please see the AUTHORS file for details.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 * SPDX-License-Identifier: Apache-2.0
 */

package at.released.debuglayout.ruler

internal expect operator fun MarkerTextFormatter.Companion.invoke(): MarkerTextFormatter

internal fun interface MarkerTextFormatter {
    fun format(value: Float): String
    companion object
}
