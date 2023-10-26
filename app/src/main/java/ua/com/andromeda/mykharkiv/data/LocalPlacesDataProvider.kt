package ua.com.andromeda.mykharkiv.data

import ua.com.andromeda.mykharkiv.R
import ua.com.andromeda.mykharkiv.data.model.Place

object LocalPlacesDataProvider {
    val defaultPlace = Place(-1, -1, -1, -1, -1, -1)

    val allPlaces = listOf(
        Place(
            1,
            R.string.coffee_shop_1_name,
            R.drawable.coffee_shop_1,
            R.string.coffee_shop_1_address,
            R.string.coffee_shop_1_details,
            1
        ),
        Place(
            2,
            R.string.coffee_shop_2_name,
            R.drawable.coffee_shop_2,
            R.string.coffee_shop_2_address,
            R.string.coffee_shop_2_details,
            1
        ),
        Place(
            3,
            R.string.coffee_shop_3_name,
            R.drawable.coffee_shop_3,
            R.string.coffee_shop_3_address,
            R.string.coffee_shop_3_details,
            1
        ),
        Place(
            4,
            R.string.coffee_shop_4_name,
            R.drawable.coffee_shop_4,
            R.string.coffee_shop_4_address,
            R.string.coffee_shop_4_details,
            1
        ),
        Place(
            5,
            R.string.coffee_shop_5_name,
            R.drawable.coffee_shop_5,
            R.string.coffee_shop_5_address,
            R.string.coffee_shop_5_details,
            1
        ),
        Place(
            6,
            R.string.restaurant_1_name,
            R.drawable.restaurant_1,
            R.string.restaurant_1_address,
            R.string.restaurant_1_details,
            2
        ),
        Place(
            7,
            R.string.restaurant_2_name,
            R.drawable.restaurant_2,
            R.string.restaurant_2_address,
            R.string.restaurant_2_details,
            2
        ),
        Place(
            8,
            R.string.restaurant_3_name,
            R.drawable.restaurant_3,
            R.string.restaurant_3_address,
            R.string.restaurant_3_details,
            2
        ),
        Place(
            9,
            R.string.restaurant_4_name,
            R.drawable.restaurant_4,
            R.string.restaurant_4_address,
            R.string.restaurant_4_details,
            2
        ),
        Place(
            10,
            R.string.restaurant_5_name,
            R.drawable.restaurant_5,
            R.string.restaurant_5_address,
            R.string.restaurant_5_details,
            2
        ),
        Place(
            11,
            R.string.park_1_name,
            R.drawable.park_1,
            R.string.park_1_address,
            R.string.park_1_details,
            3
        ),
        Place(
            12,
            R.string.park_2_name,
            R.drawable.park_2,
            R.string.park_2_address,
            R.string.park_2_details,
            3
        ),
        Place(
            13,
            R.string.park_3_name,
            R.drawable.park_3,
            R.string.park_3_address,
            R.string.park_3_details,
            3
        ),
        Place(
            14,
            R.string.park_4_name,
            R.drawable.park_4,
            R.string.park_4_address,
            R.string.park_4_details,
            3
        ),
        Place(
            15,
            R.string.park_5_name,
            R.drawable.park_5,
            R.string.park_5_address,
            R.string.park_5_details,
            3
        ),
        Place(
            16,
            R.string.shopping_centre_1_name,
            R.drawable.shopping_centre_1,
            R.string.shopping_centre_1_address,
            R.string.shopping_centre_1_details,
            4
        ),
        Place(
            17,
            R.string.shopping_centre_2_name,
            R.drawable.shopping_centre_2,
            R.string.shopping_centre_2_address,
            R.string.shopping_centre_2_details,
            4
        ),
        Place(
            18,
            R.string.shopping_centre_3_name,
            R.drawable.shopping_centre_3,
            R.string.shopping_centre_3_address,
            R.string.shopping_centre_3_details,
            4
        ),
        Place(
            19,
            R.string.shopping_centre_4_name,
            R.drawable.shopping_centre_4,
            R.string.shopping_centre_4_address,
            R.string.shopping_centre_4_details,
            4
        ),
        Place(
            20,
            R.string.shopping_centre_5_name,
            R.drawable.shopping_centre_5,
            R.string.shopping_centre_5_address,
            R.string.shopping_centre_5_details,
            4
        )
    )

    fun findAllByCategoryId(categoryId: Long) = allPlaces.filter { it.categoryId == categoryId }

}