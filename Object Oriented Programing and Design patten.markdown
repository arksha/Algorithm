#Object Oriented Programing and Design patten 
Based on C++

##OOD is a design discipline 
by managing interdependencies between modules. OO just introduce abstraction between modules,like add walls between each modules, so it will make world much more neat!

Encapusulation: hide internal details  
Interfaces: expose operations

Class: is a specification of an object  
Object: is an instance of a class

##main():  
  int main() {}  
  int main(int argc, char* argv[]) {}

##namespaces std:  
prevent name collisions, standard library called std.  
three ways to refer to objects in namespace: use fully qualified name, use a using declairation, use a using directive(use this a lot)  

##Class Organization:  
have class definitions with only member function declearations in a header file, member function implementation in a separate source code file.  
Include guard #ifndef AAA\_H #define AAA\_H #endif  

###Constructors:
guarantee objects are initialized when created.  
overloaded: signature = name + paramlist + constness  
one constructors cannot call other constructor.  
member initialization list:  
  Account::Account(Money a):balance(a) {}
  
###Destructors:
to clean up before object is destroyed.  

##The Development cycle:  
Start-> write a test for new capability -> complie -> fix compile errors -> run test to see if fail -> write the code -> run the test and see it pass -> refactor as needed  

##Dynamic Memory Allocation:  
scope and lifetime: scope is a region of a program where variable names are visible. Including block scope, function scope,internal file scope, external scope and class struct scope. 

automatic variables: called constructors when defined. reside in a region of memory known as the stack.
static and global variables: live during program. Constructors are called before static used and main runs. reside a region of memory known as static data area.  
free-store objects: controlled by programmer, reside in heap. can be created in one function and destoryed much later in another.  

new and delete: new allocate memory on heap , delete return memory back

##Const:
const variables must be initialized.  
const pointers: const is on the right of \* (like int \* const ), means pointer is const; on the left of \*, (like int const* pt) means the thing pointed at is const.  
const member functions: instead of pass by value, pass in a pointer.

##Reference Variable:
is another name for existing variables.  
must initialized and cannot refer anything else once initialized.( int i = 1; int& ri = i;)  

##Pass parameters into functions:
1.by value: okay for small structures or single values.
2.by pointer: if pointer can be null or can be modified to point another object
3.by reference: if target of reference does not change. reference cannot be null and always have to refer something.(const references are most use when pass objects to functions)  

##Class Member:
Static member must be defined, otherwise will results in a linker error.  
Copy constructor: X::X(const X&)
This pointer: Within evey non-static member function, there exists a pointer known as this.

##Exception handling:  throw catch

##Inline functions:
Templates functions: let compiler write code. 

##Type conversions: 
casting this way: int(d), static_cast<int>(d)

##Inheritance:  
Polymorphism:  
Virtual function:  
Abstract class: a class with at least one pure virtual function and cannot be instaniated.

Member initialize list: is more efficitent than assigning values in constructor. class members are initialized in declaration order not initialized list order.

Virtual destructors: 
must be defined for base class

##C++ std:  
Strings: 
Container class:
Iterators: [begin, end)

##Principle of OOD:  
Dependency Management:   
code rot: writtent to specific, high level policy depends on low level implement details, require changes must edited to adjust new one.  
###Property of good design:  
flexible: changes are localized and ramifications are minimal.  
maintainable: modules requiring changes can be identified and changes can be made in their place.    
reusable: modules should be used in other contexts.  

the ideal disign accommodates change by adding new code, not by modifying existing code


Single responsibility principle: a class has single responsibility, does it all well and only.   
Open/Closed principle: modules should be open for extension, but closed for modification. Key for this is abstraction.  
Liskov Substitution principle: define what is-a means.   

##Casting operation:  
dynamic_cast: used to navigate inheritance hierarchy through pointer or reference conversion. 
static_cast: does perform type checking like dynamic_cast.   
const_cast: converts between types that differonly in constness.  
reinterpret_cast: used to reinterpret lowlevel bit pattern. 


