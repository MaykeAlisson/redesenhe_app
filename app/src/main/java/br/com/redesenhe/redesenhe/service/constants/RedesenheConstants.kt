package br.com.redesenhe.redesenhe.service.constants

/**
 * Constantes usadas na aplicação
 */
class RedesenheConstants private constructor() {

    // SharedPreferences
    object APP {
        const val NAME = "Redesenhe"
        const val VERSION = "1.0.0"
    }

    // SharedPreferences
    object SHARED {
        const val TOKEN = "token"
        const val USER_ID = "userid"
        const val USER_NAME = "username"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object BUNDLE {
        const val OBJETIVOID = "id"
        const val LANCAMENTOID = "id"
    }
}