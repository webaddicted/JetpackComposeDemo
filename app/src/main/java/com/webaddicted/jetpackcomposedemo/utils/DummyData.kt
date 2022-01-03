package com.webaddicted.jetpackcomposedemo.utils

import com.webaddicted.jetpackcomposedemo.data.CategoryBean

class DummyData {
    companion object {
        fun getData(): Array<CategoryBean> {
            return  arrayOf(
                CategoryBean(
                    "Abstract",
                    "https://img.freepik.com/free-vector/gradient-liquid-abstract-background_52683-60469.jpg?size=626&ext=jpg"
                ),
                CategoryBean("Nature", "https://wallpaperaccess.com/full/1180075.jpg"),
                CategoryBean(
                    "Architecture",
                    "https://static.dezeen.com/uploads/2021/05/oyo-architects-house-dede-belgium-residential-architecture_dezeen_sq3-411x411.jpg"
                ),
                CategoryBean(
                    "Animals",
                    "https://www.ucsf.edu/sites/default/files/2020-12/astonishing-animals-komodo-dragon-featured.jpg"
                ),
                CategoryBean(
                    "Portraits", "https://jooinn.com/images/portrait-119.jpg"
                ),
                CategoryBean(
                    "Sea", "https://i.ytimg.com/vi/QX4j_zHAlw8/maxresdefault.jpg"
                ),
                CategoryBean(
                    "Night",
                    "https://texasmotorplex.com/wp-content/uploads/2018/01/NightlightsRotator.jpg"
                ),
                CategoryBean(
                    "Cars",
                    "https://stimg.cardekho.com/images/carexteriorimages/360x240/Ferrari/Ferrari-488-GTB/047.jpg"
                ),
                CategoryBean("Street Art", "https://wallpaperaccess.com/full/210623.jpg"),
                CategoryBean(
                    "Dark",
                    "https://cdn.statically.io/img/www.wallpaperwolf.com/wallpapers/4k-wallpapers/4k/download/dark-forest-0131-4k.png"
                ),
                CategoryBean("Random", "https://cdn.wallpapersafari.com/17/16/1lefPD.jpg")
            )
        }
    }
}