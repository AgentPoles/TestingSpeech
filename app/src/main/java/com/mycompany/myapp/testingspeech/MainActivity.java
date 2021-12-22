package com.mycompany.myapp.testingspeech;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private static int TTS_DATA_CHECK = 1;
    private TextToSpeech tts = null;
    Detailse details;
    HashMap<String, String> map;
    TextToSpeech.OnInitListener jj;
    public static int VOICE_RECOGNITION = 8;
    Intent intrent;
    String name;
     static  int proccedings =0;
    static List<Detailse> detailLists = new ArrayList<>();
    static DetailsAdapter detailsAdapter;
    RecyclerView recyclerView;
    private boolean ttsIsInit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        map = new HashMap<String, String>();
     intrent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
// Specify free form input
        intrent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intrent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "or forever hold your peace");
        intrent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
        intrent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        detailsAdapter = new DetailsAdapter(detailLists);
        ActionBar actionBar = getSupportActionBar();
        details = new Detailse();
        tts = new TextToSpeech(this,jj);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        detailLists.add(details);detailLists.add(details);detailLists.add(details);
        actionBar.hide();
        initTextToSpeech();
//        startActivityForResult(intrent,VOICE_RECOGNITION);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(detailsAdapter);
        detailsAdapter.notifyDataSetChanged();

        TextToSpeech.OnInitListener jj = new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        };
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               startActivityForResult(intrent,VOICE_RECOGNITION);
initTextToSpeech();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initTextToSpeech() {
        Intent intent = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent, TTS_DATA_CHECK);
    }
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION && resultCode == RESULT_OK) {
            ArrayList<String> results;
            results =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            float[] confidence;
            String confidenceExtra = RecognizerIntent.EXTRA_CONFIDENCE_SCORES;
            confidence =
                    data.getFloatArrayExtra(confidenceExtra);
// TODO Do something with the recognized voice strings
            Toast.makeText(this, results.toString(), Toast.LENGTH_LONG).show();
            switch (proccedings){

                case 1:tts.setPitch(1.33f);
                      speak("did you say," + results.toString());
                           name = results.toString();
                    break;
                case 2:
                    if (results.toString().equals("[yes]")) {
                        tts.setPitch(0.89f);
                        speak("ok then,welcome,"+name+", what would you like me to do for you");
                        break;
                    }
                    else {
                        if (results.toString().equals("[no]")) {
                            tts.setPitch(0.89f);
                            proccedings =0;
                            speak("sorry! for the mixup, please can u take your name again or simply enter it in the box below?");
                            break;

                        }
                        else {
                            tts.setPitch(0.89f);
                            proccedings--;
                            speak("sorry i didn't get that, did i get your name? yes or no");
                            break;
                        }
                        }
            }

        }
//        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TTS_DATA_CHECK) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                tts = new TextToSpeech(this, this);

            } else {
                Intent installVoice = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installVoice);
            }

        }
    }
    private void speak(String m) {

        if (tts != null && ttsIsInit) {
            proccedings++;
            tts.speak(m, TextToSpeech.QUEUE_ADD, map);

        }
    }
    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            ttsIsInit = true;
            if (tts.isLanguageAvailable(Locale.UK) >= 0)
                tts.setLanguage(Locale.US);
            tts.setPitch(0.89f);
            tts.setSpeechRate(0.87f);
            map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
            speak("Hi, . welcome to your design aid, i'm Ann the software programme that manages the entire P.O.L.E.S system. please may I know your name?");
                            tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                                @Override
                                public void onStart(String s) {
                                    Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onDone(String s) {

//                                    new Thread()
//                                    {
//                                        public void run()
//                                        {
//                                            MainActivity.this.runOnUiThread(new Runnable()
//                                            {
//                                                public void run()
//                                                {
//
//                                                    Toast.makeText(getBaseContext(), "TTS Completed", Toast.LENGTH_SHORT).show();
//
//                                                }
//                                            });
//                                        }
//                                    }.start();

                                    startActivityForResult(intrent, VOICE_RECOGNITION);
                                }

                                @Override
                                public void onError(String s) {

                                }
                            });

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//TextToSpeec Rabbi = new TextToSpeech.OnUtteranceCompletedListener() {
//    @Override
//    public void onUtteranceCompleted(String s) {
//        startActivityForResult(intrent, VOICE_RECOGNITION);
//    }
//};
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
