package com.example.restoranapp.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("ElevenEateryPrefs", Context.MODE_PRIVATE)

    fun saveRestaurantInfo(name: String, address: String, description: String, openingHours: String, profileImageUri: String? = null) {
        sharedPreferences.edit().apply {
            putString("res_name", name)
            putString("res_address", address)
            putString("res_desc", description)
            putString("res_hours", openingHours)
            profileImageUri?.let { putString("res_logo_uri", it) }
            apply()
        }
    }

    fun getRestaurantName(): String = sharedPreferences.getString("res_name", "Eleven Eatery") ?: "Eleven Eatery"
    fun getRestaurantAddress(): String = sharedPreferences.getString("res_address", "Jl. Soekarno Hatta No. 9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141") ?: "Jl. Soekarno Hatta No. 9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141"
    fun getRestaurantDescription(): String = sharedPreferences.getString("res_desc", "Menghadirkan pengalaman makan yang nyaman dengan perpaduan rasa modern, suasana hangat, dan pelayanan terbaik untuk setiap pelanggan.") ?: "Menghadirkan pengalaman makan yang nyaman dengan perpaduan rasa modern, suasana hangat, dan pelayanan terbaik untuk setiap pelanggan."
    fun getRestaurantHours(): String = sharedPreferences.getString("res_hours", "08:00 - 22:00") ?: "08:00 - 22:00"
    fun getProfileImageUri(): String? = sharedPreferences.getString("res_logo_uri", null)

    fun setDarkMode(isDark: Boolean) {
        sharedPreferences.edit().putBoolean("dark_mode", isDark).apply()
    }

    fun isDarkMode(): Boolean = sharedPreferences.getBoolean("dark_mode", false)
}
