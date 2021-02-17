package com.shaswat.kumar.cwph_lusip.ui.home;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.shaswat.kumar.cwph_lusip.R;
import com.shaswat.kumar.cwph_lusip.ui.model.Student_Data;

import java.util.ArrayList;

public class HomeViewModel extends RecyclerView.Adapter<HomeViewModel.HolderData> {

    private Context context;
    private ArrayList<Student_Data> stu_data;


    public HomeViewModel(Context context, ArrayList<Student_Data> stu_data) {
        this.context = context;
        this.stu_data = stu_data;
    }
    @NonNull
    @Override
    public HomeViewModel.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.student_recycler_content,parent,false);


        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewModel.HolderData holder, int position) {

        final Student_Data student_data = stu_data.get(position);
        final String mMessage,mName,url;
        final Button playButton;

        mName = "Anonymous";
        mMessage = student_data.getMessage();
        url = student_data.getAudio();

        holder.title.setText(mName);
        holder.message.setText(mMessage);
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Audio Playing...", Toast.LENGTH_SHORT).show();
                MediaPlayer player = new MediaPlayer();

                try{
                    player.setDataSource(url);
                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    player.prepare();
                }catch(Exception e){
                    Toast.makeText(context, "Can't play now, Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return stu_data.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        private TextView title,message;
        private Button play;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message_student_content);
            play = itemView.findViewById(R.id.playButton);
        }
    }
}