package com.shaswat.kumar.cwph_lusip.ui.teacheranswerpage;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.shaswat.kumar.cwph_lusip.LoginActivity;
import com.shaswat.kumar.cwph_lusip.R;

public class TeacherAnswerPageFragment extends Fragment {

    private TeacherAnswerPageViewModel mViewModel;

    TextView signout;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    public static TeacherAnswerPageFragment newInstance() {
        return new TeacherAnswerPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_answer_page_fragment, container, false);

        signout = view.findViewById(R.id.signout_teacher);

        mAuth = FirebaseAuth.getInstance();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                mAuth.removeAuthStateListener(authStateListener);
                startActivity(new Intent(getActivity(), LoginActivity.class));

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeacherAnswerPageViewModel.class);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAuth.removeAuthStateListener(authStateListener);
    }
}
