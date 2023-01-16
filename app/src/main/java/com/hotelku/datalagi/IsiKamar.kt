package com.hotelku.datalagi

class IsiKamar {
    companion object{
        fun setDataKamar() : ArrayList<DataKamar>{
            val listKamar = ArrayList<DataKamar>()
            listKamar.add(
                DataKamar(
                    "kamar01",
                    "Superior Twin",
                    "2 Ranjang Twin",
                    "AC, WIFI, Sarapan Gratis, minibar, Televisi, Pembuat Teh/Kopi",
                    "https://ik.imagekit.io/tvlk/generic-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10003885-1296x864-FIT_AND_TRIM-574e0b9643eed1706fd6e04d7bd1f783.jpeg?_src=imagekit&tr=c-at_max,h-360,q-40,w-550",
                    "-Rp 750.000 / malam"
                )
            )
            listKamar.add(
                DataKamar(
                    "kamar02",
                    "Superior Double Bed",
                    "1 King Bed",
                    "AC, WIFI, Sarapan Gratis, minibar, Televisi, Pembuat Teh/Kopi",
                    "https://ik.imagekit.io/tvlk/generic-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10003885-79a1d98e544847420eb4fe8bdd6a8749.jpeg?_src=imagekit&tr=c-at_max,h-360,q-40,w-550",
                    "-Rp 750.000 / malam"
                )
            )
            listKamar.add(
                DataKamar(
                    "kamar03",
                    "Deluxe Double Bed",
                    "1 King Bed",
                    "AC, WIFI, Sarapan Gratis, minibar, Televisi, Pembuat Teh/Kopi",
                    "https://ik.imagekit.io/tvlk/generic-asset/dgXfoyh24ryQLRcGq00cIdKHRmotrWLNlvG-TxlcLxGkiDwaUSggleJNPRgIHCX6/hotel/asset/10003885-79a1d98e544847420eb4fe8bdd6a8749.jpeg?_src=imagekit&tr=c-at_max,h-360,q-40,w-550",
                    "Rp 935.000 / malam"
                )
            )
            return listKamar
        }
    }
}