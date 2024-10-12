package com.example.userprofileregistration.Views

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Models.UserProfile
import com.example.userprofileregistration.R
import com.example.userprofileregistration.viewModel.UserProfileViewModel

class SingleProfileActivity : AppCompatActivity() {

    private  lateinit var  userProfile: UserProfile
    private lateinit var  nameTxt: TextView
    private lateinit var  emailTxt: TextView
    private lateinit var  dobTxt: TextView
    private lateinit var  districtTxt: TextView
    private lateinit var  mobileTxt: TextView
    private  lateinit var updateBtn: ImageButton
    private  lateinit var deleteBtn:ImageButton

    private  lateinit var  profileViewHolder: UserProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_profile)

        profileViewHolder = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        userProfile  = intent.getSerializableExtra("USER_PROFILE") as UserProfile


        nameTxt = this.findViewById(R.id.nameTxt)
        emailTxt = findViewById(R.id.emailTxt)
        dobTxt = findViewById(R.id.dobTxt)
        districtTxt = findViewById(R.id.districtTxt)
        mobileTxt = findViewById(R.id.mobileTxt)
        updateBtn= findViewById(R.id.editBtn)
        deleteBtn = findViewById(R.id.deleteBtn)

        updateBtn.setOnClickListener {
            val intent = android.content.Intent(this, UpdateProfileActivity::class.java)
            intent.putExtra("USER_PROFILE", userProfile)
            startActivity(intent)
        }
        deleteBtn.setOnClickListener{

            profileViewHolder.deleteUserProfile(userProfile)
            finish()
        }
        populateFields()
    }
    private fun populateFields() {
        nameTxt.text = userProfile.name
        emailTxt.text = userProfile.email
        dobTxt.text = userProfile.dob
        districtTxt.text = userProfile.district
        mobileTxt.text = userProfile.mobile
    }
}