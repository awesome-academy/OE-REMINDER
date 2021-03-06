package com.edu.sun.oereminder.data.source.preferences

interface PreferencesHelper {
    fun getApiToken(): String

    fun getRoomId(): String

    fun getAccountId(): Long

    fun getTrainerGroup(): String
}
