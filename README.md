# Animal Shelter CLI

![Java](https://img.shields.io/badge/Java-23+-blue)
![License: MIT](https://img.shields.io/badge/License-MIT-green)

A command-line interface (CLI) application to manage an animal shelter. Built in Java and is a part of my learning journey! It demonstrates object-oriented design, enum usage, user input handling, basic data storage and more. New features and such, will be implemented as I slowly expand my knowledge!

---

## Features

- Add animals (Cats & Dogs) with specific attributes
- List all animals with detailed info
- Search animals by specie or adoption status 
- Update animal adoption status
- Remove animals from shelter
- Persistent data storage via JSON files (work in progress)

---

## Technologies Used

- Java 23+
- Enums for animal species, gender, and adoption status
- Java Collections (HashSet, LinkedHashMap)
- Gson for JSON serialization
- CLI user input handling with `Scanner`
- Custom utility and color classes for console output

---

## Getting Started

### Clone the repository

```bash
git clone https://github.com/HeyImSushii/Animal-Shelter-CLI.git
cd Animal-Shelter-CLI
```

### Build and run
```
javac -d bin src/com/lsore/**/*.java
java -cp bin com.lsore.Main
```

### Usage
Follow on-screen prompts to add, list, and manage animals.

---

## Roadmap
 * Improve JSON serialization to support multiple animals in one file.
   * Currently only supports one JSON object.
 * Implement search and filter features 
 * Replace option 5 in the main menu with a submenu for updating animal info (e.g., name, age, adoption status)
 * Implement exception handling and input validation 
 * Implement database integration for scalability
 * Implement unit testing and continuous integration

---

## License

This project is licensed under the MIT License. See the LICENSE file for details.