package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.models.Answer;
import com.londonappbrewery.destini.models.Story;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;
    // TODO: Declare as variaveis aqui:

    //indice corrente da historia
    //private Story mStorySelected;
    Story T1 = new Story(R.string.T1_Story);
    Story T2 = new Story(R.string.T2_Story);
    Story T3 = new Story(R.string.T3_Story);
    Story T4 = new Story(R.string.T4_End);
    Story T5 = new Story(R.string.T5_End);
    Story T6 = new Story(R.string.T6_End);

    private Story mStorySelected = T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.buttonTop);
        mAnswerBottom = findViewById(R.id.buttonBottom);


        if (savedInstanceState!=null){
            mStorySelected = (Story) savedInstanceState.getSerializable("StoryKey");
        }
        //TODO:faça o mapeamento da história


        T1.setAnswerTop(new Answer(R.string.T1_Ans1, T3));
        T1.setAnswerBottom(new Answer(R.string.T1_Ans2, T2));

        T2.setAnswerTop(new Answer(R.string.T2_Ans1, T3));
        T2.setAnswerBottom(new Answer(R.string.T2_Ans2, T4));

        T3.setAnswerTop(new Answer(R.string.T3_Ans1, T6));
        T3.setAnswerBottom(new Answer(R.string.T3_Ans2, T5));

        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());


        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
         mAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mStorySelected.getAnswerTop().getChildStory());
                mStoryTextView.setText(mStorySelected.getStoryID());
                if (mStorySelected == T4 || mStorySelected == T5 || mStorySelected == T6) {
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                }else{
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }

            }
        });

        mAnswerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mStorySelected.getAnswerBottom().getChildStory());
                mStoryTextView.setText(mStorySelected.getStoryID());

                if (mStorySelected == T4 || mStorySelected == T5 || mStorySelected == T6) {
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                }else{
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }
            }
        });



    }
    public void updateStory(Story newStory){
        mStorySelected = newStory;

    }
	@Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);;
        outState.putSerializable("StoryKey", (Serializable) mStorySelected);

    }

}
