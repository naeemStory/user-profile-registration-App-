package com.example.userprofileregistration.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userprofileregistration.Dao.UserProfileDao
import com.example.userprofileregistration.Models.UserProfile

@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract  fun _userProfileDao(): UserProfileDao

    companion object{
        @Volatile
        private var INSTANCE:UserDatabase?=null
        fun getDatabase(context: Context):UserDatabase{

            return  INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_profile_database"

                ).build()
                INSTANCE =instance
                instance
            }
        }
    }


}