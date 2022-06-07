# PinguRacing
First Assignment from Java course

Alan and Bjarne are the two fastest penguins in Antarctica. In order to decide which of the two is the fastest penguin, they arrange a race. Your program should simulate the course of the race and decide who has won.

## The rules of the race
The integer variable _**t**_ represents the time over the course of the race. The total duration of the race is _**t<sub>duration</sub>**_ seconds,
so the time _**t**_ runs in the interval <strong><i>[0; t<sub>duration</sub>)</strong></i>.
The program calculates the positions and speeds of the two penguins for every second of the race.

The integer positions of Alan and Bjarne are _**posA**_ and _**posB**_ respectively, and can have any initial values. The integer speeds of Alan and Bjarne are
_**spe<sub>A</sub>**_ and _**spe<sub>B</sub>**_ respectively, and both are 0 at the start.
Every second in the first half of the race _**[0 ; <sup>t<sub>duration</sub></sup>&frasl;<sub>2</sub>)**_ the following rules apply to determine the speed of the penguins:
<ul>
<li>Alan suffers from <a href="https://en.wikipedia.org/wiki/Tetraphobia">Tetraphobia</a>. So if its current position <strong><i>posA</i></strong> ends with the number 4, its speed <strong><i>speA</i></strong> is halved (if necessary it is rounded down) and increased by 1. </li>
<li>Otherwise Alan is not afraid and can increase his speed speAspe_Aspe by 7.</li>
<li>Bjarne, on the other hand, suffers from <a href="https://en.wikipedia.org/wiki/Triskaidekaphobia">Triskaidekaphobia</a>. So if his current position 
 <strong><i>posB</i></strong> is divisible by 13,
he gets an adrenaline rush and doubles his speed <strong><i>speB</i></strong> and increases it by an additional 1.</li>
<li>Otherwise Bjarne doesn't panic and can increase his speed <strong><i>speB</i></strong> by 3. </li>
  </ul>
In the second half of the race <strong><i>[<sup> t<sub>duration</sub></sup>&frasl;<sub>2</sub> ; t<sub>duration</sub>)</i></strong> the above rules no longer apply, but only the following:
<ul>
<li>
Basically, <strong><i>speA</i></strong> is now increased by 1 per time step. Only at the times <strong<i><sup>3</sup>&frasl;<sub>5</sub>⋅t<sub>duration</sub></i></strong> and <strong<i><sup>4</sup>&frasl;<sub>5</sub>⋅t<sub>duration</sub></i></strong> <strong><i>speA</i></strong> is divided by 4 and rounded down if necessary. </li>
<li>
Basically, <strong><i>speB</i></strong> is now reduced by 1 per time step. Only in the last 13 seconds 
<strong><i>[t<sub>duration</sub> -13 ; t<sub>duration</sub>)</i></strong> Bjarne is unlucky and stumbles,
so that his speed is halved every second and rounded down if necessary.</li>
 </ul>
There is also a maximum <strong><i>spe<sub>max</sub>=128</i></strong>, which must never be exceeded at any time. The speeds can never be negative either. I.e. if the speed exceeds the <strong><i>spe<sub>max</sub></i></strong> or falls below 0 according to the above rules, the speed is simply set to <strong><i>spe<sub>max</sub></i></strong> or 0.  

After the current speed has been determined for the time <strong><i>t</i></strong> the position of the penguin is simply increased by the speed.

In the end, the penguin with the highest position wins. A draw can of course also occur.

### Program Statement
Your program should ask the starting positions of Alan and Bjarne, as well as the duration of the race, and simulate the race.

The command prompt via the console should look like this:

Alan starting position:
Bjarne starting position:
Race duration:
If the entered race duration is negative, the following error message should be issued repeatedly until a non-negative race duration is entered:

Please do not enter a negative number:
For every second of the simulation, the positions and speeds of Alan and Bjarne should be output as follows:

t = <time>
Alan position = <posA>; speed = <speA>
Bjarne position = <posB>; speed = <speB>
It stands <time> for ttt, <posA> for posApos_Apos 
A
​
 , <speA> for speAspe_Aspe 
A
​
 , and so forth.

In the end, the winning penguin should be handed out. So if Alan wins:

Alan wins!
If Bjarne wins:

Bjarne wins!
And if the race ends in a draw:

Draw!
Examples
The lines that begin with "> " mark the user input and are not output by the program. They are only given for the sake of clarity.

 example 1: Error messages 1 of 1 tests passing
Alan starting position:
> 0
Bjarne starting position:
> 0
Race duration:
> -1
Please do not enter a negative number:
> -3
Please do not enter a negative number:
> 0
Draw!
 example 2: Alan wins 1 of 1 tests passing
Alan starting position:
> 3
Bjarne starting position:
> 3
Race duration:
> 6
t = 0
Alan position = 10; speed = 7
Bjarne position = 6; speed = 3
t = 1
Alan position = 24; speed = 14
Bjarne position = 12; speed = 6
t = 2
Alan position = 32; speed = 8
Bjarne position = 21; speed = 9
t = 3
Alan position = 34; speed = 2
Bjarne position = 25; speed = 4
t = 4
Alan position = 34; speed = 0
Bjarne position = 27; speed = 2
t = 5
Alan position = 35; speed = 1
Bjarne position = 28; speed = 1
Alan wins!
 example 3: Bjarne wins 1 of 1 tests passing
Alan starting position:
> -3
Bjarne starting position:
> 4
Race duration:
> 7
t = 0
Alan position = 4; speed = 7
Bjarne position = 7; speed = 3
t = 1
Alan position = 8; speed = 4
Bjarne position = 13; speed = 6
t = 2
Alan position = 19; speed = 11
Bjarne position = 26; speed = 13
t = 3
Alan position = 31; speed = 12
Bjarne position = 32; speed = 6
t = 4
Alan position = 34; speed = 3
Bjarne position = 35; speed = 3
t = 5
Alan Position = 34; speed = 0
Bjarne Position = 36; speed = 1
t = 6
Alan position = 35; speed = 1
Bjarne position = 36; speed = 0
Bjarne wins!


FAQ
Q: What is this weird [a;b)[a; b)[a;b) notation?
A: A half-open interval, i.e. the set of whole numbers xxx for which applies a≤x&lt;ba \leq x &lt; ba≤x<b.

Q: What is this ⌊x⌋\lfloor x \rfloor⌊x⌋ notation?
A: That means xxx is rounded down, e.g. if x=2.9x=2.9x=2.9 then ⌊x⌋=2\lfloor x \rfloor = 2⌊x⌋=2.

Q: Why does it look in example 2 and 3 as if the penguins are already moving at t = 0?
A: The specification of t is always at the beginning of the time interval, whereas the position and speed of the positions are output from the end of the time interval.
