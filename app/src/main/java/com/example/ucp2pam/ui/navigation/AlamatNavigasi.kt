package com.example.ucp2pam.ui.navigation

interface AlamatNavigasi{
    val route: String
}

object DestinasiHome : AlamatNavigasi{
    override val route ="home"
}

object DestinasiDetail : AlamatNavigasi{
    override val route ="detail"
    const val ID = "id"

}