# music-tool

## logic:

given a string, create a sequence of notes using the distance between characters

%7 to prevent notes from jumping across multiple octaves

note[0] = start note

note[i] = (char[i]-char[i-1]) % 7

examples in C major:

String "ABC", starting at C: C D E

String "ZXV", starting at G: G E C

String "STRING", starting at F: F G E C A A

>S->T = +1, T->R = -2, R->I = -9%7 = -2, I->N = +5, N->G = 7%7 = 0

## usage:
- enter key (A-G), append # for sharp option
- indicate whether it's a minor key
- enter text to be transformed
- enter start note (0-7), in key of C, 0->first note is C, 1->first note is D, etc

## example output:

Music Tool

Enter Key (a-g, #): **C**

Minor? (y/n): **n**


Type 'restart' to choose a new key. 

Type 'end' to terminate the program.

Enter Text: **abcdefghijklmnop**

Enter Start Note (0-7): **0**


Available notes:
C D E F G A B

<pre>
 2|                                            C  D

 1|                       C  D  E  F  G  A  B

 0|  C  D  E  F  G  A  B

-1|
</pre>

Enter Text:
