package com.fatkus.quis.model

import com.fatkus.quis.R

object ProductData {
    private val productName = arrayOf("C","C++","C#","Java","JavaScript","Nodejs","Kotlin","PHP","Python","GoLang")
    private val detail = arrayOf(
        "C ini termasuk bahasa pemrograman tertua yang pernah ada",
        "C++ merupakan bahasa pemrograman pengembangan dari bahasa C++",
        "C# adalah bahasa pemrograman yang dikembangkan oleh Microsoft",
        "Java merupakan bahasa pemrograman yang dapat dijalankan di berbagai platform, dari mulai PC sampai perangkat mobile.",
        "JavaScript adalah bahasa pemrograma yang dikembangkan oleh Netscape",
        "Node.js adalah platform perangkat lunak pada sisi-server dan aplikasi jaringan",
        "Kotlin adalah sebuah bahasa pemrograman dengan pengetikan statis yang berjalan pada Mesin Virtual Java ataupun menggunakan kompiler LLVM ",
        "PHP (PHP Hypertext Pre-processor) merupakan bahasa pemrograman yang paling banyak digunakan di Indonesia",
        "Python menjadi salah satu bahasa pemrograman yang dapat membangun aplikasi, baik itu berbasis web ataupun berbasis mobile",
        "Go adalah bahasa pemrograman yang dibuat di Google pada tahun 2009 oleh Robert Griesemer, Rob Pike, dan Ken Thompson"
    )
    private val productImage = intArrayOf(
        R.drawable.c,
        R.drawable.cplus,
        R.drawable.csharp,
        R.drawable.java,
        R.drawable.js,
        R.drawable.nodejs,
        R.drawable.kotlin,
        R.drawable.php,
        R.drawable.python,
        R.drawable.golang
    )

    val listProduct: ArrayList<Product>
    get() {
        val list = arrayListOf<Product>()
        for (position in productName.indices){
            val product = Product()
            product.name = productName[position]
            product.detail = detail[position]
            product.photo = productImage[position]
            list.add(product)
        }
        return list
    }
}