package com.gr.java15;

//Example of TextBlock.
public class TextBlocks {

    public static void main(String... args) {

        //Text block is a String.
        textBlockIsAString();

        //html as text block.
        System.out.println("Html As text block:");
        htmlAsTextBlock();

        //xml as text block.
        System.out.println("XML As text block:");
        xmlAsTextBlock();

        //Json as text block
        System.out.println("JSON As text block:");
        jsonAsTextBlock();
        //formatting text blocks

        //interpolation in text block.
        System.out.println("Formatting/Interpolation in a text block:");
        interpolate();

        //Changes in JDK14.
        System.out.println("Added in JDK 14:");
        printOnSingleLineButReadMultiline();
        maintainSpace();

        System.out.println("Display XML:");
        displayXML();
    }


    public static void textBlockIsAString() {

        String name = "J.R.R. Tolkein";
        System.out.println(name);

        //Syntax
        //How to represent a multi-line string without that final \n ?
        String nameTextBlock = """
                J.R.R. Tolkein
                """;

        System.out.println(nameTextBlock);

        System.out.println("String of same value : " + name.equals(nameTextBlock));

        //Intern
        System.out.println(name == nameTextBlock);

        //String methods on text block.
        System.out.println(nameTextBlock.contains("." ));
    }

    public static void htmlAsTextBlock() {

        //Incidental white space,newline characters.
        String html = ""
                + "    <html>\n"
                + "      <body>\n"
                + "        <p style=\"color:red;\">Hello Java</p>\n"
                + "      </body>\n"
                + "    </html>\n";

        System.out.println(html);

        String htmlTB = """
                <html>
                  <body>
                    <p style="color:red;">Hello Java</p>
                  </body>
                </html>
                """;
        System.out.println(htmlTB);

    }

    public static void xmlAsTextBlock() {
        String foodMenu = ""
                +"           <breakfast_menu>\n"
                +"             <food id=\"1\">\n"
                +"               <name>Belgian Waffles</name>\n"
                +"               <price>$5.95</price>\n"
                +"             </food>\n"
                +"           </breakfast_menu>\n";
        
        System.out.println(foodMenu);

        String foodMenuTB = """
                <breakfast_menu>
                  <food id="1">
                    <name>Belgian Waffles</name>
                    <price>$5.95</price>
                  </food>
                </breakfast_menu>  
                """;
        System.out.println(foodMenuTB);
    }

    public static void jsonAsTextBlock() {

        String customerJson = ""
                +"      {\n"
                +"        \"id\" : \"1234\",\n"
                +"        \"firstName\" : \"Jack\",\n"
                +"        \"lastName\" : \"Sparrow\"\n"
                +"      }\n";

        System.out.println(customerJson);

        String customerJsonTB = """
                {
                  "id" : "1234",
                  "firstName" : "Jack",
                  "lastName" : "Sparrow"
                }
                """;
        System.out.println(customerJsonTB);
    }

    public static void interpolate() {
        String html = """
                <html>
                    <head>
                        <title>%s</title>
                    </head>
                    <body>
                    <h1>%s</h1>
                    </body>
                </html>
                """.formatted("Text Blocks", "hello, text blocks!!!");
        
        System.out.println(html);
    }

    public static void printOnSingleLineButReadMultiline() {

        //Use \ (line terminator)
        var data = """
                This is supposed \
                to be on \
                a single line and \
                hence we are adding \
                a line break which \
                will be removed by \
                the compiler. \
                """;
        System.out.println(data);

    }

    public static void maintainSpace() {

        //Use \s "Explicit space"
        var data = """
                ----------
                    ()  \s
                   (  ) \s
                  (    )\s
                ----------
                """;
        System.out.println(data);
    }


    public static void displayXML() {
        System.out.println("""
                <breakfast_menu>
                  <food id="1">
                    <name>Belgian Waffles</name>
                    <price>$5.95</price>
                  </food>
                </breakfast_menu>
                """);
    }
 }