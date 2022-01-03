package com.webaddicted.newhiltproject.utils.constant

object AppConstant {

    //    val SUB_DEALER_PICKLIST:
    const val SPLASH_DELAY: Long = 3000

    //menu options
    enum class MenuItem(val value: String) {
        HOME("Home"),
        NEW_OUTLET("New Outlet"),
        VISIT("Visit"),
        PRICE_VISIBILITY("Price List"),
        E_CATALOGUE("E-Catalogue"),
    }

    const val BACK_STACK_ROOT_TAG = "root_fragment"
    const val DISPLAY_DATE_FORMAT = "dd-MMM-yyyy"
    const val SERVER_DATE_FORMAT = "yyyy-MM-dd"
    const val TIME_AM_PM_FORMAT = "hh:mm aaa"
    const val TIME_FORMAT = "hh:mm"
    const val DATE_TIME_FORMAT = "dd-MMM-yyyy hh:mm"
    const val IMG_FILE_NAME_FORMAT = "yyyyMMdd_HHmmss"
    const val IMG_FILE_EXT = "jpeg"
    const val IMGS_DIR = "app_imgs_dir"


}
