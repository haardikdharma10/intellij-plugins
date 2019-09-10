// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package tanvd.grazi.ide.fus

import com.intellij.internal.statistic.eventLog.validator.ValidationResultType
import com.intellij.internal.statistic.eventLog.validator.rules.EventContext
import com.intellij.internal.statistic.eventLog.validator.rules.impl.CustomWhiteListRule
import tanvd.grazi.language.LangTool

@Suppress("MissingRecentApi")
class GraziWhiteListRule : CustomWhiteListRule() {
  override fun doValidate(data: String,
                          context: EventContext) = if (data in LangTool.allRules) ValidationResultType.ACCEPTED else ValidationResultType.REJECTED

  override fun acceptRuleId(ruleId: String?) = ruleId == "grazi_rule_id"
}
