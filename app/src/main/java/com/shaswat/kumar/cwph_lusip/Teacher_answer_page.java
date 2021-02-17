package com.shaswat.kumar.cwph_lusip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shaswat.kumar.cwph_lusip.ui.teacheranswerpage.TeacherAnswerPageFragment;

public class Teacher_answer_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_answer_page_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TeacherAnswerPageFragment.newInstance())
                    .commitNow();
        }
    }
}
