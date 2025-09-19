# Library-Management-System

Requirements
- Borrow Book
- Return books
- Search books by title, author or ISBN
- Keep track of books borrowed by patrons
- Add , remove and update books in library
- Add, remove patrons of the library
- Check book inventory
- Add, remove branches of library
- Transfer books between library
- Reserve and unreserve book
- Notify when book available

Entities
- Library system
- Branch
- Book
- Patron
- Lending
- Reservation

Library System
- Name
- List<branch>
- List<pateron>
—----------------------------------
+ Add branch 
+ remove branch
+ Add Patron
+ Remove Patron

Branch
- Name
- ID
- Address
- List<Books>
—----------------------------------
+ Add book
+ Remove book
+ Search book
+ Transfer book

Book
- ISBN
- Title
- Author
- Status
- reservation

Patron
- Name
- ID
- Joining date
- List<Lending>

Lending
- Lending id
- Book
- Patron
- Checkout Date
- dueDate
- Return date
—----------------------------------
+ Borrow book
+ Return book

Reserve
- Reserve id
- Book
- patron
—----------------------------------
+ Reserve book
+ Cancel reservation
