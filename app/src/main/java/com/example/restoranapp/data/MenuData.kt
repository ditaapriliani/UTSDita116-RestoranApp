package com.example.restoranapp.data

data class MenuItem(
    val id: Int,
    val name: String,
    val price: String,
    val rating: Float,
    val description: String,
    val imageUrl: String,
    var isFavorite: Boolean = false
)

object MenuData {
    // Banner Suasana Restoran
    const val RESTAURANT_BANNER = "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?auto=format&fit=crop&q=80&w=1000"
    const val RESTAURANT_LOGO = "https://images.unsplash.com/photo-1514362545857-3bc16c4c7d1b?auto=format&fit=crop&q=80&w=200"
    const val RESTAURANT_INTERIOR = "https://images.unsplash.com/photo-1552566626-52f8b828add9?auto=format&fit=crop&q=80&w=1000"

    val menuList = listOf(
        MenuItem(
            id = 1,
            name = "Salmon Mentai Bowl",
            price = "Rp 55.000",
            rating = 4.9f,
            description = "Nasi hangat dengan topping grilled salmon premium, saus mentai yang creamy dan gurih, serta taburan nori dan tobiko segar.",
            imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&q=80&w=800"
        ),
        MenuItem(
            id = 2,
            name = "Beef Teriyaki Garlic",
            price = "Rp 65.000",
            rating = 4.8f,
            description = "Irisan daging sapi pilihan yang dimasak dengan saus teriyaki autentik dan bawang putih goreng yang harum, disajikan dengan nasi pulen.",
            imageUrl = "https://images.unsplash.com/photo-1529006557810-274b9b2fc783?auto=format&fit=crop&q=80&w=800"
        ),
        MenuItem(
            id = 3,
            name = "Matcha Latte Oat",
            price = "Rp 32.000",
            rating = 4.7f,
            description = "Bubuk matcha premium asal Kyoto yang dipadukan dengan creamy-nya susu oat, memberikan rasa earthy yang menenangkan.",
            imageUrl = "https://images.unsplash.com/photo-1515823064-d6e0c04616a7?auto=format&fit=crop&q=80&w=800"
        ),
        MenuItem(
            id = 4,
            name = "Croissant Sandwich",
            price = "Rp 38.000",
            rating = 4.6f,
            description = "Croissant mentega yang renyah dengan isian smoked beef premium, keju cheddar, dan sayuran segar pilihan.",
            imageUrl = "https://images.unsplash.com/photo-1555507036-ab1f4038808a?auto=format&fit=crop&q=80&w=800"
        ),
        MenuItem(
            id = 5,
            name = "Korean Spicy Wings",
            price = "Rp 42.000",
            rating = 4.9f,
            description = "Sayap ayam goreng renyah yang dibalut dengan saus gochujang pedas manis khas Korea, ditaburi dengan biji wijen.",
            imageUrl = "https://images.unsplash.com/photo-1567620832903-9fc6debc209f?auto=format&fit=crop&q=80&w=800"
        ),
        MenuItem(
            id = 6,
            name = "Iced Salted Caramel",
            price = "Rp 35.000",
            rating = 4.8f,
            description = "Kopi cold brew dengan campuran sirup salted caramel buatan rumah dan cold foam yang lembut di atasnya.",
            imageUrl = "https://images.unsplash.com/photo-1512568400610-62da28bc8a13?auto=format&fit=crop&q=80&w=800"
        )
    )
}
