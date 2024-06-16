package com.example.cargame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.content.Intent


class MainActivity : AppCompatActivity(), GameTask {
    lateinit var rootLayout: LinearLayout
    lateinit var startBtn: Button
    lateinit var restartBtn: Button // New button for restarting the game
    lateinit var mGameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this, gameTask = this)

        startBtn.setOnClickListener {
            startGame()
        }

        restartBtn.setOnClickListener {
            restartGame()
        }
    }

    private fun startGame() {
        mGameView.setBackgroundResource(R.drawable.path)
        rootLayout.addView(mGameView)
        startBtn.visibility = View.GONE
        restartBtn.visibility = View.GONE
        score.visibility = View.GONE
    }

    private fun restartGame() {
        rootLayout.removeView(mGameView)
        mGameView = GameView(this, gameTask = this) // Create a new instance of GameView
        startGame() // Start the game again
    }

    override fun closeGame(mScore: Int) {
        score.text = "Score :$mScore"
        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        restartBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE

        // Start the RestartActivity
        val intent = Intent(this, RestartActivity::class.java)
        startActivity(intent)
    }


}
