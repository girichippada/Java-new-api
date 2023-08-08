# JDK New Features
This Demonstrates some major Java New Features starting from Java 9 to Java 17 and later versions!

## Java 9:

1. **Factory methods in Collections**: 'of' method for List, Set, and map: <code>List.of(varargs)</code>
2. **G1 Garbage Collector**: The default GC from JDK 9 onwards
3. Compact Strings: Uses <code>byte[]</code> to store stings instead of <code>char[]</code> as in most of the java apps, strings use 1 byte or 8 bits to improve heap consumption
4. Use **<code>jdeps</code>** tool to analyze the Java app dependencies and it also suggests replacements for any JDK internal APIs usage
5. Use **<code>jlink</code>** using <code>jlink</code> module descriptor or a custom <code>module-info.class</code> file to create a custom run time Java image of our modular applications
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
2. **copyOf method** introduced for the list, set, and map interfaces for the ability to copy the immutable copy of the collection
     1. The unmodifiableXXX() method returns an unmodifiable view where if the source collection is changed, then the copied collection object data will be changed
     2. the copyOf collection object values won't change if the source collection object is changed
3. **orEleThrow()** introduced in Optional class to ease of throwing an exception when we don't have a value of an optional object so we can replace: <code>if(optionalObj.isPresent()) return optionalObj.get();}</code> with <code> return optionalObj.orElseThrow() </code>
4. **Class Data sharing(CDS):** to enable create a shared archive file of classes that can be reused by other JVM instances to improve the startup time of JVM
5. **Application Class Data Sharing(App CDS)**: To allow create shared archive files of application-specific or third-party classes that can be used by other JVM instances to improve the startup time of JVM
      1. Steps: Create a .lst classes list
      2. Create a .jsa dump file of the shared classes list(.lst)
      3. Using App CDS: use the .jsa shared archive file:
6. **Improved container awareness: ** JVM can know if it is running inside a container
     1. To get to know how much memory a JVM is consuming:
          1. docker run -m 100MB openjdk:8u121 java -XshowSettings:vm -version (JDK <10 consuming more heap than allocated for the container)
          2. docker run -m 400MB openjdk:10 java -XshowSettings:vm -version (JDK >=10 consuming heap as per allocated heap size to the container)
          3. Java 8 update 191 has the fix so, if we are using java: openjdk:9u191, it has the fix so can allocate heap size as per container limit
7. **new JVM flag: -XX:Active ProcessorsCount:<count>**: to override no of CPUs for the JVM

## Java 11:

1. **<code>HttpClient</code>:** To replace existing HttpURLConnection API which provides builder pattern to make HttpRequests using sync and async methods.
      1. Incubated in jdk 9 but standardized in jdk 11
      2. Compact API which support Http1.1 and Http1.2
      3. Supports both sync and asyc execution
      4. supports reactive streams
2. **Local variales for lamba parameters:**
      1. can use var for lamba
      2. Can use annotations for lamba params
3. <code>repeat method in string</code>: to repeat a string operation n no of times: <code> "abc".repeat(5) : "abcabcabcabcabcabc"</code>
4. <code>strip method</code>: to remove all possible whitespaces of a string . supports all Unicode of white spaces
5. <code>lines method added to String class</code>: splits by line characters and returns stream of strings: <code> multipleLines.lines(System.out::println);</code>
      1. faster than the split method as it returns a stream
6. **Epsilon GC is introduced:** Epsilon GC is a no-op GC which means it only allocates memory but not reclaims memory. It will terminate JVM when max heap usage is reached.
       1. Useful for performance testing
       2. Useful for ultra latency applications that have sensitive about reserved memory allocation
7. **ZGC is introduced:** ZGC is the most concurrent GC
       1. Most concurrent GC
       2. Max pause time is 10ms
       3. Concurrent collector
       4. Pause time does not increase with the size of the heap
       5. can handle terra bytes of the heap size
       6. experimental in JDK 11 and only released for Linux x86 64-bit platform
8. **Single file source code file:** no need to use javac to compile. can use directly with the java command which compiles in in-memory for single source files
   

   
Reference: https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346



