package telephony;

import telephony.interfaces.Browsable;
import telephony.interfaces.Callable;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder call = new StringBuilder();
        for (String number : this.numbers) {
            if (isNumber(number)) {
                call.append("Calling... ").append(number);
                call.append(System.lineSeparator());
            } else {
                call.append("Invalid number!");
                call.append(System.lineSeparator());
            }
        }

        return call.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder browse = new StringBuilder();
        for (String url : this.urls) {
            if (isNumeric(url)) {
                browse.append("Browsing: ").append(url).append("!");
                browse.append(System.lineSeparator());
            } else {
               browse.append("Invalid URL!");
               browse.append(System.lineSeparator());
            }
        }

        return browse.toString().trim();
    }

    public boolean isNumeric(String url) {
        boolean hasNumber = true;
        String pattern = "[0-9]+";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(url);
        if (matcher.find()) {
            hasNumber = false;
        }

        return hasNumber;
    }

    public boolean isNumber(String call) {
        boolean hasNumber = true;
        String pattern = "[^0-9]+[a-zA-Z]*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(call);
        if (matcher.find()) {
            hasNumber = false;
        }

        return hasNumber;
    }
}
