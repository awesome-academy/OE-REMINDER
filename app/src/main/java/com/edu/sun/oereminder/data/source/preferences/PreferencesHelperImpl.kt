package com.edu.sun.oereminder.data.source.preferences

import android.content.Context
import android.content.SharedPreferences
import com.edu.sun.oereminder.utils.PrefsConst.ENCRYPTED_PREFS_NAME
import com.edu.sun.oereminder.utils.PrefsConst.KEY_API_TOKEN
import com.edu.sun.oereminder.utils.PrefsConst.KEY_ROOM_ID
import com.edu.sun.oereminder.utils.defaultPrefs
import com.edu.sun.oereminder.utils.encryptedPrefs
import com.edu.sun.oereminder.utils.get

class PreferencesHelperImpl(context: Context) : PreferencesHelper {

    private var encryptedPrefs: SharedPreferences? = null
    private var defaultPrefs: SharedPreferences? = null

    init {
        encryptedPrefs = context.encryptedPrefs(ENCRYPTED_PREFS_NAME)
        defaultPrefs = context.defaultPrefs()
    }

    override fun getApiToken() = encryptedPrefs?.get(KEY_API_TOKEN, "") ?: ""

    override fun getRoomId() = defaultPrefs?.get(KEY_ROOM_ID, "") ?: ""

    companion object {
        @Volatile
        private var INSTANCE: PreferencesHelperImpl? = null

        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: PreferencesHelperImpl(context)
            }
    }
}