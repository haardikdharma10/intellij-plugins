// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package tanvd.grazi.ide.fus

import com.intellij.internal.statistic.beans.MetricEvent
import com.intellij.internal.statistic.beans.addBoolIfDiffers
import com.intellij.internal.statistic.beans.addIfDiffers
import com.intellij.internal.statistic.beans.newMetric
import com.intellij.internal.statistic.eventLog.FeatureUsageData
import com.intellij.internal.statistic.service.fus.collectors.ApplicationUsagesCollector
import tanvd.grazi.GraziConfig

@Suppress("MissingRecentApi")
class GraziFUStateCollector : ApplicationUsagesCollector() {
  override fun getGroupId(): String = "grazi.state"
  override fun getVersion(): Int = 1

  override fun getMetrics(): Set<MetricEvent> {
    val metrics = HashSet<MetricEvent>()

    val state = GraziConfig.get()
    val default = GraziConfig.State()

    state.enabledLanguages.forEach { metrics.add(newMetric("enabled.language", it.shortCode)) }

    addIfDiffers(metrics, state, default, { s -> s.nativeLanguage.shortCode }, "native.language")
    addBoolIfDiffers(metrics, state, default, { s -> s.enabledSpellcheck }, "enabled.spellcheck")

    state.userEnabledRules.forEach { metrics.add(newMetric("rule", FeatureUsageData().addData("id", it).addData("enabled", true))) }

    state.userDisabledRules.forEach { metrics.add(newMetric("rule", FeatureUsageData().addData("id", it).addData("enabled", false))) }

    return metrics
  }
}
