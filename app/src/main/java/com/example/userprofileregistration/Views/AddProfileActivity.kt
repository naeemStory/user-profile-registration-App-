package com.example.userprofileregistration.Views

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.userprofileregistration.Models.UserProfile
import com.example.userprofileregistration.R
import com.example.userprofileregistration.viewModel.UserProfileViewModel
import java.util.Calendar

class AddProfileActivity : AppCompatActivity() {
    private  lateinit var   profileViewModel: UserProfileViewModel
    private  lateinit var  nameTxt:EditText
    private  lateinit var  emailTxt:EditText
    private  lateinit var  dobTxt:EditText
    private  lateinit var  districtTxt:EditText
    private  lateinit var  mobileTxt:EditText
    private  lateinit var  saveBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_profile)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        nameTxt = findViewById(R.id.profileNameEt)
        emailTxt = findViewById(R.id.emailEt)
        dobTxt = findViewById(R.id.dobEt)

        dobTxt.setOnClickListener{
            showDatePickerDialog()
        }
        districtTxt = findViewById(R.id.districtEt)
        mobileTxt = findViewById(R.id.mobileEt)

        saveBtn = findViewById(R.id.addBtn)
        saveBtn.setOnClickListener{

            val name = nameTxt.text.toString().trim()
            val email = emailTxt.text.toString().trim()
            val dob = dobTxt.text.toString().trim()
            val district = districtTxt.text.toString().trim()
            val mobile = mobileTxt.text.toString().trim()
            val userProfile = UserProfile(name = name, email=email, dob=dob, district=district, mobile=mobile)
            profileViewModel.insertUserProfile(userProfile)
            finish()
        }

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            dobTxt.setText(date)
        }, year, month, day)

        datePickerDialog.show()

    }

}