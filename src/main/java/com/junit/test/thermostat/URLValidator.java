package com.junit.test.thermostat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {
    public static void main(String[] args) {
        // Regular expression for matching URLs
        String regex = "(?i)\\b((?:https?|ftp)://[-\\w]+(?:\\.\\w[-\\w]*)+|(?i)www\\.[-\\w]+(?:\\.\\w[-\\w]*)+)(?::\\d+)?(?:/[^\\s]*)?\\b";

        // Array of URLs to validate
        String[] urls = {
                "https://www.example.com",
                "http://subdomain.example.com/page",
                "ftp://ftp.example.com/file",
                "www.example.com",
                "http://123.45.67.89",
                "https://www.example.com:8080/path",
                "https://en.wikipedia.org/wiki/Main_Page",
                "http://www.google.com/search?q=java",
                "https://www.amazon.com/dp/B08T7L8H86",
                "http://www.nytimes.com/2024/04/20/technology/ai-language-models-benefits-risks.html",
                "https://github.com/openai/gpt-3",
                "https://www.reddit.com/r/artificial/",
                "https://www.coursera.org/browse/data-science",
                "https://www.linkedin.com/in/johndoe",
                "http://www.example.co.uk",
                "https://www.udemy.com/course/machine-learning-a-z",
                "https://www.apple.com/iphone/",
                "https://www.microsoft.com/en-us/",
                "https://www.netflix.com/browse",
                "http://www.example123.com/page"
        };

        // Validate each URL against the regular expression and save results to a file
        Pattern pattern = Pattern.compile(regex);
        try {
            FileWriter writer = new FileWriter("url_validation_results.txt");
            for (String url : urls) {
                Matcher matcher = pattern.matcher(url);
                if (matcher.matches()) {
                    writer.write(url + " is a valid URL\n");
                } else {
                    writer.write(url + " is not a valid URL\n");
                }
            }
            writer.close();
            System.out.println("Validation results saved to url_validation_results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
