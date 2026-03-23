# Snake & Ladder

A clean, object-oriented implementation of the classic **Snakes & Ladders** game in Java.

---

## Overview

This project simulates a multiplayer Snake & Ladder game where:

* The board size is **n × n**
* There are **n snakes and n ladders**, placed randomly
* Players take turns rolling a dice
* The first player to reach the final cell wins

The intention behind this project is not just functional correctness, but also to demonstrate how a simple problem can be structured into a well-designed, maintainable system.

---

## Design Approach

The implementation follows a modular design where each class has a clearly defined responsibility:

* The system avoids monolithic code and instead separates concerns across multiple components
* The design supports extensibility without requiring major changes to existing code
* The structure reflects patterns and practices commonly expected in technical interviews

---

## Project Structure

```
SnakeLadder/
│
├── Main.java                → Entry point, handles user input
├── Game.java                → Controls game flow and turn management
├── Board.java               → Maintains snakes and ladders
├── Player.java              → Represents player state
│
├── dice/
│   ├── DiceStrategy.java    → Dice abstraction (Strategy pattern)
│   ├── NormalDice.java      → Standard six-faced dice implementation
│   └── LoggingDiceDecorator.java → Adds logging without modifying dice logic
│
├── jump/
│   ├── Snake.java           → Snake model (head → tail)
│   ├── Ladder.java          → Ladder model (start → end)
│   └── JumpFactory.java     → Responsible for generating snakes and ladders
│
├── difficulty/
│   ├── DifficultyStrategy.java → Difficulty abstraction
│   ├── EasyDifficulty.java     → Easier configuration (more ladders)
│   └── HardDifficulty.java     → Harder configuration (more snakes)
```

---

## Game Flow

1. The user provides:

   * Board size `n`
   * Number of players
   * Player names
   * Difficulty level (easy or hard)

2. The system initializes:

   * A board of size `n × n`
   * Snakes and ladders based on the selected difficulty
   * Players at starting position `0`

3. During gameplay:

   * Players take turns in FIFO order using a queue
   * A dice roll determines movement (1 to 6)
   * The player moves forward accordingly
   * If the player lands on:

     * A snake head → moves down to its tail
     * A ladder start → climbs up to its end
   * If the move exceeds the final cell, the player remains in place

4. The game continues until a player reaches the last cell

---

## Design Patterns Used

### Strategy Pattern

* Used for both dice behavior and difficulty handling
* Enables interchangeable implementations without changing core logic

### Factory Pattern

* `JumpFactory` encapsulates the creation of snakes and ladders
* Keeps board initialization clean and focused

### Decorator Pattern

* `LoggingDiceDecorator` adds logging functionality without modifying the original dice implementation
* Demonstrates extension of behavior through composition

---

## Key Design Decisions

* A **queue** is used to manage player turns, ensuring fairness and simplicity
* **Hash maps** are used for snakes and ladders to allow constant-time lookups
* The **Board** class encapsulates all jump-related logic
* The **Game** class is responsible only for flow control, not internal mechanics

---

## How to Run

1. Compile all files:

```bash
javac *.java dice/*.java jump/*.java difficulty/*.java
```

2. Run the application:

```bash
java Main
```

3. Follow the prompts in the console to start the game

---

## Sample Gameplay

```
Sam rolled 4
Sam is at 4

Bitten by snake! Down to 2

Rahul rolled 6
Rahul is at 6

Climbed ladder! Up to 14
```
