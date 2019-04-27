package com.coder.vocab.model

data class BaseResult(
    var results: List<WordInfo>
)

data class WordInfo(
    val word: String,
    val lexicalEntries: List<LexicalEntry>,
    val pronunciations: List<Pronunciation>
)

data class Pronunciation(
    val audioFile: String,
    val phoneticNotation: String,
    val phoneticSpelling: String
)

data class LexicalEntry(
    val lexicalCategory: LexicalCategory,
    val entries: List<Entries>
)

data class LexicalCategory(
    val text: String
)

data class Entries(
    val senses: List<Senses>
)

data class Senses(
    val definitions: ArrayList<String>,
    val examples: List<Examples>
)

data class Examples(
    val text: String
)