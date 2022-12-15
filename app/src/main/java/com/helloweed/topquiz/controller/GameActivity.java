package com.helloweed.topquiz.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.helloweed.topquiz.R;
import com.helloweed.topquiz.model.Question;
import com.helloweed.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mQuestionText;
    private TextView mNameEtScore;
    private Button mBoutonReponse1;
    private Button mBoutonReponse2;
    private Button mBoutonReponse3;
    private Button mBoutonReponse4;
    private Question mQuestion;
    private QuestionBank mQuestionBank = generateQuestions();
    private Question mCurrentQuestion;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";



    private int mRemainingQuestionCount;
private int mReponseCorrectes;
private int mReponseTotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mRemainingQuestionCount = 10;
        mReponseCorrectes = 0;
        mReponseTotal =0;

        mBoutonReponse1 = findViewById(R.id.game_activity_button_1);
        mBoutonReponse2 = findViewById(R.id.game_activity_button_2);
        mBoutonReponse3 = findViewById(R.id.game_activity_button_3);
        mBoutonReponse4 = findViewById(R.id.game_activity_button_4);
        mQuestionText = findViewById(R.id.game_activity_textview_question);
        mNameEtScore = findViewById(R.id.game_activity_textview_NameEtScore);
        mNameEtScore.setText("Question(s) restante(s) " +  mRemainingQuestionCount);

        mBoutonReponse1.setOnClickListener(this);
        mBoutonReponse2.setOnClickListener(this);
        mBoutonReponse3.setOnClickListener(this);
        mBoutonReponse4.setOnClickListener(this);
if (mRemainingQuestionCount > 0){
    mCurrentQuestion = mQuestionBank.getCurrentQuestion();
    displayQuestion(mCurrentQuestion);
}else{

}

    }
    private void displayQuestion(final Question question){
        mQuestionText.setText(question.getQuestion());
        mBoutonReponse1.setText(question.getChoiceList().get(0));
        mBoutonReponse2.setText(question.getChoiceList().get(1));
        mBoutonReponse3.setText(question.getChoiceList().get(2));
        mBoutonReponse4.setText(question.getChoiceList().get(3));

    }
    private QuestionBank generateQuestions() {

        Question question1 = new Question(
                "Qui de papa ou maman a déjà eu le COVID ?",
                Arrays.asList(
                        "Maman uniquement",
                        "Papa uniquement",
                        "Maman et Papa",
                        "Aucun des deux"),
                2
        );
        Question question2 = new Question(
                "Maman et Papa vivent-ils dans une grande maison ?",
                Arrays.asList(
                        "Non",
                        "Bah... ca dépend...",
                        "JOKER ?!",
                        "Oui ! Et c'est même papa qui l'a retapé !"),
                3
        );
        Question question3 = new Question(
                "La piscine est-elle pouette pouette ?",
                Arrays.asList(
                        "Non... Elle est juste carrée.",
                        "Depuis quand ?",
                        "La réponse 3",
                        "Non elle est ronde..."),
                3
        );
        Question question4 = new Question(
                "Quel est le deuxième prénom de Lengie ?",
                Arrays.asList(
                        "Edouarda",
                        "Saluella Grandiosa",
                        "Alberta !",
                        "Lutèce."),
                3
        );
        Question question5 = new Question(
                "Quel est l'age de notre univers ?",
                Arrays.asList(
                        "3478 ans",
                        "13.8 milliards d'années ? Enfin je crois...",
                        "Ca me parle, il me semble que c'est un piège. C'est 13 millions ?",
                        "Trop vieux pour le dater. On en sait rien."),
                1
        );
        Question question6 = new Question(
                "Quel est le diamètre de l'univers Observable ?",
                Arrays.asList(
                        "46.5 Milliards d'années lumière. Ca fait beaucoup.",
                        "13.8 Milliards d'années lumière. Bah ouais logique vu qu'il a 13.8 milliards d'années.",
                        "Plutot grand !",
                        "Infini !"),
                0
        );
        Question question7 = new Question(
                "Comment appelle t'on une laie suivie de ses petits ?",
                Arrays.asList(
                        "Une Quinte Flush Royale. C'est une référence au poker pour les chasseurs qui y voient le jackpot ultime !",
                        "Un roudoudou.",
                        "Une suitée.",
                        "Une laitue vireuse !"),
                2
        );
        Question question8 = new Question(
                "Est-ce que Mathieu a galéré à réaliser cette petite application ?",
                Arrays.asList(
                        "Un peu...",
                        "Bah, c'était pas aisé on va dire...",
                        "Avec du recule ça va.",
                        "Oui, c'était très stressant pour lui."),
                3
        );
        Question question9 = new Question(
                "Avec Quel logiciel a été réalisé cette application ?",
                Arrays.asList(
                        "Quiz Studio",
                        "APPLE Studio",
                        "ANDROID STUDIO",
                        "MAYASQUAD"),
                2
        );
        Question question10 = new Question(
                "Quel type de language de programmation peut-on retrouver dans le code source de cette application ?",
                Arrays.asList(
                        "Python",
                        "C",
                        "VISUAL BASIC",
                        "JAVA"),
                3
        );
        Question question11 = new Question(
                "Peut-on se faire beaucoup d'argent avec une application ?",
                Arrays.asList(
                        "Oui c'est possible. Mais les proportions sont plutôt faibles.",
                        "Non en aucun cas. Faut pas rêver...",
                        "A tous les coups ça paye gros !",
                        "La réponse 4"),
                0
        );


        return new QuestionBank(Arrays.asList(question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,question11));
    }

    @Override
    public void onClick(View v) {
        int index;

        if (v == mBoutonReponse1) {
            index = 0;
        } else if (v == mBoutonReponse2) {
            index = 1;
        } else if (v == mBoutonReponse3) {
            index = 2;
        } else if (v == mBoutonReponse4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()){
            Toast.makeText(this,"Correct !",Toast.LENGTH_SHORT).show();
            mReponseTotal ++;
            mReponseCorrectes ++;

        } else { Toast.makeText(this, "Incorrect !",Toast.LENGTH_SHORT).show();
            mReponseTotal ++;
        }
        mRemainingQuestionCount --;
        if (mRemainingQuestionCount >0){
            mCurrentQuestion = mQuestionBank.getNextQuestion();
            displayQuestion(mCurrentQuestion);
            mNameEtScore.setText(mReponseCorrectes + " bonne(s) réponse(s) sur " + mReponseTotal);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("C'est fini !")
                    .setMessage("Ton score est de " + mReponseCorrectes )
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra(BUNDLE_EXTRA_SCORE,mReponseCorrectes);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    })
                    .create()
                    .show();
            //Rien
        }
    }


}