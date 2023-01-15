package com.hotelku.datalagi

class IsiHotel {
    companion object {
        fun buatSetData(): ArrayList<DataHotel> {
            val list = ArrayList<DataHotel>()

            list.add(
                DataHotel(
                    "1",
                    "Grand Central Hotel Pekanbaru",
                    "Jalan Jendral Sudirman No 1 Pekanbaru 28, Pusat Kota Pekanbaru, Pekanbaru, Riau, Indonesia, 28292",
                    "0813-7271-0889",
                    "10",
                    "R.drawable.kab_kep_meranti",
                    "Bintang 5"
                )
            )
            list.add(
                DataHotel(
                    "2",
                    "Hotel Pengeran Pekanbaru",
                    "Jalan Jend Sudirman No. 371-373, Pusat Kota Pekanbaru, Pekanbaru, Riau, Indonesia, 28131",
                    "+62 761-853-636",
                    "9",
                    "https://www.kayak.co.id/rimg/himg/c0/e3/fe/hotelsdotcom-458881-03e37077_w-786483.jpg?width=1366&height=768&xhint=1000&yhint=667&crop=true",
                    "Bintang 5"
                )
            )
            return list
        }
    }
}