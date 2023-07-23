# JDK New Features
This Demonstrates some major Java New Features starting from Java 9 to Java 17 and later versions!

Java 9 Features:
1. Factory methods in Collections: of method for List, Set, and map: List.of(varargs)
2. G1 Garbage Collector: The default GC from JDK 9 onwards
3. Compact Strings: Uses byte[] to store stings instead of char[] as in most of the java apps, strings use 1 byte or 8 bits to improve heap consumption
4. Use jdeps tool to analyze the java app dependencies and it also suggests replacements for any JDK internal APIs usage
5. Use jlink using jlink module descriptor or a custom module-info file to create a custom run time java image of our modular applications
6. jShell - A Java command line tool for developers to use a shell to tryout any Java code without having to create a class and main method
7. introduction of allowing private default methods in interfaces
8. takeWhile method for collections API to do an operation only until a condition is satisfied
9. dropWhile method added in collections API to drop elements until a condition is satisfied i.e., exclude elements until a condition is satisfied
10. new overloaded iterate method to Collection to iterate a collection until a condition is satisfied
11. Stream.ofNullable() method added to return an empty stream if a value of an element of a stream is null
12. Modular system: Java Modules - To restrict or specify what classes to export and what not to export in jars to avoid internal classes being exposed
13. Allow @SafeVargs on private instance methods. E.g., https://www.tutorialspoint.com/safevarargs-annotation-for-private-methods-in-java-9#:~:text=The%20%40SafeVarargs%20annotation%20was%20introduced,operations%20on%20its%20varargs%20parameters.
14. Enhanced Deprecation support added: @Depreacated(forRemoval = true) to specify a method or class that is marked for removal later. @Depreacted(since ="<version>")
15. jdeprscan command can be used to scan the deprecations in the code
16. Boxed primitive type constructors are deprecated. the alternative is to use valueOf() method. finalize() method in Object is marked as deprecated. Alternatives are java.lang.ref.Cleaner and java.lang.ref.PhantomReference
17. Allow effectively final variables to be used as resources in the try-with-resources statement.
18. Allow the diamond("<>") with anonymous classes if the argument type of the inferred type is denotable.
19. Complete the removal, begun in Java SE 8, of the underscore from the set of legal identifier names.
20. Add support for private interface methods.
   

Reference: https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346



