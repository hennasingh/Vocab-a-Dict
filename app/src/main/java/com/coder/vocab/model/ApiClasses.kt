package com.coder.vocab.model

data class BaseResult(var results: List<WordInfo>)

data class WordInfo(
    val word: String,
    val lexicalEntries: List<LexicalEntry>
)