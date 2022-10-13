package com.example.bofanotes

import java.util.*

data class Note(val uuid: UUID, val ts :Long, val msg :String) {
    var id = uuid;
    var timestamp = ts;
    var message = msg
}