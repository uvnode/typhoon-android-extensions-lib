package com.uvnode.typhoon.extensions.model

import java.util.*

open class Filter<T>(var name: String?, var state: T) {
    open class Text(name: String?, state: String) : Filter<String?>(name, state)
    class CheckBox(name: String?, state: Boolean) : Filter<Boolean?>(name, state)
    class TriState(name: String?, state: Int) : Filter<Int?>(name, state) {
        val isIgnored: Boolean
            get() = state == STATE_IGNORE
        val isIncluded: Boolean
            get() = state == STATE_INCLUDE
        val isExcluded: Boolean
            get() = state == STATE_EXCLUDE

        companion object {
            const val STATE_IGNORE = 0
            const val STATE_INCLUDE = 1
            const val STATE_EXCLUDE = 2
        }
    }

    class Group<U>(name: String?, state: ArrayList<U>) : Filter<ArrayList<U>?>(name, state)
    class Query(state: String) : Text("q", state)
}