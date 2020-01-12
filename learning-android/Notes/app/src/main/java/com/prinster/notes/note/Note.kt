package com.prinster.notes.note

class Note(private var title: String, private var content: String, private var id: Int) {

    fun returnTitle(): String {
        return title
    }

    fun returnContent(): String {
        return content
    }

    fun returnID(): Int {
        return id
    }
}