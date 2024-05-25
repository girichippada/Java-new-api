# JDK New Features
This Demonstrates some major Java New Features starting from Java 9 to Java 17 and later versions!

## Java 9:

1. **Introduction of Reactive Streams**: [Reactive Streams](https://en.wikipedia.org/wiki/Reactive_Streams) is an initiative to provide a standard for asynchronous stream processing with non-blocking back pressure. For further read, see [project reactor](https://projectreactor.io/docs/core/release/reference/) implementations: Reactor is a fully non-blocking reactive programming foundation for the JVM, with efficient demand management (in the form of managing “backpressure”). It integrates directly with the Java 8 functional APIs, notably CompletableFuture, Stream, and Duration. It offers composable asynchronous sequence APIs — Flux (for [N] elements) and Mono (for [0|1] elements) — and extensively implements the Reactive Streams specification. The reactor also supports non-blocking inter-process communication with the reactor-netty project. Suited for Microservices Architecture, Reactor Netty offers backpressure-ready network engines for HTTP (including Websockets), TCP, and UDP. Reactive encoding and decoding are fully supported. Additionally, see [Spring webFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html) that has a framework for using reactive streams in spring boot applications. [Here is a quick tutorial](https://dassum.medium.com/building-a-reactive-restful-web-service-using-spring-boot-and-postgres-c8e157dbc81d)
2. **Factory methods in Collections**: 'of' method for List, Set, and map: <code>List.of(varargs)</code>
3. **G1 Garbage Collector**: The default GC from JDK 9 onwards
4. Compact Strings: Uses <code>byte[]</code> to store stings instead of <code>char[]</code> as in most of the java apps, strings use 1 byte or 8 bits to improve heap consumption
5. Use **<code>jdeps</code>** tool to analyze the Java app dependencies and it also suggests replacements for any JDK internal API usage
6. Use **<code>jlink</code>** using <code>jlink</code> module descriptor or a custom <code>module-info.class</code> file to create a custom run time Java image of our modular applications
7. **<code>jShell</code>** - A Java command line tool for developers to use a shell to try any Java code without having to create a class and main method
8. introduction of allowing **private default methods in interfaces**
9. **<code>takeWhile</code>** method for collections API to do an operation only until a condition is satisfied
10. **<code>dropWhile</code>** method added in collections API to drop elements until a condition is satisfied i.e., exclude elements until a condition is satisfied
11. new overloaded **<code>iterate</code> method to Collection** to iterate a collection until a condition is satisfied
12. **<code>Stream.ofNullable()</code>** method added to return an empty stream if a value of an element of a stream is null
13. **Modular system**: Java Modules - To restrict or specify what classes to export and what not to export in jars to avoid internal classes being exposed
14. Allow **<code>@SafeVargs</code> on private instance methods**. E.g., https://www.tutorialspoint.com/safevarargs-annotation-for-private-methods-in-java-9#:~:text=The%20%40SafeVarargs%20annotation%20was%20introduced,operations%20on%20its%20varargs%20parameters.
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
   2. specifically for local variable declarations and try with resource variable declarations
   3. Not allowed for catch block, method parameter types, instance, or static variables as the type of those variables cannot be derived
   4. Should follow the style guide as using var for all local variables doesn't improve code readability
2. **copyOf method** introduced for the list, set, and map interfaces for the ability to copy the immutable copy of the collection
     1. The unmodifiableXXX() method returns an unmodifiable view where if the source collection is changed, then the copied collection object data will be changed
     2. the copyOf collection object values won't change if the source collection object is changed
3. **orEleThrow()** introduced in Optional class to ease of throwing an exception when we don't have a value of an optional object so we can replace: <code>if(optionalObj.isPresent()) return optionalObj.get();}</code> with <code> return optionalObj.orElseThrow() </code>
4. **Class Data sharing(CDS):** to enable the creation of a shared archive file of classes that can be reused by other JVM instances to improve the startup time of JVM
5. **Application Class Data Sharing(App CDS)**: To allow the creation of shared archive files of application-specific or third-party classes that can be used by other JVM instances to improve the startup time of JVM
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

1. **<code>HttpClient</code>:** To replace existing HttpURLConnection API which provides a builder pattern to make HttpRequests using sync and async methods.
      1. Incubated in JDK 9 but standardized in JDK 11
      2. Compact API which supports Http1.1 and Http1.2
      3. Supports both sync and async execution
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
8. **Removal of out of the box JAVA EE and Corba Modules:** Couple of modules out of the box provided in Java se are evolved as third-party libraries or dependencies in Maven central. Hence Java team decided to remove these modules and the applications using these modules must add the dependencies explicitly in the maven or gradle.
   1. **JAXB**: The module was removed and the replacement is Jakarta as JAVA EE handed over from Oracle to Eclipse foundation
   2. **JAX-WS**
   3. **JAF(Java activation framework)**
   4. **java.se.ee**
   5. **JTA(java.transaction)(JAVA Transaction API)**
   6. **java.xml.ws.annotation**
   7. **CORBA(java.corba)**
9. **Dropped support for Applets:** Because of security issues at runtime, most of the browser vendors dropped support for browser-based Applets hence Java team decided to remove it
10. **Nashorn deprecated and will be removed**: challenges in maintainance. alternative is GralVM
11. **JavaFX moved to openJFX**: JavaFX will not be bundled along with JDK starting from JDK 11 and will be available in OpenJFX: https://openjfx.io/
12. **Single file source code file:** no need to use javac to compile. can be used directly with the java command which compiles in in-memory for single source files
13. **Files.readString and Files.writeString:** methods introduced to read file data as a string and write a string to file respectively. readString and writeString methods read and write whole file data at once. if we are dealing with large files, consider using Files.lines method e.g., <pre>Files.lines(Paths.get(FILE_PATH);</pre>
14. **Predicate.not:** predicate.not method is introduced to do a negate in a readable way. E.g., <pre>line.filter(Predicate.not(String::isBlank).collect(Collectors.toList());</pre>
15. **Flight Recorder:** To start the Flight recorder, use the command: <pre>java -XX:StartFlightRecording=duration=60s,filename=recording.jfr APP </pre>. To start flight recording for already running jvm, first run: jcmd and get the PID. then, <pre>jcmd <PID> JFR.start duration=60s filename=recording.jfr</pre>
16. **JDK Mission Control:** Can be used to visualize jfr files data

## Java 12:

1. **Compact Number Formatting:** To represent numbers in compact form like 1k for 1000, 1M for 1 million, etc, we can do so by
   <pre>
      NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.style.SHORT);
      fmt.format(1000); //1K 
   </pre>
2. ***teeing collector:** Provides the ability to multiple collectors for a stream and merge the result. for e.g.,
   <pre> 
      List<String> input = List.of("Learning", "Java 12", "Features"); 
         input.stream(Collectors.teeing(Collectors.joining(" "), Collectors.counting(), Statistics::new //passes two collectors data to the merged instance); 
      </pre>
3. **<code>Files.mismatch</code>:** Files.mismatch method introduced to compare two files data. if both file contents are equal, then -1 will be returned. if both file sizes are the same but some mismatch in data, then the first mismatch byte position will be returned. if there is a mismatch in file size then the file having a small size is returned
4. **Shenandoah Garbage Collector Introduced:** Most concurrent GC with low GC pause time. experimental feature
5. **indent method introduced in String class:** add n no of spaces to do indentation for each line. <code>input.indent(4);</code>
6. **transform method introduced in String class:** applies a transformation to a string using a lambda function or a method reference. E.g.,
   <pre>
      inout.transform(String::toUpperCase).transform(str -> str.replace("\\W+", "-"));
   </pre>
7. **Introduction of Java Microbenchmark Harness (JMH):** JMH is developed as a separate project for benchmarking the Java code. When writing code with JMH annotations: @Benchmark, JMH runs the code in n (5 by default) of JVMs and n(5 by default) no of iterations for each JVM and produces results for each benchmark method. The higher the score, the better the performance. Very useful for performance-critical areas of the code.
Refer [this for how to setup](/java12/JMH_Setup.txt)

## Java 13:
1. Reimplementation of **Legacy Socket API** in JDK 13 to replace **java.net.Socket & java.net.ServerSocket**
2. Issues with Legacy Socket API: Difficult to maintain and a lot of concurrency issues
3. The new implementation is **NioSocketImpl**- easy to maintain, debug and also future proof
4. It uses Concurrent locking instead of synchronization
5. better compatibility with Project Loom
6. **Dynamic CDK Archives**: Allows to generate CDK archives for built-in class loaders and user-defined class loaders
7. **TextBlocks**: Preview feature: Allows to write multi-line strings without having escape characters and provides more readable code
8. **stripIndent** method added to String Class: Allows incidental white spaces and indents the string. especially useful JSON strings
9. **translateEscapes** method added to String Class: Allows to remove all escape characters in the string and hence helps to produce readable multi-line string which has escape characters in it:
   <pre>
      inputString
         .filter(Predicate.not(String::isEmpty))
         .map(String.translateEscapes)
         .collect(Collectors.groupingBy(String::length));
   </pre>
10. **formatted** method added to String Class: Helps to format the text blocks string
11. **switch Expression** Enhanced Preview feature: replaced break with yield when we need to return for a case in switch if it has more than 1 line in that case
12. **Enhancements to Z Garbage Collector**: returns the unused memory to the OS of the host. uncommit capability enabled by default. performance improvement made

## Java 14:
1. **Switch Expressions**: made generally available with yield keyword introduction from JDK 13
2. **HelpfulNullPointerExceptions**: Writes helpful additional information to the log for NullPointerExceptions and denotes exactly it caused by which field exactly caused it
3. **Records**: A preview feature: that helps to model data as data by automatically generating required methods for POJO classes that are just data carriers for example DTO classes
4. **pattern matching for instanceof**: enables to create pattern matching variable when checking the object type using instanceof keyword:
   <pre>
      if(object instanceof String result){
         System.out.println(result.toUpperCase());
      }else if(object instanceof Date result){
         System.out.println(result.getTime());
      }
   </pre>
   is a replacement for:
   <pre>
      if(object instanceof String){
         String result = (String) object;
         System.out.println(result.toUpperCase());
      }else if(object instanceof Date){
         Date result = (Date) object;
         System.out.println(result.getTime());
      }
   </pre>

## Java 15:
1. **Records**: made generally available: Records are data carrier that extends Record class internally. All instance variables are final by default. out of the box provides the implementation of toString. equals and hashCode methods and provides read-only access to variables using out of box created methods based on record variables
2. **Sealed classes introduced**
## Java 16:
1. Records can be used to replace DTO classes where just carrying the state is the requirement but not having any functionality
2. Records can be used in Stream operation and can be useful if needed to return multiple elements from a single stream operation. For ex., to find both min and max profit products in a stream operation
3. local records can be created. i.e., records can be created in a method or in a class which will be local visibility to that method or the class where created
4. records can implement an interface but cannot extend a class
5. **mapMulti introduced in stream api**: Useful for working on one to many objects in a stream operation where we generally use flatMap. The advantage with mapMulti is it doesn't create a new stream for each element in the stream operation unlike flatMap and it just collects the objects instead:
   <pre>
   List<String> famousMovieCast = </String>movies.stream()
      .filter(movie -> movie.name().equals("famous first movie")
      .<String>mapMulti((movie, consumer) -> {
         List<Cast> cast: movie.getCast();
         for(String: actor: cast){
            consumer.accept(actor);
         }
      }).toList();
   </pre>
   with compared to flatMap way:
   <pre>
   List<String> famousMovieCast = movies.stream()
      .filter(movie -> movie.name().equals("famous first movie")
      .flatMap(movie -> movie.cast().stream()
      .toList();
   </pre>
6. **toList method added to Stream API**: can be useful to replace .collect(Collectors.toList()). **returns an immutable list** where the collect method toList is not immutable
7. **pattern matching variable support added to instanceof keyword**: eliminates the need of creating variable by casting inside instanceof condition
   <pre>
      if(value instanceof String s){
         log.info("{} value is of type String", s);
      }
   </pre>

   is compared to earlier:
   <pre>
      if(value instanceof String){
         String s = (String) value;
         log.info("{} value is of type String", s);
      }
   </pre>
8. **Interface can be sealed**: A sealed keyword can be used for interfaces and allow permit to implement selected classes in the interface declaration. That way, the interface access is restricted but has the option to allow implementation to be done by specified classes only
9. **Stong encapsulation to JDK internals using JDK 9 modular system:**: Allowing access to JDK internals is denied by default starting from JDK 16
10. **jpackage command introduced**: can be useful for packaging self-contained java applications. for example, desktop Java applications or command-line Java applications. generate the executable file specific to the host operating system

## Java 17:
1. **Sealed classes made generally available**: [Sealed Classes](https://openjdk.org/jeps/409) feature is about enabling more fine-grained inheritance control in Java. Sealing allows classes and interfaces to define their permitted subtypes. In other words, a class or an interface can now define which classes can implement or extend it. It is a useful feature for domain modeling and increasing the security of libraries.
2. **--illeagal-access jvm option is removed**: --illeagal-access option allows to access jdk internals which can use security and code maintainability issues. Hence, removed in JDK 17
3. **deprecated for removal**: SecurityManager, AppletAPI(as support from browser vendors removed), RMi Activation
4. **Pattern matching for Switch: A preview feature**: Allows to use case elevel variables without having to check for instanceof and casting the variables before accessing


References: 
https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346
https://openjdk.org/projects/jdk/17/
https://openjdk.org/projects/jdk/

# **Next Big things:**
1. Project Loom: https://openjdk.org/projects/loom/      :    https://developer.okta.com/blog/2022/08/26/state-of-java-project-loom
2. Project Valhalla: https://openjdk.org/projects/valhalla/



