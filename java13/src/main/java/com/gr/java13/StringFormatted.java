package com.gr.java13;

//Example of String.formatted method introduced in JDK 13.
public class StringFormatted {

    public static void main(String[] args) {

        String addressBlock =      "<html>"
                                   +"\n<head></head>"
                                   +"\n<body>"
                                   +"\n  <address1>%s</address1>"
                                   +"\n  <address2>%s</address2>"
                                   +"\n</body>"
                                   +"\n</html>";

        String formattedAddressBlock = String.format(addressBlock, "10 M.G. Road","Mumbai,India,400086");
        System.out.println(formattedAddressBlock);

        String addressTextBlock = """
                                    <html>
                                    <head></head>
                                    <body>
                                      <address1>%s</address1>
                                      <address2>%s</address2>
                                    </body>
                                    </html>""".formatted("10 M.G. Road","Mumbai,India,400086");

        System.out.println(addressTextBlock);

        String text =  "Hello %s World".formatted("Java");
        System.out.println(text);
    }
}
