package com.prinster.notes.note

class Note {

    private var title: String = ""
    private var content: String = ""
    private var id: String = ""

    constructor(title: String, content: String) {
        this.title = title
        this.content = content
        this.id = ""
    }

    constructor(title: String, content: String, id: String) {
        this.title = title
        this.content = content
        this.id = id
    }

    fun returnTitle(): String {
        return title
    }

    fun returnContent(): String {
        return content
    }

    fun returnID(): String {
        return id
    }
}