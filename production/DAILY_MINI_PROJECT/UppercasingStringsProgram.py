# Define the list of strings
string_list = ["hello", "world", "python", "programming"]

# Function to convert a character to uppercase
def to_uppercase(char):
    if 'a' <= char <= 'z':
        return chr(ord(char) - 32)
    return char

# Convert each string in the list to uppercase
uppercase_list = [''.join(to_uppercase(char) for char in s) for s in string_list]

# Print the result
print(uppercase_list)
