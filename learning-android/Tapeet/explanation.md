Introduction

Tapit (pronounced Tah-Peet) is French for tap it. We are going to build a tapping game to test your reflexes. The game is basically as cool as Tap Tap Revenge. Well, in the same way that checkers is as cool as Mike Tyson’s Punch-Out!!  You could potentially make fractions of dollars through the App Store.

The purpose of this assignment is to introduce:

Style
Layouts
Lifecycle
Game Play

The game is very simple since we’re not keeping track of any data outside of the current game. The game begins with a start button. When the button is pressed it disappears and the game begins. There is a timer at the top of the screen, as well as a counter for the number of taps completed.

A shape, button, or image (we’ll just call it a button) appears and the player needs to tah-peet (tap it, in English). As soon as the button is tapped, then it moves to a different location on the screen. The movement is random. The screen is divided into a 5x8 grid, and the button can appear in any cell.

Level 1

The timer counts down for 10 seconds. If the player successfully taps at least 15 buttons, then they can play Level 2. Tapping anywhere on the screen except the button has no effect. The only way to lose this round is to not tap 15 buttons. Display an intermediate screen to indicate that Level 1 was completed and Level 2 will start (can have a start button).

Level 2

The second round is similar except every spot in the grid contains a different button than the one that needs to be tapped. After each successful tap the entire board is randomized. If they tap an incorrect button, then the game is over and they lose. If they tap at least 20 buttons accurately, then they are a winner.

A message appears that they are a winner, and they can hit the play button to start again.

Requirements

Create a program that does the following:

(5 pts) Displays a start button to begin
(10 pts) Counter to count down 10 seconds
See state demo code for an example of a timer with setInterval()
Don’t forget to stop it when you’re done!
(10 pts) Score increments with each successful tap
(5 pts) Layouts (flex) are used to position the counter and score
(10 pts) Layouts (flex) are used to create and manage the grid
(10 pts) Lifecycle methods are used appropriately
Do not update a component if prop values haven’t changed
Start the game after gameboard has been built
Start and cleanup timers
(10 pts) Level 1 game play and board updating works appropriately
(15 pts) Level 2 game play and board updating works appropriately
(15 pts) Displays an end game screen
Appropriate messaging
Start button to play again
(10 pts) Use state and props to control updating and component communication
Notes

We are not using navigation yet, so switching screens is just a matter of changing the render function of the main class. A button can be whatever you want it to be. It just needs to be clear which button the player should tap.