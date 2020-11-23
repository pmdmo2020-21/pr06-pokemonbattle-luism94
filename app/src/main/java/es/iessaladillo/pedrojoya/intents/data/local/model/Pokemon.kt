package es.iessaladillo.pedrojoya.intents.data.local.model

class Pokemon(id: Long, name : String, cp: Int, image: Int,) {
    private var id = id
    private var name = name
    private var cp = cp
    private var image = image

    fun getID(): Long {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getStrength(): Int {
        return cp
    }

    fun getImage(): Int {
        return image
    }
}