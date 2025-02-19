#practice - using GitHub
#Cassandra Sbordoni

print("Hello Python world!")

a, b = "hi", "python"
#print(a, '\n', b) prints extra space, so no good.
print(a, '\n', b, sep = "") #works
print(a, b, sep = "\n") #works
print(a+'\n'+b) #stacks right on top of eachother prints same as 2 above.

#input allows the user to input something they want anything, to be displayed.
a=input("Enter a greeting: ") #you can do with no spacing 
b = input("Enter some text: ") #or with.

print(a.capitalize()+', '+b.lower()+"!")

# hello.py                      #The program below asks the user to enter a course number using the input() 
try:                            #function. This input is then passed to eval().
 courseNum = eval(input("Enter your course number: "))#The eval() function evaluates the input. If the input is a valid expression 
 print(f"Hello, welcome to the course ET{courseNum}!")#(ex: 5 + 10 or 101) an integer not an alphabetical char, it is evaluated and stored in courseNum.
except:               #The program then prints a message, using an f-string, welcoming the user 
 print("Hello, world!")#to the course and inserting the evaluated courseNum into the string.
                        #ex: if courseNum = 574, it prints:
                        #"Hello, welcome to the course ET574!"
