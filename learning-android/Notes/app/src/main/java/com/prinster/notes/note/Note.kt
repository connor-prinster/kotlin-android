package com.prinster.notes.note

class Note(val title: String, val content: String) {
    fun returnTitle(): String {
        return title
    }

    fun returnContent(): String {
        return content
    }
}