import tkinter as tk
from tkinter import ttk
from tkinter.ttk import *
import time
    
def typingTest():
    
    phrases = ["Typing is a great skill to master.", "I began to learn how to type in Elementary school. It was really fun to learn.",
               "I became the fastest typer in my entire class at one point, I'm not sure how I managed that!"]
    
    score = 0
    totalTime = 0
    
    for i in range(len(phrases)):
        
        phraseout0 = phrases[i]
        start = time.time()
        print(f"\n{phraseout0}")
        phrase1 = input("Type phrase correctly:")
    
        if phrase1 == phraseout0:
            print("Good Job!")
            score += 1
            print(f"Points: {score}")
        else:
            print("\nWrong!")
            print(f"Points: {score}")
        end = time.time()
        actualTime = (end - start)
        totalTime += actualTime
        roundedTime = round(actualTime, 3)
        
        print(f"{roundedTime} Seconds")

    print(f"\n{score}/{len(phrases)} correct")
    
    if score == 1:
        print(f"Game Over! \nYou scored {score} point")
    else:
        print(f"Game Over! \nYou scored {score} points")
        
    print(f"Total Time: {round(totalTime, 3)} Seconds")


def configure():
    startButton.config(text="Enter")

        
    phrases = ["Typing is a great skill to master.", "I began to learn how to type in Elementary school. It was really fun to learn.",
               "I became the fastest typer in my entire class at one point, I'm not sure how I managed that!"]
    i = 3
    score = 0

    while i <= len(phrases):
        instructions.config(text=phrases[i])
        phrase1 = phraseEntry.get()

        if phrase1 != phrases[i]:
            print()
        else:
            lblresult["text"] = "Good job!"
            score -= 1
            lblresult2["text"] = f"Points: {score}"
            i -= 1 
  

        

window = tk.Tk()
window.geometry("600x400")
window.title("Typing Speed Test")
instructions = tk.Label(window, text="Welcome to the typing speed test! \nClick to begin!")
instructions2 = tk.Label(window, text="")
phrases = tk.Label(window)
lbl1 = tk.Label(window, text="Type the phrase:")
startButton = tk.Button(window, text="Start", command=configure)
phraseEntry = tk.Entry(window, width=75)
phraseEntry2 = tk.Entry(window)
lblresult = tk.Label(window)
lblresult2 = tk.Label(window)
lblresultWrong = tk.Label(window)
lblresult3 = tk.Label(window)


startButton.grid(column=4, row=2)
instructions.grid(column=4, row=0)
instructions2.grid(column=1, row=4)
lbl1.grid(column=3, row=14)
phraseEntry.grid(column=4, row=14)
#phraseEntry2.grid(column=8, row=2)
lblresult.grid(column=6, row=5)
lblresult2.grid(column=6, row=6)
lblresultWrong.grid(column=6, row=7)
lblresult3.grid(column=6, row=8)
window.mainloop()

typingTest()