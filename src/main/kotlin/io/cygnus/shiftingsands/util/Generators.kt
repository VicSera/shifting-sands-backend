package io.cygnus.shiftingsands.util

object Generators
{
    fun randomAlphaNumericId(length: Int): String {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        return List(length) { alphabet.random() }.joinToString("")
    }
}
