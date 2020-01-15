package com.prinster.t3online

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var playerOneTurn = true

    private val playerOneMoves: ArrayList<Int> = ArrayList()
    private val playerTwoMoves: ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeButtons()
    }

    private fun initializeButtons() {
        tl.setOnClickListener { v -> whichCell(v!!, v.id) }
        tm.setOnClickListener { v -> whichCell(v!!, v.id) }
        tr.setOnClickListener { v -> whichCell(v!!, v.id) }

        ml.setOnClickListener { v -> whichCell(v!!, v.id) }
        mm.setOnClickListener { v -> whichCell(v!!, v.id) }
        mr.setOnClickListener { v -> whichCell(v!!, v.id) }

        bl.setOnClickListener { v -> whichCell(v!!, v.id) }
        bm.setOnClickListener { v -> whichCell(v!!, v.id) }
        br.setOnClickListener { v -> whichCell(v!!, v.id) }
    }

    private fun whichCell(view: View, id: Int) {
        val button = view as Button
        var cell = -1
        when(id) {
            tl.id -> cell = 1
            tm.id -> cell = 2
            tr.id -> cell = 3
            ml.id -> cell = 4
            mm.id -> cell = 5
            mr.id -> cell = 6
            bl.id -> cell = 7
            bm.id -> cell = 8
            br.id -> cell = 9
        }

        if(playerOneTurn) {
            button.background = getDrawable(R.drawable.player_one_button)
            playerOneMoves.add(cell)
            checkWinner(playerOneMoves)
        }
        else {
            button.background = getDrawable(R.drawable.player_two_button)
            playerTwoMoves.add(cell)
            checkWinner(playerTwoMoves)
        }
    }

    private fun checkWinner(arr: ArrayList<Int>) {
        var currentPlayer = "Player 1"
        if(!playerOneTurn) {
            currentPlayer = "Player 2"
        }

        // top row
        if(arr.contains(1) && arr.contains(2) && arr.contains(3)) {
            toastWin(currentPlayer)
        }
        // middle row
        else if(arr.contains(4) && arr.contains(5) && arr.contains(6)) {
            toastWin(currentPlayer)
        }
        // bottom row
        else if(arr.contains(7) && arr.contains(8) && arr.contains(9)) {
            toastWin(currentPlayer)
        }
        // first column
        else if(arr.contains(1) && arr.contains(4) && arr.contains(7)) {
            toastWin(currentPlayer)
        }
        // second column
        else if(arr.contains(2) && arr.contains(5) && arr.contains(8)) {
            toastWin(currentPlayer)
        }
        // third column
        else if(arr.contains(3) && arr.contains(6) && arr.contains(9)) {
            toastWin(currentPlayer)
        }
        // top left -> bottom right
        else if(arr.contains(1) && arr.contains(5) && arr.contains(9)) {
            toastWin(currentPlayer)
        }
        // bottom left -> top right
        else if(arr.contains(7) && arr.contains(5) && arr.contains(3)) {
            toastWin(currentPlayer)
        }
        // full, but no winner
        else if((playerOneMoves.size + playerTwoMoves.size) == 9) {
            toastDraw()
        }

        swapPlayers()
    }

    private fun toastWin(player: String) {
        Toast.makeText(this, "Player $player wins!", Toast.LENGTH_LONG).show()
        clearBoard()
    }

    private fun toastDraw() {
        Toast.makeText(this, "It's a Draw!", Toast.LENGTH_LONG).show()
        clearBoard()
    }

    private fun swapPlayers() {
        playerOneTurn = !playerOneTurn
    }

    private fun clearBoard() {
        tl.background = getDrawable(R.drawable.unclicked_button)
        tm.background = getDrawable(R.drawable.unclicked_button)
        tr.background = getDrawable(R.drawable.unclicked_button)

        ml.background = getDrawable(R.drawable.unclicked_button)
        mm.background = getDrawable(R.drawable.unclicked_button)
        mr.background = getDrawable(R.drawable.unclicked_button)

        bl.background = getDrawable(R.drawable.unclicked_button)
        bm.background = getDrawable(R.drawable.unclicked_button)
        br.background = getDrawable(R.drawable.unclicked_button)

        playerOneMoves.clear()
        playerTwoMoves.clear()
    }
}
