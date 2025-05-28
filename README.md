# 📚 Library Management System

A comprehensive Java-based library management system that supports multiple book genres with advanced search, filtering, and management capabilities. Built with object-oriented principles and robust exception handling.

![Library Management System Diagram](docs/images/Library%20Management%20System%20-%20Diagram.png)

## 🌟 Features

- **Multi-Genre Book Support**: 7 different book types (Biography, Detective, Fantasy, Historical, Horror, Science Fiction, Romance)
- **Advanced Search & Filtering**: Search by library code, author, category, and combined criteria
- **Complete Book Management**: Add, remove, update, and list books with validation
- **Unique Library Codes**: Auto-generated timestamp-based unique identifiers for each book
- **Comprehensive Validation**: Input validation for all book attributes with detailed error messages
- **Interactive Console Interface**: User-friendly command-line interface with menu system
- **Robust Exception Handling**: Try-catch blocks throughout with graceful error recovery
- **Sample Data**: Pre-loaded books for immediate testing and demonstration

## 🏗️ Complete Project Structure

```
library-manager/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── murat/
│                   └── library/
│                       ├── Book.java                    # Abstract base class for all books
│                       ├── LibraryManager.java          # Main library collection management
│                       ├── LibraryApp.java              # Console application entry point
│                       ├── genres/                      # Book genre implementations
│                       │   ├── BiographyBook.java       # Biography books with subject info
│                       │   ├── DetectiveBook.java       # Detective/mystery books
│                       │   ├── FantasyBook.java         # Fantasy books with magic levels
│                       │   ├── HistoricalBook.java      # Historical books with era/region
│                       │   ├── HorrorBook.java          # Horror books with scare levels
│                       │   ├── ScienceFictionBook.java  # Sci-fi books with tech levels
│                       │   └── RomanceBook.java         # Romance books with romantic levels
│                       └── utils/                       # Utility classes for validation
│                           ├── AuthorUtils.java         # Author-specific validation utilities
│                           ├── BookUtils.java           # General book validation utilities
│                           └── LibraryUtils.java        # Library operation utilities
├── docs/
│   └── images/
│       └── Library Management System - Diagram.png     # UML class diagram
└── README.md                                           # This comprehensive documentation
```

## 🚀 Getting Started

### Prerequisites

- **Java 17 or higher** (JDK with java.time support)
- **IDE** (IntelliJ IDEA, Eclipse, VS Code with Java extension)
- **Git** for version control
- **Terminal/Command Prompt** for compilation and execution

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/library-manager.git
   cd library-manager
   ```

2. **Create output directory**
   ```bash
   mkdir out
   ```

3. **Compile all Java files**
   ```bash
   javac -d out src/main/java/com/murat/library/*.java src/main/java/com/murat/library/genres/*.java src/main/java/com/murat/library/utils/*.java
   ```

4. **Run the application**
   ```bash
   java -cp out com.murat.library.LibraryApp
   ```

### Alternative IDE Setup

1. Import project into your preferred IDE
2. Set source folder to `src/main/java`
3. Run `LibraryApp.java` main method

## 📖 Comprehensive Usage Guide

### Main Menu System

The application presents an interactive menu system:

```
----- LIBRARY MANAGEMENT SYSTEM -----
1. Add a book
2. Remove a book
3. List all books
4. Find book by library code
5. Filter books by category
6. Filter books by author
7. Advanced search
8. Update book
0. Exit
Enter your choice:
```

### Book Types & Specific Attributes

#### 1. Biography Books
- **Subject Name**: Name of the person the biography describes (no digits allowed)
- **Birth Year**: Subject's birth year (realistic historical range)
- **Death Year**: Subject's death year (-1 for living person, 0 for unknown)

#### 2. Detective Books
- **Mystery Level**: Puzzle complexity level (1-10 scale)
- **Sub-Genre**: Detective story type (e.g., "police procedural", "cozy mystery", "noir")

#### 3. Fantasy Books
- **Sub-Genre**: Fantasy category (e.g., "epic fantasy", "urban fantasy", "dark fantasy")
- **Fantasy Level**: Magical intensity and complexity (1-10 scale)

#### 4. Historical Books
- **Era Start Year**: Historical period beginning (flexible format: "1066", "Ancient Rome")
- **Region**: Geographical area or empire (e.g., "Europe", "Byzantine Empire", "Global")

#### 5. Horror Books
- **Sub-Genre**: Horror category (e.g., "psychological", "supernatural", "slasher")
- **Scare Level**: Frightening intensity (1-10 scale)

#### 6. Science Fiction Books
- **Sub-Genre**: Sci-fi category (e.g., "space opera", "cyberpunk", "time travel")
- **Scientific Level**: Technical complexity and realism (1-10 scale)

#### 7. Romance Books
- **Sub-Genre**: Romance category (e.g., "contemporary", "historical", "paranormal")
- **Romantic Level**: Romantic intensity and content level (1-10 scale)

### Advanced Operations

#### Search Functionality
- **By Library Code**: Exact match search using unique book codes
- **By Category**: Case-insensitive category filtering
- **By Author**: Case-insensitive author name filtering
- **Advanced Search**: Combine author, category, and page count criteria

#### Update Operations
- Modify any book attribute (title, author, category, page count)
- Update borrowing information (borrowed date, return date)
- All updates include validation and error handling

## 🏛️ Detailed Architecture

### Core Classes

#### Book (Abstract Base Class)
```java
public abstract class Book {
    // Common attributes for all books
    protected String libraryCode;
    private String title, author, category;
    private int pageCount;
    private LocalDate borrowedDate, returnDate;
    
    // Common methods
    public String getLibraryCode();
    protected void setLibraryCode(String libraryCode);
    // Getters and setters with validation
    public abstract String toString();
}
```

#### LibraryManager (Collection Management)
```java
public class LibraryManager {
    private static final List<Book> catalog = new ArrayList<>();
    
    // CRUD operations
    public void addBook(Book book);
    public boolean removeBook(String libraryCode);
    public Book findBookByTitle(String title);
    public void listBooks();
    public List<Book> getCatalog();
}
```

#### LibraryApp (User Interface)
```java
public class LibraryApp {
    public static void main(String[] args);
    public static void initializeSampleBooks(LibraryManager manager);
    // Menu handling methods for each operation
}
```

### Genre Implementation Classes

Each genre class extends `Book` and implements:
- **Unique Library Code Generation**: Timestamp + random + counter pattern
- **Genre-Specific Attributes**: Specialized fields for each book type
- **Validation**: Input validation using utility classes
- **toString() Override**: Comprehensive book information display

### Utility Classes

#### AuthorUtils
```java
public class AuthorUtils {
    public static int validateBirthYear(int year);
    public static int validateDeathYear(int birthYear, int deathYear);
}
```
- Validates birth years (cannot be future, cannot be negative)
- Validates death years (logical relationship to birth year)
- Exception handling with user-friendly error messages

#### BookUtils
```java
public class BookUtils {
    public static String validateBasicText(String input, String fieldName);
    public static String validateNameText(String input, String fieldName);
    public static int validatePageCount(int pageCount);
    public static int validateLevel1to10(int level);
}
```
- Text validation (empty, null, digit constraints)
- Page count validation (1-10,000 range)
- Level validation (1-10 scale for intensity ratings)

#### LibraryUtils
```java
public class LibraryUtils {
    public static void findBookByCode(LibraryManager manager, String libraryCode);
    public static void filterByCategory(LibraryManager manager, String category);
    public static void filterByAuthor(LibraryManager manager, String author);
    public static void advancedSearch(LibraryManager manager, String author, String category, int maxPageCount);
    public static void updateBookByCode(LibraryManager manager, String libraryCode);
}
```
- Advanced search and filtering operations
- Book update functionality with validation
- User interaction handling for complex operations

## 🔍 Search & Filter Capabilities

### Basic Search Operations
- **Library Code Search**: Exact match using unique identifiers
- **Category Filtering**: Display all books in specific genre
- **Author Filtering**: Show all books by particular author

### Advanced Multi-Criteria Search
Combine multiple search parameters:
- **Author Name**: Case-insensitive partial matching
- **Category**: Case-insensitive exact matching  
- **Page Count Limit**: Books with pages ≤ specified maximum

### Update System
- **Field-by-Field Updates**: Modify individual book attributes
- **Date Management**: Update borrowing and return dates
- **Validation Integration**: All updates go through validation pipeline

## 🛡️ Comprehensive Validation System

### Universal Book Validation
- **Title**: Non-empty, non-null strings
- **Author**: Non-empty, non-null, no digits allowed
- **Page Count**: Range 1-10,000 pages
- **Category**: Non-empty, non-null, no digits allowed

### Date Validation Logic
- **Borrowed Date**: Cannot be in future
- **Return Date**: Cannot be in past, must be after borrowed date
- **Null Handling**: Both dates can be null for available books

### Genre-Specific Validation
- **Intensity Levels**: All 1-10 scale ratings validated
- **Birth/Death Years**: Logical historical validation
- **Subject Names**: Biography subjects cannot contain digits
- **Sub-Genres**: Text validation for all genre categories

### Exception Handling Strategy
- **Try-Catch Blocks**: Comprehensive exception catching
- **User-Friendly Messages**: Clear error explanations
- **Graceful Recovery**: Application continues after validation failures
- **Input Retry**: Users can correct invalid inputs

## 🎯 Unique System Features

### Auto-Generated Library Codes

Each book type generates unique codes with specific prefixes:

| Book Type | Code Format | Example Output |
|-----------|-------------|----------------|
| Biography | `BK-B{timestamp}-{random}-{counter}` | `BK-B20241205143022123-042-17` |
| Detective | `BK-D{timestamp}-{random}-{counter}` | `BK-D20241205143022456-178-18` |
| Fantasy | `BK-F{timestamp}-{random}-{counter}` | `BK-F20241205143022789-293-19` |
| Historical | `BK-HI{timestamp}-{random}-{counter}` | `BK-HI20241205143022012-456-20` |
| Horror | `BK-H{timestamp}-{random}-{counter}` | `BK-H20241205143022345-789-21` |
| Science Fiction | `BK-S{timestamp}-{random}-{counter}` | `BK-S20241205143022678-012-22` |
| Romance | `BK-R{timestamp}-{random}-{counter}` | `BK-R20241205143022901-345-23` |

### Pre-Loaded Sample Data
The application initializes with sample books:
- **"Steve Jobs"** by Walter Isaacson (Biography)
- **"A Brief History of Time"** by Stephen Hawking (Science Fiction)
- **"Guns, Germs, and Steel"** by Jared Diamond (Historical)

### Code Generation Components
- **Timestamp**: `yyyyMMddHHmmssSSS` format (17 digits)
- **Random Component**: 3-digit random number (000-999)
- **Counter**: Thread-safe atomic integer increment

## 🔧 Technical Implementation Details

### Design Patterns Applied
- **Inheritance Hierarchy**: Book as abstract base class
- **Static Factory Methods**: Library code generation
- **Utility Pattern**: Separated validation and operation logic
- **Singleton-like Pattern**: Static catalog in LibraryManager

### Core Technologies
- **Java SE 17+**: Modern Java features and syntax
- **java.time.LocalDate**: Robust date handling
- **java.util.concurrent.AtomicInteger**: Thread-safe counters
- **java.util.ArrayList**: Dynamic book collection
- **java.util.Scanner**: Console input handling

### Exception Handling Architecture
- **Multi-Level Validation**: Input, business logic, and persistence layers
- **Specific Exception Types**: IllegalArgumentException, DateTimeParseException
- **User Experience Focus**: Clear error messages and recovery options

## 📊 Code Examples

### Creating and Adding Books

```java
// Biography Book Example
BiographyBook biography = new BiographyBook(
    "The Autobiography of Benjamin Franklin",  // title
    "Benjamin Franklin",                       // author
    320,                                      // page count
    "Biography",                              // category
    LocalDate.of(2024, 12, 1),              // borrowed date
    LocalDate.of(2024, 12, 15),             // return date
    "Benjamin Franklin",                      // subject name
    1706,                                     // birth year
    1790                                      // death year
);

// Detective Book Example
DetectiveBook detective = new DetectiveBook(
    "The Murder of Roger Ackroyd",           // title
    "Agatha Christie",                       // author
    312,                                     // page count
    "Detective",                             // category
    null,                                    // not borrowed
    null,                                    // no return date
    8,                                       // mystery level (1-10)
    "Classic Whodunit"                       // sub-genre
);

// Adding to library
LibraryManager manager = new LibraryManager();
manager.addBook(biography);
manager.addBook(detective);
```

### Search Operations

```java
// Search by library code
LibraryUtils.findBookByCode(manager, "BK-B20241205143022123-042-17");

// Filter by category
LibraryUtils.filterByCategory(manager, "Biography");

// Advanced search
LibraryUtils.advancedSearch(manager, "Agatha Christie", "Detective", 400);
```

## 🤝 Contributing Guidelines

### Getting Started
1. **Fork** the repository on GitHub
2. **Clone** your fork locally
3. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
4. **Make** your changes following code standards
5. **Test** your changes thoroughly
6. **Commit** with descriptive messages
7. **Push** to your feature branch
8. **Submit** a Pull Request

### Code Standards
- **Java Conventions**: Follow standard Java naming and formatting
- **Javadoc**: Document all public methods and classes
- **Exception Handling**: Include proper try-catch blocks
- **Validation**: Validate all user inputs
- **Testing**: Test edge cases and error conditions

### Pull Request Process
- Describe changes clearly in PR description
- Include code examples if adding new features
- Ensure all existing functionality still works
- Add unit tests for new functionality where applicable

## 🐛 Known Issues & Limitations

### Current Limitations
- **No Persistence**: Data is lost when application exits
- **Date Format**: Requires yyyy-MM-dd format for date input
- **Memory Only**: Books stored in memory, not database
- **Single User**: No multi-user support or user authentication
- **No File Export**: Cannot export book lists to files

### Planned Improvements
- Database integration for persistent storage
- GUI interface using JavaFX
- File import/export capabilities (CSV, JSON)
- User management system
- Book reservation system
- ISBN validation and integration
- Cover image support

## 🚀 Future Enhancement Roadmap

### Phase 1: Data Persistence
- [ ] SQLite database integration
- [ ] Data migration utilities
- [ ] Backup and restore functionality

### Phase 2: User Interface
- [ ] JavaFX GUI application
- [ ] Web interface with Spring Boot
- [ ] Mobile-responsive design

### Phase 3: Advanced Features
- [ ] ISBN validation and book lookup
- [ ] Book cover image management
- [ ] Email notifications for due dates
- [ ] Report generation (PDF, Excel)
- [ ] Barcode scanning support

### Phase 4: Enterprise Features
- [ ] Multi-user support with authentication
- [ ] Role-based access control
- [ ] Audit logging
- [ ] API for external integrations
- [ ] Cloud deployment support

## 📄 License & Legal

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for complete details.

### MIT License Summary
- ✅ Commercial use permitted
- ✅ Modification permitted
- ✅ Distribution permitted
- ✅ Private use permitted
- ❌ No warranty provided
- ❌ No liability accepted

## 👨‍💻 Author & Credits

**Murat** - *Project Creator and Lead Developer*
- Initial architecture design
- Complete implementation
- Documentation and testing
