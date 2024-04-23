package com.junit.test.thermostat;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {

    private Pattern pattern;
    public URLValidator(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean isValidURL(String url) {
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    public void validateURLsAndSaveToFile(List<String> urls, String outputFileName) {
        try {
            FileWriter writer = new FileWriter(outputFileName);
            for (String url : urls) {
                if (isValidURL(url)) {
                    writer.write(url + " is a valid URL\n");
                } else {
                    writer.write(url + " is not a valid URL\n");
                }
            }
            writer.close();
            System.out.println("Validation results saved to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // The regex pattern to match URLs
        String regex = "^(?:(?:http|https|ftp)://)?((?:www|ftp)\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$";

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

        // Create URLValidator instance
        URLValidator urlValidator = new URLValidator(regex);

        // Test invalid URL
        String invalidURL = "http://-invalid-domain-.com/page";
        if (urlValidator.isValidURL(invalidURL)) {
            System.out.println(invalidURL + " is a valid URL");
        } else {
            System.out.println(invalidURL + " is not a valid URL");
        }

        // Validate URLs and save results to file
        urlValidator.validateURLsAndSaveToFile(List.of(urls), "url_validation_results.txt");

   }
}
