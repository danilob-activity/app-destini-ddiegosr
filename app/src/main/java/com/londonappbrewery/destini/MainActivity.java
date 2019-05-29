package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.models.Answer;
import com.londonappbrewery.destini.models.Story;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;
    // TODO: Declare as variaveis aqui:
    Answer mT1StoryAns1 = new Answer(R.string.T1_Ans1);
    Answer mT1StoryAns2 = new Answer(R.string.T1_Ans2);

    Answer mT2StoryAns1 = new Answer(R.string.T2_Ans1);
    Answer mT2StoryAns2 = new Answer(R.string.T2_Ans2);

    Answer mT3StoryAns1 = new Answer(R.string.T3_Ans1);
    Answer mT3StoryAns2 = new Answer(R.string.T3_Ans2);
    Story[] mStories = new Story[] {
            new Story(R.string.T1_Story, mT1StoryAns1, mT1StoryAns2),
            new Story(R.string.T2_Story, mT2StoryAns1, mT2StoryAns2),
            new Story(R.string.T3_Story, mT3StoryAns1, mT3StoryAns2),
            new Story(R.string.T4_End),
            new Story(R.string.T5_End),
            new Story(R.string.T6_End),
    };

    //indice corrente da historia
    private int mStoryIndex = 0;
    Story mStorySelected;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("storyIndex", mStoryIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("storyIndex");
        }

        mStorySelected = mStories[mStoryIndex];


        //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.buttonTop);
        mAnswerBottom = findViewById(R.id.buttonBottom);

        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());

        //TODO:faça o mapeamento da história
        mT1StoryAns1.setChildStory(mStories[2]);
        mT1StoryAns2.setChildStory(mStories[1]);

        mT3StoryAns1.setChildStory(mStories[5]);
        mT3StoryAns2.setChildStory(mStories[4]);

        mT2StoryAns1.setChildStory(mStories[2]);
        mT2StoryAns2.setChildStory(mStories[3]);

        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):

    }

}
