package com.belajar.suitmediatest.data.repository

import android.app.Application
import com.belajar.suitmediatest.data.dummy.ModelEvent

class EventRepository() {

    fun getDummyData(): ArrayList<ModelEvent>{
        return arrayListOf(
            ModelEvent("Firebase Summit", "2018-7-8", "https://miro.medium.com/max/1280/0*XYQp0ZwQbbO7g2Ov.jpg"),
            ModelEvent("Android Dev Summit", "2018-10-23", "https://i.ytimg.com/vi/GYvhRmx2bfI/maxresdefault.jpg"),
            ModelEvent("Google I/O", "2018-05-23", "https://gadget.jagatreview.com/wp-content/uploads/2020/03/google-io-1.jpg"),
            ModelEvent("Google Cloud Summit","2018-6-3", "https://miro.medium.com/max/8064/1*fXHNaOH7vUQEo__Ik1J6bg.jpeg"),
            ModelEvent("Cherry Blossom Festival", "2018-03-26", "https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/00/a0000995/img/basic/a0000995_main.jpg?20200911184019&q=80&rw=750&rh=536"),
            ModelEvent("Japan Summer Festival", "2018-08-21", "https://resources.matcha-jp.com/resize/720x2000/2016/10/07-3876.jpeg")
        )
    }
}