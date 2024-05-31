#include <iostream>
#include <vector>
#include <string>
#include <fstream>
#include <stdexcept>

// Function to print "Hello, World!"
void printMessage() {
    std::cout << "Hello, World!" << std::endl;
}

// Class to demonstrate object-oriented programming
class Greeter {
public:
    Greeter(const std::string& name) : name(name) {}

    void greet() const {
        std::cout << "Hello, " << name << "!" << std::endl;
    }

private:
    std::string name;
};

// Template function to print elements of a container
template <typename Container>
void printContainer(const Container& container) {
    for (const auto& element : container) {
        std::cout << element << " ";
    }
    std::cout << std::endl;
}

// Function to read names from a file and return a vector of strings
std::vector<std::string> readNamesFromFile(const std::string& filename) {
    std::ifstream file(filename);
    if (!file) {
        throw std::runtime_error("Could not open file: " + filename);
    }

    std::vector<std::string> names;
    std::string name;
    while (std::getline(file, name)) {
        names.push_back(name);
    }
    return names;
}

int main() {
    try {
        // Print "Hello, World!" using a function
        printMessage();

        // Read names from a file
        const std::string filename = "names.txt";
        std::vector<std::string> names = readNamesFromFile(filename);

        // Create a vector of Greeter objects using names from the file
        std::vector<Greeter> greeters;
        for (const auto& name : names) {
            greeters.emplace_back(name);
        }

        // Use a lambda function to greet each person in the vector
        auto greetAll = [](const std::vector<Greeter>& greeters) {
            for (const auto& greeter : greeters) {
                greeter.greet();
            }
        };

        // Greet all using the lambda function
        greetAll(greeters);

        // Print the names using a template function
        std::cout << "Names read from file: ";
        printContainer(names);

    } catch (const std::exception& ex) {
        std::cerr << "Error: " << ex.what() << std::endl;
        return 1;
    }

    return 0;
}
