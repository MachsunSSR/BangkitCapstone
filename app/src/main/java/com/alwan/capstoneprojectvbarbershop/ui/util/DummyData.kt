package com.alwan.capstoneprojectvbarbershop.ui.util

import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Barber
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Book
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Haircut
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Notification
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.PaymentMethod
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Promo
import com.alwan.capstoneprojectvbarbershop.ui.core.entity.Review

object DummyData {
    fun provideImage() = listOf(
        "https://image-barbers.co.uk/wp-content/uploads/2019/12/IMG_7719.jpg",
        "https://images.squarespace-cdn.com/content/v1/5332fcb9e4b00ce9525b384f/1470971655186-IKH5GIYRWTRFFR7M8XS7/DSC_1271.jpg?format=2500w",
        "https://images.pexels.com/photos/1813272/pexels-photo-1813272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
    )

    fun provideFacilities() = listOf(
        "Hair Coloring",
        "Hair Cut",
        "Hair Wash",
        "Shampoo",
        "Pomade",
        "Wi-fi",
        "AC",
        "Certified Barber"
    )

    fun provideReviews() = listOf(
        Review(
            name = "Alwan",
            date = "20 Apr, 2022",
            rating = 4.2f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Ohh ini keren banget",
        ),
        Review(
            name = "Fauzi",
            date = "21 May, 2022",
            rating = 4.8f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Bagus sekali hasilnya, saya request model dari tampilan filter aplikasi dan hasilnya pun sama, tidak mengecewakan",
        ),
        Review(
            name = "Machsun",
            date = "11 Jun, 2022",
            rating = 4.5f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Layanan sangat bagus, pegawai sangat ramah dan hasil memuaskan. Thank you Shinjuku!",
        ),
        Review(
            name = "Alwan",
            date = "20 Apr, 2022",
            rating = 4.2f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Ohh ini keren banget",
        ),
        Review(
            name = "Fauzi",
            date = "21 May, 2022",
            rating = 4.8f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Bagus sekali hasilnya, saya request model dari tampilan filter aplikasi dan hasilnya pun sama, tidak mengecewakan",
        ),
        Review(
            name = "Machsun",
            date = "11 Jun, 2022",
            rating = 4.5f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Layanan sangat bagus, pegawai sangat ramah dan hasil memuaskan. Thank you Shinjuku!",
        ),
        Review(
            name = "Alwan",
            date = "20 Apr, 2022",
            rating = 4.2f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Ohh ini keren banget",
        ),
        Review(
            name = "Fauzi",
            date = "21 May, 2022",
            rating = 4.8f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Bagus sekali hasilnya, saya request model dari tampilan filter aplikasi dan hasilnya pun sama, tidak mengecewakan",
        ),
        Review(
            name = "Machsun",
            date = "11 Jun, 2022",
            rating = 4.5f,
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
            review = "Layanan sangat bagus, pegawai sangat ramah dan hasil memuaskan. Thank you Shinjuku!",
        ),
    )

    fun providePromos() = listOf(
        Promo(
            name = "50% OFF Cuci Potong disetiap hari Senin di Moz Salon",
            imageUrl = "",
            bgColor = "#0088E0"
        ),
        Promo(
            name = "20% OFF Cuci dan Potong disetiap hari Senin ",
            imageUrl = "",
            bgColor = "#4F0DF0"
        ),
        Promo(
            name = "50% OFF Cuci Potong disetiap hari Senin di Moz Salon",
            imageUrl = "",
            bgColor = "#0088E0"
        ),
        Promo(
            name = "20% OFF Cuci dan Potong disetiap hari Senin ",
            imageUrl = "",
            bgColor = "#4F0DF0"
        ),
        Promo(
            name = "50% OFF Cuci Potong disetiap hari Senin di Moz Salon",
            imageUrl = "",
            bgColor = "#0088E0"
        ),

        )

    fun provideBarber() = listOf(
        Barber(
            name = "Shinjuku",
            imageUrl = "https://image-barbers.co.uk/wp-content/uploads/2019/12/IMG_7719.jpg",
            rating = 4.3f,
            distance = 12.9f,
        ),
        Barber(
            name = "Salon Ilham",
            imageUrl = "https://images.squarespace-cdn.com/content/v1/5332fcb9e4b00ce9525b384f/1470971655186-IKH5GIYRWTRFFR7M8XS7/DSC_1271.jpg?format=2500w",
            rating = 4.5f,
            distance = 22.2f,
        ),
        Barber(
            name = "Best barber ever",
            imageUrl = "https://images.pexels.com/photos/1813272/pexels-photo-1813272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            rating = 4.9f,
            distance = 1.9f,
        ),
    )

    fun provideBooks() = listOf(
        Book(
            barber = Barber(
                name = "Best barber ever",
                imageUrl = "https://images.pexels.com/photos/1813272/pexels-photo-1813272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                rating = 4.9f,
                distance = 1.9f,
            ),
            time = "13:00",
        ),
        Book(
            barber = Barber(
                name = "Salon Ilham",
                imageUrl = "https://images.squarespace-cdn.com/content/v1/5332fcb9e4b00ce9525b384f/1470971655186-IKH5GIYRWTRFFR7M8XS7/DSC_1271.jpg?format=2500w",
                rating = 4.5f,
                distance = 22.2f,
            ),
            time = "11:00",
        ),
        Book(
            barber = Barber(
                name = "Shinjuku",
                imageUrl = "https://image-barbers.co.uk/wp-content/uploads/2019/12/IMG_7719.jpg",
                rating = 4.3f,
                distance = 12.9f,
            ),
            time = "12:00",
        ),
    )

    fun provideNotifications() = listOf(
        Notification(
            name = "Payment Successful",
            type = 1,
            description = "Angga Salon payment through BCA Bank was successful",
        ),
        Notification(
            name = "Booking Canceled",
            type = 0,
            description = "You have canceled your Nara Salon booking",
        ),
        Notification(
            name = "E-wallet Connected",
            type = 2,
            description = "E-Wallet has been connected to Hair-IT",
        ),
    )

    fun provideHaircut() = listOf(
        Haircut(
            name = "Buzz Cut",
            desc = "Potongan seperti tentara, bikin cewe kesemsem dah soaln....",
            imageUrl = "https://haircutinspiration.com/wp-content/uploads/Pitch-Perfect-Buzz-Cut.jpg",
            totalRating = 655,
        ),
        Haircut(
            name = "Comma Hair",
            desc = "Potongan ala oppa oppa cocok untuk rambut lurus",
            imageUrl = "https://www.sneakers.co.id/wp-content/uploads/2021/11/potongan-comma-hair-2.png",
            totalRating = 563,
        ),
        Haircut(
            name = "Two Block",
            desc = "Potongan ala oppa oppa cocok untuk rambut ikal",
            imageUrl = "https://i.pinimg.com/736x/fa/d6/c8/fad6c866d337b86c17bb60c9f2b8fb94.jpg",
            totalRating = 483,
        ),
    )

    fun providePaymentMethods() = listOf(
        PaymentMethod(
            name = "ovo",
            imageUrl = "https://www.cloudera.com/content/dam/www/marketing/images/logos/customers/ovo-logo.png",
        ),
        PaymentMethod(
            name = "gopay",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Gopay_logo.svg/2560px-Gopay_logo.svg.png",
        ),
        PaymentMethod(
            name = "DANA",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Logo_dana_blue.svg/1200px-Logo_dana_blue.svg.png",
        ),
    )

    fun provideTimeSlots() = listOf(
        "08:00",
        "10:00",
        "12:00",
        "13:00",
        "15:00",
        "18:00",
        "20:00"
    )
}