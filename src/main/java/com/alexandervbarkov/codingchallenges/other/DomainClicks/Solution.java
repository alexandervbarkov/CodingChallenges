package com.alexandervbarkov.codingchallenges.other.DomainClicks;

// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

// counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "20,overflow.com",
//      "5,com.com",
//      "2,en.wikipedia.org",
//      "1,m.wikipedia.org",
//      "1,mobile.sports",
//      "1,google.co.uk"]

// Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

// Sample output (in any order/format):

// calculateClicksByDomain(counts) =>
// com:                     1345
// google.com:              900
// stackoverflow.com:       10
// overflow.com:            20
// yahoo.com:               410
// mail.yahoo.com:          60
// mobile.sports.yahoo.com: 10
// sports.yahoo.com:        50
// com.com:                 5
// org:                     3
// wikipedia.org:           3
// en.wikipedia.org:        2
// m.wikipedia.org:         1
// mobile.sports:           1
// sports:                  1
// uk:                      1
// co.uk:                   1
// google.co.uk:            1

// n: number of domains in the input
// (individual domains and subdomains have a constant upper length)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] argv) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Map<String, Integer> actual = calculateClicksByDomain(counts);
        System.out.println(actual);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("com", 1345);
        expected.put("google.com", 900);
        expected.put("stackoverflow.com", 10);
        expected.put("overflow.com", 20);
        expected.put("yahoo.com", 410);
        expected.put("mail.yahoo.com", 60);
        expected.put("mobile.sports.yahoo.com", 10);
        expected.put("sports.yahoo.com", 50);
        expected.put("com.com", 5);
        expected.put("org", 3);
        expected.put("wikipedia.org", 3);
        expected.put("en.wikipedia.org", 2);
        expected.put("m.wikipedia.org", 1);
        expected.put("mobile.sports", 1);
        expected.put("sports", 1);
        expected.put("uk", 1);
        expected.put("co.uk", 1);
        expected.put("google.co.uk", 1);
        System.out.println(expected.equals(actual));
    }

    private static Map<String, Integer> calculateClicksByDomain(String[] counts) {
        HashMap<String, Integer> domainCounts = new HashMap<>();
        for (String s : counts) {
            String[] countUrl = s.split(",");
            int count = Integer.valueOf(countUrl[0]);
            String url = countUrl[1];
            while (!url.isEmpty()) {
                if (domainCounts.containsKey(url)) {
                    domainCounts.replace(url, domainCounts.get(url) + count);
                } else {
                    domainCounts.put(url, count);
                }
                int index = url.indexOf('.');
                if (index == -1) {
                    break;
                }
                url = url.substring(index + 1);
            }
        }
        return domainCounts;
    }
}