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
- List<branch>
- List<pateron>
—----------------------------------
+ Add branch 
+ remove branch
+ Add Patron
+ Remove Patron
+ Transfer Book

Branch
- Name
- ID
- Address
- List<Books>
—----------------------------------
+ Add book
+ Remove book
+ Search book

Book
- ISBN
- Title
- Author
- Status
- reserva

Patron
- Name
- ID
- Joining date

Lending
- Lending id
- Book
- Patron
- Checkout Date
- dueDate
- Return date

Reserve
- Reserve id
- Book
- patron

Lending Service
- Lending Record
+ lend Book
+ Return Book

Reservation Service
- Reservation record
+ Reserve Book
+ Cancel Reserve

  <img width="558" height="367" alt="image" src="https://github.com/user-attachments/assets/9445ec22-0e24-4fa4-b1bb-93650ef734e2" />

