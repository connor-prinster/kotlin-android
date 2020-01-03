package com.prinster.listapp

class Animal(private var image: Int, private var animalType: String, private var animalDesc: String, private var dangerous: Boolean) {

    fun getImage(): Int {
        return image
    }

    fun getAnimalType(): String {
        return animalType
    }

    fun getAnimalDesc(): String {
        return animalDesc
    }

    fun getDangerous(): Boolean {
        return dangerous
    }
}