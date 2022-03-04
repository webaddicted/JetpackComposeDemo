package com.webaddicted.jetpackcomposedemo

import android.util.Log

/**
 * Author : Deepak Sharma(webaddicted)
 * Email : techtamper@gmail.com
 * Profile : https://github.com/webaddicted
 */
class Testt (var name: String) {
    init {
        Log.d("TAG","Testt Student has got a name as $name")
    }
    constructor(sectionName: String, id: Int): this(sectionName){
    }
}



