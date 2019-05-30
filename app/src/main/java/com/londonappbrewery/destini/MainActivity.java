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
    Story mT1Story = new Story(R.string.T1_Story);
    Story mT2Story = new Story(R.string.T2_Story);
    Story mT3Story = new Story(R.string.T3_Story);
    Story mT4Story = new Story(R.string.T4_End);
    Story mT5Story = new Story(R.string.T5_End);
    Story mT6Story = new Story(R.string.T6_End);

    private Story mStorySelected = mT1Story;
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


        mT1Story.setAnswerTop(new Answer(R.string.T1_Ans1, mT3Story));
        mT1Story.setAnswerBottom(new Answer(R.string.T1_Ans2, mT2Story));

        mT2Story.setAnswerTop(new Answer(R.string.T2_Ans1, mT3Story));
        mT2Story.setAnswerBottom(new Answer(R.string.T2_Ans2, mT4Story));

        mT3Story.setAnswerTop(new Answer(R.string.T3_Ans1, mT6Story));
        mT3Story.setAnswerBottom(new Answer(R.string.T3_Ans2, mT5Story));

        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());


        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        mAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mStorySelected.getAnswerTop().getChildStory());
                mStoryTextView.setText(mStorySelected.getStoryID());
                if (mStorySelected == mT4Story || mStorySelected == mT5Story || mStorySelected == mT6Story) {
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

                if (mStorySelected == mT4Story || mStorySelected == mT5Story || mStorySelected == mT6Story) {
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

    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);;
        outState.putSerializable("StoryKey", (Serializable) mStorySelected);

    }

}