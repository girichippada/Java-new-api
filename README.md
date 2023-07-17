# JDK New Features
This Demonstrates some major Java New Features starting from Java 9 to Java 17 and later versions!

Java 9 Features:
1. Factory methods in Collections: of method for List, Set, and map: List.of(varargs)
2. G1 Garbage Collector: The default GC from Jdk 9 onwards
3. Compact Strings: Uses byte[] to store stings instead of char[] as in most of the java apps, strings uses 1 byte or 8 bits to improve heap consumption
4. Modular system: Java Modules - To restrict or specify what classes to export and what not to export in jars to avoid internal classed to be exposed
5. Allow @SafeVargs on private instance methods. E.g., https://www.tutorialspoint.com/safevarargs-annotation-for-private-methods-in-java-9#:~:text=The%20%40SafeVarargs%20annotation%20was%20introduced,operations%20on%20its%20varargs%20parameters.
6. Allow effectively final variables to be used as resources in the try-with-resources statement.
7. Allow the diamond("<>") with anonymous classes if the argument type of the inferred type is denotable.
8. Complete the removal, begun in Java SE 8, of the underscore from the set of legal identifier names.
9. Add support for private interface methods.
   

Reference: https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346



