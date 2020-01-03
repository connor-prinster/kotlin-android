package com.prinster.listapp

class Animal(private var image: Int, private var animalType: String, private var animalDesc: String) {
    fun getImage(): Int {
        return image
    }

    fun getAnimalType(): String {
        return animalType
    }

    fun getAnimalDesc(): String {
        return animalDesc
    }
}