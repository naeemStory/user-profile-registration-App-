package com.example.userprofileregistration.repository

import androidx.lifecycle.LiveData
import com.example.userprofileregistration.Dao.UserProfileDao
import com.example.userprofileregistration.Models.UserProfile


class UserProfileRepository(private val userProfileDao: UserProfileDao)  {

    fun  getUserProfiles(): LiveData<List<UserProfile>> {

        return userProfileDao.getAllProfiles()
    }
    suspend fun  insert(userProfile: UserProfile){
        return userProfileDao.insert(userProfile)

    }
    suspend fun  update(userProfile: UserProfile){
        return  userProfileDao.update(userProfile)

    }

    suspend fun  delete(userProfile: UserProfile){
        return  userProfileDao.delete(userProfile)

    }


}