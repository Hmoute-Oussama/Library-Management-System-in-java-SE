# Library Manager

A small Java console app for managing a library's books.

## Features

- Add, list, search, and delete books
- Reserve a book and mark it as returned

## Requirements

- Java JDK (with `javac` and `java` available on your PATH)

## Run

From the project root, compile the source files and start the app:

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\library\*.java
java -cp out src.library.Main
```

Follow the numbered menu in the console. Enter `0` to exit.
