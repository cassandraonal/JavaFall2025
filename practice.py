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