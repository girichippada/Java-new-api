# JDK New Features
This Demonstrates some major Java New Features starting from Java 9 to Java 17 and later versions!

## Java 9:

1. **Factory methods in Collections**: 'of' method for List, Set, and map: <code>List.of(varargs)</code>
2. **G1 Garbage Collector**: The default GC from JDK 9 onwards
3. Compact Strings: Uses <code>byte[]</code> to store stings instead of <code>char[]</code> as in most of the java apps, strings use 1 byte or 8 bits to improve heap consumption
4. Use **<code>jdeps</code>** tool to analyze the Java app dependencies and it also suggests replacements for any JDK internal APIs usage
5. Use **<code>jlink</code>** using <code>jlink</code> module descriptor or a custom <code>module-info.class</code> file to create a custom run time java image of our modular applications
6. **<code>jShell</code>** - A Java command line tool for developers to use a shell to tryout any Java code without having to create a class and main method
7. introduction of allowing **private default methods in interfaces**
8. **<code>takeWhile</code>** method for collections API to do an operation only until a condition is satisfied
9. **<code>dropWhile</code>** method added in collections API to drop elements until a condition is satisfied i.e., exclude elements until a condition is satisfied
10. new overloaded **<code>iterate</code> method to Collection** to iterate a collection until a condition is satisfied
11. **<code>Stream.ofNullable()</code>** method added to return an empty stream if a value of an element of a stream is null
12. **Modular system**: Java Modules - To restrict or specify what classes to export and what not to export in jars to avoid internal classes being exposed
13. Allow **<code>@SafeVargs</code> on private instance methods**. E.g., https://www.tutorialspoint.com/safevarargs-annotation-for-private-methods-in-java-9#:~:text=The%20%40SafeVarargs%20annotation%20was%20introduced,operations%20on%20its%20varargs%20parameters.
14.** Enhanced Deprecation support** added: <code>@Depreacated(forRemoval = true)</code> to specify a method or class that is marked for removal later. <code>@Depreacted(since ="<version>")</code>
15. **<code>jdeprscan</code>** command can be used to scan the deprecations in the code
16.** Boxed primitive type constructors are deprecated**. the alternative is to use <code>valueOf()</code> method. <code>finalize()</code> method in Object is marked as deprecated. Alternatives are <code>java.lang.ref.Cleaner</code> and <code>java.lang.ref.PhantomReference</code>
17. **Allow effectively final variables** to be used as resources in the try-with-resources statement.
18. Allow the **diamond("<>") with anonymous classes** if the argument type of the inferred type is denotable.
19. Complete the removal, begun in Java SE 8, of the **underscore** from the set of legal identifier names.
20. Add support for **private interface methods**.

## Java 10:

1. **Dynamic type inference using var for local variables:** Now we can use var for local variables type of those variables will be derived by Java using its assignment on the right side
   1. Allowed for local variables only
   2. specifically for local variable declarations and try with resource variables declarations
   3. Not allowed for catch block, method parameter types, instance, or static variables as the type of those variables cannot be derived
   4. Should follow the style guide as using var for all local variables doesn't improve code readability
2. **copyOf method** introduced for list, set, map interfaces for the ability to copy the immutable copy of the collection
     1. The unmodifiableXXX() method return unmodifiable view where if the souce collection is changed, then the copied collcetion object data will be changed
     2. the copyOf collection object values won't change if the source collection object is changed
3. **orEleThrow()** introduced in Optional class to ease of throwing exception when we don't have a value of an optional object so we can replace: <code>if(optionalObj.isPresent()) return optionalObj.get();}</code> with <code> return optionalObj.orElseThrow() </code>
   
Reference: https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346



