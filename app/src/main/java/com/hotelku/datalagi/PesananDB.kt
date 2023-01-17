package com.hotelku.datalagi

data class PesananDB(
    val id_pemesanan: String,
    val waktu_checkin: String,
    val waktu_checkout: String,
    val id_kamar: String,
    val id_hotel: String,
    val id_user: String,
    val biaya: String,
    val no_hp: String,
    val bukti_pembayaran: String
){
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
}