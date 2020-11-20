# Battleship. Currently WIP
Welcome to my first personal project, other than school ones. This time I'm going for a Battleship console game!</br>
The next ships will be implemented (For the moment):
<ul>
  <li><b>1 Carrier C (5 lenght).</b></li>
  <li><b>1 Battleship B (4 lenght).</b></li>
  <li><b>1 Light Cruiser L (3 lenght).</b></li>
  <li><b>2 Destroyers D (3 lenght).</b></li>
  <li><b>2 Submarines S (2 lenght).</b></li>
</ul>

The player's fleet, as well as every board, will take on a 10x10 matrix.
# TODO
<ol>
  <li><b>Autofill the oponent's board (CPU).</b></li>
  <li><b>Implement the shooting action.</b></li>
  <li><b>Add a pile of destroyed ships for each player.</b></li>
  <li><b>End game.</b></li>
</ol>


# Current State (As 20/11/2020):
The program at this moment is cappable of place all ships for human player but not the CPU ones.</br>
Catching exceptions at placing ships such as giving a position that doesn't exists, control that a ship is inside the array bounds or control that a ship cannot be placed on top of another.</br>
<b>Example of Out of Bounds ship:</b></br>
![OutofBoundsShip](/images/ShipOoB.JPG)</br></br>
<b>As well as a ship taking x position of another ship (ship crossing):</b></br>
![CrossedShip](/images/ShipCrossed.JPG)</br></br>
<b>And final player's board after placing all ships:</b></br>
![AllShipsPlaced](/images/AllShipsPlaced.JPG)
