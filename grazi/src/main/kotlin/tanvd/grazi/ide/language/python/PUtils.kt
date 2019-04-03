package tanvd.grazi.ide.language.python

import tanvd.grazi.grammar.SanitizingGrammarChecker
import tanvd.grazi.utils.*

object PUtils {
    val python = SanitizingGrammarChecker(listOf({ str, cur ->
        str.lastOrNull()?.let { blankCharRegex.matches(it) }.orTrue() && blankCharRegex.matches(cur)
    }, { prev, cur -> (cur == '\'' || cur == '\"') && (prev.isEmpty() || prev.last() == cur) }), listOf({ _, cur ->
        newLineCharRegex.matches(cur).ifTrue { ' ' }
    }))
}